package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueRain extends GameActivity {

    public static final String APP_SAVE_CAVE_FAIL = "Cave fail";
    public static final String APP_SAVE_RAIN = "Rain";

    private RadioGroup radioGroupPrologueRain;

    private RadioButton buttonPrologueRainFirst;
    private RadioButton buttonPrologueRainSecond;
    private RadioButton buttonPrologueRainThird;

    private ScrollView scrollPrologueRain;

    private TextView textPrologueRainStart;

    private boolean isFirst;
    private boolean isSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_rain);

        level = 2.141f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.putBoolean(APP_SAVE_RAIN,true);
        editor.apply();

        stopService(new Intent(this, OstCave.class));

        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        radioGroupPrologueRain = (RadioGroup) findViewById(R.id.radioGroupPrologueRainID);

        buttonPrologueRainFirst = (RadioButton) findViewById(R.id.buttonPrologueRainFirstID);
        buttonPrologueRainFirst.setTextSize(sizeFonts);
        buttonPrologueRainSecond = (RadioButton) findViewById(R.id.buttonPrologueRainSecondID);
        buttonPrologueRainSecond.setTextSize(sizeFonts);
        buttonPrologueRainThird = (RadioButton) findViewById(R.id.buttonPrologueRainThirdID);
        buttonPrologueRainThird.setTextSize(sizeFonts);

        scrollPrologueRain = (ScrollView) findViewById(R.id.scrollPrologueRainID);
        sScroll(scrollPrologueRain);

        textPrologueRainStart = (TextView) findViewById(R.id.textPrologueRainStartID);
        sText(textPrologueRainStart);

        if (save.getBoolean(APP_SAVE_CAVE_FAIL, false)) {
            textPrologueRainStart.setText(R.string.prologue_rain_text_start_cave_fail);
        }

        if (save.getBoolean(APP_SAVE_RAINCOAT, false)) {
            buttonPrologueRainFirst.setVisibility(View.VISIBLE);
        }

        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueRain, radioGroupPrologueRain)));

    }

    public void onPrologueRainFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollPrologueRain);
            textPrologueRainStart.setText(R.string.prologue_rain_text_raincoat);
            buttonPrologueRainFirst.setVisibility(View.GONE);
            isFirst = false;
            buttonPrologueRainFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueRainFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueRainThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
        }
    }

    public void onPrologueRainSecond(View view) {
    }

    public void onPrologueRainThird(View view) {
        if (isSecond) {
            refreshScroll(scrollPrologueRain);
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            getNextScene(new Intent(this, PrologueBeforeBreakage.class));
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
            isSecond = false;
            buttonPrologueRainThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueRainThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueRainFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            isSecond = true;
            isFirst = false;
        }
    }
}
