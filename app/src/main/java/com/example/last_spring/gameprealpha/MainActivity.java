package com.example.last_spring.gameprealpha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;


import com.example.last_spring.gameprealpha.res.GameActivity;
import com.example.last_spring.gameprealpha.res.LevelsList;
import com.example.last_spring.gameprealpha.res.TypefaceUtil;

public class MainActivity extends AppCompatActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_START = "New game";
    private static final String APP_SAVE_LEVEL = "Level";
    private SharedPreferences settings;
    private ConstraintLayout constraintLayoutPrologueMain;
    private boolean isNewGame;
    private View decorView;
    private CountDownTimer timer;
    private Button buttonStartMain;
    private Button buttonСontinueMain;
    private Button buttonExitMain;
    private MediaPlayer ostMain;


    private boolean isOstStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        isNewGame = settings.getBoolean(APP_SAVE_START, true);

        ostMain = MediaPlayer.create(this, R.raw.ost_main);
        ostMain.start();

        ostMain.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });


        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/circe.otf");
        buttonStartMain = (Button) findViewById(R.id.buttonStartMainID);
        buttonСontinueMain = (Button) findViewById(R.id.buttonСontinueMainID);
        buttonExitMain = (Button) findViewById(R.id.buttonExitMainID);
        checkForUpdates();
    }

    public void onResume() {
        super.onResume();
        checkForCrashes();
        if(isOstStop) {
            ostMain = MediaPlayer.create(this, R.raw.ost_main);
            isOstStop = false;
            ostMain.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterManagers();
        if (!isOstStop) {
            isOstStop = true;
            ostMain.stop();
        }
    }

    public void onStartMain(View view) {
        timer = new CountDownTimer(400, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonStartMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonStartMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();

        isNewGame = false;
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
        editor.putBoolean(APP_SAVE_START, isNewGame);
        editor.apply();
        ostMain.stop();
        Intent intent = new Intent(MainActivity.this, PrologueTitle.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }

    public void onContinueMain(View view) {
        timer = new CountDownTimer(400, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonСontinueMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonСontinueMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();
        if (isNewGame) {
            view.setClickable(false);
        } else {
            float level = settings.getFloat(APP_SAVE_LEVEL, 0);
            Intent intent = new Intent(MainActivity.this, LevelsList.getLevel(level));
            startActivity(intent);
            ostMain.stop();
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
    }

    public void onExitMain(View view) {
        timer = new CountDownTimer(400, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonExitMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonExitMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();
        ostMain.stop();
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterManagers();
    }

    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }



    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    AlertDialog.Builder dialog;

    private void openQuitDialog() {
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.button_dialog_title);
        dialog.setPositiveButton(R.string.button_dialog_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton(R.string.button_dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void onOldCamp(View view) {
        ostMain.stop();
        startActivity(new Intent(this, PrologueOldStory.class));
        finish();
    }

    public void onHunting(View view) {
        ostMain.stop();
        startActivity(new Intent(this, PrologueBreakage.class));
        finish();
    }

    public void onSettingsMain(View view) {
        startActivity(new Intent(this,MainSettings.class));
    }
}
