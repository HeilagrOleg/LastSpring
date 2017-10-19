package com.example.last_spring.gameprealpha.prologue;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueBox extends GameActivity {

    private ImageButton imageButtonBoxFirst;
    private ImageButton imageButtonBoxSecond;
    private ImageButton imageButtonBoxThird;
    private ImageButton imageButtonBoxFour;

    private RadioButton buttonPrologueBoxFirst;
    private RadioButton buttonPrologueBoxSecond;
    private RadioButton buttonPrologueBoxThird;

    private RadioGroup radioGroupPrologueBox;

    private RelativeLayout layoutGamePrologueBoxThird;

    private ScrollView scrollPrologueBox;

    private TextView textPrologueBox;

    private Animation outAnimation;

    private float firstCounterGr;
    private float secondCounterGr;
    private float thirdCounterGr;
    private float fourCounterGr;

    private int firstCounter;
    private int secondCounter;
    private int thirdCounter;
    private int fourCounter;

    private boolean isFirst;
    private boolean isSecond;
    private boolean isThird;

    private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_box);
        res = getResources();

        getSave(1.121f);

        startService(new Intent(this, OstDisturbance.class));

        imageButtonBoxFirst = (ImageButton) findViewById(R.id.imageButtonBoxFirstID);
        imageButtonBoxSecond = (ImageButton) findViewById(R.id.imageButtonBoxSecondID);
        imageButtonBoxThird = (ImageButton) findViewById(R.id.imageButtonBoxThirdID);
        imageButtonBoxFour = (ImageButton) findViewById(R.id.imageButtonBoxFourID);

        layoutGamePrologueBoxThird = (RelativeLayout) findViewById(R.id.layoutGamePrologueBoxThirdID);

        textPrologueBox = (TextView) findViewById(R.id.textPrologueBoxID);
        sText(textPrologueBox);

        radioGroupPrologueBox = (RadioGroup) findViewById(R.id.radioGroupPrologueBoxID);
        scrollPrologueBox = (ScrollView) findViewById(R.id.scrollPrologueBoxID);
        sScroll(scrollPrologueBox);

        outAnimation = AnimationUtils.loadAnimation(this, R.anim.title_out);

        buttonPrologueBoxFirst = (RadioButton) findViewById(R.id.buttonPrologueBoxFirstID);
        buttonPrologueBoxFirst.setTextSize(sizeFonts);
        buttonPrologueBoxSecond = (RadioButton) findViewById(R.id.buttonPrologueBoxSecondID);
        buttonPrologueBoxSecond.setTextSize(sizeFonts);
        buttonPrologueBoxThird = (RadioButton) findViewById(R.id.buttonPrologueBoxThirdID);
        buttonPrologueBoxThird.setTextSize(sizeFonts);
        firstCounterGr = 0f;
        firstCounter = 0;
        secondCounterGr = 0f;
        secondCounter = 0;
        thirdCounterGr = 0f;
        thirdCounter = 0;
        fourCounterGr = 0f;
        fourCounter = 0;

        startAnimation(new ArrayList<View>(Arrays.asList(scrollPrologueBox, radioGroupPrologueBox)));

        getInterface(false);
        textMessage.setText(R.string.prologue_hunting_lodge_box_message);

    }

    public void onButtonBoxFirst(View view) {
        ObjectAnimator.ofFloat(imageButtonBoxFirst, View.ROTATION, firstCounterGr, firstCounterGr + 90).start();
        if (firstCounterGr == 360) {
            firstCounterGr = 90;
        } else {
            firstCounterGr += 90;
        }
        if (firstCounter == 3) {
            firstCounter = 0;
        } else {
            firstCounter++;
        }
        getAllImage();
    }

    public void onButtonBoxSecond(View view) {
        ObjectAnimator.ofFloat(imageButtonBoxSecond, View.ROTATION, secondCounterGr, secondCounterGr + 90).start();
        if (secondCounterGr == 360) {
            secondCounterGr = 90;
        } else {
            secondCounterGr += 90;
        }

        if (secondCounter == 3) {
            secondCounter = 0;
        } else {
            secondCounter++;
        }

        getAllImage();
    }

    public void onButtonBoxThird(View view) {
        ObjectAnimator.ofFloat(imageButtonBoxThird, View.ROTATION, thirdCounterGr, thirdCounterGr + 90).start();
        if (thirdCounterGr == 360) {
            thirdCounterGr = 90;
        } else {
            thirdCounterGr += 90;
        }

        if (thirdCounter == 3) {
            thirdCounter = 0;
        } else {
            thirdCounter++;
        }


        getAllImage();
    }

    public void onButtonBoxFour(View view) {
        ObjectAnimator.ofFloat(imageButtonBoxFour, View.ROTATION, fourCounterGr, fourCounterGr + 90).start();
        if (fourCounterGr == 360) {
            fourCounterGr = 90;
        } else {
            fourCounterGr += 90;
        }

        if (fourCounter == 3) {
            fourCounter = 0;
        } else {
            fourCounter++;
        }

        getAllImage();
    }

    private void getAllImage() {
        if (firstCounter == 1 && secondCounter == 2 && thirdCounter == 3 && fourCounter == 3) {
            imageButtonBoxFirst.setImageDrawable(res.getDrawable(R.drawable.hunting_first_two));
            imageButtonBoxFirst.setClickable(false);
            imageButtonBoxSecond.setImageDrawable(res.getDrawable(R.drawable.hunting_second_two));
            imageButtonBoxSecond.setClickable(false);
            imageButtonBoxThird.setImageDrawable(res.getDrawable(R.drawable.hunting_third_two));
            imageButtonBoxThird.setClickable(false);
            imageButtonBoxFour.setImageDrawable(res.getDrawable(R.drawable.hunting_four_two));
            imageButtonBoxFour.setClickable(false);

            new CountDownTimer(1600, 1500) {
                public void onTick(long millisUntilFinished) {
                    layoutGamePrologueBoxThird.setBackground(null);
                    ObjectAnimator animator = ObjectAnimator.ofFloat(layoutGamePrologueBoxThird, View.ALPHA, 1, 0);
                    animator.setDuration(1500);
                    animator.start();
                }

                public void onFinish() {
                    startAnimation(new ArrayList<View>(Arrays.asList(radioGroupPrologueBox, scrollPrologueBox)));
                    buttonPrologueBoxFirst.setVisibility(View.GONE);
                    showMessage(textMessage, false);
                    textPrologueBox.setText(R.string.prologue_hunting_lodge_box_text_final);
                }
            }.start();
        }
    }

    public void onPrologueBoxFirst(View view) {
        if (isFirst) {
            radioGroupPrologueBox.startAnimation(outAnimation);
            scrollPrologueBox.startAnimation(outAnimation);
           ;

            new CountDownTimer(2000, 2000) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    radioGroupPrologueBox.setVisibility(View.GONE);
                    scrollPrologueBox.setVisibility(View.GONE);
                    layoutGamePrologueBoxThird.setVisibility(View.VISIBLE);
                    ObjectAnimator.ofFloat(layoutGamePrologueBoxThird, View.ALPHA, 0,1).start();
            }
            }.start();



            isFirst = false;
            buttonPrologueBoxFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueBoxFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueBoxSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;

        }
    }

    public void onPrologueBoxSecond(View view) {
        if (isFirst) {
            getNextScene(new Intent(this, PrologueHuntingLodgeCutScene.class));
            finish();
        } else {
            buttonPrologueBoxFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueBoxSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = true;
            isSecond = false;
        }
    }
}
