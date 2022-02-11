package com.ondev.payment.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ondev.payment.bean.OrderBean;

@Component
public class OrderProxy {

	private RestTemplate restTemplate;

	@Autowired
	public OrderProxy(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	public OrderBean getOrder(Long orderId) {
		 ResponseEntity<OrderBean> responseEntity = restTemplate.getForEntity("http://localhost:8085/api/order/getOrderById/"+orderId,
				 OrderBean.class);
		return responseEntity.getBody();
	}


	public ResponseEntity<OrderBean> updateOrder(OrderBean orderBean) {
		return restTemplate.exchange("http://localhost:8085/api/order/validateOrder",
	                HttpMethod.PUT,new HttpEntity<>(orderBean),OrderBean.class);
 	}

}
