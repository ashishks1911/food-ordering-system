package com.ashish.services;

import com.ashish.entities.Order;
import com.ashish.entities.Restaurant;
import com.ashish.enums.OrderStatus;
import com.ashish.exceptions.RestaurantException;
import com.ashish.repositories.OrderRepository;
import com.ashish.repositories.RestaurantRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderService {
    private RestaurantRepository restaurantRepository;
    private OrderRepository orderRepository;

    public OrderService(RestaurantRepository restaurantRepository, OrderRepository orderRepository) {
        this.restaurantRepository = restaurantRepository;
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        //Minimum cost
        Restaurant restaurant = null;
        Integer minimumCostRestaurant = Integer.MAX_VALUE;
        Map<String, Restaurant> restaurantMap = restaurantRepository.getRestaurantMap();
        Map<String, Integer> items = order.getItems();
        for (String restaurantName : restaurantMap.keySet()) {
            if (isAllItemsAvailable(restaurantMap.get(restaurantName), items)) {
                if (restaurantMap.get(restaurantName).isFull()) {
                    System.out.println(restaurantName + " is occupied.");
                    break;
                }
                Integer cost = calculateOrder(restaurantMap.get(restaurantName), items);
                if (minimumCostRestaurant > cost) {
                    minimumCostRestaurant = cost;
                    restaurant = restaurantMap.get(restaurantName);
                }
                System.out.println(restaurantName + " : can fulfill order at " + cost);
            }
        }
        if (restaurant == null) {
            System.out.println("None of the restaurant can fulfill the Order.");
        }
        order.assignOrder(restaurant);
        orderRepository.placeOrder(order);

    }

    public boolean isAllItemsAvailable(Restaurant restaurant, Map<String, Integer> items) {
        Set<String> restaurantItems = restaurant.getMenu().keySet();
        for (String item : items.keySet()) {
            if (!restaurantItems.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public Integer calculateOrder(Restaurant restaurant, Map<String, Integer> items) {
        Integer total = 0;
        Set<String> restaurantItems = restaurant.getMenu().keySet();
        Map<String, Integer> menu = restaurant.getMenu();
        for (String item : items.keySet()) {
            if (restaurantItems.contains(item)) {
                total += menu.get(item);
            }
        }
        return total;
    }

    public void updateOrderStatus(Integer orderId, OrderStatus orderStatus) {
        orderRepository.orderMap.get(orderId).setOrderStatus(orderStatus);
    }

}
