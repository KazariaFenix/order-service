package aston.red.orderservice.repository;

import aston.red.orderservice.entity.OrderGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersGoodsRepository extends JpaRepository<OrderGoodsEntity, Long> {

    List<OrderGoodsEntity> findByOrder
}
