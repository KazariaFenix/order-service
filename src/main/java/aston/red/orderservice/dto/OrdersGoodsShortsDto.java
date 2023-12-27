package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrdersGoodsShortsDto {
  private long goodId;
  private long shopId;
  private int quantity;

}
