package com.example.last_spring.gameprealpha;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.Random;

public class Prologue_start extends GameActivity {
    public RadioButton buttonPrologueTent;
    public RadioButton buttonPrologueMoveUp;
    public RadioButton buttonPrologueMoveDown;
    public static final String APP_SAVE_LEVEL = "Level";
    public static final String APP_SAVE_FORTUNE = "Fortune";
    public static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    public static final String APP_SAVE_TENT_PROLOGUE = "Tent_prologue";
    public static final String APP_SAVE = "Save";
    public TextView prologueTextMain;
    public boolean isButtonPrologueTent;
    public boolean isButtonPrologueMoveUp;
    public boolean isButtonPrologueMoveDown;
    public float level;
    public RadioGroup radioGroupPrologue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prolog_start);
        level = 1;
        fortune = 60;
        wound = 1;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.putInt(APP_SAVE_FORTUNE, fortune);
        editor.putInt(APP_SAVE_WOUND, wound);
        editor.apply();
        buttonPrologueTent = (RadioButton) findViewById(R.id.buttonPrologueTentID);
        buttonPrologueMoveUp = (RadioButton) findViewById(R.id.buttonPrologueMoveUpID);
        buttonPrologueMoveDown = (RadioButton) findViewById(R.id.buttonPrologueMoveDownID);
        radioGroupPrologue = (RadioGroup) findViewById(R.id.radioGroupPrologueID);
        prologueTextMain = (TextView) findViewById(R.id.prologue_textMainID);
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        if (save.getInt(APP_SAVE_TENT_PROLOGUE, 0) != 0) {
            buttonPrologueTent.setVisibility(View.GONE);
        }
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
            Intent intent = new Intent(Prologue_start.this, PrologueUpFirstScene.class);
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
            Intent intent = new Intent(Prologue_start.this, PrologueDownFirstScene.class);
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
            editor.apply();
            prologueTextMain.setText(R.string.prologue_tent_fail);
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
            editor.apply();
            isSleepingBugMain = true;
            prologueTextMain.setText(R.string.prologue_tent_luck);
            return fortune;
        }
    }

    public void test(View view) {
        getNextScene(new Intent(this, PrologueBreakage.class));
        finish();
    }
}

