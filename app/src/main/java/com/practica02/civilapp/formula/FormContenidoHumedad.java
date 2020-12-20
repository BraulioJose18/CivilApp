package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.practica02.civilapp.R;

import java.text.DecimalFormat;

public class FormContenidoHumedad extends AppCompatActivity {

    EditText contHumedad;
    EditText pesoMuestraHumeda;
    EditText pesoMuestraSeca;
    Button calcular;

    String strMuestraHumeda = null, strMuestraSeca = null;

    double almMuestraHumeda, almMuestraSeca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contenido_humedad);

        pesoMuestraHumeda = (EditText) findViewById(R.id.pesoMuestraHumeda);
        pesoMuestraSeca = (EditText) findViewById(R.id.pesoMuestraSeca);
        contHumedad = (EditText) findViewById(R.id.resultadoContenidoHumedad);

        calcular =(Button) findViewById(R.id.calContHumedad);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strMuestraHumeda = pesoMuestraHumeda.getText().toString();
                strMuestraSeca = pesoMuestraSeca.getText().toString();
                almMuestraHumeda = Double.parseDouble(strMuestraHumeda);
                almMuestraSeca = Double.parseDouble(strMuestraSeca);

                DecimalFormat formato = new DecimalFormat("#.###");
                double resul = calcularContenidoHumedad(almMuestraHumeda,almMuestraSeca);
                String almrRsul = formato.format(resul)+"";
                contHumedad.setText(almrRsul+ "%");
            }
        });


    }
    public double calcularContenidoHumedad(double muestraHumeda, double muestraSeca){
        return ((muestraHumeda-muestraSeca)/muestraSeca)*100;
    }
}