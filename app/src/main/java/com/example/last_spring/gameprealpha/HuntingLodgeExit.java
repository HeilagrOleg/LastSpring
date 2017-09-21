package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;

public class HuntingLodgeExit extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_HUNTING_KNIFE = "Knife bedside";
    private static final String APP_SAVE_PROLOGUE_HUNTER_CAMP = "Old camp";
    private static final String APP_SAVE_PROLOGUE_HUNTER_THINGS = "Things";
    private static final String APP_SAVE_PROLOGUE_HUNTER_FIGHT = "Fight with hunter";

    private TextView textPrologueHunterExit;
    private RadioButton buttonPrologueHunterExitFirst;
    private RadioButton buttonPrologueHunterExitSecond;

    private boolean isExit;
    private boolean isArm;
    private boolean isStop;
    private boolean isNextWound;
    private boolean isNextHunger;
    private boolean isNextNoKnifeNoWoundNoHunger;
    private boolean isNextNoKnifeWoundNoHunger;
    private boolean isNextNoKnifeNoWoundHunger;

    private float level;

    private boolean isFirst;
    private boolean isSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_exit);

        level = 1.15f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        textPrologueHunterExit = (TextView) findViewById(R.id.textPrologueHunterExitID);
        buttonPrologueHunterExitFirst = (RadioButton) findViewById(R.id.buttonPrologueHunterExitFirstID);
        buttonPrologueHunterExitSecond = (RadioButton) findViewById(R.id.buttonPrologueHunterExitSecondID);

        startService(new Intent(this, OstDisturbance.class));
        isOstDisturbance = true;

        if (save.getBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, false)) {
            if (save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false)) {
                textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife);
                buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_knife);
                buttonPrologueHunterExitSecond.setText(R.string.hunting_exit_button_fight_no_knife);
            } else {
                if (save.getBoolean(APP_SAVE_FAIM, false) || save.getInt(APP_SAVE_WOUND, 0) > 0) {
                    if ((save.getBoolean(APP_SAVE_FAIM, false) && save.getInt(APP_SAVE_WOUND, 0) > 0) || save.getInt(APP_SAVE_WOUND, 0) > 0) {
                        textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_wound);
                        buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_wound_first);
                        buttonPrologueHunterExitSecond.setText(R.string.hunting_exit_button_fight_no_knife_wound_second);
                    } else {
                        textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_hunger);
                        buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_hunger_first);
                        buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    }
                } else {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_no_hunger_no_wound);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_no_hunger_no_wound);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                }
            }
        } else {
            if (save.getBoolean(APP_SAVE_PROLOGUE_HUNTER_CAMP, false)) {
                textPrologueHunterExit.setText(R.string.hunting_exit_text_camp);
                buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_camp);
                buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                isExit = true;
            } else {
                textPrologueHunterExit.setText(R.string.hunting_exit_text_no_camp);
                buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                isExit = true;
            }
        }
    }

    public void onPrologueHunterExitFirst(View view) {
        if (isFirst) {
            if (isStop) {
                textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_hunger_exit);
                buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                isExit = true;
                isStop = false;
                buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                isFirst = false;
            } else if (isExit) {
                stopService(new Intent(this, OstDisturbance.class));
                SharedPreferences.Editor editor = save.edit();
                if ((wound > 0 || isFaim) && save.getBoolean(APP_SAVE_PROLOGUE_HUNTER_FIGHT, false) && !isArm) {
                    wound++;
                }
                editor.putInt(APP_SAVE_WOUND, wound);
                editor.apply();
                getNextScene(new Intent(this, HuntingLodgeAfter.class));
                textPrologueHunterExit.setVisibility(View.GONE);
                finish();
            } else if (isNextHunger || isNextWound) {
                if (isNextWound) {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_wound_exit);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    isExit = true;
                    buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                    isFirst = false;
                } else {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_no_wound_hunger_stop);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_next);
                    isStop = true;
                    isNextHunger = false;
                    buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                }
            } else {
                if (save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false)) {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_knife);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    isExit = true;
                    isArm = true;
                    buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                    isFirst = false;
                } else {
                    if (save.getBoolean(APP_SAVE_FAIM, false) || save.getInt(APP_SAVE_WOUND, 0) > 0) {
                        if ((save.getBoolean(APP_SAVE_FAIM, false) && save.getInt(APP_SAVE_WOUND, 0) > 0) || save.getInt(APP_SAVE_WOUND, 0) > 0) {
                            textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_wound_next);
                            buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_wound_next);
                            buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                            isNextWound = true;
                            buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                            isFirst = false;
                        } else {
                            textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_hunger_next);
                            buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_hunger_first_next);
                            buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                            isNextHunger = true;
                            buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                            isFirst = false;
                        }
                    } else {
                        textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_no_hunger_no_wound_next);
                        buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                        buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                        isExit = true;
                        buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
                        isFirst = false;
                    }
                }
            }
        } else {
            buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
        }
    }

    public void onPrologueHunterExitSecond(View view) {
        if (isSecond) {
            if (isNextNoKnifeNoWoundNoHunger || isNextNoKnifeWoundNoHunger || isNextNoKnifeNoWoundHunger) {
                if (isNextNoKnifeNoWoundNoHunger) {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_no_wound_no_hunger_next);
                    buttonPrologueHunterExitFirst.setVisibility(View.VISIBLE);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    isExit = true;
                    buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                    isSecond = false;
                } else if (isNextNoKnifeWoundNoHunger) {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_wound_no_hunger_next);
                    buttonPrologueHunterExitFirst.setVisibility(View.VISIBLE);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    isExit = true;
                    buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                    isSecond = false;
                } else {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_no_wound_hunger_next);
                    buttonPrologueHunterExitFirst.setVisibility(View.VISIBLE);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_exit);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    isExit = true;
                    buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                    isSecond = false;
                }
            } else {
                if (save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, false)) {
                    if (!save.getBoolean(APP_SAVE_FAIM, false) && save.getInt(APP_SAVE_WOUND, 0) == 0) {
                        textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_no_wound_no_hunger);
                        buttonPrologueHunterExitSecond.setText(R.string.hunting_exit_button_fight_no_knife_next);
                        buttonPrologueHunterExitFirst.setVisibility(View.GONE);
                        isNextNoKnifeNoWoundNoHunger = true;
                        buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                        isSecond = false;
                    } else if (save.getInt(APP_SAVE_WOUND, 0) > 0) {
                        textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_wound_no_hunger);
                        buttonPrologueHunterExitSecond.setText(R.string.hunting_exit_button_fight_no_knife_next);
                        buttonPrologueHunterExitFirst.setVisibility(View.GONE);
                        isNextNoKnifeWoundNoHunger = true;
                        buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                        isSecond = false;
                    } else {
                        textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_knife_no_knife_no_wound_hunger);
                        buttonPrologueHunterExitSecond.setText(R.string.hunting_exit_button_fight_no_knife_next);
                        buttonPrologueHunterExitFirst.setVisibility(View.GONE);
                        isNextNoKnifeNoWoundHunger = true;
                        buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                        isSecond = false;
                    }
                } else {
                    textPrologueHunterExit.setText(R.string.hunting_exit_text_fight_no_knife_wound_next);
                    buttonPrologueHunterExitFirst.setText(R.string.hunting_exit_button_fight_no_knife_wound_next);
                    buttonPrologueHunterExitSecond.setVisibility(View.GONE);
                    isNextWound = true;
                    buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
                    isSecond = false;
                }
            }
        } else {
            buttonPrologueHunterExitSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueHunterExitFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
        }
    }
}
