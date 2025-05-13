package com.ashish.entities;

import com.ashish.enums.OrderStatus;
import com.ashish.enums.Selection;

import java.util.Map;

public class Order {
    private Integer orderId;
    private String username;
    private Map<String, Integer> items;
    private Selection strategy;
    private Restaurant restaurant;
    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus.equals(OrderStatus.COMPLETED)) {
            restaurant.setCapacity(restaurant.getCapacity() - 1);
        }
        this.orderStatus = orderStatus;
    }

    public Order(Integer orderId, String username, Selection strategy) {
        this.orderId = orderId;
        this.username = username;
        this.strategy = strategy;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public Selection getStrategy() {
        return strategy;
    }

    public void setStrategy(Selection strategy) {
        this.strategy = strategy;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void assignOrder(Restaurant restaurant) {
        this.restaurant = restaurant;
        System.out.println("Order assigned to : " + restaurant.getName());
        restaurant.setCapacity(getRestaurant().getCapacity() + 1);
        this.orderStatus = OrderStatus.ACCEPTED;
    }
}
