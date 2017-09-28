package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueBadEnding extends GameActivity {

    private TextView textPrologueBadFinal;
    private TextView textFinalBadTitle;

    private ConstraintLayout backgroundPrologueFinalBad;
    private RelativeLayout constraintLayoutPrologueFinalBadExtraEpisode;

    private Button buttonPrologueFinalBadExtraEpisodeTrue;
    private Button buttonPrologueFinalBadExtraEpisodeFalse;
    private TextView textPrologueFinalBadExtraEpisode;

    private ScrollView scrollPrologueBadFinal;

    private RadioGroup radioGroupPrologueBadFinalFirst;

    private RadioButton buttonPrologueBadFinalFirst;

    private Animation backgroundAnimation;
    private Animation titleAnimation;
    private Animation titleAnimationOut;

    private boolean isFirst;
    private boolean isSecond;
    private boolean isThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_bad_ending);

        getSave(5.1f);

        buttonPrologueFinalBadExtraEpisodeTrue = (Button) findViewById(R.id.buttonPrologueFinalBadExtraEpisodeTrueID);
        buttonPrologueFinalBadExtraEpisodeTrue.setTextSize(sizeFonts);
        buttonPrologueFinalBadExtraEpisodeFalse = (Button) findViewById(R.id.buttonPrologueFinalBadExtraEpisodeFalseID);
        buttonPrologueFinalBadExtraEpisodeFalse.setTextSize(sizeFonts);
        textPrologueFinalBadExtraEpisode = (TextView) findViewById(R.id.textPrologueFinalBadExtraEpisodeID);
        textPrologueFinalBadExtraEpisode.setTextSize(sizeFonts);

        textPrologueBadFinal = (TextView) findViewById(R.id.textPrologueBadFinalID);
        textPrologueBadFinal.setTextSize(sizeFonts);
        textFinalBadTitle = (TextView) findViewById(R.id.textFinalBadTitleID);

        scrollPrologueBadFinal = (ScrollView) findViewById(R.id.scrollPrologueBadFinalID);

        radioGroupPrologueBadFinalFirst = (RadioGroup) findViewById(R.id.radioGroupPrologueBadFinalFirstID);

        backgroundPrologueFinalBad = (ConstraintLayout) findViewById(R.id.backgroundPrologueFinalBadID);

        buttonPrologueBadFinalFirst = (RadioButton) findViewById(R.id.buttonPrologueBadFinalFirstID);
        buttonPrologueBadFinalFirst.setTextSize(sizeFonts);

        constraintLayoutPrologueFinalBadExtraEpisode = (RelativeLayout) findViewById(R.id.constraintLayoutPrologueFinalBadExtraEpisodeID);

        backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.title_in);
        titleAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);

        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueBadFinal, radioGroupPrologueBadFinalFirst)));

    }

    public void onPrologueCaveAfterFirst(View view) {
        if (isFirst) {
            if (isSecond) {
                refreshScroll(textPrologueBadFinal);
                textPrologueBadFinal.setText(R.string.prologue_final_bad_text_final);
                buttonPrologueBadFinalFirst.setText(R.string.prologue_final_bad_button_exit);
                isThird = true;
                isSecond = false;
            } else if (isThird) {
                buttonPrologueBadFinalFirst.setClickable(false);
                backgroundPrologueFinalBad.startAnimation(backgroundAnimation);
                new CountDownTimer(2000, 1500) {
                    public void onTick(long millisUntilFinished) {
                        textFinalBadTitle.startAnimation(backgroundAnimation);
                        new CountDownTimer(2000, 2000) {
                            public void onTick(long millisUntilFinished) {
                            }

                            public void onFinish() {
                                textFinalBadTitle.setVisibility(View.VISIBLE);
                                constraintLayoutPrologueFinalBadExtraEpisode.startAnimation(titleAnimation);
                                new CountDownTimer(800, 800) {
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    public void onFinish() {
                                        constraintLayoutPrologueFinalBadExtraEpisode.setVisibility(View.VISIBLE);
                                        textFinalBadTitle.setVisibility(View.VISIBLE);
                                    }
                                }.start();

                            }
                        }.start();
                    }

                    public void onFinish() {
                        backgroundPrologueFinalBad.setVisibility(View.VISIBLE);
                    }
                }.start();
            } else {
                refreshScroll(textPrologueBadFinal);
                textPrologueBadFinal.setText(R.string.prologue_final_bad_text_next);
                buttonPrologueBadFinalFirst.setText(R.string.prologue_final_bad_button_next);
                isSecond = true;
            }
            isFirst = false;
            buttonPrologueBadFinalFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueBadFinalFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
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
