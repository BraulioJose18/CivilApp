package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

public class FormDensidadMinima extends AppCompatActivity {

    EditText pesoMuestraMolde;
    EditText pesoMolde;
    EditText areaBase;
    EditText alturaMolde;
    EditText resultadoDenMax;

    Button calcular;

    String strPesoMuestraMolde = null, strPesoMolde = null, strAreaBase = null, strAlturaMolde = null;
    double almPesoMuestraMolde, almPesoMolde, almAreaBase, almAlturaMolde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_densidad_minima);

        pesoMuestraMolde = (EditText) findViewById(R.id.denMinPesoMuestraMolde);
        pesoMolde = (EditText) findViewById(R.id.denMinPesoMolde);
        areaBase = (EditText) findViewById(R.id.denMinAreaBase);
        alturaMolde = (EditText) findViewById(R.id.denMinAlturaMolde);
        resultadoDenMax = (EditText) findViewById(R.id.resultadoDenMin);

        calcular = (Button) findViewById(R.id.calDenMin);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strPesoMuestraMolde = pesoMuestraMolde.getText().toString();
                strPesoMolde = pesoMolde.getText().toString();
                strAreaBase = areaBase.getText().toString();
                strAlturaMolde = alturaMolde.getText().toString();

                almPesoMuestraMolde = Double.parseDouble(strPesoMuestraMolde);
                almPesoMolde = Double.parseDouble(strPesoMolde);
                almAreaBase = Double.parseDouble(strAreaBase);
                almAlturaMolde = Double.parseDouble(strAlturaMolde);

                resultadoDenMax.setText(calcularDensidadMinima(almPesoMuestraMolde,almPesoMolde,almAreaBase,almAlturaMolde)+"");
            }
        });

    }
    public double calcularDensidadMinima (double pesoMuestraMolde, double pesoMolde, double areaBase, double alturaMolde){
        return (pesoMuestraMolde-pesoMolde)/(areaBase*alturaMolde);
    }
}