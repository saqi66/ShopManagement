package com.example.shopmanagement.service.impl;

import com.example.shopmanagement.dto.CategoriesDto;
import com.example.shopmanagement.dto.request.CategoriesRequest;
import com.example.shopmanagement.model.Categories;
import com.example.shopmanagement.repository.CategoriesRepository;
import com.example.shopmanagement.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public CategoriesDto getCategoriesByCategoryId(Long categoryId) {
        Categories categories = categoriesRepository.getCategoriesByCategoryId(categoryId);
        return CategoriesDto.builder()
                .categoryName(categories.getCategoryName())
                .description(categories.getDescription())
                .picture(categories.getPicture())
                .build();
    }

    @Override
    public void saveCategories(CategoriesRequest categoriesRequest) {
        Categories categories = Categories.builder()
                .categoryName(categoriesRequest.getCategoryName())
                .description(categoriesRequest.getDescription())
                .picture(categoriesRequest.getPicture())
                .build();
        categoriesRepository.save(categories);
    }

    @Override
    public void updateCategories(CategoriesRequest categoriesRequest) {
        Categories categories = Categories.builder()
                .categoryId(categoriesRequest.getCategoryId())
                .categoryName(categoriesRequest.getCategoryName())
                .description(categoriesRequest.getDescription())
                .picture(categoriesRequest.getPicture())
                .build();
        categoriesRepository.save(categories);
    }

    @Override
    public List<CategoriesDto> getAll() {
        List<Categories> categories = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtos = new ArrayList<>();

        for (Categories categories1 : categories) {
            CategoriesDto categoriesDto = CategoriesDto.builder()
                    .categoryName(categories1.getCategoryName())
                    .description(categories1.getDescription())
                    .picture(categories1.getPicture())
                    .build();

            categoriesDtos.add(categoriesDto);
        }

        return categoriesDtos;
    }


    @Override
    public void deleteById(Long categoryId) {
        Categories categories = categoriesRepository.getCategoriesByCategoryId(categoryId);
        if (categories == null) {
            throw new RuntimeException("ID tapilmadi.!");
        } else {
            categoriesRepository.deleteById(categoryId);
        }
    }
}
