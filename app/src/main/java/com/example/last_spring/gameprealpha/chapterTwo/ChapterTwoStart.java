package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstSnowy;

public class ChapterTwoStart extends GameActivityTwo {

    private Animation animationBackgroundFirst;
    private Animation animationBackgroundSecond;
    private Animation animationBackgroundThird;

    private ImageView imageChapterTwoBackgroundFirst;
    private ImageView imageChapterTwoBackgroundSecond;
    private ImageView imageChapterTwoBackgroundThird;

    private ImageButton buttonChapterTwoStartNext;

    private TextView textChapterTwoStartDate;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_start);


        animationBackgroundFirst = AnimationUtils.loadAnimation(this, R.anim.chapter_two_start_background_animation_first);
        animationBackgroundSecond = AnimationUtils.loadAnimation(this, R.anim.chapter_two_start_background_animation_second);
        animationBackgroundThird = AnimationUtils.loadAnimation(this, R.anim.chapter_two_start_background_animation_third);

        imageChapterTwoBackgroundFirst = (ImageView) findViewById(R.id.imageChapterTwoBackgroundFirstID);
        imageChapterTwoBackgroundSecond = (ImageView) findViewById(R.id.imageChapterTwoBackgroundTwoID);
        imageChapterTwoBackgroundThird = (ImageView) findViewById(R.id.imageChapterTwoBackgroundThirdID);

        buttonChapterTwoStartNext = (ImageButton) findViewById(R.id.buttonChapterTwoStartNextID);


        textChapterTwoStartDate = (TextView) findViewById(R.id.textChapterTwoStartDateID);

        startAnimationChapterTwo(textChapterTwoStartDate);

        new CountDownTimer(5000, 5000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                getOutText();
                imageChapterTwoBackgroundFirst.startAnimation(animationBackgroundFirst);
                imageChapterTwoBackgroundSecond.startAnimation(animationBackgroundSecond);
                imageChapterTwoBackgroundThird.startAnimation(animationBackgroundThird);
                startAnim();
            }
        }.start();


    }

    private void startAnim() {

        isOstShowy = true;
        startService(new Intent(this, OstSnowy.class));
        new CountDownTimer(12000, 6000) {
            public void onTick(long millisUntilFinished) {
                imageChapterTwoBackgroundFirst.setVisibility(View.GONE);
            }

            public void onFinish() {
                imageChapterTwoBackgroundSecond.setVisibility(View.GONE);
            }
        }.start();

        new CountDownTimer(13000, 13000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                showWindow();
                textChapterTwoStartDate.setText(R.string.chapter_two_start_text_location);
                startAnimationChapterTwo(textChapterTwoStartDate);
                imageChapterTwoBackgroundSecond.setVisibility(View.GONE);
            }
        }.start();
    }

    private void getOutText() {


        textChapterTwoStartDate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.title_out));
        new CountDownTimer(2000, 2000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                textChapterTwoStartDate.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    private void showWindow() {
        new CountDownTimer(2000, 2000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Resources res = getResources();
                imageChapterTwoBackgroundThird.setImageDrawable(res.getDrawable(R.drawable.chapter_two_start_background_third_second));
                textChapterTwoStartDate.setText(R.string.chapter_two_start_text_location_second);
                buttonChapterTwoStartNext.setVisibility(View.VISIBLE);
                ObjectAnimator.ofFloat(buttonChapterTwoStartNext, View.ALPHA, 0, 1);
            }
        }.start();
    }

    public void onChapterTwoStartNextID(View view) {
        getNextScene(ChapterTwoApartment.class);
        finish();
    }
}
