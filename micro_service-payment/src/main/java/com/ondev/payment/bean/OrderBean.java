package com.ondev.payment.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderBean {
	Long id;
	Long productId;
	Long number;
	boolean isOrderPaid;
	Long userId;
	LocalDateTime orderDate;
	int quantity;
	double totalPrice;
}
