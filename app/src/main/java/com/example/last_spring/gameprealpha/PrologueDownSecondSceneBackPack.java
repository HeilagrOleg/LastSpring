package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueDownSecondSceneBackPack extends GameActivity {

    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_KNIFE = "Knife";
    private static final String APP_SAVE_RAINCOAT = "Raincoat";
    private static final String APP_SAVE_OINTMENT = "Ointment";
    private static final String APP_SAVE_FORTUNE = "Fortune";
    private static final String APP_SAVE_LEVEL = "Level";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";

    private Button prologueBackpackNextButton;

    private RadioGroup prologueDownBackPackMainRadioGroup;
    private RadioGroup prologueDownBackpackTopPartRadioGroup;
    private RadioGroup prologueDownBackpackMiddlePartRadioGroup;
    private RadioGroup prologueDownBackpackBasementPartRadioGroup;
    private RadioGroup prologueDownBackpackAdditionalPartRadioGroup;

    private RadioButton topBackpackButton;
    private RadioButton topBackpackKnifeButton;
    private RadioButton topBackpackKnifeLuckButton;
    private RadioButton topBackpackNoKnifeButton;
    private RadioButton topBackpackBackButton;
    private RadioButton middleBackPackButton;
    private RadioButton middleBackPackSleepingBugButton;
    private RadioButton middleBackPackSleepingBugLuckButton;
    private RadioButton middleBackPackNoSleepingBugButton;
    private RadioButton middleBackPackBackButton;
    private RadioButton basementBackpackButton;
    private RadioButton basementBackpackRaincoatButton;
    private RadioButton basementBackpackRaincoatLuckButton;
    private RadioButton basementBackpackNoRaincoatButton;
    private RadioButton basementBackpackBackButton;
    private RadioButton additionalBackpackButton;
    private RadioButton additionalBackpackOintmentButton;
    private RadioButton additionalBackpackOintmentLuckButton;
    private RadioButton additionalBackpackNoOintmentButton;
    private RadioButton additionalBackpackBackButton;

    private FrameLayout linearLayoutBackpack;

    private ScrollView scrollBackpack;

    private TextView fortuneCounter;
    private TextView prologueCutBackpack;

    protected float level;

    private String stFortune;

    private boolean isTopBackpack;
    private boolean isTopBackpackKnife;
    private boolean isTopBackpackKnifeLuck;
    private boolean isTopBackpackNoKnife;
    private boolean isTopBackpackBack;
    private boolean isMiddleBackPack;
    private boolean isMiddleBackPackSleepingBug;
    private boolean isMiddleBackPackSleepingBugLuck;
    private boolean isMiddleBackPackNoSleepingBug;
    private boolean isMiddleBackPackBack;
    private boolean isBasementBackpack;
    private boolean isBasementBackpackRaincoat;
    private boolean isBasementBackpackRaincoatLuck;
    private boolean isBasementBackpackNoRaincoat;
    private boolean isBasementBackpackBack;
    private boolean isAdditionalBackpack;
    private boolean isAdditionalBackpackOintment;
    private boolean isAdditionalBackpackOintmentLuck;
    private boolean isAdditionalBackpackNoOintment;
    private boolean isAdditionalBackpackBack;
    private boolean isSleepingBug;
    private boolean isOintment;
    private boolean isRaincoat;
    private boolean isKnife;
    private boolean isTop;
    private boolean isMiddle;
    private boolean isBasement;
    private boolean isAdditional;

    private SharedPreferences save;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_down_second_scene_back_pack);

        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);
        isSleepingBug = save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false);
        level = 2.12f;
        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();

        startService(new Intent(this, OstWood.class));
        isOstWood = true;
        stFortune = "Test";
        fortuneCounter = (TextView) findViewById(R.id.fortuneCounterID);
        fortuneCounter.setText(stFortune);
        fortuneCounter.setTextSize(sizeFonts);
        fortuneCounter.setBackgroundColor(Color.parseColor("#303030"));
        fortuneCounter.setVisibility(View.GONE);

        prologueBackpackNextButton = (Button) findViewById(R.id.prologueCutBackpackNextButtonID);
        prologueBackpackNextButton.setVisibility(View.GONE);

        linearLayoutBackpack = (FrameLayout) findViewById(R.id.linearLayoutBackpackID);
        scrollBackpack = (ScrollView) findViewById(R.id.scrollBackpackID);

        prologueCutBackpack = (TextView) findViewById(R.id.prologueCutBackpackID);
        prologueCutBackpack.setTextSize(sizeFonts);

        prologueDownBackPackMainRadioGroup = (RadioGroup) findViewById(R.id.prologueDownBackPackMainRadioGroupID);
        prologueDownBackpackTopPartRadioGroup = (RadioGroup) findViewById(R.id.prologueDownBackpackTopPartRadioGroupID);
        prologueDownBackpackTopPartRadioGroup.setVisibility(View.GONE);
        prologueDownBackpackMiddlePartRadioGroup = (RadioGroup) findViewById(R.id.prologueDownBackpackMiddlePartRadioGroupID);
        prologueDownBackpackMiddlePartRadioGroup.setVisibility(View.GONE);
        prologueDownBackpackBasementPartRadioGroup = (RadioGroup) findViewById(R.id.prologueDownBackpackBasementPartRadioGroupID);
        prologueDownBackpackBasementPartRadioGroup.setVisibility(View.GONE);
        prologueDownBackpackAdditionalPartRadioGroup = (RadioGroup) findViewById(R.id.prologueDownBackpackAdditionalPartRadioGroupID);
        prologueDownBackpackAdditionalPartRadioGroup.setVisibility(View.GONE);

        topBackpackButton = (RadioButton) findViewById(R.id.buttonBackpackOpenTopPartID);
        topBackpackButton.setTextSize(sizeFonts);
        topBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackButton = (RadioButton) findViewById(R.id.buttonBackpackOpenMiddlePartID);
        middleBackPackButton.setTextSize(sizeFonts);
        middleBackPackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackButton = (RadioButton) findViewById(R.id.buttonBackpackBasementPartID);
        basementBackpackButton.setTextSize(sizeFonts);
        basementBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackButton = (RadioButton) findViewById(R.id.buttonBackpackAdditionalPartID);
        additionalBackpackButton.setTextSize(sizeFonts);
        additionalBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));

        topBackpackKnifeButton = (RadioButton) findViewById(R.id.topBackpackKnifeButtonID);
        topBackpackKnifeButton.setTextSize(sizeFonts);
        topBackpackKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackKnifeLuckButton = (RadioButton) findViewById(R.id.topBackpackKnifeLuckButtonID);
        topBackpackKnifeLuckButton.setTextSize(sizeFonts);
        topBackpackKnifeLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackNoKnifeButton = (RadioButton) findViewById(R.id.topBackpackNoKnifeButtonID);
        topBackpackNoKnifeButton.setTextSize(sizeFonts);
        topBackpackNoKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackBackButton = (RadioButton) findViewById(R.id.topBackpackBackButtonID);
        topBackpackBackButton.setTextSize(sizeFonts);
        topBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));

        middleBackPackSleepingBugButton = (RadioButton) findViewById(R.id.middleBackPackSleepingBugButtonID);
        middleBackPackSleepingBugButton.setTextSize(sizeFonts);
        middleBackPackSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackSleepingBugLuckButton = (RadioButton) findViewById(R.id.middleBackPackSleepingBugLuckButtonID);
        middleBackPackSleepingBugLuckButton.setTextSize(sizeFonts);
        middleBackPackSleepingBugLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackNoSleepingBugButton = (RadioButton) findViewById(R.id.middleBackPackNoSleepingBugButtonID);
        middleBackPackNoSleepingBugButton.setTextSize(sizeFonts);
        middleBackPackNoSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackBackButton = (RadioButton) findViewById(R.id.middleBackPackBackButtonID);
        middleBackPackBackButton.setTextSize(sizeFonts);
        middleBackPackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));

        basementBackpackRaincoatButton = (RadioButton) findViewById(R.id.basementBackpackRaincoatButtonID);
        basementBackpackRaincoatButton.setTextSize(sizeFonts);
        basementBackpackRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackRaincoatLuckButton = (RadioButton) findViewById(R.id.basementBackpackRaincoatLuckButtonID);
        basementBackpackRaincoatLuckButton.setTextSize(sizeFonts);
        basementBackpackRaincoatLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackNoRaincoatButton = (RadioButton) findViewById(R.id.basementBackpackNoRaincoatButtonID);
        basementBackpackNoRaincoatButton.setTextSize(sizeFonts);
        basementBackpackNoRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackBackButton = (RadioButton) findViewById(R.id.basementBackpackBackButtonID);
        basementBackpackBackButton.setTextSize(sizeFonts);
        basementBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));

        additionalBackpackOintmentButton = (RadioButton) findViewById(R.id.additionalBackpackOintmentButtonID);
        additionalBackpackOintmentButton.setTextSize(sizeFonts);
        additionalBackpackOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackOintmentLuckButton = (RadioButton) findViewById(R.id.additionalBackpackOintmentLuckButtonID);
        additionalBackpackOintmentLuckButton.setTextSize(sizeFonts);
        additionalBackpackOintmentLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackNoOintmentButton = (RadioButton) findViewById(R.id.additionalBackpackNoOintmentButtonID);
        additionalBackpackNoOintmentButton.setTextSize(sizeFonts);
        additionalBackpackNoOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackBackButton = (RadioButton) findViewById(R.id.additionalBackpackBackButtonID);
        additionalBackpackBackButton.setTextSize(sizeFonts);
        additionalBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        if (isSleepingBug) {
            middleBackPackSleepingBugButton.setVisibility(View.GONE);
            middleBackPackSleepingBugLuckButton.setVisibility(View.GONE);
        }

        startAnimation(new ArrayList<View>(Arrays.asList(linearLayoutBackpack, scrollBackpack)));
    }

    public void onOpenTopPart(View view) {
        if (isTopBackpack) {
            prologueDownBackPackMainRadioGroup.setVisibility(View.GONE);
            prologueDownBackpackTopPartRadioGroup.setVisibility(View.VISIBLE);
        }
        topBackpackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        middleBackPackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTopBackpack = true;
        isMiddleBackPack = false;
        isBasementBackpack = false;
        isAdditionalBackpack = false;
    }

    public void onOpenMiddlePart(View view) {
        if (isMiddleBackPack) {
            prologueDownBackPackMainRadioGroup.setVisibility(View.GONE);
            prologueDownBackpackMiddlePartRadioGroup.setVisibility(View.VISIBLE);
        }
        topBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        basementBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTopBackpack = false;
        isMiddleBackPack = true;
        isBasementBackpack = false;
        isAdditionalBackpack = false;
    }

    public void onBasementPart(View view) {
        if (isBasementBackpack) {
            prologueDownBackPackMainRadioGroup.setVisibility(View.GONE);
            prologueDownBackpackBasementPartRadioGroup.setVisibility(View.VISIBLE);
        }
        topBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        additionalBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTopBackpack = false;
        isMiddleBackPack = false;
        isBasementBackpack = true;
        isAdditionalBackpack = false;
    }

    public void onAdditionalPart(View view) {
        if (isAdditionalBackpack) {
            prologueDownBackPackMainRadioGroup.setVisibility(View.GONE);
            prologueDownBackpackAdditionalPartRadioGroup.setVisibility(View.VISIBLE);
        }
        topBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isTopBackpack = false;
        isMiddleBackPack = false;
        isBasementBackpack = false;
        isAdditionalBackpack = true;
    }

    public void onAdditionalOintmentBackPack(View view) {
        if (isAdditionalBackpackOintment) {
            prologueDownBackpackAdditionalPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            additionalBackpackButton.setVisibility(View.GONE);
            isOintment = true;
            if (fortune < 20) {
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck, Toast.LENGTH_LONG);
                toast.show();
                isAdditional = true;
                if (isBasement && isTop && isMiddle) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                fortune = 10;
                getFortune();
                fortuneCounter.setText(stFortune);

            } else {
                fortune -= 20;
                treatmentCounterMain++;
                isAdditional = true;
                if (isBasement && isTop && isMiddle) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                toast = Toast.makeText(this, R.string.prologue_backpack_additional_part_ointment_text_toast, Toast.LENGTH_LONG);
                toast.show();
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        additionalBackpackOintmentButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        additionalBackpackOintmentLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackNoOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isAdditionalBackpackOintment = true;
        isAdditionalBackpackOintmentLuck = false;
        isAdditionalBackpackNoOintment = false;
        isAdditionalBackpackBack = false;
    }

    public void onAdditionalOintmentLuckBackPack(View view) {
        if (isAdditionalBackpackOintmentLuck) {
            prologueDownBackpackAdditionalPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            additionalBackpackButton.setVisibility(View.GONE);
            if (fortune < 10) {
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck_second, Toast.LENGTH_LONG);
                toast.show();
                isAdditional = true;
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                isOintment = Fortune.isFiftyFifty();
                fortune -= 10;

                isAdditional = true;
                if (isBasement && isTop && isMiddle) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                if (isOintment) {
                    treatmentCounterMain++;
                    toast = Toast.makeText(this, R.string.prologue_backpack_additional_part_ointment_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    toast = Toast.makeText(this, R.string.prologue_backpack_additional_part_no_ointment_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                }
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        additionalBackpackOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackOintmentLuckButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        additionalBackpackNoOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isAdditionalBackpackOintment = false;
        isAdditionalBackpackOintmentLuck = true;
        isAdditionalBackpackNoOintment = false;
        isAdditionalBackpackBack = false;
    }

    public void onAdditionalNoOintmentBackPack(View view) {
        if (isAdditionalBackpackNoOintment) {
            prologueDownBackpackAdditionalPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            additionalBackpackButton.setVisibility(View.GONE);
            fortune += 10;
            isOintment = false;
            getFortune();
            fortuneCounter.setText(stFortune);
            isAdditional = true;
            if (isBasement && isTop && isMiddle) {
                prologueBackpackNextButton.setVisibility(View.VISIBLE);
            }
            toast = Toast.makeText(this, R.string.prologue_backpack_additional_part_no_ointment_text_toast, Toast.LENGTH_LONG);
            toast.show();
        }
        additionalBackpackOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackOintmentLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackNoOintmentButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        additionalBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isAdditionalBackpackOintment = false;
        isAdditionalBackpackOintmentLuck = false;
        isAdditionalBackpackNoOintment = true;
        isAdditionalBackpackBack = false;
    }


    public void onAdditionalPartBack(View view) {
        if (isAdditionalBackpackBack) {
            prologueDownBackpackAdditionalPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
        }
        additionalBackpackOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackOintmentLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackNoOintmentButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        additionalBackpackBackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isAdditionalBackpackOintment = false;
        isAdditionalBackpackOintmentLuck = false;
        isAdditionalBackpackNoOintment = false;
        isAdditionalBackpackBack = true;
    }


    public void onTopBackpackKnife(View view) {
        if (isTopBackpackKnife) {
            prologueDownBackpackTopPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            topBackpackButton.setVisibility(View.GONE);
            if (fortune < 30) {
                fortune = 10;
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck_third, Toast.LENGTH_LONG);
                toast.show();
                isTop = true;
                if (isBasement && isMiddle && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                fortune -= 30;
                foodCounterMain++;
                isKnife = true;
                isKnifeMain = true;
                isTop = true;
                if (isBasement && isMiddle && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                toast = Toast.makeText(this, R.string.prologue_backpack_top_part_knife_text_toast, Toast.LENGTH_LONG);
                toast.show();
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        topBackpackKnifeButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        topBackpackKnifeLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackNoKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTopBackpackKnife = true;
        isTopBackpackKnifeLuck = false;
        isTopBackpackNoKnife = false;
        isTopBackpackBack = false;
    }

    public void onTopBackpackKnifeLuck(View view) {
        if (isTopBackpackKnifeLuck) {
            prologueDownBackpackTopPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            topBackpackButton.setVisibility(View.GONE);
            if (fortune < 15) {
                fortune = 10;
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck_third, Toast.LENGTH_LONG);
                toast.show();
                isTop = true;
                if (isBasement && isMiddle && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                fortune -= 15;
                foodCounterMain++;
                isKnife = Fortune.isFiftyFifty();

                isTop = true;
                if (isBasement && isMiddle && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                if (isKnife) {
                    isKnifeMain = true;
                    toast = Toast.makeText(this, R.string.prologue_backpack_top_part_knife_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    toast = Toast.makeText(this, R.string.prologue_backpack_top_part_no_knife_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                }
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        topBackpackKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackKnifeLuckButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        topBackpackNoKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTopBackpackKnife = false;
        isTopBackpackKnifeLuck = true;
        isTopBackpackNoKnife = false;
        isTopBackpackBack = false;
    }

    public void onTopBackpackNoKnife(View view) {
        if (isTopBackpackNoKnife) {
            prologueDownBackpackTopPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            topBackpackButton.setVisibility(View.GONE);
            fortune += 10;
            isKnife = false;
            foodCounterMain++;
            isTop = true;
            if (isBasement && isMiddle && isAdditional) {
                prologueBackpackNextButton.setVisibility(View.VISIBLE);
            }
            toast = Toast.makeText(this, R.string.prologue_backpack_top_part_no_knife_text_toast, Toast.LENGTH_LONG);
            toast.show();
            getFortune();
            fortuneCounter.setText(stFortune);
        }
        topBackpackKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackKnifeLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackNoKnifeButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        topBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isTopBackpackKnife = false;
        isTopBackpackKnifeLuck = false;
        isTopBackpackNoKnife = true;
        isTopBackpackBack = false;
    }

    public void onTopPartBack(View view) {
        if (isTopBackpackBack) {
            prologueDownBackpackTopPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
        }
        topBackpackKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackKnifeLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackNoKnifeButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        topBackpackBackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isTopBackpackKnife = false;
        isTopBackpackKnifeLuck = false;
        isTopBackpackNoKnife = false;
        isTopBackpackBack = true;
    }

    public void onMiddleBackPackSleepingBug(View view) {
        if (isMiddleBackPackSleepingBug) {
            prologueDownBackpackMiddlePartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            middleBackPackButton.setVisibility(View.GONE);
            if (fortune < 30) {
                fortune = 10;
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck, Toast.LENGTH_LONG);
                toast.show();
                isMiddle = true;
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                fortune -= 30;
                isSleepingBug = true;

                isSleepingBugMain = true;
                isMiddle = true;
                if (isBasement && isTop && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                toast = Toast.makeText(this, R.string.prologue_backpack_middle_part_sleeping_bug_text_toast, Toast.LENGTH_LONG);
                toast.show();
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        middleBackPackSleepingBugButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        middleBackPackSleepingBugLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackNoSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isMiddleBackPackSleepingBug = true;
        isMiddleBackPackSleepingBugLuck = false;
        isMiddleBackPackNoSleepingBug = false;
        isMiddleBackPackBack = false;
    }

    public void onMiddleBackPackSleepingBugLuck(View view) {
        if (isMiddleBackPackSleepingBugLuck) {
            prologueDownBackpackMiddlePartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            middleBackPackButton.setVisibility(View.GONE);
            if (fortune < 15) {
                fortune = 10;
                isMiddle = true;
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck, Toast.LENGTH_LONG);
                toast.show();
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                fortune -= 15;
                isSleepingBug = Fortune.isFiftyFifty();
                isMiddle = true;
                if (isBasement && isTop && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                if (isSleepingBug) {
                    isSleepingBugMain = true;
                    toast = Toast.makeText(this, R.string.prologue_backpack_middle_part_sleeping_bug_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    toast = Toast.makeText(this, R.string.prologue_backpack_middle_part_no_sleeping_bug_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                }
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        middleBackPackSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackSleepingBugLuckButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        middleBackPackNoSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isMiddleBackPackSleepingBug = false;
        isMiddleBackPackSleepingBugLuck = true;
        isMiddleBackPackNoSleepingBug = false;
        isMiddleBackPackBack = false;
    }

    public void onMiddleBackPackNoSleepingBug(View view) {
        if (isMiddleBackPackNoSleepingBug) {
            prologueDownBackpackMiddlePartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            middleBackPackButton.setVisibility(View.GONE);
            fortune += 10;

            isMiddle = true;
            if (isBasement && isTop && isAdditional) {
                prologueBackpackNextButton.setVisibility(View.VISIBLE);
            }
            toast = Toast.makeText(this, R.string.prologue_backpack_middle_part_no_sleeping_bug_text_toast, Toast.LENGTH_LONG);
            toast.show();
            getFortune();
            fortuneCounter.setText(stFortune);
        }
        middleBackPackSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackSleepingBugLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackNoSleepingBugButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        middleBackPackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isMiddleBackPackSleepingBug = false;
        isMiddleBackPackSleepingBugLuck = false;
        isMiddleBackPackNoSleepingBug = true;
        isMiddleBackPackBack = false;
    }

    public void onMiddlePartBack(View view) {
        if (isMiddleBackPackBack) {
            prologueDownBackpackMiddlePartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
        }
        middleBackPackSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackSleepingBugLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackNoSleepingBugButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        middleBackPackBackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isMiddleBackPackSleepingBug = false;
        isMiddleBackPackSleepingBugLuck = false;
        isMiddleBackPackNoSleepingBug = false;
        isMiddleBackPackBack = true;
    }

    public void onBasementBackpackRaincoat(View view) {
        if (isBasementBackpackRaincoat) {
            prologueDownBackpackBasementPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            basementBackpackButton.setVisibility(View.GONE);
            if (fortune < 20) {
                fortune = 10;
                isBasement = true;
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck, Toast.LENGTH_LONG);
                toast.show();
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                isRaincoat = true;
                isRaincoatMain = true;
                fortune -= 20;
                isBasement = true;
                if (isTop && isMiddle && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                toast = Toast.makeText(this, R.string.prologue_backpack_basement_part_raincoat_text_toast, Toast.LENGTH_LONG);
                toast.show();
                getFortune();
                fortuneCounter.setText(stFortune);
            }

        }
        basementBackpackRaincoatButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        basementBackpackRaincoatLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackNoRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isBasementBackpackRaincoat = true;
        isBasementBackpackRaincoatLuck = false;
        isBasementBackpackNoRaincoat = false;
        isBasementBackpackBack = false;
    }

    public void onBasementBackpackRaincoatLuckButton(View view) {
        if (isBasementBackpackRaincoatLuck) {
            prologueDownBackpackBasementPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            basementBackpackButton.setVisibility(View.GONE);
            isRaincoat = Fortune.isFiftyFifty();
            if (fortune < 10) {
                fortune = 10;
                toast = Toast.makeText(this, R.string.prologue_backpack_no_luck, Toast.LENGTH_LONG);
                toast.show();
                isBasement = true;
                getFortune();
                fortuneCounter.setText(stFortune);
            } else {
                fortune -= 10;
                isBasement = true;
                if (isTop && isMiddle && isAdditional) {
                    prologueBackpackNextButton.setVisibility(View.VISIBLE);
                }
                if (isRaincoat) {
                    isRaincoatMain = true;
                    toast = Toast.makeText(this, R.string.prologue_backpack_basement_part_raincoat_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    toast = Toast.makeText(this, R.string.prologue_backpack_basement_part_no_raincoat_text_toast, Toast.LENGTH_LONG);
                    toast.show();
                }
                getFortune();
                fortuneCounter.setText(stFortune);
            }
        }
        basementBackpackRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackRaincoatLuckButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        basementBackpackNoRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isBasementBackpackRaincoat = false;
        isBasementBackpackRaincoatLuck = true;
        isBasementBackpackNoRaincoat = false;
        isBasementBackpackBack = false;
    }

    public void onBasementBackpackNoRaincoat(View view) {
        if (isBasementBackpackNoRaincoat) {
            prologueDownBackpackBasementPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
            basementBackpackButton.setVisibility(View.GONE);
            isRaincoat = false;
            fortune += 10;
            isBasement = true;
            if (isTop && isMiddle && isAdditional) {
                prologueBackpackNextButton.setVisibility(View.VISIBLE);
            }
            toast = Toast.makeText(this, R.string.prologue_backpack_basement_part_no_raincoat_text_toast, Toast.LENGTH_LONG);
            toast.show();
            getFortune();
            fortuneCounter.setText(stFortune);
        }
        basementBackpackRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackRaincoatLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackNoRaincoatButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        basementBackpackBackButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        isBasementBackpackRaincoat = false;
        isBasementBackpackRaincoatLuck = false;
        isBasementBackpackNoRaincoat = true;
        isBasementBackpackBack = false;
    }

    public void onBasementPartBack(View view) {
        if (isBasementBackpackBack) {
            prologueDownBackpackBasementPartRadioGroup.setVisibility(View.GONE);
            prologueDownBackPackMainRadioGroup.setVisibility(View.VISIBLE);
        }
        basementBackpackRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackRaincoatLuckButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackNoRaincoatButton.setBackgroundColor(Color.parseColor("#60ffffff"));
        basementBackpackBackButton.setBackgroundColor(Color.parseColor("#607e9e7f"));
        isBasementBackpackRaincoat = false;
        isBasementBackpackRaincoatLuck = false;
        isBasementBackpackNoRaincoat = false;
        isBasementBackpackBack = true;
    }

    public void onBackpackCamp(View view) {
        SharedPreferences.Editor editor = save.edit();
        editor.putBoolean(APP_SAVE_KNIFE, isKnife);
        editor.putBoolean(APP_SAVE_OINTMENT, isOintment);
        editor.putBoolean(APP_SAVE_RAINCOAT, isRaincoat);
        editor.putBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, isSleepingBug);
        editor.putInt(APP_SAVE_FOOD, foodCounterMain);
        editor.putInt(APP_SAVE_TREATMENT, treatmentCounterMain);
        editor.putInt(APP_SAVE_FORTUNE, fortune);
        editor.apply();
        Intent intent = new Intent(PrologueDownSecondSceneBackPack.this, PrologueBonfire.class);
        getNextScene(intent);
        overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
        finish();
    }

    private void getFortune() {
        fortuneCounter.setVisibility(View.VISIBLE);
        if (fortune <= 10) {
            stFortune = "Удача:\nБез комментариев";
            fortuneCounter.setTextColor(Color.parseColor("#ff6666"));
        } else if (fortune <= 20) {
            stFortune = "Удача:\nКак любовник в шкафу";
            fortuneCounter.setTextColor(Color.parseColor("#ff7f7f"));
        } else if (fortune <= 30) {
            stFortune = "Удача:\nКак девственник в 45 лет";
            fortuneCounter.setTextColor(Color.parseColor("#ffb2b2"));
        } else if (fortune <= 40) {
            stFortune = "Удача:\nИногда везет....";
            fortuneCounter.setTextColor(Color.parseColor("#ffe5e5"));
        } else if (fortune <= 50) {
            stFortune = "Удача:\n50/50";
            fortuneCounter.setTextColor(Color.parseColor("#ffffff"));
        } else if (fortune <= 60) {
            stFortune = "Удача:\nКак уйти после 9 класса";
            fortuneCounter.setTextColor(Color.parseColor("#a2c57f"));
        } else if (fortune <= 70) {
            stFortune = "Удача:\nБеспечный Ангел";
            fortuneCounter.setTextColor(Color.parseColor("#7cad4c"));
        } else if (fortune <= 80) {
            stFortune = "Удача:\nБлеск!";
            fortuneCounter.setTextColor(Color.parseColor("#6aa232"));
        } else if (fortune <= 90) {
            stFortune = "Удача:\nКаре из тузов";
            fortuneCounter.setTextColor(Color.parseColor("#579619"));
        } else if (fortune <= 100) {
            stFortune = "Удача:\nИз двух орлов - решка!";
            fortuneCounter.setTextColor(Color.parseColor("#3e7d00"));
        }
    }
}

