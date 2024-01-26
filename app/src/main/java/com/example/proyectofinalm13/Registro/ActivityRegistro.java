package com.example.proyectofinalm13.Registro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinalm13.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ActivityRegistro extends AppCompatActivity {
    private EditText etNombre, etApellidos,etUsuario, etMail, etContraseña,etRepContra;
    private TextInputLayout TiNombre,TiApellidos, TiUsuario, TiMail, TiContra,TiRepContra ;
    private Button btnLogin, btnEnviar;
    private RadioButton rm, rf, rn;
    private Spinner spinnerNacionalidad, spinnerMarca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etNombre = findViewById(R.id.editNombre);
        etApellidos = findViewById(R.id.editApellidos);
        etUsuario= findViewById(R.id.editUsuario);
        etMail = findViewById(R.id.editMail);
        etContraseña = findViewById(R.id.editTextContraseña);
        etRepContra = findViewById(R.id.editTextContraseñaRepetir);
        btnLogin = findViewById(R.id.buttonCuenta);
        btnEnviar = findViewById(R.id.buttonEnviar);
        TiNombre = findViewById(R.id.TiNombre);
        TiApellidos = findViewById(R.id.TiApellidos);
        TiUsuario = findViewById(R.id.TiUsuario2);
        TiMail = findViewById(R.id.TiMail); 
        TiContra = findViewById(R.id.TiContra1);
        TiRepContra = findViewById(R.id.TiRepContra);
        spinnerMarca = findViewById(R.id.spinnerFabricante);
        spinnerNacionalidad = findViewById(R.id.spinnerNacionalidad);
        rm = findViewById(R.id.RadioM);
        rf = findViewById(R.id.RadioF);
        rn = findViewById(R.id.RadioN);

        /*Adaptadores de los spinner
        Adaptador Fabricante
         */
        ArrayAdapter<CharSequence> adaptadorMarca = ArrayAdapter.createFromResource(this, R.array.fabricante, android.R.layout.simple_spinner_item);
        adaptadorMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMarca.setAdapter(adaptadorMarca);
        //Adaptador Nacionalidad
        ArrayAdapter<CharSequence> adaptadorFabricante = ArrayAdapter.createFromResource(this, R.array.nacionalidad, android.R.layout.simple_spinner_item);
        adaptadorFabricante.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNacionalidad.setAdapter(adaptadorFabricante);

        etNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usuario= etNombre.getText().toString();
                if(usuario.isEmpty()  ){
                    TiNombre.setError("Está en blanco");
                }else{
                    TiNombre.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etApellidos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usuario= etApellidos.getText().toString();
                if(usuario.isEmpty()){
                    TiApellidos.setError("Está en blanco");
                }else{
                    TiNombre.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
                if(!usuario.isEmpty() & usuario.length() < 4){
                    TiUsuario.setError("minimo 4 caracteres");
                }else if(usuario.isEmpty()){
                    TiUsuario.setError("Está en blanco");
                }else if(usuario.length() > 15){
                    TiUsuario.setError("máximo 15 caracteres");
                }
                else{
                    TiUsuario.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mail= etMail.getText().toString();
                if(mail.isEmpty()){
                    TiMail.setError("Está en blanco");
                }else{
                    TiMail.setError("");
                }
                //Comprobar que se introduce el formato correcto de mail
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    TiMail.setHelperText("");
                    //formato correcto
                }else{
                    TiMail.setHelperText("formato correcto");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String ComprobarContra= etContraseña.getText().toString();
                String RepContra= etRepContra.getText().toString();
                if(ComprobarContra.isEmpty()){
                    TiContra.setError("Está en blanco");
                }else{
                    TiContra.setError("");
                }
                if(!ComprobarContra.isEmpty() & ComprobarContra.length() < 4){
                    TiContra.setError("minimo 4 caracteres");
                }else if(ComprobarContra.isEmpty()){
                    TiContra.setError("Está en blanco");
                }else if(ComprobarContra.length() > 10){
                    TiContra.setError("máximo 10 caracteres");
                }
                else{
                    TiContra.setError("");
                }

                if(!ComprobarContra.equals(RepContra)){

                }else{
                    TiRepContra.setError("");
                    if(ComprobarContra.isEmpty()){
                        TiRepContra.setError("Está en blanco");
                    }
                    TiRepContra.setHelperText("Los correos coinciden");

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //Cambio del texto de repetir contraseña
        etRepContra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String repContra= etRepContra.getText().toString();
                String comprobarContra= etContraseña.getText().toString();
                //Si está en blanco
                if(repContra.isEmpty()){
                    TiRepContra.setError("Está en blanco");
                }
                else{
                    TiRepContra.setError("");
                }
                //Aviso si no coinciden las contraseñas
                if(!repContra.equals(comprobarContra)){
                    TiRepContra.setError("Las contraseñas no coinciden");
                }else{
                    TiRepContra.setError("");
                    TiRepContra.setHelperText("Las contraseñas coinciden");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //Botón enviar lanzar activity
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity();

            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityLogin();

            }

        });
    }
    private void abrirActivityLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
    //Aquí se hace el cambio de activity si se cumplen las condiciones, quedaría implementar la parte del inset de la base de datos
    private void abrirActivity() {
        String nombre = etNombre.getText().toString();
        String apellido = etApellidos.getText().toString();
        String user = etUsuario.getText().toString();
        String mail = etMail.getText().toString();
        String password = etContraseña.getText().toString();
        String RepContra = etRepContra.getText().toString();
        String spinnerFabricantePos = spinnerMarca.getItemAtPosition(0).toString();
        String spinnerNacionPos=  spinnerNacionalidad.getItemAtPosition(0).toString();
        String spinnerFabricante = spinnerMarca.getSelectedItem().toString();
        String spinnerNacion=  spinnerNacionalidad.getSelectedItem().toString();
        String genero = "hola";
        ProgressDialog progressDialog = new ProgressDialog(this);
        //Para pasar la información del radio button
            if(rm.isChecked()){
                genero = rm.getText().toString();
            }else if(rf.isChecked()){
            genero = rf.getText().toString();
        }else{
            genero = rn.getText().toString();
        }
            if(nombre.isEmpty()){

            }

            else if(mail.isEmpty()){

            }else if(spinnerNacion.equals(spinnerNacionPos)){

            }else if(spinnerFabricante.equals(spinnerFabricantePos)){
                //instar en la base de datos
           } else if(!nombre.isEmpty() && !apellido.isEmpty() && !user.isEmpty() && !password.isEmpty()
                    && !RepContra.isEmpty()  && !spinnerNacion.equals(spinnerNacionPos) && spinnerFabricante.equals(spinnerFabricantePos) && !mail.isEmpty()
                    || rm.isChecked() || rf.isChecked() || rn.isChecked()) {
                if(user.length() >3 && user.length()<16 && password.length() >3 && password.length() < 11 && password.equals(RepContra) && Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    progressDialog.show();
                    String finalGenero = genero;
                    StringRequest request = new StringRequest(Request.Method.POST, "http://10.0.2.2/insertUsuario.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("datos insertados")) {
                                Intent intent = new Intent(getApplicationContext(), RegistroSatisfactorio.class);
                                intent.putExtra("usuario", user);
                                startActivity(intent);
                                finish();
                                progressDialog.dismiss();
                            } else {
                                Toast.makeText(getApplicationContext(), "no se guardó", Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }){
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map <String,String> params = new HashMap<String,String>();
                            params.put("nombre",nombre);
                            params.put("apellido",apellido);
                            params.put("user",user);
                            params.put("mail",mail);
                            params.put("contra",password);
                            params.put("genero", finalGenero);
                            params.put("nacionalidad",spinnerNacion);
                            params.put("fabricante",spinnerFabricante);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
                }
            }
    }

}





