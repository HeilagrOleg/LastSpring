package com.example.last_spring.gameprealpha.res;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.R;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstDisturbance;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;

public class GameActivityTwo extends AppCompatActivity {

    private static final String APP_SETTINGS = "Settings";
    private static final String APP_SETTINGS_SETTINGS_FONTS_SIZE = "Fonts size";
    private static final String APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING = "Line spacing";

    public static final String APP_SAVE = "Save";
    public static final String APP_SAVE_LEVEL = "Level";
    public static final String APP_SAVE_FORTUNE = "Fortune";

    public SharedPreferences save;
    public SharedPreferences settings;
    public int fortune;
    public int wound;
    public boolean isExitScene;
    public boolean isOst;
    public boolean isOstStop;
    public boolean isOstWood;
    public boolean isOstCave;
    public boolean isOstDisturbance;
    public float level;
    public float sizeFonts;
    public float lineSpacing;

    public Animation animationStart;

    public MediaPlayer ost;

    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    AlertDialog.Builder dialog;
    private View decorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        settings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        sizeFonts = settings.getFloat(APP_SETTINGS_SETTINGS_FONTS_SIZE, 18f);
        lineSpacing = settings.getFloat(APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING, 3f);
        fortune = save.getInt(APP_SAVE_FORTUNE, 0);
        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        animationStart = AnimationUtils.loadAnimation(this, R.anim.title_in);
    }

    public void onInventory(View view) {
        openQuitDialog();
    }

    private void openQuitDialog() {

        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.button_dialog_title);
        dialog.setPositiveButton(R.string.button_dialog_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishOst();
                finish();
            }
        });
        dialog.setNeutralButton(R.string.button_dialog_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishOst();
                Intent intent = new Intent(GameActivityTwo.this, MainActivity.class);
                startActivity(intent);
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

    public void finishOst() {
        stopService(new Intent(this, OstWood.class));
        stopService(new Intent(this, OstDisturbance.class));
        stopService(new Intent(this, OstCave.class));
        if (isOst) {
            ost.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isOst) {
            ost.stop();
        }
        if (!isOstStop && !isExitScene) {
            finishOst();
            isOstStop = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isOst) {
            ost.start();
        }
        if (isOstStop && !isOst) {
            if (isOstWood) {
                startService(new Intent(this, OstWood.class));
            } else if (isOstCave) {
                startService(new Intent(this, OstCave.class));
            } else if (isOstDisturbance) {
                startService(new Intent(this, OstDisturbance.class));
            }
        }
    }

    public void getSave(float level) {
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
    }

    public void getNextScene(Intent intent) {
        isExitScene = true;
        startActivity(intent);
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }

    public void startAnimation(final ArrayList<View> list) {
        new CountDownTimer(500, 500) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                for (View e : list) {
                    e.startAnimation(animationStart);
                    e.setVisibility(View.VISIBLE);
                }
            }
        }.start();
    }

    public void sText(TextView view) {
        view.setTextSize(sizeFonts);
        view.setLineSpacing(lineSpacing, 0.8f);
    }

    public void sScroll(ScrollView view) {

    }

    public void refreshScroll(ScrollView view) {
        view.scrollTo(0, 0);
    }
}
