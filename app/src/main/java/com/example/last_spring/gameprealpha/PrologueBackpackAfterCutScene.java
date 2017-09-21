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
    private static final String APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT = "Backpack hunter fight";

    private float level;

    private String raincoat;

    private Boolean isCave;
    private Boolean isCamp;
    private Boolean isSleep;
    private Boolean isStandUp;
    private Boolean isFirst;
    private Boolean isKnife;
    private Boolean isSecond;
    private Boolean isThird;

    private RadioGroup radioGroupPrologueBackpackAfterCutStart;
    private RadioGroup radioGroupPrologueBackpackAfterCutNext;
    private RadioGroup radioGrouprologueBackPackAfterCutSceneBeforeStart;

    private RadioButton buttonPrologueBackpackAfterCutSleep;
    private RadioButton buttonPrologueBackpackAfterCutStandUp;
    private RadioButton buttonPrologueBackpackAfterCutMoveCave;
    private RadioButton buttonPrologueBackpackAfterCutMoveCamp;
    private RadioButton buttonPrologueBackPackAfterCutSceneBeforeStartFirst;
    private RadioButton buttonPrologueBackPackAfterCutSceneBeforeStartSecond;
    private RadioButton buttonPrologueBackPackAfterCutSceneBeforeStartThird;

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
        isFirst = false;
        isSecond = false;
        isThird = false;
        isKnife = false;

        finishOst();
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        radioGroupPrologueBackpackAfterCutStart = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackAfterCutStartID);
        radioGroupPrologueBackpackAfterCutNext = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackAfterCutNextID);
        radioGroupPrologueBackpackAfterCutNext.setVisibility(View.GONE);
        radioGrouprologueBackPackAfterCutSceneBeforeStart = (RadioGroup) findViewById(R.id.radioGrouprologueBackPackAfterCutSceneBeforeStartID);

        constraintLayoutCave = (ConstraintLayout) findViewById(R.id.constraintLayoutCaveID);
        Resources res = getResources();
        constraintLayoutCave.setBackground(res.getDrawable(R.drawable.prologue_down_second_scene_morning_background));

        textPrologueBackpackAfterCut = (TextView) findViewById(R.id.textPrologueBackPackAfterCutSceneBeforeStartID);

        buttonPrologueBackpackAfterCutSleep = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutSleepID);
        buttonPrologueBackpackAfterCutStandUp = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutStandUpID);
        buttonPrologueBackpackAfterCutMoveCave = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutMoveCaveID);
        buttonPrologueBackpackAfterCutMoveCamp = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutMoveCampID);
        buttonPrologueBackPackAfterCutSceneBeforeStartFirst = (RadioButton) findViewById(R.id.buttonPrologueBackPackAfterCutSceneBeforeStartFirstID);
        buttonPrologueBackPackAfterCutSceneBeforeStartSecond = (RadioButton) findViewById(R.id.buttonPrologueBackPackAfterCutSceneBeforeStartSecondID);
        buttonPrologueBackPackAfterCutSceneBeforeStartThird = (RadioButton) findViewById(R.id.buttonPrologueBackPackAfterCutSceneBeforeStartThirdID);

        if (save.getBoolean(APP_SAVE_RAINCOAT, false)) {
            raincoat = getString(R.string.text_prologue_backpack_after_cut_start_raincoat);
        } else {
            raincoat = getString(R.string.text_prologue_backpack_after_cut_start_no_raincoat);
        }

        if (save.getBoolean(APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT, false)) {
            if (isKnifeMain) {
                textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_knife);
                radioGroupPrologueBackpackAfterCutStart.setVisibility(View.GONE);
                radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.VISIBLE);
                isKnife = true;
            } else {
                if (wound == 0 && !isFaim) {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_no_knife);
                    radioGroupPrologueBackpackAfterCutStart.setVisibility(View.GONE);
                    radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.VISIBLE);
                    isKnife = true;
                    buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setVisibility(View.GONE);
                } else if (wound != 0 && !isFaim) {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_no_knife_wound);
                    radioGroupPrologueBackpackAfterCutStart.setVisibility(View.GONE);
                    radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.VISIBLE);
                    isKnife = true;
                    buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setVisibility(View.GONE);
                } else {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_no_knife_faim);
                    radioGroupPrologueBackpackAfterCutStart.setVisibility(View.GONE);
                    radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.VISIBLE);
                    isKnife = true;
                    buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setVisibility(View.GONE);
                }
            }
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
        if (isCave) {
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
        if (isCamp) {
            getNextScene(new Intent(this, PrologueRain.class));
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        buttonPrologueBackpackAfterCutMoveCave.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueBackpackAfterCutMoveCamp.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isCave = false;
        isCamp = true;
    }

    public void onPrologueBackPackAfterCutSceneBeforeStartFirst(View view) {
        if (isFirst) {
            if (isKnife) {
                textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_knife);
                radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.GONE);
                radioGroupPrologueBackpackAfterCutStart.setVisibility(View.VISIBLE);
                buttonPrologueBackpackAfterCutStandUp.setVisibility(View.GONE);
                isKnife = false;
            }
            buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
        } else {
            buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBackPackAfterCutSceneBeforeStartThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
            isThird = false;
        }
    }

    public void onPrologueBackPackAfterCutSceneBeforeStartSecond(View view) {
        if (isSecond) {
            if (isKnife) {
                if (wound == 0 && !isFaim) {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_no_knife);
                    buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setVisibility(View.GONE);
                    buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setVisibility(View.GONE);
                    buttonPrologueBackPackAfterCutSceneBeforeStartThird.setVisibility(View.VISIBLE);

                } else if (wound != 0 && !isFaim) {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_no_knife_wound);
                    buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setVisibility(View.GONE);
                    buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setVisibility(View.GONE);
                    buttonPrologueBackPackAfterCutSceneBeforeStartThird.setVisibility(View.VISIBLE);

                } else {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_no_knife_faim);
                    buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setVisibility(View.GONE);
                    buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setVisibility(View.GONE);
                    buttonPrologueBackPackAfterCutSceneBeforeStartThird.setVisibility(View.VISIBLE);

                }
            }
            buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isSecond = false;
        } else {
            buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueBackPackAfterCutSceneBeforeStartThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
            isThird = false;
        }
    }

    public void onPrologueBackPackAfterCutSceneBeforeStartThird(View view) {
        if (isThird) {
            if (isKnife) {
                if (wound == 0 && !isFaim) {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_no_knife_next);
                    radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.GONE);
                    radioGroupPrologueBackpackAfterCutStart.setVisibility(View.VISIBLE);
                    isKnife = false;
                } else if (wound != 0 && !isFaim) {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_no_knife_wound_next);
                    radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.GONE);
                    radioGroupPrologueBackpackAfterCutStart.setVisibility(View.VISIBLE);
                    isKnife = false;
                } else {
                    textPrologueBackpackAfterCut.setText(R.string.button_prologue_backpack_after_cut_scene_text_knife_no_knife_faim_next);
                    radioGrouprologueBackPackAfterCutSceneBeforeStart.setVisibility(View.GONE);
                    radioGroupPrologueBackpackAfterCutStart.setVisibility(View.VISIBLE);
                    isKnife = false;
                }
            }
            buttonPrologueBackPackAfterCutSceneBeforeStartThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isThird = false;
        } else {
            buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBackPackAfterCutSceneBeforeStartThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = false;
            isSecond = false;
            isThird = true;
        }
    }
}
