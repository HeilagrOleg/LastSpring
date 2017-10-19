package com.example.last_spring.gameprealpha.prologue;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_inventory);
    }

    public void onPrologueInventoryBack(View view) {
        finish();
    }
}
