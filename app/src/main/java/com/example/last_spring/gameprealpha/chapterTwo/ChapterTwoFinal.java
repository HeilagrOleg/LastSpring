package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstRoad;
import com.last_spring.gameprealpha.OstSnowy;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoFinal extends GameActivityTwo {

    private boolean isStart;

    private RelativeLayout layoutChapterTwoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_final);

        finishOst();
        isOstRoad = true;

        startService(new Intent(this, OstRoad.class));

        getSave(17f);

        getButtons();

        getInterfaceChapterTwo();

        isStart = true;

        date = 1151;

        layoutChapterTwoFinal = (RelativeLayout) findViewById(R.id.layoutChapterTwoFinalID);

        startAnimation(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));
    }

    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_final_text_false);
                buttonChapterTwoFirst.setText(R.string.chapter_two_final_button_true_second);
                buttonChapterTwoSecond.setText(R.string.chapter_two_final_button_false_second);
                isStart = false;
            } else {
                textChapterTwo.setText(R.string.chapter_two_final_text_true_second);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
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
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_final_text_true);
                buttonChapterTwoFirst.setText(R.string.chapter_two_final_button_true_second);
                buttonChapterTwoSecond.setText(R.string.chapter_two_final_button_false_second);
                isStart = false;
            } else {
                textChapterTwo.setText(R.string.chapter_two_final_text_false_second);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
            }
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            textChapterTwo.setText(R.string.chapter_two_final_text_final);
            buttonChapterTwoThird.setVisibility(View.GONE);
            buttonChapterTwoFour.setVisibility(View.VISIBLE);
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            imageButtonMenuChapterTwo.setVisibility(View.GONE);
            startAnimationChapterTwo(layoutChapterTwoFinal);
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }

    public void onChapterTwoExitTrue(View view) {
        showMessageChapterTwo("А вот ХУЙ!");
    }

    public void onChapterTwoExitFalse(View view) {
        finishOst();
        getNextScene(MainActivity.class);
        finish();
    }
}
