package com.ashish;

import com.ashish.entities.Order;
import com.ashish.entities.Restaurant;
import com.ashish.enums.OrderStatus;
import com.ashish.enums.Selection;
import com.ashish.repositories.OrderRepository;
import com.ashish.repositories.RestaurantRepository;
import com.ashish.services.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FoodOrderingSystemApplication {

    static RestaurantRepository restaurantRepository = new RestaurantRepository();
    static OrderRepository orderRepository = new OrderRepository();
    static OrderService orderService = new OrderService(restaurantRepository, orderRepository);

    // DRIVER
    public static void main(String[] args) {
        SpringApplication.run(FoodOrderingSystemApplication.class, args);

        Restaurant restaurant = new Restaurant("R1", 4.5);
        Map<String, Integer> menu = new HashMap<>();
        menu.put("Veg Biryani", 100);
        menu.put("Chicken Biryani", 150);
        restaurant.setMaxNoOfOrders(5);
        restaurant.setMenu(menu);

        Restaurant restaurant2 = new Restaurant("R2", 4.0);
        Map<String, Integer> menu2 = new HashMap<>();
        menu2.put("Idli", 10);
        menu2.put("Dosa", 50);
        menu2.put("Veg Biryani", 80);
        menu2.put("Chicken Biryani", 175);
        restaurant2.setMaxNoOfOrders(5);
        restaurant2.setMenu(menu2);

        Restaurant restaurant3 = new Restaurant("R3", 4.9);
        Map<String, Integer> menu3 = new HashMap<>();
        menu3.put("Idli", 15);
        menu3.put("Dosa", 30);
        menu3.put("Gobi Manchurian", 150);
        menu3.put("Chicken Biryani", 175);
        restaurant3.setMaxNoOfOrders(1);
        restaurant3.setMenu(menu3);

        restaurantRepository.onBoardRestaurant(restaurant);
        restaurantRepository.onBoardRestaurant(restaurant2);
        restaurantRepository.onBoardRestaurant(restaurant3);

        //update
        restaurantRepository.addMenuItem("R1", "chicken65", 250);
        restaurantRepository.updateMenuItem("R2", "Chicken Biryani", 150);


        //place Order
        Order order = new Order(01,"Ashwin", Selection.LOWEST_COST);
        Map<String, Integer> items = new HashMap<>();
        items.put("Idli", 3);
        items.put("Dosa", 1);
        order.setItems(items);
        orderService.placeOrder(order);

        Order order2 = new Order(02,"Harish", Selection.LOWEST_COST);
        Map<String, Integer> items2 = new HashMap<>();
        items2.put("Idli", 3);
        items2.put("Dosa", 1);
        order2.setItems(items2);
        orderService.placeOrder(order2);

        orderService.updateOrderStatus(01, OrderStatus.COMPLETED);

        Order order3 = new Order(03,"Harish", Selection.LOWEST_COST);
        Map<String, Integer> items3 = new HashMap<>();
        items3.put("Idli", 3);
        items3.put("Dosa", 1);
        order3.setItems(items3);
        orderService.placeOrder(order3);

        Order order4 = new Order(04,"Harish", Selection.LOWEST_COST);
        Map<String, Integer> items4 = new HashMap<>();
        items4.put("Idli", 3);
        items4.put("Paneer Tikka", 1);
        order4.setItems(items4);
        orderService.placeOrder(order4);



    }

}
