package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class PrologueBackpackAfterCutScene extends GameActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";

    private float level;

    private String raincoat;

    private Boolean isCave;
    private Boolean isCamp;
    private Boolean isSleep;
    private Boolean isStandUp;

    private RadioGroup radioGroupPrologueBackpackAfterCutStart;
    private RadioGroup radioGroupPrologueBackpackAfterCutNext;

    private RadioButton buttonPrologueBackpackAfterCutSleep;
    private RadioButton buttonPrologueBackpackAfterCutStandUp;
    private RadioButton buttonPrologueBackpackAfterCutMoveCave;
    private RadioButton buttonPrologueBackpackAfterCutMoveCamp;

    private ConstraintLayout constraintLayoutCave;

    private TextView textPrologueBackpackAfterCut;
    private SharedPreferences save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_backpack_after_cut_scene);

        level = 2.122f;

        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
        isSleep = false;
        isStandUp = false;
        isCave = false;
        isCamp = false;

        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        radioGroupPrologueBackpackAfterCutStart = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackAfterCutStartID);
        textPrologueBackpackAfterCut = (TextView) findViewById(R.id.textPrologueBackpackAfterCutID);
        radioGroupPrologueBackpackAfterCutNext = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackAfterCutNextID);
        radioGroupPrologueBackpackAfterCutNext.setVisibility(View.GONE);

        constraintLayoutCave = (ConstraintLayout) findViewById(R.id.constraintLayoutCaveID);
        Resources res = getResources();
        constraintLayoutCave.setBackground(res.getDrawable(R.drawable.prologue_down_second_scene_no_backpack_background));

        buttonPrologueBackpackAfterCutSleep = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutSleepID);
        buttonPrologueBackpackAfterCutStandUp = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutStandUpID);
        buttonPrologueBackpackAfterCutMoveCave = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutMoveCaveID);
        buttonPrologueBackpackAfterCutMoveCamp = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutMoveCampID);

        if (save.getBoolean(APP_SAVE_RAINCOAT, false)) {
            raincoat = getString(R.string.text_prologue_backpack_after_cut_start_raincoat);
        } else {
            raincoat = getString(R.string.text_prologue_backpack_after_cut_start_no_raincoat);
        }
    }

    public void onPrologueBackpackAfterCutSleep(View view) {
        if (isSleep) {
            radioGroupPrologueBackpackAfterCutStart.setVisibility(View.GONE);
            textPrologueBackpackAfterCut.setText(getString(R.string.text_prologue_backpack_after_cut_start_sleep, raincoat));
            Resources res = getResources();
            constraintLayoutCave.setBackground(res.getDrawable(R.drawable.prologue_cave_background));
            radioGroupPrologueBackpackAfterCutNext.setVisibility(View.VISIBLE);
        }
        buttonPrologueBackpackAfterCutSleep.setBackgroundColor(Color.parseColor("#607e9e7f"));
        buttonPrologueBackpackAfterCutStandUp.setBackgroundColor(Color.parseColor("#60ffffff"));
        isSleep = true;
        isStandUp = false;
    }

    public void onPrologueBackpackAfterCutStandUp(View view) {
        if (isStandUp) {
            radioGroupPrologueBackpackAfterCutStart.setVisibility(View.GONE);
            textPrologueBackpackAfterCut.setText(getString(R.string.text_prologue_backpack_after_cut_start_no_sleep, raincoat));
            Resources res = getResources();
            constraintLayoutCave.setBackground(res.getDrawable(R.drawable.prologue_cave_background));
            radioGroupPrologueBackpackAfterCutNext.setVisibility(View.VISIBLE);
        }
        buttonPrologueBackpackAfterCutStandUp.setBackgroundColor(Color.parseColor("#607e9e7f"));
        buttonPrologueBackpackAfterCutSleep.setBackgroundColor(Color.parseColor("#60ffffff"));
        isStandUp = true;
        isSleep = false;
    }

    public void onPrologueBackpackAfterCutMoveCave(View view) {
        if(isCave) {
            getNextScene(new Intent(this, PrologueCave.class));
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        buttonPrologueBackpackAfterCutMoveCave.setBackgroundColor(Color.parseColor("#607e9e7f"));
        buttonPrologueBackpackAfterCutMoveCamp.setBackgroundColor(Color.parseColor("#60ffffff"));
        isCave = true;
        isCamp = false;
    }

    public void onPrologueBackpackAfterCutMoveCamp(View view) {
        if(isCamp) {
            getNextScene(new Intent(this, PrologueRain.class));
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        buttonPrologueBackpackAfterCutMoveCave.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueBackpackAfterCutMoveCamp.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isCave = false;
        isCamp = true;
    }
}
