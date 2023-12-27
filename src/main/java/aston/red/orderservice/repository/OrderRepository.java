package aston.red.orderservice.repository;

import aston.red.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Long findShopIdById(long orderId);
}
