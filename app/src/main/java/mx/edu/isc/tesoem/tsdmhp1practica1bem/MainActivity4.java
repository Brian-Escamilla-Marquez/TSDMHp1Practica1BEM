package mx.edu.isc.tesoem.tsdmhp1practica1bem;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {

    private Spinner spinnerEstados, spinnerMunicipios;
    private RadioGroup radioGroupSexo, radioGroupMascotas;
    private Map<String, String[]> municipiosMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        spinnerEstados = findViewById(R.id.spinnerEstados);
        spinnerMunicipios = findViewById(R.id.spinnerMunicipios);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        radioGroupMascotas = findViewById(R.id.radioGroupMascotas);

        // Crear el mapa de estados con sus municipios reales
        municipiosMap = new HashMap<>();
        municipiosMap.put("CDMX", new String[]{"Álvaro Obregón", "Benito Juárez", "Coyoacán", "Iztacalco", "Tlalpan"});
        municipiosMap.put("Jalisco", new String[]{"Guadalajara", "Zapopan", "Tlaquepaque", "Puerto Vallarta", "Tlajomulco"});
        municipiosMap.put("Nuevo León", new String[]{"Monterrey", "San Nicolás", "Guadalupe", "Escobedo", "Apodaca"});
        municipiosMap.put("Puebla", new String[]{"Puebla", "Tehuacán", "Atlixco", "Cholula", "San Martín Texmelucan"});
        municipiosMap.put("Yucatán", new String[]{"Mérida", "Progreso", "Valladolid", "Tizimín", "Kanasín"});

        // Adapter para el Spinner de estados
        ArrayAdapter<String> adapterEstados = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"CDMX", "Jalisco", "Nuevo León", "Puebla", "Yucatán"});
        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstados.setAdapter(adapterEstados);

        // Listener para el Spinner de estados
        spinnerEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String estadoSeleccionado = (String) parentView.getItemAtPosition(position);
                actualizarMunicipios(estadoSeleccionado);
                mostrarSeleccion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No hacer nada si no se selecciona nada
            }
        });

        // Adapter para el Spinner de municipios (inicialmente vacío)
        ArrayAdapter<String> adapterMunicipios = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{});
        adapterMunicipios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMunicipios.setAdapter(adapterMunicipios);

        // Listener para el Spinner de municipios
        spinnerMunicipios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                mostrarSeleccion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No hacer nada si no se selecciona nada
            }
        });

        // Listener para el RadioGroup de Sexo
        radioGroupSexo.setOnCheckedChangeListener((group, checkedId) -> mostrarSeleccion());

        // Listener para el RadioGroup de Mascotas
        radioGroupMascotas.setOnCheckedChangeListener((group, checkedId) -> mostrarSeleccion());
    }

    // Método para actualizar los municipios según el estado seleccionado
    private void actualizarMunicipios(String estadoSeleccionado) {
        String[] municipios = municipiosMap.get(estadoSeleccionado);
        ArrayAdapter<String> adapterMunicipios = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, municipios);
        adapterMunicipios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMunicipios.setAdapter(adapterMunicipios);
    }

    // Método para mostrar los mensajes por separado
    private void mostrarSeleccion() {
        String estadoSeleccionado = (String) spinnerEstados.getSelectedItem();
        String municipioSeleccionado = (String) spinnerMunicipios.getSelectedItem();
        int idSexo = radioGroupSexo.getCheckedRadioButtonId();
        int idMascota = radioGroupMascotas.getCheckedRadioButtonId();

        RadioButton radioButtonSexo = findViewById(idSexo);
        RadioButton radioButtonMascota = findViewById(idMascota);

        // Verificar si el municipio y los RadioButton están seleccionados antes de mostrar el mensaje
        if (estadoSeleccionado != null && municipioSeleccionado != null) {
            // Mostrar el mensaje para el estado seleccionado
            String mensajeEstado = "Estado: " + estadoSeleccionado;
            Toast.makeText(MainActivity4.this, mensajeEstado, Toast.LENGTH_SHORT).show();

            // Mostrar el mensaje para el municipio seleccionado
            String mensajeMunicipio = "Municipio: " + municipioSeleccionado;
            Toast.makeText(MainActivity4.this, mensajeMunicipio, Toast.LENGTH_SHORT).show();
        }

        if (radioButtonSexo != null) {
            // Mostrar el mensaje para el sexo seleccionado
            String mensajeSexo = "Sexo: " + radioButtonSexo.getText();
            Toast.makeText(MainActivity4.this, mensajeSexo, Toast.LENGTH_SHORT).show();
        }

        if (radioButtonMascota != null) {
            // Mostrar el mensaje para las mascotas seleccionadas
            String mensajeMascota = "Mascotas: " + radioButtonMascota.getText();
            Toast.makeText(MainActivity4.this, mensajeMascota, Toast.LENGTH_SHORT).show();
        }
    }
}
