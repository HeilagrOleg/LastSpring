package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueBackpackAfterCutScene extends GameActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    private static final String APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT = "Backpack hunter fight";
    private static final String APP_SAVE_PROLOGUE_BACKPACK_HUNTER_MAIN = "Backpack hunter main";

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

    private FrameLayout linearLayoutPrologueBackpackAfterCut;

    private ScrollView scrollPrologueBackPackAfterCutScene;

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

        textMessage = (TextView) findViewById(R.id.textMessageID);

        radioGroupPrologueBackpackAfterCutStart = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackAfterCutStartID);
        radioGroupPrologueBackpackAfterCutNext = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackAfterCutNextID);
        radioGroupPrologueBackpackAfterCutNext.setVisibility(View.GONE);
        radioGrouprologueBackPackAfterCutSceneBeforeStart = (RadioGroup) findViewById(R.id.radioGrouprologueBackPackAfterCutSceneBeforeStartID);

        constraintLayoutCave = (ConstraintLayout) findViewById(R.id.constraintLayoutCaveID);
        Resources res = getResources();
        constraintLayoutCave.setBackground(res.getDrawable(R.drawable.prologue_down_second_scene_morning_background));

        textPrologueBackpackAfterCut = (TextView) findViewById(R.id.textPrologueBackPackAfterCutSceneBeforeStartID);
        sText(textPrologueBackpackAfterCut);
        textPrologueBackpackAfterCut.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

        linearLayoutPrologueBackpackAfterCut = (FrameLayout) findViewById(R.id.linearLayoutPrologueBackpackAfterCutID);

        scrollPrologueBackPackAfterCutScene = (ScrollView) findViewById(R.id.scrollPrologueBackPackAfterCutSceneID);
        sScroll(scrollPrologueBackPackAfterCutScene);

        buttonPrologueBackpackAfterCutSleep = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutSleepID);
        buttonPrologueBackpackAfterCutSleep.setTextSize(sizeFonts);
        buttonPrologueBackpackAfterCutStandUp = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutStandUpID);
        buttonPrologueBackpackAfterCutStandUp.setTextSize(sizeFonts);
        buttonPrologueBackpackAfterCutMoveCave = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutMoveCaveID);
        buttonPrologueBackpackAfterCutMoveCave.setTextSize(sizeFonts);
        buttonPrologueBackpackAfterCutMoveCamp = (RadioButton) findViewById(R.id.buttonPrologueBackpackAfterCutMoveCampID);
        buttonPrologueBackpackAfterCutMoveCamp.setTextSize(sizeFonts);
        buttonPrologueBackPackAfterCutSceneBeforeStartFirst = (RadioButton) findViewById(R.id.buttonPrologueBackPackAfterCutSceneBeforeStartFirstID);
        buttonPrologueBackPackAfterCutSceneBeforeStartFirst.setTextSize(sizeFonts);
        buttonPrologueBackPackAfterCutSceneBeforeStartSecond = (RadioButton) findViewById(R.id.buttonPrologueBackPackAfterCutSceneBeforeStartSecondID);
        buttonPrologueBackPackAfterCutSceneBeforeStartSecond.setTextSize(sizeFonts);
        buttonPrologueBackPackAfterCutSceneBeforeStartThird = (RadioButton) findViewById(R.id.buttonPrologueBackPackAfterCutSceneBeforeStartThirdID);
        buttonPrologueBackPackAfterCutSceneBeforeStartThird.setTextSize(sizeFonts);

        if (save.getBoolean(APP_SAVE_RAINCOAT, false)) {
            raincoat = getString(R.string.text_prologue_backpack_after_cut_start_raincoat);
        } else {
            raincoat = getString(R.string.text_prologue_backpack_after_cut_start_no_raincoat);
        }

        if (save.getBoolean(APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT, false)) {



            textMessage.setText(R.string.button_prologue_backpack_after_cut_scene_message_start);
            showMessage(textMessage, true);

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
        } else {
            textMessage.setText(R.string.button_prologue_backpack_after_cut_scene_message_hunter);
            showMessage(textMessage, true);
        }

        getInterface(true);

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        startAnimation(new ArrayList<View>(Arrays.asList(linearLayoutPrologueBackpackAfterCut, scrollPrologueBackPackAfterCutScene, buttonMenu)));
    }

    public void onPrologueBackpackAfterCutSleep(View view) {
        if (isSleep) {
            refreshScroll(scrollPrologueBackPackAfterCutScene);
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
            refreshScroll(scrollPrologueBackPackAfterCutScene);
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
            refreshScroll(scrollPrologueBackPackAfterCutScene);
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
            refreshScroll(scrollPrologueBackPackAfterCutScene);
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
            refreshScroll(scrollPrologueBackPackAfterCutScene);
            if (isKnife) {
                textMessage.setText(R.string.button_prologue_backpack_after_cut_scene_message_hunter_wound);
                showMessage(textMessage, false);
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
            refreshScroll(scrollPrologueBackPackAfterCutScene);
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
            refreshScroll(scrollPrologueBackPackAfterCutScene);
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
