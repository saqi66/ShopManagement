package com.example.shopmanagement.controller;

import com.example.shopmanagement.dto.ProductsDto;
import com.example.shopmanagement.dto.request.ProductsRequest;
import com.example.shopmanagement.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductsController {

    final ProductsService productsService;

    @GetMapping(value = "/productsList")
    public List<ProductsDto> getProductsList() {
        return productsService.getAll();
    }

    @GetMapping(value = "/getProductsById/{productId}")
    public ProductsDto getProductsById(@PathVariable(value = "productId") Long productId) {
        return productsService.getProductsByProductId(productId);
    }

    @PostMapping(value = "/saveProducts")
    public void saveProducts(@RequestBody ProductsRequest productsRequest) {
        productsService.saveProducts(productsRequest);
    }

    @PostMapping(value = "/updateProducts")
    public void updateProducts(@RequestBody ProductsRequest productsRequest) {
        productsService.updateProducts(productsRequest);
    }

    @DeleteMapping(value = "/deleteById/{productId}")
    public void deleteById(@PathVariable(value = "productId") Long productId) {
        productsService.deleteById(productId);
    }
}
