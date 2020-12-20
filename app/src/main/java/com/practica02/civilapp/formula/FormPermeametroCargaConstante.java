package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

import java.text.DecimalFormat;

public class FormPermeametroCargaConstante extends AppCompatActivity {

    EditText volAgua, longMuestra, areaSeccTransversal, altCargaHidraulica, tiempo, resultado, diametro;

    Button calcular;

    double almVolAgua, almLongMuestra, almAreaSeccTransversal, almAltCargaHidraulica, almTiempo, almDiametro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_permeametro_carga_constante);

        volAgua = (EditText) findViewById(R.id.permConstanteVolumenAgua);
        longMuestra = (EditText) findViewById(R.id.permConstanteLongMuestra);
        diametro = (EditText) findViewById(R.id.permConstanteDiametro);
        altCargaHidraulica = (EditText) findViewById(R.id.permConstanteAltCargaHidraulica);
        tiempo = (EditText) findViewById(R.id.permConstanteTiempo);

        areaSeccTransversal = (EditText) findViewById(R.id.permConstanteAreaSeccTransversal);
        resultado = (EditText) findViewById(R.id.resultadoPermCargaConstante);

        calcular = (Button) findViewById(R.id.calPermConstante);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                almVolAgua = Double.parseDouble(volAgua.getText().toString());
                almLongMuestra = Double.parseDouble(longMuestra.getText().toString());
                almDiametro = Double.parseDouble(diametro.getText().toString());

                almAreaSeccTransversal = Math.PI*(Math.pow(almDiametro,2)/4);
                //almAreaSeccTransversal = Double.parseDouble(areaSeccTransversal.getText().toString());

                almAltCargaHidraulica = Double.parseDouble(altCargaHidraulica.getText().toString());
                almTiempo = Double.parseDouble(tiempo.getText().toString());

                DecimalFormat formato = new DecimalFormat("#.###");

                areaSeccTransversal.setText(formato.format(almAreaSeccTransversal)+"");
                resultado.setText(formato.format(calcularCoefPerm(almVolAgua,almLongMuestra,almAreaSeccTransversal,almAltCargaHidraulica,almTiempo))+"");
                
            }
        });
    }
    public double calcularCoefPerm (double volAgua, double longMuestra, double areaSeccTransversal, double altCargaHiadraulica, double tiempo){
        return (volAgua*longMuestra)/(areaSeccTransversal*altCargaHiadraulica*tiempo);
    }
}