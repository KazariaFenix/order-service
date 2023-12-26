package aston.red.orderservice.controller;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.OrderPreparedToPayDto;
import aston.red.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{orderId}")
    public void payedOrder(@PathVariable Long orderId) {
        orderService.postDeliveryOrder(orderId);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public OrderPreparedToPayDto processOrder(@RequestBody OrderGoodsDto orderGoodsDto) {
        return orderService.processOrder(orderGoodsDto);
    }
}
