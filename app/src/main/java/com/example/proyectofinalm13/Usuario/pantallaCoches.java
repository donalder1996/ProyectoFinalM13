package com.example.proyectofinalm13.Usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.proyectofinalm13.R;

public class pantallaCoches extends AppCompatActivity {
    private Spinner spinnerMarca;
    private ImageView IvBack, Ivcoches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_coches);
        IvBack = findViewById(R.id.back_btn4);
        Ivcoches = findViewById(R.id.banner_colecciones);
        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
        Ivcoches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity();

            }

        });
        spinnerMarca = findViewById(R.id.spinnerMarca);
        //adaptador fabricante, al pusarlo se va a usar para mostrar el orden de lo que queremos
        ArrayAdapter<CharSequence> adaptadorMarca = ArrayAdapter.createFromResource(this, R.array.fabricante, android.R.layout.simple_spinner_item);
        adaptadorMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMarca.setAdapter(adaptadorMarca);

    }
    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción")
                .setMessage("¿Quieres permanecer en esta pantalla o ir a la pantalla principal")
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
    private void abrirActivity() {
        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
        Intent intent = new Intent((getApplication()), ColeccionesAnadirCoche.class);
        startActivity(intent);

    }
}