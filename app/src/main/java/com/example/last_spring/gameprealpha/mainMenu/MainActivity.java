package com.example.last_spring.gameprealpha.mainMenu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;


import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoApartment;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoCabinet;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoCar;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoInstituteEntrance;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoStart;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoTrafficJam;
import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoTrafficJamTest;
import com.example.last_spring.gameprealpha.prologue.PrologueTitle;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.example.last_spring.gameprealpha.res.LevelsList;
import com.example.last_spring.gameprealpha.res.TypefaceUtil;

public class MainActivity extends AppCompatActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_START = "New game";
    private static final String APP_SAVE_LEVEL = "Level";
    private SharedPreferences settings;
    private ConstraintLayout constraintLayoutPrologueMain;
    private Button buttonSettingsMain;
    private boolean isNewGame;
    private View decorView;
    private CountDownTimer timer;
    private Button buttonStartMain;
    private Button buttonСontinueMain;
    private Button buttonExitMain;
    private MediaPlayer ostMain;

    Animation animationBirdFirst;
    Animation animationBirdSecond;

    private AnimationDrawable animationDrawable;
    private int timeAnimation;

    private ImageView imageBonfireMain;
    private ImageView imageBirdFirst;
    private ImageView imageBirdSecond;


    private boolean isOstStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        decorView = getWindow().getDecorView();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/proba.otf");
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        settings = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        isNewGame = settings.getBoolean(APP_SAVE_START, true);

        ostMain = MediaPlayer.create(this, R.raw.ost_main);
        ostMain.start();

        ostMain.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });


        imageBonfireMain = (ImageView) findViewById(R.id.imageBonfireMainID);

        buttonSettingsMain = (Button) findViewById(R.id.buttonSettingsMainID);


        //TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/circe.otf");
        buttonStartMain = (Button) findViewById(R.id.buttonStartMainID);
        buttonСontinueMain = (Button) findViewById(R.id.buttonСontinueMainID);
        buttonExitMain = (Button) findViewById(R.id.buttonExitMainID);
        checkForUpdates();

        BitmapDrawable bonfireFirst = (BitmapDrawable) getResources().getDrawable(R.drawable.bonfire_first);
        BitmapDrawable bonfireSecond = (BitmapDrawable) getResources().getDrawable(R.drawable.bonfire_second);
        BitmapDrawable bonfireThird = (BitmapDrawable) getResources().getDrawable(R.drawable.bonfire_third);
        BitmapDrawable bonfireFour = (BitmapDrawable) getResources().getDrawable(R.drawable.bonfire_four);
        BitmapDrawable bonfireFive = (BitmapDrawable) getResources().getDrawable(R.drawable.bonfire_five);
        BitmapDrawable bonfireSix = (BitmapDrawable) getResources().getDrawable(R.drawable.bonfire_six);

        animationDrawable = new AnimationDrawable();

        timeAnimation = 150;

        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(bonfireFirst, timeAnimation);
        animationDrawable.addFrame(bonfireSecond, timeAnimation);
        animationDrawable.addFrame(bonfireThird, timeAnimation);
        animationDrawable.addFrame(bonfireFour, timeAnimation);
        animationDrawable.addFrame(bonfireFive, timeAnimation);
        animationDrawable.addFrame(bonfireSix, timeAnimation);

        imageBonfireMain.setImageDrawable(animationDrawable);

        animationDrawable.start();

        imageBirdFirst = (ImageView) findViewById(R.id.imageBirdFirstID);
        imageBirdSecond = (ImageView) findViewById(R.id.imageBirdSecondID);

        animationBirdFirst = AnimationUtils.loadAnimation(this, R.anim.main_menu_bird_first_animation);
        animationBirdSecond = AnimationUtils.loadAnimation(this, R.anim.main_menu_bird_second_animation);

        new CountDownTimer(600000, 10000) {
            public void onTick(long millisUntilFinished) {
                getAnimationBirdFirst();

            }

            public void onFinish() {

            }
        }.start();

        new CountDownTimer(3000, 3000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                new CountDownTimer(600000, 10000) {
                    public void onTick(long millisUntilFinished) {
                        getAnimationBirdSecond();

                    }

                    public void onFinish() {

                    }
                }.start();

            }
        }.start();


    }

    public void onResume() {
        super.onResume();
        checkForCrashes();
        if (isOstStop) {
            ostMain = MediaPlayer.create(this, R.raw.ost_main);
            isOstStop = false;
            ostMain.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterManagers();
        if (!isOstStop) {
            isOstStop = true;
            ostMain.stop();
        }
    }

    public void onStartMain(View view) {
        timer = new CountDownTimer(200, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonStartMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonStartMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();

        isNewGame = false;
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
        editor.putBoolean(APP_SAVE_START, isNewGame);
        editor.apply();
        ostMain.stop();
        Intent intent = new Intent(MainActivity.this, PrologueTitle.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }

    public void onContinueMain(View view) {
        timer = new CountDownTimer(200, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonСontinueMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonСontinueMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();
        if (isNewGame) {
            view.setClickable(false);
        } else {
            float level = settings.getFloat(APP_SAVE_LEVEL, 0);
            Intent intent = new Intent(MainActivity.this, LevelsList.getLevel(level));
            startActivity(intent);
            ostMain.stop();
            finish();
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        }
    }

    public void onExitMain(View view) {
        timer = new CountDownTimer(200, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonExitMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonExitMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();
        ostMain.stop();
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterManagers();
    }

    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }


    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    AlertDialog.Builder dialog;

    private void openQuitDialog() {
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.button_dialog_title);
        dialog.setPositiveButton(R.string.button_dialog_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton(R.string.button_dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void onOldCamp(View view) {
        ostMain.stop();
        startActivity(new Intent(this, ChapterTwoInstituteEntrance.class));
        finish();
    }

    public void onHunting(View view) {
        ostMain.stop();
        startActivity(new Intent(this, ChapterTwoApartment.class));
        finish();
    }

    public void onSettingsMain(View view) {

        timer = new CountDownTimer(200, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonSettingsMain.setTextColor(Color.WHITE);
            }

            @Override
            public void onFinish() {
                buttonSettingsMain.setTextColor(Color.parseColor("#303030"));
            }
        }.start();

        startActivity(new Intent(this, MainSettings.class));
    }

    public void getAnimationBirdFirst() {

        imageBirdFirst.startAnimation(animationBirdFirst);

        imageBirdFirst.setVisibility(View.VISIBLE);
    }

    public void getAnimationBirdSecond() {

        imageBirdSecond.startAnimation(animationBirdSecond);

        imageBirdSecond.setVisibility(View.VISIBLE);
    }

    public void onTest3(View view) {
        startActivity(new Intent(this, ChapterTwoTrafficJamTest.class));
        finish();
    }
}
