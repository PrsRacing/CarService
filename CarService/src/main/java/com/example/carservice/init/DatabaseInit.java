package com.example.carservice.init;

import com.example.carservice.service.CarCategoryService;
import com.example.carservice.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final CategoryService categoryService;
    private final CarCategoryService carCategoryService;

    public DatabaseInit(CategoryService categoryService, CarCategoryService carCategoryService) {
        this.categoryService = categoryService;
        this.carCategoryService = carCategoryService;
    }


    @Override
    public void run(String... args) throws Exception {

        categoryService.initCategories();
        carCategoryService.initCarCategories();

    }
}
