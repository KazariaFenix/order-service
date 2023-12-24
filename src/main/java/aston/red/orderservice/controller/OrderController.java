package aston.red.orderservice.controller;

import aston.red.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/{orderId}")
    public void payedOrder(@PathVariable("orderId") Long orderId) {
        service.addDeliveryOrder(orderId);
    }
}
