package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.example.last_spring.gameprealpha.R;

import com.example.last_spring.gameprealpha.res.GameActivityTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoPorch extends GameActivityTwo {

    private boolean isButton;
    private boolean isText;
    private boolean isExit;
    private boolean isFirstText;

    private ProgressBar progressBarChapterTwoApartment;

    private int textCounter;
    private int stopCounter;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_porch);

        getSave(8f);

        progressBarChapterTwoApartment = (ProgressBar) findViewById(R.id.progressBarChapterTwoApartmentID);
        progressBarChapterTwoApartment.setProgress(100);

        getButtons();

        isButton = true;
        isText = true;

        textCounter = 0;
        stopCounter = 0;

        startAnimationChapterTwo(new ArrayList<View>(Arrays.asList(radioGroupChapterTwo, scrollChapterTwo)));
    }

    public void onChapterTwoFirst(View view) {
        refreshScroll(scrollChapterTwo);
        if (isFirst) {
            nextText(R.string.chapter_two_porch_text_start_first);
            buttonChapterTwoFirst.setVisibility(View.GONE);
            buttonChapterTwoSecond.setVisibility(View.GONE);
            progressBarChapterTwoApartment.setVisibility(View.VISIBLE);
            getChoiceButton();
            editText();
        } else {
            getChoiceButton(buttonChapterTwoFirst);
            isFirst = true;
        }
    }

    public void onChapterTwoSecond(View view) {
        if (isSecond) {
            if (isExit) {
                getNextScene(ChapterTwoCar.class);
                finish();
            } else {
                nextText(R.string.chapter_two_porch_text_start_second);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                progressBarChapterTwoApartment.setVisibility(View.VISIBLE);
                editText();
            }
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    private void editText() {
        new CountDownTimer(140100, 20000) {
            public void onTick(long millisUntilFinished) {
                editProgressBar();
                if (isFirstText) {
                    if (isButton) {
                        startAnimation(new ArrayList<View>(Arrays.asList(buttonChapterTwoThird)));
                        buttonChapterTwoThird.setText(R.string.chapter_two_porch_button_stop_first);
                        isButton = false;
                        isExit = true;
                    }
                    if (isText) {
                        switch (textCounter) {
                            case 0:
                                nextText(R.string.chapter_two_porch_text_main_second);
                                break;
                            case 1:
                                nextText(R.string.chapter_two_porch_text_main_third);
                                break;
                            case 2:
                                nextText(R.string.chapter_two_porch_text_main_four);
                                break;
                            case 3:
                                nextText(R.string.chapter_two_porch_text_main_five);
                                break;
                            case 4:
                                nextText(R.string.chapter_two_porch_text_main_six);
                                break;
                            case 5:
                                nextText(R.string.chapter_two_porch_text_main_seven);
                                break;
                        }
                        textCounter++;
                    }
                } else {
                    isFirstText = true;
                }
            }

            public void onFinish() {
                if (isText) {
                    nextText(R.string.chapter_two_porch_text_main_eight);
                    progressBarChapterTwoApartment.startAnimation(animationOut);
                    buttonChapterTwoThird.setVisibility(View.GONE);
                    buttonChapterTwoFour.setVisibility(View.VISIBLE);
                    isText = false;
                }

            }
        }.start();
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            isText = false;
            switch (stopCounter) {
                case 0:
                    buttonChapterTwoThird.setText(R.string.chapter_two_porch_button_stop_second);
                    break;
                case 1:
                    buttonChapterTwoThird.setText(R.string.chapter_two_porch_button_stop_third);
                    break;
                default:
                    buttonChapterTwoThird.setVisibility(View.GONE);
                    nextText(R.string.chapter_two_porch_text_main_stop);
                    progressBarChapterTwoApartment.startAnimation(animationOut);
                    buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                    buttonChapterTwoSecond.setText(R.string.chapter_two_porch_button_stop_exit);
            }

            stopCounter++;


            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {

            isText = false;

            nextText(R.string.chapter_two_porch_text_main_final);
            buttonChapterTwoFour.setVisibility(View.GONE);
            buttonChapterTwoSecond.setVisibility(View.VISIBLE);
            buttonChapterTwoSecond.setText(R.string.chapter_two_porch_button_stop_exit);

            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }

    private void editProgressBar() {

        progress = 100;

        new CountDownTimer(20000, 200) {
            public void onTick(long millisUntilFinished) {
                progress -=1;
                progressBarChapterTwoApartment.setProgress(progress);

            }

            public void onFinish() {
            }
        }.start();
    }


}
