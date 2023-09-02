package com.example.shopmanagement.repository;

import com.example.shopmanagement.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    OrderDetails getOrderDetailsByOrderId(Long orderDetailsId);

}
