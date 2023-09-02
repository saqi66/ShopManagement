package com.example.shopmanagement.service;

import com.example.shopmanagement.dto.ShippersDto;
import com.example.shopmanagement.dto.SuppliersDto;
import com.example.shopmanagement.dto.request.ShippersRequest;
import com.example.shopmanagement.dto.request.SuppliersRequest;

import java.util.List;

public interface SuppliersService {


    SuppliersDto getSuppliersBySupplierId(Long supplierId);

    void saveSuppliers(SuppliersRequest suppliersRequest);

    void updateSuppliers (SuppliersRequest suppliersRequest);

    List<SuppliersDto> getAll();

    void deleteById(Long supplierId);
}
