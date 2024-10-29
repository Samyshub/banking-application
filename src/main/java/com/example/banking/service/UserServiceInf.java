package com.example.banking.service;

import com.example.banking.entity.User;
import com.example.banking.exceptionHandling.IncorrectEmailPass;
import com.example.banking.exceptionHandling.UserNotFound;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface UserServiceInf {
    String create(User user);

    User getbyId(long accNo);
    String depositMoney(long accNo, Double money);
    String withdrawMoney(long accNo, Double money);

    List<User> getAll();

//    String loginUser(String email, String password);

    String loginUser(String email, String password) throws UserNotFound, IncorrectEmailPass;

}
