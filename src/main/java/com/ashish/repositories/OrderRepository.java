package com.ashish.repositories;

import com.ashish.entities.Order;
import com.ashish.enums.OrderStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    public Map<Integer, Order> orderMap;

    public OrderRepository() {
        this.orderMap = new HashMap<>();
    }

    public void placeOrder(Order order){
        this.orderMap.put(order.getOrderId(), order);
    }


}
