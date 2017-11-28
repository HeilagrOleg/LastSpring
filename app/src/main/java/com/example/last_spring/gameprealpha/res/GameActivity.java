package com.example.last_spring.gameprealpha.res;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.prologue.PrologueInventory;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstDisturbance;
import com.last_spring.gameprealpha.OstRoad;
import com.last_spring.gameprealpha.OstSnowy;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private static final String APP_SETTINGS = "Settings";
    private static final String APP_SETTINGS_SETTINGS_FONTS_SIZE = "Fonts size";
    private static final String APP_SETTINGS_SETTINGS_FONTS_BACKGROUND = "Background";
    private static final String APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING = "Line spacing";

    public static final String APP_SAVE = "Save";
    public static final String APP_SAVE_FOOD = "Food";
    public static final String APP_SAVE_TRAINING = "Training";
    public static final String APP_SAVE_WOOD = "Wood";
    public static final String APP_SAVE_FAIM = "Faim";
    public static final String APP_SAVE_KNIFE = "Knife";
    public static final String APP_SAVE_LEVEL = "Level";
    public static final String APP_SAVE_FORTUNE = "Fortune";
    public static final String APP_SAVE_RAINCOAT = "Raincoat";
    public static final String APP_SAVE_WOUND = "Wound";
    public static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    public static final String APP_SAVE_TREATMENT = "Treatment";

    public SharedPreferences save;
    public SharedPreferences settings;
    private String sleepingBug;
    private String knife;
    private String raincoat;
    public int treatmentCounterMain;
    public int foodCounterMain;
    public int fortune;
    public int backgroundCounter;
    public boolean isSleepingBugMain;
    public boolean isRaincoatMain;
    public boolean isKnifeMain;
    public int wound;
    public boolean isFaim;
    public boolean isExitScene;
    public boolean isOst;
    public boolean isOstStop;
    public boolean isOstWood;
    public boolean isOstCave;
    public boolean isOstShowy;
    public boolean isOstDisturbance;
    public boolean isOstRoad;
    public boolean isMenu;
    public float level;
    public float sizeFonts;
    public float lineSpacing;

    public boolean isMenuExit;

    public ImageButton buttonMenu;

    public Button buttonMenuCancel;

    public Animation animationStart;
    public Animation luckAnimation;
    public Animation failAnimation;
    public Animation buttonMainAnimation;

    public ImageView imageBackgroundLuckTrue;
    public ImageView imageBackgroundLuckFalse;

    public TextView textMessage;
    public TextView textInventoryFood;
    public TextView textInventoryDrugs;
    public TextView textInventorySleepingBug;
    public TextView textInventoryRaincoat;
    public TextView textInventoryKnife;
    public TextView textInventoryText;

    public ProgressBar progressBarMenuHealth;
    public ProgressBar progressBarMenuHunger;
    public ProgressBar progressBarMenuLuck;

    public MediaPlayer ost;

    public Resources res;

    public RelativeLayout menuMain;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PrologueInventory.class);
        intent.putExtra("fortune", fortune);
        intent.putExtra("wound", wound);
        intent.putExtra("faim", isFaim);
        intent.putExtra("knife", isKnifeMain);
        intent.putExtra("raincoat", isRaincoatMain);
        intent.putExtra("sleepingBug", isSleepingBugMain);
        intent.putExtra("food", foodCounterMain);
        intent.putExtra("treatment", treatmentCounterMain);
        startActivity(intent);
    }

    AlertDialog.Builder dialog;
    private View decorView;
    public AlertDialog.Builder inventory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        settings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        sizeFonts = settings.getFloat(APP_SETTINGS_SETTINGS_FONTS_SIZE, 18f);
        lineSpacing = settings.getFloat(APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING, 3f);
        backgroundCounter = settings.getInt(APP_SETTINGS_SETTINGS_FONTS_BACKGROUND, 75);
        luckAnimation = AnimationUtils.loadAnimation(this, R.anim.background_luck_animation);
        failAnimation = AnimationUtils.loadAnimation(this, R.anim.background_luck_animation);
        treatmentCounterMain = save.getInt(APP_SAVE_TREATMENT, 0);
        foodCounterMain = save.getInt(APP_SAVE_FOOD, 0);
        fortune = save.getInt(APP_SAVE_FORTUNE, 0);
        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        res = getResources();

        isMenu = false;

        isKnifeMain = save.getBoolean(APP_SAVE_KNIFE, false);
        isRaincoatMain = save.getBoolean(APP_SAVE_RAINCOAT, false);
        isSleepingBugMain = save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
        isFaim = save.getBoolean(APP_SAVE_FAIM, false);
        wound = save.getInt(APP_SAVE_WOUND, 0);


        buttonMainAnimation = AnimationUtils.loadAnimation(this, R.anim.button_main_animation);
        animationStart = AnimationUtils.loadAnimation(this, R.anim.title_in);
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

    public void finishOst() {
        stopService(new Intent(this, OstWood.class));
        stopService(new Intent(this, OstDisturbance.class));
        stopService(new Intent(this, OstCave.class));
        stopService(new Intent(this, OstRoad.class));
        if (isOst) {
            ost.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!isMenuExit) {
            if (isOst) {
                ost.stop();
            }
            if (!isOstStop && !isExitScene) {
                finishOst();
                isOstStop = true;
            }
        }
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!isMenuExit) {
            if (isOst) {
                ost.stop();
            }
            if (!isOstStop && !isExitScene) {
                finishOst();
                isOstStop = true;
            }
        }
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isOst) {
            ost.start();
        }
        if (isOstStop && !isOst) {
            if (isOstWood) {
                startService(new Intent(this, OstWood.class));
            } else if (isOstCave) {
                startService(new Intent(this, OstCave.class));
            } else if (isOstDisturbance) {
                startService(new Intent(this, OstDisturbance.class));
            } else if (isOstShowy) {
                startService(new Intent(this, OstSnowy.class));
            }  else if (isOstRoad) {
                startService(new Intent(this, OstRoad.class));
            }
        }
    }



    public void getSave(float level) {
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
    }

    public void getNextScene(Intent intent) {
        isExitScene = true;
        startActivity(intent);
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
    }

    public void startAnimation(final ArrayList<View> list) {
        new CountDownTimer(500, 500) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                for (View e : list) {
                    e.startAnimation(animationStart);
                    e.setVisibility(View.VISIBLE);
                }
            }
        }.start();
    }

    public void sText(TextView view) {
        view.setTextSize(sizeFonts);
        view.setLineSpacing(lineSpacing, 0.8f);
    }

    public void sScroll(ScrollView view) {

    }

    public void refreshScroll(ScrollView view) {
        view.scrollTo(0, 0);
    }


    public void onButtonMenu(View view) {
        showButtonMainAnimation(view);
        Intent intent = new Intent(this, PrologueInventory.class);
        intent.putExtra("fortune", fortune);
        intent.putExtra("wound", wound);
        intent.putExtra("faim", isFaim);
        intent.putExtra("knife", isKnifeMain);
        intent.putExtra("raincoat", isRaincoatMain);
        intent.putExtra("sleepingBug", isSleepingBugMain);
        intent.putExtra("food", foodCounterMain);
        intent.putExtra("treatment", treatmentCounterMain);
        startActivity(intent);
    }

    public void showMessage(TextView textView, boolean isStart) {

        if (isStart) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.message_animation_start);
            textView.startAnimation(animation);
            textView.setVisibility(View.VISIBLE);
        } else {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.message_animation);
            textView.startAnimation(animation);
            textView.setVisibility(View.VISIBLE);
        }


    }

    public void getInterface(boolean isImage) {

        if (isImage) {
            imageBackgroundLuckTrue = (ImageView) findViewById(R.id.imageBackgroundLuckTrueID);
            imageBackgroundLuckFalse = (ImageView) findViewById(R.id.imageBackgroundLuckFalseID);
        }

        menuMain = (RelativeLayout) findViewById(R.id.menuMainID);

        textMessage = (TextView) findViewById(R.id.textMessageID);
        textMessage.setTextSize(sizeFonts + 4);
    }

    public void getLuckImage(boolean isLuck) {
        if (isLuck) {
            imageBackgroundLuckFalse.setVisibility(View.GONE);
            imageBackgroundLuckTrue.setVisibility(View.VISIBLE);
            imageBackgroundLuckTrue.startAnimation(luckAnimation);
        } else {
            imageBackgroundLuckTrue.setVisibility(View.GONE);
            imageBackgroundLuckFalse.setVisibility(View.VISIBLE);
            imageBackgroundLuckFalse.startAnimation(failAnimation);
        }
    }




    public void showButtonMainAnimation(final View view) {
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

}
