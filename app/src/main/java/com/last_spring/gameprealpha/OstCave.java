package com.last_spring.gameprealpha;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.last_spring.gameprealpha.R;

public class OstCave extends Service {
    public MediaPlayer playerStrangest;

    public OstCave() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        playerStrangest = MediaPlayer.create(this, R.raw.ost_strangest);
        playerStrangest.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        playerStrangest.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        playerStrangest.stop();
    }
}
