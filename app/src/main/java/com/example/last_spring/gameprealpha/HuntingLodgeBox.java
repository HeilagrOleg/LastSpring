package com.example.last_spring.gameprealpha;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.last_spring.gameprealpha.res.GameActivity;

public class HuntingLodgeBox extends GameActivity {

    private ImageView imageHuntingMain;
    private ImageButton imageHuntingFirst;
    private ImageButton imageHuntingSecond;
    private ImageButton imageHuntingThird;
    private ImageButton imageHuntingFour;
    private ImageView imageHuntingEnd;

    private boolean isFirstButton;
    private boolean isSecondButton;
    private boolean isThirdButton;
    private boolean isFourButton;

    private int firstButton;
    private int secondButton;
    private int thirdButton;
    private int fourButton;

    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_box);

        imageHuntingMain = (ImageView) findViewById(R.id.imageHuntingMainID);
        imageHuntingFirst = (ImageButton) findViewById(R.id.imageHuntingFirstID);
        imageHuntingSecond = (ImageButton) findViewById(R.id.imageHuntingSecondID);
        imageHuntingThird = (ImageButton) findViewById(R.id.imageHuntingThirdID);
        imageHuntingFour = (ImageButton) findViewById(R.id.imageHuntingFourID);
        imageHuntingEnd = (ImageView) findViewById(R.id.imageHuntingEndID);

        Matrix matrix = new Matrix();
        matrix.postRotate(90);

        Bitmap firstBitmap = ((BitmapDrawable)imageHuntingFirst.getDrawable()).getBitmap();

        firstButton = 3;
        secondButton = 1;
        thirdButton = 2;
        fourButton = 3;

        animation = AnimationUtils.loadAnimation(this, R.anim.hunting_button_animation);
    }

    public void onHuntingFirst(View view) {
        if (!isFirstButton) {
            isFirstButton = true;
            imageHuntingFirst.startAnimation(animation);

            new CountDownTimer(1000, 1000) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    isFirstButton = false;
                    if (firstButton == 3) {
                        firstButton = 0;
                    } else {
                        firstButton++;
                    }
                }
            }.start();
        }
    }
}
