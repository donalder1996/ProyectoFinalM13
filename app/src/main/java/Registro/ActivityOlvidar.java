package Registro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.proyectofinalm13.R;

public class ActivityOlvidar extends AppCompatActivity {
    private ImageView IvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar);
        IvBack = findViewById(R.id.back_btn);
        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
    }
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
                        Intent intent = new Intent((getApplication()),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .show();
    }

}