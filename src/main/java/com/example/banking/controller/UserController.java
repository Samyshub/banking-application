package com.example.banking.controller;

import com.example.banking.entity.User;
import com.example.banking.service.UserServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceInf userInf;
    @PostMapping("/createacc")
    public String createAcc (@RequestBody User user){
        return userInf.create(user);
    }
    @GetMapping("getbyId/{accNo}")
    public User getDetailsById(@PathVariable Long accNo){
        return userInf.getbyId(accNo);
    }
    @GetMapping("/greturnetall")
    public List<User> getall(){
        return userInf.getAll();
    }
    @PutMapping("/deposit/{accNo}/{money}")
    public String depositAmount(@PathVariable Long accNo, @PathVariable Double money){
        return userInf.depositMoney(accNo,money);
    }
    @PutMapping("/withdraw/{accNo}/{money}")
    public String withdrawAmount(@PathVariable Long accNo , @PathVariable Double money){
        return userInf.withdrawMoney(accNo,money);
    }
    @PostMapping("/login")
    public String loginDetails(@RequestParam String email, @RequestParam String password)  {
        System.out.println("Email: " + email);
        return userInf.loginUser(email,password);
    }

}
