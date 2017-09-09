package com.example.last_spring.gameprealpha;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        save = getSharedPreferences(APP_SAVE, Context.MODE_PRIVATE);

        if (save.getBoolean(APP_SAVE_SLEEPING_BAG_PROLOGUE, false)) {
            sleepingBug = getString(R.string.prologue_inventory_sleeping_bug);
        } else {
            sleepingBug = getString(R.string.prologue_inventory_no_sleeping_bug);
        }

        if (save.getBoolean(APP_SAVE_KNIFE, false)) {
            knife = getString(R.string.prologue_inventory_knife);
        } else {
            knife = getString(R.string.prologue_inventory_no_knife);
        }

        if (save.getBoolean(APP_SAVE_RAINCOAT, false)) {
            raincoat = getString(R.string.prologue_inventory_raincoat);
        } else {
            raincoat = getString(R.string.prologue_inventory_no_raincoat);
        }

        textPrologueInventory = (TextView) findViewById(R.id.textPrologueInventoryID);
        textPrologueInventory.setText(getString(R.string.prologue_inventory, sleepingBug,
                        save.getInt(APP_SAVE_FOOD, 0),
                        save.getInt(APP_SAVE_TREATMENT, 0),
                        knife,
                raincoat
                ));
    }

    public void onPrologueInventoryBack(View view) {
        finish();
    }
}
