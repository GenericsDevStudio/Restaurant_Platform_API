package com.generics.restaurant_platform.api.config;

import com.generics.restaurant_platform.api.user_types.UserType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class UserTypeConfig {
    private HashSet<UserType> addCategoryConfig = new HashSet<UserType>();
    private HashSet<UserType> addDishConfig = new HashSet<UserType>();
    private HashSet<UserType> addOrderCongif = new HashSet<UserType>();
    private HashSet<UserType> getOrderListCongif = new HashSet<UserType>();
    private HashSet<UserType> addRestaurantConfig = new HashSet<UserType>();


    public UserTypeConfig() {
        addCategoryConfig.addAll(Arrays.asList(UserType.ADMIN));
        addDishConfig.addAll(Arrays.asList(UserType.ADMIN));
        addOrderCongif.addAll(Arrays.asList(UserType.ADMIN, UserType.MODERATOR, UserType.GUEST));
        getOrderListCongif.addAll(Arrays.asList(UserType.ADMIN, UserType.MODERATOR));
        addRestaurantConfig.addAll(Arrays.asList(UserType.ADMIN));
    }

    @Bean
    public HashSet<UserType> addCategoryConfig() {
        return addCategoryConfig;
    }

    @Bean
    public HashSet<UserType> addDishConfig() {
        return addDishConfig;
    }

    @Bean
    public HashSet<UserType> addOrderConfig() {
        return addOrderCongif;
    }

    @Bean
    public HashSet<UserType> getOrderConfig() {
        return getOrderListCongif;
    }

    @Bean
    public HashSet<UserType> addRestaurantConfig() {
        return addRestaurantConfig;
    }
}
