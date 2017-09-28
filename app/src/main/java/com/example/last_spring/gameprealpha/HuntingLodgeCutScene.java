package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;

public class HuntingLodgeCutScene extends GameActivity {

    public static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_PROLOGUE_HUNTING_KNIFE = "Knife bedside";
    private static final String APP_SAVE_PROLOGUE_HUNTING_SLEEPING_BUG = "Extra sleeping bug";
    private static final String APP_SAVE_PROLOGUE_HUNTING_FOOD = "Food hunting lodge";

    private Animation inAnimation;
    private Animation outAnimation;
    private Animation imageAnimation;

    private float level;
    private TextView textHuntingLodgeHunterStart;

    private ImageView imageAnimationBack;

    private int textCounter;

    private boolean isKnifeBedside;
    private boolean isFood;
    private boolean isSleepingBug;
    private boolean isNext;

    private SharedPreferences save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_cut_scene);

        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        level = 1.13f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        stopService(new Intent(this, OstDisturbance.class));

        isOst = true;
        ost = MediaPlayer.create(this, R.raw.ost_dream);
        ost.setLooping(true);
        ost.start();

        imageAnimationBack = (ImageView) findViewById(R.id.imageAnimationBackID);
        imageAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_image_animation);
        imageAnimationBack.startAnimation(imageAnimation);

        isKnifeBedside = save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false);
        isFood = save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_FOOD, false);

        isSleepingBug = save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_SLEEPING_BUG, false);

        textCounter = 0;

        textHuntingLodgeHunterStart = (TextView) findViewById(R.id.textHuntingLodgeHunterStartID);

        if (isSleepingBug) {
            textHuntingLodgeHunterStart.setText(getString(R.string.hunting_Lodge_cut_scene_text_start_sleeping_bug));
        } else {
            textHuntingLodgeHunterStart.setText(getString(R.string.hunting_Lodge_cut_scene_text_start_no_sleeping_bug));
        }

        textHuntingLodgeHunterStart.setTextSize(sizeFonts);

        inAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);
        outAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_out_animation);

        isNext = false;
    }

    public void onTextHuntingLodgeSceneNext(View view) {
        if (!isNext) {
            switch (textCounter) {
                case 0:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            if (isKnifeBedside) {
                                textHuntingLodgeHunterStart.setText(getString(R.string.hunting_Lodge_cut_scene_text_start_knife));
                                isKnifeBedside = false;
                            } else if (isFood) {
                                textHuntingLodgeHunterStart.setText(getString(R.string.hunting_Lodge_cut_scene_text_start_food));
                                isFood = false;
                            } else {
                                textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_2);
                                textCounter++;
                            }
                            textCounter++;
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            isNext = false;
                        }
                    }.start();
                    break;
                case 1:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_3);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 2:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_4);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 3:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_5);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 4:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_6);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 5:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(300, 300) {
                        public void onTick(long millisUntilFinished) {
                        }
                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_7);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 6:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_8);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 7:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_9);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 8:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_10);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 9:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_11);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 10:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_12);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 11:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_13);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 12:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_14);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 13:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_15);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 14:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_16);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                case 15:
                    textHuntingLodgeHunterStart.startAnimation(outAnimation);
                    isNext = true;
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            textHuntingLodgeHunterStart.startAnimation(inAnimation);
                            textHuntingLodgeHunterStart.setText(R.string.hunting_Lodge_cut_scene_text_start_17);
                            textCounter++;
                            isNext = false;
                        }
                    }.start();
                    break;

                default:
                    stopService(new Intent(this, OstDisturbance.class));
                    ost.stop();
                    getNextScene(new Intent(this, HuntingLodgeHunter.class));
                    finish();
                    overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            }
        }
    }

    public void onClick(View view) {
        stopService(new Intent(this, OstDisturbance.class));
        ost.stop();
        getNextScene(new Intent(this, HuntingLodgeHunter.class));
        finish();
    }
}
