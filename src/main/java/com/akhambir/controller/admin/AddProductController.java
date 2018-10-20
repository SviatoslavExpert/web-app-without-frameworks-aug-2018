package com.akhambir.controller.admin;

import com.akhambir.controller.Controller;
import com.akhambir.model.Category;
import com.akhambir.model.Product;
import com.akhambir.service.ProductService;
import com.akhambir.web.Request;
import com.akhambir.web.ViewModel;

import java.util.List;

public class AddProductController implements Controller {

    private final ProductService productService;

    public AddProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request request) {
        String productName = request.getParamByName("productName");
        double price = Double.valueOf(request.getParamByName("price"));
        String description = request.getParamByName("description");
        long categoryId = Long.valueOf(request.getParamByName("categoryId"));

        Product product = new Product(productName, price, description);
        Category category = new Category();
        category.setId(categoryId);
        product.setCategory(category);

        productService.save(product);

        List<Product> products = productService.findAll();

        ViewModel vm = ViewModel.of("manageProducts");
        vm.addAttribute("products", products);

        return vm;
    }
}
