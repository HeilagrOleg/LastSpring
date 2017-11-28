package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstSnowy;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoCabinetBox extends GameActivityTwo {

    private boolean isStart;
    private boolean isNext;
    private boolean isGame;

    private float buttonGr1;
    private float buttonGr2;
    private float buttonGr3;
    private float buttonGr4;
    private float buttonGr5;
    private float buttonGr6;
    private float buttonGr7;
    private float buttonGr8;

    private int buttonCounter1;
    private int buttonCounter2;
    private int buttonCounter3;
    private int buttonCounter4;
    private int buttonCounter5;
    private int buttonCounter6;
    private int buttonCounter7;
    private int buttonCounter8;

    private ImageView imageChapterTwoGameFirst;
    private ImageView imageChapterTwoGameSecond;
    private ImageView imageChapterTwoGameThird;
    private ImageView imageChapterTwoGameFour;
    private ImageView imageChapterTwoGameFive;
    private ImageView imageChapterTwoGameSix;
    private ImageView imageChapterTwoGameSeven;
    private ImageView imageChapterTwoGameEight;

    private RelativeLayout layoutChapterTwoGame;

    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_cabinet_box);

        isOstShowy = true;

        startService(new Intent(this, OstSnowy.class));

        getSave(14f);

        getButtons();

        getInterfaceChapterTwo();

        isStart = true;

        date = 864;

        layoutChapterTwoGame = (RelativeLayout) findViewById(R.id.layoutChapterTwoGameID);

        startAnimationChapterTwo(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));

        res = getResources();

        buttonGr1 = 0f;
        buttonGr2 = 0f;
        buttonGr3 = 0f;
        buttonGr4 = 0f;
        buttonGr5 = 0f;
        buttonGr6 = 0f;
        buttonGr7 = 0f;
        buttonGr8 = 0f;

        buttonCounter1 = 0;
        buttonCounter2 = 0;
        buttonCounter3 = 0;
        buttonCounter4 = 0;
        buttonCounter5 = 0;
        buttonCounter6 = 0;
        buttonCounter7 = 0;
        buttonCounter8 = 0;

        imageChapterTwoGameFirst = (ImageView) findViewById(R.id.imageChapterTwoGameFirstID);
        imageChapterTwoGameSecond = (ImageView) findViewById(R.id.imageChapterTwoGameSecondID);
        imageChapterTwoGameThird = (ImageView) findViewById(R.id.imageChapterTwoGameThirdID);
        imageChapterTwoGameFour = (ImageView) findViewById(R.id.imageChapterTwoGameFourID);
        imageChapterTwoGameFive = (ImageView) findViewById(R.id.imageChapterTwoGameFiveID);
        imageChapterTwoGameSix = (ImageView) findViewById(R.id.imageChapterTwoGameSixID);
        imageChapterTwoGameSeven = (ImageView) findViewById(R.id.imageChapterTwoGameSevenID);
        imageChapterTwoGameEight = (ImageView) findViewById(R.id.imageChapterTwoGameEightID);

    }


    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_watch);
                buttonChapterTwoFirst.setVisibility(View.GONE);
            } else {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_alin_true);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                respectAlin += 8;
                getRespectUp();
            }
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFirst);
            isFirst = true;
        }
    }

    public void onChapterTwoSecond(View view) {
        if (isSecond) {
            if (isStart) {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_think);
                buttonChapterTwoSecond.setVisibility(View.GONE);
            } else {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_alin_false);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                respectAlin -= 8;
                getRespectDown();
            }
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_table);
            buttonChapterTwoThird.setVisibility(View.GONE);
            buttonChapterTwoFirst.setText(R.string.chapter_two_cabinet_box_button_alin_true);
            buttonChapterTwoFirst.setVisibility(View.VISIBLE);
            buttonChapterTwoSecond.setText(R.string.chapter_two_cabinet_box_button_alin_false);
            buttonChapterTwoSecond.setVisibility(View.VISIBLE);
            isStart = false;
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            if (isGame) {
                scrollChapterTwo.setVisibility(View.GONE);
                radioGroupChapterTwo.setVisibility(View.GONE);
                layoutChapterTwoGame.setVisibility(View.VISIBLE);
                imageButtonMenuChapterTwo.setVisibility(View.GONE);
            } else {
                textChapterTwo.setText(R.string.chapter_two_cabinet_box_text_box);
                buttonChapterTwoFour.setText(R.string.chapter_two_cabinet_box_button_game);
                isGame = true;
            }
            date += 1+ Math.random() * 5;
            getChoiceButton();
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }

    public void onChapterTwoGameFirst(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameFirst, View.ROTATION, buttonGr1, buttonGr1 + 90).start();
        if (buttonGr1 == 360) {
            buttonGr1 = 90;
        } else {
            buttonGr1 += 90;
        }
        if (buttonCounter1 == 3) {
            buttonCounter1 = 0;
        } else {
            buttonCounter1++;
        }

        getAllImage();
    }

    public void onChapterTwoGameSecond(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameSecond, View.ROTATION, buttonGr2, buttonGr2 + 90).start();
        if (buttonGr2 == 360) {
            buttonGr2 = 90;
        } else {
            buttonGr2 += 90;
        }
        if (buttonCounter2 == 3) {
            buttonCounter2 = 0;
        } else {
            buttonCounter2++;
        }

        getAllImage();
    }

    public void onChapterTwoGameThird(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameThird, View.ROTATION, buttonGr3, buttonGr3 + 90).start();
        if (buttonGr3 == 360) {
            buttonGr3 = 90;
        } else {
            buttonGr3 += 90;
        }
        if (buttonCounter3 == 3) {
            buttonCounter3 = 0;
        } else {
            buttonCounter3++;
        }

        getAllImage();
    }

    public void onChapterTwoGameFour(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameFour, View.ROTATION, buttonGr4, buttonGr4 + 90).start();
        if (buttonGr4 == 360) {
            buttonGr4 = 90;
        } else {
            buttonGr4 += 90;
        }
        if (buttonCounter4 == 3) {
            buttonCounter4 = 0;
        } else {
            buttonCounter4++;
        }

        getAllImage();
    }

    public void onChapterTwoGameFive(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameFive, View.ROTATION, buttonGr5, buttonGr5 + 90).start();
        if (buttonGr5 == 360) {
            buttonGr5 = 90;
        } else {
            buttonGr5 += 90;
        }
        if (buttonCounter5 == 3) {
            buttonCounter5 = 0;
        } else {
            buttonCounter5++;
        }

        getAllImage();
    }

    public void onChapterTwoGameSix(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameSix, View.ROTATION, buttonGr6, buttonGr6 + 90).start();
        if (buttonGr6 == 360) {
            buttonGr6 = 90;
        } else {
            buttonGr6 += 90;
        }
        if (buttonCounter6 == 3) {
            buttonCounter6 = 0;
        } else {
            buttonCounter6++;
        }

        getAllImage();
    }

    public void onChapterTwoGameSeven(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameSeven, View.ROTATION, buttonGr7, buttonGr7 + 90).start();
        if (buttonGr7 == 360) {
            buttonGr7 = 90;
        } else {
            buttonGr7 += 90;
        }
        if (buttonCounter7 == 3) {
            buttonCounter7 = 0;
        } else {
            buttonCounter7++;
        }

        getAllImage();
    }

    public void onChapterTwoGameEight(View view) {
        ObjectAnimator.ofFloat(imageChapterTwoGameEight, View.ROTATION, buttonGr8, buttonGr8 + 90).start();
        if (buttonGr8 == 360) {
            buttonGr8 = 90;
        } else {
            buttonGr8 += 90;
        }
        if (buttonCounter8 == 3) {
            buttonCounter8 = 0;
        } else {
            buttonCounter8++;
        }

        getAllImage();
    }

    private void getAllImage() {
        if (buttonCounter1 == 3 && buttonCounter2 == 3 && buttonCounter3 == 3 && buttonCounter4 == 1
                && buttonCounter5 == 2 && buttonCounter6 == 3 && buttonCounter7 == 1 && buttonCounter8 == 1
                ) {
            imageChapterTwoGameSecond.setImageDrawable(res.getDrawable(R.drawable.chapter_two_buttons_second_active));
            imageChapterTwoGameFour.setImageDrawable(res.getDrawable(R.drawable.chapter_two_buttons_four_active));
            imageChapterTwoGameFive.setImageDrawable(res.getDrawable(R.drawable.chapter_two_buttons_five_active));
            imageChapterTwoGameSix.setImageDrawable(res.getDrawable(R.drawable.chapter_two_buttons_six_active));
            imageChapterTwoGameSeven.setImageDrawable(res.getDrawable(R.drawable.chapter_two_buttons_seven_active));
            imageChapterTwoGameEight.setImageDrawable(res.getDrawable(R.drawable.chapter_two_buttons_eight_active));

            imageChapterTwoGameEight.setClickable(false);
            imageChapterTwoGameSeven.setClickable(false);
            imageChapterTwoGameSix.setClickable(false);
            imageChapterTwoGameFive.setClickable(false);
            imageChapterTwoGameFour.setClickable(false);
            imageChapterTwoGameThird.setClickable(false);
            imageChapterTwoGameSecond.setClickable(false);
            imageChapterTwoGameFirst.setClickable(false);

            new CountDownTimer(2000, 2000) {


                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    layoutChapterTwoGame.setBackground(null);
                    ObjectAnimator animator = ObjectAnimator.ofFloat(layoutChapterTwoGame, View.ALPHA, 1, 0);
                    animator.setDuration(1800);
                    animator.start();
                }
            }.start();


            new CountDownTimer(4000, 4000) {


                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    getNextScene(ChapterTwoCabinet.class);
                    finish();
                }
            }.start();
        }
    }
}
