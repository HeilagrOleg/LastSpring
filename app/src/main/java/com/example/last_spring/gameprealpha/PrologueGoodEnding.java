package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;

public class PrologueGoodEnding extends GameActivity {

    private TextView textPrologueGoodFinal;
    private TextView textFinalGoodTitle;

    private ConstraintLayout backgroundPrologueFinalGood;
    private ConstraintLayout constraintLayoutPrologueFinalGoodExtraEpisode;

    private RadioButton buttonPrologueGoodFinalFirst;

    private Animation backgroundAnimation;
    private Animation titleAnimation;
    private Animation titleAnimationOut;

    private boolean isFirst;
    private boolean isSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_good_ending);

        getSave(5.0f);

        textPrologueGoodFinal = (TextView) findViewById(R.id.textPrologueGoodFinalID);
        textFinalGoodTitle = (TextView) findViewById(R.id.textFinalGoodTitleID);

        backgroundPrologueFinalGood = (ConstraintLayout) findViewById(R.id.backgroundPrologueFinalGoodID);

        buttonPrologueGoodFinalFirst = (RadioButton) findViewById(R.id.buttonPrologueGoodFinalFirstID);

        constraintLayoutPrologueFinalGoodExtraEpisode = (ConstraintLayout) findViewById(R.id.constraintLayoutPrologueFinalGoodExtraEpisodeID);

        backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.title_in);
        titleAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);

    }

    public void onPrologueCaveAfterFirst(View view) {
        if (isFirst) {
            if (isSecond) {
                buttonPrologueGoodFinalFirst.setClickable(false);
                backgroundPrologueFinalGood.startAnimation(backgroundAnimation);
                new CountDownTimer(2000, 1500) {
                    public void onTick(long millisUntilFinished) {
                        textFinalGoodTitle.startAnimation(backgroundAnimation);
                        new CountDownTimer(2000, 2000) {
                            public void onTick(long millisUntilFinished) {
                            }

                            public void onFinish() {
                                textFinalGoodTitle.setVisibility(View.VISIBLE);
                                constraintLayoutPrologueFinalGoodExtraEpisode.startAnimation(titleAnimation);
                                new CountDownTimer(800, 800) {
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    public void onFinish() {
                                        constraintLayoutPrologueFinalGoodExtraEpisode.setVisibility(View.VISIBLE);
                                        textFinalGoodTitle.setVisibility(View.VISIBLE);
                                    }
                                }.start();

                            }
                        }.start();
                    }

                    public void onFinish() {
                        backgroundPrologueFinalGood.setVisibility(View.VISIBLE);
                    }
                }.start();

            } else {
                textPrologueGoodFinal.setText(R.string.prologue_final_good_text_next);
                buttonPrologueGoodFinalFirst.setText(R.string.prologue_final_good_button_exit);
                isSecond = true;
            }
            isFirst = false;
            buttonPrologueGoodFinalFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueGoodFinalFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = true;
        }
    }

    public void onPrologueFinalGoodExtraEpisodeTrue(View view) {
        getNextScene(new Intent(this, PrologueOldStory.class));
        finish();
    }

    public void onPrologueFinalGoodExtraEpisodeFalse(View view) {
        getNextScene(new Intent(this, MainActivity.class));
        finish();
    }
}
