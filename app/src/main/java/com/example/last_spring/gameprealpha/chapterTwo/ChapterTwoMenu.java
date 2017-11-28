package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ChapterTwoMenu extends GameActivityTwo {

    public static final String APP_SAVE_CHAPTER_TWO_RESPECT = "Respect Alin";

    private ProgressBar progressBarMenuLuck;
    private CircularProgressBar progressBarChapterTwoRespectAlin;

    private TextView textMenuDescription;

    private TextView textChapterTwoDate;
    private TextView textChapterTwoProgressRespectAlin;

    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_menu);

        isMenuExit = true;

        progressBarMenuLuck = (ProgressBar) findViewById(R.id.progressBarChapterTwoLuckID);
        progressBarChapterTwoRespectAlin = (CircularProgressBar) findViewById(R.id.progressBarChapterTwoRespectAlinID);

        textChapterTwoDate = (TextView) findViewById(R.id.textChapterTwoDateID);
      textChapterTwoProgressRespectAlin = (TextView) findViewById(R.id.textChapterTwoProgressRespectAlinID);

       textMenuDescription = (TextView) findViewById(R.id.textMenuDescriptionID);
        sText(textMenuDescription);

        if (save.getBoolean(APP_SAVE_CHAPTER_TWO_RESPECT, false)) {
            textChapterTwoProgressRespectAlin.setVisibility(View.VISIBLE);
        }

        fortune = getIntent().getIntExtra("fortune", fortune);
        respectAlin = getIntent().getIntExtra("respectAlin", respectAlin);
        date = getIntent().getIntExtra("date", date);

        hour = date / 60;
        minute = date - (hour * 60);

        if (date == 0) {

            textChapterTwoDate.setText(R.string.chapter_two_message_data_cut_scene);

        } else {

            if (minute == 0) {
                textChapterTwoDate.setText(hour + ":" + "00" + " " + getString(R.string.chapter_two_text_time_data));

            } else if (minute < 10) {

                textChapterTwoDate.setText(hour + ":0" + minute + " " + getString(R.string.chapter_two_text_time_data));
            } else {

                textChapterTwoDate.setText(hour + ":" + minute + " " + getString(R.string.chapter_two_text_time_data));
            }
        }

        progressBarMenuLuck.setProgress(fortune);
        progressBarChapterTwoRespectAlin.setProgress(100 - respectAlin);

            if (100 - respectAlin > 66) {
                progressBarChapterTwoRespectAlin.setBackgroundColor(Color.parseColor("#6e9ba1"));
            } else if (100 - respectAlin> 33) {
                progressBarChapterTwoRespectAlin.setBackgroundColor(Color.parseColor("#8eb5bc"));
            } else {
                progressBarChapterTwoRespectAlin.setBackgroundColor(Color.parseColor("#a3c8ce"));
            }


    }

    private void showButtonMainAnimation(final View view) {
        view.setClickable(false);

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_main_animation));
        new CountDownTimer(300, 300) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                view.setClickable(true);
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    public void onMenuExit(View view) {
        Intent intent = new Intent(ChapterTwoMenu.this, ChapterTwoMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();
    }


    public void onChapterTwoDate(View view) {
        showButtonMainAnimation(view);
        textMenuDescription.setText(R.string.chapter_two_menu_text_date);
    }

    public void onChapterTwoLuck(View view) {
        showButtonMainAnimation(view);
        textMenuDescription.setText(R.string.chapter_two_menu_text_luck);
    }

    public void onChapterTwoRespectAlin(View view) {
        showButtonMainAnimation(view);

        if (save.getBoolean(APP_SAVE_CHAPTER_TWO_RESPECT, false)) {
            if (respectAlin < 34) {
          textMenuDescription.setText(getString(R.string.chapter_two_menu_text_respect_true) + " " + getString(R.string.chapter_two_menu_text_respect_fail));
            } else if (respectAlin < 67) {
            textMenuDescription.setText(getString(R.string.chapter_two_menu_text_respect_true) + " " + getString(R.string.chapter_two_menu_text_respect_normal));
            } else {
             textMenuDescription.setText(getString(R.string.chapter_two_menu_text_respect_true) + " " + getString(R.string.chapter_two_menu_text_respect_good));
            }
        } else {
          textMenuDescription.setText(R.string.chapter_two_menu_text_respect_false);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }
}
