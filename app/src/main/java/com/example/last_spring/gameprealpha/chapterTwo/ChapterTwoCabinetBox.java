package com.example.last_spring.gameprealpha.chapterTwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoCabinetBox extends GameActivityTwo {

    private boolean isStart;
    private boolean isNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_cabinet_box);


        getButtons();

        getInterfaceChapterTwo();

        startAnimationChapterTwo(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));

    }


    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_watch);
                buttonChapterTwoFirst.setVisibility(View.GONE);
            } else {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_alin_true);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                respectAlin+=8;
                getRespectUp();
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
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_think);
                buttonChapterTwoSecond.setVisibility(View.GONE);
            } else  {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_alin_false);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                respectAlin -=8;
                getRespectDown();
            }
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_table);
            buttonChapterTwoThird.setVisibility(View.GONE);
            buttonChapterTwoFirst.setText(R.string.chapter_two_cabinet_box_button_alin_true);
            buttonChapterTwoFirst.setVisibility(View.VISIBLE);
            buttonChapterTwoSecond.setText(R.string.chapter_two_cabinet_box_button_alin_false);
            buttonChapterTwoSecond.setVisibility(View.VISIBLE);
            isStart = false;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            scrollChapterTwo.setVisibility(View.GONE);
            radioGroupChapterTwo.setVisibility(View.GONE);
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }
}
