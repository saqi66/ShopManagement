package com.example.shopmanagement.controller;

import com.example.shopmanagement.dto.OrderDetailsDto;
import com.example.shopmanagement.dto.request.OrderDetailsRequest;
import com.example.shopmanagement.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orderdetails")
public class OrderDetailsController {

    final OrderDetailsService orderDetailsService;

    @GetMapping(value = "/orderDetailsList")
    public List<OrderDetailsDto> getOrderDetailsList() {
        return orderDetailsService.getAll();
    }

    @GetMapping(value = "/getOrderDetailsById/{orderDetailsId}")
    public OrderDetailsDto getOrderDetailsById(@PathVariable(value = "orderDetailsId") Long orderDetailsId) {
        return orderDetailsService.getOrderDetailsByOrderDetailsId(orderDetailsId);
    }

    @PostMapping(value = "/saveOrderDetails")
    public void saveOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest) {
        orderDetailsService.saveOrderDetails(orderDetailsRequest);
    }

    @PostMapping(value = "/updateOrderDetails")
    public void updateOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest) {
        orderDetailsService.updateOrderDetails(orderDetailsRequest);
    }

    @DeleteMapping(value = "/deleteById/{orderDetailsId}")
    public void deleteById(@PathVariable(value = "orderDetailsId") Long orderDetailsId) {
        orderDetailsService.deleteById(orderDetailsId);
    }
}
