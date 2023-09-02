package com.example.shopmanagement.service.impl;

import com.example.shopmanagement.dto.ShippersDto;
import com.example.shopmanagement.dto.request.ShippersRequest;
import com.example.shopmanagement.model.Shippers;
import com.example.shopmanagement.repository.ShippersRepository;
import com.example.shopmanagement.service.ShippersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippersServiceImpl implements ShippersService {

    private final ShippersRepository shippersRepository;

    @Override
    public ShippersDto getShippersByShipperId(Long shipperId) {
        Shippers shippers = shippersRepository.getShippersByShipperId(shipperId);
        return ShippersDto.builder()
                .companyName(shippers.getCompanyName())
                .phone(shippers.getPhone())
                .build();
    }

    @Override
    public void saveShippers(ShippersRequest shippersRequest) {
        Shippers shippers = Shippers.builder()
                .companyName(shippersRequest.getCompanyName())
                .phone(shippersRequest.getPhone())
                .build();
        shippersRepository.save(shippers);
    }

    @Override
    public void updateShippers(ShippersRequest shippersRequest) {
        Shippers shippers = Shippers.builder()
                .shipperId(shippersRequest.getShipperId())
                .companyName(shippersRequest.getCompanyName())
                .phone(shippersRequest.getPhone())
                .build();
        shippersRepository.save(shippers);
    }

    @Override
    public List<ShippersDto> getAll() {
        List<Shippers> shippersList = shippersRepository.findAll();
        List<ShippersDto> shippersDtos = new ArrayList<>();

        for (Shippers shippers : shippersList) {
            ShippersDto shippersDto = ShippersDto.builder()
                    .companyName(shippers.getCompanyName())
                    .phone(shippers.getPhone())
                    .build();

            shippersDtos.add(shippersDto);
        }

        return shippersDtos;
    }

    @Override
    public void deleteById(Long shipperId) {
        Shippers shippers = shippersRepository.getShippersByShipperId(shipperId);
        if (shippers == null) {
            throw new RuntimeException("ID tapilmadi!");
        } else {
            shippersRepository.deleteById(shipperId);
        }
    }
}
