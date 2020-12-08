package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

public class FormDensidadMaxima extends AppCompatActivity {

    EditText pesoMuestraMolde;
    EditText pesoMolde;
    EditText areaBase;
    EditText alturaMolde;
    EditText asentamiento;
    EditText resultadoDenMax;

    Button calcular;
    String strPesoMuestraMolde = null, strPesoMolde = null, strAreaBase = null, strAlturaMolde = null, strAsentamiento = null;
    double almPesoMuestraMolde, almPesoMolde, almAreaBase, almAlturaMolde, almAsentamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_densidad_maxima);

        pesoMuestraMolde = (EditText) findViewById(R.id.denMaxPesoMuestraMolde);
        pesoMolde = (EditText) findViewById(R.id.denMaxPesoMolde);
        areaBase = (EditText) findViewById(R.id.denMaxAreaBase);
        alturaMolde = (EditText) findViewById(R.id.denMaxAlturaMolde);
        asentamiento = (EditText) findViewById(R.id.denMaxAsentamiento);
        resultadoDenMax = (EditText) findViewById(R.id.resultadoDenMax);

        calcular = (Button) findViewById(R.id.calDenMax);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strPesoMuestraMolde = pesoMuestraMolde.getText().toString();
                strPesoMolde = pesoMolde.getText().toString();
                strAreaBase = areaBase.getText().toString();
                strAlturaMolde = alturaMolde.getText().toString();
                strAsentamiento = asentamiento.getText().toString();

                almPesoMuestraMolde = Double.parseDouble(strPesoMuestraMolde);
                almPesoMolde = Double.parseDouble(strPesoMolde);
                almAreaBase = Double.parseDouble(strAreaBase);
                almAlturaMolde = Double.parseDouble(strAlturaMolde);
                almAsentamiento = Double.parseDouble(strAsentamiento);

                resultadoDenMax.setText(calcularDensidadMaxima(almPesoMuestraMolde,almPesoMolde,almAreaBase,almAlturaMolde,almAsentamiento)+"");
            }
        });


    }

    public double calcularDensidadMaxima (double pesoMuestraMolde, double pesoMolde, double areaBase, double alturaMolde, double asentamiento){
        return (pesoMuestraMolde-pesoMolde)/(areaBase*(alturaMolde-asentamiento));
    }
}