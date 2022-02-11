package com.ondev.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ondev.payment.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Payment findByOrderId(Long orderId);
    List<Payment> findByOrderIdIn(List<Long> orderIds);
}