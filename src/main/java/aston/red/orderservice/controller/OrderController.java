package aston.red.orderservice.controller;

import aston.red.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/{orderId}")
    public void payedOrder(@RequestParam Long orderId) {
        service.postDeliveryOrder(orderId);
    }
}
