package com.example.utilisateur.escapegame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Utilisateur on 23/01/2018.
 */

public class InscriptionJoueur extends Activity {

    EditText nom;
    Button play;
    EditText num;
    ArrayList<Avatar> lesAvatar = new ArrayList<Avatar>();
    ArrayList<Equipe> lesEquipe = new ArrayList<>();
    long test = 0;
    int id_a = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        final GridView gridview = (GridView) findViewById(R.id.avatars);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setSelection(1);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(InscriptionJoueur.this, "" + position,
                        Toast.LENGTH_SHORT).show();

               test = gridview.getItemIdAtPosition(position);
               //convertir test en int
               id_a = Integer.parseInt(new Long(test).toString());

            }
        });

        //ajouter le boutton jouer
        play = (Button) findViewById(R.id.play);
        //Edit text du nom de l'équipe
        nom = (EditText) findViewById(R.id.nom);
        final String nomEquipe = nom.getText().toString();
        //Edit Text du numéro de téléphone
        num = (EditText) findViewById(R.id.num);
        final String numeroTel = num.getText().toString();


        final int nombreEquipe = lesEquipe.size();


        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //appelle de la fonction d'insertion de l'équipe
                Equipe uneEquipe = new Equipe (nombreEquipe + 1, nomEquipe, numeroTel, id_a);

                //retour à l'accueil
                Intent laccueil = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(laccueil);

            }
        });

    }
    }

