package metier;

import java.util.ArrayList;

public class Objectif {
    private int o_id;
    private String o_nom;
    private String o_description;
    private int o_points_bonus;
    ArrayList<Enigme> lesEnigmes;

    public Objectif(int o_id, String o_nom, String o_description, int o_points_bonus){
        this.o_id = o_id;
        this.o_nom = o_nom;
        this.o_description = o_description;
        this.o_points_bonus = 0; //Initialisation à 750pts pour chaque objectif réussi sans indice.
    }

    // Getters et Setters
    public int getO_id() {
        return o_id;
    }

    public String getO_nom() { return o_nom; }

    public void setO_nom(String o_nom) {
        this.o_nom = o_nom;
    }

    public String getO_description() {
        return o_description;
    }

    public void setO_description(String o_description) {
        this.o_description = o_description;
    }

    public int getO_points_bonus() {
        for(Enigme e: lesEnigmes) {
            if (e.getCompteurIndice() >0) {
                o_points_bonus+= 0;
            } else {
                o_points_bonus+=750;
            }
        }
        return o_points_bonus;
    }

    public void setO_points_bonus(int o_points_bonus) {
        this.o_points_bonus = o_points_bonus;
    }

    public ArrayList<Enigme> getLesEnigmes() {
        return lesEnigmes;
    }

    public void setLesEnigmes(ArrayList<Enigme> lesEnigmes) {
        lesEnigmes = lesEnigmes;
    }

    //Méthodes

}
