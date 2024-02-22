package com.example.ecom.dao;

import com.example.ecom.modele.ProduitModele;

import java.util.List;

public interface ProduitInt {
    public void connexion();
    public boolean  createProduit(String nom,String description);
    public List<ProduitModele> getProduit(int id);
    public boolean updateProduit(int id,String nom,String description);
    public boolean deleteProduit(int id);
    public boolean close();
}
