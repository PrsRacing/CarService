package com.example.carservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_categories")
public class CarCategory extends BaseEntity{

    private CarCategoryEnum carName;

    public CarCategory() {
    }

    @Enumerated(EnumType.STRING)
    public CarCategoryEnum getCarName() {
        return carName;
    }

    public void setCarName(CarCategoryEnum carName) {
        this.carName = carName;
    }
}
