package com.example.carservice.model.binding;

import com.example.carservice.model.entity.CarCategoryEnum;
import com.example.carservice.model.entity.CategoryRepairEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceOrderAddBindingModel {

    private String ownerName;
    private String carMark;
    private String description;
    private LocalDateTime carAcceptedTime;
    private BigDecimal price;
    private CategoryRepairEnum categoryRepair;
    private CarCategoryEnum carCategory;

    public ServiceOrderAddBindingModel() {
    }

    @Size(min = 3, max = 20)
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Size(min = 2, max = 20)
    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getCarAcceptedTime() {
        return carAcceptedTime;
    }

    public void setCarAcceptedTime(LocalDateTime carAcceptedTime) {
        this.carAcceptedTime = carAcceptedTime;
    }

    @NotNull
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public CategoryRepairEnum getCategoryRepair() {
        return categoryRepair;
    }

    public void setCategoryRepair(CategoryRepairEnum categoryRepair) {
        this.categoryRepair = categoryRepair;
    }

    @NotNull
    public CarCategoryEnum getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategoryEnum carCategory) {
        this.carCategory = carCategory;
    }
}
