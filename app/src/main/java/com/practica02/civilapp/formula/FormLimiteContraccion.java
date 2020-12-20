package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

import java.text.DecimalFormat;

public class FormLimiteContraccion extends AppCompatActivity {

    EditText contHumedad;
    EditText pesoMercurio;
    EditText pesoMercurioRebalsado;
    EditText pesoMuestraSeca;
    EditText pesoEspecificoMercurio;
    EditText resultadoLimContrac;

    Button calcular;

    double almContHumedad, almPesoMercurio, almPesoMercRebalsado, almMuestraSeca, almPesoEspMerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_limite_contraccion);

        contHumedad = (EditText) findViewById(R.id.limContracContHumedad);
        pesoMercurio= (EditText) findViewById(R.id.limContracPesoMercurio);
        pesoMercurioRebalsado = (EditText) findViewById(R.id.limContracPesoMercurioRebalsado);
        pesoMuestraSeca = (EditText) findViewById(R.id.limContracPesoMuestraSeca);
        pesoEspecificoMercurio = (EditText) findViewById(R.id.limContracPesoEspecMercurio);
        resultadoLimContrac = (EditText) findViewById(R.id.resultadoLimContrac);

        calcular = (Button) findViewById(R.id.calLimContrac);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almContHumedad = Double.parseDouble(contHumedad.getText().toString());
                almPesoMercurio = Double.parseDouble(pesoMercurio.getText().toString());
                almPesoMercRebalsado = Double.parseDouble(pesoMercurioRebalsado.getText().toString());
                almMuestraSeca = Double.parseDouble(pesoMuestraSeca.getText().toString());
                almPesoEspMerc = Double.parseDouble(pesoEspecificoMercurio.getText().toString());

                DecimalFormat formato = new DecimalFormat("#.###");

                resultadoLimContrac.setText(formato.format(calcularLimContrac(almContHumedad,almPesoMercurio,almPesoMercRebalsado,almMuestraSeca,almPesoEspMerc))+"");


            }
        });
    }
    public double calcularLimContrac(double contHumedad, double pesoMercurio, double pesoMercurioRebal, double muestraSeca, double pesoEspMerc){
        return contHumedad - (((pesoMercurio*pesoEspMerc-pesoMercurioRebal*pesoEspMerc)+1)/muestraSeca)*100;
    }
}