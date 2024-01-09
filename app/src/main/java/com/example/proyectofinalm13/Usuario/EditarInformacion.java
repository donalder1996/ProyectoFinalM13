package com.example.proyectofinalm13.Usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.proyectofinalm13.R;
import com.example.proyectofinalm13.Registro.MainActivity;

public class EditarInformacion extends AppCompatActivity {
    ImageView IvBack;
     Spinner spinnerNacionalidad, spinnerMarca;
     EditText  etNombre, etApellido;
     Button btnEnviar;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_informacion);
        IvBack = findViewById(R.id.back_btn3);
        spinnerMarca = findViewById(R.id.spinnerFabri);
        spinnerNacionalidad = findViewById(R.id.spinnerNacion);
        etNombre = findViewById(R.id.nombreBlanco);
        etApellido = findViewById(R.id.apellidoBlanco);
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
    //Al buscar el botón comprobar si los campos están en blanco y si todo está bien hacer el insert
    private void controlarCampos() {

    }
}