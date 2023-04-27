package com.example.carservice.model.service;

import com.example.carservice.model.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceOrderModel {
    private Long id;
    private String ownerName;
    private String carMark;
    private String description;
    private BigDecimal price;
    private LocalDateTime carAcceptedTime;
    private CarCategoryEnum carCategory;
    private CategoryRepairEnum category;
    private User employee;

    public ServiceOrderModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCarAcceptedTime() {
        return carAcceptedTime;
    }

    public void setCarAcceptedTime(LocalDateTime carAcceptedTime) {
        this.carAcceptedTime = carAcceptedTime;
    }

    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategoryEnum carCategory) {
        this.carCategory = carCategory;
    }

    public CategoryRepairEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryRepairEnum category) {
        this.category = category;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }
}
