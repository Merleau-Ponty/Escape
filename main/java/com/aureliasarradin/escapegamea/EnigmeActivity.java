package com.aureliasarradin.escapegamea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnigmeActivity extends AppCompatActivity {
    TextView afficherEnigme = null;
    EditText insererReponse = null;
    Button buttonValider = null;
    Button buttonIndice = null;
    Button buttonAide = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme);

        buttonValider = (Button) findViewById(R.id.xbtn_valider);
        buttonValider.setEnabled(true);

        Bundle extras = getIntent().getExtras();
        String idEnigme = extras.getString("idEnigme");

        //buttonValider.setOnClickListener(new View.OnClickListener() {
        // button1.setOnClickListener(){
            /*@Override
            public void onClick(View v) {
                setContentView(R.layout.enigme);
                Intent Enigme = new Intent(getApplicationContext(), Enigme.class);
            }*/
        //});
    }
}

