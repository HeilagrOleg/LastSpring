package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueOldStory extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS = "Hunters";
    private static final String APP_SAVE_PROLOGUE_OLD_STORY_WOOD = "Wood";

    private TextView textPrologueOldStoryStart;
    private TextView textPrologueOldStory;

    private RadioGroup radioGroupPrologueOldStory;

    private RadioButton buttonPrologueOldStoryFirst;
    private RadioButton buttonPrologueOldStorySecond;
    private RadioButton buttonPrologueOldStoryThird;
    private RadioButton buttonPrologueOldStoryFour;

    private ScrollView scrollPrologueOldStory;
    private ScrollView scrollPrologueOldStoryStart;

    private ImageView imagePrologueOldStory;

    private int hunterCount;

    private boolean isFirst;
    private boolean isSecond;
    private boolean isThird;
    private boolean isFour;

    private boolean isStart;
    private boolean isExit;
    private boolean isPlan;
    private boolean isPlanAttack;
    private boolean isPlanBack;
    private boolean isNorth;
    private boolean isNorthAttack;
    private boolean isWood;
    private boolean isWest;
    private boolean isWestAttack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_old_story);

        getSave(0.1f);

        radioGroupPrologueOldStory = (RadioGroup) findViewById(R.id.radioGroupPrologueOldStoryID);
        buttonPrologueOldStoryFirst = (RadioButton) findViewById(R.id.buttonPrologueOldStoryFirstID);
        buttonPrologueOldStoryFirst.setTextSize(sizeFonts);
        buttonPrologueOldStorySecond = (RadioButton) findViewById(R.id.buttonPrologueOldStorySecondID);
        buttonPrologueOldStorySecond.setTextSize(sizeFonts);
        buttonPrologueOldStoryThird = (RadioButton) findViewById(R.id.buttonPrologueOldStoryThirdID);
        buttonPrologueOldStoryThird.setTextSize(sizeFonts);
        buttonPrologueOldStoryFour = (RadioButton) findViewById(R.id.buttonPrologueOldStoryFourID);
        buttonPrologueOldStoryFour.setTextSize(sizeFonts);

        scrollPrologueOldStory = (ScrollView) findViewById(R.id.scrollPrologueOldStoryID);
        sScroll(scrollPrologueOldStory);
        scrollPrologueOldStoryStart = (ScrollView) findViewById(R.id.scrollPrologueOldStoryStartID);
        sScroll(scrollPrologueOldStoryStart);

        textPrologueOldStoryStart = (TextView) findViewById(R.id.textPrologueOldStoryStartID);
        sText(textPrologueOldStoryStart);
        textPrologueOldStory = (TextView) findViewById(R.id.textPrologueOldStoryID);
        sText(textPrologueOldStory);

        imagePrologueOldStory = (ImageView) findViewById(R.id.imagePrologueOldStoryID);
        imagePrologueOldStory.setVisibility(View.GONE);

        hunterCount = 0;
        isStart = true;

        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueOldStory,scrollPrologueOldStoryStart,radioGroupPrologueOldStory)));
    }

    public void onPrologueOldStoryFirst(View view) {
        if (isFirst) {
            sScroll(scrollPrologueOldStoryStart);
            sScroll(scrollPrologueOldStory);
            if (isStart) {
                textPrologueOldStoryStart.setVisibility(View.GONE);
                textPrologueOldStory.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_plan);
                imagePrologueOldStory.setVisibility(View.VISIBLE);
                isStart = false;
                isPlan = true;
            } else if (isPlan) {
                textPrologueOldStory.setText(R.string.prologue_old_story_text_plan);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_north);
                buttonPrologueOldStorySecond.setText(R.string.prologue_old_story_button_west);
                buttonPrologueOldStorySecond.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryThird.setText(R.string.prologue_old_story_button_north_attack);
                buttonPrologueOldStoryFour.setText(R.string.prologue_old_story_button_west_attack);
                isPlan = false;
                isPlanAttack = true;
            } else if (isPlanAttack) {
                textPrologueOldStory.setText(R.string.prologue_old_story_text_north);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_plan_back);
                buttonPrologueOldStorySecond.setVisibility(View.GONE);
                buttonPrologueOldStoryThird.setVisibility(View.GONE);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isPlanAttack = false;
                isNorth = true;
                isPlanBack = true;
            } else if (isPlanBack) {
                textPrologueOldStory.setText(R.string.prologue_old_story_text_plan);
                if (isNorth) {
                    buttonPrologueOldStoryThird.setVisibility(View.VISIBLE);
                }
                if (isWest) {
                    buttonPrologueOldStoryFour.setVisibility(View.VISIBLE);
                }
                buttonPrologueOldStorySecond.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_north);
                buttonPrologueOldStorySecond.setText(R.string.prologue_old_story_button_west);
                isPlanBack = false;
                isPlanAttack = true;
            } else if (isWestAttack || isNorthAttack) {
                textPrologueOldStory.setVisibility(View.GONE);
                imagePrologueOldStory.setVisibility(View.GONE);
                hunterCount = 1;
                textPrologueOldStoryStart.setText(R.string.prologue_old_story_text_final);
                textPrologueOldStoryStart.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_final);
                buttonPrologueOldStoryFirst.setVisibility(View.VISIBLE);
                buttonPrologueOldStorySecond.setVisibility(View.GONE);
                buttonPrologueOldStoryThird.setVisibility(View.GONE);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isExit = true;
                isWestAttack = false;
                isNorthAttack = false;
                isPlanAttack = false;
                isPlanBack = false;
            } else if (isExit) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_PROLOGUE_OLD_STORY_WOOD, isWood);
                editor.putInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, hunterCount);
                editor.apply();
                startActivity(new Intent(this, PrologueOldStoryAttack.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            }
            isFirst = false;
            buttonPrologueOldStoryFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStorySecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryFour.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
            isThird = false;
            isFour = false;
        }
    }

    public void onPrologueOldStorySecond(View view) {
        if (isSecond) {
            sScroll(scrollPrologueOldStoryStart);
            sScroll(scrollPrologueOldStory);
            if (isPlanAttack) {
                textPrologueOldStory.setText(R.string.prologue_old_story_text_west);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_plan_back);
                buttonPrologueOldStorySecond.setVisibility(View.GONE);
                buttonPrologueOldStoryThird.setVisibility(View.GONE);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isPlanAttack = false;
                isWest = true;
                isPlanBack = true;
            } else if (isWestAttack || isNorthAttack) {
                textPrologueOldStory.setVisibility(View.GONE);
                imagePrologueOldStory.setVisibility(View.GONE);
                hunterCount = 2;
                textPrologueOldStoryStart.setText(R.string.prologue_old_story_text_final);
                textPrologueOldStoryStart.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_final);
                buttonPrologueOldStoryFirst.setVisibility(View.VISIBLE);
                buttonPrologueOldStorySecond.setVisibility(View.GONE);
                buttonPrologueOldStoryThird.setVisibility(View.GONE);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isExit = true;
                isWestAttack = false;
                isNorthAttack = false;
                isPlanAttack = false;
                isPlanBack = false;
            }
            isSecond = false;
            buttonPrologueOldStorySecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStorySecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryFour.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
            isThird = false;
            isFour = false;
        }
    }

    public void onPrologueOldStoryThird(View view) {
        if (isThird) {
            sScroll(scrollPrologueOldStoryStart);
            sScroll(scrollPrologueOldStory);
            if (isNorth) {
                textPrologueOldStory.setText(R.string.prologue_old_story_text_north_attack);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_hunter_one);
                buttonPrologueOldStoryFirst.setVisibility(View.GONE);
                buttonPrologueOldStorySecond.setText(R.string.prologue_old_story_button_hunter_two);
                buttonPrologueOldStoryThird.setText(R.string.prologue_old_story_button_hunter_three);
                buttonPrologueOldStoryThird.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFour.setText(R.string.prologue_old_story_button_hunter_four);
                buttonPrologueOldStoryFour.setVisibility(View.VISIBLE);
                isNorth = false;
                isWest = false;
                isNorthAttack = true;
                isPlanAttack = false;
                isPlanBack = false;
            } else if (isWestAttack || isNorthAttack) {
                textPrologueOldStory.setVisibility(View.GONE);
                imagePrologueOldStory.setVisibility(View.GONE);
                hunterCount = 3;
                textPrologueOldStoryStart.setText(R.string.prologue_old_story_text_final);
                textPrologueOldStoryStart.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_final);
                buttonPrologueOldStoryFirst.setVisibility(View.VISIBLE);
                buttonPrologueOldStorySecond.setVisibility(View.GONE);
                buttonPrologueOldStoryThird.setVisibility(View.GONE);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isExit = true;
                isWestAttack = false;
                isNorthAttack = false;
                isPlanAttack = false;
                isPlanBack = false;
            }
            isThird = false;
            buttonPrologueOldStoryThird.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStorySecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryFour.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = false;
            isThird = true;
            isFour = false;
        }
    }

    public void onPrologueOldStoryFour(View view) {
        if (isFour) {
            sScroll(scrollPrologueOldStoryStart);
            sScroll(scrollPrologueOldStory);
            if (isWest) {
                textPrologueOldStory.setText(R.string.prologue_old_story_text_west_attack);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_hunter_one);
                buttonPrologueOldStorySecond.setText(R.string.prologue_old_story_button_hunter_two);
                buttonPrologueOldStoryThird.setText(R.string.prologue_old_story_button_hunter_three);
                buttonPrologueOldStoryThird.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFour.setText(R.string.prologue_old_story_button_hunter_four);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isWood = true;
                isWest = false;
                isNorth = false;
                isWestAttack = true;
                isPlanAttack = false;
                isPlanBack = false;
            } else if (isWestAttack || isNorthAttack) {
                textPrologueOldStory.setVisibility(View.GONE);
                imagePrologueOldStory.setVisibility(View.GONE);
                hunterCount = 4;
                textPrologueOldStoryStart.setText(R.string.prologue_old_story_text_final);
                textPrologueOldStoryStart.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryFirst.setText(R.string.prologue_old_story_button_final);
                buttonPrologueOldStoryFirst.setVisibility(View.VISIBLE);
                buttonPrologueOldStorySecond.setVisibility(View.GONE);
                buttonPrologueOldStoryThird.setVisibility(View.GONE);
                buttonPrologueOldStoryFour.setVisibility(View.GONE);
                isExit = true;
                isWestAttack = false;
                isNorthAttack = false;
                isPlanAttack = false;
                isPlanBack = false;
            }
            isFour = false;
            buttonPrologueOldStoryFour.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStorySecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryFour.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = false;
            isSecond = false;
            isThird = false;
            isFour = true;
        }
    }
}
