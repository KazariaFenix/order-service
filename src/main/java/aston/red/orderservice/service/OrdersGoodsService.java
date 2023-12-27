package aston.red.orderservice.service;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.entity.Order;

import aston.red.orderservice.dto.OrdersGoodsShortsDto;
import java.util.List;

public interface OrdersGoodsService {

    void saveGoods(Order order, OrderGoodsDto orderGoodsDto);
  void getOrdersGoodsShortsDtoByOrderId(Long orderId);

}
