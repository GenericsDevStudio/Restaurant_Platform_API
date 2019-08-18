package com.generics.restaurant_platform.api.rest_controllers.order;

import com.generics.restaurant_platform.api.database.order.OrderDataBaseController;
import com.generics.restaurant_platform.api.entities.Order;
import com.generics.restaurant_platform.api.entities.OrderListing;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderListController {
    @Autowired
    private OrderDataBaseController orderDataBaseController;

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public Answer getOrders() {
        ListAnswer<Order> listAnswer = new ListAnswer<Order>(200, "OK", orderDataBaseController.getAllOrders());
        listAnswer.getList().forEach(s -> System.out.println(s.getDishes()));
        return listAnswer;
    }

    @RequestMapping(value = "/getOrdersByRestaurant", method = RequestMethod.GET)
    public Answer getOrders(int restaurantId) {
        return new ListAnswer<Order>(200, "OK", orderDataBaseController.getAllRestaurantOrders(restaurantId));
    }

    @RequestMapping(value = "/getOrdersByRestaurantAndStatus", method = RequestMethod.GET)
    public Answer getOrders(int restaurantId, boolean status) {
        return new ListAnswer<Order>(200, "OK", orderDataBaseController.getAllRestaurantStatusOrders(restaurantId, status));
    }
}
