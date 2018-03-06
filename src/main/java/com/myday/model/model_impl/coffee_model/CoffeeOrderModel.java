package com.myday.model.model_impl.coffee_model;

import com.myday.model.model_inter.ObjectOrderModel;
import com.myday.service.dao.dao_inter.ObjectDao;
import com.myday.service.entities.impl_entities.coffee_impl_entity.CoffeeOrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CoffeeOrderModel implements ObjectOrderModel {
    private List<CoffeeOrderList> coffeeOrderList = new ArrayList<>();

    @Autowired
    private ObjectDao coffeeDao;

    public CoffeeOrderModel() {
    }

    @Override
    public void addToOrderList(String coffeeName, int countCups) {
        CoffeeOrderList coffeeOrderListObj = null;

        for (CoffeeOrderList coffeeEntity : coffeeOrderList) {
            if (isContainsList(coffeeEntity, coffeeName)) {
                coffeeOrderListObj = coffeeEntity;

                break;
            }
        }

        if (coffeeOrderListObj == null) {
            double price = coffeeDao.getPriceByName(coffeeName);
            price *= countCups;

            coffeeOrderList.add(new CoffeeOrderList(coffeeName, countCups, price));
        } else {
            updatingOrderData(coffeeOrderListObj, coffeeName, countCups);
        }
    }

    @Transactional
    @Override
    public List<CoffeeOrderList> getOrderList() {
        return coffeeOrderList;
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;

        for (CoffeeOrderList coffeeEntity : getOrderList()) {
            totalPrice += coffeeEntity.getPrice();
        }

        return totalPrice;
    }

    private void updatingOrderData(CoffeeOrderList coffeeOrderListObj, String name, int countCups) {
        double standardPrice = coffeeDao.getPriceByName(name);

        double price = coffeeOrderListObj.getPrice() + standardPrice * countCups;
        int newCountCups = coffeeOrderListObj.getCountCups() + countCups;
        int index = coffeeOrderList.indexOf(coffeeOrderListObj);

        coffeeOrderListObj.setPrice(price);
        coffeeOrderListObj.setCountCups(newCountCups);

        coffeeOrderList.set(index, coffeeOrderListObj);
    }

    private boolean isContainsList(CoffeeOrderList coffeeOrderListObj, String coffeeName) {
        return coffeeOrderListObj.getName().contains(coffeeName);
    }
}
