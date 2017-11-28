package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;

import com.example.last_spring.gameprealpha.R;
import com.last_spring.gameprealpha.OstSnowy;

import java.util.ArrayList;
import java.util.Arrays;


public class ChapterTwoInstituteEntrance extends GameActivityTwo {

    public static final String APP_SAVE_CHAPTER_TWO_FAIL_LATE = "VERY LATE";

    private boolean isStart;
    private boolean isLuck;
    private boolean isFail;
    private boolean isVeryFail;
    private boolean isWait;
    private boolean isSecondFail;
    private boolean isThirdFail;
    private boolean isFourFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_institute_entrance);

        isOstShowy = true;

        startService(new Intent(this, OstSnowy.class));

        getSave(11f);

        getButtons();

        isStart = true;
        isLuck = false;
        isFail = false;
        isWait = false;
        isFour = false;
        isSecondFail = false;
        isThirdFail = false;
        isFourFail = false;

        getInterfaceChapterTwo();

        startAnimationChapterTwo(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));

        new CountDownTimer(500, 500) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                date += 2;
                getTime();
            }
        }.start();
    }

    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_start_second);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
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
                if (Fortune.isLuck(fortune, 95)) {
                    getFortuneChange(-10);
                    getLuckImage(true);
                    showMessageChapterTwo(R.string.chapter_two_message_luck_down);
                    textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_true);
                    buttonChapterTwoSecond.setVisibility(View.GONE);
                    buttonChapterTwoThird.setVisibility(View.GONE);
                    buttonChapterTwoFour.setVisibility(View.VISIBLE);
                    isStart = false;
                    isFail = true;
                } else {
                    getFortuneChange(10);
                    getLuckImage(false);
                    showMessageChapterTwo(R.string.chapter_two_message_luck_up);
                    textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false);
                    buttonChapterTwoSecond.setText(R.string.chapter_two_institute_entrance_button_luck_false_wait);
                    buttonChapterTwoThird.setText(R.string.chapter_two_institute_entrance_button_luck_false_stand_up);
                    isStart = false;
                    isFail = true;
                }
            } else if (isFail) {
                date+=15;
                getTime();
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_wait);
                buttonChapterTwoSecond.setText(R.string.chapter_two_institute_entrance_button_luck_false_good);
                buttonChapterTwoThird.setText(R.string.chapter_two_institute_entrance_button_luck_false_bad);
                isFail = false;
                isSecondFail = true;
            } else if (isSecondFail) {
                date+=2;
                getTime();
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_good);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isSecondFail = false;
            } else if (isWait) {
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_wait_bad);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isWait = false;
            } else if (isThirdFail) {
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_bad_good);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isThirdFail = false;
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
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_wait);
                buttonChapterTwoSecond.setText(R.string.chapter_two_institute_entrance_button_wait_bad);
                buttonChapterTwoThird.setText(R.string.chapter_two_institute_entrance_button_wait_good);
                date += 17;
                getTime();
                isStart = false;
                isWait = true;
            } else if (isWait) {
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_wait_good);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isWait = false;
            } else if (isFail) {
                date+=15;
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_stand_up);
                buttonChapterTwoSecond.setText(R.string.chapter_two_institute_entrance_button_luck_false_good);
                buttonChapterTwoThird.setText(R.string.chapter_two_institute_entrance_button_luck_false_bad);
                isFail = false;
                isSecondFail = true;
            } else if (isSecondFail) {
                date+=2;
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_bad);
                buttonChapterTwoSecond.setText(R.string.chapter_two_institute_entrance_button_luck_false_good);
                buttonChapterTwoThird.setText(R.string.chapter_two_institute_entrance_button_luck_false_bad_wait);
                date += 5;
                getTime();
                isSecondFail = false;
                isThirdFail = true;
            } else if (isThirdFail) {
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_bad_wait);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setText(R.string.chapter_two_institute_entrance_button_luck_false_bad_wait_second);
                isThirdFail = false;
                isFourFail = true;
            } else if (isFourFail) {
                textChapterTwo.setText(R.string.chapter_two_institute_entrance_text_luck_false_bad_wait_second);
                editor.putBoolean(APP_SAVE_CHAPTER_TWO_FAIL_LATE, true);
                editor.apply();
                isVeryFail = true;
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isFourFail = false;
            }
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            if (isVeryFail) {
                getNextScene(ChapterTwoDialog.class);
                finish();
            } else {
                getNextScene(ChapterTwoConferenceHall.class);
                finish();
            }
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }

    public void onTest(View view) {
        getMenuChapterTwo();
    }

    public void onTest2(View view) {
        fortune += 20;
    }
}
