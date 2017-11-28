package com.example.last_spring.gameprealpha.chapterTwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoCabinet extends GameActivityTwo {

    private boolean isStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_cabinet);

        getSave(15f);

        getInterfaceChapterTwo();

        getButtons();

        startAnimation(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));

        date = 1003;

        isStart = true;

    }

    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            if (isStart) {
                getRespectUp();
                isStart = false;
                textChapterTwo.setText(R.string.chapter_two_cabinet_text_alin_true);
                buttonChapterTwoFirst.setText(R.string.chapter_two_cabinet_button_alin_father);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
            } else {
                textChapterTwo.setText(R.string.chapter_two_cabinet_text_alin_father);
                buttonChapterTwoFirst.setVisibility(View.GONE);
            }
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFirst);
            isFirst = true;
        }
    }

    public void onChapterTwoSecond(View view) {
        if (isSecond) {
            getRespectDown();
            textChapterTwo.setText(R.string.chapter_two_cabinet_text_alin_false);
            isStart = false;
            buttonChapterTwoFirst.setText(R.string.chapter_two_cabinet_button_alin_father);
            buttonChapterTwoSecond.setVisibility(View.GONE);
            buttonChapterTwoThird.setVisibility(View.VISIBLE);
            buttonChapterTwoFour.setVisibility(View.VISIBLE);
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            textChapterTwo.setText(R.string.chapter_two_cabinet_text_alin_photo);
            buttonChapterTwoThird.setVisibility(View.GONE);
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            getNextScene(ChapterTwoCutScene.class);
            finish();
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }
}
