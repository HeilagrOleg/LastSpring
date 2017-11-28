package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrologueDownFirstScene extends GameActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_FORTUNE = "Fortune";
    private static final String APP_SAVE_BACKPACK = "Backpack";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    private ProgressBar progressBarPrologueDown;
    private View miniGame;
    private Button prologueDownStartGameButton;
    private ImageButton firstButton;
    private ImageButton secondButton;
    private ImageButton thirdButton;
    private ImageButton fourthButton;
    private ImageButton fifthButton;
    private ImageButton sixthButton;
    private ImageButton seventhButton;
    private ImageButton eighthButton;
    private ImageButton ninthButton;
    private RadioButton prologueDownStartGameRadioButton;
    private RadioButton prologueDownStartExitRadioButton;
    private RadioButton prologueDownStartLuckRadioButton;
    private RadioButton prologueDownStartNoLuckRadioButton;
    private RadioGroup radioGroupPrologueDown;
    private RadioGroup secondRadioGroupPrologueDown;
    private ImageButton symbolPrologueDown;
    private TextView countPrologueDown;
    private TextView textPrologueDownStart;
    private CountDownTimer timer;
    protected float level;
    protected int firstRandom;
    private int secondRandom;
    protected int thirdRandom;
    private long timerTime;
    private long timerUp;
    private long timerDown;
    private boolean isLevel;
    private boolean isTimer;
    private boolean isFirstStart;
    private boolean isSleepingBag;
    protected boolean isGameVictory;
    private boolean isRadioButtonGame;
    private boolean isRadioButtonLuck;
    private boolean isRadioButtonExit;
    private boolean isRadioButtonNoLuck;
    private boolean isFinish;
    private Animation buttonRotate;
    protected int textCheckFirst;
    private int textCheckSecond;
    protected int textCheckThird;
    private SharedPreferences settings;

    private Animation trueAnimation;
    private Animation falseAnimation;
    private FrameLayout framePrologueFirst;
    private ConstraintLayout layoutBackgroundDownFirst;
    private RelativeLayout layoutPrologueTrainingBackPack;
    private TextView textPrologueTraining;
    private RadioButton radioButtonTrainingBackPack;
    private CheckBox checkBoxPrologueTrainingBackPack;
    private Resources res;

    private boolean isTraining;
    private boolean isTrainingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_down_first_scene);
        settings = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        isSleepingBag = settings.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
        level = 2.1f;
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
        startService(new Intent(this, OstWood.class));
        isOstWood = true;

        isTraining = true;

        ost = MediaPlayer.create(this, R.raw.ost_action_prologue);

        framePrologueFirst = (FrameLayout) findViewById(R.id.framePrologueFirstID);

        buttonRotate = AnimationUtils.loadAnimation(this, R.anim.button_animation_rotate);

        progressBarPrologueDown = (ProgressBar) findViewById(R.id.progressBarPrologueDownID);
        progressBarPrologueDown.setMax(50000);

        radioButtonTrainingBackPack = (RadioButton) findViewById(R.id.radioButtonTrainingBackPackID);
        radioButtonTrainingBackPack.setTextSize(sizeFonts);

        checkBoxPrologueTrainingBackPack = (CheckBox) findViewById(R.id.checkBoxPrologueTrainingBackPackID);
        checkBoxPrologueTrainingBackPack.setTextSize(sizeFonts);

        textPrologueDownStart = (TextView) findViewById(R.id.textPrologueDownID);
        sText(textPrologueDownStart);
        textPrologueDownStart.setText(R.string.prologue_down_start);
        textPrologueDownStart.setMovementMethod(new ScrollingMovementMethod());
        textPrologueDownStart.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

        textPrologueTraining = (TextView) findViewById(R.id.textPrologueTrainingBackPackID);
        sText(textPrologueTraining);

        isTimer = false;
        isFirstStart = true;
        isLevel = false;
        isFinish = false;


        timerUp = 4500;
        timerDown = 3000;
        timerTime = 15000;

        prologueDownStartExitRadioButton = (RadioButton) findViewById(R.id.prologueDownStartExitButtonID);
        prologueDownStartExitRadioButton.setTextSize(sizeFonts);
        prologueDownStartGameRadioButton = (RadioButton) findViewById(R.id.prologueDownStartGameButtonID);
        prologueDownStartGameRadioButton.setTextSize(sizeFonts);
        radioGroupPrologueDown = (RadioGroup) findViewById(R.id.radioGroupPrologueDownID);
        prologueDownStartLuckRadioButton = (RadioButton) findViewById(R.id.prologueDownStartLuckButtonID);
        prologueDownStartLuckRadioButton.setTextSize(sizeFonts);
        prologueDownStartNoLuckRadioButton = (RadioButton) findViewById(R.id.prologueDownStartNoLuckButtonID);
        prologueDownStartNoLuckRadioButton.setTextSize(sizeFonts);
        secondRadioGroupPrologueDown = (RadioGroup) findViewById(R.id.secondRadioGroupPrologueDownID);
        prologueDownStartLuckRadioButton.setText(R.string.prologue_game_over_down_luck);
        prologueDownStartLuckRadioButton.setVisibility(View.GONE);
        prologueDownStartNoLuckRadioButton.setVisibility(View.GONE);
        prologueDownStartNoLuckRadioButton.setText(R.string.prologue_game_over_down_no_luck);
        secondRadioGroupPrologueDown.setVisibility(View.GONE);
        layoutPrologueTrainingBackPack = (RelativeLayout) findViewById(R.id.layoutPrologueTrainingBackPackID);


        layoutBackgroundDownFirst = (ConstraintLayout) findViewById(R.id.layoutBackgroundDownFirstID);

        prologueDownStartGameButton = (Button) findViewById(R.id.buttonProlDownStartID);
        prologueDownStartGameButton.setTextSize(sizeFonts);
        prologueDownStartGameButton.setClickable(false);
        prologueDownStartGameButton.setVisibility(View.GONE);
        firstButton = (ImageButton) findViewById(R.id.firstButtonPlolDownID);
        firstButton.setVisibility(View.GONE);
        secondButton = (ImageButton) findViewById(R.id.secondButtonPlolDownID);
        secondButton.setVisibility(View.GONE);
        thirdButton = (ImageButton) findViewById(R.id.thirdButtonPlolDownID);
        thirdButton.setVisibility(View.GONE);
        fourthButton = (ImageButton) findViewById(R.id.fourthButtonPlolDownID);
        fourthButton.setVisibility(View.GONE);
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fifthButton = (ImageButton) findViewById(R.id.fifthButtonPlolDownID);
        fifthButton.setVisibility(View.GONE);
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sixthButton = (ImageButton) findViewById(R.id.sixthButtonPlolDownID);
        sixthButton.setVisibility(View.GONE);
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        seventhButton = (ImageButton) findViewById(R.id.seventhButtonPlolDownID);
        seventhButton.setVisibility(View.GONE);
        seventhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        eighthButton = (ImageButton) findViewById(R.id.eighthButtonPlolDownID);
        eighthButton.setVisibility(View.GONE);
        eighthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ninthButton = (ImageButton) findViewById(R.id.ninthButtonPlolDownID);
        ninthButton.setVisibility(View.GONE);
        ninthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        symbolPrologueDown = (ImageButton) findViewById(R.id.prolDownTextDirectionID);
        symbolPrologueDown.setVisibility(View.GONE);
        countPrologueDown = (TextView) findViewById(R.id.counterPrologDownID);
        countPrologueDown.setVisibility(View.GONE);

        trueAnimation = AnimationUtils.loadAnimation(this, R.anim.button_prologue_first_scene_animation_true);
        falseAnimation = AnimationUtils.loadAnimation(this, R.anim.button_prologue_first_scene_animation);

        res = getResources();

        getInterface(true);

        textMessage.setText(R.string.prologue_down_message);

        showMessage(textMessage, true);

        startAnimation(new ArrayList<View>(Arrays.asList(textPrologueDownStart, framePrologueFirst)));

    }

    public void onStartDownPrologue(View view) {
        prologueDownStartGameButton.setVisibility(View.GONE);
        textPrologueDownStart.setVisibility(View.GONE);
        progressBarPrologueDown.setVisibility(View.VISIBLE);
        layoutBackgroundDownFirst.setBackground(res.getDrawable(R.drawable.background_prologue_down_first_scene_game));

        if (isTraining) {
            if (!save.getBoolean(APP_SAVE_TRAINING, false)) {
                layoutPrologueTrainingBackPack.setVisibility(View.VISIBLE);
                firstButton.setClickable(false);
                secondButton.setClickable(false);
                thirdButton.setClickable(false);
                isTraining = false;
            }
        }


        if (!isFirstStart) {
            firstButton.clearAnimation();
            secondButton.clearAnimation();
            thirdButton.clearAnimation();
        }



        if (isFirstStart) {

            stopService(new Intent(this, OstWood.class));

            isOst = true;
            ost.start();
            ost.setLooping(true);

            progressBarPrologueDown.setVisibility(View.VISIBLE);
            progressBarPrologueDown.setProgress(25000);
            countPrologueDown.setVisibility(View.GONE);
            isFirstStart = false;
            timerUp = 4000;
            timerDown = 3000;
            timerTime = 15000;
        }


        miniGame = view;
        firstButton.setVisibility(View.GONE);
        secondButton.setVisibility(View.GONE);
        thirdButton.setVisibility(View.GONE);

        firstRandom = (int) (Math.random() * 9);
        while (firstRandom == secondRandom) {
            firstRandom = (int) (Math.random() * 9);
        }


        switch (firstRandom) {
            case 0:
                firstButton = (ImageButton) findViewById(R.id.firstButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 1:
                firstButton = (ImageButton) findViewById(R.id.secondButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                firstButton = (ImageButton) findViewById(R.id.thirdButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 3:
                firstButton = (ImageButton) findViewById(R.id.fourthButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 4:
                firstButton = (ImageButton) findViewById(R.id.fifthButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 5:
                firstButton = (ImageButton) findViewById(R.id.sixthButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 6:
                firstButton = (ImageButton) findViewById(R.id.seventhButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            case 7:
                firstButton = (ImageButton) findViewById(R.id.eighthButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
            default:
                firstButton = (ImageButton) findViewById(R.id.ninthButtonPlolDownID);
                firstButton.setVisibility(View.VISIBLE);
                break;
        }

        int testSymbol = (int) (Math.random() * 3);
        switch (testSymbol) {
            case 0:
                symbolPrologueDown.setImageResource(R.drawable.button1);
                symbolPrologueDown.setVisibility(View.VISIBLE);
                firstButton.setImageResource(R.drawable.button1);
                textCheckFirst = 0;
                break;
            case 1:
                symbolPrologueDown.setImageResource(R.drawable.button2);
                symbolPrologueDown.setVisibility(View.VISIBLE);
                firstButton.setImageResource(R.drawable.button2);
                textCheckFirst = 1;
                break;
            default:
                symbolPrologueDown.setImageResource(R.drawable.button3);
                symbolPrologueDown.setVisibility(View.VISIBLE);
                firstButton.setImageResource(R.drawable.button3);
                textCheckFirst = 2;
                break;
        }

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerTime >= 50000) {
                    if (isLevel) {
                        timer.cancel();
                        gameVictory();
                    } else {
                        ost.pause();
                        timer.cancel();
                        isLevel = true;
                        layoutBackgroundDownFirst.setBackground(res.getDrawable(R.drawable.background_prologue_down_first_scene));
                        progressBarPrologueDown.setProgress(25000);
                        progressBarPrologueDown.setVisibility(View.GONE);
                        countPrologueDown.setVisibility(View.VISIBLE);
                        countPrologueDown.setText(R.string.prologue_game_over_down_level_up);
                        textPrologueDownStart.setText(R.string.prologue_game_over_down_level_up_text);
                        textPrologueDownStart.setVisibility(View.VISIBLE);
                        firstButton.setVisibility(View.GONE);
                        secondButton.setVisibility(View.GONE);
                        thirdButton.setVisibility(View.GONE);
                        prologueDownStartGameButton.setVisibility(View.VISIBLE);
                        symbolPrologueDown.setVisibility(View.GONE);
                        isFirstStart = true;
                    }
                } else {
                    firstButton.startAnimation(trueAnimation);
                    new CountDownTimer(300, 300) {
                        public void onTick(long millisUntilFinished) {
                        }
                        public void onFinish() {
                            if (isTimer) {
                                timer.cancel();
                            }
                            timer = new CountDownTimer(timerTime + timerUp, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    if (timerUp > 2000) {
                                        timerUp -= 100;
                                    }
                                    timerTime = millisUntilFinished;
                                    countPrologueDown.setText(String.valueOf(millisUntilFinished / 1000));
                                    progressBarPrologueDown.setProgress((int) millisUntilFinished);

                                }

                                @Override
                                public void onFinish() {
                                    ost.pause();
                                    firstButton.clearAnimation();
                                    secondButton.clearAnimation();
                                    thirdButton.clearAnimation();
                                    countPrologueDown.setVisibility(View.VISIBLE);
                                    progressBarPrologueDown.setVisibility(View.GONE);
                                    layoutBackgroundDownFirst.setBackground(res.getDrawable(R.drawable.background_prologue_down_first_scene));
                                    countPrologueDown.setText(R.string.prologue_game_over_down);
                                    textPrologueDownStart.setText(R.string.prologue_game_over_down_text);
                                    textPrologueDownStart.setVisibility(View.VISIBLE);
                                    firstButton.setVisibility(View.GONE);
                                    secondButton.setVisibility(View.GONE);
                                    thirdButton.setVisibility(View.GONE);
                                    symbolPrologueDown.setVisibility(View.GONE);
                                    prologueDownStartGameButton.setVisibility(View.GONE);
                                    progressBarPrologueDown.setVisibility(View.GONE);
                                    secondRadioGroupPrologueDown.setVisibility(View.VISIBLE);
                                    prologueDownStartLuckRadioButton.setVisibility(View.VISIBLE);
                                    prologueDownStartNoLuckRadioButton.setVisibility(View.VISIBLE);
                                    isFinish = true;
                                }
                            }.start();
                            isTimer = true;
                            if (!isFinish) {
                                onStartDownPrologue(miniGame);

                            }
                        }
                    }.start();
                }
            }
        });
        secondRandom = (int) (Math.random() * 9);
        while (secondRandom == firstRandom) {
            secondRandom = (int) (Math.random() * 9);
        }


        switch (secondRandom) {
            case 0:
                secondButton = (ImageButton) findViewById(R.id.firstButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 1:
                secondButton = (ImageButton) findViewById(R.id.secondButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                secondButton = (ImageButton) findViewById(R.id.thirdButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 3:
                secondButton = (ImageButton) findViewById(R.id.fourthButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 4:
                secondButton = (ImageButton) findViewById(R.id.fifthButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 5:
                secondButton = (ImageButton) findViewById(R.id.sixthButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 6:
                secondButton = (ImageButton) findViewById(R.id.seventhButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            case 7:
                secondButton = (ImageButton) findViewById(R.id.eighthButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
            default:
                secondButton = (ImageButton) findViewById(R.id.ninthButtonPlolDownID);
                secondButton.setVisibility(View.VISIBLE);
                break;
        }

        if (textCheckFirst == 0) {
            secondButton.setImageResource(R.drawable.button2);
            textCheckSecond = 0;
        } else if (textCheckFirst == 1) {
            secondButton.setImageResource(R.drawable.button3);
            textCheckSecond = 1;
        } else {
            textCheckThird = 2;
            secondButton.setImageResource(R.drawable.button1);
        }


        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimer) {
                    timer.cancel();
                }
                try{
                secondButton.startAnimation(falseAnimation);}
                catch (Exception e ){
                    secondButton.setVisibility(View.GONE);
                }
                new CountDownTimer(300, 300) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {


                        timer = new CountDownTimer(timerTime - timerDown, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                timerDown += 100;
                                timerTime = millisUntilFinished;
                                countPrologueDown.setText(String.valueOf(millisUntilFinished / 1000));
                                progressBarPrologueDown.setProgress((int) millisUntilFinished);

                            }

                            @Override
                            public void onFinish() {
                                ost.pause();
                                firstButton.clearAnimation();
                                secondButton.clearAnimation();
                                thirdButton.clearAnimation();
                                layoutBackgroundDownFirst.setBackground(res.getDrawable(R.drawable.background_prologue_down_first_scene));
                                countPrologueDown.setVisibility(View.VISIBLE);
                                progressBarPrologueDown.setVisibility(View.GONE);
                                countPrologueDown.setText(R.string.prologue_game_over_down);
                                textPrologueDownStart.setText(R.string.prologue_game_over_down_text);
                                textPrologueDownStart.setVisibility(View.VISIBLE);
                                firstButton.setVisibility(View.GONE);
                                secondButton.setVisibility(View.GONE);
                                thirdButton.setVisibility(View.GONE);
                                symbolPrologueDown.setVisibility(View.GONE);
                                prologueDownStartGameButton.setVisibility(View.GONE);
                                progressBarPrologueDown.setVisibility(View.GONE);
                                secondRadioGroupPrologueDown.setVisibility(View.VISIBLE);
                                prologueDownStartLuckRadioButton.setVisibility(View.VISIBLE);
                                prologueDownStartNoLuckRadioButton.setVisibility(View.VISIBLE);
                            }
                        }.start();
                        isTimer = true;
                        if (!isFinish) {
                            onStartDownPrologue(miniGame);
                        }
                    }
                }.start();

            }
        });

        thirdRandom = (int) (Math.random() * 9);
        while (thirdRandom == firstRandom || thirdRandom == secondRandom) {
            thirdRandom = (int) (Math.random() * 9);
        }

        switch (thirdRandom) {
            case 0:
                thirdButton = (ImageButton) findViewById(R.id.firstButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 1:
                thirdButton = (ImageButton) findViewById(R.id.secondButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                thirdButton = (ImageButton) findViewById(R.id.thirdButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 3:
                thirdButton = (ImageButton) findViewById(R.id.fourthButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 4:
                thirdButton = (ImageButton) findViewById(R.id.fifthButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 5:
                thirdButton = (ImageButton) findViewById(R.id.sixthButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 6:
                thirdButton = (ImageButton) findViewById(R.id.seventhButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            case 7:
                thirdButton = (ImageButton) findViewById(R.id.eighthButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
            default:
                thirdButton = (ImageButton) findViewById(R.id.ninthButtonPlolDownID);
                thirdButton.setVisibility(View.VISIBLE);
                break;
        }

        if ((textCheckFirst == 0 || textCheckFirst == 1)
                && (textCheckSecond == 0 || textCheckSecond == 2)) {
            thirdButton.setImageResource(R.drawable.button3);
        } else if ((textCheckFirst == 1 || textCheckFirst == 2)
                && (textCheckSecond == 0 || textCheckSecond == 1)) {
            thirdButton.setImageResource(R.drawable.button1);
        } else {
            thirdButton.setImageResource(R.drawable.button2);
        }

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimer) {
                    timer.cancel();
                }

                thirdButton.startAnimation(falseAnimation);
                new CountDownTimer(300, 300) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        timer = new CountDownTimer(timerTime - timerDown, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                timerDown += 100;
                                timerTime = millisUntilFinished;
                                countPrologueDown.setText(String.valueOf(millisUntilFinished / 1000));
                                progressBarPrologueDown.setProgress((int) millisUntilFinished);
                            }

                            @Override
                            public void onFinish() {
                                ost.pause();
                                firstButton.clearAnimation();
                                secondButton.clearAnimation();
                                thirdButton.clearAnimation();
                                layoutBackgroundDownFirst.setBackground(res.getDrawable(R.drawable.background_prologue_down_first_scene));
                                countPrologueDown.setVisibility(View.VISIBLE);
                                progressBarPrologueDown.setVisibility(View.GONE);
                                countPrologueDown.setText(R.string.prologue_game_over_down);
                                textPrologueDownStart.setText(R.string.prologue_game_over_down_text);
                                textPrologueDownStart.setVisibility(View.VISIBLE);
                                firstButton.setVisibility(View.GONE);
                                secondButton.setVisibility(View.GONE);
                                thirdButton.setVisibility(View.GONE);
                                symbolPrologueDown.setVisibility(View.GONE);
                                prologueDownStartGameButton.setVisibility(View.GONE);
                                progressBarPrologueDown.setVisibility(View.GONE);
                                secondRadioGroupPrologueDown.setVisibility(View.VISIBLE);
                                prologueDownStartLuckRadioButton.setVisibility(View.VISIBLE);
                                prologueDownStartNoLuckRadioButton.setVisibility(View.VISIBLE);
                            }
                        }.start();
                        isTimer = true;
                        if (!isFinish) {
                            onStartDownPrologue(miniGame);
                        }
                    }
                }.start();
            }
        });
        if (isLevel) {
            firstButton.startAnimation(buttonRotate);
            secondButton.startAnimation(buttonRotate);
            thirdButton.startAnimation(buttonRotate);
        } else {
            thirdButton.setVisibility(View.GONE);
        }
    }

    public void gameVictory() {
        ost.stop();
        finishOst();
        firstButton.clearAnimation();
        secondButton.clearAnimation();
        thirdButton.clearAnimation();
        progressBarPrologueDown.setVisibility(View.GONE);
        firstButton.setVisibility(View.GONE);
        secondButton.setVisibility(View.GONE);
        thirdButton.setVisibility(View.GONE);
        prologueDownStartGameButton.setVisibility(View.GONE);
        isGameVictory = true;
        symbolPrologueDown.setVisibility(View.GONE);
        Intent intent = new Intent(PrologueDownFirstScene.this, PrologueDownSecondSceneBackPack.class);
        getNextScene(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }

    public void onPrologueDownStartGame(View view) {
        if (isRadioButtonGame) {
            prologueDownStartGameRadioButton.setVisibility(View.GONE);
            prologueDownStartExitRadioButton.setVisibility(View.GONE);
            radioGroupPrologueDown.setVisibility(View.GONE);
            prologueDownStartGameButton.setVisibility(View.VISIBLE);
            prologueDownStartGameButton.setClickable(true);
            if (isSleepingBag) {
                textPrologueDownStart.setText(R.string.prologue_down_start_game_sleeping_bag);
            } else {
                textPrologueDownStart.setText(R.string.prologue_down_start_game_no_sleeping_bag);
            }

        }
        prologueDownStartGameRadioButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        prologueDownStartExitRadioButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isRadioButtonGame = true;
        isRadioButtonExit = false;
    }

    public void onPrologueDownExit(View view) {
        if (isRadioButtonExit) {
            finishOst();
            Intent intent = new Intent(PrologueDownFirstScene.this, PrologueDownSecondSceneNoBackPack.class);
            getNextScene(intent);
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);

        }
        prologueDownStartGameRadioButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        prologueDownStartExitRadioButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isRadioButtonGame = false;
        isRadioButtonExit = true;
    }

    public void onPrologueDownLuck(View view) {
        if (isRadioButtonLuck) {
            Random random = new Random();
            int number = random.nextInt(85);
            if (number > fortune) {
                textPrologueDownStart.setText(R.string.prologue_game_over_down_luck_fail);
                if (fortune <= 85) {
                    fortune += 15;
                }
                finishOst();
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(APP_SAVE_BACKPACK, false);
                editor.putInt(APP_SAVE_FORTUNE, fortune);
                editor.apply();
                imageBackgroundLuckFalse.setVisibility(View.VISIBLE);
                imageBackgroundLuckFalse.startAnimation(luckAnimation);
                Intent intent = new Intent(PrologueDownFirstScene.this, PrologueDownSecondSceneNoBackPack.class);
                getNextScene(intent);
                finish();
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            } else {
                textPrologueDownStart.setText(R.string.prologue_game_over_down_luck_luck);
                if (fortune >= 15) {
                    fortune -= 15;
                }
                imageBackgroundLuckTrue.setVisibility(View.VISIBLE);
                imageBackgroundLuckTrue.startAnimation(luckAnimation);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(APP_SAVE_BACKPACK, true);
                editor.putInt(APP_SAVE_FORTUNE, fortune);
                editor.apply();
                gameVictory();
            }
        }
        prologueDownStartLuckRadioButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        prologueDownStartNoLuckRadioButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isRadioButtonLuck = true;
        isRadioButtonNoLuck = false;
    }

    public void onPrologueDownNoLuck(View view) {
        if (isRadioButtonNoLuck) {
            finishOst();
            Intent intent = new Intent(PrologueDownFirstScene.this, PrologueDownSecondSceneNoBackPack.class);
            getNextScene(intent);
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
        prologueDownStartLuckRadioButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        prologueDownStartNoLuckRadioButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isRadioButtonLuck = false;
        isRadioButtonNoLuck = true;
    }

    public void onTwo(View view) {
        finishOst();
        Intent intent = new Intent(PrologueDownFirstScene.this, PrologueDownSecondSceneBackPack.class);
        getNextScene(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ost = MediaPlayer.create(this, R.raw.ost_action_prologue);
    }

    public void onPrologueStartTrainingBackpack(View view) {
        if (isTrainingButton) {
            if(checkBoxPrologueTrainingBackPack.isChecked()) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_TRAINING, true);
                editor.apply();
            }
            firstButton.setClickable(true);
            secondButton.setClickable(true);
            thirdButton.setClickable(true);
            layoutPrologueTrainingBackPack.setVisibility(View.GONE);
        } else {
            isTrainingButton = true;
            radioButtonTrainingBackPack.setBackgroundColor(Color.parseColor("#607e9e7f"));
        }

    }
}
