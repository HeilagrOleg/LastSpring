package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;

public class PrologueBackpackHunter extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT = "Backpack hunter fight";


    private String nameParagraph;
    private String[] strings;

    private RadioButton firstLine;
    private RadioButton secondLine;
    private RadioButton thirdLine;

    private TextView textPrologueBackpackHunterStart;
    private TextView textPrologueBackpackHunterStartMain;

    private boolean isFirstLine;
    private boolean isSecondLine;
    private boolean isThirdLine;

    private boolean isStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_backpack_hunter);

        level = 2.102f;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        startService(new Intent(this, OstDisturbance.class));
        isOstDisturbance = true;

        firstLine = (RadioButton) findViewById(R.id.buttonPrologueBackpackHunterFirstLineID);
        secondLine = (RadioButton) findViewById(R.id.buttonPrologueHunterSecondLineID);
        thirdLine = (RadioButton) findViewById(R.id.buttonPrologueHunterThirdLineID);

        textPrologueBackpackHunterStart = (TextView) findViewById(R.id.textPrologueBackpackHunterStartID);
        textPrologueBackpackHunterStartMain = (TextView) findViewById(R.id.textPrologueBackpackHunterStartMainID);

        nameParagraph = "dialog_backpack";

        strings = getResources().getStringArray(R.array.dialog_backpack);

        getParagraph(strings);

        thirdLine.setText(R.string.prologue_backpack_hunter_button_start);

        if(save.getBoolean(APP_SAVE_KNIFE,false)) {
            textPrologueBackpackHunterStart.setText(R.string.prologue_backpack_hunter_text_start_knife);
        }

    }

    public void onPrologueBackpackHunterFirstLine(View view) {
        if (isStart) {
            isStart = false;
            textPrologueBackpackHunterStartMain.setVisibility(View.GONE);
            textPrologueBackpackHunterStart.setVisibility(View.VISIBLE);
        }
        if (isFirstLine) {
            strings = getStrings(1);
            getParagraph(strings);
            firstLine.setBackgroundColor(Color.parseColor("#60ffffff"));
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
            isFirstLine = false;
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            secondLine.setBackgroundColor(Color.parseColor("#60ffffff"));
            thirdLine.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirstLine = true;
            isSecondLine = false;
            isThirdLine = false;
        }
    }

    public void onPrologueBackpackHunterSecondLine(View view) {
        if (isStart) {
            isStart = false;
            textPrologueBackpackHunterStartMain.setVisibility(View.GONE);
            textPrologueBackpackHunterStart.setVisibility(View.VISIBLE);
        }
        if (isSecondLine) {
            strings = getStrings(2);
            getParagraph(strings);
            secondLine.setBackgroundColor(Color.parseColor("#60ffffff"));
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
            isSecondLine = false;
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#60ffffff"));
            secondLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            thirdLine.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirstLine = false;
            isSecondLine = true;
            isThirdLine = false;
        }
    }


    public void onPrologueBackpackHunterThirdLine(View view) {
        if (isThirdLine) {
            isThirdLine = false;
            isStart = true;
            thirdLine.setVisibility(View.GONE);
            firstLine.setVisibility(View.VISIBLE);
            secondLine.setVisibility(View.VISIBLE);
            textPrologueBackpackHunterStartMain.setText(R.string.prologue_backpack_hunter_text_start_next);
        } else {
            firstLine.setBackgroundColor(Color.parseColor("#60ffffff"));
            secondLine.setBackgroundColor(Color.parseColor("#60ffffff"));
            thirdLine.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirstLine = false;
            isSecondLine = false;
            isThirdLine = true;
        }
    }

    private String[] getStrings(int choice) {
        Resources res = getResources();

        if (choice == 1) {
            if (nameParagraph.equals("dialog_backpack_1_1_1_1_1")|| nameParagraph.equals("dialog_backpack_1_1_1_1_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1_2")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2_1") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_1_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_1_2_2") || nameParagraph.equals("dialog_backpack_1_2_1_2_1_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_1_1") || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_2_1") || nameParagraph.equals("dialog_backpack_1_2_2_2_2_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_2_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_1_1")|| nameParagraph.equals("dialog_backpack_2_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_1_1_2")|| nameParagraph.equals("dialog_backpack_2_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_2_1_2_1")|| nameParagraph.equals("dialog_backpack_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_1_1_1_2_1") || nameParagraph.equals("dialog_backpack_2_1_1_1_1_2_1")) {
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else if ((nameParagraph.equals("dialog_backpack_1_2_2_2_2_1"))|| nameParagraph.equals("dialog_backpack_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_1_2")|| nameParagraph.equals("dialog_backpack_1_2_1_2_1_2")
                    || nameParagraph.equals("dialog_backpack_1_2_1_1_2_1") || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2")  || nameParagraph.equals("dialog_backpack_2_2_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_2_1_1_1_1_1")) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT,true);
                editor.apply();
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            }  else {
                nameParagraph += "_1";
                strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
            }
        }
        if (choice == 2) {
            if (nameParagraph.equals("dialog_backpack_2_2_1_2")|| nameParagraph.equals("dialog_backpack_2_2_2_1_1_2")
                    || nameParagraph.equals("dialog_backpack_1_1_1_1_2") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1_2")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2_1") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_1_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_1_2_2") || nameParagraph.equals("dialog_backpack_1_2_1_2_1_1")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_1_1") || nameParagraph.equals("dialog_backpack_1_2_1_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_1_2_1_2_2_2_1") || nameParagraph.equals("dialog_backpack_1_2_2_2_2_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_2_2_2") || nameParagraph.equals("dialog_backpack_2_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_1_1")|| nameParagraph.equals("dialog_backpack_2_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_1_1_2")|| nameParagraph.equals("dialog_backpack_2_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_2_1_2_1")|| nameParagraph.equals("dialog_backpack_2_2_1_1")
                    || nameParagraph.equals("dialog_backpack_2_1_1_1_2_1") || nameParagraph.equals("dialog_backpack_2_1_1_1_1_2_1")) {
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else if ((nameParagraph.equals("dialog_backpack_2_2_1_2_1"))|| nameParagraph.equals("dialog_backpack_2_2_2_1_2")
                    || nameParagraph.equals("dialog_backpack_2_2_2_2_1_1")|| nameParagraph.equals("dialog_backpack_1_1_1_1_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_1_2") || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2")  || nameParagraph.equals("dialog_backpack_1_1_2_1_1_2_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_1_2_2_2_2_2")|| nameParagraph.equals("dialog_backpack_1_1_2_2_2_1")
                    || nameParagraph.equals("dialog_backpack_1_2_2_2_2_2")) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_BACKPACK_HUNTER_FIGHT,true);
                editor.apply();
                getNextScene(new Intent(this, PrologueBackpackAfterCutScene.class));
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            }  else {
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
            nameParagraph = "dialog_backpack_2_1_2_2";
            strings = res.getStringArray(res.getIdentifier(nameParagraph, "array", "com.last_spring.gameprealpha"));
        }

        //Ссылка на миф
        if (nameParagraph.equals("dialog_backpack_1_1_2_1_2")) {
            nameParagraph = "dialog_backpack_2_1_2_2_2_1";
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

        return strings;
    }


    private void getParagraph(String[] strings) {
        textPrologueBackpackHunterStart.setText(strings[0]);
        firstLine.setText(strings[1]);
        secondLine.setText(strings[2]);
        thirdLine.setText(strings[3]);
    }
}
