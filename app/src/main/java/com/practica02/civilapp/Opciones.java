package com.practica02.civilapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.practica02.civilapp.informacion.ContenidoHumedad;
import com.practica02.civilapp.informacion.DensidadMaxima;
import com.practica02.civilapp.informacion.DensidadMinima;
import com.practica02.civilapp.informacion.DensidadNatural;
import com.practica02.civilapp.informacion.GravedadEspecifica;
import com.practica02.civilapp.informacion.LimiteContraccion;
import com.practica02.civilapp.informacion.PermeametroCargaConstante;
import com.practica02.civilapp.informacion.PermeametroCargaVariable;

public class Opciones extends AppCompatActivity {

    private TextView titleMenu;
    CardView info;
    CardView calcular;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        info = (CardView) findViewById(R.id.info);
        calcular = (CardView) findViewById(R.id.calcular);

        titleMenu = (TextView) findViewById(R.id.titleMenu);

        String dato = getIntent().getStringExtra("name");
        String cadena = quitarSaltos(dato);
        Log.d("prueba",cadena);
        titleMenu.setText(dato);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                if(cadena.equalsIgnoreCase("CONTENIDO DE HUMEDAD")){
                    i = new Intent(Opciones.this, ContenidoHumedad.class);
                }else if(cadena.equalsIgnoreCase("LÍMITE DE CONTRACCIÓN")){
                    i = new Intent(Opciones.this, LimiteContraccion.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD MÁXIMA")){
                    i = new Intent(Opciones.this, DensidadMaxima.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD MÍNIMA")){
                    i = new Intent(Opciones.this, DensidadMinima.class);
                }else if(cadena.equalsIgnoreCase("GRAVEDAD ESPECÍFICA DE LOS SÓLIDOS")){
                    i = new Intent(Opciones.this, GravedadEspecifica.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD NATURAL CON PARAFINA")){
                    i = new Intent(Opciones.this, DensidadNatural.class);
                }else if(cadena.equalsIgnoreCase("PERMEAMETRO DE CARGA CONSTANTE")){
                    i = new Intent(Opciones.this, PermeametroCargaConstante.class);
                }else if(cadena.equalsIgnoreCase("PERMEAMETRO DE CARGA VARIABLE")){
                    i = new Intent(Opciones.this, PermeametroCargaVariable.class);
                }
                startActivity(i);
            }
        });

        if(dato.equalsIgnoreCase("CONTENIDO DE HUMEDAD")){
            titleMenu.setText(dato);
        }else if(dato.equalsIgnoreCase("LÍMITE DE CONTRACCIÓN")){
            titleMenu.setText(dato);
        }
    }
    public String quitarSaltos(String cadena) {
        // Para el reemplazo usamos un string vacío
        return cadena.replaceAll("\n", "");
    }
}