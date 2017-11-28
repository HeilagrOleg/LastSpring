package com.last_spring.gameprealpha;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.last_spring.gameprealpha.R;

public class OstRoad extends Service {
    public MediaPlayer playerRoad;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playerRoad = MediaPlayer.create(this, R.raw.ost_road);
        playerRoad.setLooping(true);
    }


    public OstRoad() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playerRoad.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        playerRoad.stop();
    }
}
