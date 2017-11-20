package com.example.last_spring.gameprealpha.chapterTwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;

public class ChapterTwoCabinet extends GameActivityTwo {

    private ImageButton imageButtonTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_cabinet);

        imageButtonTest = (ImageButton) findViewById(R.id.imageButtonTestID);

        Animation animationTest = AnimationUtils.loadAnimation(this, R.anim.button_traffic_jam_size_animation);

        imageButtonTest.startAnimation(animationTest);
    }
}
