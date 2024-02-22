package com.example.ecom.dao.impl;
import com.example.ecom.dao.ProduitInt;

import java.sql.SQLException;
import  java.sql.*;
import java.util.List;
import com.example.ecom.modele.ProduitModele;

public class ProduitImpl implements ProduitInt {
    private Connection con ;
    public ProduitImpl(){
        connexion();
    }
    @Override
    public void connexion(){
        String pilot="com.mysql.cj.jdbc.Driver";
        String DB = "jdbc:mysql://mysql-3a17bb18-fahlaouimohammed-0d14.a.aivencloud.com:18736/e-comm";

        try{
            con=DriverManager.getConnection(DB,"avnadmin","AVNS_UZIMfdcPHMAOUps-eD7");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public boolean  createProduit(String nom,String description){
        try {


            PreparedStatement inst = con.prepareStatement("INSERT INTO personne(nom,description) values(?,?)");
            inst.setString(1,nom);
            inst.setString(2,description);
            inst.execute();
            return true;
        }catch(SQLException e){
            return  false;
        }


    }
    @Override
    public List<ProduitModele> getProduit(int id){
        List<ProduitModele> Produits=null;
        try {


            PreparedStatement inst = con.prepareStatement("SELECT * from produit WHERE id=?");
            inst.setInt(1,id);

            ResultSet result=inst.executeQuery();

            while (result.next()){

                     ProduitModele produit = new ProduitModele();
                     produit.setNom(result.getString("nom"));
                     produit.setDiscription(result.getString("description"));


                     Produits.add(produit);


            }
            return Produits;


        }catch(SQLException e){
            return Produits;
        }
    }
    @Override
    public boolean updateProduit(int id,String nom,String description){
        try {


            PreparedStatement inst = con.prepareStatement("UPDATE  personne set non=?,description=? where id=?");
            inst.setString(1,nom);
            inst.setString(2,description);
            inst.setInt(3,id);
            inst.execute();
            return true;
        }catch(SQLException e){
            return  false;
        }
    }
    @Override
    public boolean deleteProduit(int id){
        try {


            PreparedStatement inst = con.prepareStatement("DELETE personne where id=?");

            inst.setInt(3,id);
            inst.execute();
            return true;
        }catch(SQLException e){
            return  false;
        }
    }
    @Override
    public boolean close(){
        if (con!=null){
            try {
                con.close();
                return true;

            }catch(SQLException e){
                return  false;
            }
        }
       return false;
    }

}
