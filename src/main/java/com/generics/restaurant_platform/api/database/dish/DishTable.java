package com.generics.restaurant_platform.api.database.dish;

import com.generics.restaurant_platform.api.entities.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishTable extends CrudRepository<Dish, Integer> {
    List<Dish> findAll();
    List<Dish> findByCategoryId(int categoryId);
    Dish findByName(String name);
}
