package com.last_spring.gameprealpha;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.example.last_spring.gameprealpha.R;

public class OstWood extends Service {

    public MediaPlayer playerWood;


    public OstWood() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playerWood = MediaPlayer.create(this, R.raw.ost_wood);
        playerWood.setLooping(true);
}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playerWood.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        playerWood.stop();
    }
}
