package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.res.GameActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class PrologueOldStoryAttack extends GameActivity {

    private static final String APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS = "Hunters";
    private static final String APP_SAVE_PROLOGUE_OLD_STORY_WOOD = "Wood";

    private TextView textPrologueOldStoryAttackStart;
    private TextView textPrologueOldStoryAttackAction;
    private TextView textPrologueOldStoryAttackStatus;

    private RadioGroup radioGroupPrologueOldStoryAttackNorth;

    private RadioButton buttonPrologueOldStoryAttackNorthFirst;
    private RadioButton buttonPrologueOldStoryAttackNorthSecond;
    private RadioButton buttonPrologueOldStoryAttackNorthThird;

    private RadioGroup radioGroupPrologueOldStoryAttackWest;

    private RadioButton buttonPrologueOldStoryAttackWestFirst;
    private RadioButton buttonPrologueOldStoryAttackWestSecond;
    private RadioButton buttonPrologueOldStoryAttackWestThird;

    private RadioGroup radioGroupPrologueOldStoryAttackMain;

    private RadioButton buttonPrologueOldStoryAttackMainFirst;
    private RadioButton buttonPrologueOldStoryAttackMainSecond;
    private RadioButton buttonPrologueOldStoryAttackMainThird;

    private ArrayList<Integer> random;

    private int enemiesCount;
    private int enemiesCoast;
    private int huntersCount;
    private int statusCamp;
    private int randomCounter;

    private String camp;
    private String stormtroopers;
    private String statusMessage;

    private boolean isFirst;
    private boolean isSecond;
    private boolean isThird;

    private boolean isStart;
    private boolean isAttack;
    private boolean isWestFight;
    private boolean isNorthFight;
    private boolean isMainFight;
    private boolean isMainNext;
    private boolean isAttackNorth;
    private boolean isAttackTent;
    private boolean isAttackBlade;
    private boolean isBlade;
    private boolean isAttackBow;
    private boolean isBow;
    private boolean isAttackForest;
    private boolean isForest;
    private boolean isFailNorth;
    private boolean isExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_old_story_attack);

        getSave(0.2f);

        textPrologueOldStoryAttackStart = (TextView) findViewById(R.id.textPrologueOldStoryAttackStartID);
        textPrologueOldStoryAttackAction = (TextView) findViewById(R.id.textPrologueOldStoryAttackActionID);
        textPrologueOldStoryAttackStatus = (TextView) findViewById(R.id.textPrologueOldStoryAttackStatusID);

        radioGroupPrologueOldStoryAttackNorth = (RadioGroup) findViewById(R.id.radioGroupPrologueOldStoryAttackNorthID);

        buttonPrologueOldStoryAttackNorthFirst = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackNorthFirstID);
        buttonPrologueOldStoryAttackNorthSecond = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackNorthSecondID);
        buttonPrologueOldStoryAttackNorthThird = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackNorthThirdID);

        radioGroupPrologueOldStoryAttackWest = (RadioGroup) findViewById(R.id.radioGroupPrologueOldStoryAttackWestID);

        buttonPrologueOldStoryAttackWestFirst = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackWestFirstID);
        buttonPrologueOldStoryAttackWestSecond = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackWestSecondID);
        buttonPrologueOldStoryAttackWestThird = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackWestThirdID);

        radioGroupPrologueOldStoryAttackMain = (RadioGroup) findViewById(R.id.radioGroupPrologueOldStoryAttackMainID);

        buttonPrologueOldStoryAttackMainFirst = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackMainFirstID);
        buttonPrologueOldStoryAttackMainSecond = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackMainSecondID);
        buttonPrologueOldStoryAttackMainThird = (RadioButton) findViewById(R.id.buttonPrologueOldStoryAttackMainThirdID);

        textPrologueOldStoryAttackAction.setVisibility(View.GONE);
        textPrologueOldStoryAttackStatus.setVisibility(View.GONE);
        radioGroupPrologueOldStoryAttackMain.setVisibility(View.GONE);

        huntersCount = save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0);
        statusCamp = 100;
        enemiesCount = 18;
        enemiesCoast = 3;
        randomCounter = 0;

        isStart = true;

        random = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        camp = getString(R.string.prologue_old_story_attack_text_status_camp_calm);
        stormtroopers = getString(R.string.prologue_old_story_attack_text_status_no_stormtroopers);
        statusMessage = getString(R.string.prologue_old_story_attack_message_status_attack_north);

        if (save.getBoolean(APP_SAVE_PROLOGUE_OLD_STORY_WOOD, false)) {
            textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_west);
            radioGroupPrologueOldStoryAttackNorth.setVisibility(View.GONE);
            radioGroupPrologueOldStoryAttackWest.setVisibility(View.VISIBLE);
            statusMessage = getString(R.string.prologue_old_story_attack_message_status_attack_west);
        } else {
            radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
        }
    }

    public void onPrologueOldStoryAttackNorthFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textPrologueOldStoryAttackStart.setVisibility(View.GONE);
                textPrologueOldStoryAttackStatus.setVisibility(View.VISIBLE);
                textPrologueOldStoryAttackAction.setVisibility(View.VISIBLE);
                getStatus();
                buttonPrologueOldStoryAttackNorthFirst.setText(R.string.prologue_old_story_attack_button_north_attack);
                buttonPrologueOldStoryAttackNorthSecond.setVisibility(View.GONE);
                isStart = false;
                isAttackNorth = true;
            } else if (isAttackNorth) {
                if (huntersCount >= enemiesCoast) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_success);
                    buttonPrologueOldStoryAttackNorthFirst.setText(R.string.prologue_old_story_attack_button_attack_tent);
                    buttonPrologueOldStoryAttackNorthSecond.setText(R.string.prologue_old_story_attack_button_attack_mounts);
                    buttonPrologueOldStoryAttackNorthSecond.setVisibility(View.VISIBLE);
                    buttonPrologueOldStoryAttackNorthThird.setText(R.string.prologue_old_story_attack_button_attack_signal);
                    buttonPrologueOldStoryAttackNorthThird.setVisibility(View.VISIBLE);
                    enemiesCount -= 3;
                    statusCamp -= 26;
                    isNorthFight = true;
                    isAttackNorth = false;
                    getStatus();
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_fail);
                    buttonPrologueOldStoryAttackNorthFirst.setText(R.string.prologue_old_story_attack_button_last_attack);
                    buttonPrologueOldStoryAttackNorthSecond.setText(R.string.prologue_old_story_attack_button_last_finish);
                    buttonPrologueOldStoryAttackNorthSecond.setVisibility(View.VISIBLE);
                    enemiesCount -= huntersCount;
                    enemiesCoast -= huntersCount;
                    statusCamp -= 26;
                    isAttackNorth = false;
                    isFailNorth = true;
                    getStatus();
                }
            } else if (isFailNorth) {
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_last_attack);
                buttonPrologueOldStoryAttackNorthFirst.setText(R.string.prologue_old_story_attack_button_attack_tent);
                buttonPrologueOldStoryAttackNorthSecond.setText(R.string.prologue_old_story_attack_button_attack_mounts);
                buttonPrologueOldStoryAttackNorthThird.setText(R.string.prologue_old_story_attack_button_attack_signal);
                buttonPrologueOldStoryAttackNorthThird.setVisibility(View.VISIBLE);
                statusCamp -= 15;
                isFailNorth = false;
                isNorthFight = true;
            } else if (isNorthFight) {
                if (huntersCount == 2) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_north_attack_tent_fail);
                    statusCamp -= 30;
                    huntersCount = 5;
                    enemiesCount -= 3;
                    isAttack = true;
                    radioGroupPrologueOldStoryAttackNorth.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_north_attack_tent_success);
                    statusCamp -= 30;
                    huntersCount = 6;
                    enemiesCount -= 3;
                    isAttack = true;
                    radioGroupPrologueOldStoryAttackNorth.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                }
                isNorthFight = false;
                stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                getStatus();
            }
            isFirst = false;
            buttonPrologueOldStoryAttackNorthFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryAttackNorthFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackNorthSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackNorthThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
            isThird = false;
        }
    }

    public void onPrologueOldStoryAttackNorthSecond(View view) {
        if (isSecond) {
            if (isStart) {
                textPrologueOldStoryAttackStart.setVisibility(View.GONE);
                textPrologueOldStoryAttackStatus.setVisibility(View.VISIBLE);
                textPrologueOldStoryAttackAction.setVisibility(View.VISIBLE);
                getStatus();
                randomCounter++;
                if (randomCounter == 3) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_wait_final);
                    isAttackNorth = true;
                    isStart = false;
                    buttonPrologueOldStoryAttackNorthFirst.setText(R.string.prologue_old_story_attack_button_north_attack);
                    buttonPrologueOldStoryAttackNorthSecond.setVisibility(View.GONE);
                } else {
                    Collections.shuffle(random);
                    switch (random.get(randomCounter - 1)) {
                        case 1:
                            textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_wait_one);
                            enemiesCoast--;
                            break;
                        case 2:
                            textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_wait_two);
                            enemiesCoast++;
                            break;
                        case 3:
                            textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_wait_three);
                            break;
                        case 4:
                            textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_start_north_wait_four);
                            break;
                    }
                }
            } else if (isFailNorth) {
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_last_finish);
                buttonPrologueOldStoryAttackNorthFirst.setText(R.string.prologue_old_story_attack_button_attack_tent);
                buttonPrologueOldStoryAttackNorthSecond.setText(R.string.prologue_old_story_attack_button_attack_mounts);
                buttonPrologueOldStoryAttackNorthThird.setText(R.string.prologue_old_story_attack_button_attack_signal);
                buttonPrologueOldStoryAttackNorthThird.setVisibility(View.VISIBLE);
                statusCamp -= 10;
                enemiesCount -= enemiesCoast;
                isFailNorth = false;
                isNorthFight = true;
            } else if (isNorthFight) {
                if (huntersCount == 2) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_north_attack_mount_fail);
                    statusCamp -= 30;
                    huntersCount = 5;
                    enemiesCount -= 2;
                    isAttack = true;
                    radioGroupPrologueOldStoryAttackNorth.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_north_attack_mount_success);
                    statusCamp -= 30;
                    huntersCount = 6;
                    enemiesCount -= 2;
                    isAttack = true;
                    radioGroupPrologueOldStoryAttackNorth.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                }
                isNorthFight = false;
                stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                getStatus();
            }
            buttonPrologueOldStoryAttackNorthSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isSecond = false;
        } else {
            buttonPrologueOldStoryAttackNorthFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackNorthSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackNorthThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
            isThird = false;
        }
    }

    public void onPrologueOldStoryAttackNorthThird(View view) {
        if (isThird) {
            if (isNorthFight) {
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_north_attack_signal);
                statusCamp -= 10;
                huntersCount = 6;
                enemiesCount -= 1;
                isAttack = true;
                radioGroupPrologueOldStoryAttackNorth.setVisibility(View.GONE);
                radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
            }
            isNorthFight = false;
            stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
            getStatus();
            isThird = false;
        } else {
            buttonPrologueOldStoryAttackNorthFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackNorthSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackNorthThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = false;
            isThird = true;
        }
    }


    public void onPrologueOldStoryAttackWestFirst(View view) {
        if (isFirst) {
            if (isStart) {
                textPrologueOldStoryAttackStart.setVisibility(View.GONE);
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_blade);
                textPrologueOldStoryAttackAction.setVisibility(View.VISIBLE);
                textPrologueOldStoryAttackStatus.setVisibility(View.VISIBLE);
                getStatus();
                buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_start_west_attack);
                buttonPrologueOldStoryAttackWestSecond.setVisibility(View.GONE);
                buttonPrologueOldStoryAttackWestThird.setVisibility(View.GONE);
                isStart = false;
                isAttackBlade = true;
            } else if (isAttackBlade) {
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_blade_attack);
                buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_west_attack_tent);
                buttonPrologueOldStoryAttackWestSecond.setText(R.string.prologue_old_story_attack_button_west_attack_camp);
                buttonPrologueOldStoryAttackWestSecond.setVisibility(View.VISIBLE);
                if (huntersCount > 1) {
                    buttonPrologueOldStoryAttackWestThird.setVisibility(View.VISIBLE);
                    buttonPrologueOldStoryAttackWestThird.setText(R.string.prologue_old_story_attack_button_west_attack_tent_hunters);
                }
                statusCamp -= 10;
                isAttackBlade = false;
                enemiesCount--;
                isBlade = true;
                isAttackTent = true;
                getStatus();
            } else if (isAttackBow) {
                if (huntersCount == 1) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_bow_attack);
                    statusCamp -= 26;
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_bow_attack_hunters);
                    statusCamp -= 10;
                }
                buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_west_attack_tent);
                buttonPrologueOldStoryAttackWestSecond.setText(R.string.prologue_old_story_attack_button_west_attack_camp);
                buttonPrologueOldStoryAttackWestSecond.setVisibility(View.VISIBLE);
                if (huntersCount > 1) {
                    buttonPrologueOldStoryAttackWestThird.setVisibility(View.VISIBLE);
                    buttonPrologueOldStoryAttackWestThird.setText(R.string.prologue_old_story_attack_button_west_attack_tent_hunters);
                }
                isAttackBow = false;
                isBow = true;
                isAttackTent = true;
                enemiesCount--;
                getStatus();
            } else if (isAttackForest) {
                buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_west_attack_tent);
                buttonPrologueOldStoryAttackWestSecond.setText(R.string.prologue_old_story_attack_button_west_attack_camp);
                buttonPrologueOldStoryAttackWestSecond.setVisibility(View.VISIBLE);
                if (huntersCount > 1) {
                    buttonPrologueOldStoryAttackWestThird.setVisibility(View.VISIBLE);
                    buttonPrologueOldStoryAttackWestThird.setText(R.string.prologue_old_story_attack_button_west_attack_tent_hunters);
                }
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_blade_attack);
                statusCamp -= 15;
                isAttackForest = false;
                isForest = true;
                isAttackTent = true;
                enemiesCount--;
                getStatus();
            } else if (isWestFight) {
                isAttack = true;
                isWestFight = false;
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_signal);
                radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                huntersCount = 6;
                stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                getStatus();
            } else if (isAttackTent) {
                if (huntersCount == 1) {
                    if (statusCamp < 80) {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_tent_attack_alone_fail);
                        enemiesCount -= 3;
                        radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                        radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                        huntersCount = 6;
                        stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                        getStatus();
                    } else {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_tent_attack_alone_fail);
                        enemiesCount -= 4;
                        radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                        radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                        huntersCount = 6;
                        stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                        getStatus();
                    }
                } else {
                    if ((statusCamp < 86 && huntersCount == 2) || huntersCount == 3) {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_tent_attack_fail);
                        enemiesCount = enemiesCount - (1 + huntersCount);
                        radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                        radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                        huntersCount = 6;
                        statusCamp -= 30;
                        stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                        getStatus();
                    } else {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_tent_attack_success);
                        enemiesCount = enemiesCount - (3 + huntersCount);
                        radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                        radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                        huntersCount = 6;
                        stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                        getStatus();
                    }
                    stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                    getStatus();
                }

                isAttackTent = false;
            }
            isFirst = false;
            buttonPrologueOldStoryAttackWestFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryAttackWestFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackWestSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackWestThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
            isThird = false;
        }
    }

    public void onPrologueOldStoryAttackWestSecond(View view) {
        if (isSecond) {
            if (isStart) {
                textPrologueOldStoryAttackStart.setVisibility(View.GONE);
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_bow);
                textPrologueOldStoryAttackAction.setVisibility(View.VISIBLE);
                textPrologueOldStoryAttackStatus.setVisibility(View.VISIBLE);
                getStatus();
                buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_start_west_attack);
                buttonPrologueOldStoryAttackWestSecond.setVisibility(View.GONE);
                buttonPrologueOldStoryAttackWestThird.setVisibility(View.GONE);
                isStart = false;
                isAttackBow = true;
            } else if (isAttackTent) {
                enemiesCount -= huntersCount;
                statusCamp -= 10;
                if (huntersCount == 1) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_alone);
                    isAttack = true;
                    huntersCount = 6;
                    radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                    stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack);
                    buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_west_attack_signal);
                    buttonPrologueOldStoryAttackWestSecond.setText(R.string.prologue_old_story_attack_button_west_attack_fight);
                    buttonPrologueOldStoryAttackWestThird.setVisibility(View.GONE);
                    isWestFight = true;
                }
                getStatus();
                isAttackTent = false;
            } else if (isWestFight) {
                if (huntersCount == 2) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_fight_fail);
                    huntersCount--;
                    statusCamp -= 20;
                    isAttack = true;
                    huntersCount = 5;
                    radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_fight);
                    statusCamp -= 20;
                    isAttack = true;
                    huntersCount = 6;
                    radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                }
                stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
                getStatus();
                isWestFight = false;
            }
            buttonPrologueOldStoryAttackWestSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            isSecond = false;
        } else {
            buttonPrologueOldStoryAttackWestFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackWestSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackWestThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
            isThird = false;
        }
    }

    public void onPrologueOldStoryAttackWestThird(View view) {
        if (isThird) {
            if (isStart) {
                textPrologueOldStoryAttackStart.setVisibility(View.GONE);
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_forest_attack);
                textPrologueOldStoryAttackAction.setVisibility(View.VISIBLE);
                textPrologueOldStoryAttackStatus.setVisibility(View.VISIBLE);
                getStatus();
                buttonPrologueOldStoryAttackWestFirst.setText(R.string.prologue_old_story_attack_button_start_west_attack);
                buttonPrologueOldStoryAttackWestSecond.setVisibility(View.GONE);
                buttonPrologueOldStoryAttackWestThird.setVisibility(View.GONE);
                isStart = false;
                isAttackForest = true;
            } else if (isAttackTent) {
                if (huntersCount == 2 && statusCamp < 86) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_tent_fail);
                    huntersCount = 5;
                    enemiesCount -= 4;
                    radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_west_attack_tent_success);
                    huntersCount = 6;
                    enemiesCount -= 4;
                    radioGroupPrologueOldStoryAttackWest.setVisibility(View.GONE);
                    radioGroupPrologueOldStoryAttackMain.setVisibility(View.VISIBLE);
                }
            }
            stormtroopers = getString(R.string.prologue_old_story_attack_text_status_stormtroopers);
            getStatus();
            buttonPrologueOldStoryAttackWestThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isThird = false;
        } else {
            buttonPrologueOldStoryAttackWestFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackWestSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackWestThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = false;
            isSecond = false;
            isThird = true;
        }
    }

    public void onPrologueOldStoryAttackMainFirst(View view) {
        if (isFirst) {
            if (isAttack) {
                textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_start);
                isAttack = false;
                if (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0) < 3) {
                    enemiesCount -= 2;
                } else if (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0) < 5) {
                    if (statusCamp > 60) {
                        enemiesCount = enemiesCount - (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0));
                    } else {
                        enemiesCount = enemiesCount - (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0) + 1);
                    }
                } else if (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0) == 5) {
                    if (statusCamp > 60) {
                        enemiesCount = enemiesCount - (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0) + 1);
                    } else {
                        enemiesCount = enemiesCount - (6 - save.getInt(APP_SAVE_PROLOGUE_OLD_STORY_HUNTERS, 0) + 2);
                    }
                }
                buttonPrologueOldStoryAttackMainFirst.setText(R.string.prologue_old_story_attack_button_main_attack_field);
                buttonPrologueOldStoryAttackMainSecond.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryAttackMainThird.setVisibility(View.VISIBLE);
                isMainFight = true;
                getStatus();
            } else if (isMainFight) {
                if (statusCamp <= 60) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_field_fail);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_field_success);
                }
                if (enemiesCount > 14) {
                    huntersCount--;
                }
                buttonPrologueOldStoryAttackMainFirst.setText(R.string.prologue_old_story_attack_button_main_attack_field_next);
                buttonPrologueOldStoryAttackMainSecond.setText(R.string.prologue_old_story_attack_button_main_attack_attack_next);
                buttonPrologueOldStoryAttackMainSecond.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryAttackMainThird.setVisibility(View.GONE);
                enemiesCount--;
                isMainFight = false;
                isMainNext = true;
                getStatus();
            } else if (isMainNext) {
                textPrologueOldStoryAttackAction.setVisibility(View.GONE);
                textPrologueOldStoryAttackStatus.setVisibility(View.GONE);
                textPrologueOldStoryAttackStart.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryAttackMainFirst.setText(R.string.prologue_old_story_attack_button_final);
                buttonPrologueOldStoryAttackMainSecond.setVisibility(View.GONE);
                isMainNext = false;
                isExit = true;
                if (huntersCount == 6 && enemiesCount < 8) {
                    textPrologueOldStoryAttackStart.setText(R.string.prologue_old_story_attack_good);
                } else {
                    textPrologueOldStoryAttackStart.setText(R.string.prologue_old_story_attack_normal_one);
                }
            } else if (isExit) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            buttonPrologueOldStoryAttackMainFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
        } else {
            buttonPrologueOldStoryAttackMainFirst.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackMainSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackMainThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = true;
            isSecond = false;
            isThird = false;
        }
    }

    public void onPrologueOldStoryAttackMainSecond(View view) {
        if (isSecond) {
            if (isMainFight) {
                if (enemiesCount > 12) {
                    if (statusCamp <= 60) {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_attack_fail_success);
                        huntersCount--;
                        enemiesCount--;
                    } else {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_attack_fail_fail);
                        huntersCount--;
                        enemiesCount--;
                    }
                } else {
                    if (statusCamp <= 60) {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_attack_success_success);
                        enemiesCount -= 2;
                    } else {
                        textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_attack_success_fail);
                        enemiesCount -= 2;
                    }
                }
                buttonPrologueOldStoryAttackMainFirst.setText(R.string.prologue_old_story_attack_button_main_attack_field_next);
                buttonPrologueOldStoryAttackMainSecond.setText(R.string.prologue_old_story_attack_button_main_attack_attack_next);
                buttonPrologueOldStoryAttackMainSecond.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryAttackMainThird.setVisibility(View.GONE);
                isMainFight = false;
                isMainNext = true;
                getStatus();
            } else if (isMainNext) {
                textPrologueOldStoryAttackAction.setVisibility(View.GONE);
                textPrologueOldStoryAttackStatus.setVisibility(View.GONE);
                textPrologueOldStoryAttackStart.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryAttackMainFirst.setText(R.string.prologue_old_story_attack_button_final);
                buttonPrologueOldStoryAttackMainSecond.setVisibility(View.GONE);
                isMainNext = false;
                isExit = true;
                if (huntersCount < 6 && enemiesCount > 8) {
                    textPrologueOldStoryAttackStart.setText(R.string.prologue_old_story_attack_bad);
                } else {
                    textPrologueOldStoryAttackStart.setText(R.string.prologue_old_story_attack_normal_two);
                }
            }
            isSecond = false;
            buttonPrologueOldStoryAttackMainSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonPrologueOldStoryAttackMainFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackMainSecond.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonPrologueOldStoryAttackMainThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isFirst = false;
            isSecond = true;
            isThird = false;
        }
    }

    public void onPrologueOldStoryAttackMainThird(View view) {
        if (isThird) {
            if (isMainFight) {
                if (statusCamp <= 60) {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_leader_success);
                } else {
                    textPrologueOldStoryAttackAction.setText(R.string.prologue_old_story_attack_text_main_attack_leader_fail);
                }
                buttonPrologueOldStoryAttackMainFirst.setText(R.string.prologue_old_story_attack_button_main_attack_field_next);
                buttonPrologueOldStoryAttackMainSecond.setText(R.string.prologue_old_story_attack_button_main_attack_attack_next);
                buttonPrologueOldStoryAttackMainSecond.setVisibility(View.VISIBLE);
                buttonPrologueOldStoryAttackMainThird.setVisibility(View.GONE);
                huntersCount--;
                isMainFight = false;
                isMainNext = true;
                getStatus();
            }
            buttonPrologueOldStoryAttackMainThird.setBackgroundColor(Color.parseColor("#60ffffff"));
            isThird = false;
        } else {
            buttonPrologueOldStoryAttackMainFirst.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackMainSecond.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonPrologueOldStoryAttackMainThird.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFirst = false;
            isSecond = false;
            isThird = true;
        }
    }

    public void getStatus() {
        if (statusCamp > 75) {
            camp = getString(R.string.prologue_old_story_attack_text_status_camp_calm);
        } else if (statusCamp > 60) {
            camp = getString(R.string.prologue_old_story_attack_text_status_camp_alarmed);
        } else {
            camp = getString(R.string.prologue_old_story_attack_text_status_camp_ready);
        }
        textPrologueOldStoryAttackStatus.setText(getString(R.string.prologue_old_story_attack_text_status,
                statusMessage,
                enemiesCount,
                huntersCount,
                camp,
                stormtroopers));
    }
}
