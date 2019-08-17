package com.generics.restaurant_platform.api.rest_controllers.order;

import com.generics.restaurant_platform.api.database.order.OrderDataBaseController;
import com.generics.restaurant_platform.api.entities.Order;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderAddingController {

    @Autowired
    private OrderDataBaseController orderDataBaseController;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Answer addOrder(int restaurantId, int userId, String dishes) {
        Order order = new Order(true, restaurantId, userId, dishes);
        orderDataBaseController.addOrder(order);
        return new RegistrationAnswer(200, "OK", order.getId());
    }
}
