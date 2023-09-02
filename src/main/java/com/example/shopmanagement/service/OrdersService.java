package com.example.shopmanagement.service;

import com.example.shopmanagement.dto.CategoriesDto;
import com.example.shopmanagement.dto.OrdersDto;
import com.example.shopmanagement.dto.request.CategoriesRequest;
import com.example.shopmanagement.dto.request.OrdersRequest;

import java.util.List;

public interface OrdersService {

    OrdersDto getOrdersByOrderId(Long orderId);

    void saveOrders(OrdersRequest ordersRequest);

    void updateOrders (OrdersRequest ordersRequest);

    List<OrdersDto> getAll();

    void deleteById(Long orderId);

}
