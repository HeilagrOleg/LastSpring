package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.example.last_spring.gameprealpha.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoCar extends GameActivityTwo {

    private static final String APP_SAVE_CHAPTER_TWO_CAR_SHOW = "SNOW";

    boolean isStart;
    boolean isAir;
    boolean isExit;
    boolean isExitSecond;
    boolean isLady;
    boolean isInside;
    boolean isDog;

    int failCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_car);

        isStart = true;
        isAir = false;
        isExit = false;
        isLady = false;
        isExitSecond = false;
        isDog = true;

        failCounter = 0;

        getButtons();

        startAnimationChapterTwo(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));


    }

    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            if (isStart) {
                //Дышать воздухом
                failCounter++;
                if (isAir) {
                    textChapterTwo.setText(R.string.chapter_two_car_text_air_second);
                } else {
                    textChapterTwo.setText(R.string.chapter_two_car_text_air);
                }

                buttonChapterTwoFirst.setVisibility(View.GONE);
            } else if (isInside) {
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_car_pusher);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.GONE);
                buttonChapterTwoThird.setText(R.string.chapter_two_car_button_start);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                isInside = false;
                isExitSecond = true;
            }

            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFirst);
            isFirst = true;
        }
    }

    public void onChapterTwoSecond(View view) {
        if (isSecond) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_car_text_clear);
                isAir = true;
                editor.putBoolean(APP_SAVE_CHAPTER_TWO_CAR_SHOW, true);
                editor.apply();
                buttonChapterTwoSecond.setVisibility(View.GONE);
            } else if(isLady) {
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_car);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setText(R.string.chapter_two_car_button_lady_car_dog);
                buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                buttonChapterTwoThird.setText(R.string.chapter_two_car_button_lady_car_luck);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setText(R.string.chapter_two_car_button_lady_car_battery);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isLady = false;
                isInside = true;
            } else if (isInside && isDog) {
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_car_dog);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                isDog = false;
            } else if (isInside) {
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_car_charge);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.GONE);
                buttonChapterTwoThird.setText(R.string.chapter_two_car_button_start);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                isInside = false;
                isExitSecond = true;
            }
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_car_text_wheels);
                buttonChapterTwoThird.setVisibility(View.GONE);
                isAir = true;
                failCounter++;
            } else if (isExit) {
                //Игра на удачу
                isExit = false;
            } else if (isLady) {
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_wait);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setText(R.string.chapter_two_car_button_lady_car_dog);
                buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                buttonChapterTwoThird.setText(R.string.chapter_two_car_button_lady_car_luck);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setText(R.string.chapter_two_car_button_lady_car_battery);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isLady = false;
                isInside = true;
            } else if(isInside) {
                //Игра на удачу
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_car_luck_true);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.GONE);
                buttonChapterTwoThird.setText(R.string.chapter_two_car_button_start);
                isExitSecond = true;
                isInside = false;
            } else if (isExitSecond) {
                textChapterTwo.setText(R.string.chapter_two_car_text_exit_second);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setText(R.string.chapter_two_car_button_exit_luck);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setText(R.string.chapter_two_car_button_exit_game);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isExit = true;
                isExitSecond = false;
            }
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            if (isStart) {
                if (failCounter < 2) {
                    textChapterTwo.setText(R.string.chapter_two_car_text_exit);
                    buttonChapterTwoFirst.setVisibility(View.GONE);
                    buttonChapterTwoSecond.setVisibility(View.GONE);
                    buttonChapterTwoThird.setText(R.string.chapter_two_car_button_exit_luck);
                    buttonChapterTwoThird.setVisibility(View.VISIBLE);
                    buttonChapterTwoFour.setText(R.string.chapter_two_car_button_exit_game);
                    buttonChapterTwoFour.setVisibility(View.VISIBLE);
                    isExit = true;
                    isStart = false;
                } else {
                    textChapterTwo.setText(R.string.chapter_two_car_text_lady);
                    buttonChapterTwoThird.setText(R.string.chapter_two_car_button_lady_wait);
                    buttonChapterTwoThird.setVisibility(View.VISIBLE);
                    buttonChapterTwoSecond.setText(R.string.chapter_two_car_button_lady_car);
                    buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                    buttonChapterTwoFour.setVisibility(View.GONE);
                    buttonChapterTwoFirst.setVisibility(View.GONE);
                    isStart = false;
                    isLady = true;
                }
            } else if(isExit) {
                getNextScene(ChapterTwoTrafficJamTest.class);
                finish();
            } else if (isInside) {
                textChapterTwo.setText(R.string.chapter_two_car_text_lady_car_battery);
                buttonChapterTwoFour.setVisibility(View.GONE);
                buttonChapterTwoFirst.setText(R.string.chapter_two_car_button_lady_car_pusher);
                buttonChapterTwoFirst.setVisibility(View.VISIBLE);
                buttonChapterTwoSecond.setText(R.string.chapter_two_car_button_lady_car_charge);
                buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                isDog = false;
            }
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }
}
