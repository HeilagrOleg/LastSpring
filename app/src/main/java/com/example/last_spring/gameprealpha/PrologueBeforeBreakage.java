package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class PrologueBeforeBreakage extends GameActivity {

    public static final String APP_SAVE_WAY_CAVE = "Way cave";
    public static final String APP_SAVE_RAIN = "Rain";
    public static final String APP_SAVE_BREAKAGE_FOOD = "Breakage food";


    private RadioButton buttonBeforeBreakageFirst;
    private RadioButton buttonBeforeBreakageSecond;
    private RadioButton buttonBeforeBreakageThird;

    private CheckBox checkBoxBeforeBreakage;

    private TextView textBeforeBreakage;

    private String strWound;
    private String strHunger;
    private String strWay;
    private String strFood;
    private String strFinal;

    private Boolean isStart;
    private Boolean isBreakageFood;

    private Boolean isFirst;
    private Boolean isSecond;
    private Boolean isThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_before_breakage);

        level = 3.0f;

        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        isFirst = false;
        isSecond = false;
        isThird = false;

        if (save.getBoolean(APP_SAVE_WAY_CAVE, false)) {
            finishOst();
        }
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        isBreakageFood = false;

        buttonBeforeBreakageFirst = (RadioButton) findViewById(R.id.buttonBeforeBreakageFirstID);
        buttonBeforeBreakageSecond = (RadioButton) findViewById(R.id.buttonBeforeBreakageSecondID);
        buttonBeforeBreakageThird = (RadioButton) findViewById(R.id.buttonBeforeBreakageThirdID);
        buttonBeforeBreakageThird.setVisibility(View.GONE);

        checkBoxBeforeBreakage = (CheckBox) findViewById(R.id.checkBoxBeforeBreakageID);

        textBeforeBreakage = (TextView) findViewById(R.id.textBeforeBreakageID);

        if (wound > 0) {
            strWound = getString(R.string.prologue_before_breakage_text_wound);
            strFinal = getString(R.string.prologue_before_breakage_text_fail);
            buttonBeforeBreakageFirst.setVisibility(View.GONE);
        } else {
            strWound = getString(R.string.prologue_before_breakage_text_no_wound);
            strFinal = getString(R.string.prologue_before_breakage_text_start);
            isStart = true;
        }

        if (isFaim) {
            strHunger = getString(R.string.prologue_before_breakage_text_hunger);
        } else {
            strHunger = getString(R.string.prologue_before_breakage_text_no_hunger);
        }

        if (save.getBoolean(APP_SAVE_WAY_CAVE, false)) {
            strWay = getString(R.string.prologue_before_breakage_text_cave);
        } else if (save.getBoolean(APP_SAVE_RAIN, false)) {
            strWay = getString(R.string.prologue_before_breakage_text_rain);
        } else {
            strWay = getString(R.string.prologue_before_breakage_text_lodge);
        }

        if (foodCounterMain > 0) {
            strFood = getString(R.string.prologue_before_breakage_text_food);
        } else {
            strFood = getString(R.string.prologue_before_breakage_text_no_food);
            checkBoxBeforeBreakage.setVisibility(View.GONE);
        }

        textBeforeBreakage.setText(getString(R.string.prologue_before_breakage_text_main,
                strWound,
                strHunger,
                strWay,
                strFood,
                strFinal));
    }

    public void onBeforeBreakageFirst(View view) {
        if (isFirst) {
            if (checkBoxBeforeBreakage.isChecked()) {
                isBreakageFood = true;
                textBeforeBreakage.setText(R.string.prologue_before_breakage_text_breakage_food);
            } else {
                if (isFaim) {
                    textBeforeBreakage.setText(R.string.prologue_before_breakage_text_breakage_hunger);
                } else {
                    textBeforeBreakage.setText(R.string.prologue_before_breakage_text_breakage_no_food);
                }
            }
            buttonBeforeBreakageThird.setVisibility(View.VISIBLE);
            buttonBeforeBreakageFirst.setVisibility(View.GONE);
            buttonBeforeBreakageSecond.setVisibility(View.GONE);
            isFirst = false;
            buttonBeforeBreakageFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonBeforeBreakageFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonBeforeBreakageSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonBeforeBreakageThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
            isThird = false;
        }
    }

    public void onBeforeBreakageSecond(View view) {
        if (isSecond) {
            Intent intent = new Intent(this, PrologueBadEnding.class);
            getNextScene(intent);
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
        } else {
            buttonBeforeBreakageFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonBeforeBreakageSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonBeforeBreakageThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
            isThird = false;
        }
    }

    public void onBeforeBreakageThird(View view) {
        if (isThird) {
            SharedPreferences.Editor editor = save.edit();
            editor.putBoolean(APP_SAVE_BREAKAGE_FOOD, isBreakageFood);
            editor.apply();
            Intent intent = new Intent(this, PrologueBreakage.class);
            getNextScene(intent);
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
        } else {
            buttonBeforeBreakageFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonBeforeBreakageSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonBeforeBreakageThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = false;
            isSecond = false;
            isThird = true;
        }
    }
}
