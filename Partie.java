package com.example.valou.ppe;

import java.util.ArrayList;

/**
 * Created by valou on 23/01/2018.
 */

public class Partie {

    private int p_id;
    private int p_score;
    private ArrayList<Objectif> LesObjectifs;
    private int e_id;

    public Partie(int p_id, int p_score, int e_id){
        this.p_id = p_id;
        this.p_score = p_score;
        this.e_id = e_id;
    }

    public int getP_id() {
        return p_id;
    }

    public int getP_score() {
        return p_score;
    }

    public void setP_score(int p_score) {
        this.p_score = p_score;
    }

    public ArrayList<Objectif> getLesObjectifs() {
        return LesObjectifs;
    }

    public void setLesObjectifs(ArrayList<Objectif> lesObjectifs) {
        LesObjectifs = lesObjectifs;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }
}
