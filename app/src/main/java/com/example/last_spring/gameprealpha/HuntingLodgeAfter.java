package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class HuntingLodgeAfter extends GameActivity {

    private RadioButton buttonHunterLodgeAfterFirst;
    private RadioButton buttonHunterLodgeAfterSecond;

    private TextView textHunterLodgeAfter;

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
        buttonHunterLodgeAfterSecond = (RadioButton) findViewById(R.id.buttonHunterLodgeAfterSecondID);
    }


    public void onHunterLodgeAfterFirst(View view) {
        if (isFirst) {
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
