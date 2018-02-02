package metier;

import java.util.ArrayList;

public class Enigme {
    private int e_id;
    private int e_points;
    private String e_titre;
    private String e_texte;
    private String e_reponse;
    private Objectif leObjectif;
    private ArrayList<Indice> lesIndices;
    private int compteur=0;

    public Enigme(int e_id, int e_points, String e_titre, String e_texte, String e_reponse, Objectif leObjectif){
        this.e_id = e_id;
        this.e_points = 1750 / leObjectif.getLesEnigmes().size();
        this.e_titre = e_titre;
        this.e_texte = e_texte;
        this.e_reponse = e_reponse;
        this.leObjectif = leObjectif;
    }


    public int getE_id() {
        return e_id;
    }

    public int getE_points() {
        return e_points;
    }

    public void setE_points(int e_points) {
        this.e_points = e_points;
    }

    public String getE_titre() {
        return e_titre;
    }

    public void setE_titre(String e_titre) {
        this.e_titre = e_titre;
    }

    public String getE_texte() {
        return e_texte;
    }

    public void setE_texte(String e_texte) {
        this.e_texte = e_texte;
    }

    public String getE_reponse() {
        return e_reponse;
    }

    public void setE_reponse(String e_reponse) {
        this.e_reponse = e_reponse;
    }

    public ArrayList<Indice> getLesIndices() {
        return lesIndices;
    }

    public void setLesIndices(ArrayList<Indice> lesIndices) {
        lesIndices = lesIndices;
    }

    public void setCompteurIndice( int compteur){
        compteur+=1;
    }
    public int getCompteurIndice(){
        return compteur;
    };
}
