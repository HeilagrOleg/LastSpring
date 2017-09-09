package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.example.last_spring.gameprealpha.R;
import com.last_spring.gameprealpha.OstWood;

public class PrologueTitle extends GameActivity {

    private Animation inAnimation;
    private Animation outAnimation;

    private TextView stringTitle;

    private boolean isNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_title);

        level = 1;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        startService(new Intent(this, OstWood.class));
        isOstWood = true;
        inAnimation = AnimationUtils.loadAnimation(this, R.anim.title_in);
        outAnimation = AnimationUtils.loadAnimation(this, R.anim.title_out);

        isNext = true;

        stringTitle = (TextView) findViewById(R.id.prologueTitleID);
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
        Intent intent = new Intent(this, Prologue_start.class);
        getNextScene(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }
}
