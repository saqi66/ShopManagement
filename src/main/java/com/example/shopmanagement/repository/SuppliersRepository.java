package com.example.shopmanagement.repository;

import com.example.shopmanagement.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {

    Suppliers getSuppliersBySupplierId(Long supplierId);

}
