package com.aureliasarradin.escapegamea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import metier.DemandeIntervention;
import metier.Enigme;
import metier.Equipe;
import support.DAO_Global;


//Activity qui permet d'accéder au classement des équipes par score de Partie
//par tri : ordre décroissant (du plus grand au plus petit score d'équipe)
public class ClassementActivity extends AppCompatActivity {

    ArrayList<Equipe> lesEquipes ;
    DAO_Global dao = new DAO_Global(this);

    //pour associer le score de la partie à une équipe
    Map<Equipe, Integer> equipesScore = new HashMap<Equipe, Integer>();

    Map<Equipe, Integer> equipesScoreOrd = new HashMap<Equipe, Integer>();

    ArrayList<Integer> lesScores ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        //on initialise lesEquipes avec chaque équipe de la BDD
        lesEquipes = dao.donneLesEquipes();


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



    }
}
