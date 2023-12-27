package aston.red.orderservice.repository;

import aston.red.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Long findShopIdById(long orderId);

    @Query(value = "UPDATE orders SET paid = true WHERE id = ?", nativeQuery = true)
    void setPaid(long orderId);

    @Query(value = "UPDATE orders SET delivery = true WHERE id = ?", nativeQuery = true)
    void setDelivery(long orderId);
}
