package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

public class FormPermeametroCargaConstante extends AppCompatActivity {

    EditText volAgua, longMuestra, areaSeccTransversal, altCargaHidraulica, tiempo, resultado;

    Button calcular;

    double almVolAgua, almLongMuestra, almAreaSeccTransversal, almAltCargaHidraulica, almTiempo, almResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_permeametro_carga_constante);

        volAgua = (EditText) findViewById(R.id.permConstanteVolumenAgua);
        longMuestra = (EditText) findViewById(R.id.permConstanteLongMuestra);
        areaSeccTransversal = (EditText) findViewById(R.id.permConstanteAreaSeccTransversal);
        altCargaHidraulica = (EditText) findViewById(R.id.permConstanteAltCargaHidraulica);
        tiempo = (EditText) findViewById(R.id.permConstanteTiempo);

        resultado = (EditText) findViewById(R.id.resultadoPermCargaConstante);

        calcular = (Button) findViewById(R.id.calPermConstante);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                almVolAgua = Double.parseDouble(volAgua.getText().toString());
                almLongMuestra = Double.parseDouble(longMuestra.getText().toString());
                almAreaSeccTransversal = Double.parseDouble(areaSeccTransversal.getText().toString());
                almAltCargaHidraulica = Double.parseDouble(altCargaHidraulica.getText().toString());
                almTiempo = Double.parseDouble(tiempo.getText().toString());

                resultado.setText(calcularCoefPerm(almVolAgua,almLongMuestra,almAreaSeccTransversal,almAltCargaHidraulica,almTiempo)+"");
                
            }
        });
    }
    public double calcularCoefPerm (double volAgua, double longMuestra, double areaSeccTransversal, double altCargaHiadraulica, double tiempo){
        return (volAgua*longMuestra)/(areaSeccTransversal*altCargaHiadraulica*tiempo);
    }
}