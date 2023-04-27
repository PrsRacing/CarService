package com.example.carservice.web;

import com.example.carservice.model.view.ServiceOrderViewModel;
import com.example.carservice.sec.CurrentUser;
import com.example.carservice.service.ServiceOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {

    private final CurrentUser currentUser;
    private final ServiceOrderService serviceOrderService;
    public HomeController(CurrentUser currentUser, ServiceOrderService serviceOrderService) {
        this.currentUser = currentUser;
        this.serviceOrderService = serviceOrderService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null){
            return "index";
        }
        List<ServiceOrderViewModel> serviceOrders = serviceOrderService.findAllServiceOrderByPriceDesc();

        model.addAttribute("orders", serviceOrderService.findAllServiceOrderByPriceDesc());

        return "home";
    }
}
//3:18:00