package com.example.last_spring.gameprealpha.prologue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstCave;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueCaveAfterLabyrinth extends GameActivity {

    public static final String APP_SAVE_WAY_CAVE = "Way cave";

    private RadioGroup radioGroupPrologueCaveStart;

    private RadioButton buttonPrologueCaveAfterFirst;
    private RadioButton buttonPrologueCaveAfterSecond;
    private RadioButton buttonPrologueCaveAfterThird;

    private ScrollView scrollPrologueCaveAfter;

    private TextView textPrologueCaveAfter;

    private boolean isFirst;
    private boolean isSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_cave_after_labyrinth);
        level = 2.14f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.putBoolean(APP_SAVE_WAY_CAVE, true);
        editor.apply();

        startService(new Intent(this, OstCave.class));
        isOstCave = true;

        radioGroupPrologueCaveStart = (RadioGroup) findViewById(R.id.radioGroupPrologueCaveStartID);

        buttonPrologueCaveAfterFirst = (RadioButton) findViewById(R.id.buttonPrologueCaveAfterFirstID);
        buttonPrologueCaveAfterFirst.setTextSize(sizeFonts);
        buttonPrologueCaveAfterSecond = (RadioButton) findViewById(R.id.buttonPrologueCaveAfterSecondID);
        buttonPrologueCaveAfterSecond.setTextSize(sizeFonts);
        buttonPrologueCaveAfterThird = (RadioButton) findViewById(R.id.buttonPrologueCaveAfterThirdID);
        buttonPrologueCaveAfterThird.setTextSize(sizeFonts);

        textPrologueCaveAfter = (TextView) findViewById(R.id.textPrologueCaveAfterID);
        sText(textPrologueCaveAfter);

        scrollPrologueCaveAfter = (ScrollView) findViewById(R.id.scrollPrologueCaveAfterID);
        sScroll(scrollPrologueCaveAfter);

        if (fortune < 80) {
            fortune += 20;
        } else {
            fortune = 100;
        }
        if (wound > 0) {
            wound--;
        }

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        getInterface(false);

        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueCaveStart, scrollPrologueCaveAfter, buttonMenu)));

        textMessage.setText(R.string.prologue_cave_message);
        showMessage(textMessage, true);

    }

    public void onPrologueCaveAfterFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollPrologueCaveAfter);
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            getNextScene(new Intent(this, PrologueBeforeBreakage.class));
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
            isFirst = false;
            buttonPrologueCaveAfterFirst.setBackgroundColor(Color.parseColor("#303030"));
        } else {
            buttonPrologueCaveAfterFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueCaveAfterSecond.setBackgroundColor(Color.parseColor("#303030"));
            isFirst = true;
            isSecond = false;
        }
    }

    public void onPrologueCaveAfterSecond(View view) {
        if (isSecond) {
            textMessage.setText(R.string.prologue_cave_message_second);
            showMessage(textMessage, true);
            refreshScroll(scrollPrologueCaveAfter);
            textPrologueCaveAfter.setText(R.string.prologue_after_labyrinth_text_relax);
            buttonPrologueCaveAfterSecond.setVisibility(View.GONE);
            if (fortune < 90) {
                fortune += 10;
            } else {
                fortune = 100;
            }
            isSecond = false;
            buttonPrologueCaveAfterSecond.setBackgroundColor(Color.parseColor("#303030"));
        } else {
            buttonPrologueCaveAfterSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueCaveAfterFirst.setBackgroundColor(Color.parseColor("#303030"));
            isFirst = false;
            isSecond = true;
        }
    }

    public void onPrologueCaveAfterThirdID(View view) {
    }


}
