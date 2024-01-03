package Registro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectofinalm13.R;
import com.google.android.material.textfield.TextInputLayout;

public class ActivityOlvidar extends AppCompatActivity {
    private ImageView IvBack;
    private TextInputLayout TiMail, TiRMail;
    private Button btnEnviar;
    private EditText etCMail, etCRepMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar);
        IvBack = findViewById(R.id.back_btn);
        btnEnviar = findViewById(R.id.buttonEnviar);
        etCMail = findViewById(R.id.etComMail);
        etCRepMail = findViewById(R.id.etComRMail);
        TiMail = findViewById(R.id.TIMail);
        TiRMail = findViewById(R.id.TIRMail);

        etCMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String correo= etCMail.getText().toString();
                String comprobarCorreo=  etCRepMail.getText().toString();
                if(correo.isEmpty()){
                    TiMail.setError("Está en blanco");
                }else{
                    TiMail.setError("");
                }
                //Comprobar que se introduce el formato correcto de mail
                if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
                    TiMail.setHelperText("");
                    //formato correcto
                }else{
                    TiMail.setHelperText("formato correcto");
                }
                if(!comprobarCorreo.equals(correo)){
                    TiRMail.setError("");
                }else{
                    TiRMail.setError("");
                    if(correo.isEmpty()){
                        TiRMail.setError("Está en blanco");
                    }
                    TiRMail.setHelperText("Los correos coinciden");

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etCRepMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String correo=  etCRepMail.getText().toString();
                String comprobarCorreo= etCMail.getText().toString();
                //Si está en blanco
                if(correo.isEmpty()){
                    TiRMail.setError("Está en blanco");
                }
                else{
                    TiRMail.setError("");
                }
                //Aviso si no coinciden las contraseñas
                if(!correo.equals(comprobarCorreo)){
                    TiRMail.setError("Los correos no coinciden");
                }else{
                    TiRMail.setError("");
                    TiRMail.setHelperText("Los correos coinciden");
                    if(correo.isEmpty()){
                        TiRMail.setError("Está en blanco");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCambio();

            }

        });
        IvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }

        });
    }
    private void abrirCambio() {
        String mail = etCMail.getText().toString();
        String repMail = etCRepMail.getText().toString();
        String mailTest = "hola";
        String repMailTest = "hola";
        //Prueba para hacer el cambio de activity
        if(mailTest.equals(mail) & repMailTest.equals(repMail)){
            Intent intent = new Intent(this, ActivityOlvidar2.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Mail incorrecto o no existe en la base de datos", Toast.LENGTH_LONG).show();
        }
        //Lanzar en esta parte la base de datos
        //new ValidarUsuarioTask().execute(usuario, contrasena);

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