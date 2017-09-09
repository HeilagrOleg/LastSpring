package com.example.last_spring.gameprealpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.last_spring.gameprealpha.res.GameActivity;
import com.last_spring.gameprealpha.OstWood;

public class HuntingLodgeAfter extends GameActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_lodge_after);

        startService(new Intent(this, OstWood.class));
        isOstWood = true;
    }
}
