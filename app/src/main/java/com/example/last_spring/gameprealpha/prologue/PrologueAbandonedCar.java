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
import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueAbandonedCar extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_DIARY = "Diary";

    private float level;

    private RadioGroup radioGroupAbandonedCar;

    private RadioButton buttonAbandonedCarFirst;
    private RadioButton buttonAbandonedCarSecond;
    private RadioButton buttonAbandonedCarThird;

    private TextView textAbandonedCarStart;

    private ScrollView scrollAbandonedCar;

    private boolean isFirstButton;
    private boolean isSecondButton;
    private boolean isThirdButton;
    private boolean isOintment;
    private boolean isDiary;
    private boolean isRaincoat;
    private boolean isExit;
    private boolean isStart;
    private boolean isCar;
    private boolean isGloveBox;
    private boolean isMiddle;
    private boolean isTrunk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abandoned_car);

        level = 1.10f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        radioGroupAbandonedCar = (RadioGroup) findViewById(R.id.radioGroupAbandonedCarID);

        buttonAbandonedCarFirst = (RadioButton) findViewById(R.id.buttonAbandonedCarFirstID);
        buttonAbandonedCarFirst.setTextSize(sizeFonts);
        buttonAbandonedCarSecond = (RadioButton) findViewById(R.id.buttonAbandonedCarSecondID);
        buttonAbandonedCarSecond.setTextSize(sizeFonts);
        buttonAbandonedCarThird = (RadioButton) findViewById(R.id.buttonAbandonedCarThirdID);
        buttonAbandonedCarThird.setTextSize(sizeFonts);

        textAbandonedCarStart = (TextView) findViewById(R.id.textAbandonedCarStartID);
        sText(textAbandonedCarStart);

        scrollAbandonedCar = (ScrollView) findViewById(R.id.scrollAbandonedCarID);
        sScroll(scrollAbandonedCar);

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupAbandonedCar,scrollAbandonedCar, buttonMenu)));

        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        isStart = true;
        isCar = false;
        isExit = false;
        isGloveBox = false;
        isMiddle = false;
        isTrunk = false;
        isOintment = false;

        getInterface(true);
        textMessage.setText(R.string.abandoned_car_message_raincoat);

    }

    public void onAbandonedCarFirst(View view) {
        if (isFirstButton) {
            refreshScroll(scrollAbandonedCar);
            if (isCar) {
                buttonAbandonedCarFirst.setVisibility(View.GONE);
                textAbandonedCarStart.setText(R.string.abandoned_car_text_glove_box);
                isGloveBox = true;
                isOintment = true;
                treatmentCounterMain++;
                if (isTrunk && isMiddle) {
                    isCar = false;
                    isExit = true;
                    buttonAbandonedCarSecond.setVisibility(View.VISIBLE);
                    buttonAbandonedCarSecond.setText(R.string.abandoned_car_button_exit);
                    SharedPreferences.Editor editor = save.edit();
                    if (isRaincoat) {
                        editor.putBoolean(APP_SAVE_RAINCOAT, isRaincoat);
                        editor.putInt(APP_SAVE_FORTUNE, save.getInt(APP_SAVE_FORTUNE, 0) - 10);
                    } else {
                        editor.putBoolean(APP_SAVE_RAINCOAT, isRaincoat);
                        editor.putInt(APP_SAVE_FORTUNE, save.getInt(APP_SAVE_FORTUNE, 0) + 10);
                    }
                    editor.putBoolean(APP_SAVE_PROLOGUE_DIARY, isDiary);
                    if (isOintment) {
                        editor.putInt(APP_SAVE_TREATMENT, 1);
                    }
                    editor.apply();
                }
            }

            if (isStart) {
                isStart = false;
                buttonAbandonedCarThird.setVisibility(View.VISIBLE);
                textAbandonedCarStart.setText(R.string.abandoned_car_text_car);
                buttonAbandonedCarFirst.setText(R.string.abandoned_car_button_glove_box);
                buttonAbandonedCarSecond.setText(R.string.abandoned_car_button_middle);
                isCar = true;
            }
            isFirstButton = false;
            buttonAbandonedCarFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonAbandonedCarFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonAbandonedCarSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonAbandonedCarThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirstButton = true;
            isSecondButton = false;
            isThirdButton = false;
        }
    }


    public void onAbandonedCarSecond(View view) {
        if (isSecondButton) {
            refreshScroll(scrollAbandonedCar);
            if (isStart || isExit) {
                getNextScene(new Intent(this, PrologueHuntingLodge.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            }
            if (isCar) {
                buttonAbandonedCarSecond.setVisibility(View.GONE);
                textAbandonedCarStart.setText(R.string.abandoned_car_text_diary);
                isMiddle = true;
                isDiary = true;
                if (isTrunk && isGloveBox) {
                    isCar = false;
                    isExit = true;
                    buttonAbandonedCarSecond.setVisibility(View.VISIBLE);
                    buttonAbandonedCarSecond.setText(R.string.abandoned_car_button_exit);
                    SharedPreferences.Editor editor = save.edit();
                    editor.putBoolean(APP_SAVE_PROLOGUE_DIARY, isDiary);
                    if (isOintment) {
                        editor.putInt(APP_SAVE_TREATMENT, 1);
                    }
                    editor.apply();
                }
            }
            buttonAbandonedCarSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        }
        buttonAbandonedCarFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonAbandonedCarSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
        buttonAbandonedCarThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        isFirstButton = false;
        isSecondButton = true;
        isThirdButton = false;
    }


    public void onAbandonedCarThird(View view) {
        if (isThirdButton) {
            refreshScroll(scrollAbandonedCar);
            if (isCar) {
                if (Fortune.isLuck(save.getInt(APP_SAVE_FORTUNE, 0), 60)) {
                    textAbandonedCarStart.setText(R.string.abandoned_car_text_trunk_luck);
                    buttonAbandonedCarThird.setVisibility(View.GONE);
                    isRaincoat = true;
                    isRaincoatMain = true;
                    isTrunk = true;
                    showMessage(textMessage, false);
                    getLuckImage(true);
                } else {
                    textAbandonedCarStart.setText(R.string.abandoned_car_text_trunk_fail);
                    buttonAbandonedCarThird.setVisibility(View.GONE);
                    isTrunk = true;
                    getLuckImage(false);
                }
                if (isTrunk && isGloveBox && isMiddle) {
                    isCar = false;
                    isExit = true;
                    buttonAbandonedCarSecond.setVisibility(View.VISIBLE);
                    buttonAbandonedCarSecond.setText(R.string.abandoned_car_button_exit);
                    SharedPreferences.Editor editor = save.edit();
                    if (isRaincoat) {
                        editor.putBoolean(APP_SAVE_RAINCOAT, isRaincoat);
                        editor.putInt(APP_SAVE_FORTUNE, save.getInt(APP_SAVE_FORTUNE, 0) - 10);
                    } else {
                        editor.putBoolean(APP_SAVE_RAINCOAT, isRaincoat);
                        editor.putInt(APP_SAVE_FORTUNE, save.getInt(APP_SAVE_FORTUNE, 0) + 10);
                    }
                    editor.putBoolean(APP_SAVE_PROLOGUE_DIARY, isDiary);
                    if (isOintment) {
                        editor.putInt(APP_SAVE_TREATMENT, 1);
                    }
                    editor.apply();
                }
            }
            buttonAbandonedCarThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        }
        buttonAbandonedCarFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonAbandonedCarSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonAbandonedCarThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isFirstButton = false;
        isSecondButton = false;
        isThirdButton = true;
    }
}

