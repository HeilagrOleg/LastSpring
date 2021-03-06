package com.example.last_spring.gameprealpha.res;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.chapterTwo.ChapterTwoMenu;
import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.R;
import com.last_spring.gameprealpha.OstCave;
import com.last_spring.gameprealpha.OstDisturbance;
import com.last_spring.gameprealpha.OstRoad;
import com.last_spring.gameprealpha.OstSnowy;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;

public class GameActivityTwo extends AppCompatActivity {

    private static final String APP_SETTINGS = "Settings";
    private static final String APP_SETTINGS_SETTINGS_FONTS_SIZE = "Fonts size";
    private static final String APP_SETTINGS_SETTINGS_FONTS_BACKGROUND = "Background";
    private static final String APP_SETTINGS_SETTINGS_FONTS_LINE_SPACING = "Line spacing";

    public static final String APP_SAVE = "Save";
    public static final String APP_SAVE_LEVEL = "Level";
    public static final String APP_SAVE_CHAPTER_TWO_DATE = "Date";
    public static final String APP_SAVE_CHAPTER_TWO_FORTUNE = "Fortune";
    public static final String APP_SAVE_CHAPTER_TWO_RESPECT_ALIN = "Alin respect";

    public RadioGroup radioGroupChapterTwo;

    public RadioButton buttonChapterTwoFirst;
    public RadioButton buttonChapterTwoSecond;
    public RadioButton buttonChapterTwoThird;
    public RadioButton buttonChapterTwoFour;

    public ImageView imageBackgroundLuckFalse;
    public ImageView imageBackgroundLuckTrue;

    public ImageButton imageButtonMenuChapterTwo;

    public ScrollView scrollChapterTwo;
    public TextView textChapterTwo;
    public TextView textMessage;

    public SharedPreferences save;
    public SharedPreferences settings;
    public int fortune;
    public int wound;
    public int backgroundCounter;

    public boolean isMenuExit;

    public boolean isExitScene;
    public boolean isOst;
    public boolean isOstStop;
    public boolean isOstWood;
    public boolean isOstCave;
    public boolean isOstShowy;
    public boolean isOstRoad;
    public boolean isOstDisturbance;

    public int respectAlin;
    public int date;

    public Animation animationOut;
    public Animation animationIn;

    public boolean isFirst;
    public boolean isSecond;
    public boolean isThird;
    public boolean isFour;

    public float level;
    public float sizeFonts;
    public float lineSpacing;

    public String colorChoice;
    public String colorButton;

    public Animation animationStart; //3000 Длительность

    public MediaPlayer ost;

    public SharedPreferences.Editor editor;

    @Override
    public void onBackPressed() {
        getMenuChapterTwo();
    }

    AlertDialog.Builder dialog;
    private View decorView;

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
        respectAlin = save.getInt(APP_SAVE_CHAPTER_TWO_RESPECT_ALIN, 0);
        date = save.getInt(APP_SAVE_CHAPTER_TWO_DATE, 0);
        fortune = save.getInt(APP_SAVE_CHAPTER_TWO_FORTUNE, 0);
        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        animationOut = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_out_animation);
        animationIn = AnimationUtils.loadAnimation(this, R.anim.cut_scene_prologue_text_in_animation);

        colorChoice = "#6e9ba1";
        colorButton = "#60ffffff";

        editor = save.edit();

        animationStart = AnimationUtils.loadAnimation(this, R.anim.title_in);
    }

    public void onInventory(View view) {
        openQuitDialog();
    }

    private void openQuitDialog() {

        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        String text = getString(R.string.button_dialog_title) + " " + fortune;

        dialog = new AlertDialog.Builder(this);
        dialog.setTitle(text);
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
                Intent intent = new Intent(GameActivityTwo.this, MainActivity.class);
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
        stopService(new Intent(this, OstSnowy.class));
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

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void getSave(float level) {
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
    }

    public void getNextScene(Class<?> cls) {
        isExitScene = true;
        editor.putInt(APP_SAVE_CHAPTER_TWO_FORTUNE, fortune);
        editor.putInt(APP_SAVE_CHAPTER_TWO_DATE, date);
        editor.putInt(APP_SAVE_CHAPTER_TWO_RESPECT_ALIN, respectAlin);
        editor.apply();
        startActivity(new Intent(this, cls));
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

    public void startAnimationChapterTwo(final ArrayList<View> list) {

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

    public void startAnimationChapterTwo(final View view) {

        new CountDownTimer(500, 500) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                view.startAnimation(animationStart);
                view.setVisibility(View.VISIBLE);
            }
        }.start();
    }


    public void getButtons() {

        radioGroupChapterTwo = (RadioGroup) findViewById(R.id.radioGroupChapterTwoID);

        buttonChapterTwoFirst = (RadioButton) findViewById(R.id.buttonChapterTwoFirstID);
        buttonChapterTwoFirst.setTextSize(sizeFonts);
        buttonChapterTwoSecond = (RadioButton) findViewById(R.id.buttonChapterTwoSecondID);
        buttonChapterTwoSecond.setTextSize(sizeFonts);
        buttonChapterTwoThird = (RadioButton) findViewById(R.id.buttonChapterTwoThirdID);
        buttonChapterTwoThird.setTextSize(sizeFonts);
        buttonChapterTwoFour = (RadioButton) findViewById(R.id.buttonChapterTwoFourID);
        buttonChapterTwoFour.setTextSize(sizeFonts);

        textChapterTwo = (TextView) findViewById(R.id.textChapterTwoID);
        sText(textChapterTwo);
        textChapterTwo.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

        scrollChapterTwo = (ScrollView) findViewById(R.id.scrollChapterTwoID);
        sScroll(scrollChapterTwo);
    }

    public void getChoiceButton(RadioButton button) {
        buttonChapterTwoFirst.setBackgroundColor(Color.parseColor(colorButton));
        buttonChapterTwoSecond.setBackgroundColor(Color.parseColor(colorButton));
        buttonChapterTwoThird.setBackgroundColor(Color.parseColor(colorButton));
        buttonChapterTwoFour.setBackgroundColor(Color.parseColor(colorButton));

        isFirst = false;
        isSecond = false;
        isThird = false;
        isFour = false;

        button.setBackgroundColor(Color.parseColor(colorChoice));
    }

    public void getChoiceButton() {
        refreshScroll();
        buttonChapterTwoFirst.setBackgroundColor(Color.parseColor(colorButton));
        buttonChapterTwoSecond.setBackgroundColor(Color.parseColor(colorButton));
        buttonChapterTwoThird.setBackgroundColor(Color.parseColor(colorButton));
        buttonChapterTwoFour.setBackgroundColor(Color.parseColor(colorButton));

        isFirst = false;
        isSecond = false;
        isThird = false;
        isFour = false;
    }

    public void nextText(@StringRes final int resid) {
        textChapterTwo.startAnimation(animationOut);

        new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                textChapterTwo.setText(resid);
                textChapterTwo.startAnimation(animationIn);
            }
        }.start();
    }

    public void nextText(final Button button, @StringRes final int resid) {
        button.startAnimation(animationOut);

        new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                button.setText(resid);
                button.startAnimation(animationIn);
            }
        }.start();
    }

    public void getInterfaceChapterTwo() {
        textMessage = (TextView) findViewById(R.id.textMessageID);
        textMessage.setTextSize(sizeFonts + 4);

        imageButtonMenuChapterTwo = (ImageButton) findViewById(R.id.imageButtonMenuChapterTwoID);

        startAnimationChapterTwo(imageButtonMenuChapterTwo);

        imageBackgroundLuckFalse = (ImageView) findViewById(R.id.imageBackgroundLuckFalseID);
        imageBackgroundLuckTrue = (ImageView) findViewById(R.id.imageBackgroundLuckTrueID);

    }

    public void getLuckImage(boolean isLuck) {
        if (isLuck) {
            Animation luckAnimation = AnimationUtils.loadAnimation(this, R.anim.background_luck_animation);
            imageBackgroundLuckFalse.setVisibility(View.GONE);
            imageBackgroundLuckTrue.setVisibility(View.VISIBLE);
            imageBackgroundLuckTrue.startAnimation(luckAnimation);
        } else {
            Animation failAnimation = AnimationUtils.loadAnimation(this, R.anim.background_luck_animation);
            imageBackgroundLuckTrue.setVisibility(View.GONE);
            imageBackgroundLuckFalse.setVisibility(View.VISIBLE);
            imageBackgroundLuckFalse.startAnimation(failAnimation);
        }
    }


    public void showMessageChapterTwo(@StringRes final int resid) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.message_animation);
        textMessage.setText(resid);
        textMessage.startAnimation(animation);
        textMessage.setVisibility(View.VISIBLE);
    }

    public void showMessageChapterTwo(String text) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.message_animation);
        textMessage.setText(text);
        textMessage.startAnimation(animation);
        textMessage.setVisibility(View.VISIBLE);
    }


    public void getMenuChapterTwo() {
        Intent intent = new Intent(this, ChapterTwoMenu.class);
        intent.putExtra("fortune", fortune);
        intent.putExtra("date", date);
        intent.putExtra("respectAlin", respectAlin);
        startActivity(intent);
        onPause();
    }

    public void onMenuCancelD(View view) {
        finish();
    }


    public void onMenuMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void getTime() {

        int minutes = 540 - (date);

        if (minutes <= 0) {
            showMessageChapterTwo(R.string.chapter_two_message_data_fail);
        } else {

            if (minutes % 10 == 1) {
                showMessageChapterTwo(getString(R.string.chapter_two_message_data_main) + " " + minutes + " " + getString(R.string.chapter_two_message_data_minute_second));
            } else {
                showMessageChapterTwo(getString(R.string.chapter_two_message_data_main) + " " + minutes + " " + getString(R.string.chapter_two_message_data_minute));
            }

        }

    }

    public void getFortuneChange(int change) {

        fortune += change;

        if (fortune <= 10) {
            fortune = 10;
        } else if (fortune >= 100) {
            fortune = 100;
        }
    }

    public void onButtonMenu(final View view) {
        view.setClickable(false);
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_main_animation));
        new CountDownTimer(300, 300) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                getMenuChapterTwo();
                view.setClickable(true);
            }
        }.start();

    }

    public void getRespectDown() {
        showMessageChapterTwo(R.string.chapter_two_dialog_message_respect_down);
        if (respectAlin < 5) {
            respectAlin = 0;
        } else {
            respectAlin -= 5;
        }

    }

    public void getRespectUp() {
        showMessageChapterTwo(R.string.chapter_two_dialog_message_respect_up);
        if (respectAlin > 95) {
            respectAlin = 100;
        } else {
            respectAlin += 5;
        }
    }

    public void refreshScroll() {
        scrollChapterTwo.scrollTo(0, 0);
    }

}
