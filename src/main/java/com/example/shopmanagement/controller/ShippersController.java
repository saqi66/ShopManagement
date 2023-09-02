package com.example.shopmanagement.controller;

import com.example.shopmanagement.dto.ShippersDto;
import com.example.shopmanagement.dto.request.ShippersRequest;
import com.example.shopmanagement.service.ShippersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/shippers")
public class ShippersController {

    final ShippersService shippersService;

    @GetMapping(value = "/shippersList")
    public List<ShippersDto> getShippersList() {
        return shippersService.getAll();
    }

    @GetMapping(value = "/getShippersById/{shipperId}")
    public ShippersDto getShippersById(@PathVariable(value = "shipperId") Long shipperId) {
        return shippersService.getShippersByShipperId(shipperId);
    }

    @PostMapping(value = "/saveShippers")
    public void saveShippers(@RequestBody ShippersRequest shippersRequest) {
        shippersService.saveShippers(shippersRequest);
    }

    @PostMapping(value = "/updateShippers")
    public void updateShippers(@RequestBody ShippersRequest shippersRequest) {
        shippersService.updateShippers(shippersRequest);
    }

    @DeleteMapping(value = "/deleteById/{shipperId}")
    public void deleteById(@PathVariable(value = "shipperId") Long shipperId) {
        shippersService.deleteById(shipperId);
    }
}
