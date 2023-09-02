package com.example.shopmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersRequest {

    private Long orderId;

    private Long customerId;

    private Long employeeId;

    private Date orderDate;

    private Date requiredDate;

    private Date shippedDate;

    private String shippVia;

    private String freight;

    private String shipName;

    private String shipAddress;

    private String shipCity;

    private String shipRegion;

    private String shipPostalCode;

    private String shipCountry;

}
