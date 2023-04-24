package com.example.carservice.service;

import com.example.carservice.model.entity.Category;
import com.example.carservice.model.entity.CategoryRepairEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryRepairEnum categoryRepairEnum);
}
