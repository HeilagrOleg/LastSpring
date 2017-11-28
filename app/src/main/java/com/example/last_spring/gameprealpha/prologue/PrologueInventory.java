package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.mainMenu.MainActivity;
import com.example.last_spring.gameprealpha.res.GameActivity;

public class PrologueInventory extends GameActivity {

    private TextView textPrologueInventory;
    private static final String APP_SAVE = "Save";
    private static final String APP_SAVE_FOOD = "Food";
    private static final String APP_SAVE_KNIFE = "Knife";
    private static final String APP_SAVE_RAINCOAT = "Raincoat";
    private static final String APP_SAVE_SLEEPING_BAG_PROLOGUE = "Sleeping bag";
    private static final String APP_SAVE_TREATMENT = "Treatment";


    private SharedPreferences save;
    private String sleepingBug;
    private String knife;
    private String raincoat;

    @Override
    public void onBackPressed() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_inventory);

        isMenuExit = true;

        fortune = getIntent().getIntExtra("fortune", fortune);
        wound = getIntent().getIntExtra("wound", wound);
        isFaim = getIntent().getBooleanExtra("faim", isFaim);
        isKnifeMain = getIntent().getBooleanExtra("knife", isKnifeMain);
        isRaincoatMain = getIntent().getBooleanExtra("raincoat", isRaincoatMain);
        isSleepingBugMain = getIntent().getBooleanExtra("sleepingBug", isSleepingBugMain);
        treatmentCounterMain = getIntent().getIntExtra("treatment", treatmentCounterMain);
        foodCounterMain = getIntent().getIntExtra("food", foodCounterMain);

        if (fortune < 0) {
            fortune = 10;
        } else if (fortune > 100) {
            fortune = 100;
        }

        textInventoryFood = (TextView) findViewById(R.id.textInventoryFoodID);
        textInventoryFood.setTextSize(sizeFonts + 2);
        textInventoryDrugs = (TextView) findViewById(R.id.textInventoryDrugsID);
        textInventoryDrugs.setTextSize(sizeFonts + 2);
        textInventorySleepingBug = (TextView) findViewById(R.id.textInventorySleepingBugID);
        textInventorySleepingBug.setTextSize(sizeFonts + 2);
        textInventoryRaincoat = (TextView) findViewById(R.id.textInventoryRaincoatID);
        textInventoryRaincoat.setTextSize(sizeFonts + 2);
        textInventoryKnife = (TextView) findViewById(R.id.textInventoryKnifeID);
        textInventoryKnife.setTextSize(sizeFonts + 2);
        textInventoryText = (TextView) findViewById(R.id.textInventoryTextID);
        textInventoryText.setTextSize(sizeFonts - 2);

        progressBarMenuHealth = (ProgressBar) findViewById(R.id.progressBarMenuHealthID);
        progressBarMenuHunger = (ProgressBar) findViewById(R.id.progressBarMenuHungerID);
        progressBarMenuLuck = (ProgressBar) findViewById(R.id.progressBarChapterTwoLuckID);

        String stFood = res.getString(R.string.inventory_food) + " " + foodCounterMain;
        String stDrug = res.getString(R.string.inventory_drugs) + " " + treatmentCounterMain;

        textInventoryDrugs.setText(stDrug);
        textInventoryFood.setText(stFood);

        if (isSleepingBugMain) {
            textInventorySleepingBug.setTextColor(Color.parseColor("#ffffff"));
            textInventorySleepingBug.setBackgroundColor(Color.parseColor("#90e9f7f7"));
        }

        if (isKnifeMain) {
            textInventoryKnife.setTextColor(Color.parseColor("#ffffff"));
            textInventoryKnife.setBackgroundColor(Color.parseColor("#90e9f7f7"));
        }

        if (isRaincoatMain) {
            textInventoryRaincoat.setTextColor(Color.parseColor("#ffffff"));
            textInventoryRaincoat.setBackgroundColor(Color.parseColor("#90e9f7f7"));
        }

        if (fortune > 65) {
            progressBarMenuLuck.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_good));
        } else if (fortune < 35) {
            progressBarMenuLuck.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_bad));
        } else {
            progressBarMenuLuck.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_normal));
        }

        if (wound == 0) {
            progressBarMenuHealth.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_good));
            progressBarMenuHealth.setProgress(100);
        } else if (wound == 1) {
            progressBarMenuHealth.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_normal));
            progressBarMenuHealth.setProgress(45);
        } else {
            progressBarMenuHealth.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_bad));
            progressBarMenuHealth.setProgress(10);
        }

        if (isFaim) {
            progressBarMenuHunger.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_bad));
            progressBarMenuHunger.setProgress(25);
        } else {
            progressBarMenuHunger.setProgressDrawable(res.getDrawable(R.drawable.progress_bar_menu_vertical_good));
            progressBarMenuHunger.setProgress(75);
        }

        buttonMenuCancel = (Button) findViewById(R.id.buttonMenuCancelD);

        progressBarMenuLuck.setProgress(fortune);

    }

    public void onBarMenuHealth(View view) {
        showButtonMainAnimation(view);
        textInventoryText.setText(R.string.inventory_text_health);
    }

    public void onBarBarMenuHunger(View view) {
        showButtonMainAnimation(view);
        textInventoryText.setText(R.string.inventory_text_hunger);
    }

    public void onBarMenuLuck(View view) {
        showButtonMainAnimation(view);
        textInventoryText.setText(R.string.inventory_text_luck);
    }

    public void onInventoryKnife(View view) {
        if (isKnifeMain) {
            showButtonMainAnimation(view);
            textInventoryText.setText(R.string.inventory_text_knife);
        } else {
            showButtonMainAnimation(view);
            textInventoryText.setText(R.string.inventory_text_false);
        }
    }

    public void onInventoryRaincoat(View view) {
        if (isRaincoatMain) {
            showButtonMainAnimation(view);
            textInventoryText.setText(R.string.inventory_text_raincoat);
        } else {
            showButtonMainAnimation(view);
            textInventoryText.setText(R.string.inventory_text_false);
        }
    }

    public void onInventorySleepingBug(View view) {
        if (isSleepingBugMain) {
            showButtonMainAnimation(view);
            textInventoryText.setText(R.string.inventory_text_sleeping_bug);
        } else {
            showButtonMainAnimation(view);
            textInventoryText.setText(R.string.inventory_text_false);
        }
    }

    public void onInventoryDrugs(View view) {
        showButtonMainAnimation(view);
        textInventoryText.setText(R.string.inventory_text_drugs);
    }

    public void onInventoryFood(View view) {
        showButtonMainAnimation(view);
        textInventoryText.setText(R.string.inventory_text_food);
    }


    public void onMenuLuckUp(View view) {
    }

    public void onMenuCancelD(View view) {
        finish();
    }


    public void onMenuMenu(View view) {
        finishOst();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void onMenuExit(View view) {
        finishOst();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }
}
