package com.example.shopmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailsDto {

    private BigDecimal unitPrice;
    private Integer quantity;
    private Double discount;

}
