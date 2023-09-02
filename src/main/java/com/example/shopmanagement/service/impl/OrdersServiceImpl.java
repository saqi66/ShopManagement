package com.example.shopmanagement.service.impl;

import com.example.shopmanagement.dto.OrdersDto;
import com.example.shopmanagement.dto.request.OrdersRequest;
import com.example.shopmanagement.model.Orders;
import com.example.shopmanagement.repository.OrdersRepository;
import com.example.shopmanagement.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public OrdersDto getOrdersByOrderId(Long orderId) {
        Orders orders = ordersRepository.getOrdersByOrderId(orderId);
        return OrdersDto.builder()
                .orderDate(orders.getOrderDate())
                .freight(orders.getFreight())
                .requiredDate(orders.getRequiredDate())
                .shipAddress(orders.getShipAddress())
                .shipCity(orders.getShipCity())
                .shipName(orders.getShipName())
                .shippedDate(orders.getShippedDate())
                .shipPostalCode(orders.getShipPostalCode())
                .shippVia(orders.getShippVia())
                .shipRegion(orders.getShipRegion())
                .build();
    }

    @Override
    public void saveOrders(OrdersRequest ordersRequest) {
        Orders orders = Orders.builder()
                .orderDate(ordersRequest.getOrderDate())
                .freight(ordersRequest.getFreight())
                .requiredDate(ordersRequest.getRequiredDate())
                .shipAddress(ordersRequest.getShipAddress())
                .shipCity(ordersRequest.getShipCity())
                .shipName(ordersRequest.getShipName())
                .shippedDate(ordersRequest.getShippedDate())
                .shipPostalCode(ordersRequest.getShipPostalCode())
                .shippVia(ordersRequest.getShippVia())
                .shipRegion(ordersRequest.getShipRegion())
                .build();
        ordersRepository.save(orders);
    }

    @Override
    public void updateOrders(OrdersRequest ordersRequest) {
        Orders orders = Orders.builder()
                .orderId(ordersRequest.getOrderId())
                .orderDate(ordersRequest.getOrderDate())
                .freight(ordersRequest.getFreight())
                .requiredDate(ordersRequest.getRequiredDate())
                .shipAddress(ordersRequest.getShipAddress())
                .shipCity(ordersRequest.getShipCity())
                .shipName(ordersRequest.getShipName())
                .shippedDate(ordersRequest.getShippedDate())
                .shipPostalCode(ordersRequest.getShipPostalCode())
                .shippVia(ordersRequest.getShippVia())
                .shipRegion(ordersRequest.getShipRegion())
                .build();
        ordersRepository.save(orders);
    }

    @Override
    public List<OrdersDto> getAll() {
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();

        for (Orders orders : ordersList) {
            OrdersDto ordersDto = OrdersDto.builder()
                    .orderDate(orders.getOrderDate())
                    .freight(orders.getFreight())
                    .requiredDate(orders.getRequiredDate())
                    .shipAddress(orders.getShipAddress())
                    .shipCity(orders.getShipCity())
                    .shipName(orders.getShipName())
                    .shippedDate(orders.getShippedDate())
                    .shipPostalCode(orders.getShipPostalCode())
                    .shippVia(orders.getShippVia())
                    .shipRegion(orders.getShipRegion())
                    .build();

            ordersDtos.add(ordersDto);
        }

        return ordersDtos;
    }

    @Override
    public void deleteById(Long orderId) {
        Orders orders = ordersRepository.getOrdersByOrderId(orderId);
        if (orders == null) {
            throw new RuntimeException("ID tapilmadi!");
        } else {
            ordersRepository.deleteById(orderId);
        }
    }
}
