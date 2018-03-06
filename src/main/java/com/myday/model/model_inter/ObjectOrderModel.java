package com.myday.model.model_inter;

import java.util.List;

public interface ObjectOrderModel {
    void addToOrderList(String coffeeName, int countCups);

    List<?> getOrderList();

    double getTotalPrice();
}
