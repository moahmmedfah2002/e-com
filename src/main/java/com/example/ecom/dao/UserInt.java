package com.example.ecom.dao;

import com.example.ecom.modele.ProduitModele;
import com.example.ecom.modele.UserModele;

import java.util.List;

public interface UserInt {
    public void connexion();
    public boolean  createUser(UserModele user);
    public List<UserModele> getUser(int id);
    public boolean updateUser(UserModele user);
    public boolean deleteUser(int id);
    public List<UserModele> getUser(String email,String pass);

    public boolean close();
}
