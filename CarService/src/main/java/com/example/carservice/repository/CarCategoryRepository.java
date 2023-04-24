package com.example.carservice.repository;

import com.example.carservice.model.entity.CarCategory;
import com.example.carservice.model.entity.CarCategoryEnum;
import com.example.carservice.model.entity.Category;
import com.example.carservice.model.entity.CategoryRepairEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategory, Long> {
    Optional<CarCategory> findByCarName (CarCategoryEnum carName);

}
