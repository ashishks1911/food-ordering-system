package com.ashish.repositories;

import com.ashish.entities.Restaurant;
import com.ashish.exceptions.MenuException;
import com.ashish.exceptions.RestaurantException;

import java.util.*;

public class RestaurantRepository {
    public Map<String, Restaurant> restaurantMap;

    public Map<String, Restaurant> getRestaurantMap() {
        return restaurantMap;
    }

    public RestaurantRepository() {
        this.restaurantMap = new HashMap<>();
    }

    public void onBoardRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    public void addMenuItem(String name, String itemName, Integer price) {
        if (!restaurantMap.containsKey(name)) {
            throw new RestaurantException("Restaurant not found with name : " + name);
        }
        Restaurant restaurant = restaurantMap.get(name);
        Map<String, Integer> map = restaurant.getMenu();
        if (map.containsKey(itemName)) {
            throw new MenuException("item : " + itemName + " already exists");
        }
        map.put(itemName, price);
    }


    public void updateMenuItem(String name, String itemName, Integer price) {
        if (!restaurantMap.containsKey(name)) {
            throw new RestaurantException("Restaurant not found with name : " + name);
        }
        Restaurant restaurant = restaurantMap.get(name);
        Map<String, Integer> map = restaurant.getMenu();
        if (!map.containsKey(itemName)) {
            throw new MenuException("item : " + itemName + " not found");
        }
        map.put(itemName, price);
    }


}