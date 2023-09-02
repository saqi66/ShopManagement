package com.example.shopmanagement.service;

import com.example.shopmanagement.dto.OrderDetailsDto;
import com.example.shopmanagement.dto.request.OrderDetailsRequest;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsDto getOrderDetailsByOrderDetailsId(Long orderDetailsId);

    void saveOrderDetails(OrderDetailsRequest orderDetailsRequest);

    void updateOrderDetails (OrderDetailsRequest orderDetailsRequest);

    List<OrderDetailsDto> getAll();

    void deleteById(Long orderDetailsId);


}
