package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

public class    FormPermeametroCargaVariable extends AppCompatActivity {

    EditText longMuestra, areaSecTransversal, areaBureta, tiempoPrueba, h, h1, resultado;

    Button calcular;

    double almLongMuestra, almAreaSecTransversal, almAreaBureta, almTiempoPrueba, almH, almH1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_permeametro_carga_variable);

        longMuestra = (EditText) findViewById(R.id.permVariableLongMuestra);
        areaSecTransversal = (EditText) findViewById(R.id.permVariableAreaSeccTransversal);
        areaBureta = (EditText) findViewById(R.id.permVariableAreaBureta);
        tiempoPrueba = (EditText) findViewById(R.id.permVariableTiempoPrueba);
        h = (EditText) findViewById(R.id.permVariableH);
        h1 = (EditText) findViewById(R.id.permVariableH1);

        resultado = (EditText) findViewById(R.id.resultadoPermCargaVariable);

        calcular = (Button) findViewById(R.id.calPermVariable);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almLongMuestra = Double.parseDouble(longMuestra.getText().toString());
                almAreaSecTransversal = Double.parseDouble(areaSecTransversal.getText().toString());
                almAreaBureta = Double.parseDouble(areaBureta.getText().toString());
                almTiempoPrueba = Double.parseDouble(tiempoPrueba.getText().toString());
                almH = Double.parseDouble(h.getText().toString());
                almH1 = Double.parseDouble(h1.getText().toString());

                resultado.setText(calcularCoefPerm(almLongMuestra,almAreaSecTransversal,almAreaBureta,almTiempoPrueba,almH,almH1)+"");


            }
        });
    }
    public double calcularCoefPerm (double longMuestra, double areaSeccTransversal, double areaBureta, double tiempoPrueba, double h, double h1){
        return ((areaBureta*longMuestra)/(areaSeccTransversal*tiempoPrueba))*(Math.log(h) / Math.log(h1));
    }
}