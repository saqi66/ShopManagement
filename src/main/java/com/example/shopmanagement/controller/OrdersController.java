package com.example.shopmanagement.controller;

import com.example.shopmanagement.dto.OrdersDto;
import com.example.shopmanagement.dto.request.OrdersRequest;
import com.example.shopmanagement.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrdersController {

    final OrdersService ordersService;

    @GetMapping(value = "/ordersList")
    public List<OrdersDto> getOrdersList() {
        return ordersService.getAll();
    }

    @GetMapping(value = "/getOrdersById/{orderId}")
    public OrdersDto getOrdersById(@PathVariable(value = "orderId") Long orderId) {
        return ordersService.getOrdersByOrderId(orderId);
    }

    @PostMapping(value = "/saveOrders")
    public void saveOrders(@RequestBody OrdersRequest ordersRequest) {
        ordersService.saveOrders(ordersRequest);
    }

    @PostMapping(value = "/updateOrders")
    public void updateOrders(@RequestBody OrdersRequest ordersRequest) {
        ordersService.updateOrders(ordersRequest);
    }

    @DeleteMapping(value = "/deleteById/{orderId}")
    public void deleteById(@PathVariable(value = "orderId") Long orderId) {
        ordersService.deleteById(orderId);
    }
}
