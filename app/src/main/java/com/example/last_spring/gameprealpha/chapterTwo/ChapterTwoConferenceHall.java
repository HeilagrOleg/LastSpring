package com.example.last_spring.gameprealpha.chapterTwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoConferenceHall extends GameActivityTwo {

    public static final String APP_SAVE_CHAPTER_TWO_LATE = "Late";

    private boolean isStart;
    private boolean isExit;
    private boolean isLate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_conference_hall);

        getSave(12f);

        getInterfaceChapterTwo();

        getButtons();

        isStart = true;
        isExit = false;

        if (date <= 0) {
            isLate = true;
            editor.putBoolean(APP_SAVE_CHAPTER_TWO_LATE, true);
            editor.apply();
        }

        if (isLate) {
            textChapterTwo.setText(R.string.chapter_two_conference_hall_late_start);
            buttonChapterTwoFirst.setText(R.string.chapter_two_conference_hall_late_button_exit);

            isStart = false;
            isExit = true;
            buttonChapterTwoSecond.setVisibility(View.GONE);
        }


        startAnimation(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));


    }

    public void onChapterTwoFirst(View view) {
        if (isFirst) {

            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_conference_hall_no_late_show);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
            } else if (isExit) {
                getNextScene(ChapterTwoDialog.class);
                finish();
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
                textChapterTwo.setText(R.string.chapter_two_conference_hall_no_late_watch);
                buttonChapterTwoSecond.setVisibility(View.GONE);
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
                textChapterTwo.setText(R.string.chapter_two_conference_hall_no_late_taste);
                buttonChapterTwoFirst.setText(R.string.chapter_two_conference_hall_no_late_button_exit);
                buttonChapterTwoFirst.setVisibility(View.VISIBLE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.GONE);
                isStart = false;
                isExit = true;
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
                textChapterTwo.setText(R.string.chapter_two_conference_hall_no_late_plan);
                buttonChapterTwoFirst.setText(R.string.chapter_two_conference_hall_no_late_button_exit);
                buttonChapterTwoFirst.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.GONE);
                isStart = false;
                isExit = true;
            }

            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }


    }
}
