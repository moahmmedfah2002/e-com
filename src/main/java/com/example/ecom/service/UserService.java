package com.example.ecom.service;

import com.example.ecom.dao.impl.UserImpl;
import com.example.ecom.modele.UserModele;

import java.util.List;

public class UserService {
    private UserImpl user;
    private  List<UserModele> L=null;
    public UserService(){
        user=new UserImpl();
    }
    public boolean Login(UserModele user){
        List<UserModele> L= this.user.getUser(user.getEmail(),user.getPassword());
        if(L.isEmpty()){
            return false;
        }else {
            return true;
        }

    }
    public boolean Logup(UserModele user){
        return  this.user.createUser(user);
    }
}
