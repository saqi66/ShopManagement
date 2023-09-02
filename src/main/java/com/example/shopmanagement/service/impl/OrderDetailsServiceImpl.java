package com.example.shopmanagement.service.impl;

import com.example.shopmanagement.dto.OrderDetailsDto;
import com.example.shopmanagement.dto.request.OrderDetailsRequest;
import com.example.shopmanagement.model.OrderDetails;
import com.example.shopmanagement.repository.OrderDetailsRepository;
import com.example.shopmanagement.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetailsDto getOrderDetailsByOrderDetailsId(Long orderDetailsId) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsByOrderId(orderDetailsId);
        return OrderDetailsDto.builder()
                .discount(orderDetails.getDiscount())
                .quantity(orderDetails.getQuantity())
                .unitPrice(orderDetails.getUnitPrice())
                .build();
    }

    @Override
    public void saveOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .discount(orderDetailsRequest.getDiscount())
                .quantity(orderDetailsRequest.getQuantity())
                .unitPrice(orderDetailsRequest.getUnitPrice())
                .build();
        orderDetailsRepository.save(orderDetails);
    }


    @Override
    public void updateOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .orderDetailsId(orderDetailsRequest.getOrderDetailsId())
                .discount(orderDetailsRequest.getDiscount())
                .quantity(orderDetailsRequest.getQuantity())
                .unitPrice(orderDetailsRequest.getUnitPrice())
                .build();
        orderDetailsRepository.save(orderDetails);
    }

    @Override
    public List<OrderDetailsDto> getAll() {
        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<OrderDetailsDto> orderDetailsDtos = new ArrayList<>();

        for (OrderDetails orderDetails1 : orderDetails) {
            OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                    .discount(orderDetails1.getDiscount())
                    .quantity(orderDetails1.getQuantity())
                    .unitPrice(orderDetails1.getUnitPrice())
                    .build();

            orderDetailsDtos.add(orderDetailsDto);
        }

        return orderDetailsDtos;
    }

    @Override
    public void deleteById(Long orderDetailsId) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsByOrderId(orderDetailsId);
        if (orderDetails == null) {
            throw new RuntimeException("ID tapilmadi.!");
        } else {
            orderDetailsRepository.deleteById(orderDetailsId);
        }
    }
}