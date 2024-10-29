package com.example.banking.service;

import com.example.banking.entity.User;
import com.example.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.banking.exceptionHandling.UserNotFound;
import com.example.banking.exceptionHandling.IncorrectEmailPass;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserServiceInf {
    @Autowired
    UserRepository userrepo;

    @Override
    public String create(User user) {
        userrepo.save(user);
//        userrepo.findByEmail(user.getEmail());
        return "Account created Successfully";
    }

    @Override
    public User getbyId(long accNo) {
        Optional<User> u = userrepo.findById(accNo);
        return u.get();
    }

    @Override
    public List<User> getAll() {
        return userrepo.findAll();
    }




    @Override
    public String depositMoney(long accNo, Double money) {
        Optional<User> user = userrepo.findById(accNo);
        User us = user.get();
        Double totalbalance = us.getAccBal() + money;
        // us.setAccBal( (us.getAccBal()+money));
        us.setAccBal(totalbalance);
        userrepo.save(us);
        System.out.println("Amount added successfully");
        return "deposit success";
    }

    @Override
    public String withdrawMoney(long accNo, Double money) {
        Optional<User> user = userrepo.findById(accNo);
        User balance = user.get();
        Double totalbalance = balance.getAccBal() - money;
        balance.setAccBal(totalbalance);
        userrepo.save(balance);
        return "withdraw success";
    }
//    @Override
//    public String loginUser(String email, String password) {
//        User user = userrepo.getByEmail(email);
//        if (user == null) {
//            return "User not found with email: " + email;
//        }
//        if (!user.getPassword().equals(password)) {
//            return "Incorrect email or password";
//        }
//        return "Login successful";
//    }

    @Override
    public String loginUser(String email, String password) {
        User user = userrepo.getByEmail(email);
        if (user == null) {
            throw new UserNotFound("User not found with email: " + email);
        }
       if (!user.getPassword().equals(password)) {
           throw new IncorrectEmailPass("Incorrect email or password");
       }
        return "Login successful";
    }
}
