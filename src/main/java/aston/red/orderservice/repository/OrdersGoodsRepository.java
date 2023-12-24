package aston.red.orderservice.repository;

import aston.red.orderservice.entity.OrderGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersGoodsRepository extends JpaRepository<OrderGoodsEntity, Long> {
}
