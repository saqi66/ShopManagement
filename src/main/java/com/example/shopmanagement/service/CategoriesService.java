package com.example.shopmanagement.service;

import com.example.shopmanagement.dto.CategoriesDto;
import com.example.shopmanagement.dto.request.CategoriesRequest;

import java.util.List;

public interface CategoriesService {

    CategoriesDto getCategoriesByCategoryId(Long categoryId);

    void saveCategories(CategoriesRequest categoriesRequest);

    void updateCategories (CategoriesRequest categoriesRequest);

    List<CategoriesDto> getAll();

    void deleteById(Long categoryId);

}
