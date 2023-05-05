package com.cydeo.service;

import com.cydeo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO findCategoryById(Long categoryId);
    List<CategoryDTO> getAllCategories() throws Exception;
    boolean hasProduct(Long categoryId);
}
