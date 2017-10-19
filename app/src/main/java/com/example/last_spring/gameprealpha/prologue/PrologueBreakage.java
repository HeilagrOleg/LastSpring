package com.example.last_spring.gameprealpha.prologue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.sax.EndTextElementListener;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueBreakage extends GameActivity {

    public static final String APP_SAVE_BREAKAGE_FOOD = "Breakage food";


    private ConstraintLayout constraintLayoutFirst;
    private ConstraintLayout constraintLayoutSecond;

    private RelativeLayout layoutPrologueTrainingBreakage;

    private ImageButton imageButtonBreakageFirst;
    private ImageButton imageButtonBreakageSecond;

    private Button buttonBreakage;
    private Button buttonBreakageTest;

    private CheckBox checkBoxPrologueTrainingBreakage;

    private RadioButton radioButtonTrainingBreakage;

    private TextView textFailCounter;
    private TextView textTime;
    private TextView textPrologueTrainingBreakage;
    private TextView textPrologueBreakage;

    private RadioGroup radioGroupPrologueBreakage;

    private ScrollView scrollPrologueBreakage;

    private RadioButton buttonPrologueBreakageFirst;

    private CountDownTimer timer;

    private SeekBar seekBarBreakage;

    private String stFailCount;

    private int pointsCounter;
    private int pointsCounterMain;
    private int failCounter;
    private int maxPointsForSecondRight;
    private int maxFail;
    private int leftCounter;
    private int rightCounter;
    private int right;
    private int left;


    private double time;

    private boolean isTime;
    private boolean isSide;
    private boolean isFinish;
    private boolean isGameOver;
    private boolean isStart;
    private boolean isTraining;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_breakage);

        finishOst();

        level = 4.0f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        layoutPrologueTrainingBreakage = (RelativeLayout) findViewById(R.id.layoutPrologueTrainingBreakageID);


        constraintLayoutFirst = (ConstraintLayout) findViewById(R.id.constraintLayoutFirstID);
        constraintLayoutSecond = (ConstraintLayout) findViewById(R.id.constraintLayoutSecondID);

        constraintLayoutFirst.setVisibility(View.GONE);
        constraintLayoutSecond.setVisibility(View.GONE);

        checkBoxPrologueTrainingBreakage = (CheckBox) findViewById(R.id.checkBoxPrologueTrainingBreakageID);
        checkBoxPrologueTrainingBreakage.setTextSize(sizeFonts);

        radioButtonTrainingBreakage = (RadioButton) findViewById(R.id.radioButtonTrainingBreakageID);
        radioButtonTrainingBreakage.setTextSize(sizeFonts);

        buttonPrologueBreakageFirst = (RadioButton) findViewById(R.id.buttonPrologueBreakageFirstID);
        buttonPrologueBreakageFirst.setTextSize(sizeFonts);

        textPrologueTrainingBreakage = (TextView) findViewById(R.id.textPrologueTrainingBreakageID);
        sText(textPrologueTrainingBreakage);

        textPrologueBreakage = (TextView) findViewById(R.id.textPrologueBreakageID);
        sText(textPrologueBreakage);

        radioGroupPrologueBreakage = (RadioGroup) findViewById(R.id.radioGroupPrologueBreakageID);
        scrollPrologueBreakage = (ScrollView) findViewById(R.id.scrollPrologueBreakageID);
        sScroll(scrollPrologueBreakage);

        seekBarBreakage = (SeekBar) findViewById(R.id.seekBarBreakageID);
        seekBarBreakage.setMax(600);
        seekBarBreakage.setProgress(300);

        imageButtonBreakageFirst = (ImageButton) findViewById(R.id.imageButtonBreakageFirstID);
        imageButtonBreakageSecond = (ImageButton) findViewById(R.id.imageButtonBreakageSecondID);

        buttonBreakage = (Button) findViewById(R.id.buttonBreakageID);
        buttonBreakage.setTextSize(sizeFonts);
        buttonBreakageTest = (Button) findViewById(R.id.buttonBreakageTestID);
        buttonBreakageTest.setTextSize(sizeFonts);

        ost = MediaPlayer.create(this, R.raw.ost_action_prologue);


        maxPointsForSecondRight = 15;
        if (save.getBoolean(APP_SAVE_BREAKAGE_FOOD, false)) {
            maxFail = 14;
        } else {
            maxFail = 7;
        }
        pointsCounter = 200;
        pointsCounterMain = 200;
        failCounter = 0;
        time = 160;
        leftCounter = 0;
        rightCounter = 0;
        left = 0;
        right = 0;

        isStart = true;


        stFailCount = "Ошибок: " + failCounter + "/" + maxFail;
        textFailCounter = (TextView) findViewById(R.id.textFailCounterID);
        textFailCounter.setText(stFailCount);
        textFailCounter.setTextSize(sizeFonts);

        textTime = (TextView) findViewById(R.id.textTimeID);
        textTime.setTextSize(sizeFonts);

        if (!save.getBoolean(APP_SAVE_TRAINING, false)) {
            layoutPrologueTrainingBreakage.setVisibility(View.VISIBLE);
        } else  {
            buttonBreakage.setVisibility(View.VISIBLE);
            buttonBreakageTest.setVisibility(View.VISIBLE);
        }

        getInterface(true);

    }

    public void onBreakage(View view) {
        isOst = true;
        ost.start();
        ost.setLooping(true);
        time = 450;
        failCounter = 0;
        buttonBreakageTest.setVisibility(View.GONE);
        textFailCounter.setVisibility(View.VISIBLE);
        stFailCount = "Ошибок: " + failCounter + "/" + maxFail;
        textFailCounter.setText(stFailCount);
        textTime.setVisibility(View.VISIBLE);
        textTime.setText(String.valueOf(time));
        buttonBreakage.setVisibility(View.GONE);
        constraintLayoutFirst.setVisibility(View.VISIBLE);
        constraintLayoutSecond.setVisibility(View.VISIBLE);
        timer = new CountDownTimer(100, 100) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                time--;
                textTime.setText(String.valueOf((int) time / 10));

                if (rightCounter < 6) {
                    right = rightCounter;
                } else {
                    rightCounter = 6;
                    right = 6;
                }

                if (leftCounter < 6) {
                    left = leftCounter;
                } else {
                    leftCounter = 6;
                    left = 6;
                }

                if (!isSide) {
                    isSide = true;
                    if ((int) (1 + Math.random() * 2) == 1) {
                        if (leftCounter > 0) {
                            leftCounter--;
                        }
                        rightCounter++;


                        pointsCounter += (1 + (int) (Math.random() * maxPointsForSecondRight)) + right;
                    } else {
                        if (rightCounter > 0) {
                            rightCounter--;
                        }
                        leftCounter++;
                        pointsCounter -= 1 + (int) (Math.random() * maxPointsForSecondRight) + left;
                    }
                } else if (leftCounter > rightCounter) {
                    if (rightCounter > 0) {
                        rightCounter--;
                    }
                    isSide = false;
                    leftCounter++;
                    pointsCounter -= 1 + (int) (Math.random() * maxPointsForSecondRight) + left;
                } else if (leftCounter < rightCounter) {
                    if (leftCounter > 0) {
                        leftCounter--;
                    }
                    isSide = false;
                    rightCounter++;
                    pointsCounter += (1 + (int) (Math.random() * maxPointsForSecondRight)) + right;
                } else {
                    if ((int) (1 + Math.random() * 2) == 1) {
                        if (leftCounter > 0) {
                            leftCounter--;
                        }
                        rightCounter++;
                        pointsCounter += (1 + (int) (Math.random() * maxPointsForSecondRight)) + right;
                    } else {
                        if (rightCounter > 0) {
                            rightCounter--;
                        }
                        leftCounter++;
                        pointsCounter -= 1 + (int) (Math.random() * maxPointsForSecondRight) + left;
                    }
                }


                seekBarBreakage.setProgress(pointsCounter);

                if (pointsCounter > 600 || pointsCounter < 0) {
                    isGameOver = true;
                } else if (pointsCounter > 450 || pointsCounter < 150) {
                    failCounter++;
                    stFailCount = "Ошибок: " + failCounter / 4 + "/" + maxFail;
                    textFailCounter.setText(stFailCount);
                    if (failCounter > maxFail * 4) {
                        isGameOver = true;
                    }
                }

                if (time < 1) {
                    if (isFinish) {
                        getFinal();
                    }
                    constraintLayoutFirst.setVisibility(View.GONE);
                    constraintLayoutSecond.setVisibility(View.GONE);
                    maxPointsForSecondRight = 18;
                    pointsCounter = 300;
                    ost.pause();
                    isOst = false;
                    seekBarBreakage.setProgress(pointsCounter);
                    failCounter = 0;
                    left = 0;
                    leftCounter = 0;
                    right = 0;
                    rightCounter = 0;
                    isStart = true;
                    isFinish = true;
                    buttonBreakage.setVisibility(View.VISIBLE);
                } else if (isGameOver) {
                    getGameOver();
                } else {
                    timer.start();
                }
            }
        };
        if (isStart) {
            timer.start();
            isStart = false;
        }
    }


    public void onButtonBreakageFirst(View view) {
        int points = 25 + left;
        pointsCounter -= points;
        leftCounter += 2;
        rightCounter -= 2;
        seekBarBreakage.setProgress(pointsCounter);
    }

    public void onButtonBreakageSecond(View view) {
        int points = 25 + right;
        pointsCounter += points;
        leftCounter -= 2;
        rightCounter += 2;
        seekBarBreakage.setProgress(pointsCounter);
    }

    public void getFinal() {
        ost.stop();
        isOst = false;
        Intent intent = new Intent(this, PrologueGoodEnding.class);
        getNextScene(intent);
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        finish();
    }

    public void getGameOver() {
        ost.stop();
        isOst = false;
        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueBreakage, radioGroupPrologueBreakage)));
        textFailCounter.setVisibility(View.GONE);
        textTime.setVisibility(View.GONE);
        seekBarBreakage.setVisibility(View.GONE);
        constraintLayoutFirst.setVisibility(View.GONE);
        constraintLayoutSecond.setVisibility(View.GONE);
        buttonBreakage.setVisibility(View.GONE);
        buttonBreakageTest.setVisibility(View.GONE);
    }

    public void onBreakageTest(View view) {
        time = 450;
        failCounter = 0;
        ost.pause();
        isOst = false;
        buttonBreakageTest.setVisibility(View.GONE);
        textFailCounter.setVisibility(View.VISIBLE);
        stFailCount = "Ошибок: " + failCounter;
        textFailCounter.setText(stFailCount);
        textTime.setVisibility(View.VISIBLE);
        textTime.setText(String.valueOf(time));
        buttonBreakage.setVisibility(View.GONE);
        constraintLayoutFirst.setVisibility(View.VISIBLE);
        constraintLayoutSecond.setVisibility(View.VISIBLE);
        timer = new CountDownTimer(100, 100) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                time--;
                textTime.setText(String.valueOf((int) time / 10));

                if (rightCounter < 6) {
                    right = rightCounter;
                } else {
                    rightCounter = 6;
                    right = 6;
                }

                if (leftCounter < 6) {
                    left = leftCounter;
                } else {
                    leftCounter = 6;
                    left = 6;
                }

                if (!isSide) {
                    isSide = true;
                    if ((int) (1 + Math.random() * 2) == 1) {
                        if (leftCounter > 0) {
                            leftCounter--;
                        }
                        rightCounter++;


                        pointsCounter += (1 + (int) (Math.random() * maxPointsForSecondRight)) + right;
                    } else {
                        if (rightCounter > 0) {
                            rightCounter--;
                        }
                        leftCounter++;
                        pointsCounter -= 1 + (int) (Math.random() * maxPointsForSecondRight) + left;
                    }
                } else if (leftCounter > rightCounter) {
                    if (rightCounter > 0) {
                        rightCounter--;
                    }
                    isSide = false;
                    leftCounter++;
                    pointsCounter -= 1 + (int) (Math.random() * maxPointsForSecondRight) + left;
                } else if (leftCounter < rightCounter) {
                    if (leftCounter > 0) {
                        leftCounter--;
                    }
                    isSide = false;
                    rightCounter++;
                    pointsCounter += (1 + (int) (Math.random() * maxPointsForSecondRight)) + right;
                } else {
                    if ((int) (1 + Math.random() * 2) == 1) {
                        if (leftCounter > 0) {
                            leftCounter--;
                        }
                        rightCounter++;
                        pointsCounter += (1 + (int) (Math.random() * maxPointsForSecondRight)) + right;
                    } else {
                        if (rightCounter > 0) {
                            rightCounter--;
                        }
                        leftCounter++;
                        pointsCounter -= 1 + (int) (Math.random() * maxPointsForSecondRight) + left;
                    }
                }


                seekBarBreakage.setProgress(pointsCounter);

                if (pointsCounter > 600 || pointsCounter < 0) {
                    isGameOver = true;
                } else if (pointsCounter > 450 || pointsCounter < 150) {
                    failCounter++;
                    stFailCount = "Ошибок: " + failCounter / 4 + "/" + maxFail;
                    textFailCounter.setText(stFailCount);
                    if (failCounter > maxFail * 4) {
                        isGameOver = true;
                    }
                }

                if (time < 1 || isGameOver) {
                    buttonBreakageTest.setVisibility(View.VISIBLE);
                    constraintLayoutFirst.setVisibility(View.GONE);
                    constraintLayoutSecond.setVisibility(View.GONE);
                    pointsCounter = 300;
                    seekBarBreakage.setProgress(pointsCounter);
                    failCounter = 0;
                    left = 0;
                    leftCounter = 0;
                    right = 0;
                    rightCounter = 0;
                    ost.pause();
                    isStart = true;
                    isFinish = true;
                    buttonBreakage.setVisibility(View.VISIBLE);
                    isGameOver = false;

                } else {
                    timer.start();
                }
            }
        };
        if (isStart) {
            timer.start();
            isStart = false;
        }
    }

    public void onPrologueStartTrainingBackpack(View view) {
        if (isTraining) {

            if (checkBoxPrologueTrainingBreakage.isChecked()) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_TRAINING, true);
                editor.apply();
            }

            buttonBreakageTest.setVisibility(View.VISIBLE);
            buttonBreakage.setVisibility(View.VISIBLE);

            layoutPrologueTrainingBreakage.setVisibility(View.GONE);
        } else {
            isTraining = true;
            radioButtonTrainingBreakage.setBackgroundColor(Color.parseColor("#607e9e7f"));
        }

    }

    public void onPrologueBreakageFirst(View view) {
        if (isFirst) {
            getNextScene(new Intent(this, PrologueBadEnding.class));
            finish();
        } else {
            buttonPrologueBreakageFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = true;
        }
    }
}
