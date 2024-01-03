package Registro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalm13.R;
import com.google.android.material.textfield.TextInputLayout;

import Usuario.pantallaUsuario;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario, etContraseña;
    private TextInputLayout TiUsuario,TiContra;
    private Button btnLogin, btnRegistro;
    private TextView tvOlvidar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.buttonLogin);
        TiUsuario = findViewById(R.id.TiUsuario);
        TiContra = findViewById(R.id.TiNombre);
        btnRegistro = findViewById(R.id.buttonRegistro);
        tvOlvidar = findViewById(R.id.tvOlvidar);
        etUsuario = findViewById(R.id.editTextUsuario);
        etContraseña = findViewById(R.id.editTextContra);

        //changedlister para cambiar el texto del Textyalout, primero el del usuario
        etUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usuario= etUsuario.getText().toString();
                if(usuario.isEmpty()){
                    TiUsuario.setError("Está en blanco");
                }else{
                    TiUsuario.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //El de la contraseña
        etContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String contrasena= etContraseña.getText().toString();
                if(contrasena.isEmpty()){
                    TiContra.setError("Está en blanco");
                }else{
                    TiContra.setError("");
                }
                if(!contrasena.isEmpty() & contrasena.length() < 4){
                    TiContra.setError("minimo 4 caracteres");
                }else if(contrasena.isEmpty()){
                    TiContra.setError("Está en blanco");
                }else if(contrasena.length() > 10){
                    TiContra.setError("máximo 10 caracteres");
                }
                else{
                    TiContra.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
        String usuarioTest = "hola";
        String contrasenaTest = "123456";
        //Prueba para hacer el cambio de activity
        if(usuarioTest.equals(usuario) & contrasenaTest.equals(contrasena)){
            Intent intent = new Intent(this, pantallaUsuario.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
        }
        //Lanzar en esta parte la basede datos
        //new ValidarUsuarioTask().execute(usuario, contrasena);

    }
    //Abrir el activity de registro
    private void abrirActivityRegistro() {
        Intent intent = new Intent(this, ActivityRegistro.class);
        startActivity(intent);
        finish();

    }
    //enviar a la pantalla de olvidar contraseña
    private void abrirActivityOlvidar() {
        Intent intent = new Intent(this, ActivityOlvidar.class);
        startActivity(intent);
        finish();

    }
}