package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText poid,taille;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poid = findViewById(R.id.poids_text);
        taille = findViewById(R.id.taiile_text);
        ok = findViewById(R.id.ok_button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "votre IMC est : "+ calculeIMC() +" , votre etat est : " + etat(),Toast.LENGTH_LONG).show();
            }
        });

    }

    // La methode calcule() permettant da calculer l'IMC d'un personne
    public double calculeIMC(){
        double poid_valeu = Double.parseDouble(poid.getText().toString());
        double taille_valeu = Double.parseDouble(taille.getText().toString());

        double IMC = (poid_valeu/(taille_valeu*taille_valeu));
        return  IMC;
    }

    // La methode calcule() permettant da determiner l'etat d'un peresonne
    public String etat(){
        String etat = "";
        if(calculeIMC()<18.5){etat = "Maigreur";}
        else if(calculeIMC()>=18.5 && calculeIMC()<25){etat = "Normale";}
        else if(calculeIMC()<40 && calculeIMC()>=25){etat = "Supoids";}
        else if(calculeIMC()>=40 ){etat = "Obésité";}

        return etat;
    }
}