package com.example.proyectofinalm13.Usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalm13.R;
import com.example.proyectofinalm13.Registro.MainActivity;
import com.example.proyectofinalm13.Registro.RegistroSatisfactorio;

public class EditarInformacion extends AppCompatActivity {
    ImageView IvBack;
     Spinner spinnerNacionalidad, spinnerMarca;
     EditText  etNombre, etApellido;
     TextView TvNombre, TvApellido,TvSNacion, TvSMarca;
     Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_informacion);
        IvBack = findViewById(R.id.back_btn3);
        spinnerMarca = findViewById(R.id.spinnerFabri);
        spinnerNacionalidad = findViewById(R.id.spinnerNacion);
        etNombre = findViewById(R.id.cambiarNombre);
        etApellido = findViewById(R.id.cambiarApellidos);
        TvNombre = findViewById(R.id.nombreBlanco);
        TvApellido = findViewById(R.id.apellidoBlanco);
        TvSNacion = findViewById(R.id.nacionalidadBlanco);
        TvSMarca = findViewById(R.id.FabricanteBlanco);
        btnEnviar = findViewById(R.id.buttonEnviarEditar);


        //Adapter spinner fabricante
        ArrayAdapter<CharSequence> adaptadorMarca = ArrayAdapter.createFromResource(this, R.array.fabricante, android.R.layout.simple_spinner_item);
        adaptadorMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMarca.setAdapter(adaptadorMarca);
        //Adaptador Nacionalidad
        ArrayAdapter<CharSequence> adaptadorFabricante = ArrayAdapter.createFromResource(this, R.array.nacionalidad, android.R.layout.simple_spinner_item);
        adaptadorFabricante.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNacionalidad.setAdapter(adaptadorFabricante);


        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlarCampos();

            }

        });

    }
    //Dar la opción de mantenerse en la pantalla o volver a la pantalla de usuario
    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción")
                .setMessage("¿Quieres permanecer en esta pantalla o ir a la pantalla de usuario")
                .setPositiveButton("Permanecer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Permanecer"
                        dialog.dismiss(); // Cierra el diálogo
                    }
                })
                .setNegativeButton("Volver a pantalla principal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
                        Intent intent = new Intent((getApplication()), pantallaUsuario.class);
                        startActivity(intent);
                    }
                })
                .show();
    }
    //Al buscar el botón comprobar si los campos están en blanco y hacer insert

    private void controlarCampos() {
    String nombre = etNombre.getText().toString();
    String apellidos = etApellido.getText().toString();
    String spinnerFabricantePos = spinnerMarca.getItemAtPosition(0).toString();
    String spinnerNacionPos=  spinnerNacionalidad.getItemAtPosition(0).toString();
    String spinnerFabricante = spinnerMarca.getSelectedItem().toString();
    String spinnerNacion=  spinnerNacionalidad.getSelectedItem().toString(); //spinnerFabricante.equals(spinnerFabricantePos)

    if(nombre.isEmpty()){
        TvNombre.setText("texto en blanco");
    } else{
        TvNombre.setText("");
    }
    if(apellidos.isEmpty()){
            TvApellido.setText("texto en blanco");
        }
    else{
        TvApellido.setText("");
    }
    if(spinnerNacion.equals(spinnerNacionPos) || spinnerNacion.isEmpty()){
        TvSNacion.setText("texto en blanco");
    } else{
        TvSNacion.setText("");
    }
    if(spinnerNacion.equals(spinnerNacionPos) || spinnerNacion.isEmpty()){
            TvSMarca.setText("texto en blanco");
        }
    else{
        TvSMarca.setText("");
    }

    //insert
        if(!nombre.isEmpty() & !apellidos.isEmpty() && !spinnerNacion.equals(spinnerNacionPos) && !spinnerFabricante.equals(spinnerFabricantePos)){
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_LONG).show();
        }
    }


}