package com.example.valou.ppe;

import java.util.ArrayList;

/**
 * Created by valou on 23/01/2018.
 */

public class Equipe {

    private int eq_id;
    private String eq_nom;
    private int a_id;
    private String eq_numTel;
    private ArrayList<Joueur> eq_lesjoueurs;

    public Equipe(int eq_id, String eq_nom, String eq_numtel,int a_id){
        this.eq_id = eq_id;
        this.eq_nom = eq_nom;
        this.eq_numTel = eq_numtel;
        this.a_id = a_id;
    }

    public int getEq_id() {
        return eq_id;
    }

    public String getEq_nom() {
        return eq_nom;
    }

    public void setEq_nom(String eq_nom) {
        this.eq_nom = eq_nom;
    }

    public int getEq_avatar() {
        return a_id;
    }

    public void setEq_avatar(int a_id) {
        this.a_id = a_id;
    }

    public ArrayList<Joueur> getEq_lesjoueurs() {
        return eq_lesjoueurs;
    }

    public void setEq_lesjoueurs(ArrayList<Joueur> eq_lesjoueurs) {
        this.eq_lesjoueurs = eq_lesjoueurs;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getEq_numTel() {
        return eq_numTel;
    }

    public void setEq_numTel(String eq_numTel) {
        this.eq_numTel = eq_numTel;
    }
}
