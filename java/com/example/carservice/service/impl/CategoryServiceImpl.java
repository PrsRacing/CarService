package com.example.carservice.service.impl;

import com.example.carservice.model.entity.Category;
import com.example.carservice.model.entity.CategoryRepairEnum;
import com.example.carservice.repository.CategoryRepository;
import com.example.carservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count() !=0) {
            return;
        }

        Arrays.stream(CategoryRepairEnum.values())
                .forEach(categoryRepairEnum -> {
                    Category category = new Category();
                    category.setName(categoryRepairEnum);
                        switch (categoryRepairEnum){
                            case MAINTENANCE -> category.setNeededTime(45);
                            case DIAGNOSTIC -> category.setNeededTime(40);
                            case ENGINEREPAIR -> category.setNeededTime(240);
                            case SUSPENCIONREPAIR -> category.setNeededTime(140);
                            case DETAILING -> category.setNeededTime(120);
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryRepairEnum categoryRepairEnum) {
        return categoryRepository
                .findByName(categoryRepairEnum)
                .orElse(null);
    }
}
