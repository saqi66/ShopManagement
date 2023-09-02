package com.example.shopmanagement.repository;

import com.example.shopmanagement.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Orders getOrdersByOrderId(Long orderId);

}
