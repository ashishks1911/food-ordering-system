package com.ashish.entities;

import java.util.Map;

public class Restaurant {
    private Integer maxNumberOfOrders;
    private Integer capacity = 0;
    private String name;
    private Map<String, Integer> menu;
    private Double rating;

    public Restaurant(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }

    public Integer getMaxNoOfOrders() {
        return maxNumberOfOrders;
    }

    public void setMaxNoOfOrders(Integer maxNumberOfOrders) {
        this.maxNumberOfOrders = maxNumberOfOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isFull() {
        return capacity >= maxNumberOfOrders;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
