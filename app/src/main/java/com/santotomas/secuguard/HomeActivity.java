package com.santotomas.secuguard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Otros elementos y variables necesarios
    Button sendRequestButton;
    Button confirmWellnessButton;
    Button emergencyButton;
    DrawerLayout drawer;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicializa los botones y otros elementos de la interfaz
        sendRequestButton = findViewById(R.id.send_request_button);
        confirmWellnessButton = findViewById(R.id.confirm_wellness_button);
        emergencyButton = findViewById(R.id.emergency_button);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();

        // Implementa los listeners de clic para cada botón
        sendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para enviar solicitudes de seguridad
            }
        });

        confirmWellnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para confirmar el bienestar
            }
        });

        emergencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para activar una alerta de emergencia
            }
        });

        // Implementa el resto de la funcionalidad de la aplicación
    }

    // Implementa el método para cerrar sesión en el menú lateral
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent; // Declaración de la variable intent

        switch (id) {
            case R.id.nav_grupos:
                // Lógica para la opción "Grupos"
                intent = new Intent(this, Grupos.class);
                startActivity(intent);
                break;

            case R.id.nav_contacts:
                // Lógica para la opción "Contactos"
                intent = new Intent(this, Contactos.class);
                startActivity(intent);
                break;

            case R.id.nav_Solicitudes:
                // Lógica para la opción "Solicitudes"
                intent = new Intent(this, Solicitudes.class);
                startActivity(intent);
                break;

            case R.id.nav_comprobacion_auto:
                // Lógica para la opción "Comprobacion Automatica"
                intent = new Intent(this, ComprobacionAutomatica.class);
                startActivity(intent);
                break;

            case R.id.nav_safe_space:
                intent = new Intent(this, EspacioSeguro.class);
                startActivity(intent);
                break;

            case R.id.nav_emergency_button:
                // Lógica para la opción "Botón de Emergencia"
                intent = new Intent(this, BotonEmergencia.class);
                startActivity(intent);
                break;

            case R.id.nav_settings:
                // Lógica para la opción "Configuración"
                intent = new Intent(this, Configuracion.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                // Lógica para la opción "Cerrar Sesión"
                mAuth.signOut();
                intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
        }

        drawer.close(); // Cierra el drawer después de seleccionar una opción

        return true;
    }



    // Otros métodos y lógica de la aplicación
}