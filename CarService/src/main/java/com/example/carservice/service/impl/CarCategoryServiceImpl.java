package com.example.carservice.service.impl;

import com.example.carservice.model.entity.CarCategory;
import com.example.carservice.model.entity.CarCategoryEnum;
import com.example.carservice.model.entity.Category;
import com.example.carservice.model.entity.CategoryRepairEnum;
import com.example.carservice.repository.CarCategoryRepository;
import com.example.carservice.service.CarCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CarCategoryServiceImpl implements CarCategoryService {

    private final CarCategoryRepository carCategoryRepository;

    public CarCategoryServiceImpl(CarCategoryRepository carCategoryRepository) {
        this.carCategoryRepository = carCategoryRepository;
    }

    @Override
    public void initCarCategories() {
        if(carCategoryRepository.count() !=0) {
            return;
        }
        Arrays.stream(CarCategoryEnum.values())
                .forEach(carCategoryEnum -> {
                    CarCategory carCategory = new CarCategory();
                    carCategory.setCarName(carCategoryEnum);

                    carCategoryRepository.save(carCategory);
                });

    }

    @Override
    public CarCategory findByCarCategoryNameEnum(CarCategoryEnum carCategoryEnum) {
        return carCategoryRepository
                .findByCarName(carCategoryEnum)
                .orElse(null);
    }



}
