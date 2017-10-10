package com.example.last_spring.gameprealpha.res;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.R;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstDisturbance;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private static final String APP_SETTINGS = "Settings";
    private static final String APP_SETTINGS_SETTINGS_FONTS_SIZE = "Fonts size";
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
    public boolean isOstDisturbance;
    public float level;
    public float sizeFonts;
    public float lineSpacing;

    public ImageButton buttonMenu;

    public Animation animationStart;
    public Animation luckAnimation;
    public Animation failAnimation;

    public MediaPlayer ost;

    @Override
    public void onBackPressed() {
        openQuitDialog();
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
        isKnifeMain = save.getBoolean(APP_SAVE_KNIFE, false);
        isRaincoatMain = save.getBoolean(APP_SAVE_RAINCOAT, false);
        isSleepingBugMain = save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
        isFaim = save.getBoolean(APP_SAVE_FAIM, false);
        wound = save.getInt(APP_SAVE_WOUND, 0);

        animationStart = AnimationUtils.loadAnimation(this, R.anim.title_in);
    }

    public void onInventory(View view) {
        openQuitDialog();
    }

    private void openQuitDialog() {

        String stFortune;
        String stWound;
        String stFaim;

        if (isSleepingBugMain) {
            sleepingBug = getString(R.string.prologue_inventory_sleeping_bug);
        } else {
            sleepingBug = getString(R.string.prologue_inventory_no_sleeping_bug);
        }

        if (isKnifeMain) {
            knife = getString(R.string.prologue_inventory_knife);
        } else {
            knife = getString(R.string.prologue_inventory_no_knife);
        }

        if (isRaincoatMain) {
            raincoat = getString(R.string.prologue_inventory_raincoat);
        } else {
            raincoat = getString(R.string.prologue_inventory_no_raincoat);
        }

        if (wound == 0) {
            stWound = getString(R.string.prologue_inventory_hp_100);
        } else if (wound == 1) {
            stWound = getString(R.string.prologue_inventory_hp_50);
        } else {
            stWound = getString(R.string.prologue_inventory_hp_0);
        }

        if (isFaim) {
            stFaim = getString(R.string.prologue_inventory_faim);
        } else {
            stFaim = getString(R.string.prologue_inventory_no_faim);
        }

        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        stFortune = "test";

        if (fortune <= 10) {
            stFortune = getString(R.string.prologue_inventory_fortune_10);
        } else if (fortune <= 20) {
            stFortune = getString(R.string.prologue_inventory_fortune_20);
        } else if (fortune <= 30) {
            stFortune = getString(R.string.prologue_inventory_fortune_30);
        } else if (fortune <= 40) {
            stFortune = getString(R.string.prologue_inventory_fortune_40);
        } else if (fortune <= 50) {
            stFortune = getString(R.string.prologue_inventory_fortune_50);
        } else if (fortune <= 60) {
            stFortune = getString(R.string.prologue_inventory_fortune_60);
        } else if (fortune <= 70) {
            stFortune = getString(R.string.prologue_inventory_fortune_70);
        } else if (fortune <= 80) {
            stFortune = getString(R.string.prologue_inventory_fortune_80);
        } else if (fortune <= 90) {
            stFortune = getString(R.string.prologue_inventory_fortune_90);
        } else if (fortune <= 100) {
            stFortune = getString(R.string.prologue_inventory_fortune_100);
        }


        dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.button_dialog_title);
        dialog.setMessage(Html.fromHtml(getString(R.string.prologue_inventory, sleepingBug,
                foodCounterMain,
                treatmentCounterMain,
                knife,
                raincoat,
                stFortune, stWound, stFaim)));
        dialog.setPositiveButton(R.string.button_dialog_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishOst();
                finish();
            }
        });
        dialog.setNeutralButton(R.string.button_dialog_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishOst();
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
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
        if (isOst) {
            ost.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isOst) {
            ost.stop();
        }
        if (!isOstStop && !isExitScene) {
            finishOst();
            isOstStop = true;
        }
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
        openQuitDialog();
    }

}
