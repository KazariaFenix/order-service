/*package aston.red.orderservice.mapper;

import aston.red.orderservice.dto.OrderDto;
import aston.red.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = GoodMapper.class)
public interface OrderMapper {

    @Mapping(target = "goods", source = "order.orderGoods")
    @Mapping(target = "tgChatIdClient", source = "order.userId")
    @Mapping(target = "addressClient", source = "order.userAddress")
    @Mapping(target = "goods", source = "order.orderGoods")
    OrderDto toOrderDto(Order order);
}

 */
