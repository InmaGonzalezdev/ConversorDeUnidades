package com.inmagonzalez.conversordeunidades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Permite elegir qué tipo de conversión se desea realizar:
 * - Longitud.
 * - Masa
 * - Temperatura
 * Se usa un RadioGroup con tres RadioButtons.
 * Al seleccionar una opción, te lleva directamente a la actividad correspondiente.
 * Para volver atrás, se usa el deslizamiento base de Android.
 */

public class MainActivity extends AppCompatActivity {

    //RadioGroup que contiene los RadioButtons
    RadioGroup rg;
    //RadioButtons que se utilizan para elegir la conversión.
    RadioButton rbt_longitud,rbt_masa,rbt_temperatura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);

        rbt_longitud = findViewById(R.id.rbt_longitud);
        rbt_masa = findViewById(R.id.rbt_masa);
        rbt_temperatura = findViewById(R.id.rbt_temperatura);


        //Listener necesario al seleccionar un RadioButton, se dispara al seleccionar uno de ellos.
      rg.setOnCheckedChangeListener((group, checkedId) -> {
          //Se revisa que RadioButton es seleccionado y con Intent abrimos la actividad correspondiente.
          if (checkedId == R.id.rbt_longitud){
              Intent intent = new Intent(MainActivity.this, LongitudActivity.class);
              startActivity(intent);
          } else if (checkedId == R.id.rbt_masa) {
              Intent intent = new Intent(MainActivity.this, MasaActivity.class);
              startActivity(intent);

          }else if (checkedId == R.id.rbt_temperatura){
              Intent intent = new Intent(MainActivity.this, TemperaturaActivity.class);
              startActivity(intent);
          }

      });

    }






}