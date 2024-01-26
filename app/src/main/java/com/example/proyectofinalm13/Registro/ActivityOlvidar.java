package com.example.proyectofinalm13.Registro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinalm13.R;
import com.example.proyectofinalm13.Usuario.pantallaUsuario;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

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
        String url = "http://10.0.2.2/check.php";

        if(mail.isEmpty()){
            /*
            Intent intent = new Intent(this, ActivityOlvidar2.class);
            startActivity(intent);
            finish();

             */
        }else if (repMail.isEmpty()){
            //select para comprobar que el mail está en la base de datos
        }  else if(repMail.equals(mail) && !repMail.isEmpty() && !mail.isEmpty()){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Por favor espera...");

            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if(response.equalsIgnoreCase("ingresaste correctamente")){
                        Intent intent = new Intent(getApplicationContext(), ActivityOlvidar2.class);
                        //envia los datos del mail al activity, para hacer el update
                        intent.putExtra("mail",mail);
                        startActivity(intent);
                        finish();
                        // startActivity(new Intent(getApplicationContext(), ActivityOlvidar2.class));
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }

                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("mail",mail);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(request);
        }
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