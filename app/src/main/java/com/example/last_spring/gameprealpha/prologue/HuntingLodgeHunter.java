package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;

import java.util.ArrayList;
import java.util.Arrays;


public class HuntingLodgeHunter extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_HUNTING_KNIFE = "Knife bedside";
    private static final String APP_SAVE_PROLOGUE_HUNTER_CAMP = "Old camp";
    private static final String APP_SAVE_PROLOGUE_HUNTER_THINGS = "Things";
    private static final String APP_SAVE_PROLOGUE_HUNTER_FIGHT = "Fight with hunter";
    private static final String APP_SAVE_PROLOGUE_HUNTING_SLEEPING_BUG = "Extra sleeping bug";

    private RadioButton firstLine;
    private RadioButton secondLine;
    private RadioButton thirdLine;

    private ConstraintLayout constraintLayoutDialogHuntingLodge;

    private TextView textPrologueHunterStart;

    private RadioGroup radioGroupPrologueHunterDialog;

    private  Resources res;

    private boolean isFirstLine;
    private boolean isSecondLine;
    private boolean isThirdLine;
    private boolean isFirstStart;
    private boolean isKnifeBedside;
    private boolean isImage;

    private float level;

    private String nameParagraph;
    private String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_hunter);

        level = 1.14f;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        startService(new Intent(this, OstDisturbance.class));
        isOstDisturbance = true;

        isKnifeBedside = save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false);
        constraintLayoutDialogHuntingLodge = (ConstraintLayout) findViewById(R.id.ConstraintLayoutDialogHuntingLodgeID);

        res = getResources();

        firstLine = (RadioButton) findViewById(R.id.buttonPrologueHunterFirstLineID);
        firstLine.setTextSize(sizeFonts);
        secondLine = (RadioButton) findViewById(R.id.buttonPrologueHunterSecondLineID);
        secondLine.setTextSize(sizeFonts);
        secondLine.setVisibility(View.GONE);
        thirdLine = (RadioButton) findViewById(R.id.buttonPrologueHunterThirdLineID);
        thirdLine.setTextSize(sizeFonts);
        thirdLine.setVisibility(View.GONE);

        radioGroupPrologueHunterDialog = (RadioGroup) findViewById(R.id.radioGroupPrologueHunterDialogID);
        radioGroupPrologueHunterDialog.setVisibility(View.GONE);

        textPrologueHunterStart = (TextView) findViewById(R.id.textPrologueHunterStartID);
        sText( textPrologueHunterStart);
        textPrologueHunterStart.setVisibility(View.GONE);

        if (isKnifeBedside) {
            textPrologueHunterStart.setText(R.string.hunting_lodge_hunter_text_start);
        } else {
            textPrologueHunterStart.setText(R.string.hunting_lodge_hunter_text_start_no_knife);
        }

        firstLine.setText(R.string.hunting_lodge_hunter_button_start);
        secondLine.setVisibility(View.GONE);
        thirdLine.setVisibility(View.GONE);
        isFirstStart = true;

        strings = res.getStringArray(R.array.dialog_hunter_1);
        nameParagraph = "dialog_hunter_1";

        new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueHunterDialog, textPrologueHunterStart)));
            }
        }.start();
    }


    public void onPrologueHunterFirstLine(View view) {
        if (isFirstStart) {
            secondLine.setVisibility(View.VISIBLE);
            thirdLine.setVisibility(View.VISIBLE);
            getParagraph(strings);
            isFirstStart = false;
            isImage = true;
            constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_hunter_background));
        } else if (isFirstLine) {
                strings = getStrings(1);
                getParagraph(strings);
                firstLine.setBackgroundColor(Color.parseColor("#70303030"));
                if (secondLine.getText().length() > 2) {
                    secondLine.setVisibility(View.VISIBLE);
                } else {
                    secondLine.setVisibility(View.GONE);
                }
                if (thirdLine.getText().length() > 2) {
                    thirdLine.setVisibility(View.VISIBLE);
                } else {
                    thirdLine.setVisibility(View.GONE);
                }
            if (isImage) {
                isImage = false;
                constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_adam_background));
            } else {
                isImage = true;
                constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_hunter_background));
            }

                isFirstLine = false;
            } else {
                firstLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
                secondLine.setBackgroundColor(Color.parseColor("#70303030"));
                thirdLine.setBackgroundColor(Color.parseColor("#70303030"));
                isFirstLine = true;
                isSecondLine = false;
                isThirdLine = false;
            }
    }


    public void onPrologueHunterSecondLine(View view) {
        if (isSecondLine) {
            strings = getStrings(2);
            getParagraph(strings);
            secondLine.setBackgroundColor(Color.parseColor("#70303030"));
            if (secondLine.getText().length() > 2) {
                secondLine.setVisibility(View.VISIBLE);
            } else {
                secondLine.setVisibility(View.GONE);
            }
            if (thirdLine.getText().length() > 2) {
                thirdLine.setVisibility(View.VISIBLE);
            } else {
                thirdLine.setVisibility(View.GONE);
            }
            if (isImage) {
                isImage = false;
                constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_adam_background));
            } else {
                isImage = true;
                constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_hunter_background));
            }

            isSecondLine = false;
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#70303030"));
            secondLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            thirdLine.setBackgroundColor(Color.parseColor("#70303030"));
            isFirstLine = false;
            isSecondLine = true;
            isThirdLine = false;
        }
    }

    public void onPrologueHunterThirdLine(View view) {
        if (isThirdLine) {
            strings = getStrings(3);
            getParagraph(strings);
            thirdLine.setBackgroundColor(Color.parseColor("#70303030"));
            if (secondLine.getText().length() > 2) {
                secondLine.setVisibility(View.VISIBLE);
            } else {
                secondLine.setVisibility(View.GONE);
            }
            if (thirdLine.getText().length() > 2) {
                thirdLine.setVisibility(View.VISIBLE);
            } else {
                thirdLine.setVisibility(View.GONE);
            }
            if (isImage) {
                isImage = false;
                constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_adam_background));
            } else {
                isImage = true;
                constraintLayoutDialogHuntingLodge.setBackground(res.getDrawable(R.drawable.prologue_huntinh_lodge_inside_second_hunter_background));
            }
            isThirdLine = false;
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#70303030"));
            secondLine.setBackgroundColor(Color.parseColor("#70303030"));
            thirdLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirstLine = false;
            isSecondLine = false;
            isThirdLine = true;
        }
    }

    private String[] getStrings(int choice) {
        Resources res = getResources();

        if (choice == 1) {
            if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_1_2") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_1_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_1_1_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_2_1_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_1_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_2_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_2_3_2_2")) {
                if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_1_1")) {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_CAMP, true);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_THINGS, true);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, false);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false);
                    editor.putInt(APP_SAVE_FOOD, 0);
                    editor.apply();
                } else {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_CAMP, false);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_THINGS, false);
                    editor.apply();
                }
                getNextScene(new Intent(this, HuntingLodgeExit.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_1_1_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_1_1_2") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_2_1_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_1_2") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_2_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_2_1_2") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_1_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_2_2")) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, true);
                editor.putBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false);
                editor.putInt(APP_SAVE_FOOD, 0);
                editor.apply();
                getNextScene(new Intent(this, HuntingLodgeExit.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else {
                nameParagraph += "_1";
                strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
            }
        }
        if (choice == 2) {

            if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_1_2") || nameParagraph.equals("dialog_hunter_1_1_1_1_1_2")) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, true);
                editor.apply();
                getNextScene(new Intent(this, HuntingLodgeExit.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_1_2") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_1_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_1_1_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_2_1_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_1_1_1_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_2_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_1_2_3") ||
                    nameParagraph.equals("dialog_hunter_1_1_2_3_2_1_1") ||
                    nameParagraph.equals("dialog_hunter_1_1_2_3_2_2")) {
                if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_1_1")) {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_CAMP, true);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_THINGS, false);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, false);
                    editor.apply();
                    getNextScene(new Intent(this, HuntingLodgeExit.class));
                    finish();
                    overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                } else {
                    SharedPreferences.Editor editor = save.edit();
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_CAMP, false);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_THINGS, false);
                    editor.putBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, false);
                    editor.apply();
                    getNextScene(new Intent(this, HuntingLodgeExit.class));
                    finish();
                    overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                }
            } else {

                nameParagraph += "_2";

                strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
            }
        }
        if (choice == 3) {
            nameParagraph += "_3";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_1_2_1") || nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_1_2")) {
            nameParagraph = "dialog_hunter_1_1_1_1_2_1_1_1_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        //Ссылка на Серу
        if (nameParagraph.equals("dialog_hunter_1_1_1_1_2_1_2_2") || nameParagraph.equals("dialog_hunter_1_1_1_1_2_2") ||
                nameParagraph.equals("dialog_hunter_1_1_2_3_1_1_1_2") || nameParagraph.equals("dialog_hunter_1_1_2_3_2_1_2")) {
            nameParagraph = "dialog_hunter_1_1_1_1_2_1_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        //Ссылка на Горы и Лес
        if (nameParagraph.equals("dialog_hunter_1_1_2_1")) {
            nameParagraph = "dialog_hunter_1_1_1_1_2_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        //Ссылка на Шавку
        if (nameParagraph.equals("dialog_hunter_1_1_2_2") || nameParagraph.equals("dialog_hunter_1_1_2_3_1_1_2") ||
                nameParagraph.equals("dialog_hunter_1_1_2_3_1_2_1_2")) {
            nameParagraph = "dialog_hunter_1_1_1_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        //Ссылка на смартфоны
        if (nameParagraph.equals("dialog_hunter_1_1_2_3_1_1_1_1") || nameParagraph.equals("dialog_hunter_1_1_2_3_1_2_1_1") ||
                nameParagraph.equals("dialog_hunter_1_1_2_3_1_2_2")) {
            nameParagraph = "dialog_hunter_1_1_1_1_2_1_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        //Cсылка на Колхозника
        if (nameParagraph.equals("dialog_hunter_1_2_1")) {
            nameParagraph = "dialog_hunter_1_1_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }
        //Cсылка на Органы
        if (nameParagraph.equals("dialog_hunter_1_2_2") || nameParagraph.equals("dialog_hunter_1_3")) {
            nameParagraph = "dialog_hunter_1_1_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        return strings;
    }

    private void getParagraph(String[] strings) {
        textPrologueHunterStart.setText(strings[0]);
        firstLine.setText(strings[1]);
        secondLine.setText(strings[2]);
        thirdLine.setText(strings[3]);
    }
}
