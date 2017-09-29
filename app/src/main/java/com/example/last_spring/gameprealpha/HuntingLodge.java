package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class HuntingLodge extends GameActivity {


    private RadioGroup radioGroupHuntingLodgeStart;
    private RadioGroup radioGroupHuntingLodgeBeforeStart;

    private RadioButton radioButtonWindowHuntingStart;
    private RadioButton radioButtonDoorHuntingStart;
    private RadioButton radioButtonOpenDoorHuntingStart;

    private RadioButton radioButtonShedHuntingBeforeStart;
    private RadioButton radioButtonToiletHuntingBeforeStart;
    private RadioButton radioButtonNextHuntingBeforeStart;

    private ScrollView scrollHuntingLodge;

    private boolean isWindow;
    private boolean isSaveWindow;
    private boolean isDoor;
    private boolean isOpenDoor;
    private boolean isShed;
    private boolean isShedFirst;
    private boolean isShedSecond;
    private boolean isShedThird;
    private boolean isShedFour;
    private boolean isShedFive;
    private boolean isShedMain;
    private boolean isNext;
    private boolean isToilet;
    private boolean isToiletFirst;
    private boolean isToiletMain;

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

        scrollHuntingLodge = (ScrollView) findViewById(R.id.scrollHuntingLodgeID);
        sScroll(scrollHuntingLodge);

        huntingLodgeStartText = (TextView) findViewById(R.id.huntingLodgeStartTextID);
        huntingLodgeStartText.setTextSize(sizeFonts);
        sText(huntingLodgeStartText);

        radioGroupHuntingLodgeStart = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeStartID);
        radioGroupHuntingLodgeStart.setVisibility(View.GONE);
        radioGroupHuntingLodgeBeforeStart = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeBeforeStartID);

        radioButtonWindowHuntingStart = (RadioButton) findViewById(R.id.radioButtonWindowHuntingStartID);
        radioButtonWindowHuntingStart.setTextSize(sizeFonts);
        radioButtonDoorHuntingStart = (RadioButton) findViewById(R.id.radioButtonDoorHuntingStartID);
        radioButtonDoorHuntingStart.setTextSize(sizeFonts);
        radioButtonOpenDoorHuntingStart = (RadioButton) findViewById(R.id.radioButtonOpenDoorHuntingStartID);
        radioButtonOpenDoorHuntingStart.setTextSize(sizeFonts);
        radioButtonShedHuntingBeforeStart = (RadioButton) findViewById(R.id.radioButtonShedHuntingBeforeStartID);
        radioButtonShedHuntingBeforeStart.setTextSize(sizeFonts);
        radioButtonToiletHuntingBeforeStart = (RadioButton) findViewById(R.id.radioButtonToiletHuntingBeforeStartID);
        radioButtonToiletHuntingBeforeStart.setTextSize(sizeFonts);
        radioButtonNextHuntingBeforeStart = (RadioButton) findViewById(R.id.radioButtonNextHuntingBeforeStartID);
        radioButtonNextHuntingBeforeStart.setTextSize(sizeFonts);

        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupHuntingLodgeBeforeStart,scrollHuntingLodge)));

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
        if (isWindow) {
            refreshScroll(scrollHuntingLodge);
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
        if (isOpenDoor) {
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

    public void onShedHuntingBeforeStart(View view) {
        if (isShed) {
            refreshScroll(scrollHuntingLodge);
            if (isShedFive) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_again);
                if (isToiletMain) {
                    radioButtonToiletHuntingBeforeStart.setVisibility(View.GONE);
                } else {
                    radioButtonToiletHuntingBeforeStart.setVisibility(View.VISIBLE);
                    radioButtonToiletHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed);
                }
                radioButtonShedHuntingBeforeStart.setVisibility(View.GONE);
                radioButtonNextHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_next);
                radioButtonToiletHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_toilet);
                isShedMain = true;
                isShedFive = false;
                isShedFirst = false;
            } else if (isShedFour) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_shed_four);
                radioButtonShedHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_inside_back);
                isShedFive = true;
            } else if (isShedThird) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_shed_third);
                radioButtonShedHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_inside);
                isShedFour = true;
            } else if (isShedSecond) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_shed_second);
                radioButtonShedHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_enter);
                radioButtonToiletHuntingBeforeStart.setVisibility(View.GONE);
                isShedThird = true;
            } else if (isShedFirst) {
                isShedSecond = true;
                radioButtonShedHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_stone_open);
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_shed_stone);
            } else {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_shed_first);
                radioButtonNextHuntingBeforeStart.setVisibility(View.VISIBLE);
                radioButtonNextHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_back);
                radioButtonToiletHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_hand);
                radioButtonToiletHuntingBeforeStart.setVisibility(View.VISIBLE);
                radioButtonShedHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed_stone);
                radioButtonShedHuntingBeforeStart.setVisibility(View.VISIBLE);
                isShedFirst = true;
            }
            radioButtonShedHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            isShed = false;
        } else {
            radioButtonShedHuntingBeforeStart.setBackgroundColor(Color.parseColor("#607e9e7f"));
            radioButtonToiletHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonNextHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            isShed = true;
            isToilet = false;
            isNext = false;
        }
    }

    public void onToiletHuntingBeforeStart(View view) {
        if (isToilet) {
            refreshScroll(scrollHuntingLodge);
            if (isShedFirst) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_shed_hand);
                radioButtonToiletHuntingBeforeStart.setVisibility(View.GONE);
            } else if (isToiletFirst) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_again);
                isToiletMain = true;
                if (isShedMain) {
                    radioButtonShedHuntingBeforeStart.setVisibility(View.GONE);
                } else {
                    radioButtonShedHuntingBeforeStart.setVisibility(View.VISIBLE);
                    radioButtonShedHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed);
                }
                radioButtonNextHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_next);
                radioButtonNextHuntingBeforeStart.setVisibility(View.VISIBLE);
                radioButtonToiletHuntingBeforeStart.setVisibility(View.GONE);
                isToiletFirst = false;
            } else {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_toilet);
                isToiletFirst = true;
                radioButtonShedHuntingBeforeStart.setVisibility(View.GONE);
                radioButtonNextHuntingBeforeStart.setVisibility(View.GONE);
                radioButtonToiletHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_toilet_back);
            }
            radioButtonToiletHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            isToilet = false;
        } else {
            radioButtonShedHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonToiletHuntingBeforeStart.setBackgroundColor(Color.parseColor("#607e9e7f"));
            radioButtonNextHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            isShed = false;
            isToilet = true;
            isNext = false;
        }
    }

    public void onNextHuntingBeforeStart(View view) {
        if (isNext) {
            refreshScroll(scrollHuntingLodge);
            if (isShedFirst) {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_before_text_again);
                if (isToiletMain) {
                    radioButtonToiletHuntingBeforeStart.setVisibility(View.GONE);
                } else {
                    radioButtonToiletHuntingBeforeStart.setVisibility(View.VISIBLE);
                    radioButtonToiletHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_shed);
                }
                radioButtonShedHuntingBeforeStart.setVisibility(View.GONE);
                radioButtonNextHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_next);
                radioButtonToiletHuntingBeforeStart.setText(R.string.hunting_Lodge_start_button_toilet);
                isShedMain = true;
                isShedFirst = false;
            } else {
                huntingLodgeStartText.setText(R.string.hunting_Lodge_start_text);
                radioGroupHuntingLodgeBeforeStart.setVisibility(View.GONE);
                radioGroupHuntingLodgeStart.setVisibility(View.VISIBLE);
            }
            isNext = false;
            radioButtonNextHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            radioButtonShedHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonToiletHuntingBeforeStart.setBackgroundColor(Color.parseColor("#60ffffff"));
            radioButtonNextHuntingBeforeStart.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isShed = false;
            isToilet = false;
            isNext = true;
        }
    }
}
