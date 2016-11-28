package com.example.administrator.myapplication.data;

/**
 * Created by xiaojay on 2016/11/25.
 */
public class User {
    private String userName;
    private String passWd;
    public User(String userName, String passWd){
        this.userName = userName;
        this.passWd = passWd;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassWd(String passWd){
        this.passWd = passWd;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassWd(){
        return passWd;
    }
}
