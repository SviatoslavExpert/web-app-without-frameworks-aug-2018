package com.akhambir.dao;

import com.akhambir.model.Category;

import java.util.List;

public interface CategoryDao {

    Category findById(Long id);

    List<Category> findAll();
}
