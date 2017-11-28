package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueBackpackHunter extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT = "Backpack hunter fight";

private ConstraintLayout  constraintLayoutDialogBackpack;

    private String nameParagraph;
    private String[] strings;

    private RadioGroup radioGroupPrologueBackpackHunterDialog;
    private RadioButton firstLine;
    private RadioButton secondLine;
    private RadioButton thirdLine;

    private ScrollView scrollPrologueBackpackHunterStart;

    private TextView textPrologueBackpackHunterStart;
    private TextView textPrologueBackpackHunterStartMain;

    private Resources res;

    private boolean isFirstLine;
    private boolean isSecondLine;
    private boolean isThirdLine;
    private boolean isStart;
    private boolean isImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_backpack_hunter);

        level = 2.102f;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        finishOst();

        startService(new Intent(this, OstDisturbance.class));
        isOstDisturbance = true;

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        radioGroupPrologueBackpackHunterDialog = (RadioGroup) findViewById(R.id.radioGroupPrologueBackpackHunterDialogID);
        firstLine = (RadioButton) findViewById(R.id.buttonPrologueBackpackHunterFirstLineID);
        firstLine.setTextSize(sizeFonts);
        secondLine = (RadioButton) findViewById(R.id.buttonPrologueHunterSecondLineID);
        secondLine.setTextSize(sizeFonts);
        thirdLine = (RadioButton) findViewById(R.id.buttonPrologueHunterThirdLineID);
        thirdLine.setTextSize(sizeFonts);

        scrollPrologueBackpackHunterStart = (ScrollView) findViewById(R.id.scrollPrologueBackpackHunterStartID);
        sScroll(scrollPrologueBackpackHunterStart);

        textPrologueBackpackHunterStart = (TextView) findViewById(R.id.textPrologueBackpackHunterStartID);
        sText(textPrologueBackpackHunterStart);
        textPrologueBackpackHunterStartMain = (TextView) findViewById(R.id.textPrologueBackpackHunterStartMainID);
        sText(textPrologueBackpackHunterStartMain);

        constraintLayoutDialogBackpack = (ConstraintLayout) findViewById(R.id.constraintLayoutDialogBackpackID);

        res = getResources();

        nameParagraph = "dialog_backpack";

        strings = getResources().getStringArray(R.array.dialog_backpack);

        getParagraph(strings);

        thirdLine.setText(R.string.prologue_backpack_hunter_button_start);

        if (save.getBoolean(APP_SAVE_KNIFE, false)) {
            textPrologueBackpackHunterStart.setText(R.string.prologue_backpack_hunter_text_start_knife);
        }

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);
        buttonMenu.setVisibility(View.INVISIBLE);

        getInterface(false);

        new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueBackpackHunterDialog, scrollPrologueBackpackHunterStart)));
            }
        }.start();

    }

    public void onPrologueBackpackHunterFirstLine(View view) {
        if (isFirstLine) {
            refreshScroll(scrollPrologueBackpackHunterStart);
            scrollPrologueBackpackHunterStart.setVisibility(View.GONE);
            textPrologueBackpackHunterStart.setVisibility(View.VISIBLE);
            strings = getStrings(1);
            getParagraph(strings);
            firstLine.setBackgroundColor(Color.parseColor("#60303030"));
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
                constraintLayoutDialogBackpack.setBackground(res.getDrawable(R.drawable.prologue_backpack_adam_background));
            } else {
                isImage = true;
                constraintLayoutDialogBackpack.setBackground(res.getDrawable(R.drawable.prologue_backpack_hunter_background));
            }

            isFirstLine = false;
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            secondLine.setBackgroundColor(Color.parseColor("#60303030"));
            thirdLine.setBackgroundColor(Color.parseColor("#60303030"));
            isFirstLine = true;
            isSecondLine = false;
            isThirdLine = false;
        }
    }

    public void onPrologueBackpackHunterSecondLine(View view) {
        if (isSecondLine) {
            refreshScroll(scrollPrologueBackpackHunterStart);
            scrollPrologueBackpackHunterStart.setVisibility(View.GONE);
            textPrologueBackpackHunterStart.setVisibility(View.VISIBLE);
            strings = getStrings(2);
            getParagraph(strings);
            secondLine.setBackgroundColor(Color.parseColor("#60303030"));
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
                constraintLayoutDialogBackpack.setBackground(res.getDrawable(R.drawable.prologue_backpack_adam_background));
            } else {
                isImage = true;
                constraintLayoutDialogBackpack.setBackground(res.getDrawable(R.drawable.prologue_backpack_hunter_background));
            }

            isSecondLine = false;
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#60303030"));
            secondLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            thirdLine.setBackgroundColor(Color.parseColor("#60303030"));
            isFirstLine = false;
            isSecondLine = true;
            isThirdLine = false;
        }
    }


    public void onPrologueBackpackHunterThirdLine(View view) {
        if (isThirdLine) {
            refreshScroll(scrollPrologueBackpackHunterStart);
            isThirdLine = false;
            isStart = true;
            thirdLine.setVisibility(View.GONE);
            firstLine.setVisibility(View.VISIBLE);
            secondLine.setVisibility(View.VISIBLE);
            textPrologueBackpackHunterStartMain.setText(R.string.prologue_backpack_hunter_text_start_next);
            textPrologueBackpackHunterStartMain.setBackgroundColor(Color.parseColor("#60303030"));
            textPrologueBackpackHunterStartMain.setTextColor(Color.parseColor("#FFFFFF"));
            isImage = true;
            constraintLayoutDialogBackpack.setBackground(res.getDrawable(R.drawable.prologue_backpack_hunter_background));
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#60303030"));
            secondLine.setBackgroundColor(Color.parseColor("#60303030"));
            thirdLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirstLine = false;
            isSecondLine = false;
            isThirdLine = true;
        }
    }

    private String[] getStrings(int choice) {
        Resources res = getResources();

        if (choice == 1) {
            if (nameParagraph.equals("dialog_backpack_1_1_1_1_1") || nameParagraph.equals("dialog_backpack_1_1_1_1_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1_2")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2_1") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_1_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_1_2_2") || nameParagraph.equals("dialog_backpack_1_2_1_2_1_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_1_1") || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_2_1") || nameParagraph.equals("dialog_backpack_1_2_2_2_2_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_2_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_1_1") || nameParagraph.equals("dialog_backpack_2_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_1_1_2") || nameParagraph.equals("dialog_backpack_2_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_2_1_2_1") || nameParagraph.equals("dialog_backpack_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_1_1_1_2_1") || nameParagraph.equals("dialog_backpack_2_1_1_1_1_2_1")) {
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else if ((nameParagraph.equals("dialog_backpack_1_2_2_2_2_1")) || nameParagraph.equals("dialog_backpack_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_1_2") || nameParagraph.equals("dialog_backpack_1_2_1_2_1_2")
                    || nameParagraph.equals("dialog_backpack_1_2_1_1_2_1") || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2") || nameParagraph.equals("dialog_backpack_2_2_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_2_1_1_1_1_1")|| nameParagraph.equals("dialog_backpack_2_2_2_2_1_2")) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT, true);
                editor.apply();
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else {
                nameParagraph += "_1";
                strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
            }
        }
        if (choice == 2) {
            if (nameParagraph.equals("dialog_backpack_2_2_1_2") || nameParagraph.equals("dialog_backpack_2_2_2_1_1_2")
                    || nameParagraph.equals("dialog_backpack_1_1_1_1_2")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_1_2_2") || nameParagraph.equals("dialog_backpack_1_2_1_2_1_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_1_1") || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_2_2_2_2_2_1")

                    || nameParagraph.equals("dialog_backpack_2_2_2_1_1_2") || nameParagraph.equals("dialog_backpack_2_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_1_1_1_2_1") || nameParagraph.equals("dialog_backpack_2_1_1_1_1_2_1")) {
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else if ((nameParagraph.equals("dialog_backpack_2_2_1_2_1")) || nameParagraph.equals("dialog_backpack_2_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_1_1") || nameParagraph.equals("dialog_backpack_1_1_1_1_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1_2") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_1_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_2_2_2_2")) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT, true);
                editor.apply();
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else {
                nameParagraph += "_2";
                strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
            }
        }
        if (choice == 3) {
            nameParagraph += "_3";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на необычную культуру
        if (nameParagraph.equals("dialog_backpack_2_1_1_1_2_2")) {
            nameParagraph = "dialog_backpack_2_1_1_1_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на эти места
        if (nameParagraph.equals("dialog_backpack_1_1_1_2")) {
            nameParagraph = "dialog_backpack_2_2_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на миф
        if (nameParagraph.equals("dialog_backpack_1_1_2_1_2")) {
            nameParagraph = "dialog_backpack_2_2_2_2_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на земле роемся
        if (nameParagraph.equals("dialog_backpack_1_1_2_2_1")) {
            nameParagraph = "dialog_backpack_2_1_1_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на историй не слыхивал
        if (nameParagraph.equals("dialog_backpack_1_2_1_1_1")) {
            nameParagraph = "dialog_backpack_2_1_2_2_2_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на гуляю и гонишь псина
        if (nameParagraph.equals("dialog_backpack_1_2_2_1_2")) {
            nameParagraph = "dialog_backpack_1_1_2_1_1_2_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на культуру какую-то
        if (nameParagraph.equals("dialog_backpack_1_2_2_1_1")) {
            nameParagraph = "dialog_backpack_1_2_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        if (nameParagraph.equals("dialog_backpack_2_1_2")) {
            nameParagraph = "dialog_backpack_2_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Раскопки
        if (nameParagraph.equals("dialog_backpack_1_1_2_1_2")) {
            nameParagraph = "dialog_backpack_2_2_2_2_1";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        return strings;
    }


    private void getParagraph(String[] strings) {
        textPrologueBackpackHunterStart.setText(strings[0]);
        firstLine.setText(strings[1]);
        secondLine.setText(strings[2]);
        thirdLine.setText(strings[3]);
    }
}
