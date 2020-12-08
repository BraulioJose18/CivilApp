package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

public class    FormPermeametroCargaVariable extends AppCompatActivity {

    EditText longMuestra, areaSecTransversal, diamMuestra, areaBureta, diamBureta, tiempoPrueba, h, h1, resultado;

    Button calcular;

    double almLongMuestra, almAreaSecTransversal, almAreaBureta, almTiempoPrueba, almH, almH1, almDiamMuestra, almDiamBureta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_permeametro_carga_variable);

        longMuestra = (EditText) findViewById(R.id.permVariableLongMuestra);
        diamMuestra = (EditText) findViewById(R.id.permVariableDiamMuestra);
        diamBureta = (EditText) findViewById(R.id.permVariableDiamBureta);
        tiempoPrueba = (EditText) findViewById(R.id.permVariableTiempoPrueba);
        h = (EditText) findViewById(R.id.permVariableH);
        h1 = (EditText) findViewById(R.id.permVariableH1);

        areaSecTransversal = (EditText) findViewById(R.id.permVariableAreaSeccTransversal);
        areaBureta = (EditText) findViewById(R.id.permVariableAreaBureta);
        resultado = (EditText) findViewById(R.id.resultadoPermCargaVariable);

        calcular = (Button) findViewById(R.id.calPermVariable);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almLongMuestra = Double.parseDouble(longMuestra.getText().toString());
                almDiamMuestra = Double.parseDouble(diamMuestra.getText().toString());
                almDiamBureta = Double.parseDouble(diamBureta.getText().toString());
                almH = Double.parseDouble(h.getText().toString());
                almH1 = Double.parseDouble(h1.getText().toString());
                almTiempoPrueba = Double.parseDouble(tiempoPrueba.getText().toString());

                almAreaSecTransversal = Math.PI*(Math.pow(almDiamMuestra,2)/4);
                almAreaBureta = Math.PI*(Math.pow(almDiamBureta,2)/4);

                //almAreaSecTransversal = Double.parseDouble(areaSecTransversal.getText().toString());
                //almAreaBureta = Double.parseDouble(areaBureta.getText().toString());


                areaSecTransversal.setText(almAreaSecTransversal+"");
                areaBureta.setText(almAreaBureta+"");
                resultado.setText(calcularCoefPerm(almLongMuestra,almAreaSecTransversal,almAreaBureta,almTiempoPrueba,almH,almH1)+"");


            }
        });
    }
    public double calcularCoefPerm (double longMuestra, double areaSeccTransversal, double areaBureta, double tiempoPrueba, double h, double h1){
        return ((areaBureta*longMuestra)/(areaSeccTransversal*tiempoPrueba))*(Math.log(h/h1));
    }
}