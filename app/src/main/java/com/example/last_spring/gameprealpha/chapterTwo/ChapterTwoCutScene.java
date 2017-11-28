package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstSnowy;

public class ChapterTwoCutScene extends GameActivityTwo {

    private TextView textChapterTwoCutScene;

    private Animation animationIn;
    private Animation animationOut;
    private Animation imageAnimation;

    private ImageView imageAnimationBack;

    private int textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_cut_scene);

        finishOst();

        isOst = true;
        ost = MediaPlayer.create(this, R.raw.ost_dream);
        ost.setLooping(true);
        ost.start();

        startService(new Intent(this, OstSnowy.class));

        getSave(16f);

        date = 0;

        imageAnimationBack = (ImageView) findViewById(R.id.imageAnimationBackID);
        imageAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_image_animation);
        imageAnimationBack.startAnimation(imageAnimation);

        textChapterTwoCutScene = (TextView) findViewById(R.id.textChapterTwoCutSceneID);
        sText(textChapterTwoCutScene);

        animationIn = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);
        animationOut = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_out_animation);

        textCounter = 1;

    }

    public void onTextChapterTwoCutScene(View view) {

        view.setClickable(false);


        switch (textCounter) {

            case 1:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_1);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 2:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_2);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 3:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_3);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 4:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_4);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 5:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_5);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 6:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_6);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 7:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_7);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 8:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_8);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 9:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_9);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 10:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textChapterTwoCutScene.startAnimation(animationIn);
                        textChapterTwoCutScene.setText(R.string.chapter_two_cabinet_cut_scene_text_10);
                        textChapterTwoCutScene.setClickable(true);
                        textCounter++;
                    }
                }.start();
                break;
            case 11:
                textChapterTwoCutScene.startAnimation(animationOut);
                new CountDownTimer(2000, 2000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        getNextScene(ChapterTwoFinal.class);
                        finish();
                    }
                }.start();
                break;
        }
    }

}
