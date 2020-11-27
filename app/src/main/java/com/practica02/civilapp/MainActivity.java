package com.practica02.civilapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Opciones del Menu
    CardView contHumedad;
    CardView limContraccion;
    CardView denMax;
    CardView denMin;
    CardView gravEspSolidos;
    CardView denNatParafina;
    CardView permCargaConstante;
    CardView permCargaVariable;

    //Etiquetas del menu
    TextView textContHumedad;
    TextView textLimContraccion;
    TextView textDenMax;
    TextView textDenMin;
    TextView textGravEspSolidos;
    TextView textDenNatParafina;
    TextView textPermCargaConstante;
    TextView textPermCargaVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contHumedad = (CardView) findViewById(R.id.contHumedad);
        limContraccion = (CardView) findViewById(R.id.limContraccion);
        denMax = (CardView) findViewById(R.id.denMax);
        denMin = (CardView) findViewById(R.id.denMin);
        gravEspSolidos = (CardView) findViewById(R.id.gravEspSolidos);
        denNatParafina = (CardView) findViewById(R.id.denNatParafina);
        permCargaConstante = (CardView) findViewById(R.id.permCargaConstante);
        permCargaVariable = (CardView) findViewById(R.id.permCargaVariable);

        textContHumedad = (TextView) findViewById(R.id.textContHumedad);
        textLimContraccion = (TextView) findViewById(R.id.textLimContraccion);
        textDenMax = (TextView) findViewById(R.id.textDenMax);
        textDenMin = (TextView) findViewById(R.id.textDenMin);
        textGravEspSolidos = (TextView) findViewById(R.id.textGravEspSolidos);
        textDenNatParafina = (TextView) findViewById(R.id.textDenNatParafina);
        textPermCargaConstante = (TextView) findViewById(R.id.textPermCargaConstante);
        textPermCargaVariable = (TextView) findViewById(R.id.textPermCargaVariable);

        contHumedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textContHumedad.getText().toString());
                startActivity(i);
            }
        });
        limContraccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textLimContraccion.getText().toString());
                startActivity(i);
            }
        });
        denMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textDenMax.getText().toString());
                startActivity(i);
            }
        });
        denMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textDenMin.getText().toString());
                startActivity(i);
            }
        });
        gravEspSolidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textGravEspSolidos.getText().toString());
                startActivity(i);
            }
        });
        denNatParafina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textDenNatParafina.getText().toString());
                startActivity(i);
            }
        });
        permCargaConstante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textPermCargaConstante.getText().toString());
                startActivity(i);
            }
        });
        permCargaVariable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Opciones.class);
                i.putExtra("name", textPermCargaVariable.getText().toString());
                startActivity(i);
            }
        });

    }
}