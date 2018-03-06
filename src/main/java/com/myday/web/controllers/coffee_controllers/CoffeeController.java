package com.myday.web.controllers.coffee_controllers;

import com.myday.model.model_inter.ObjectModel;
import com.myday.model.model_inter.ObjectOrderModel;
import com.myday.service.entities.impl_entities.coffee_impl_entity.CoffeeEntity;
import com.myday.service.entities.impl_entities.coffee_impl_entity.CoffeeOrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping(value = "/")
public class CoffeeController {

    @Autowired
    private ObjectModel coffeeModel;

    @Autowired
    private ObjectOrderModel coffeeOrderModel;

    @SuppressWarnings("unchecked")
    @GetMapping("coffee-card")
    public String getCoffeeCard(Model model) {

        List<CoffeeEntity> propositionList = (List<CoffeeEntity>) coffeeModel.getPropositionList();

        model.addAttribute("propositionList", propositionList);

        List<CoffeeOrderList> orderList = (List<CoffeeOrderList>) coffeeOrderModel.getOrderList();
        model.addAttribute("orderList", orderList);

        double totalPrice = coffeeOrderModel.getTotalPrice();
        model.addAttribute("totalPrice", totalPrice);

        return "coffee-card";
    }

    @PostMapping("/coffee-card")
    public String getOrderDataList(HttpServletRequest servletRequest) {

        String coffeeName = servletRequest.getParameter("coffee-name");
        int countCups = parseInt(servletRequest.getParameter("spinner-num"));

        coffeeOrderModel.addToOrderList(coffeeName, countCups);

        return "redirect:/coffee-card";
    }
}
