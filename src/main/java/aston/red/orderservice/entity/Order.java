package aston.red.orderservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "user_address", nullable = false)
  private String userAddress;

  @Column(name = "paid")
  private boolean paid;

  @Column(name = "total")
  private Long total;

  @Column(name = "shop_id", nullable = false)
  private Long shopId;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "delivery")
  private boolean delivery;

  @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
  private List<OrderGoodsEntity> orderGoods;
}
