package com.ondev.order.proxy;

import com.ondev.order.bean.ProductBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="microservice-product",url = "loclahost:8084")
public interface ProductProxy {

    @PostMapping("/api/product/getAllProductsByIds")
     List<ProductBean> getProductsByIds(@RequestBody List<Long> ids);
}
