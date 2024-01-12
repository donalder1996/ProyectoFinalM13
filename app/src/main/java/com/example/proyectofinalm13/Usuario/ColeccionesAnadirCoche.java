package com.example.proyectofinalm13.Usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.proyectofinalm13.R;

public class ColeccionesAnadirCoche extends AppCompatActivity {
    private ImageView IvBack,IvTick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colecciones_anadir_coche);
        IvBack = findViewById(R.id.back_btn5);
        IvTick = findViewById(R.id.tickAñadir);
        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
        IvTick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                añadir();

            }

        });
    }
    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción")
                .setMessage("¿Quieres permanecer en esta pantalla o ir a la colección")
                .setPositiveButton("Permanecer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Permanecer"
                        dialog.dismiss(); // Cierra el diálogo
                    }
                })
                .setNegativeButton("Volver a pantalla colección", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
                        Intent intent = new Intent((getApplication()), pantallaMisColecciones.class);
                        startActivity(intent);
                    }
                })
                .show();
    }
    /*
    función para hacer el insert, preguntar al usuario con el alertDialog si está seguro de la acción
    si el elemeno ya está añadido mostrar la view sin el tick
     */
    private void añadir() {
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción")
                .setMessage("¿Quieres permanecer en esta pantalla o ir a la colección")
                .setPositiveButton("Permanecer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Permanecer"
                        dialog.dismiss(); // Cierra el diálogo
                    }
                })
                .setNegativeButton("Volver a pantalla colección", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
                        Intent intent = new Intent((getApplication()), pantallaMisColecciones.class);
                        startActivity(intent);
                    }
                })
                .show();

         */

    }
}