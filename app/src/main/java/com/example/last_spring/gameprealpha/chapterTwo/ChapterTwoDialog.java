package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.last_spring.gameprealpha.OstSnowy;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoDialog extends GameActivityTwo {

    public static final String APP_SAVE_CHAPTER_TWO_RESPECT = "Respect Alin";

    public static final String APP_SAVE_CHAPTER_TWO_FAIL_LATE = "VERY LATE";

    public static final String APP_SAVE_CHAPTER_TWO_LATE = "Late";


    private RadioButton buttonChapterTwoFive;
    private RadioButton buttonChapterTwoSix;

    private boolean isHand;
    private boolean isResearch;
    private boolean isCongratulate;
    private boolean isResearchSecond;
    private boolean isFather;
    private boolean isQuestions;
    private boolean isFive;
    private boolean isSix;
    private boolean isVeryLate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_dialog);

        editor.putBoolean(APP_SAVE_CHAPTER_TWO_RESPECT, true);
        editor.apply();

        isOstShowy = true;

        startService(new Intent(this, OstSnowy.class));

        respectAlin = 40;

        getSave(13f);

        getButtons();

        getInterfaceChapterTwo();

        isHand = true;

        date = 802;

        buttonChapterTwoFive = (RadioButton) findViewById(R.id.buttonChapterTwoFiveID);
        buttonChapterTwoFive.setTextSize(sizeFonts);
        buttonChapterTwoSix = (RadioButton) findViewById(R.id.buttonChapterTwoSixID);
        buttonChapterTwoSix.setTextSize(sizeFonts);

        isVeryLate = save.getBoolean(APP_SAVE_CHAPTER_TWO_FAIL_LATE, false);

        if (isVeryLate) {
            textChapterTwo.setText(R.string.chapter_two_dialog_very_late_start);
            respectAlin = 20;
        } else if (save.getBoolean(APP_SAVE_CHAPTER_TWO_LATE, false)) {
            textChapterTwo.setText(R.string.chapter_two_dialog_late_start);
            respectAlin = 30;
        }

        startAnimation(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));


    }

    public void onChapterTwoFirst(View view) {
        if (isFirst) {

            if (isHand) {
                if (isVeryLate) {
                    textChapterTwo.setText(R.string.chapter_two_dialog_very_late_text_hand);
                } else if (save.getBoolean(APP_SAVE_CHAPTER_TWO_LATE, false)) {
                    textChapterTwo.setText(R.string.chapter_two_dialog_late_text_hand);
                } else

                {
                    textChapterTwo.setText(R.string.chapter_two_dialog_text_hand);
                }
                buttonChapterTwoFirst.setText(R.string.chapter_two_dialog_button_congratulate);
                buttonChapterTwoSecond.setText(R.string.chapter_two_dialog_button_research);
                isHand = false;
                isResearch = true;
                getRespectUp();
            } else if (isResearch) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_congratulate);
                buttonChapterTwoFirst.setText(R.string.chapter_two_dialog_button_congratulate_archeology);
                buttonChapterTwoSecond.setText(R.string.chapter_two_dialog_button_congratulate_victor);
                isResearch = false;
                isCongratulate = true;
                getRespectUp();
            } else if (isCongratulate) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_congratulate_archeology);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isFather = true;
                isCongratulate = false;
                getRespectDown();
            } else if (isResearchSecond) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_research_know);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isFather = true;
                isResearchSecond = false;
                getRespectDown();
            } else if (isQuestions) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_party);
                buttonChapterTwoFirst.setVisibility(View.GONE);
            }
            date += Math.random() * 5;
            getChoiceButton();
        } else {
            isFive = false;
            isSix = false;
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorButton));
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorButton));
            getChoiceButton(buttonChapterTwoFirst);
            isFirst = true;
        }
    }

    public void onChapterTwoSecond(View view) {
        if (isSecond) {
            if (isHand) {
                if (isVeryLate) {
                    textChapterTwo.setText(R.string.chapter_two_dialog_very_late_text_no_hand);
                } else if (save.getBoolean(APP_SAVE_CHAPTER_TWO_LATE, false)) {
                    textChapterTwo.setText(R.string.chapter_two_dialog_late_text_no_hand);
                } else {
                    textChapterTwo.setText(R.string.chapter_two_dialog_text_no_hand);
                }
                buttonChapterTwoFirst.setText(R.string.chapter_two_dialog_button_congratulate);
                buttonChapterTwoSecond.setText(R.string.chapter_two_dialog_button_research);
                isHand = false;
                isResearch = true;
                getRespectDown();
            } else if (isResearch) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_research);
                buttonChapterTwoFirst.setText(R.string.chapter_two_dialog_button_research_know);
                buttonChapterTwoSecond.setText(R.string.chapter_two_dialog_button_research_sorry);
                isResearchSecond = true;
                isResearch = false;
                getRespectDown();
            } else if (isCongratulate) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_congratulate_victor);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isFather = true;
                isCongratulate = false;
                getRespectUp();
            } else if (isResearchSecond) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_research_sorry);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                isFather = true;
                isResearchSecond = false;
                getRespectUp();
            } else if (isQuestions) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_cave);
                buttonChapterTwoSecond.setVisibility(View.GONE);
            }
            date += Math.random() * 5;
            getChoiceButton();
        } else {
            isFive = false;
            isSix = false;
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorButton));
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorButton));
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }


    public void onChapterTwoThird(View view) {
        if (isThird) {
            if (isFather) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_father);
                getRespectDown();
                buttonChapterTwoFirst.setVisibility(View.VISIBLE);
                buttonChapterTwoFirst.setText(R.string.chapter_two_dialog_button_party);
                buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                buttonChapterTwoSecond.setText(R.string.chapter_two_dialog_button_cave);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoThird.setText(R.string.chapter_two_dialog_button_camp);
                buttonChapterTwoFive.setVisibility(View.VISIBLE);
                buttonChapterTwoFive.setText(R.string.chapter_two_dialog_button_valley);
                buttonChapterTwoSix.setVisibility(View.VISIBLE);
                buttonChapterTwoSix.setText(R.string.chapter_two_dialog_button_theory);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setText(R.string.chapter_two_dialog_button_exit);
                isQuestions = true;
                isFather = false;
            } else if (isQuestions) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_camp);
                buttonChapterTwoThird.setVisibility(View.GONE);
            }
            date += Math.random() * 5;
            getChoiceButton();
        } else {
            isFive = false;
            isSix = false;
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorButton));
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorButton));
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }

    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            if (isFather) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_ok);
                buttonChapterTwoFirst.setVisibility(View.VISIBLE);
                buttonChapterTwoFirst.setText(R.string.chapter_two_dialog_button_party);
                buttonChapterTwoSecond.setVisibility(View.VISIBLE);
                buttonChapterTwoSecond.setText(R.string.chapter_two_dialog_button_cave);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                buttonChapterTwoThird.setText(R.string.chapter_two_dialog_button_camp);
                buttonChapterTwoFive.setVisibility(View.VISIBLE);
                buttonChapterTwoFive.setText(R.string.chapter_two_dialog_button_valley);
                buttonChapterTwoSix.setVisibility(View.VISIBLE);
                buttonChapterTwoSix.setText(R.string.chapter_two_dialog_button_theory);
                buttonChapterTwoFour.setVisibility(View.VISIBLE);
                buttonChapterTwoFour.setText(R.string.chapter_two_dialog_button_exit);
                isQuestions = true;
                isFather = false;
            } else if (isQuestions) {
                getNextScene(ChapterTwoCabinetBox.class);
                editor.putInt(APP_SAVE_CHAPTER_TWO_RESPECT_ALIN, respectAlin);
                editor.apply();
                finish();
            }
            date += Math.random() * 5;
            getChoiceButton();
        } else {
            isFive = false;
            isSix = false;
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorButton));
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorButton));
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }

    }

    public void onChapterTwoFive(View view) {
        if (isFive) {
            if (isQuestions) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_valley);
                getRespectDown();
                buttonChapterTwoFive.setVisibility(View.GONE);
            }
            date += Math.random() * 5;
            isFive = false;
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorButton));
        } else {
            getChoiceButton();
            isSix = false;
            isFive = true;
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorChoice));
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorButton));
        }
    }


    public void onChapterTwoSix(View view) {
        if (isSix) {
            if (isQuestions) {
                textChapterTwo.setText(R.string.chapter_two_dialog_text_theory);
                getRespectUp();
                buttonChapterTwoSix.setVisibility(View.GONE);
            }
            date += Math.random() * 5;
            isSix = false;
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorButton));
        } else {
            getChoiceButton();
            isSix = true;
            isFive = false;
            buttonChapterTwoSix.setBackgroundColor(Color.parseColor(colorChoice));
            buttonChapterTwoFive.setBackgroundColor(Color.parseColor(colorButton));
        }
    }


}
