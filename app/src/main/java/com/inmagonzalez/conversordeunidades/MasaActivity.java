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
/**
 * Esta actividad convierte kilogramos en gramos y viceversa.
 * Se puede hacer:
 * - Ingresar un valor, en este caso un número.
 * - Seleccionar la unidad de la que se parte y convertirla, usando checkbox.
 * - Calcular la conversión.
 * - Guardar el resultado en datos.xml a través de SharedPreferences.
 * - Borrar valores.
 * - Mostrar valores guardados.
 */

public class MasaActivity extends AppCompatActivity {


    //Checkbox que se usarán para elegir la conversión
    CheckBox cbKaAg,cbGaKg;

    //TextView que mostrará el resultado de la conversión
    TextView tw_resultado;

    //EditText donde se ingresa el valor
    EditText edt_valor;

    //SharedPreferences para guardar el resultado y poder pedirlo
    SharedPreferences preferences;

    //Necesario para mostrar alertas
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masa);

        cbKaAg = findViewById(R.id.cbKaAg);
        cbGaKg = findViewById(R.id.cbGaKg);
        tw_resultado = findViewById(R.id.tw_resultado);
        edt_valor = findViewById(R.id.edt_valor);

        preferences = getSharedPreferences(Preferencias.DATOS, Context.MODE_PRIVATE);

        builder = new AlertDialog.Builder(this);



        //Necesario para que si uno es marcado, no se pueda marcar el otro.
        //Se desmarca solo
        cbKaAg.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                cbGaKg.setChecked(false);
            }
        });

        cbGaKg.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                cbKaAg.setChecked(false);
            }
        });


    }

    /**
     * Calcula la conversión de los valores.
     * Se valida que el usuario haya ingresado un valor y marque una opción.
     * @param view Dispara el evento del botón calcular
     */
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

        //Se hacen los cálculos, si no se marca ninguna opción, te avisa para que lo hagas
        if (cbGaKg.isChecked()){
            resultado = valor/1000;
            tw_resultado.setText(String.valueOf(resultado));

        }else if (cbKaAg.isChecked()){
            resultado = valor * 1000;
            tw_resultado.setText(String.valueOf(resultado));
        }else {
            mostrarAlerta("Aviso", "Marque una opción", R.drawable.warning_icon);
        }
    }

    /**
     * Al pulsar el botón borrar,quitará todos los textos y desmarcará todos los CheckBox.
     * @param view Dispara el evento del botón borrar
     */
    public void borrarContenido(View view) {
        edt_valor.setText("");
        tw_resultado.setText("");
        cbKaAg.setChecked(false);
        cbGaKg.setChecked(false);
    }

    /**
     * Al pulsar el botón, guarda el último resultado en SharedPreferences.
     * Además, se valida el que se tenga que hacer un cálculo para poder guardarlo.
     * @param view Dispara el evento del botón guardar
     */
    public void guardarDatos(View view) {
        String txt_resultado = tw_resultado.getText().toString();

        if (txt_resultado.isEmpty()){
            mostrarAlerta("Aviso", "No es posible guardar sin haber realizado un calculo", R.drawable.warning_icon);
            return;
        }

        float resultado = Float.parseFloat(tw_resultado.getText().toString());

        preferences.edit().putFloat(Preferencias.RESULTADO_MASA, resultado).apply();

        mostrarAlerta("Guardado", "Datos guardados correctemente",R.drawable.check_icon);
    }

    /**
     * Al pulsar el botón mostrar, muestra el resultado del último cálculo guardado.
     * @param view Dispara el evento del botón mostrar.
     */
    public void mostrarDatos(View view) {
        tw_resultado.setText(String.valueOf(preferences.getFloat(Preferencias.RESULTADO_MASA,0)));
    }

    /**\
     * Método necesario ya que se repetirá bastantes veces.
     * @param titulo Título del dialog.
     * @param mensaje Mensaje que se muestra en el dialog.
     * @param icono Icono que se muestra en el dialog, guardado en la carpeta drawable.
     */
    public void mostrarAlerta(String titulo, String mensaje, int icono){

        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setIcon(icono);
        builder.setPositiveButton("Aceptar", null);
        builder.create().show();

    }
}