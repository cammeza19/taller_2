package com.example.taller_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private Button botonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (vista, margenes) -> {
            Insets barrasSistema = margenes.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom);
            return margenes;
        });

        Bundle datosRecibidos = getIntent().getExtras();
        if (datosRecibidos != null) {
            String primerTexto = datosRecibidos.getString("DatoUno");
            String segundoTexto = datosRecibidos.getString("DatoDos");

            Toast.makeText(getApplicationContext(),
                    "Datos recibidos:\n• " + primerTexto + "\n• " + segundoTexto,
                    Toast.LENGTH_LONG).show();
        }

        botonRegresar = findViewById(R.id.btnRegresarAFirst);
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retorno = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(retorno);
                finish();
            }
        });
    }
}