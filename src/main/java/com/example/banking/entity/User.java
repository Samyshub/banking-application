package com.example.banking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User_Details")
public class User {

    private String userName;
    private String email;
    private int phoneNum;




    @Id

    private long accNo;
    private String password;


    private Double accBal;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAccBal() {
        return accBal;
    }

    public void setAccBal(Double accBal) {
        this.accBal = accBal;
    }
    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

}
