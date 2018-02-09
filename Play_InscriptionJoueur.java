package com.lmp.timeflies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Utilisateur on 23/01/2018.
 */

public class Play_InscriptionJoueur extends Activity {

    EditText nom;
    Button play;
    EditText num;
    TextView selection;
    ArrayList<Equipe> lesEquipe = new ArrayList<>();
    long test = 0;
    int id_a = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        final GridView gridview = (GridView) findViewById(R.id.avatars);
        gridview.setAdapter(new ImageAdapter(this));
        //mettre la séléction de l'item à la position 0 de base
        gridview.setSelection(0);

        selection = (TextView) findViewById(R.id.selection);

        //Quand on clique sur un item du gridview
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Play_InscriptionJoueur.this, "avatar n°" + (position + 1),
                        Toast.LENGTH_SHORT).show();

               test = gridview.getItemIdAtPosition(position);
               //convertir test en int
               id_a = Integer.parseInt(new Long(test).toString());

               selection.setText("Avatar n°" + (id_a + 1));

            }
        });

        //ajouter le boutton jouer
        play = (Button) findViewById(R.id.play);

        //Edit text du nom de l'équipe
        nom = (EditText) findViewById(R.id.nom);
        //récupérer la valeur entrée pour le nom de l'équipe
        final String nomEquipe = nom.getText().toString();

        //Edit Text du numéro de téléphone
        num = (EditText) findViewById(R.id.num);
        //récupérer le numéro de téléphone
        final String numeroTel = num.getText().toString();

        //savoir combien d'équipe sont enregistrées
        final int nombreEquipe = lesEquipe.size();

        //quand on clique sur le bouton
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //appelle de la fonction d'insertion de l'équipe
                Equipe uneEquipe = new Equipe (nombreEquipe + 1, nomEquipe, numeroTel, id_a + 1);

                //retour à l'accueil
                Intent laccueil = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(laccueil);

            }
        });

    }
    }

