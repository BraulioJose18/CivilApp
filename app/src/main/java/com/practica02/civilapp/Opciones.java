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

import com.practica02.civilapp.formula.FormContenidoHumedad;
import com.practica02.civilapp.formula.FormDensidadMaxima;
import com.practica02.civilapp.formula.FormDensidadMinima;
import com.practica02.civilapp.formula.FormDensidadNatural;
import com.practica02.civilapp.formula.FormGravedadEspecifica;
import com.practica02.civilapp.formula.FormLimiteContraccion;
import com.practica02.civilapp.formula.FormPermeametroCargaConstante;
import com.practica02.civilapp.formula.FormPermeametroCargaVariable;
import com.practica02.civilapp.informacion.InfoContenidoHumedad;
import com.practica02.civilapp.informacion.InfoDensidadMaxima;
import com.practica02.civilapp.informacion.InfoDensidadMinima;
import com.practica02.civilapp.informacion.InfoDensidadNatural;
import com.practica02.civilapp.informacion.InfoGravedadEspecifica;
import com.practica02.civilapp.informacion.InfoLimiteContraccion;
import com.practica02.civilapp.informacion.InfoPermeametroCargaConstante;
import com.practica02.civilapp.informacion.InfoPermeametroCargaVariable;

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
        //Log.d("prueba",cadena);
        titleMenu.setText(dato);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                if(cadena.equalsIgnoreCase("CONTENIDO DE HUMEDAD")){
                    i = new Intent(Opciones.this, InfoContenidoHumedad.class);
                }else if(cadena.equalsIgnoreCase("LÍMITE DE CONTRACCIÓN")){
                    i = new Intent(Opciones.this, InfoLimiteContraccion.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD MÁXIMA")){
                    i = new Intent(Opciones.this, InfoDensidadMaxima.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD MÍNIMA")){
                    i = new Intent(Opciones.this, InfoDensidadMinima.class);
                }else if(cadena.equalsIgnoreCase("GRAVEDAD ESPECÍFICA DE LOS SÓLIDOS")){
                    i = new Intent(Opciones.this, InfoGravedadEspecifica.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD NATURAL CON PARAFINA")){
                    i = new Intent(Opciones.this, InfoDensidadNatural.class);
                }else if(cadena.equalsIgnoreCase("PERMEAMETRO DE CARGA CONSTANTE")){
                    i = new Intent(Opciones.this, InfoPermeametroCargaConstante.class);
                }else if(cadena.equalsIgnoreCase("PERMEAMETRO DE CARGA VARIABLE")){
                    i = new Intent(Opciones.this, InfoPermeametroCargaVariable.class);
                }
                startActivity(i);
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                if(cadena.equalsIgnoreCase("CONTENIDO DE HUMEDAD")){
                    i = new Intent(Opciones.this, FormContenidoHumedad.class);
                }else if(cadena.equalsIgnoreCase("LÍMITE DE CONTRACCIÓN")){
                    i = new Intent(Opciones.this, FormLimiteContraccion.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD MÁXIMA")){
                    i = new Intent(Opciones.this, FormDensidadMaxima.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD MÍNIMA")){
                    i = new Intent(Opciones.this, FormDensidadMinima.class);
                }else if(cadena.equalsIgnoreCase("GRAVEDAD ESPECÍFICA DE LOS SÓLIDOS")){
                    i = new Intent(Opciones.this, FormGravedadEspecifica.class);
                }else if(cadena.equalsIgnoreCase("DENSIDAD NATURAL CON PARAFINA")){
                    i = new Intent(Opciones.this, FormDensidadNatural.class);
                }else if(cadena.equalsIgnoreCase("PERMEAMETRO DE CARGA CONSTANTE")){
                    i = new Intent(Opciones.this, FormPermeametroCargaConstante.class);
                }else if(cadena.equalsIgnoreCase("PERMEAMETRO DE CARGA VARIABLE")){
                    i = new Intent(Opciones.this, FormPermeametroCargaVariable.class);
                }
                startActivity(i);
            }
        });

    }
    public String quitarSaltos(String cadena) {
        // Para el reemplazo usamos un string vacío
        return cadena.replaceAll("\n", "");
    }
}