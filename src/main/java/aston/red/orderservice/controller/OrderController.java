package aston.red.orderservice.controller;

import aston.red.orderservice.service.OrdersGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrdersGoodsService service;

    @GetMapping
    public void payedOrder(Long orderId) {

    }
}
