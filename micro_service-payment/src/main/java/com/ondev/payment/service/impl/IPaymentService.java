package com.ondev.payment.service.impl;

import java.util.List;

import com.ondev.payment.entities.Payment;

public interface IPaymentService {

	Payment addPayment(Payment payment);

	Payment getPayment(long paymentId);
	
	Payment updatePayment(long paymentId);

	List<Payment> getAllPayment();

	List<Payment> getAllPaymentsByIds(List<Long> idsPayment);

	Payment payCommand(Long orderId);
}
