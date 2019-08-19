package com.generics.restaurant_platform.api.rest_controllers.order;

import com.generics.restaurant_platform.api.database.order.OrderDataBaseController;
import com.generics.restaurant_platform.api.database.token.TokenDataBaseController;
import com.generics.restaurant_platform.api.entities.Order;
import com.generics.restaurant_platform.api.json_answers.Answer;
import com.generics.restaurant_platform.api.json_answers.RegistrationAnswer;
import com.generics.restaurant_platform.api.services.CheckPermission;
import com.generics.restaurant_platform.api.services.GetIdByToken;
import com.generics.restaurant_platform.api.services.ListToString;
import com.generics.restaurant_platform.api.user_types.UserType;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@Component("orderAddingController")
public class OrderAddingController {
    @Autowired
    private OrderDataBaseController orderDataBaseController;
    @Autowired
    private GetIdByToken getIdByToken;
    @Autowired
    private ListToString listToString;
    @Autowired
    private CheckPermission checkPermission;
    private HashSet<UserType> userTypes;

    public void setUserTypes(UserType... ust) {
        userTypes.addAll(Arrays.asList(ust));
    }
    public OrderAddingController() {
        userTypes = new HashSet<>();
        setUserTypes(UserType.ADMIN, UserType.MODERATOR, UserType.GUEST);
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Answer addOrder(String token, int restaurantId, String dishes) {
        if(userTypes.contains(checkPermission.checkPermisson(token))) {
            Order order = new Order(true, restaurantId, getIdByToken.getId(token), listToString.convertToEntityAttribute(dishes));
            orderDataBaseController.addOrder(order);
            return new RegistrationAnswer(200, "OK", order.getId());
        } else {
            return new Answer(403, "Permission denied");
        }
    }
}
