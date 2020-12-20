package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

import java.text.DecimalFormat;

public class FormGravedadEspecifica extends AppCompatActivity {

    EditText pesoMuestraSeca;
    EditText pesoPicnometroAgua;
    EditText pesoPicnometroAguaMuestra;
    EditText resultadoGravEsp;

    Button calcular;

    double almPesoMuestraSeca, almPesoPicnometroAgua, almPesoPicnometroAguaMuestra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_gravedad_especifica);

        pesoMuestraSeca = (EditText) findViewById(R.id.gravEspPesoMuestraSeca);
        pesoPicnometroAgua = (EditText) findViewById(R.id.gravEspPesoPicnometroAgua);
        pesoPicnometroAguaMuestra = (EditText) findViewById(R.id.gravEspPesoPicnometroAguaMuestra);
        resultadoGravEsp = (EditText) findViewById(R.id.resultadoGravEsp);

        calcular = (Button) findViewById(R.id.calGravEsp);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almPesoMuestraSeca = Double.parseDouble(pesoMuestraSeca.getText().toString());
                almPesoPicnometroAgua = Double.parseDouble(pesoPicnometroAgua.getText().toString());
                almPesoPicnometroAguaMuestra = Double.parseDouble(pesoPicnometroAguaMuestra.getText().toString());

                DecimalFormat formato = new DecimalFormat("#.###");

                resultadoGravEsp.setText(formato.format(calcularGravEsp(almPesoMuestraSeca,almPesoPicnometroAgua,almPesoPicnometroAguaMuestra))+"");
            }
        });
    }

    public double calcularGravEsp(double almPesoMuestraSeca, double almPesoPicnometroAgua, double almPesoPicnometroAguaMuestra) {
        return almPesoMuestraSeca/(almPesoMuestraSeca+almPesoPicnometroAgua-almPesoPicnometroAguaMuestra);
    }
}