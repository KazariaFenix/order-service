package aston.red.orderservice.repository;

import aston.red.orderservice.entity.OrderGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersGoodsRepository extends JpaRepository<OrderGoodsEntity, Long> {
}
