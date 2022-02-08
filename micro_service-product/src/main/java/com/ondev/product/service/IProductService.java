package com.ondev.product.service;

import java.util.List;

import com.ondev.product.entities.Product;

public interface IProductService {

	Product addProduct(Product product);

	Product getProduct(long productId);
	
	Product updateProduct(long productId);

	List<Product> getAllProduct();
}
