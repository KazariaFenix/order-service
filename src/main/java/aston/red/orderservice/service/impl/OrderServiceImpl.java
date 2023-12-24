package aston.red.orderservice.service.impl;

import aston.red.orderservice.dto.OrderDto;
import aston.red.orderservice.entity.Order;
import aston.red.orderservice.exception.OrderNotFoundException;
import aston.red.orderservice.feign.DeliveryFeign;
import aston.red.orderservice.feign.StoreFeign;
import aston.red.orderservice.mapper.OrderMapper;
import aston.red.orderservice.repository.OrderRepository;
import aston.red.orderservice.service.OrderService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final DeliveryFeign deliveryFeign;
    private final StoreFeign storeFeign;
    private final OrderMapper orderMapper;

    @Override
    public void addDeliveryOrder(long orderId) {
        Order order = repository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(String.valueOf(orderId)));
        OrderDto orderDto = orderMapper.toOrderDto(order);

        orderDto.setShop(storeFeign.getById(order.getShopId()));
        deliveryFeign.getOrderDto(orderDto);
    }
}
