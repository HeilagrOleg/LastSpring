package com.example.last_spring.gameprealpha.prologue;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueHuntingLodgeAfter extends GameActivity {

    private RadioButton buttonHunterLodgeAfterFirst;
    private RadioButton buttonHunterLodgeAfterSecond;

    private TextView textHunterLodgeAfter;

    private RadioGroup radioGroupPrologueRain;

    private ScrollView scrollPrologueHunterAfter;

    private boolean isFirst;
    private boolean isSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_after);

        getSave(1.16f);

        finishOst();
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        buttonHunterLodgeAfterFirst = (RadioButton) findViewById(R.id.buttonHunterLodgeAfterFirstID);
        buttonHunterLodgeAfterFirst.setTextSize(sizeFonts);
        buttonHunterLodgeAfterSecond = (RadioButton) findViewById(R.id.buttonHunterLodgeAfterSecondID);
        buttonHunterLodgeAfterSecond.setTextSize(sizeFonts);

        textHunterLodgeAfter = (TextView) findViewById(R.id.textHunterLodgeAfterID);
        sText( textHunterLodgeAfter);

        textHunterLodgeAfter.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

        radioGroupPrologueRain = (RadioGroup) findViewById(R.id.radioGroupHunterLodgeAfteID);

        scrollPrologueHunterAfter = (ScrollView) findViewById(R.id.scrollPrologueHunterAfterID);
        sScroll(scrollPrologueHunterAfter);

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueRain, scrollPrologueHunterAfter, buttonMenu)));

        getInterface(false);

    }


    public void onHunterLodgeAfterFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollPrologueHunterAfter);
            getNextScene(new Intent(this, PrologueCave.class));
            finish();
            isFirst = false;
            buttonHunterLodgeAfterFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonHunterLodgeAfterFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonHunterLodgeAfterSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
        }
    }

    public void onHunterLodgeAfterSecond(View view) {
        if (isSecond) {
            refreshScroll(scrollPrologueHunterAfter);
            getNextScene(new Intent(this, PrologueRain.class));
            finish();
            isSecond = false;
            buttonHunterLodgeAfterSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonHunterLodgeAfterFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonHunterLodgeAfterSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = false;
            isSecond = true;
        }
    }
}
