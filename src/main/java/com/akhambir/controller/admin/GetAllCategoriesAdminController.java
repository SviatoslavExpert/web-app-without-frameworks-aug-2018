package com.akhambir.controller.admin;

import com.akhambir.controller.Controller;
import com.akhambir.dao.CategoryDao;
import com.akhambir.model.Category;
import com.akhambir.web.Request;
import com.akhambir.web.ViewModel;

import java.util.List;

public class GetAllCategoriesAdminController implements Controller {

    private final CategoryDao categoryDao;
    private final String VIEW_NAME;

    public GetAllCategoriesAdminController(CategoryDao categoryDao, String viewName) {
        this.categoryDao = categoryDao;
        this.VIEW_NAME = viewName;
    }


    @Override
    public ViewModel process(Request request) {
        List<Category> categories = categoryDao.findAll();
        ViewModel vm = ViewModel.of(VIEW_NAME);
        vm.addAttribute("categories", categories);
        return vm;
    }
}
