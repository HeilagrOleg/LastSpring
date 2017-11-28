package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;

import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstSnowy;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoPorch extends GameActivityTwo {

    private boolean isButton;
    private boolean isText;
    private boolean isExit;
    private boolean isFirstText;
    private boolean isLuck;

    private ProgressBar progressBarChapterTwoApartment;

    private int textCounter;
    private int stopCounter;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_porch);

        isOstShowy = true;

        startService(new Intent(this, OstSnowy.class));

        getSave(8f);

        progressBarChapterTwoApartment = (ProgressBar) findViewById(R.id.progressBarChapterTwoApartmentID);
        progressBarChapterTwoApartment.setProgress(100);

        textMessage = (TextView) findViewById(R.id.textMessageID);
        textMessage.setTextSize(sizeFonts + 4);

        imageBackgroundLuckFalse = (ImageView) findViewById(R.id.imageBackgroundLuckFalseID);
        imageBackgroundLuckTrue = (ImageView) findViewById(R.id.imageBackgroundLuckTrueID);


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
                                date += 2;
                                break;
                            case 1:
                                nextText(R.string.chapter_two_porch_text_main_third);
                                date += 2;
                                break;
                            case 2:
                                nextText(R.string.chapter_two_porch_text_main_four);
                                date += 2;
                                getTime();
                                break;
                            case 3:
                                nextText(R.string.chapter_two_porch_text_main_five);
                                date += 2;
                                break;
                            case 4:
                                nextText(R.string.chapter_two_porch_text_main_six);
                                date += 2;
                                break;
                            case 5:
                                nextText(R.string.chapter_two_porch_text_main_seven);
                                date += 2;
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
                    date += 2;
                    getTime();
                    getFortuneChange(15);
                    isLuck = true;
                    nextText(R.string.chapter_two_porch_text_main_eight);
                    progressBarChapterTwoApartment.startAnimation(animationOut);
                    buttonChapterTwoThird.setVisibility(View.GONE);
                    buttonChapterTwoFour.setVisibility(View.VISIBLE);
                    isText = false;
                }

            }
        }.start();
    }

    public void onChapterTwoThird(final View view) {
        if (isThird) {
            switch (stopCounter) {
                case 0:
                    buttonChapterTwoThird.setText(R.string.chapter_two_porch_button_stop_second);
                    view.setVisibility(View.GONE);
                    showMessageChapterTwo(R.string.chapter_two_porch_message_reaction_first);
                    new CountDownTimer(2000, 2000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            startAnimationChapterTwo(view);
                        }
                    }.start();
                    break;
                case 1:
                    buttonChapterTwoThird.setText(R.string.chapter_two_porch_button_stop_third);
                    view.setVisibility(View.GONE);
                    showMessageChapterTwo(R.string.chapter_two_porch_message_reaction_second);
                    new CountDownTimer(2000, 2000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            startAnimationChapterTwo(view);
                        }
                    }.start();
                    break;
                default:
                    isText = false;
                    buttonChapterTwoThird.setVisibility(View.GONE);
                    date += 2;
                    getTime();
                    nextText(R.string.chapter_two_porch_text_main_stop);
                    progressBarChapterTwoApartment.setVisibility(View.GONE);
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

            if (isLuck) {
                showMessageChapterTwo(R.string.chapter_two_porch_message_luck);
                getLuckImage(true);
            }

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
                progress -= 1;
                progressBarChapterTwoApartment.setProgress(progress);

            }

            public void onFinish() {
            }
        }.start();
    }


}
