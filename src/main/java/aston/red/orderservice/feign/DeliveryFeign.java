package aston.red.orderservice.feign;

import aston.red.orderservice.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "deliveryOrder", url = "http://localhost:8097/api/v1/deliveries")
public interface DeliveryFeign {

    @PostMapping("/order")
    void getOrderDto(@RequestBody OrderDto dto);
}
