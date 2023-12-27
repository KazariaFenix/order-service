package aston.red.orderservice.feign;

import aston.red.orderservice.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "deliveryOrder", url = "http://localhost:8097/api/v1/deliveries")
public interface DeliveryFeign {

    @PatchMapping("/order")
    void postOrderDto(@RequestBody OrderDto dto);
}
