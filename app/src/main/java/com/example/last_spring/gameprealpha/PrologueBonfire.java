package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class PrologueBonfire extends GameActivity {

    private RadioGroup radioGroupPrologueBonfire;
    private RadioButton buttonPrologueBonfireFirst;
    private RadioButton buttonPrologueBonfireSecond;
    private RadioButton buttonPrologueBonfireThird;

    private TextView textPrologueBonfireMain;

    private boolean isFirst;
    private boolean isSecond;
    private boolean isThird;
    private boolean isDown;
    private boolean isExit;
    private boolean isUndergrowth;
    private boolean isDownWay;
    private boolean isUndergrowthWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_bonfire);

        level = 2.101f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        radioGroupPrologueBonfire = (RadioGroup) findViewById(R.id.radioGroupPrologueBonfireID);
        buttonPrologueBonfireFirst = (RadioButton) findViewById(R.id.buttonPrologueBonfireFirstID);
        buttonPrologueBonfireSecond = (RadioButton) findViewById(R.id.buttonPrologueBonfireSecondID);
        buttonPrologueBonfireThird = (RadioButton) findViewById(R.id.buttonPrologueBonfireThirdID);

        textPrologueBonfireMain = (TextView) findViewById(R.id.textPrologueBonfireMainID);

        isDown = false;

    }

    public void onPrologueBonfireFirst(View view) {
        if (isFirst) {
            if (isExit) {
                getNextScene(new Intent(this, PrologueDownBackpackCutScene.class));
                SharedPreferences.Editor editor = save.edit();
                editor.putInt(APP_SAVE_FOOD,foodCounterMain);
                editor.apply();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            } else if (isDown) {
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_bench);
                buttonPrologueBonfireFirst.setVisibility(View.GONE);
            } else if (isUndergrowth) {
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_undergrowth_firewood);
                buttonPrologueBonfireFirst.setVisibility(View.GONE);
            } else {
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_down);
                buttonPrologueBonfireFirst.setText(R.string.prologue_bonfire_button_down_bench);
                buttonPrologueBonfireFirst.setVisibility(View.VISIBLE);
                buttonPrologueBonfireSecond.setText(R.string.prologue_bonfire_button_down_hill);
                buttonPrologueBonfireSecond.setVisibility(View.VISIBLE);
                buttonPrologueBonfireThird.setText(R.string.prologue_bonfire_button_down_back);
                buttonPrologueBonfireThird.setVisibility(View.VISIBLE);
                isDown = true;
            }
            isFirst = false;
            buttonPrologueBonfireFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            isFirst = true;
            isSecond = false;
            isThird = false;
            buttonPrologueBonfireFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueBonfireSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBonfireThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        }

    }

    public void onPrologueBonfireSecond(View view) {
        if (isSecond) {
            if (isDown) {
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_hill);
                buttonPrologueBonfireSecond.setVisibility(View.GONE);
            } else if (isUndergrowth) {
                Toast toast;
                int chance;
                if (save.getBoolean(APP_SAVE_KNIFE, false)) {
                    textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_undergrowth_mushrooms_knife);
                    chance = 40;
                } else {
                    textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_undergrowth_mushrooms_no_knife);
                    chance = 60;
                }
                if (Fortune.isLuck(save.getInt(APP_SAVE_FORTUNE, 0), chance)) {
                    foodCounterMain++;
                    toast = Toast.makeText(this, R.string.prologue_bonfire_toast_undergrowth_mushrooms_luck, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    toast = Toast.makeText(this, R.string.prologue_bonfire_toast_undergrowth_mushrooms_fail, Toast.LENGTH_LONG);
                    toast.show();
                }
                buttonPrologueBonfireSecond.setVisibility(View.GONE);
            } else {
                isUndergrowth = true;
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_undergrowth);
                buttonPrologueBonfireFirst.setText(R.string.prologue_bonfire_button_undergrowth_firewood);
                buttonPrologueBonfireFirst.setVisibility(View.VISIBLE);
                buttonPrologueBonfireSecond.setText(R.string.prologue_bonfire_button_undergrowth_mushrooms);
                buttonPrologueBonfireSecond.setVisibility(View.VISIBLE);
                buttonPrologueBonfireThird.setText(R.string.prologue_bonfire_button_undergrowth_back);
                buttonPrologueBonfireThird.setVisibility(View.VISIBLE);
            }
            isSecond = false;
            buttonPrologueBonfireSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            isFirst = false;
            isSecond = true;
            isThird = false;
            buttonPrologueBonfireFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBonfireSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueBonfireThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        }
    }

    public void onPrologueBonfireThird(View view) {
        if (isThird) {
            if (isUndergrowthWay && isDownWay) {
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_forest);
                buttonPrologueBonfireFirst.setVisibility(View.VISIBLE);
                buttonPrologueBonfireSecond.setVisibility(View.GONE);
                buttonPrologueBonfireThird.setVisibility(View.GONE);
                buttonPrologueBonfireFirst.setText(R.string.prologue_bonfire_button_camp);
                isExit = true;
            } else if (isDown) {
                isDown = false;
                isDownWay = true;
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_middle);
                buttonPrologueBonfireFirst.setVisibility(View.GONE);
                buttonPrologueBonfireSecond.setVisibility(View.VISIBLE);
                if (isUndergrowthWay) {
                    buttonPrologueBonfireSecond.setVisibility(View.GONE);
                    buttonPrologueBonfireThird.setText(R.string.prologue_bonfire_button_forest);
                    textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_forest_way);
                } else {
                    buttonPrologueBonfireThird.setVisibility(View.GONE);
                    buttonPrologueBonfireSecond.setText(R.string.prologue_bonfire_button_undergrowth);
                }
            } else if (isUndergrowth) {
                isUndergrowth = false;
                isUndergrowthWay = true;
                textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_middle);
                buttonPrologueBonfireSecond.setVisibility(View.GONE);
                if (isDownWay) {
                    buttonPrologueBonfireFirst.setVisibility(View.GONE);
                    buttonPrologueBonfireThird.setText(R.string.prologue_bonfire_button_forest);
                    textPrologueBonfireMain.setText(R.string.prologue_bonfire_text_forest_way);
                } else {
                    buttonPrologueBonfireThird.setVisibility(View.GONE);
                    buttonPrologueBonfireFirst.setVisibility(View.VISIBLE);
                    buttonPrologueBonfireFirst.setText(R.string.prologue_bonfire_button_down);
                }
            }
            isThird = false;
            buttonPrologueBonfireThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            isFirst = false;
            isSecond = false;
            isThird = true;
            buttonPrologueBonfireFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBonfireSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBonfireThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
        }
    }
}
