package Registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalm13.R;
import com.google.android.material.textfield.TextInputLayout;

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
                String con = s.toString();
                String usuario= etNombre.getText().toString();
                if(usuario.isEmpty()){
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
                String con = s.toString();
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
                String con = s.toString();
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
        etMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String con = s.toString();
                String usuario= etMail.getText().toString();
                if(usuario.isEmpty()){
                    TiMail.setError("Está en blanco");
                }else{
                    TiMail.setError("");
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
                String con = s.toString();
                String usuario= etContraseña.getText().toString();
                if(usuario.isEmpty()){
                    TiContra.setError("Está en blanco");
                }else{
                    TiContra.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etRepContra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usuario= etRepContra.getText().toString();
                String usuario1= etContraseña.getText().toString();
                if(usuario.isEmpty()){
                    TiRepContra.setError("Está en blanco");
                }
                else{
                    TiRepContra.setError("");
                }
                if(!usuario.equals(usuario1)){
                    TiRepContra.setError("Las contraseñas no coinciden");
                }else{
                    TiRepContra.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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

    private void abrirActivity() {
        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String usuario = etUsuario.getText().toString();
        String mail = etMail.getText().toString();
        String contra = etContraseña.getText().toString();
        String RepContra = etRepContra.getText().toString();
        String spinnerFabricante = spinnerMarca.getSelectedItem().toString();
        String spinnerNacion=  spinnerNacionalidad.getSelectedItem().toString();

        if(!nombre.isEmpty() & !apellidos.isEmpty() & usuario.length() >=4 & usuario.length() <=15  & !mail.isEmpty() & contra.length() >= 4 & contra.length() <= 10 & contra.equals(RepContra) & spinnerNacion != "" &spinnerFabricante != "" & rm.isChecked()  || rf.isChecked() || rn.isChecked()){
            Intent intent = new Intent(this, RegistroSatisfactorio.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_LONG).show();
        }






    }



}