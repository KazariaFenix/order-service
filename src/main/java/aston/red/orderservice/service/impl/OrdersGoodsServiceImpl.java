package aston.red.orderservice.service.impl;


import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.ProductDtoWithQuantity;
import aston.red.orderservice.entity.Order;
import aston.red.orderservice.entity.OrderGoodsEntity;
import aston.red.orderservice.repository.OrdersGoodsRepository;
import aston.red.orderservice.dto.OrdersGoodsShortsDto;
import aston.red.orderservice.entity.OrderGoodsEntity;
import aston.red.orderservice.feign.GoodsFeign;
import aston.red.orderservice.mapper.GoodMapper;
import aston.red.orderservice.repository.OrderRepository;
import aston.red.orderservice.repository.OrdersGoodsRepository;
import aston.red.orderservice.service.OrdersGoodsService;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class OrdersGoodsServiceImpl implements OrdersGoodsService {
    OrdersGoodsRepository repository;

  private final OrderRepository orderRepository;

  private final GoodMapper goodMapper;

  private final GoodsFeign goodsFeign;

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


  public void getOrdersGoodsShortsDtoByOrderId(Long orderId) {
    List<OrderGoodsEntity> orderGoodsEntityList = repository.findOrderGoodsEntitiesByOrderId(
        orderId);
    Long shopId = orderRepository.findShopIdById(orderId);
    List<OrdersGoodsShortsDto> goodsShortsDtoList = orderGoodsEntityList.stream()
        .map(goodMapper::toOrdersGoodsShortsDto).peek(entitydto -> entitydto.setShopId(shopId))
        .toList();

    goodsFeign.getOrdersGoodsShorts(shopId, goodsShortsDtoList);


  }

}
