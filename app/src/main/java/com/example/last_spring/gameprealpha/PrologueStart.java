package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.example.last_spring.gameprealpha.res.TypefaceUtil;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrologueStart extends GameActivity {
    public RadioButton buttonPrologueTent;
    public RadioButton buttonPrologueMoveUp;
    public RadioButton buttonPrologueMoveDown;
    public static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    public static final String APP_SAVE_TENT_PROLOGUE = "Tent_prologue";
    public TextView textPrologueMain;
    public boolean isButtonPrologueTent;
    public boolean isButtonPrologueMoveUp;
    public boolean isButtonPrologueMoveDown;
    public float level;
    public RadioGroup radioGroupPrologue;

    private ScrollView scrollPrologueMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prolog_start);
        level = 1;
        fortune = 60;
        wound = 1;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        buttonPrologueTent = (RadioButton) findViewById(R.id.buttonPrologueTentID);
        buttonPrologueMoveUp = (RadioButton) findViewById(R.id.buttonPrologueMoveUpID);
        buttonPrologueMoveDown = (RadioButton) findViewById(R.id.buttonPrologueMoveDownID);
        radioGroupPrologue = (RadioGroup) findViewById(R.id.radioGroupPrologueID);
        textPrologueMain = (TextView) findViewById(R.id.textPrologueMainID);
        scrollPrologueMain = (ScrollView) findViewById(R.id.scrollPrologueMainID);
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        if (save.getInt(APP_SAVE_TENT_PROLOGUE, 0) != 0) {
            buttonPrologueTent.setVisibility(View.GONE);
        }

        textPrologueMain.setTextSize(sizeFonts);
        buttonPrologueMoveDown.setTextSize(sizeFonts);
        buttonPrologueMoveUp.setTextSize(sizeFonts);
        buttonPrologueTent.setTextSize(sizeFonts);

        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologue,scrollPrologueMain)));
    }

    public void onPrologueTent(View view) {
        if (isButtonPrologueTent) {
           fortune = checkTentPrologue(fortune);
            view.setVisibility(View.GONE);
        } else {
            buttonPrologueTent.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueMoveUp.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueMoveDown.setBackgroundColor(Color.parseColor("#60ffffff"));
            isButtonPrologueTent = true;
            isButtonPrologueMoveUp = false;
            isButtonPrologueMoveDown = false;
        }
    }

    public void onPrologueMoveUp(View view) {
        if (isButtonPrologueMoveUp) {
            Intent intent = new Intent(PrologueStart.this, PrologueUpFirstScene.class);
            getNextScene(intent);
            finish();
        } else {
            buttonPrologueTent.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueMoveUp.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueMoveDown.setBackgroundColor(Color.parseColor("#60ffffff"));
            isButtonPrologueTent = false;
            isButtonPrologueMoveUp = true;
            isButtonPrologueMoveDown = false;
        }
    }

    public void onPrologueMoveDown(View view) {
        if (isButtonPrologueMoveDown) {
            Intent intent = new Intent(PrologueStart.this, PrologueDownFirstScene.class);
            getNextScene(intent);
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        buttonPrologueTent.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueMoveUp.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueMoveDown.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isButtonPrologueTent = false;
        isButtonPrologueMoveUp = false;
        isButtonPrologueMoveDown = true;
    }

    private int checkTentPrologue(int fortune) {
        Random random = new Random();
        int number = random.nextInt(65);
        if (number > fortune) {
            save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
            if (fortune <= 90) {
                fortune += 10;
            }
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_TENT_PROLOGUE, 1);
            editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
            editor.putInt(APP_SAVE_WOUND,wound);
            editor.apply();
            textPrologueMain.setText(R.string.prologue_tent_fail);
            return fortune;
        } else {
            save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
            if (fortune >= 10) {
                fortune -= 10;
            }
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_TENT_PROLOGUE, 2);
            editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, true);
            editor.putInt(APP_SAVE_WOUND,wound);
            editor.apply();
            isSleepingBugMain = true;
            textPrologueMain.setText(R.string.prologue_tent_luck);
            return fortune;
        }
    }
}

