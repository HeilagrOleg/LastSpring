package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ChapterTwoMenu extends GameActivityTwo {

    private ProgressBar progressBarMenuLuck;
    private CircularProgressBar progressBarChapterTwoRespectAlin;

    private TextView textChapterTwoDate;

    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_menu);

        progressBarMenuLuck = (ProgressBar) findViewById(R.id.progressBarChapterTwoLuckID);
        progressBarChapterTwoRespectAlin = (CircularProgressBar) findViewById(R.id.progressBarChapterTwoRespectAlinID);

        textChapterTwoDate = (TextView) findViewById(R.id.textChapterTwoDateID);

        fortune = getIntent().getIntExtra("fortune", fortune);
        respectAlin = getIntent().getIntExtra("respectAlin", respectAlin);
        date = getIntent().getIntExtra("date", date);

        hour = date / 60;
        minute = date - (hour*60);

        textChapterTwoDate.setText(hour + ":" + minute + " " + getString(R.string.chapter_two_text_time_data));

        progressBarMenuLuck.setProgress(fortune);
        progressBarChapterTwoRespectAlin.setProgress(100-respectAlin);

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


}
