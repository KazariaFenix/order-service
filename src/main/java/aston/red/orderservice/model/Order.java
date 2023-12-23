package aston.red.orderservice.model;

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

import java.math.BigInteger;


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
    private BigInteger id;

    @Column(name = "user_address", nullable = false)
    private String userAddress;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "total")
    private BigInteger total;

    @Column(name = "shop_id", nullable = false)
    private BigInteger shopId;

    @Column(name = "user_id", nullable = false)
    private BigInteger userId;

    @Column(name = "delivery")
    private boolean delivery;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderGoods> orderGoods;
}