package com.example.shopmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesRequest {

    private Long categoryId;
    private String categoryName;
    private String description;
    private String picture;

}

