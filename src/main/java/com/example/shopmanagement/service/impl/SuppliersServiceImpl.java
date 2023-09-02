package com.example.shopmanagement.service.impl;

import com.example.shopmanagement.dto.SuppliersDto;
import com.example.shopmanagement.dto.request.SuppliersRequest;
import com.example.shopmanagement.model.Suppliers;
import com.example.shopmanagement.repository.SuppliersRepository;
import com.example.shopmanagement.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppliersServiceImpl implements SuppliersService {

    private final SuppliersRepository suppliersRepository;

    @Override
    public SuppliersDto getSuppliersBySupplierId(Long supplierId) {
        Suppliers suppliers = suppliersRepository.getSuppliersBySupplierId(supplierId);
        return SuppliersDto.builder()
                .companyName(suppliers.getCompanyName())
                .contactName(suppliers.getContactName())
                .address(suppliers.getAddress())
                .fax(suppliers.getFax())
                .country(suppliers.getCountry())
                .region(suppliers.getRegion())
                .phone(suppliers.getPhone())
                .postalCode(suppliers.getPostalCode())
                .city(suppliers.getCity())
                .build();
    }

    @Override
    public void saveSuppliers(SuppliersRequest suppliersRequest) {
        Suppliers suppliers = Suppliers.builder()
                .companyName(suppliersRequest.getCompanyName())
                .contactName(suppliersRequest.getContactName())
                .address(suppliersRequest.getAddress())
                .fax(suppliersRequest.getFax())
                .country(suppliersRequest.getCountry())
                .region(suppliersRequest.getRegion())
                .phone(suppliersRequest.getPhone())
                .postalCode(suppliersRequest.getPostalCode())
                .city(suppliersRequest.getCity())
                .build();
        suppliersRepository.save(suppliers);
    }

    @Override
    public void updateSuppliers(SuppliersRequest suppliersRequest) {
        Suppliers suppliers = Suppliers.builder()
                .supplierId(suppliersRequest.getSupplierId())
                .companyName(suppliersRequest.getCompanyName())
                .contactName(suppliersRequest.getContactName())
                .address(suppliersRequest.getAddress())
                .fax(suppliersRequest.getFax())
                .country(suppliersRequest.getCountry())
                .region(suppliersRequest.getRegion())
                .phone(suppliersRequest.getPhone())
                .postalCode(suppliersRequest.getPostalCode())
                .city(suppliersRequest.getCity())
                .build();

        suppliersRepository.save(suppliers);
    }

    @Override
    public List<SuppliersDto> getAll() {
        List<Suppliers> suppliersList = suppliersRepository.findAll();
        List<SuppliersDto> suppliersDtos = new ArrayList<>();

        for (Suppliers suppliers : suppliersList) {
            SuppliersDto suppliersDto = SuppliersDto.builder()
                    .companyName(suppliers.getCompanyName())
                    .contactName(suppliers.getContactName())
                    .address(suppliers.getAddress())
                    .fax(suppliers.getFax())
                    .country(suppliers.getCountry())
                    .region(suppliers.getRegion())
                    .phone(suppliers.getPhone())
                    .postalCode(suppliers.getPostalCode())
                    .city(suppliers.getCity())
                    .build();


            suppliersDtos.add(suppliersDto);
        }

        return suppliersDtos;
    }

    @Override
    public void deleteById(Long supplierId) {
        Suppliers suppliers = suppliersRepository.getSuppliersBySupplierId(supplierId);
        if (suppliers == null) {
            throw new RuntimeException("ID tapilmadi!");
        } else {
            suppliersRepository.deleteById(supplierId);
        }
    }
}
