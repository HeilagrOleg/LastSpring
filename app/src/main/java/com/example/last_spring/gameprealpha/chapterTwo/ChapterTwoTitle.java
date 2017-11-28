package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.prologue.PrologueStart;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstSnowy;
import com.last_spring.gameprealpha.OstWood;

public class ChapterTwoTitle extends GameActivityTwo {

    private Animation inAnimation;
    private Animation outAnimation;

    private TextView stringTitle;
    private TextView stringData;

    private boolean isNext;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_title);

        finishOst();

        inAnimation = AnimationUtils.loadAnimation(this, R.anim.title_in);
        outAnimation = AnimationUtils.loadAnimation(this, R.anim.title_out);

        isNext = true;

        stringTitle = (TextView) findViewById(R.id.ChapterTwoTitleID);
        stringData = (TextView) findViewById(R.id.ChapterTwoTotleDateID);
        stringTitle.setVisibility(View.VISIBLE);
        stringTitle.startAnimation(inAnimation);
        new CountDownTimer(2000, 2000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                new CountDownTimer(2000, 2000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        if(isNext) {
                            isNext = false;
                            stringTitle.startAnimation(outAnimation);
                            startAnimationChapterTwo(stringData);
                            new CountDownTimer(4000, 4000) {
                                public void onTick(long millisUntilFinished) {
                                }
                                public void onFinish() {
                                    stringTitle.setVisibility(View.GONE);
                                    next();
                                }
                            }.start();
                        }
                    }
                }.start();
            }
        }.start();
    }

    public void onNext(View view) {
        if(isNext) {
            isNext = false;
            stringTitle.startAnimation(outAnimation);
            new CountDownTimer(2000, 2000) {
                public void onTick(long millisUntilFinished) {
                }
                public void onFinish() {
                    stringTitle.setVisibility(View.GONE);
                    next();
                }
            }.start();
        }
    }


    public void next() {
        Intent intent = new Intent(this, ChapterTwoStart.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }
}
