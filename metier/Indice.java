package metier;

/**
 * Created by Sonia on 23/01/2018.
 */

public class Indice {

    private int i_id;
    private String i_libelle;
    private int i_penalite;
    private String i_type;

    private String i_force; //indice faible, moyen, fort

    //constructeur
    public Indice(int i_id, String i_libelle, String i_type, String i_force){
        this.i_id = i_id;
        this.i_libelle = i_libelle;
        this.i_force = i_force;

        //pénalité
        if(i_force.equals("faible")){ //indice faible
            //pas de pénalité mais entraîne l'absence de bonus à l'objectif
            //déjà initialisée à 0
            i_penalite = 0;
        } else if(i_force.equals("moyen")){//indice moyen, -100pts
            i_penalite = 100;
        }
        else{ //indice fort, -250 pts
            i_penalite = 250;
        }
        this.i_type = i_type;
    }//fin constructeur

    public int getI_id() {
        return i_id;
    }

    public String getI_libelle() {
        return i_libelle;
    }

    public void setI_libelle(String i_libelle) {
        this.i_libelle = i_libelle;
    }

    public int getI_penalite() {
        return i_penalite;
    }

    public String getI_force() {
        return i_force;
    }

    public String getI_type() {
        return i_type;
    }

    public void setI_type(String i_type) {
        this.i_type = i_type;
    }
}
