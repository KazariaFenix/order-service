package aston.red.orderservice.controller;

import aston.red.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService service;

    @GetMapping
    public void payedOrder(Long orderId) {
        service.postDeliveryOrder(orderId);
    }
}
