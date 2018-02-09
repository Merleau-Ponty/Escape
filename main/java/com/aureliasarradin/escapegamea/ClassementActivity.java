package com.aureliasarradin.escapegamea;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import metier.Equipe;
import dao.DAO_Global;
import technique.HashMapAdapter;


//Activity qui permet d'accéder au classement des équipes par score de Partie
//par tri : ordre décroissant (du plus grand au plus petit score d'équipe)
public class ClassementActivity extends ListActivity {

    ArrayList<Equipe> lesEquipes ;
    DAO_Global dao = new DAO_Global(this);

    //pour associer le score de la partie à une équipe
    LinkedHashMap<Equipe, Integer> equipesScore = new LinkedHashMap<Equipe, Integer>();

    LinkedHashMap<Equipe, Integer> equipesScoreOrd = new LinkedHashMap<Equipe, Integer>();
    //LinkedHashMap<String,String> equipesScoreOrdString = new LinkedHashMap<String,String>();

    ArrayList<String> equipeScoreOrdonne = new ArrayList<String>();
    String nomEquipe;
    String scoreEquipe;
    int i=1;

    ArrayList<Integer> lesScores ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        //on initialise lesEquipes avec chaque équipe de la BDD
        lesEquipes = dao.donneLesEquipes();


        //ON VEUT LA LISTE : LE NOM DE L'EQUIPE + LE SCORE
        liste_equipesScoreOrd();

        //SI ON UTILISAIT L'HashMapAdapter
        //on nomme equipesScoreOrdString<lenomdelequipe,lescoredelequipe> (string,string)
        /*for (Map.Entry<Equipe, Integer> eso : equipesScoreOrd.entrySet()){
            equipesScoreOrdString.put(eso.getKey().getEq_nom(),Integer.toString(eso.getValue()));
        }*/


        //adapter pour lier la Collection et la ListView
        //HashMapAdapter<String, String> hashMapAdapter = new HashMapAdapter<String, String>(this, android.R.layout.simple_list_item_1, equipesScoreOrdString);
        //setListAdapter(hashMapAdapter);
        ArrayAdapter<String> hashMapAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipeScoreOrdonne);
        setListAdapter(hashMapAdapter);
    }//fin onCreate()

    protected void liste_equipesScoreOrd(){
        //pour chaque équipe on prélève son score
        for(Equipe e : lesEquipes){
            equipesScore.put(e,dao.donneLeScore(e));
            //on a notre HashMap(Equipe,son score)

            lesScores.add(dao.donneLeScore(e));
        }

        //faire le tri, en créant le nouveau HashMap
        //on garde le score max et on ajoute le couple équipe/score dans le hashmap
        for (Map.Entry<Equipe, Integer> es : equipesScore.entrySet()){
            //comparer la value à toutes les autres
            if(es.getValue()>= Collections.max(lesScores)){
                equipesScoreOrd.put(es.getKey(),es.getValue());
            }
        }


        //on peut sinon créer un arraylist avec le nom de l'équipe et le score
        //on parcourt le hashmap ordonné, on prend une string contenant (nom équipe - score)
        for(Map.Entry<Equipe, Integer> eso : equipesScoreOrd.entrySet()){
            nomEquipe=eso.getKey().getEq_nom();
            scoreEquipe=Integer.toString(eso.getValue());
            equipeScoreOrdonne.add(i+ ". Equipe :"+ nomEquipe + " - Score : " + scoreEquipe);
            i++;
        }
    }
}
