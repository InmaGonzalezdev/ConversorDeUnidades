package com.inmagonzalez.conversordeunidades;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TemperaturaActivity extends AppCompatActivity {


    CheckBox cbCaF,cbFaC;
    TextView tw_resultado;
    EditText edt_valor;
    SharedPreferences preferences;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperatura);
        cbCaF = findViewById(R.id.cbCaF);
        cbFaC = findViewById(R.id.cbFaC);
        tw_resultado = findViewById(R.id.tw_resultado);
        edt_valor = findViewById(R.id.edt_valor);

        preferences = getSharedPreferences(Preferencias.DATOS, Context.MODE_PRIVATE);

        builder = new AlertDialog.Builder(this);



        cbCaF.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                cbFaC.setChecked(false);
            }
        });

        cbFaC.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                cbCaF.setChecked(false);
            }
        });

    }

    public void calcularConversion(View view) {

        //Por si el usuario no inserta un valor, le avisa que tiene que hacerlo
        if (edt_valor.getText().toString().isEmpty()){
            mostrarAlerta("Aviso", "Inserte un valor", R.drawable.warning_icon);
            return;
        }

        //Asegura que la app no se cierre si el usuario usa una coma
        String texto = edt_valor.getText().toString().replace(',', '.');
        double valor = Double.parseDouble(texto);
        double resultado;


        //Se hacen los calculos, si no se marca ninguna opción, te avisa para que lo hagas
        if (cbCaF.isChecked()){
            resultado = (valor * 9 / 5) + 32;
            tw_resultado.setText(String.valueOf(resultado));

        }else if (cbFaC.isChecked()){
            resultado = (valor - 32) * 5 / 9;
            tw_resultado.setText(String.valueOf(resultado));
        }else {
            mostrarAlerta("Aviso", "Marque una opción", R.drawable.warning_icon);

        }

    }

    public void borrarContenido(View view) {
        edt_valor.setText("");
        tw_resultado.setText("");
        cbCaF.setChecked(false);
        cbFaC.setChecked(false);
    }

    public void guardarDatos(View view) {
        String txt_resultado = tw_resultado.getText().toString();

        if (txt_resultado.isEmpty()){
            mostrarAlerta("Aviso", "No es posible guardar sin haber realizado un calculo", R.drawable.warning_icon);
            return;
        }

        float resultado = Float.parseFloat(tw_resultado.getText().toString());

        preferences.edit().putFloat(Preferencias.RESULTADO_TEMPERATURA, resultado).apply();

        mostrarAlerta("Guardado", "Datos guardados correctemente",R.drawable.check_icon);
    }

    public void mostrarDatos(View view) {
        tw_resultado.setText(String.valueOf(preferences.getFloat(Preferencias.RESULTADO_TEMPERATURA,0)));
    }

    public void mostrarAlerta(String titulo, String mensaje, int icono){

        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setIcon(icono);
        builder.setPositiveButton("Aceptar", null);
        builder.create().show();

    }
}