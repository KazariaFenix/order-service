package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class OrderGoodsDto {

  private Long id;
  private String goodName;
  private Long goodId;
  private Integer quantity;
  private Long orderId;

}
