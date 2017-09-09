package com.last_spring.gameprealpha;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.last_spring.gameprealpha.R;

public class OstDisturbance extends Service {
    public MediaPlayer playerDisturbance;


    public OstDisturbance() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playerDisturbance = MediaPlayer.create(this, R.raw.ost_disturbance);
        playerDisturbance.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playerDisturbance.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        playerDisturbance.stop();
    }
}
