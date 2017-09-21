package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstWood;

public class PrologueCaveAfterLabyrinth extends GameActivity {

    public static final String APP_SAVE_WAY_CAVE = "Way cave";

    private RadioButton buttonPrologueCaveAfterFirst;
    private RadioButton buttonPrologueCaveAfterSecond;
    private RadioButton buttonPrologueCaveAfterThird;

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

        buttonPrologueCaveAfterFirst = (RadioButton) findViewById(R.id.buttonPrologueCaveAfterFirstID);
        buttonPrologueCaveAfterSecond = (RadioButton) findViewById(R.id.buttonPrologueCaveAfterSecondID);
        buttonPrologueCaveAfterThird = (RadioButton) findViewById(R.id.buttonPrologueCaveAfterThirdID);

        textPrologueCaveAfter = (TextView) findViewById(R.id.textPrologueCaveAfterID);

        if (fortune < 80) {
            fortune += 20;
        } else {
            fortune = 100;
        }
        if (wound > 0) {
            wound--;
        }

    }

    public void onPrologueCaveAfterFirst(View view) {
        if (isFirst) {
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            getNextScene(new Intent(this, PrologueBeforeBreakage.class));
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
            isFirst = false;
            buttonPrologueCaveAfterFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueCaveAfterFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueCaveAfterSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
        }
    }

    public void onPrologueCaveAfterSecond(View view) {
        if (isSecond) {
        textPrologueCaveAfter.setText(R.string.prologue_after_labyrinth_text_relax);
        buttonPrologueCaveAfterSecond.setVisibility(View.GONE);
        if(fortune<90) {
            fortune += 10;
        } else {
            fortune = 100;
        }
            isSecond = false;
            buttonPrologueCaveAfterSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueCaveAfterSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueCaveAfterFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
        }
    }

    public void onPrologueCaveAfterThirdID(View view) {
    }


}
