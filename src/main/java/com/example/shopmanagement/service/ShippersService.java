package com.example.shopmanagement.service;

import com.example.shopmanagement.dto.ProductsDto;
import com.example.shopmanagement.dto.ShippersDto;
import com.example.shopmanagement.dto.request.ProductsRequest;
import com.example.shopmanagement.dto.request.ShippersRequest;

import java.util.List;

public interface ShippersService {

    ShippersDto getShippersByShipperId(Long shipperId);

    void saveShippers(ShippersRequest shippersRequest);

    void updateShippers (ShippersRequest shippersRequest);

    List<ShippersDto> getAll();

    void deleteById(Long shipperId);

}
