package com.akhambir.service;

import com.akhambir.model.User;

public interface UserService {

    User addUser(User user);

    User findByEmail(String email);

    boolean validatePassword(User user, String password);
}
