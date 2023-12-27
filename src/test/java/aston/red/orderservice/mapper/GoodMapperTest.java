package aston.red.orderservice.mapper;

import aston.red.orderservice.dto.GoodDto;
import aston.red.orderservice.entity.OrderGoodsEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoodMapperTest {

    private final GoodMapper goodMapper = Mappers.getMapper(GoodMapper.class);

    @Test
    public void testToGoodDtoMapping() {
        OrderGoodsEntity entity = new OrderGoodsEntity();
        entity.setGoodName("Sample Good");

        GoodDto goodDto = goodMapper.toGoodDto(entity);

        assertEquals(entity.getGoodName(), goodDto.getName());
    }
}