package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstDisturbance;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueHuntingLodgeInside extends GameActivity {

    public static final String APP_SAVE = "Save";
    public static final String APP_SAVE_LEVEL = "Level";
    public static final String APP_SAVE_FORTUNE = "Fortune";
    private static final String APP_SAVE_PROLOGUE_HUNTING_WINDOW = "Window";
    private static final String APP_SAVE_PROLOGUE_HUNTING_KNIFE = "Knife bedside";
    private static final String APP_SAVE_PROLOGUE_HUNTING_SLEEPING_BUG = "Extra sleeping bug";
    private static final String APP_SAVE_PROLOGUE_HUNTING_FOOD = "Food hunting lodge";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    private static final String APP_SAVE_PROLOGUE_DIARY = "Diary";

    private RadioGroup radioGroupHuntingLodgeInside;
    private RadioGroup radioGroupHuntingLodgeInsideTable;
    private RadioGroup radioGroupHuntingLodgeInsideBedside;
    private RadioGroup radioGroupHuntingLodgeInsideConserve;
    private RadioGroup radioGroupHuntingLodgeInsideCupboard;

    private RadioButton radioButtonTableHuntingInside;
    private RadioButton radioButtonCupboardHuntingInside;
    private RadioButton radioButtonBedsideTableHuntingInside;
    private RadioButton radioButtonConserveHuntingInside;
    private RadioButton radioButtonConserveLuckHuntingInside;
    private RadioButton radioButtonConserveNoLuckHuntingInside;
    private RadioButton radioButtonTableKeyHuntingInside;
    private RadioButton radioButtonTableNoKeyHuntingInside;
    private RadioButton radioButtonCupboardSleepingBugHuntingInside;
    private RadioButton radioButtonCupboardNoSleepingBugHuntingInside;
    private RadioButton radioButtonBedsideKeyHuntingInside;
    private RadioButton radioButtonBedsideLuckHuntingInside;
    private RadioButton radioButtonBedsideNoLuckHuntingInside;
    private RadioButton radioButtonBedsideBackHuntingInside;

    private CheckBox checkBoxHuntingLodgeInsideFood;
    private CheckBox checkBoxHuntingLodgeInsideKnife;
    private CheckBox checkBoxHuntingLodgeInsideOintment;
    private CheckBox checkBoxHuntingLodgeInsideBox;

    private Button buttonHuntingLodgeSleeping;

    private LinearLayout linearBoxHuntingLodgeInside;

    private ConstraintLayout constraintLayoutPrologueHuntingInside;

    private ScrollView scrollHuntingLodgeInside;

    private TextView huntingLodgeInsideText;

    private boolean isConserve;
    private boolean isConserveButton;
    private boolean isTable;
    private boolean isTableButton;
    private boolean isTableKey;
    private boolean isTableNoKey;
    private boolean isCupboard;
    private boolean isCupboardButton;
    private boolean isCupboardSleepingBug;
    private boolean isCupboardNoSleepingBug;
    private boolean isBedsideTable;
    private boolean isBedsideTableButton;
    private boolean isBedsideTableKey;
    private boolean isBedsideTableLuck;
    private boolean isBedsideTableNoLuck;
    private boolean isBedsideTableBack;
    private boolean isConserveLuck;
    private boolean isConserveNoLuck;
    private boolean isKey;
    private boolean isKnifeBedSide;
    private boolean isFood;
    private boolean isExtraSleepingBug;
    private boolean isOintment;

    protected float level;

    protected SharedPreferences save;
    protected Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_inside);

        stopService(new Intent(this, OstWood.class));
        startService(new Intent(this, OstDisturbance.class));
        isOstDisturbance = true;

        level = 1.12f;
        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        isFaim = true;

        constraintLayoutPrologueHuntingInside = (ConstraintLayout) findViewById(R.id.constraintLayoutPrologueHuntingInsideID);

        radioGroupHuntingLodgeInside = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeInsideID);
        radioGroupHuntingLodgeInsideConserve = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeInsideConserveID);
        radioGroupHuntingLodgeInsideConserve.setVisibility(View.GONE);
        radioGroupHuntingLodgeInsideTable = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeInsideTableID);
        radioGroupHuntingLodgeInsideTable.setVisibility(View.GONE);
        radioGroupHuntingLodgeInsideCupboard = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeInsideCupboardID);
        radioGroupHuntingLodgeInsideCupboard.setVisibility(View.GONE);
        radioGroupHuntingLodgeInsideBedside = (RadioGroup) findViewById(R.id.radioGroupHuntingLodgeInsideBedsideID);
        radioGroupHuntingLodgeInsideBedside.setVisibility(View.GONE);

        checkBoxHuntingLodgeInsideFood = (CheckBox) findViewById(R.id.checkBoxHuntingLodgeInsideFoodID);
        checkBoxHuntingLodgeInsideFood.setTextSize(sizeFonts);
        checkBoxHuntingLodgeInsideKnife = (CheckBox) findViewById(R.id.checkBoxHuntingLodgeInsideKnifeID);
        checkBoxHuntingLodgeInsideKnife.setTextSize(sizeFonts);
        checkBoxHuntingLodgeInsideOintment = (CheckBox) findViewById(R.id.checkBoxHuntingLodgeInsideOintmentID);
        checkBoxHuntingLodgeInsideOintment.setTextSize(sizeFonts);
        checkBoxHuntingLodgeInsideBox = (CheckBox) findViewById(R.id.checkBoxHuntingLodgeInsideBoxID);
        checkBoxHuntingLodgeInsideBox.setTextSize(sizeFonts);

        linearBoxHuntingLodgeInside = (LinearLayout) findViewById(R.id.linearBoxHuntingLodgeInsideID);
        linearBoxHuntingLodgeInside.setVisibility(View.GONE);

        radioButtonTableHuntingInside = (RadioButton) findViewById(R.id.radioButtonTableHuntingInsideID);
        radioButtonTableHuntingInside.setTextSize(sizeFonts);
        radioButtonCupboardHuntingInside = (RadioButton) findViewById(R.id.radioButtonCupboardHuntingInsideID);
        radioButtonCupboardHuntingInside.setTextSize(sizeFonts);
        radioButtonBedsideTableHuntingInside = (RadioButton) findViewById(R.id.radioButtonBedsideTableHuntingInsideID);
        radioButtonBedsideTableHuntingInside.setTextSize(sizeFonts);
        radioButtonConserveHuntingInside = (RadioButton) findViewById(R.id.radioButtonConserveHuntingInsideID);
        radioButtonConserveHuntingInside.setTextSize(sizeFonts);
        radioButtonConserveHuntingInside.setVisibility(View.GONE);
        radioButtonConserveLuckHuntingInside = (RadioButton) findViewById(R.id.radioButtonConserveLuckHuntingInsideID);
        radioButtonConserveLuckHuntingInside.setTextSize(sizeFonts);
        radioButtonConserveNoLuckHuntingInside = (RadioButton) findViewById(R.id.radioButtonConserveNoLuckHuntingInsideID);
        radioButtonConserveNoLuckHuntingInside.setTextSize(sizeFonts);
        radioButtonTableKeyHuntingInside = (RadioButton) findViewById(R.id.radioButtonTableKeyHuntingInsideID);
        radioButtonTableKeyHuntingInside.setTextSize(sizeFonts);
        radioButtonTableNoKeyHuntingInside = (RadioButton) findViewById(R.id.radioButtonTableNoKeyHuntingInsideID);
        radioButtonTableNoKeyHuntingInside.setTextSize(sizeFonts);
        radioButtonCupboardSleepingBugHuntingInside = (RadioButton) findViewById(R.id.radioButtonCupboardSleepingBugHuntingInsideID);
        radioButtonCupboardSleepingBugHuntingInside.setTextSize(sizeFonts);
        radioButtonCupboardNoSleepingBugHuntingInside = (RadioButton) findViewById(R.id.radioButtonCupboardNoSleepingBugHuntingInsideID);
        radioButtonCupboardNoSleepingBugHuntingInside.setTextSize(sizeFonts);
        radioButtonBedsideKeyHuntingInside = (RadioButton) findViewById(R.id.radioButtonBedsideKeyHuntingInsideID);
        radioButtonBedsideKeyHuntingInside.setTextSize(sizeFonts);
        radioButtonBedsideKeyHuntingInside.setVisibility(View.GONE);
        radioButtonBedsideLuckHuntingInside = (RadioButton) findViewById(R.id.radioButtonBedsideLuckHuntingInsideID);
        radioButtonBedsideLuckHuntingInside.setTextSize(sizeFonts);
        radioButtonBedsideNoLuckHuntingInside = (RadioButton) findViewById(R.id.radioButtonBedsideNoLuckHuntingInsideID);
        radioButtonBedsideNoLuckHuntingInside.setTextSize(sizeFonts);
        radioButtonBedsideBackHuntingInside = (RadioButton) findViewById(R.id.radioButtonBedsideBackHuntingInsideID);
        radioButtonBedsideBackHuntingInside.setTextSize(sizeFonts);

        buttonHuntingLodgeSleeping = (Button) findViewById(R.id.buttonHuntingLodgeSleepingID);
        buttonHuntingLodgeSleeping.setTextSize(sizeFonts);

        scrollHuntingLodgeInside = (ScrollView) findViewById(R.id.scrollHuntingLodgeInsideID);
        sScroll(scrollHuntingLodgeInside);

        huntingLodgeInsideText = (TextView) findViewById(R.id.huntingLodgeInsideTextID);
        sText(huntingLodgeInsideText);
        huntingLodgeInsideText.setBackgroundColor(Color.parseColor("#"+backgroundCounter + "ffffff"));

        if (save.getInt(APP_SAVE_TREATMENT, 0) == 0) {
            checkBoxHuntingLodgeInsideOintment.setVisibility(View.GONE);
        }

        if (save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
            radioButtonConserveHuntingInside.setVisibility(View.VISIBLE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_next_window);
        } else {
            isConserveButton = true;
        }

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        getInterface(true);
        textMessage.setText(R.string.hunting_Lodge_inside_message_sleeping_bug);


        startAnimation(new ArrayList<View>(Arrays.asList(scrollHuntingLodgeInside, radioGroupHuntingLodgeInside, buttonMenu)));

        constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_first_background);
    }

    public void onConserveHuntingInside(View view) {
        if (isConserve) {
            refreshScroll(scrollHuntingLodgeInside);
            foodCounterMain++;
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_check_conserve);
            radioGroupHuntingLodgeInside.setVisibility(View.GONE);
            radioGroupHuntingLodgeInsideConserve.setVisibility(View.VISIBLE);
        }
        radioButtonTableHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonCupboardHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideTableHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonConserveHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isConserve = true;
        isBedsideTable = false;
        isCupboard = false;
        isTable = false;
    }

    public void onTableHuntingInside(View view) {
        if (isTable) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInsideTable.setVisibility(View.VISIBLE);
            radioGroupHuntingLodgeInside.setVisibility(View.GONE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_check_table);
        }
        radioButtonTableHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonCupboardHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideTableHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonConserveHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isConserve = false;
        isBedsideTable = false;
        isCupboard = false;
        isTable = true;
    }

    public void onTableKeyHuntingInside(View view) {
        if (isTableKey) {
            refreshScroll(scrollHuntingLodgeInside);
            isKey = true;
            radioGroupHuntingLodgeInsideTable.setVisibility(View.GONE);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            radioButtonTableHuntingInside.setVisibility(View.GONE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_second);
            textMessage.setText(R.string.hunting_Lodge_inside_message_key);
            showMessage(textMessage, false);

            isTableButton = true;
            if (isBedsideTableButton && isCupboardButton && isConserveButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);

            }
        }
        radioButtonTableKeyHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonTableNoKeyHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTableKey = true;
        isTableNoKey = false;
    }

    public void onTableNoKeyHuntingInside(View view) {
        if (isTableNoKey) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInsideTable.setVisibility(View.GONE);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            radioButtonTableHuntingInside.setVisibility(View.GONE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_second);
            isTableButton = true;
            if (isBedsideTableButton && isCupboardButton && isConserveButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);

            }
        }
        radioButtonTableKeyHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonTableNoKeyHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isTableKey = false;
        isTableNoKey = true;
    }

    public void onConserveLuckHuntingInside(View view) {
        if (isConserveLuck) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInsideConserve.setVisibility(View.GONE);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_second);
            if (Fortune.isLuck(fortune, 80)) {
                foodCounterMain++;
                getLuckImage(true);
                textMessage.setText(R.string.hunting_Lodge_inside_button_conserve_victory);
                showMessage(textMessage, false);
                fortune -= 10;
            } else {
                getLuckImage(false);
                textMessage.setText(R.string.hunting_Lodge_inside_button_conserve_fail);
                showMessage(textMessage, false);
                fortune += 10;
            }
            radioButtonConserveHuntingInside.setVisibility(View.GONE);
            isConserveButton = true;
            if (isBedsideTableButton && isCupboardButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);


            }
        }
        radioButtonConserveLuckHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonConserveNoLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isConserveLuck = true;
        isConserveNoLuck = false;
    }

    public void onConserveNoLuckHuntingInside(View view) {
        if (isConserveNoLuck) {
            refreshScroll(scrollHuntingLodgeInside);
            foodCounterMain++;
            radioGroupHuntingLodgeInsideConserve.setVisibility(View.GONE);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_second);
            fortune += 10;
            radioButtonConserveHuntingInside.setVisibility(View.GONE);
            isConserveButton = true;
            if (isBedsideTableButton && isCupboardButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);
            }
        }
        radioButtonConserveLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonConserveNoLuckHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isConserveLuck = false;
        isConserveNoLuck = true;
    }

    public void onCupboardHuntingInside(View view) {
        if (isCupboard) {
            refreshScroll(scrollHuntingLodgeInside);
            if (save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false)) {
                radioGroupHuntingLodgeInsideCupboard.setVisibility(View.VISIBLE);
                radioGroupHuntingLodgeInside.setVisibility(View.GONE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_check_cupboard);
            } else {
                radioGroupHuntingLodgeInsideCupboard.setVisibility(View.VISIBLE);
                radioGroupHuntingLodgeInside.setVisibility(View.GONE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_check_cupboard);
                radioButtonCupboardNoSleepingBugHuntingInside.setVisibility(View.GONE);
            }
        }
        radioButtonTableHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonCupboardHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonBedsideTableHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonConserveHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isConserve = false;
        isBedsideTable = false;
        isCupboard = true;
        isTable = false;
    }

    public void onCupboardSleepingBugHuntingInside(View view) {
        if (isCupboardSleepingBug) {
            refreshScroll(scrollHuntingLodgeInside);
            isSleepingBugMain = true;
            if (save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false)) {
                isExtraSleepingBug = true;
            }
            radioGroupHuntingLodgeInsideCupboard.setVisibility(View.GONE);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_second);
            radioButtonCupboardHuntingInside.setVisibility(View.GONE);
            textMessage.setText(R.string.hunting_Lodge_inside_message_sleeping_bug);
            showMessage(textMessage, false);
            isCupboardButton = true;
            if (isBedsideTableButton && isConserveButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);

            }
        }
        radioButtonCupboardSleepingBugHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonCupboardNoSleepingBugHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isCupboardSleepingBug = true;
        isCupboardNoSleepingBug = false;
    }

    public void onCupboardNoSleepingBugHuntingInside(View view) {
        if (isCupboardNoSleepingBug) {
            refreshScroll(scrollHuntingLodgeInside);
            isSleepingBugMain = true;
            radioGroupHuntingLodgeInsideCupboard.setVisibility(View.GONE);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_second);
            radioButtonCupboardHuntingInside.setVisibility(View.GONE);
            isCupboardButton = true;
            if (isBedsideTableButton && isConserveButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);

            }
        }
        radioButtonCupboardSleepingBugHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonCupboardNoSleepingBugHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isCupboardSleepingBug = false;
        isCupboardNoSleepingBug = true;
    }

    public void onBedsideTableHuntingInside(View view) {
        if (isBedsideTable) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInside.setVisibility(View.GONE);
            radioGroupHuntingLodgeInsideBedside.setVisibility(View.VISIBLE);
            if (save.getBoolean(APP_SAVE_PROLOGUE_DIARY, false)) {
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_check_bedside_diary);
            } else {
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_check_bedside);
            }
            if (isKey) {
                radioButtonBedsideKeyHuntingInside.setVisibility(View.VISIBLE);
            }
        }
        radioButtonTableHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonCupboardHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideTableHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonConserveHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isConserve = false;
        isBedsideTable = true;
        isCupboard = false;
        isTable = false;
    }

    public void onBedsideKeyHuntingInside(View view) {
        if (isBedsideTableKey) {
            refreshScroll(scrollHuntingLodgeInside);
            isKnifeMain = true;
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            radioGroupHuntingLodgeInsideBedside.setVisibility(View.GONE);
            radioButtonBedsideTableHuntingInside.setVisibility(View.GONE);
            textMessage.setText(R.string.hunting_Lodge_inside_button_bedside_get_knife);
            showMessage(textMessage, false);
            isBedsideTableButton = true;
            if (isCupboardButton && isConserveButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);
            }
        }
        radioButtonBedsideKeyHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonBedsideLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideNoLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideBackHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isBedsideTableKey = true;
        isBedsideTableLuck = false;
        isBedsideTableNoLuck = false;
        isBedsideTableBack = false;
    }

    public void onBedsideLuckHuntingInside(View view) {
        if (isBedsideTableLuck) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            radioGroupHuntingLodgeInsideBedside.setVisibility(View.GONE);
            radioButtonBedsideTableHuntingInside.setVisibility(View.GONE);
            if (Fortune.isLuck(fortune, 80)) {
                isKnifeMain = true;
                getLuckImage(true);
                textMessage.setText(R.string.hunting_Lodge_inside_button_bedside_get_knife_luck);
                showMessage(textMessage, false);
                fortune -= 10;
            } else {
                getLuckImage(false);
                textMessage.setText(R.string.hunting_Lodge_inside_button_bedside_fail);
                showMessage(textMessage, false);
                fortune += 10;
            }
            radioButtonBedsideLuckHuntingInside.setVisibility(View.GONE);
            isBedsideTableButton = true;
            if (isCupboardButton && isConserveButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);
            }
        }
        radioButtonBedsideKeyHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideLuckHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonBedsideNoLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideBackHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isBedsideTableKey = false;
        isBedsideTableLuck = true;
        isBedsideTableNoLuck = false;
        isBedsideTableBack = false;
    }

    public void onBedsideNoLuckHuntingInside(View view) {
        if (isBedsideTableNoLuck) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            radioGroupHuntingLodgeInsideBedside.setVisibility(View.GONE);
            radioButtonBedsideTableHuntingInside.setVisibility(View.GONE);
            isBedsideTableButton = true;
            if (isCupboardButton && isConserveButton && isTableButton) {
                linearBoxHuntingLodgeInside.setVisibility(View.VISIBLE);
                huntingLodgeInsideText.setText(R.string.hunting_Lodge_inside_text_preparation_sleep);
                if (!isKnifeMain) {
                    checkBoxHuntingLodgeInsideKnife.setVisibility(View.GONE);
                }
                if (!save.getBoolean(APP_SAVE_PROLOGUE_HUNTING_WINDOW, false)) {
                    checkBoxHuntingLodgeInsideFood.setVisibility(View.GONE);
                }
                constraintLayoutPrologueHuntingInside.setBackgroundResource(R.drawable.prologue_huntinh_lodge_inside_second_background);
            }
        }
        radioButtonBedsideKeyHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideNoLuckHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        radioButtonBedsideBackHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        isBedsideTableKey = false;
        isBedsideTableLuck = false;
        isBedsideTableNoLuck = true;
        isBedsideTableBack = false;
    }

    public void onBedsideBackHuntingInside(View view) {
        if (isBedsideTableBack) {
            refreshScroll(scrollHuntingLodgeInside);
            radioGroupHuntingLodgeInside.setVisibility(View.VISIBLE);
            radioGroupHuntingLodgeInsideBedside.setVisibility(View.GONE);
        }
        radioButtonBedsideKeyHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideNoLuckHuntingInside.setBackgroundColor(Color.parseColor("#60ffffff"));
        radioButtonBedsideBackHuntingInside.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isBedsideTableKey = false;
        isBedsideTableLuck = false;
        isBedsideTableNoLuck = false;
        isBedsideTableBack = true;
    }

    public void onHuntingLodgeSleep(View view) {
        if (checkBoxHuntingLodgeInsideFood.isChecked()) {
            foodCounterMain--;
            isFood = true;
            isFaim = false;
        } else {
            isFaim = true;
        }


        if (checkBoxHuntingLodgeInsideKnife.isChecked()) {
            isKnifeBedSide = true;
        }
        if (save.getInt(APP_SAVE_TREATMENT, 0) > 0) {
            checkBoxHuntingLodgeInsideOintment.setVisibility(View.VISIBLE);
            if (checkBoxHuntingLodgeInsideOintment.isChecked()) {
                isOintment = true;
                wound--;
                treatmentCounterMain--;
            }
        }
        SharedPreferences.Editor editor = save.edit();
        editor.putInt(APP_SAVE_FOOD, foodCounterMain);
        editor.putInt(APP_SAVE_TREATMENT, treatmentCounterMain);
        editor.putInt(APP_SAVE_FORTUNE, fortune);
        editor.putBoolean(APP_SAVE_KNIFE, isKnifeMain);
        editor.putBoolean(APP_SAVE_PROLOGUE_HUNTING_KNIFE, isKnifeBedSide);
        editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, isSleepingBugMain);
        editor.putBoolean(APP_SAVE_PROLOGUE_HUNTING_SLEEPING_BUG, isExtraSleepingBug);
        editor.putBoolean(APP_SAVE_PROLOGUE_HUNTING_FOOD, isFood);
        editor.putInt(APP_SAVE_WOUND, wound);
        editor.putBoolean(APP_SAVE_FAIM, isFaim);
        editor.apply();
        if (checkBoxHuntingLodgeInsideBox.isChecked()) {
            getNextScene(new Intent(this, PrologueBox.class));
            finish();
        } else {
            Intent intent = new Intent(this, PrologueHuntingLodgeCutScene.class);
            getNextScene(intent);
            overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
            finish();
        }
    }
}
