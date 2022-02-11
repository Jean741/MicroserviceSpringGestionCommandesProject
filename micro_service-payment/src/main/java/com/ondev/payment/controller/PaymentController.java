package com.ondev.payment.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ondev.payment.entities.Payment;
import com.ondev.payment.service.impl.IPaymentService;

 
@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {

    private IPaymentService paymentService;

    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
    @PostMapping("/paycommand")
    public Payment payCommand(@RequestParam Long orderId){
    	return paymentService.payCommand(orderId);
    }


    @PostMapping("/getAllpaymentsByIds")
    public List<Payment> getAllPaymentsByIds(@RequestBody List<Long> idsPayment) {
        return paymentService.getAllPaymentsByIds(idsPayment);
    }

}
