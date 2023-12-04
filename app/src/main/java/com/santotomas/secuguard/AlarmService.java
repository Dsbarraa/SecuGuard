package com.santotomas.secuguard;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.logging.Handler;

public class AlarmService extends Service {
    private static final int NOTIFICATION_ID = 1;
    private static final long DELAY_MS = 60000; // 1 minuto (ajusta según tus necesidades)

    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        //handler = new Handler();
        startAlarm();
    }

    private void startAlarm() {
        //handler.postDelayed(runnable = new Runnable() {
            //@Override
            //public void run() {
           //     showNotification();
          //  }
        //}, DELAY_MS);
    }

    private void showNotification() {
        // Aquí puedes crear y mostrar una notificación
        // Consulta el siguiente paso para obtener más detalles sobre cómo hacerlo
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Detener el servicio y el contador cuando la notificación es validada
        //handler.getClass(runnable);
        stopSelf();
    }
}

