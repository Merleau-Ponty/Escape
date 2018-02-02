package com.example.alicia.timesflies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 26/01/2018.
 */

public class ListeObjectif extends ListActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> lesObjectifs = new ArrayList<String>();
    private ListView listV;
    GestionBD sgbd;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_objectif);
        sgbd = new GestionBD(this);
        init_liste();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesObjectifs   );
       // listV = findViewById(R.id.listObj);
       // listV.setAdapter(adapter);
       setListAdapter(adapter);
       getListView().setOnItemClickListener(this);
    }

    protected void init_liste(){
        lesObjectifs.add("Objectif #1");
        lesObjectifs.add("Objectif #2");
        lesObjectifs.add("Objectif #3");
        lesObjectifs.add("Objectif #4");
        //lesObjectifs = sgbd.getLesObjectifs();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast msg = null;
        msg.makeText(getApplicationContext(),""+i,Toast.LENGTH_LONG).show();
        Intent enigme = new Intent(getApplicationContext(), ListeEnigmesActivity.class);
        enigme.putExtra("o_id", lesObjectifs.get(i));
        enigme.putExtra("o_nom", lesObjectifs.get(i));
        enigme.putExtra("o_description", lesObjectifs.get(i));
        startActivity(enigme);

    }






}
