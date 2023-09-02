package com.example.shopmanagement.repository;

import com.example.shopmanagement.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Categories getCategoriesByCategoryId(Long categoryId);

}


