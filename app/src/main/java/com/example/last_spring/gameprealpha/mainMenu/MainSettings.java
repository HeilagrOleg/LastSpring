package com.example.last_spring.gameprealpha.mainMenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.TypefaceUtil;

public class MainSettings extends AppCompatActivity {

    private static final String APP_SETTINGS_SETTINGS_FONTS_SIZE = "Fonts size";
    private static final String APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING = "Line spacing";
    private static final String APP_SETTINGS_SETTINGS_FONTS_BACKGROUND = "Background";
    private static final String APP_SETTINGS = "Settings";


    private View decorView;

    private SharedPreferences settings;

    private float size;
    private float lineSpacing;

    private int fontsCounter;

    private int backgroundCounter;

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
        lineSpacing = (settings.getFloat(APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING, 3f));

        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);
        textSettingsMain.setLineSpacing(lineSpacing,0.8f);

        backgroundCounter = settings.getInt(APP_SETTINGS_SETTINGS_FONTS_BACKGROUND, 75);
        textSettingsMain.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

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
        size--;

        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);
        textSettingsMain.setLineSpacing(lineSpacing,0.8f);;
    }

    public void onDownTextSize(View view) {
        if (size > 2) {
            size++;
        }

        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);
        textSettingsMain.setLineSpacing(lineSpacing,0.8f);
    }

    public void onBackSettings(View view) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(APP_SETTINGS_SETTINGS_FONTS_SIZE, size);
        editor.putFloat(APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING, lineSpacing);
        editor.putInt(APP_SETTINGS_SETTINGS_FONTS_BACKGROUND, backgroundCounter);
        editor.apply();
        finish();
    }

    public void onSettingsFonts(View view) {
        if (fontsCounter == 0) {
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/geometria.otf");
            setContentView(R.layout.activity_main_settings);
            textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
            textSettingsMain.setTextSize(size);
            textSettingsMain.setLineSpacing(lineSpacing,0.8f);
            fontsCounter++;
        } else if (fontsCounter == 1) {
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/neris.otf");
            setContentView(R.layout.activity_main_settings);
            textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
            textSettingsMain.setTextSize(size);
            textSettingsMain.setLineSpacing(lineSpacing,0.8f);
            fontsCounter++;
        } else {
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/proba.otf");
            setContentView(R.layout.activity_main_settings);
            textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
            textSettingsMain.setTextSize(size);
            textSettingsMain.setLineSpacing(lineSpacing,0.8f);
            fontsCounter = 0;
        }
    }

    public void onDownLineSpacing(View view) {
        if (lineSpacing > 1) {
            lineSpacing--;

            textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
            textSettingsMain.setTextSize(size);
            textSettingsMain.setLineSpacing(lineSpacing,0.8f);
        }
    }

    public void onUpLineSpacing(View view) {
        lineSpacing++;

        textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
        textSettingsMain.setTextSize(size);
        textSettingsMain.setLineSpacing(lineSpacing,0.8f);
    }

    public void onDownBackground(View view) {
        if (backgroundCounter>=15) {
            backgroundCounter -= 5;
            textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
            textSettingsMain.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));
        }
    }

    public void onUpBackground(View view) {
        if (backgroundCounter<=94) {
            backgroundCounter += 5;
            textSettingsMain = (TextView) findViewById(R.id.textSettingsMainID);
            textSettingsMain.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));
        }
    }
}
