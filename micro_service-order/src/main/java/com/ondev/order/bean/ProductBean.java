package com.ondev.order.bean;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductBean {

    Long id;
    String name;
    long quantity;
    double price;
}
