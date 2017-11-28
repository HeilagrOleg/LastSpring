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

import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoStart;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoTitle;
import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.oldStory.PrologueOldStory;
import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstRoad;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueBadEnding extends GameActivity {

    public static final String APP_SAVE_BREAKAGE_GONE = "Breakage gone";

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

        finishOst();

        isOstRoad = true;

        startService(new Intent(this, OstRoad.class));

        buttonPrologueFinalBadExtraEpisodeTrue = (Button) findViewById(R.id.buttonPrologueFinalBadExtraEpisodeTrueID);
        buttonPrologueFinalBadExtraEpisodeTrue.setTextSize(sizeFonts);
        buttonPrologueFinalBadExtraEpisodeFalse = (Button) findViewById(R.id.buttonPrologueFinalBadExtraEpisodeFalseID);
        buttonPrologueFinalBadExtraEpisodeFalse.setTextSize(sizeFonts);
        textPrologueFinalBadExtraEpisode = (TextView) findViewById(R.id.textPrologueFinalBadExtraEpisodeID);
        textPrologueFinalBadExtraEpisode.setTextSize(sizeFonts);

        textPrologueBadFinal = (TextView) findViewById(R.id.textPrologueBadFinalID);
        sText(textPrologueBadFinal);
        textPrologueBadFinal.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));
        textFinalBadTitle = (TextView) findViewById(R.id.textFinalBadTitleID);

        scrollPrologueBadFinal = (ScrollView) findViewById(R.id.scrollPrologueBadFinalID);
        sScroll(scrollPrologueBadFinal);

        radioGroupPrologueBadFinalFirst = (RadioGroup) findViewById(R.id.radioGroupPrologueBadFinalFirstID);

        backgroundPrologueFinalBad = (ConstraintLayout) findViewById(R.id.backgroundPrologueFinalBadID);

        buttonPrologueBadFinalFirst = (RadioButton) findViewById(R.id.buttonPrologueBadFinalFirstID);
        buttonPrologueBadFinalFirst.setTextSize(sizeFonts);

        constraintLayoutPrologueFinalBadExtraEpisode = (RelativeLayout) findViewById(R.id.constraintLayoutPrologueFinalBadExtraEpisodeID);

        backgroundAnimation = AnimationUtils.loadAnimation(this, R.anim.title_in);
        titleAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);

        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueBadFinal, radioGroupPrologueBadFinalFirst)));

        if (save.getBoolean(APP_SAVE_BREAKAGE_GONE,false)) {
            textPrologueBadFinal.setText(R.string.prologue_final_bad_text_start_second);
        }

    }

    public void onPrologueCaveAfterFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollPrologueBadFinal);
            if (isSecond) {
                textPrologueBadFinal.setText(R.string.prologue_final_bad_text_final);
                buttonPrologueBadFinalFirst.setText(R.string.prologue_final_bad_button_exit);
                if (save.getBoolean(APP_SAVE_BREAKAGE_GONE,false)) {
                    textPrologueBadFinal.setText(R.string.prologue_final_bad_text_final_second);
                }
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
                refreshScroll(scrollPrologueBadFinal);
                textPrologueBadFinal.setText(R.string.prologue_final_bad_text_next);
                buttonPrologueBadFinalFirst.setText(R.string.prologue_final_bad_button_next);
                if (save.getBoolean(APP_SAVE_BREAKAGE_GONE,false)) {
                    textPrologueBadFinal.setText(R.string.prologue_final_bad_text_next_second);
                }
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
        finishOst();
        getNextScene(new Intent(this, ChapterTwoTitle.class));
        finish();
    }

    public void onPrologueFinalGoodExtraEpisodeFalse(View view) {
        finishOst();
        getNextScene(new Intent(this, MainActivity.class));
        finish();
    }
}
