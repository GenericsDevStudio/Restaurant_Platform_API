package com.generics.restaurant_platform.api.database.category;

import com.generics.restaurant_platform.api.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryTable extends CrudRepository<Category, Integer> {
    List<Category> findAll();
    Category findByName(String name);
    Category findById(int id);
}
