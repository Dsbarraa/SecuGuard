package com.santotomas.secuguard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PantallaDeCargaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        mAuth = FirebaseAuth.getInstance();

        int Tiempo = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Verificar si el usuario está autenticado
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    // El usuario está autenticado, ir a HomeActivity
                    Intent intent = new Intent(PantallaDeCargaActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    // El usuario no está autenticado, ir a MainActivity
                    Intent intent = new Intent(PantallaDeCargaActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, Tiempo);
    }
}
