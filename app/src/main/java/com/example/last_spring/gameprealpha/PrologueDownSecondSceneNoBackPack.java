package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class PrologueDownSecondSceneNoBackPack extends GameActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";

    RadioButton noBackPackMoveHuntingLodgeRadioButton;


    protected TextView textNoBackpackSleepingBug;
    protected View decorView;
    protected SharedPreferences save;
    public float level;

    private boolean isHuntingLodge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_down_second_scene_no_back_pack);
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        level = 2.11f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        noBackPackMoveHuntingLodgeRadioButton = (RadioButton) findViewById(R.id.buttonNoBackPackMoveHuntingLodgeID);
        textNoBackpackSleepingBug = (TextView) findViewById(R.id.textNoBackpackSleepingBugID);

        if (!save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false)) {
            textNoBackpackSleepingBug.setVisibility(View.GONE);
        }
    }

    public void onNoBackPackMoveHuntingLodge(View view) {
        if (isHuntingLodge) {
            Intent intent = new Intent(this, HuntingLodge.class);
            getNextScene(intent);
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
        }
        noBackPackMoveHuntingLodgeRadioButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isHuntingLodge = true;
    }

}
