package com.ondev.order.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "T_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    //@Column(unique = true)
    private Long number;
    private boolean isOrderPaid;
    private Long userId;
    private LocalDateTime orderDate;
    private int quantity;
    private double totalPrice;


}
