package com.inmagonzalez.conversordeunidades;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Actividad principal de la app, se muestra al iniciar y funciona como pantalla de bienvenida/de carga.
 * - El splash se muestra durante tres segundos
 * - Una vez pasados esos segundos, se abre MainActivity y se finaliza la actividad para que no se pueda volver atrás.
 * - En el caso de volver atrás, se cerrará la app.
 */

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        //Aquí añadimos 3 segundos para que pase a la siguiente página
        //Espera de tres segundos
        new Handler().postDelayed(() -> {
            //Aquí inicia MainActivity
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            //Finaliza SplashActivity para no poder volver a la pantalla de carga
            finish();
        }, 3000);
    }
}