package com.example.shopmanagement.service;

import com.example.shopmanagement.dto.ProductsDto;
import com.example.shopmanagement.dto.request.ProductsRequest;

import java.util.List;

public interface ProductsService {

    ProductsDto getProductsByProductId(Long productId);

    void saveProducts(ProductsRequest productsRequest);

    void updateProducts (ProductsRequest productsRequest);

    List<ProductsDto> getAll();

    void deleteById(Long productId);

}
