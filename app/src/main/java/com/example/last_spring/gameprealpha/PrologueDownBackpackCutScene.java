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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class PrologueDownBackpackCutScene extends GameActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_KNIFE = "Knife";
    private static final String APP_SAVE_RAINCOAT = "Raincoat";
    private static final String APP_SAVE_OINTMENT = "Ointment";
    private static final String APP_SAVE_FORTUNE = "Fortune";
    private static final String APP_SAVE_TREATMENT = "Treatment";
    private static final String APP_SAVE_FOOD = "Food";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";

    private Button buttonPrologueDownBackpackCutSceneSleep;

    private CheckBox checkBoxPrologueDownBackpackCutSceneFood;
    private CheckBox checkBoxPrologueDownBackpackCutSceneTreatment;

    private ImageView imageCutScene;

    private LinearLayout linearBoxPrologueDownBackpackCutScene;

    private float level;

    private boolean isNext;

    private Animation inAnimation;
    private Animation outAnimation;
    private Animation imageAnimation;

    private TextView textPrologueDownBackpackCutScene;

    private int textCounter;

    private SharedPreferences save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_down_backpack_cut_scene);
        textPrologueDownBackpackCutScene = (TextView) findViewById(R.id.textPrologueDownBackpackCutSceneID);
        textCounter = 0;
        level = 2.121f;

        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
        stopService(new Intent(this, OstWood.class));

        isOst = true;
        ost = MediaPlayer.create(this, R.raw.ost_dream);
        ost.setLooping(true);
        ost.start();

        linearBoxPrologueDownBackpackCutScene = (LinearLayout) findViewById(R.id.linearBoxPrologueDownBackpackCutSceneID);

        imageCutScene = (ImageView) findViewById(R.id.imageAnimationID);
        imageAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_image_animation);
        imageCutScene.startAnimation(imageAnimation);

        buttonPrologueDownBackpackCutSceneSleep = (Button) findViewById(R.id.buttonPrologueDownBackpackCutSceneSleepID);

        checkBoxPrologueDownBackpackCutSceneFood = (CheckBox) findViewById(R.id.checkBoxPrologueDownBackpackCutSceneFoodID);
        checkBoxPrologueDownBackpackCutSceneTreatment = (CheckBox) findViewById(R.id.checkBoxPrologueDownBackpackCutSceneTreatmentID);
        if (!save.getBoolean(APP_SAVE_OINTMENT, false)) {
            checkBoxPrologueDownBackpackCutSceneTreatment.setVisibility(View.GONE);
            treatmentCounterMain = 0;
        } else {
            treatmentCounterMain = 2;
        }
        //linearBoxPrologueDownBackpackCutScene.setVisibility(View.GONE);
       // buttonPrologueDownBackpackCutSceneSleep.setVisibility(View.GONE);

        foodCounterMain = 2;

        inAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);
        outAnimation = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_out_animation);
        isNext = false;

    }

    public void onTextPrologueDownBackpackCutSceneNext(View view) {
        if (!isNext) {
            if (textCounter == 0) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_first);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();
            } else if (textCounter == 1) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_second);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();
            } else if (textCounter == 2) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_third);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 3) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_fourth);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 4) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_fifth);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 5) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_six);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 6) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_seven);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 7) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_eight);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 8) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_nine);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 9) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_dix);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 10) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_eleven);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 11) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_twelve);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 12) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_thirteen);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 13) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_fourteen);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 14) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_sixteen);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 15) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_seventeen);
                        textCounter++;
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            } else if (textCounter == 16) {
                textPrologueDownBackpackCutScene.startAnimation(outAnimation);
                isNext = true;
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        textPrologueDownBackpackCutScene.setText(R.string.text_prologue_down_backpack_cut_scene_eighteen);
                        textCounter++;
                        buttonPrologueDownBackpackCutSceneSleep.setVisibility(View.VISIBLE);
                        linearBoxPrologueDownBackpackCutScene.setVisibility(View.VISIBLE);
                        textPrologueDownBackpackCutScene.startAnimation(inAnimation);
                        isNext = false;
                    }
                }.start();

            }
        }
    }

    public void onPrologueDownBackpackCutSceneSleep(View view) {
        if (checkBoxPrologueDownBackpackCutSceneFood.isChecked()) {
            foodCounterMain -= 1;
            isFaim = false;
            SharedPreferences.Editor editor = save.edit();
            editor.putBoolean(APP_SAVE_FAIM, isFaim);
            editor.putInt(APP_SAVE_FOOD, foodCounterMain);
            editor.apply();
        }
        if (checkBoxPrologueDownBackpackCutSceneTreatment.isChecked()) {
            treatmentCounterMain -= 1;
            wound--;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt(APP_SAVE_WOUND, wound);
            editor.putInt(APP_SAVE_TREATMENT, treatmentCounterMain);
            editor.apply();
        }
        ost.stop();
        startService(new Intent(this, OstWood.class));
        Intent intent = new Intent(this, PrologueBackpackAfterCutScene.class);
        getNextScene(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }
}
