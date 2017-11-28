package com.example.last_spring.gameprealpha.prologue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstCave;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueCavePool extends GameActivity {

    public static final String APP_SAVE_CAVE_RETURN = "Cave return";
    public static final String APP_SAVE_POOL = "Pool";

    private RadioGroup radioGroupCavePool;

    private RadioButton radioButtonCavePoolFirst;
    private RadioButton radioButtonCavePoolSecond;
    private RadioButton radioButtonCavePoolThird;

    private TextView textCavePool;

    private ScrollView scrollCavePool;

    private boolean isFirst;
    private boolean isSecond;
    private boolean isThird;
    private boolean isStart;
    private boolean isPool;
    private boolean isMovePool;
    private boolean isExit;
    private boolean isNext;
    private boolean isMain;

    private Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_cave_pool);

        radioGroupCavePool = (RadioGroup) findViewById(R.id.radioGroupCavePoolID);

        scrollCavePool = (ScrollView) findViewById(R.id.scrollCavePoolID);
        sScroll(scrollCavePool);

        radioButtonCavePoolFirst = (RadioButton) findViewById(R.id.radioButtonCavePoolFirstID);
        radioButtonCavePoolFirst.setTextSize(sizeFonts);
        radioButtonCavePoolSecond = (RadioButton) findViewById(R.id.radioButtonCavePoolSecondID);
        radioButtonCavePoolSecond.setTextSize(sizeFonts);
        radioButtonCavePoolThird = (RadioButton) findViewById(R.id.radioButtonCavePoolThirdID);
        radioButtonCavePoolThird.setTextSize(sizeFonts);

        textCavePool = (TextView) findViewById(R.id.textCavePoolID);
        sText(textCavePool);

        startService(new Intent(this, OstCave.class));
        isOstCave = true;

        isPool = save.getBoolean(APP_SAVE_POOL, false);

        if (isPool) {
            radioButtonCavePoolSecond.setVisibility(View.GONE);
        }

        animation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_image_animation);

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        getInterface(false);

        startAnimation(new ArrayList<View>(Arrays.asList(scrollCavePool, radioGroupCavePool, buttonMenu)));

    }

    public void onCavePoolFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollCavePool);
            if (isStart) {
                textCavePool.setText(R.string.prologue_cave_pool_text_start_second);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_move_wall);
                radioButtonCavePoolFirst.setVisibility(View.VISIBLE);
                radioButtonCavePoolSecond.setText(R.string.prologue_cave_pool_button_move_pool);
                radioButtonCavePoolSecond.setVisibility(View.VISIBLE);
                radioButtonCavePoolThird.setText(R.string.prologue_cave_pool_button_move_exit);
                radioButtonCavePoolThird.setVisibility(View.VISIBLE);
                radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#303030"));
                isMovePool = false;
                isStart = false;
                isFirst = false;
                isSecond = false;
                isThird = false;
            } else if (isMovePool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_pool_hand);
                radioButtonCavePoolFirst.setVisibility(View.GONE);
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
                isFirst = false;
                isSecond = false;
                isThird = false;
            } else if (isNext) {
                textCavePool.setText(R.string.prologue_cave_pool_text_wall_no_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_move_wall);
                if (!isPool) {
                    radioButtonCavePoolSecond.setVisibility(View.VISIBLE);
                }
                radioButtonCavePoolThird.setVisibility(View.VISIBLE);
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
                isNext = false;
                isFirst = false;
                isSecond = false;
                isThird = false;
            } else if (isExit) {
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
                isFirst = false;
                isSecond = false;
                isThird = false;
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_CAVE_RETURN, true);
                editor.apply();
                getNextScene(new Intent(this, PrologueCave.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            } else if (!isPool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_wall_no_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_wall_exit);
                radioButtonCavePoolSecond.setVisibility(View.GONE);
                radioButtonCavePoolThird.setVisibility(View.GONE);
                isExit = false;
                isStart = true;
                isFirst = false;
                isSecond = false;
                isThird = false;
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
            } else {
                textCavePool.setText(R.string.prologue_cave_pool_text_wall_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_wall_pool_exit);
                radioButtonCavePoolSecond.setVisibility(View.GONE);
                radioButtonCavePoolThird.setVisibility(View.GONE);
                isNext = true;
                isStart = false;
                isSecond = false;
                isThird = false;
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
            }
            isFirst = false;
            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));

        } else {
            isFirst = true;
            isSecond = false;
            isThird = false;

            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#303030"));
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#303030"));
        }
    }


    public void onCavePoolSecond(View view) {
        if (isSecond) {
            refreshScroll(scrollCavePool);
            if (isMovePool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_pool_drunk);
                radioButtonCavePoolFirst.setVisibility(View.GONE);
                radioButtonCavePoolSecond.setVisibility(View.GONE);
                textCavePool.startAnimation(animation);
                isPool = true;
                isMovePool = false;
                isMain = true;
                radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#303030"));
            } else {
                textCavePool.setText(R.string.prologue_cave_pool_text_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_pool_hand);
                radioButtonCavePoolSecond.setText(R.string.prologue_cave_pool_button_pool_drunk);
                radioButtonCavePoolThird.setText(R.string.prologue_cave_pool_button_pool_exit);
                radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#303030"));
                isMovePool = true;
            }
            isSecond = false;
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#303030"));
        } else {
            isFirst = false;
            isSecond = true;
            isThird = false;

            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#303030"));
        }
    }

    public void onCavePoolThirdID(View view) {
        if (isThird) {
            refreshScroll(scrollCavePool);
            if (isMain || isMovePool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_main_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_move_wall);
                radioButtonCavePoolFirst.setVisibility(View.VISIBLE);
                radioButtonCavePoolSecond.setText(R.string.prologue_cave_pool_button_move_pool);
                radioButtonCavePoolThird.setText(R.string.prologue_cave_pool_button_move_exit);
                radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#303030"));
                isMovePool = false;
                isMain = false;
                isStart = false;
                isFirst = false;
                isSecond = false;
            } else {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_POOL, isPool);
                editor.putBoolean(APP_SAVE_CAVE_RETURN, true);
                editor.apply();
                getNextScene(new Intent(this, PrologueCave.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            }
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#303030"));
            isThird = false;
        } else {
            isFirst = false;
            isSecond = false;
            isThird = true;

            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#303030"));
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#303030"));
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
        }
    }
}
