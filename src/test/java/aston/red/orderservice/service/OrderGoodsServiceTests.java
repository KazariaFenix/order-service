package aston.red.orderservice.service;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.ProductDtoWithQuantity;
import aston.red.orderservice.entity.Order;
import aston.red.orderservice.repository.OrdersGoodsRepository;
import aston.red.orderservice.service.impl.OrdersGoodsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderGoodsServiceTests {
    @InjectMocks
    private OrdersGoodsServiceImpl ordersGoodsService;
    @Mock
    private OrdersGoodsRepository repository;

    @Test
    public void testSaveGoods_Success() {
        long orderId = 1L;
        long shopId = 1L;

        Order order = new Order();
        order.setId(orderId);
        order.setShopId(shopId);

        OrderGoodsDto orderGoodsDto = new OrderGoodsDto(shopId, orderId, new ArrayList<>(), "Address");

        ProductDtoWithQuantity product1 = ProductDtoWithQuantity.builder().build();
        ProductDtoWithQuantity product2 = ProductDtoWithQuantity.builder().build();
        orderGoodsDto.setProducts(List.of(product1, product2));

        ordersGoodsService.saveGoods(order, orderGoodsDto);

        verify(repository, times(2)).save(any());
    }
}
