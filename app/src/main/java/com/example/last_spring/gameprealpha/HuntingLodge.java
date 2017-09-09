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

public class HuntingLodge extends GameActivity {

    private RadioButton radioButtonWindowHuntingStart;
    private RadioButton radioButtonDoorHuntingStart;
    private RadioButton radioButtonOpenDoorHuntingStart;

    private boolean isWindow;
    private boolean isSaveWindow;
    private boolean isDoor;
    private boolean isOpenDoor;

    protected float level;
    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_PROLOGUE_HUNTING_WINDOW = "Window";

    private TextView huntingLodgeStartText;


    private SharedPreferences save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge);
        level = 1.11f;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        huntingLodgeStartText = (TextView) findViewById(R.id.huntingLodgeStartTextID);

        radioButtonWindowHuntingStart = (RadioButton) findViewById(R.id.radioButtonWindowHuntingStartID);
        radioButtonDoorHuntingStart = (RadioButton) findViewById(R.id.radioButtonDoorHuntingStartID);
        radioButtonOpenDoorHuntingStart = (RadioButton) findViewById(R.id.radioButtonOpenDoorHuntingStartID);
    }

    public void onDoorHuntingStart(View view) {
        if (isDoor) {
            huntingLodgeStartText.setText(R.string.hunting_Lodge_start_text_next_door);
            radioButtonDoorHuntingStart.setVisibility(View.GONE);
        }
        radioButtonDoorHuntingStart.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonOpenDoorHuntingStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonWindowHuntingStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        isDoor = true;
        isOpenDoor = false;
        isWindow = false;
    }

    public void onWindowHuntingStart(View view) {
        if(isWindow){
            huntingLodgeStartText.setText(R.string.hunting_Lodge_start_text_next_window);
            radioButtonWindowHuntingStart.setVisibility(View.GONE);
            isSaveWindow = true;
        }
        radioButtonDoorHuntingStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonOpenDoorHuntingStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonWindowHuntingStart.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isDoor = false;
        isOpenDoor = false;
        isWindow = true;
    }

    public void onOpenDoorHuntingStartID(View view) {
        if(isOpenDoor) {
            SharedPreferences.Editor editor = save.edit();
            editor.putBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, isSaveWindow);
            editor.apply();
            Intent intent = new Intent(this, HuntingLodgeInside.class);
            getNextScene(intent);
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        radioButtonDoorHuntingStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonOpenDoorHuntingStart.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonWindowHuntingStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        isDoor = false;
        isOpenDoor = true;
        isWindow = false;
    }
}
