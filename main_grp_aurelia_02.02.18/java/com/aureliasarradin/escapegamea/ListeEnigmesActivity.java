package com.aureliasarradin.escapegamea;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import metier.Enigme;
import metier.Objectif;
import support.DAO_Global;

//Cette activity est lancée lorsqu'on a choisi l'Objectif dans la listeObjectifsActivity
public class ListeEnigmesActivity extends ListActivity implements AdapterView.OnItemClickListener {

    Objectif ox;
    ArrayList<String> lesEnigmesObj ;

    TextView nomObjectif;
    TextView descrObjectif;
    //ListView listeEnigmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_enigmes);

        //on récupère le nom de l'Objectif sélectionné
        //et la description de l'Objectif
        Bundle extras = getIntent().getExtras();

        String id_obj = extras.getString("o_id");
        String nom = extras.getString("o_nom");
        String descr = extras.getString("o_description");

        //on affiche les deux
        nomObjectif= (TextView) findViewById(R.id.xnom_obj);


        //on affiche la liste des énigmes de l'Objectif
        liste_enigmes(id_obj);

        //adapter pour lier la Collection et la ListView
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesEnigmesObj);
        setListAdapter(adapt);

        //c'est l'héritage de ListActivity qui permet d'avoir la méthode getListView()
        getListView().setOnItemClickListener(this); //il set depuis notre méthode overriden

    }//fin onCreate()


    protected void liste_enigmes(String nom){
        //on prend dans la BDD les énigmes de l'Objectif sélectionné
        //int id_o = (int) Integer.parseInt(id_obj);
        lesEnigmesObj = new ArrayList<>();

        DAO_Global dao = new DAO_Global(this);

        ox = (Objectif) dao.donneObjectif(nom) ;//on utilise la requête pour prendre l'objectif where id=id_obj

        for(Enigme ex : ox.getLesEnigmes()){
            lesEnigmesObj.add(ex.getE_titre());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
