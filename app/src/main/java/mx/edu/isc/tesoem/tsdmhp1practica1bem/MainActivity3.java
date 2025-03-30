package mx.edu.isc.tesoem.tsdmhp1practica1bem;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual
    }
}
