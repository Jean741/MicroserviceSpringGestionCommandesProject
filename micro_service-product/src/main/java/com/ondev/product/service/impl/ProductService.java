package com.ondev.product.service.impl;

import java.util.List;
import java.util.Optional;

import com.ondev.product.config.ApplicationPropertiesConfig;
import com.ondev.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondev.product.dao.ProductRepository;
import com.ondev.product.entities.Product;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;
    private ApplicationPropertiesConfig propertiesConfig;

    @Autowired
    public ProductService(ProductRepository productRepository, ApplicationPropertiesConfig propertiesConfig) {
    	this.productRepository = productRepository;
        this.propertiesConfig = propertiesConfig;
    }

	@Override
	public Product addProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	@Override
	public Product getProduct(long productId) {
		Optional<Product> productOpt = productRepository.findById(productId);
		 return productOpt.orElse(null);
	}

	@Override
	public Product updateProduct(long productId) {
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll().subList(0,propertiesConfig.getProductSize());
	}

	@Override
	public List<Product> getAllProductsByIds(List<Long> idsProduct) {
		return productRepository.findAllByIdIn(idsProduct);
	}

}