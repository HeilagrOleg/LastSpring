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
import android.widget.Toast;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueCave extends GameActivity {

    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_OLD_COINS = "Old coins";
    public static final String APP_SAVE_CAVE_RETURN = "Cave return";
    public static final String APP_SAVE_POOL = "Pool";


    private SharedPreferences save;

    private RadioGroup radioGroupPrologueCaveStart;
    private RadioGroup radioGroupPrologueCaveLeftStart;
    private RadioGroup radioGroupPrologueCaveLeftPool;

    private RadioButton buttonPrologueCaveRightWay;
    private RadioButton buttonPrologueCaveLeftWay;
    private RadioButton buttonPrologueCaveInspect;
    private RadioButton buttonPrologueCaveLeftMovePool;
    private RadioButton buttonPrologueCaveLeftWall;
    private RadioButton buttonPrologueCaveLeftReturn;
    private RadioButton buttonPrologueCaveLeftPoolHand;
    private RadioButton buttonPrologueCaveLeftPoolReturn;
    private RadioButton buttonPrologueCaveLeftPoolDrunk;

    private TextView textPrologueCaveStart;
    private TextView textPrologueCaveLeft;

    private Toast toast;

    private ScrollView scrollPrologueCave;

    private boolean isInspect;
    private boolean isLeft;
    private boolean isRight;
    private boolean isPoolMain;
    private boolean isWall;
    private boolean isReturn;
    private boolean isPool;
    private boolean isPoolReturn;
    private boolean isDrunk;

    private int coins;

    private float level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_cave);
        stopService(new Intent(this, OstWood.class));
        startService(new Intent(this, OstCave.class));
        isOstCave = true;

        isInspect = false;
        isLeft = false;
        isRight = false;
        isPoolMain = false;
        isWall = false;
        isReturn = false;
        isPool = false;
        isPoolReturn = false;
        isDrunk = false;

        level = 2.13f;

        radioGroupPrologueCaveStart = (RadioGroup) findViewById(R.id.radioGroupPrologueCaveStartID);

        buttonPrologueCaveInspect = (RadioButton) findViewById(R.id.buttonPrologueCaveInspectID);
        buttonPrologueCaveInspect.setTextSize(sizeFonts);
        buttonPrologueCaveLeftWay = (RadioButton) findViewById(R.id.buttonPrologueCaveLeftWayID);
        buttonPrologueCaveLeftWay.setTextSize(sizeFonts);
        buttonPrologueCaveRightWay = (RadioButton) findViewById(R.id.buttonPrologueCaveRightWayID);
        buttonPrologueCaveRightWay.setTextSize(sizeFonts);

        scrollPrologueCave = (ScrollView) findViewById(R.id.scrollPrologueCaveID);
        sScroll(scrollPrologueCave);

        textPrologueCaveStart = (TextView) findViewById(R.id.textPrologueCaveStartID);
        sText(textPrologueCaveStart);

        save = getSharedPreferences(APP_SAVE, MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        if(save.getBoolean(APP_SAVE_CAVE_RETURN,false)) {
            textPrologueCaveStart.setText(R.string.prologue_cave_text_return);
        }

        if(save.getInt(APP_SAVE_OLD_COINS, 0)==1) {
            buttonPrologueCaveInspect.setVisibility(View.GONE);
        }

        if(save.getBoolean(APP_SAVE_POOL, false)) {
            buttonPrologueCaveLeftWay.setVisibility(View.GONE);
        }

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueCave, radioGroupPrologueCaveStart, buttonMenu)));


    }

    public void onPrologueCaveInspect(View view) {
        if (isInspect) {
            refreshScroll(scrollPrologueCave);
            buttonPrologueCaveInspect.setVisibility(View.GONE);
           boolean answer = Fortune.isLuck(fortune,40);
            if (answer) {
                toast = Toast.makeText(this, R.string.prologue_cave_inspect_text_luck, Toast.LENGTH_LONG);
                toast.show();
            } else {
                toast = Toast.makeText(this, R.string.prologue_cave_inspect_text_fail, Toast.LENGTH_LONG);
                toast.show();
            }
        }
        buttonPrologueCaveInspect.setBackgroundColor(Color.parseColor("#607e9e7f"));
        buttonPrologueCaveLeftWay.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueCaveRightWay.setBackgroundColor(Color.parseColor("#60ffffff"));
        isInspect = true;
        isLeft = false;
        isRight = false;
    }

    public void onPrologueCaveRightWay(View view) {
        if (isRight) {
            refreshScroll(scrollPrologueCave);
            getNextScene(new Intent(this, CaveLabyrinth.class));
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        buttonPrologueCaveInspect.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueCaveLeftWay.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueCaveRightWay.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isInspect = false;
        isLeft = false;
        isRight = true;
    }

    public void onPrologueCaveLeftWay(View view) {
        if (isLeft) {
            refreshScroll(scrollPrologueCave);
            getNextScene(new Intent(this, PrologueCavePool.class));
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        buttonPrologueCaveInspect.setBackgroundColor(Color.parseColor("#60ffffff"));
        buttonPrologueCaveLeftWay.setBackgroundColor(Color.parseColor("#607e9e7f"));
        buttonPrologueCaveRightWay.setBackgroundColor(Color.parseColor("#60ffffff"));
        isInspect = false;
        isLeft = true;
        isRight = false;
    }
}
