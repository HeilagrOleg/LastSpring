package com.last_spring.gameprealpha;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.last_spring.gameprealpha.R;

public class OstSnowy extends Service {
    public OstSnowy() {
    }

    public MediaPlayer playerSnowy;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playerSnowy = MediaPlayer.create(this, R.raw.ost_snowy);
        playerSnowy.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playerSnowy.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        playerSnowy.stop();
    }
}
