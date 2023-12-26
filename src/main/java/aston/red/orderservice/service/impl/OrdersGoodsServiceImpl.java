package aston.red.orderservice.service.impl;


import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.ProductDtoWithQuantity;
import aston.red.orderservice.entity.Order;
import aston.red.orderservice.entity.OrderGoodsEntity;
import aston.red.orderservice.repository.OrdersGoodsRepository;
import aston.red.orderservice.service.OrdersGoodsService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class OrdersGoodsServiceImpl implements OrdersGoodsService {
    OrdersGoodsRepository repository;

    public OrdersGoodsServiceImpl(OrdersGoodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveGoods(Order order, OrderGoodsDto orderGoodsDto) {

        for (ProductDtoWithQuantity product : orderGoodsDto.getProducts()) {
            OrderGoodsEntity orderGoods = new OrderGoodsEntity();
            orderGoods.setGoodId(product.getId());
            orderGoods.setGoodName(product.getName());
            orderGoods.setQuantity(product.getQuantity());
            orderGoods.setOrder(order);

            repository.save(orderGoods);
        }
    }
}
