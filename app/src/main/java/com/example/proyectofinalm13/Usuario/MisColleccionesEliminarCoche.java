package com.example.proyectofinalm13.Usuario;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.proyectofinalm13.databinding.ActivityMisColleccionesEliminarCocheBinding;

import com.example.proyectofinalm13.R;

public class MisColleccionesEliminarCoche extends AppCompatActivity {
    private ImageView IvBack,IvCross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_collecciones_eliminar_coche);
        IvBack = findViewById(R.id.back_btn5);
        IvCross = findViewById(R.id.tickEliminar);
        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
        IvCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();

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
                        Intent intent = new Intent((getApplication()), pantallaCoches.class);
                        startActivity(intent);
                    }
                })
                .show();
    }
    /*
  función para hacer el delete, preguntar al usuario con el alertDialog si está seguro de la acción
   */
    private void eliminar() {
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