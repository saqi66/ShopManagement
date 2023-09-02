package com.example.shopmanagement.service.impl;

import com.example.shopmanagement.dto.ProductsDto;
import com.example.shopmanagement.dto.request.ProductsRequest;
import com.example.shopmanagement.model.Products;
import com.example.shopmanagement.repository.ProductsRepository;
import com.example.shopmanagement.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    public ProductsDto getProductsByProductId(Long productId) {
        Products products = productsRepository.getProductsByProductId(productId);
        return ProductsDto.builder()
                .productName(products.getProductName())
                .quantityPerUnit(products.getQuantityPerUnit())
                .unitPrice(products.getUnitPrice())
                .unitsInStock(products.getUnitsInStock())
                .unitsOnOrder(products.getUnitsOnOrder())
                .build();
    }

    @Override
    public void saveProducts(ProductsRequest productsRequest) {
        Products products = Products.builder()
                .productName(productsRequest.getProductName())
                .quantityPerUnit(productsRequest.getQuantityPerUnit())
                .unitPrice(productsRequest.getUnitPrice())
                .unitsInStock(productsRequest.getUnitsInStock())
                .unitsOnOrder(productsRequest.getUnitsOnOrder())
                .build();

        productsRepository.save(products);
    }

    @Override
    public void updateProducts(ProductsRequest productsRequest) {
        Products products = Products.builder()
                .productId(productsRequest.getProductId())
                .productName(productsRequest.getProductName())
                .quantityPerUnit(productsRequest.getQuantityPerUnit())
                .unitPrice(productsRequest.getUnitPrice())
                .unitsInStock(productsRequest.getUnitsInStock())
                .unitsOnOrder(productsRequest.getUnitsOnOrder())
                .build();

        productsRepository.save(products);
    }

    @Override
    public List<ProductsDto> getAll() {
        List<Products> productsList = productsRepository.findAll();
        List<ProductsDto> productsDtos = new ArrayList<>();

        for (Products products : productsList) {
            ProductsDto productsDto = ProductsDto.builder()
                    .productName(products.getProductName())
                    .quantityPerUnit(products.getQuantityPerUnit())
                    .unitPrice(products.getUnitPrice())
                    .unitsInStock(products.getUnitsInStock())
                    .unitsOnOrder(products.getUnitsOnOrder())
                    .build();

            productsDtos.add(productsDto);
        }

        return productsDtos;
    }

    @Override
    public void deleteById(Long productId) {
        Products products = productsRepository.getProductsByProductId(productId);
        if (products == null) {
            throw new RuntimeException("ID tapilmadi!");
        } else {
            productsRepository.deleteById(productId);
        }
    }
}
