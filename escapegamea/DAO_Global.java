// package com.example.sonia.escapegame.Support;
package com.aureliasarradin.escapegamea;

/**
 * Created by Sonia on 30/01/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import metier.Enigme;
import metier.Equipe;
import metier.Indice;
import metier.Joueur;
import metier.Objectif;
import metier.Partie;

/**
 * Created by valou on 23/01/2018.
 */

public class DAO_Global {

    private SQLiteDatabase maBase;
    private BDHelper monBDHelper;

    public DAO_Global(Context context) {
        monBDHelper = new BDHelper(context, "baseppe", null, 1);
    }

    public void open() {
        maBase = monBDHelper.getWritableDatabase();
    }

    public void close() {
        maBase.close();
    }

    public long ajouteJoueur(Joueur unJoueur) {
        ContentValues v = new ContentValues();
        v.put("j_id", unJoueur.getJ_id());
        v.put("j_nom", unJoueur.getJ_nom());
        v.put("j_prenom", unJoueur.getJ_prenom());
        v.put("j_age", unJoueur.getJ_age());
        v.put("eq_id", unJoueur.getEq_id());
        return maBase.insert("joueur", null, v);
    }


    public long ajouteEquipe(Equipe equipe) {
        ContentValues v = new ContentValues();
        v.put("eq_id", equipe.getEq_id());
        v.put("eq_nom", equipe.getEq_nom());
        v.put("eq_numtel", equipe.getEq_numTel());
        v.put("a_id", equipe.getA_id());
        return maBase.insert("equipe", null, v);
    }

    public long ajoutePartie(Partie unePartie) {
        ContentValues v = new ContentValues();
        v.put("p_id", unePartie.getP_id());
        v.put("p_score", unePartie.getP_score());
        v.put("eq_id", unePartie.getEq_id());
        return maBase.insert("partie", null, v);
    }

    public long ajouteIndice(Indice unIndice) {
        ContentValues v = new ContentValues();
        v.put("i_id", unIndice.getI_id());
        v.put("i_libelle", unIndice.getI_libelle());
        v.put("i_penalite", unIndice.getI_penalite());
        v.put("i_type", unIndice.getI_type());
        v.put("e_id", unIndice.getE_id());
        return maBase.insert("indice", null, v);
    }

    public long ajouteEnigme(Enigme uneEnigme) {
        ContentValues v = new ContentValues();
        v.put("e_id", uneEnigme.getE_id());
        v.put("e_points", uneEnigme.getE_points());
        v.put("e_titre", uneEnigme.getE_titre());
        v.put("e_texte", uneEnigme.getE_texte());
        v.put("e_reponse", uneEnigme.getE_reponse());
        v.put("o_id", uneEnigme.getO_id());
        return maBase.insert("enigme", null, v);
    }

    public long ajouteAvatar(Avatar unAvatar) {
        ContentValues v = new ContentValues();
        v.put("a_id", unAvatar.getA_id());
        v.put("a_libelle", unAvatar.getA_libelle());
        v.put("a_nomfichier", unAvatar.getA_nomfichier());
        return maBase.insert("enigme", null, v);
    }

    public ArrayList<String> donneLesJoueurDuneEquipe(Equipe uneEquipe) {
        ArrayList<String> liste = new ArrayList<String>();
        Cursor c = maBase.rawQuery("select j_nom, j_prenom from joueur where eq_id = " + uneEquipe.getEq_id() + ";", null);
        while (c.moveToNext()){
            String nom = c.getString(0);
            String prenom = c.getString(1);
            liste.add(nom+" "+prenom);
        }
        if(liste == null){
            liste.add("Erreur de bdd!");
        }
        return liste;
    }

    public ArrayList<Indice> donneLesIndicesDuneEnigme(Enigme enigme){
        ArrayList<Indice> liste = new ArrayList<Indice>();
        Cursor c = maBase.rawQuery("select i_id, i_libelle, i_penalite, i_type from indice where e_id = "+enigme.getE_id()+";", null);
        while (c.moveToNext()){
            int id = c.getInt(0);
            String libelle = c.getString(1);
            int penalite = c.getInt(2);
            String type = c.getString(3);
            int e_id = enigme.getE_id();
            Indice indice = new Indice(id,libelle,type,e_id);
            liste.add(indice);
        }
        return liste;
    }

    public Partie donneLaPartieDuneEquipe(Equipe equipe){
        int id = 0;
        int score = 0;
        int e_id = 0;
        Cursor c = maBase.rawQuery("select p_id, p_score, e_id from equipe where e_id = "+equipe.getEq_id()+";", null);
        while (c.moveToNext()){
            id = c.getInt(0);
            score = c.getInt(1);
            e_id = equipe.getEq_id();
        }
        Partie laPartie = new Partie(id, score, e_id);
        return laPartie;
    }

    public ArrayList<ArrayList<String>> donneLesObjectifs() {
        ArrayList<ArrayList<String>> liste=new ArrayList();
        ArrayList<String> champ=new ArrayList();
        Cursor c = maBase.rawQuery("select o_nom, o_description from objectif;", null);
        int Compteur=0;
        //Exemple
        //[0][0] = Objectif 1 / [0][1] = Récupérer le passport
        //[1][0] = Objectif 2 / [1][1] = Récupérer les billets
        while (c.moveToNext()){
            String nom = c.getString(0);
            String description = c.getString(1);
            champ.add(nom);
            champ.add(description);
            liste.add(0, champ);
            Compteur+=1;
        }
        return liste;
    }

    //Renvoie un objet Objectif selon le nom de celui-ci
    public Objectif donneObjectif(String nom){
        int o_id = 0;
        String o_nom = "";
        String o_description = "";
        int o_points_bonus = 0;
        Cursor c = maBase.rawQuery("select o_id, o_nom, o_description, o_points_bonus from Objectif where o_nom = "+ nom +";", null);
        while (c.moveToNext()){
            o_id = c.getInt(0);
            o_nom = c.getString(1);
            o_description = c.getString(2);
            o_points_bonus = c.getInt(3);
        }
        Objectif lObjectif = new Objectif(o_id, o_nom, o_description, o_points_bonus);
        return lObjectif;
    }
}