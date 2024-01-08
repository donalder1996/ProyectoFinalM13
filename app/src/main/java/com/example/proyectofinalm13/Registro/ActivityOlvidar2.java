package com.example.proyectofinalm13.Registro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectofinalm13.R;
import com.google.android.material.textfield.TextInputLayout;

public class ActivityOlvidar2 extends AppCompatActivity {
    private ImageView IvBack;
    private Button btnLogin, btnEnviar;
    private TextInputLayout tiContra, tiRepContra;
    private EditText etContra, etRContra;
    private TextView txTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar2);
        IvBack = findViewById(R.id.back_btn1);
        btnLogin = findViewById(R.id.buttonLogin2);
        btnEnviar = findViewById(R.id.buttonEnviar2);
        etContra = findViewById(R.id.editContra1);
        etRContra = findViewById(R.id.editTextContra);
        txTexto = findViewById(R.id.tvTexto);
        tiContra = findViewById(R.id.TIContra);
        tiRepContra = findViewById(R.id.TIRContra);
        etContra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String contrasena= etContra.getText().toString();
                String repContra= etRContra.getText().toString();
                if(contrasena.isEmpty()){
                    tiContra.setError("Está en blanco");
                }else{
                    tiContra.setError("");
                }
                if(!contrasena.isEmpty() & contrasena.length() < 4){
                    tiContra.setError("minimo 4 caracteres");
                }else if(contrasena.isEmpty()){
                    tiContra.setError("Está en blanco");
                }else if(contrasena.length() > 10){
                    tiContra.setError("máximo 10 caracteres");
                }
                else{
                    tiContra.setError("");
                }
                if(contrasena.equals(repContra)){
                    tiRepContra.setHelperText("Contraseñas coinciden");
                } else{
                    tiRepContra.setHelperText("");

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRContra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String Repcontrasena= etRContra.getText().toString();
                String contrasena= etContra.getText().toString();
                if(Repcontrasena.isEmpty()){
                    tiRepContra.setError("Está en blanco");
                }else{
                    tiRepContra.setError("");
                }

                    if(Repcontrasena.equals(contrasena)){
                        tiRepContra.setHelperText("Contraseñas coinciden");
                    } else{
                        tiRepContra.setHelperText("");
                        tiRepContra.setError("Contraseñas no coinciden");
                    }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityLogin();

            }

        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMensaje();

            }

        });
    }
    private void enviarMensaje() {
        String contrasena = etContra.getText().toString();
        String repContrasena = etRContra.getText().toString();


        /*
        Si se cumple la condición mensaje de tarea hecha y se hace el inser
        en caso de que no se cumple mensaje de internarlo de nuevo
         */
        if(contrasena.equals(repContrasena)){
            txTexto.setText("Se cambió la contraseña satisfactoriamente");

        }else{
            txTexto.setText("Error, vuelve a intentarlo");
        }






    }

    private void abrirActivityLogin() {
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
                .setNegativeButton("Volver a la pantalla de login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
                        Intent intent = new Intent((getApplication()),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .show();
    }

    
    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una opción")
                .setMessage("¿Quieres permanecer en esta pantalla o ir a la pantalla anterior")
                .setPositiveButton("Permanecer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Permanecer"
                        dialog.dismiss(); // Cierra el diálogo
                    }
                })
                .setNegativeButton("Volver a la pantalla anterior", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar al seleccionar "Ir a la siguiente pantalla
                        Intent intent = new Intent((getApplication()),ActivityOlvidar.class);
                        startActivity(intent);
                    }
                })
                .show();
    }
}