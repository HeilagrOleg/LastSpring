package com.example.last_spring.gameprealpha.prologue;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
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

import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.oldStory.PrologueOldStory;
import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueGoodEnding extends GameActivity {

    private TextView textPrologueGoodFinal;
    private TextView textFinalGoodTitle;

    private ConstraintLayout backgroundPrologueFinalGood;
    private RelativeLayout constraintLayoutPrologueFinalGoodExtraEpisode;

    private RadioGroup radioGroupPrologueGoodFinalFirst;

    private RadioButton buttonPrologueGoodFinalFirst;

    private ScrollView scrollPrologueGoodFinal;

    private TextView textPrologueFinalGoodExtraEpisode;

    private Button buttonPrologueFinalGoodExtraEpisodeTrue;

    private Button buttonPrologueFinalGoodExtraEpisodeFalse;

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

        radioGroupPrologueGoodFinalFirst = (RadioGroup) findViewById(R.id.radioGroupPrologueGoodFinalFirstID);

        scrollPrologueGoodFinal = (ScrollView) findViewById(R.id.scrollPrologueGoodFinalID);
        sScroll(scrollPrologueGoodFinal);

        textPrologueGoodFinal = (TextView) findViewById(R.id.textPrologueGoodFinalID);
        sText(textPrologueGoodFinal);
        textFinalGoodTitle = (TextView) findViewById(R.id.textFinalGoodTitleID);
        textPrologueFinalGoodExtraEpisode = (TextView) findViewById(R.id.textPrologueFinalGoodExtraEpisodeID);
        textPrologueFinalGoodExtraEpisode.setTextSize(sizeFonts);

        backgroundPrologueFinalGood = (ConstraintLayout) findViewById(R.id.backgroundPrologueFinalGoodID);

        buttonPrologueFinalGoodExtraEpisodeTrue = (Button) findViewById(R.id.buttonPrologueFinalGoodExtraEpisodeTrueID);
        buttonPrologueFinalGoodExtraEpisodeTrue.setTextSize(sizeFonts);

        buttonPrologueFinalGoodExtraEpisodeFalse = (Button) findViewById(R.id.buttonPrologueFinalGoodExtraEpisodeFalseID);
        buttonPrologueFinalGoodExtraEpisodeFalse.setTextSize(sizeFonts);

        buttonPrologueGoodFinalFirst = (RadioButton) findViewById(R.id.buttonPrologueGoodFinalFirstID);
        buttonPrologueGoodFinalFirst.setTextSize(sizeFonts);



        constraintLayoutPrologueFinalGoodExtraEpisode = (RelativeLayout) findViewById(R.id.constraintLayoutPrologueFinalGoodExtraEpisodeID);

        backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.title_in);
        titleAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);





        startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueGoodFinalFirst, scrollPrologueGoodFinal)));


    }

    public void onPrologueCaveAfterFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollPrologueGoodFinal);
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
                refreshScroll(scrollPrologueGoodFinal);
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
