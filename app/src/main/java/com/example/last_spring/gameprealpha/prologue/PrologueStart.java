package com.example.last_spring.gameprealpha.prologue;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrologueStart extends GameActivity {
    public RadioButton buttonPrologueTent;
    public RadioButton buttonPrologueMoveUp;
    public RadioButton buttonPrologueMoveDown;
    public static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    public static final String APP_SAVE_TENT_PROLOGUE = "Tent_prologue";
    public TextView textPrologueMain;
    public TextView textPrologueTraining;
    public boolean isButtonPrologueTent;
    public boolean isButtonPrologueMoveUp;
    public boolean isButtonPrologueMoveDown;
    public float level;
    public RadioGroup radioGroupPrologue;

    private ImageView imageBackgroundLuckTrue;
    private ImageView imageBackgroundLuckFalse;

    private TextView textMessage;

    private CheckBox checkBoxPrologueTraining;

    private RelativeLayout layoutPrologueTraining;

    private RadioButton radioButtonTraining;

    private boolean isTreaning;


    private ScrollView scrollPrologueMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prolog_start);
        level = 1;
        fortune = 66;
        wound = 1;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        buttonPrologueTent = (RadioButton) findViewById(R.id.buttonPrologueTentID);
        buttonPrologueMoveUp = (RadioButton) findViewById(R.id.buttonPrologueMoveUpID);
        buttonPrologueMoveDown = (RadioButton) findViewById(R.id.buttonPrologueMoveDownID);
        radioGroupPrologue = (RadioGroup) findViewById(R.id.radioGroupPrologueID);
        textPrologueMain = (TextView) findViewById(R.id.textPrologueMainID);

        radioButtonTraining = (RadioButton) findViewById(R.id.radioButtonTrainingID);
        scrollPrologueMain = (ScrollView) findViewById(R.id.scrollPrologueMainID);
        layoutPrologueTraining = (RelativeLayout) findViewById(R.id.layoutPrologueTrainingID);
        layoutPrologueTraining.setVisibility(View.GONE);
        textPrologueTraining = (TextView) findViewById(R.id.textPrologueTrainingID);
        sText(textPrologueTraining);


        checkBoxPrologueTraining = (CheckBox) findViewById(R.id.checkBoxPrologueTrainingID);
        checkBoxPrologueTraining.setTextSize(sizeFonts);
        radioButtonTraining.setTextSize(sizeFonts);
        sScroll(scrollPrologueMain);
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        imageBackgroundLuckTrue = (ImageView) findViewById(R.id.imageBackgroundLuckTrueID);
        imageBackgroundLuckFalse = (ImageView) findViewById(R.id.imageBackgroundLuckFalseID);

        if (save.getInt(APP_SAVE_TENT_PROLOGUE, 0) != 0) {
            buttonPrologueTent.setVisibility(View.GONE);
        }

        sText(textPrologueMain);
        textPrologueMain.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

        buttonPrologueMoveDown.setTextSize(sizeFonts);
        buttonPrologueMoveUp.setTextSize(sizeFonts);
        buttonPrologueTent.setTextSize(sizeFonts);

        textMessage = (TextView) findViewById(R.id.textMessageID);
        textMessage.setTextSize(sizeFonts+4);

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);


        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologue, scrollPrologueMain, buttonMenu)));

        menuMain = (RelativeLayout) findViewById(R.id.menuMainID);

        if (!save.getBoolean(APP_SAVE_TRAINING, false)) {

            buttonPrologueMoveDown.setClickable(false);
            buttonPrologueMoveUp.setClickable(false);
            buttonPrologueTent.setClickable(false);

            new CountDownTimer(3000, 3000) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {

                    ObjectAnimator animator = ObjectAnimator.ofFloat(layoutPrologueTraining, View.ALPHA, 0, 1);
                    animator.setDuration(2000);
                    animator.start();
                    layoutPrologueTraining.setVisibility(View.VISIBLE);

                }
            }.start();

        }
    }

    public void onPrologueTent(View view) {

        if (isButtonPrologueTent) {
            refreshScroll(scrollPrologueMain);
            fortune = checkTentPrologue(fortune);
            buttonPrologueTent.setVisibility(View.GONE);
        } else {
            showButtonMainAnimation(view);
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
            refreshScroll(scrollPrologueMain);
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_TENT_PROLOGUE, 1);
            editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            Intent intent = new Intent(PrologueStart.this, PrologueUpFirstScene.class);
            getNextScene(intent);
            finish();
        } else {
            showButtonMainAnimation(view);
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
            refreshScroll(scrollPrologueMain);
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_TENT_PROLOGUE, 1);
            editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            Intent intent = new Intent(PrologueStart.this, PrologueDownFirstScene.class);
            getNextScene(intent);
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        } else {
            showButtonMainAnimation(view);
            buttonPrologueTent.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueMoveUp.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueMoveDown.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isButtonPrologueTent = false;
            isButtonPrologueMoveUp = false;
            isButtonPrologueMoveDown = true;
        }
    }

    private int checkTentPrologue(int fortune) {
        refreshScroll(scrollPrologueMain);
        Random random = new Random();
        int number = random.nextInt(65);
        if (number > fortune) {
            save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
            if (fortune <= 90) {
                fortune += 10;
            }
            SharedPreferences.Editor editor = save.edit();
            textMessage.setText(R.string.prologue_message_fail);
            showMessage(textMessage, false);
            imageBackgroundLuckFalse.setVisibility(View.VISIBLE);
            imageBackgroundLuckFalse.startAnimation(luckAnimation);
            editor.putInt(APP_SAVE_FORTUNE, fortune);
            editor.putInt(APP_SAVE_TENT_PROLOGUE, 1);
            editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            textPrologueMain.setText(R.string.prologue_tent_fail);
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
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.apply();
            showMessage(textMessage, false);
            imageBackgroundLuckTrue.setVisibility(View.VISIBLE);
            imageBackgroundLuckTrue.startAnimation(luckAnimation);
            isSleepingBugMain = true;
            textPrologueMain.setText(R.string.prologue_tent_luck);
            refreshScroll(scrollPrologueMain);
            return fortune;
        }
    }



    public void onPrologueStartTraining(View view) {
        if (isTreaning) {
            if (checkBoxPrologueTraining.isChecked()) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_TRAINING, true);
                editor.apply();
            }

            buttonPrologueMoveDown.setClickable(true);
            buttonPrologueMoveUp.setClickable(true);
            buttonPrologueTent.setClickable(true);

            layoutPrologueTraining.setVisibility(View.GONE);
        } else {
            showButtonMainAnimation(view);
            isTreaning = true;
            radioButtonTraining.setBackgroundColor(Color.parseColor("#607e9e7f"));
        }

    }

}

