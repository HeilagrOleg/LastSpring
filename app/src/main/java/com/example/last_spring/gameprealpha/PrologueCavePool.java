package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        radioButtonCavePoolFirst = (RadioButton) findViewById(R.id.radioButtonCavePoolFirstID);
        radioButtonCavePoolFirst.setTextSize(sizeFonts);
        radioButtonCavePoolSecond = (RadioButton) findViewById(R.id.radioButtonCavePoolSecondID);
        radioButtonCavePoolSecond.setTextSize(sizeFonts);
        radioButtonCavePoolThird = (RadioButton) findViewById(R.id.radioButtonCavePoolThirdID);
        radioButtonCavePoolThird.setTextSize(sizeFonts);

        textCavePool = (TextView) findViewById(R.id.textCavePoolID);
        textCavePool.setTextSize(sizeFonts);

        startService(new Intent(this, OstCave.class));
        isOstCave = true;

        isPool = save.getBoolean(APP_SAVE_POOL, false);

        if (isPool) {
            radioButtonCavePoolSecond.setVisibility(View.GONE);
        }

        animation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_image_animation);

        startAnimation(new ArrayList<View>(Arrays.asList(scrollCavePool, radioGroupCavePool)));

    }

    public void onCavePoolFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textCavePool.setText(R.string.prologue_cave_pool_text_start);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_move_wall);
                radioButtonCavePoolFirst.setVisibility(View.VISIBLE);
                radioButtonCavePoolSecond.setText(R.string.prologue_cave_pool_button_move_pool);
                radioButtonCavePoolSecond.setVisibility(View.VISIBLE);
                radioButtonCavePoolThird.setText(R.string.prologue_cave_pool_button_move_exit);
                radioButtonCavePoolThird.setVisibility(View.VISIBLE);
                radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#60ffffff"));
                isMovePool = false;
                isStart = false;
                isFirst = false;
                isSecond = false;
                isThird = false;
            } else if (isMovePool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_pool_hand);
                radioButtonCavePoolFirst.setVisibility(View.GONE);
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
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
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                isNext = false;
                isFirst = false;
                isSecond = false;
                isThird = false;
            } else if (isExit) {
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
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
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            } else {
                textCavePool.setText(R.string.prologue_cave_pool_text_wall_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_wall_pool_exit);
                radioButtonCavePoolSecond.setVisibility(View.GONE);
                radioButtonCavePoolThird.setVisibility(View.GONE);
                isNext = true;
                isStart = false;
                isSecond = false;
                isThird = false;
                radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            }
            isFirst = false;
            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));

        } else {
            isFirst = true;
            isSecond = false;
            isThird = false;

            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        }
    }


    public void onCavePoolSecond(View view) {
        if (isSecond) {
            if (isMovePool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_pool_drunk);
                radioButtonCavePoolFirst.setVisibility(View.GONE);
                radioButtonCavePoolSecond.setVisibility(View.GONE);
                textCavePool.startAnimation(animation);
                isPool = true;
                isMovePool = false;
                isMain = true;
                radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            } else {
                textCavePool.setText(R.string.prologue_cave_pool_text_pool);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_pool_hand);
                radioButtonCavePoolSecond.setText(R.string.prologue_cave_pool_button_pool_drunk);
                radioButtonCavePoolThird.setText(R.string.prologue_cave_pool_button_pool_exit);
                radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                isMovePool = true;
            }
            isSecond = false;
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            isFirst = false;
            isSecond = true;
            isThird = false;

            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        }
    }

    public void onCavePoolThirdID(View view) {
        if (isThird) {
            if (isMain || isMovePool) {
                textCavePool.setText(R.string.prologue_cave_pool_text_start);
                radioButtonCavePoolFirst.setText(R.string.prologue_cave_pool_button_move_wall);
                radioButtonCavePoolFirst.setVisibility(View.VISIBLE);
                radioButtonCavePoolSecond.setText(R.string.prologue_cave_pool_button_move_pool);
                radioButtonCavePoolThird.setText(R.string.prologue_cave_pool_button_move_exit);
                radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#60ffffff"));
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
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isThird = false;
        } else {
            isFirst = false;
            isSecond = false;
            isThird = true;

            radioButtonCavePoolFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonCavePoolSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonCavePoolThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
        }
    }
}
