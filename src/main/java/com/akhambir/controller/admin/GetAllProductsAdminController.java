package com.akhambir.controller.admin;

import com.akhambir.controller.Controller;
import com.akhambir.model.Product;
import com.akhambir.service.ProductService;
import com.akhambir.web.Request;
import com.akhambir.web.ViewModel;

import java.util.List;

public class GetAllProductsAdminController implements Controller {

    private ProductService productService;

    public GetAllProductsAdminController(ProductService productService) {
        this.productService = productService;
    }


    @Override
    public ViewModel process(Request request) {
        List<Product> products = productService.findAll();
        ViewModel vm = ViewModel.of("manageProducts");
        vm.addAttribute("products", products);
        return vm;
    }
}
