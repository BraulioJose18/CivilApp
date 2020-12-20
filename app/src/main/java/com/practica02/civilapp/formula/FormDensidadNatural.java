package com.practica02.civilapp.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica02.civilapp.R;

import java.text.DecimalFormat;

public class FormDensidadNatural extends AppCompatActivity {

    EditText pesoMuestra;
    EditText pesoMuestraMasParafina;
    EditText pesoPicnometroMasAgua;
    EditText pesoMuestraPicnoAguaParafina;
    EditText contHumedad;

    EditText denAgua;
    EditText denParafina;

    EditText resultVolMuestra;
    EditText resultDenNat;
    EditText resultDenSeca;

    Button calcular;

    double almPesoMuestra, almPesoMuestraParafina, almPesoPicnometroAgua, almPesoMuestraPicnoAguaParafina, almContHumedad, almDenAgua, almDenParafina;

    double resulVolMuestra, resulDenNat, resulDenSeca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_densidad_natural);

        pesoMuestra = (EditText) findViewById(R.id.denNatPesoMuestra);
        pesoMuestraMasParafina = (EditText) findViewById(R.id.denNatPesoMuestraMasParafina);
        pesoPicnometroMasAgua = (EditText) findViewById(R.id.denNatPesoPicnoMasAgua);
        pesoMuestraPicnoAguaParafina = (EditText) findViewById(R.id.denNatPesoMuestraMasPicnoMasAguaMasParafina);
        contHumedad = (EditText) findViewById(R.id.denNatContHumedad);

        denAgua = (EditText) findViewById(R.id.denNatDenAgua);
        denParafina = (EditText) findViewById(R.id.denNatDenParafina);

        resultVolMuestra = (EditText) findViewById(R.id.denNatResulVolMuestra);
        resultDenNat = (EditText) findViewById(R.id.denNatResulDenNat);
        resultDenSeca = (EditText) findViewById(R.id.denNatResulDenSeca);

        calcular = (Button) findViewById(R.id.calDenNat);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almPesoMuestra = Double.parseDouble(pesoMuestra.getText().toString());
                almPesoMuestraParafina = Double.parseDouble(pesoMuestraMasParafina.getText().toString());
                almPesoPicnometroAgua = Double.parseDouble(pesoPicnometroMasAgua.getText().toString());
                almPesoMuestraPicnoAguaParafina = Double.parseDouble(pesoMuestraPicnoAguaParafina.getText().toString());
                almContHumedad = Double.parseDouble(contHumedad.getText().toString());
                almDenAgua = Double.parseDouble(denAgua.getText().toString());
                almDenParafina = Double.parseDouble(denParafina.getText().toString());

                DecimalFormat formato = new DecimalFormat("#.###");

                resulVolMuestra = calcularVolMuestra(almPesoMuestraParafina,almPesoPicnometroAgua,almPesoMuestraPicnoAguaParafina,almPesoMuestra,almDenAgua,almDenParafina);

                resulDenNat = calcularDenNat(almPesoMuestra, resulVolMuestra);
                resulDenSeca = calcularDenSeca(resulDenNat,almContHumedad);
                //Texto
                resultVolMuestra.setText(formato.format(resulVolMuestra)+"");
                resultDenNat.setText(formato.format(resulDenNat)+"");
                resultDenSeca.setText(formato.format(resulDenSeca)+"");


            }
        });

    }
    public double calcularVolMuestra (double almPesoMuestraParafina,double almPesoPicnometroAgua,double almPesoMuestraPicnoAguaParafina, double almPesoMuestra,
                                      double almDenAgua,double almDenParafina){
        return ((almPesoMuestraParafina+almPesoPicnometroAgua-almPesoMuestraPicnoAguaParafina)/almDenAgua)-((almPesoMuestraParafina-almPesoMuestra)/almDenParafina);
    }
    public double calcularDenNat (double almPesoMuestra, double almVolMuestra){
        return almPesoMuestra/almVolMuestra;
    }
    public double calcularDenSeca (double almDenNat, double almContHumedad){
        return almDenNat/(1+almContHumedad);
    }
}