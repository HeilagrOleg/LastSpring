package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class PrologueRain extends GameActivity {

    public static final String APP_SAVE_CAVE_FAIL = "Cave fail";
    public static final String APP_SAVE_RAIN = "Rain";

    private RadioButton buttonPrologueRainFirst;
    private RadioButton buttonPrologueRainSecond;
    private RadioButton buttonPrologueRainThird;

    private TextView textPrologueRainStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_rain);

        level = 2.141f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.putBoolean(APP_SAVE_RAIN,true);
        editor.apply();

        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        buttonPrologueRainFirst = (RadioButton) findViewById(R.id.buttonPrologueRainFirstID);
        buttonPrologueRainSecond = (RadioButton) findViewById(R.id.buttonPrologueRainSecondID);
        buttonPrologueRainThird = (RadioButton) findViewById(R.id.buttonPrologueRainThirdID);

        textPrologueRainStart = (TextView) findViewById(R.id.textPrologueRainStartID);

        if (save.getBoolean(APP_SAVE_CAVE_FAIL, false)) {
            textPrologueRainStart.setText(R.string.prologue_rain_text_start_cave_fail);
        }

        if (save.getBoolean(APP_SAVE_RAINCOAT, false)) {
            buttonPrologueRainFirst.setVisibility(View.VISIBLE);
        }
    }

    public void onPrologueRainFirst(View view) {
        textPrologueRainStart.setText(R.string.prologue_rain_text_raincoat);
        buttonPrologueRainFirst.setVisibility(View.GONE);
    }

    public void onPrologueRainSecond(View view) {
    }

    public void onPrologueRainThird(View view) {
        SharedPreferences.Editor editor = save.edit();
        editor.putInt(APP_SAVE_WOUND,wound);
        editor.apply();
        getNextScene(new Intent(this, PrologueBeforeBreakage.class));
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        finish();
    }
}
