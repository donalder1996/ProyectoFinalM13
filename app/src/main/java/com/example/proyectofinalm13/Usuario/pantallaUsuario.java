package com.example.proyectofinalm13.Usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectofinalm13.R;

import com.example.proyectofinalm13.Registro.MainActivity;

public class pantallaUsuario extends AppCompatActivity {
    private ImageView IvBack,IvBCoches,IvBColecciones;
    private Button btnEditar;
    private TextView  tvNombre, tvApellidos, tvNacionalidad, tvFabricante,tvGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_usuario);
        IvBack = findViewById(R.id.back_btn2);
        IvBCoches = findViewById(R.id.banner_colecciones);
        IvBColecciones = findViewById(R.id.banner_coches);
        btnEditar = findViewById(R.id.buttonEditar);
        //Añadir el texto con la información de la base de datos
        tvNombre = findViewById(R.id.añadirNombre);
        tvApellidos = findViewById(R.id.añadirApellidos);
        tvNacionalidad = findViewById(R.id.añadirNacionalidad);
        tvFabricante = findViewById(R.id.añadirFabricante);
        tvGenero = findViewById(R.id.añadirGenero);
        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityEditar();

            }

        });
        IvBCoches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               activityCoches();

            }

        });
        IvBColecciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityColecciones();

            }

        });
    }
    //Dar la opción de volver a login o mantenerse en la pantalla
    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción")
                .setMessage("¿Quieres permanecer en esta pantalla o ir a la pantalla de login")
                .setPositiveButton("Permanecer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Permanecer"
                        dialog.dismiss(); // Cierra el diálogo
                    }
                })
                .setNegativeButton("Volver al login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
                        Intent intent = new Intent((getApplication()), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .show();
    }
    //Al clicar se abre el activity con la colección de coches para añadir
    private void activityCoches() {
        Intent intent = new Intent((getApplication()), pantallaCoches.class);
        startActivity(intent);

    }
    //Al clicar se abre el activity con la colecciones de coches que tenemos
    private void activityColecciones() {
        Intent intent = new Intent((getApplication()), pantallaMisColecciones.class);
        startActivity(intent);

    }
    //activity para editar la información
    private void activityEditar() {
        Intent intent = new Intent((getApplication()), EditarInformacion.class);
        startActivity(intent);

    }
}