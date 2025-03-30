package mx.edu.isc.tesoem.tsdmhp1practica1bem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText editTextNombre, editTextEdad;
    private Button buttonProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEdad = findViewById(R.id.editTextEdad);
        buttonProcesar = findViewById(R.id.buttonProcesar);

        buttonProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String edadTexto = editTextEdad.getText().toString();

                if (nombre.isEmpty() || edadTexto.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                int edad = Integer.parseInt(edadTexto);
                Intent intent;

                if (edad < 18) {
                    intent = new Intent(MainActivity2.this, MainActivity3.class);
                } else {
                    intent = new Intent(MainActivity2.this, MainActivity4.class);
                }

                startActivity(intent);
            }
        });
    }
}
