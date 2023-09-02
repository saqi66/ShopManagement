package com.example.shopmanagement.repository;

import com.example.shopmanagement.model.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShippersRepository extends JpaRepository<Shippers, Long> {

    Shippers getShippersByShipperId(Long shipperId);

}
