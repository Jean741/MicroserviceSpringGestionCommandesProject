package com.ondev.payment.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ondev.payment.bean.OrderBean;
import com.ondev.payment.dao.PaymentRepository;
import com.ondev.payment.entities.Payment;
import com.ondev.payment.proxy.OrderProxy;
import com.ondev.payment.service.impl.IPaymentService;

@Service
public class PaymentService implements IPaymentService {

	private PaymentRepository paymentRepository;
	private OrderProxy orderProxy;
	
	@Autowired
	public PaymentService(PaymentRepository paymentRepository,OrderProxy orderProxy) {
		this.paymentRepository = paymentRepository;
		this.orderProxy = orderProxy;
	}

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.saveAndFlush(payment);
	}

	@Override
	public Payment getPayment(long paymentId) {
		return paymentRepository.findById(paymentId).get();
	}

	@Override
	public Payment updatePayment(long paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getAllPaymentsByIds(List<Long> idsPayment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment payCommand(Long orderId) {
		OrderBean orderBean = orderProxy.getOrder(orderId);
		if (orderBean.isOrderPaid()) {
			throw new RuntimeException("This order has alreaday a payment.");
		}
		Payment payment = paymentRepository.save(Payment.builder()
				.orderId(orderBean.getId())
				.amount(orderBean.getTotalPrice())
				.datePayement(LocalDateTime.now())
				.build());
		orderBean.setOrderPaid(true);
		ResponseEntity<OrderBean> orderBeanPayedResponseEntity = orderProxy.updateOrder(orderBean);
		if (orderBeanPayedResponseEntity.getStatusCode()!=HttpStatus.OK) {
			payment.setValide(false);
			paymentRepository.saveAndFlush(payment);
		}
		return payment;
	}
	
}
