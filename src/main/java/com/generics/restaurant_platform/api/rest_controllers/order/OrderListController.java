package com.generics.restaurant_platform.api.rest_controllers.order;

import com.generics.restaurant_platform.api.database.order.OrderDataBaseController;
import com.generics.restaurant_platform.api.entities.Order;
import com.generics.restaurant_platform.api.entities.OrderListing;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.ListAnswer;
import com.generics.restaurant_platform.api.services.CheckPermission;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@RestController
@Component("orderListController")
public class OrderListController {
    @Autowired
    private OrderDataBaseController orderDataBaseController;

    @Autowired
    private CheckPermission checkPermission;

    @Resource(name = "getOrderConfig")
    private HashSet<UserType> userTypes;

    @RequestMapping(value = "/getOrders", method = RequestMethod.POST)
    public Answer getOrders(String token) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            ListAnswer<Order> listAnswer = new ListAnswer<Order>(200, "OK", orderDataBaseController.getAllOrders());
            listAnswer.getList().forEach(s -> System.out.println(s.getDishes()));
            return listAnswer;
        } else {
            return new Answer(403, "Permission denied");
        }
    }

    @RequestMapping(value = "/getOrdersByRestaurant", method = RequestMethod.POST)
    public Answer getOrders(String token, int restaurantId) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            return new ListAnswer<Order>(200, "OK", orderDataBaseController.getAllRestaurantOrders(restaurantId));
        } else {
            return new Answer(403, "Permission denied");
        }
    }

    @RequestMapping(value = "/getOrdersByRestaurantAndStatus", method = RequestMethod.POST)
    public Answer getOrders(String token, int restaurantId, boolean status) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            return new ListAnswer<Order>(200, "OK", orderDataBaseController.getAllRestaurantStatusOrders(restaurantId, status));
        } else {
            return new Answer(403, "Permission denied");
        }
    }
}
