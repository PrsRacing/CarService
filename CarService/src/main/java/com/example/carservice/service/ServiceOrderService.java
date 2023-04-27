package com.example.carservice.service;

import com.example.carservice.model.service.ServiceOrderModel;
import com.example.carservice.model.view.ServiceOrderViewModel;

import java.util.List;

public interface ServiceOrderService {
    void addServiceOrder(ServiceOrderModel serviceOrderModel);

    List<ServiceOrderViewModel> findAllServiceOrderByPriceDesc();

}
