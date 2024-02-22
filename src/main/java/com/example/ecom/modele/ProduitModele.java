package com.example.ecom.modele;


public class ProduitModele {
    private int id;
    private  String nom;
    private String discription;
    public ProduitModele(){

    }
    public int getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public String getDiscription(){
        return  discription;
    }
    public void setId(int id){
        this.id=id;

    }
    public  void setNom(String nom){
        this.nom=nom;

    }
    public void setDiscription(String discription){
        this.discription=discription;
    }

}
