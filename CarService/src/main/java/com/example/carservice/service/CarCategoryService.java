package com.example.carservice.service;

import com.example.carservice.model.entity.CarCategory;
import com.example.carservice.model.entity.CarCategoryEnum;
import com.example.carservice.model.entity.Category;
import com.example.carservice.model.entity.CategoryRepairEnum;

public interface CarCategoryService {
    void initCarCategories();
    CarCategory findByCarCategoryNameEnum(CarCategoryEnum carCategoryEnum);
}
