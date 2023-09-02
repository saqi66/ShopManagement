package com.example.shopmanagement.controller;

import com.example.shopmanagement.dto.CategoriesDto;
import com.example.shopmanagement.dto.request.CategoriesRequest;
import com.example.shopmanagement.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/categories")
public class CategoriesController {

    final CategoriesService categoriesService;

    @GetMapping(value = "/categoriesList")
    public List<CategoriesDto> getCategoriesList() {
        return categoriesService.getAll();
    }

    @GetMapping(value = "/getCategoriesById/{categoryId}")
    public CategoriesDto getCategoriesById(@PathVariable(value = "categoryId") Long categoryId) {
        return categoriesService.getCategoriesByCategoryId(categoryId);
    }

    @PostMapping(value = "/saveCategories")
    public void saveCategories(@RequestBody CategoriesRequest categoriesRequest) {
        categoriesService.saveCategories(categoriesRequest);
    }

    @PostMapping(value = "/updateCategories")
    public void updateCategories(@RequestBody CategoriesRequest categoriesRequest) {
        categoriesService.updateCategories(categoriesRequest);
    }

    @DeleteMapping(value = "/deleteById/{categoryId}")
    public void deleteById(@PathVariable(value = "categoryId") Long categoryId) {
        categoriesService.deleteById(categoryId);
    }
}
