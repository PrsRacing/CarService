package com.example.carservice.service.impl;

import com.example.carservice.model.entity.ServiceOrder;
import com.example.carservice.model.service.ServiceOrderModel;
import com.example.carservice.model.view.ServiceOrderViewModel;
import com.example.carservice.repository.ServiceOrderRepository;
import com.example.carservice.sec.CurrentUser;
import com.example.carservice.service.CarCategoryService;
import com.example.carservice.service.CategoryService;
import com.example.carservice.service.ServiceOrderService;
import com.example.carservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CarCategoryService carCategoryService;

    public ServiceOrderServiceImpl(ServiceOrderRepository serviceOrderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService, CarCategoryService carCategoryService) {
        this.serviceOrderRepository = serviceOrderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.carCategoryService = carCategoryService;
    }


    @Override
    public void addServiceOrder(ServiceOrderModel serviceOrderModel) {
        ServiceOrder serviceOrder = modelMapper.map(serviceOrderModel, ServiceOrder.class);
        serviceOrder.setEmployee(userService.findById(currentUser.getId()));
        serviceOrder.setCategory(categoryService.findByCategoryNameEnum(serviceOrderModel.getCategory()));
        serviceOrder.setCarCategory(carCategoryService.findByCarCategoryNameEnum(serviceOrderModel.getCarCategory()));

        serviceOrderRepository.save(serviceOrder);
    }

    @Override
    public List<ServiceOrderViewModel> findAllServiceOrderByPriceDesc() {
        return serviceOrderRepository
                .findAllByServiceOrderPriceDesc()
                .stream()
                .map(serviceOrder -> modelMapper.map(serviceOrder, ServiceOrderViewModel.class))
                .collect(Collectors.toList());
    }
}
