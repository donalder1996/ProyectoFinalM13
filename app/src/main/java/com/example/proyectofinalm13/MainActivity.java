package com.example.proyectofinalm13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario, etContraseña;
    private Button btnLogin, btnRegistro;
    private TextView tvOlvidar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.buttonLogin);
        btnRegistro = findViewById(R.id.buttonRegistro);
        tvOlvidar = findViewById(R.id.tvOlvidar);
        etUsuario = findViewById(R.id.editTextUsuario);
        etContraseña = findViewById(R.id.editTextContra);
        //clicklistener para el botón para lanzar la función campoVacio
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoVacio();

            }

        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               abrirActivityRegistro();

            }

        });
        tvOlvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityOlvidar();

            }

        });
    }
    //Parte del campo de login y los textos
    private void campoVacio() {
        String usuario = etUsuario.getText().toString();
        String contrasena = etContraseña.getText().toString();
        //Si la opción primera o segunda está vacío mostrar un mensaje mediante toast
        if (usuario.isEmpty() && contrasena.isEmpty()) {
            Toast.makeText(this, "campos en blanco", Toast.LENGTH_SHORT).show();

        } else if (usuario.isEmpty()) {
            Toast.makeText(this, "usuario en blanco", Toast.LENGTH_SHORT).show();


        } else if (contrasena.isEmpty()) {
            Toast.makeText(this, "contraseña en blanco", Toast.LENGTH_SHORT).show();

        }
        if (contrasena.length() < 4 || contrasena.length() > 8) {
            Toast.makeText(this, "Mínimo 4 caractereces, máximo 8 caractereces", Toast.LENGTH_LONG).show();

        }
        //Lanzar en esta parte la basede datos
        //new ValidarUsuarioTask().execute(usuario, contrasena);

    }
    //Abrir el activity de registro
    private void abrirActivityRegistro() {
        Intent intent_JGG = new Intent(this, ActivityRegistro.class);
        startActivity(intent_JGG);
        finish();

    }
    //enviar a la pantalla de olvidar contraseña
    private void abrirActivityOlvidar() {
        Intent intent_JGG = new Intent(this, ActivityOlvidar.class);
        startActivity(intent_JGG);
        finish();

    }
}