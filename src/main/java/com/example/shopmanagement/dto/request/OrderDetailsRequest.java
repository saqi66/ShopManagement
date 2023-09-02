package com.example.shopmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsRequest {

    private Long orderDetailsId;
    private Long orderId;
    private Long productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Double discount;


}
