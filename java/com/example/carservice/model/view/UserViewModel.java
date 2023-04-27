package com.example.carservice.model.view;

public class UserViewModel {
    private String username;
    private Integer countOfServiceOrders;

    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCountOfServiceOrders() {
        return countOfServiceOrders;
    }

    public void setCountOfServiceOrders(Integer countOfServiceOrders) {
        this.countOfServiceOrders = countOfServiceOrders;
    }
}

