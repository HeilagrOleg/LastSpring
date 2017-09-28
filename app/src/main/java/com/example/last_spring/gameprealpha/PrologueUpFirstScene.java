package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueUpFirstScene extends GameActivity {

    private RadioGroup radioGroupPrologueUp;
    private RadioButton prologueMoveHuntingLodge;
    private RadioButton prologueTemporaryCamp;

    private ScrollView scrollPrologueUp;

    private TextView textPrologueUp;

    private boolean isExit;
    private boolean isSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_up_first_scene);

        prologueMoveHuntingLodge = (RadioButton) findViewById(R.id.prologueMoveHuntingLodgeID);
        prologueMoveHuntingLodge.setTextSize(sizeFonts);
        prologueTemporaryCamp = (RadioButton) findViewById(R.id.prologueTemporaryCampID);
        prologueTemporaryCamp.setTextSize(sizeFonts);

        textPrologueUp = (TextView) findViewById(R.id.textPrologueUpID);
        textPrologueUp.setTextSize(sizeFonts);

        radioGroupPrologueUp = (RadioGroup) findViewById(R.id.radioGroupPrologueUpID);

        scrollPrologueUp = (ScrollView) findViewById(R.id.scrollPrologueUpID);

        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueUp,scrollPrologueUp)));

        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        isExit = false;
        isSearch = false;
    }

    public void onUpMoveHuntingLodge(View view) {
        if (isExit) {
            Intent intent = new Intent(this, AbandonedCar.class);
            getNextScene(intent);
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
        }
        prologueMoveHuntingLodge.setBackgroundColor(Color.parseColor("#607e9e7f"));
        prologueTemporaryCamp.setBackgroundColor(Color.parseColor("#60ffffff"));

        isExit = true;
        isSearch = false;

    }

    public void onTemporaryCamp(View view) {
        if(isSearch) {
            textPrologueUp.setText(R.string.prologue_up_text_search);
            prologueTemporaryCamp.setVisibility(View.GONE);
        }
        prologueMoveHuntingLodge.setBackgroundColor(Color.parseColor("#60ffffff"));
        prologueTemporaryCamp.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isExit = false;
        isSearch = true;
    }
}
