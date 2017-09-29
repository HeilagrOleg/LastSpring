package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.TypefaceUtil;

public class MainSettings extends AppCompatActivity {

    private static final String APP_SETTINGS_SETTINGS_FONTS_SIZE = "Fonts size";
    private static final String APP_SETTINGS = "Settings";


    private View decorView;

    private SharedPreferences settings;

    private float size;

    private int fontsCounter;

    private TextView textSettingsMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        settings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        size = settings.getFloat(APP_SETTINGS_SETTINGS_FONTS_SIZE, 18f);

        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);

        fontsCounter = 0;
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


    public void onUpTextSize(View view) {

        size --;
        textSettingsMain.setTextSize(size);
        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);

    }

    public void onDownTextSize(View view) {
        if (size > 2) {
            size ++;
        }
        textSettingsMain.setTextSize(size);
        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);
    }

    public void onBackSettings(View view) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(APP_SETTINGS_SETTINGS_FONTS_SIZE, size);
        editor.apply();
        finish();
    }

    public void onSettingsFonts(View view) {
        if (fontsCounter==0) {
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/geometria.otf");
            setContentView(R.layout.activity_main_settings);
            textSettingsMain.setTextSize(size);
            fontsCounter++;
        } else if (fontsCounter==1) {
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/neris.otf");
            setContentView(R.layout.activity_main_settings);
            textSettingsMain.setTextSize(size);
            fontsCounter++;
        } else {
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/proba.otf");
            setContentView(R.layout.activity_main_settings);
            textSettingsMain.setTextSize(size);
            fontsCounter=0;
        }
    }
}
