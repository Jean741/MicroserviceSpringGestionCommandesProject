package com.ondev.order.proxy;

import com.ondev.order.bean.ProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductProxy {

    @Autowired
    RestTemplate restTemplate;

    public List<ProductBean> getProductsByIds(List<Long> ids){
        ResponseEntity<ProductBean[]> responseEntity = restTemplate.exchange("http://localhost:8084/api/product/getAllProductsByIds",
                HttpMethod.POST,new HttpEntity<>(ids),ProductBean[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
