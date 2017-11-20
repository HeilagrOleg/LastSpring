package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;

public class ChapterTwoStart extends GameActivityTwo {

    private Animation animationBackgroundFirst;
    private Animation animationBackgroundSecond;
    private Animation animationBackgroundThird;

    private ImageView imageChapterTwoBackgroundFirst;
    private ImageView imageChapterTwoBackgroundSecond;
    private ImageView imageChapterTwoBackgroundThird;

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

        imageChapterTwoBackgroundFirst.startAnimation(animationBackgroundFirst);
        imageChapterTwoBackgroundSecond.startAnimation(animationBackgroundSecond);
        imageChapterTwoBackgroundThird.startAnimation(animationBackgroundThird);
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
                imageChapterTwoBackgroundSecond.setVisibility(View.GONE);
            }
        }.start();

    }

    public void onChapterTwoStartNextID(View view) {
        getNextScene(ChapterTwoApartment.class);
        finish();
    }
}
