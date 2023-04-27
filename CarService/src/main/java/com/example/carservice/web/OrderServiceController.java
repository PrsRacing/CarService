package com.example.carservice.web;

import com.example.carservice.model.binding.ServiceOrderAddBindingModel;
import com.example.carservice.model.service.ServiceOrderModel;
import com.example.carservice.service.ServiceOrderService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderServiceController {

    private final ServiceOrderService serviceOrderService;
    private final ModelMapper modelMapper;

    public OrderServiceController(ServiceOrderService serviceOrderService, ModelMapper modelMapper) {
        this.serviceOrderService = serviceOrderService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add() {
        return "order-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ServiceOrderAddBindingModel serviceOrderAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("serviceOrderAddBindingModel", serviceOrderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.serviceOrderAddBindingModel", bindingResult);

            return "redirect:add";
        }

        serviceOrderService.addServiceOrder(modelMapper
                .map(serviceOrderAddBindingModel, ServiceOrderModel.class));

        return "redirect:/";
    }

    @ModelAttribute
    public ServiceOrderAddBindingModel serviceOrderAddBindingModel() {
        return new ServiceOrderAddBindingModel();
    }
}
