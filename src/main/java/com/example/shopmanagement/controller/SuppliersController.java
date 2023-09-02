package com.example.shopmanagement.controller;

import com.example.shopmanagement.dto.SuppliersDto;
import com.example.shopmanagement.dto.request.SuppliersRequest;
import com.example.shopmanagement.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/suppliers")
public class SuppliersController {

    final SuppliersService suppliersService;

    @GetMapping(value = "/suppliersList")
    public List<SuppliersDto> getSuppliersList() {
        return suppliersService.getAll();
    }

    @GetMapping(value = "/getSuppliersById/{supplierId}")
    public SuppliersDto getSuppliersById(@PathVariable(value = "supplierId") Long supplierId) {
        return suppliersService.getSuppliersBySupplierId(supplierId);
    }

    @PostMapping(value = "/saveSuppliers")
    public void saveSuppliers(@RequestBody SuppliersRequest suppliersRequest) {
        suppliersService.saveSuppliers(suppliersRequest);
    }

    @PostMapping(value = "/updateSuppliers")
    public void updateSuppliers(@RequestBody SuppliersRequest suppliersRequest) {
        suppliersService.updateSuppliers(suppliersRequest);
    }

    @DeleteMapping(value = "/deleteById/{supplierId}")
    public void deleteById(@PathVariable(value = "supplierId") Long supplierId) {
        suppliersService.deleteById(supplierId);
    }
}
