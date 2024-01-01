package Registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectofinalm13.R;

public class ActivityRegistro extends AppCompatActivity {
    private EditText etUsuario, etContraseña;
    private Button btnLogin, btnEnviar;
    private TextView tvOlvidar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnLogin = findViewById(R.id.buttonCuenta);
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
}