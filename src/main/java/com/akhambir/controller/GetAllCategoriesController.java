package com.akhambir.controller;

import com.akhambir.dao.CategoryDao;
import com.akhambir.model.Category;
import com.akhambir.web.Request;
import com.akhambir.web.ViewModel;

import java.util.List;

public class GetAllCategoriesController implements Controller {

    private final CategoryDao categoryDao;


    public GetAllCategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public ViewModel process(Request request) {
        List<Category> categories = categoryDao.findAll();
        ViewModel vm = ViewModel.of("categories");
        vm.addAttribute("categories", categories);
        return vm;
    }
}
