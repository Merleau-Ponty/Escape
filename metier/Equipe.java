package metier;

import android.widget.ImageView;

import java.util.ArrayList;

public class Equipe {
    private int eq_id;
    private String eq_nom;
    private ImageView eq_avatar;
    private ArrayList<Joueur> eq_lesjoueurs;

    public Equipe(int eq_id, String eq_nom, ImageView eq_avatar){
        this.eq_id = eq_id;
        this.eq_nom = eq_nom;
        this.eq_avatar = eq_avatar;
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

    public ImageView getEq_avatar() {
        return eq_avatar;
    }

    public void setEq_avatar(ImageView eq_avatar) {
        this.eq_avatar = eq_avatar;
    }

    public ArrayList<Joueur> getEq_lesjoueurs() {
        return eq_lesjoueurs;
    }

    public void setEq_lesjoueurs(ArrayList<Joueur> eq_lesjoueurs) {
        this.eq_lesjoueurs = eq_lesjoueurs;
    }
}
