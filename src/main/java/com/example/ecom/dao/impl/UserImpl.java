package com.example.ecom.dao.impl;
import com.example.ecom.dao.UserInt;
import com.example.ecom.modele.UserModele;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class UserImpl implements UserInt {
    private Connection con=null;
    public UserImpl(){
        connexion();
    }

    @Override
    public void  connexion() {
        String pilot="com.mysql.cj.jdbc.Driver";
        String DB = "jdbc:mysql://mysql-3a17bb18-fahlaouimohammed-0d14.a.aivencloud.com:18736/e-comm";

        try{
            Class.forName(pilot);
            this.con= DriverManager.getConnection(DB,"avnadmin","AVNS_UZIMfdcPHMAOUps-eD7");
        }catch (SQLException |ClassNotFoundException e){
            e.printStackTrace();

        }

    }

    @Override
    public boolean createUser(UserModele user) {
        try {
            connexion();

            PreparedStatement inst = con.prepareStatement("INSERT INTO user(nom,prenom,email,password) values(?,?,?,?)");
            inst.setString(1,user.getNom());
            inst.setString(2,user.getPrenom());
            inst.setString(3,user.getEmail());
            inst.setString(4,user.getPassword());
            inst.execute();
            return true;
        }catch(SQLException e){
            return  false;
        }
    }

    @Override
    public List<UserModele> getUser(int id) {
        connexion();
        List<UserModele> users=null;
        try {


            PreparedStatement inst = con.prepareStatement("SELECT * from user WHERE id=?");
            inst.setInt(1,id);

            ResultSet result=inst.executeQuery();

            while (result.next()){

                UserModele user = new UserModele();
                user.setNom(result.getString("nom"));
                user.setPrenom(result.getString("prenom"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));


                users.add(user);


            }
            return users;


        }catch(SQLException e){
            return users;
        }
    }

    @Override
    public List<UserModele> getUser(String email,String pass) {
        connexion();
        List<UserModele> users = new Vector<UserModele>();
        try {


            PreparedStatement inst = con.prepareStatement("SELECT * from user WHERE email like ? and password like ?");
            inst.setString(1,email);
            inst.setString(2,pass);

            ResultSet result=inst.executeQuery();

            while (result.next()){

                UserModele user = new UserModele();
                user.setNom(result.getString("nom"));
                user.setPrenom(result.getString("prenom"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));



                users.add(user);


            }
            return users;


        }catch(SQLException e){
            return users;
        }
    }

    @Override
    public boolean updateUser(UserModele user) {

        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean close() {
        return false;
    }
}
