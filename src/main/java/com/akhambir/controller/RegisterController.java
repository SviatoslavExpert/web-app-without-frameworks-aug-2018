package com.akhambir.controller;

import com.akhambir.model.User;
import com.akhambir.service.UserService;
import com.akhambir.web.Request;
import com.akhambir.web.ViewModel;

public class RegisterController implements Controller {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        String email = request.getParamByName("email");
        String password = request.getParamByName("password");
        User user = new User(email, password);
        ViewModel vm = ViewModel.of("welcome");
        vm.addAttribute("user", userService.addUser(user));
        return vm;
    }
}
