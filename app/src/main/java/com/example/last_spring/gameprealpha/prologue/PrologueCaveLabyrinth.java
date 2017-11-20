package com.example.last_spring.gameprealpha.prologue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.Fortune;
import com.example.last_spring.gameprealpha.res.GameActivity;
import com.example.last_spring.gameprealpha.res.Labyrinth;
import com.last_spring.gameprealpha.OstCave;

import java.util.ArrayList;
import java.util.Arrays;

public class PrologueCaveLabyrinth extends GameActivity {

    public static final String APP_SAVE_CAVE_FAIL = "Cave fail";
    public static final String APP_SAVE_CAVE_RETURN = "Cave return";

    private RadioGroup radioGroupCaveLabyrinth;

    private RadioButton buttonCaveLabyrinthNorth;
    private RadioButton buttonCaveLabyrinthWest;
    private RadioButton buttonCaveLabyrinthSouth;
    private RadioButton buttonCaveLabyrinthEast;
    private RadioButton buttonCaveLabyrinthExit;
    private RadioButton buttonCaveLabyrinthLuck;

    private boolean isNorth;
    private boolean isWest;
    private boolean isSouth;
    private boolean isEast;
    private boolean isExit;
    private boolean isFail;
    private boolean isLuck;
    private boolean isFortune;
    private boolean isFinish;

    private String colorBackground;
    private String colorWay;
    private String colorAir;
    private String colorActive;

    private TextView textViewCaveLabyrinth;

    private ArrayList<Labyrinth> routeList;

    private TextView textCounterStep;

    private ImageView imageCaveLabyrinth;
    private ImageView imageBackgroundLuckTrue;
    private ImageView imageBackgroundLuckFalse;

    private int x;
    private int y;
    private int xPixel;
    private int yPixel;
    private int xMain;
    private int yMain;
    private int height;
    private String name;
    private int step;
    private Bitmap map;

    private Toast toast;

    private float level;
    private Labyrinth x4y1;
    private Labyrinth x3y1;
    private Labyrinth x2y1;
    private Labyrinth x1y1;
    private Labyrinth x5y2;
    private Labyrinth x4y2;
    private Labyrinth x3y2;
    private Labyrinth x2y2;
    private Labyrinth x5y3;
    private Labyrinth x4y3;
    private Labyrinth x3y3;
    private Labyrinth x2y3;
    private Labyrinth x5y4;
    private Labyrinth x4y4;
    private Labyrinth x3y4;
    private Labyrinth x2y4;
    private Labyrinth x4y5;
    private Labyrinth x3y5;
    private Labyrinth x5y6;
    private Labyrinth x4y6;
    private Labyrinth x3y6;
    private Labyrinth x5y7;
    private Labyrinth x4y7;
    private Labyrinth x3y7;
    private Labyrinth x2y7;
    private Labyrinth x1y7;
    private Labyrinth x5y8;
    private Labyrinth x3y8;
    private Labyrinth x2y8;
    private Labyrinth x6y9;
    private Labyrinth x5y9;
    private Labyrinth x6y10;
    private Labyrinth x5y10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue_cave_labyrinth);

        level = 2.131f;

        SharedPreferences.Editor editor = save.edit();
        editor.putFloat(APP_SAVE_LEVEL, level);
        editor.apply();
        Resources res = getResources();

        startService(new Intent(this, OstCave.class));
        isOstCave = true;

        radioGroupCaveLabyrinth = (RadioGroup) findViewById(R.id.radioGroupCaveLabyrinthID);

        buttonCaveLabyrinthEast = (RadioButton) findViewById(R.id.buttonCaveLabyrinthEastID);
        buttonCaveLabyrinthEast.setTextSize(sizeFonts);
        buttonCaveLabyrinthWest = (RadioButton) findViewById(R.id.buttonCaveLabyrinthWestID);
        buttonCaveLabyrinthWest.setTextSize(sizeFonts);
        buttonCaveLabyrinthNorth = (RadioButton) findViewById(R.id.buttonCaveLabyrinthNorthID);
        buttonCaveLabyrinthNorth.setTextSize(sizeFonts);
        buttonCaveLabyrinthSouth = (RadioButton) findViewById(R.id.buttonCaveLabyrinthSouthID);
        buttonCaveLabyrinthSouth.setTextSize(sizeFonts);
        buttonCaveLabyrinthExit = (RadioButton) findViewById(R.id.buttonCaveLabyrinthExitID);
        buttonCaveLabyrinthExit.setTextSize(sizeFonts);
        buttonCaveLabyrinthLuck = (RadioButton) findViewById(R.id.buttonCaveLabyrinthLuckID);
        buttonCaveLabyrinthLuck.setTextSize(sizeFonts);
        buttonCaveLabyrinthLuck.setVisibility(View.GONE);

        textViewCaveLabyrinth = (TextView) findViewById(R.id.textViewCaveLabyrinthID);
        sText(textViewCaveLabyrinth);
        textCounterStep = (TextView) findViewById(R.id.textCounterStepID);


        routeList = new ArrayList<>(Arrays.asList(x4y1 = new Labyrinth("x4y1", true, false, false, false, true, false, true, res.getString(R.string.cave_labyrinth_button_text_4_1)),
                x3y1 = new Labyrinth("x3y1", true, false, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_1)),
                x2y1 = new Labyrinth("x2y1", true, false, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_2_1)),
                x1y1 = new Labyrinth("x1y1", false, false, false, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_1_1)),
                x5y2 = new Labyrinth("x5y2", true, false, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_5_2)),
                x4y2 = new Labyrinth("x4y2", true, true, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_4_2)),
                x3y2 = new Labyrinth("x3y2", false, true, false, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_2)),
                x2y2 = new Labyrinth("x2y2", true, true, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_2_2)),
                x5y3 = new Labyrinth("x5y3", true, true, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_5_3)),
                x4y3 = new Labyrinth("x4y3", false, true, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_4_3)),
                x3y3 = new Labyrinth("x3y3", true, false, false, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_3)),
                x2y3 = new Labyrinth("x2y3", true, true, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_2_3)),
                x5y4 = new Labyrinth("x5y4", false, true, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_5_4)),
                x4y4 = new Labyrinth("x4y4", false, false, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_4_4)),
                x3y4 = new Labyrinth("x3y4", true, true, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_4)),
                x2y4 = new Labyrinth("x2y4", false, true, false, true, false, false, true, res.getString(R.string.cave_labyrinth_button_text_2_4)),
                x4y5 = new Labyrinth("x4y5", true, false, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_4_5)),
                x3y5 = new Labyrinth("x3y5", true, true, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_5)),
                x5y6 = new Labyrinth("x5y6", false, false, true, false, false, false, true, res.getString(R.string.cave_labyrinth_button_text_5_6)),
                x4y6 = new Labyrinth("x4y6", true, true, false, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_4_6)),
                x3y6 = new Labyrinth("x3y6", true, true, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_6)),
                x5y7 = new Labyrinth("x5y7", true, false, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_5_7)),
                x4y7 = new Labyrinth("x4y7", false, true, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_4_7)),
                x3y7 = new Labyrinth("x3y7", true, true, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_7)),
                x2y7 = new Labyrinth("x2y7", true, false, true, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_2_7)),
                x1y7 = new Labyrinth("x1y7", false, false, false, true, false, false, true, res.getString(R.string.cave_labyrinth_button_text_1_7)),
                x5y8 = new Labyrinth("x5y8", true, true, false, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_5_8)),
                x3y8 = new Labyrinth("x3y8", false, true, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_3_8)),
                x2y8 = new Labyrinth("x2y8", false, true, false, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_2_8)),
                x6y9 = new Labyrinth("x6y9", true, false, true, false, false, false, false, res.getString(R.string.cave_labyrinth_button_text_6_9)),
                x5y9 = new Labyrinth("x5y9", true, true, false, true, false, false, false, res.getString(R.string.cave_labyrinth_button_text_5_9)),
                x6y10 = new Labyrinth("x6y10", false, false, false, false, false, true, false, res.getString(R.string.cave_labyrinth_button_text_6_10)),
                x5y10 = new Labyrinth("x5y10", false, true, false, false, false, false, true, res.getString(R.string.cave_labyrinth_button_text_5_10))));

        step = 0;
        textCounterStep.setText("Количество шагов: " + step);

        colorBackground = "#5e574a";
        colorActive = "#7d5041";
        colorAir = "#6b6490";
        colorWay = "#516a5a";

        x = 4;
        y = 1;

        xMain = 80;
        yMain = 20;

        xPixel = xMain;
        yPixel = yMain;

        name = "x4y1";
        getRoute(x4y1);

        height = 200;

        map = Bitmap.createBitmap(300, height, Bitmap.Config.ARGB_8888);

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 10; i++) {
                map.setPixel(xPixel, height - yPixel, Color.parseColor("#888b89"));
                xPixel++;
            }
            xPixel = xMain;
            yPixel++;
        }

        imageCaveLabyrinth = (ImageView) findViewById(R.id.imageCaveLabyrinthID);
        imageCaveLabyrinth.setImageBitmap(map);

        imageBackgroundLuckFalse = (ImageView) findViewById(R.id.imageBackgroundLuckFalseID);
        imageBackgroundLuckFalse.setVisibility(View.GONE);

        imageBackgroundLuckTrue = (ImageView) findViewById(R.id.imageBackgroundLuckTrueID);
        imageBackgroundLuckTrue.setVisibility(View.GONE);

        textCounterStep.setVisibility(View.GONE);

        buttonMenu = (ImageButton) findViewById(R.id.buttonMenuID);

        getInterface(true);

        startAnimation(new ArrayList<View>(Arrays.asList(imageCaveLabyrinth, radioGroupCaveLabyrinth, textViewCaveLabyrinth, buttonMenu)));
    }


    public void onNorth(View view) {
        if (isNorth) {
            yPixel = yMain;
            xPixel = xMain;
            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isNorth() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isSouth() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorAir));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorBackground));
                        }
                    }

                    if (getNextRoute(name).isWest() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    if (getNextRoute(name).isEast() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    xPixel++;
                }
                xPixel = xMain;
                yPixel++;
            }

            y++;
            name = "x" + x + "y" + y;
            getRoute(getNextRoute(name));
            if (getNextRoute(name).isAir()) {
                step = 0;
            }
            step++;
            if (step == 9) {
                textMessage.setText(R.string.cave_labyrinth_toast_air);
                showMessage(textMessage, false);
            } else if (step == 14) {
                textMessage.setText(R.string.cave_labyrinth_toast_no_air);
                showMessage(textMessage, false);
            } else if (step == 18) {
                textViewCaveLabyrinth.setText(R.string.cave_labyrinth_text_air_fail);
                buttonCaveLabyrinthExit.setVisibility(View.VISIBLE);
                if (!isLuck) {
                    buttonCaveLabyrinthLuck.setVisibility(View.VISIBLE);
                    isLuck = true;
                }
                buttonCaveLabyrinthEast.setVisibility(View.GONE);
                buttonCaveLabyrinthWest.setVisibility(View.GONE);
                buttonCaveLabyrinthSouth.setVisibility(View.GONE);
                buttonCaveLabyrinthNorth.setVisibility(View.GONE);
                imageCaveLabyrinth.setVisibility(View.INVISIBLE);
                isFail = true;
            }
            textCounterStep.setText("Количество шагов: " + step);
            for (int k = 0; k < 8; k++) {
                for (int i = 0; i < 8; i++) {
                    map.setPixel(xPixel + 1, height - yPixel, Color.parseColor(colorBackground));
                    xPixel++;
                }
                xPixel = xMain;
                yPixel++;
            }
            yMain = yPixel;

            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isNorth() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isSouth() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor("#ff7800"));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorActive));
                        }
                    }

                    if (getNextRoute(name).isWest() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    if (getNextRoute(name).isEast() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    xPixel++;
                }
                xPixel = xMain;
                yPixel++;
            }
            imageCaveLabyrinth.setImageBitmap(map);
            buttonCaveLabyrinthNorth.setBackgroundColor(Color.parseColor("#60ffffff"));
            isNorth = false;
        } else {
            buttonCaveLabyrinthNorth.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonCaveLabyrinthSouth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthWest.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthEast.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthExit.setBackgroundColor(Color.parseColor("#60ffffff"));

            isNorth = true;
            isSouth = false;
            isWest = false;
            isEast = false;
            isExit = false;
        }
    }

    public void onWest(View view) {
        if (isWest) {
            yPixel = yMain;
            xPixel = xMain;
            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isNorth() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isSouth() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorAir));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorBackground));
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorBackground));
                        }
                    }

                    if (getNextRoute(name).isWest() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    if (getNextRoute(name).isEast() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    xPixel++;
                }
                xPixel = xMain;
                yPixel++;
            }
            yPixel = yMain;
            x--;
            name = "x" + x + "y" + y;
            getRoute(getNextRoute(name));
            if (getNextRoute(name).isAir()) {
                step = 0;
            }
            step++;
            if (step == 9) {
                textMessage.setText(R.string.cave_labyrinth_toast_air);
                showMessage(textMessage, false);
            } else if (step == 14) {
                textMessage.setText(R.string.cave_labyrinth_toast_no_air);
                showMessage(textMessage, false);
            } else if (step == 18) {
                textViewCaveLabyrinth.setText(R.string.cave_labyrinth_text_air_fail);
                if (!isLuck) {
                    buttonCaveLabyrinthLuck.setVisibility(View.VISIBLE);
                    isLuck = true;
                }
                buttonCaveLabyrinthExit.setVisibility(View.VISIBLE);
                buttonCaveLabyrinthEast.setVisibility(View.GONE);
                buttonCaveLabyrinthWest.setVisibility(View.GONE);
                buttonCaveLabyrinthSouth.setVisibility(View.GONE);
                buttonCaveLabyrinthNorth.setVisibility(View.GONE);
                imageCaveLabyrinth.setVisibility(View.INVISIBLE);
                isFail = true;
            }

            textCounterStep.setText("Количество шагов: " + step);
            for (int k = 0; k < 8; k++) {
                yPixel = yMain;
                xPixel--;
                for (int i = 0; i < 8; i++) {
                    map.setPixel(xPixel, height - 1 - yPixel, Color.parseColor(colorBackground));
                    yPixel++;
                }
            }
            xMain = xPixel;
            yPixel = yMain;

            for (int k = 0; k < 10; k++) {
                yPixel = yMain;
                xPixel--;
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isEast() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isWest() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor("#ff7800"));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorActive));
                        }
                    }

                    if (getNextRoute(name).isSouth() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    if (getNextRoute(name).isNorth() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    yPixel++;
                }
            }
            xMain = xPixel;
            imageCaveLabyrinth.setImageBitmap(map);
            buttonCaveLabyrinthWest.setBackgroundColor(Color.parseColor("#60ffffff"));
            isWest = false;
        } else {
            buttonCaveLabyrinthNorth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthSouth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthWest.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonCaveLabyrinthEast.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthExit.setBackgroundColor(Color.parseColor("#60ffffff"));

            isNorth = false;
            isSouth = false;
            isWest = true;
            isEast = false;
            isExit = false;
        }
    }

    public void onSouth(View view) {
        if (isSouth) {
            yPixel = yMain;
            xPixel = xMain;
            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isNorth() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isSouth() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorAir));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorBackground));
                        }
                    }

                    if (getNextRoute(name).isWest() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    if (getNextRoute(name).isEast() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    xPixel++;
                }
                xPixel = xMain;
                yPixel++;
            }
            yPixel = yMain;
            y--;
            name = "x" + x + "y" + y;
            getRoute(getNextRoute(name));
            if (getNextRoute(name).isAir()) {
                step = 0;
            }
            step++;
            if (step == 9) {
                textMessage.setText(R.string.cave_labyrinth_toast_air);
                showMessage(textMessage, false);
            } else if (step == 14) {
                textMessage.setText(R.string.cave_labyrinth_toast_no_air);
                showMessage(textMessage, false);
            } else if (step == 18) {
                textViewCaveLabyrinth.setText(R.string.cave_labyrinth_text_air_fail);
                if (!isLuck) {
                    buttonCaveLabyrinthLuck.setVisibility(View.VISIBLE);
                    isLuck = true;
                }
                buttonCaveLabyrinthExit.setVisibility(View.VISIBLE);
                buttonCaveLabyrinthEast.setVisibility(View.GONE);
                buttonCaveLabyrinthWest.setVisibility(View.GONE);
                buttonCaveLabyrinthSouth.setVisibility(View.GONE);
                buttonCaveLabyrinthNorth.setVisibility(View.GONE);
                imageCaveLabyrinth.setVisibility(View.INVISIBLE);
                isFail = true;
                if (save.getInt(APP_SAVE_WOUND, 0) < 2) {
                    wound++;
                }
            }
            textCounterStep.setText("Количество шагов: " + step);
            for (int k = 0; k < 8; k++) {
                xPixel = xMain;
                yPixel--;
                for (int i = 0; i < 8; i++) {
                    map.setPixel(xPixel + 1, height - yPixel, Color.parseColor(colorBackground));
                    xPixel++;
                }
            }
            yMain = yPixel;

            for (int k = 0; k < 10; k++) {
                xPixel = xMain;
                yPixel--;
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isNorth() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isSouth() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor("#ff7800"));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorActive));
                        }
                    }
                    if (getNextRoute(name).isWest() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    if (getNextRoute(name).isEast() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    xPixel++;
                }
            }
            yMain = yPixel;
            imageCaveLabyrinth.setImageBitmap(map);
            buttonCaveLabyrinthSouth.setBackgroundColor(Color.parseColor("#60ffffff"));
            isSouth = false;
        } else {
            buttonCaveLabyrinthNorth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthSouth.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonCaveLabyrinthWest.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthEast.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthExit.setBackgroundColor(Color.parseColor("#60ffffff"));

            isNorth = false;
            isSouth = true;
            isWest = false;
            isEast = false;
            isExit = false;
        }
    }

    public void onEast(View view) {
        if (isEast) {
            yPixel = yMain;
            xPixel = xMain;
            for (int k = 0; k < 10; k++) {
                xPixel = xMain;
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isNorth() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isSouth() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorAir));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorBackground));
                        }
                    }

                    if (getNextRoute(name).isWest() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    if (getNextRoute(name).isEast() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }
                    xPixel++;
                }
                yPixel++;
            }
            yPixel = yMain;
            x++;
            name = "x" + x + "y" + y;
            getRoute(getNextRoute(name));
            if (getNextRoute(name).isAir()) {
                step = 0;
            }
            step++;
            if (step == 9) {
                textMessage.setText(R.string.cave_labyrinth_toast_air);
                showMessage(textMessage, false);
            } else if (step == 14) {
                textMessage.setText(R.string.cave_labyrinth_toast_no_air);
                showMessage(textMessage, false);
            } else if (step == 18) {
                textViewCaveLabyrinth.setText(R.string.cave_labyrinth_text_air_fail);
                if (!isLuck) {
                    buttonCaveLabyrinthLuck.setVisibility(View.VISIBLE);
                    isLuck = true;
                }
                buttonCaveLabyrinthExit.setVisibility(View.VISIBLE);
                buttonCaveLabyrinthEast.setVisibility(View.GONE);
                buttonCaveLabyrinthWest.setVisibility(View.GONE);
                buttonCaveLabyrinthSouth.setVisibility(View.GONE);
                buttonCaveLabyrinthNorth.setVisibility(View.GONE);
                imageCaveLabyrinth.setVisibility(View.INVISIBLE);
                isFail = true;
            }
            textCounterStep.setText("Количество шагов: " + step);
            for (int k = 0; k < 8; k++) {
                for (int i = 0; i < 8; i++) {
                    map.setPixel(xPixel, height - 1 - yPixel, Color.parseColor(colorBackground));
                    yPixel++;
                }
                yPixel = yMain;
                xPixel++;
            }
            xMain = xPixel;
            yPixel = yMain;

            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 10; i++) {
                    if (getNextRoute(name).isWest() && k == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else if (getNextRoute(name).isEast() && k == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    } else {
                        if (getNextRoute(name).isAir()) {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor("#ff7800"));
                        } else {
                            map.setPixel(xPixel, height - yPixel, Color.parseColor(colorActive));
                        }
                    }

                    if (getNextRoute(name).isSouth() && i == 0) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    if (getNextRoute(name).isNorth() && i == 9) {
                        map.setPixel(xPixel, height - yPixel, Color.parseColor(colorWay));
                    }

                    yPixel++;
                }
                yPixel = yMain;
                xPixel++;
            }
            imageCaveLabyrinth.setImageBitmap(map);
            buttonCaveLabyrinthEast.setBackgroundColor(Color.parseColor("#60ffffff"));
            isEast = false;
        } else {
            buttonCaveLabyrinthNorth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthSouth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthWest.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthEast.setBackgroundColor(Color.parseColor("#607e9e7f"));
            buttonCaveLabyrinthExit.setBackgroundColor(Color.parseColor("#60ffffff"));

            isNorth = false;
            isSouth = false;
            isWest = false;
            isEast = true;
            isExit = false;
        }
    }


    public void onExit(View view) {
        if (isExit) {
            if (getNextRoute(name).isFinish()) {
                getNextScene(new Intent(this, PrologueCaveAfterLabyrinth.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            } else if (getNextRoute(name).isStart()) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_CAVE_RETURN, true);
                editor.apply();
                getNextScene(new Intent(this, PrologueCave.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            } else if (isFail) {
                SharedPreferences.Editor editor = save.edit();
                editor.putBoolean(APP_SAVE_CAVE_FAIL, true);
                editor.putInt(APP_SAVE_WOUND, wound);
                editor.apply();
                getNextScene(new Intent(this, PrologueRain.class));
                overridePendingTransition(R.anim.first_activity_animation, R.anim.second_activity_animation);
                finish();
            }
        } else {
            buttonCaveLabyrinthNorth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthSouth.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthWest.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthEast.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthExit.setBackgroundColor(Color.parseColor("#607e9e7f"));

            isNorth = false;
            isSouth = false;
            isWest = false;
            isEast = false;
            isExit = true;
        }
    }


    public Labyrinth getNextRoute(String name) {
        for (Labyrinth e : routeList) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return x5y2;
    }


    public void getRoute(Labyrinth labyrinth) {
        if (labyrinth.isNorth()) {
            buttonCaveLabyrinthNorth.setVisibility(View.VISIBLE);
        } else {
            buttonCaveLabyrinthNorth.setVisibility(View.GONE);
        }

        if (labyrinth.isSouth()) {
            buttonCaveLabyrinthSouth.setVisibility(View.VISIBLE);
        } else {
            buttonCaveLabyrinthSouth.setVisibility(View.GONE);
        }

        if (labyrinth.isEast()) {
            buttonCaveLabyrinthEast.setVisibility(View.VISIBLE);
        } else {
            buttonCaveLabyrinthEast.setVisibility(View.GONE);
        }

        if (labyrinth.isWest()) {
            buttonCaveLabyrinthWest.setVisibility(View.VISIBLE);
        } else {
            buttonCaveLabyrinthWest.setVisibility(View.GONE);
        }

        if (labyrinth.isFinish() || labyrinth.isStart()) {
            buttonCaveLabyrinthExit.setVisibility(View.VISIBLE);
        } else {
            buttonCaveLabyrinthExit.setVisibility(View.GONE);
        }

        textViewCaveLabyrinth.setText(labyrinth.getText());
    }

    public void onCaveLabyrinthLuck(View view) {
        if (isFortune) {
            if (Fortune.isLuck(fortune, 40)) {
                if (fortune > 20) {
                    fortune -= 10;
                } else {
                    fortune = 10;
                }
                toast = Toast.makeText(this, R.string.cave_labyrinth_text_air_luck_luck, Toast.LENGTH_LONG);
                toast.show();
                imageBackgroundLuckTrue.setVisibility(View.VISIBLE);
                imageBackgroundLuckTrue.startAnimation(luckAnimation);
                buttonCaveLabyrinthLuck.setVisibility(View.GONE);
                getRoute(getNextRoute(name));
                imageCaveLabyrinth.setVisibility(View.VISIBLE);
                step = 8;

            } else {
                if (fortune < 90) {
                    fortune += 10;
                } else {
                    fortune = 100;
                }
                toast = Toast.makeText(this, R.string.cave_labyrinth_text_air_luck_fail, Toast.LENGTH_LONG);
                toast.show();
                buttonCaveLabyrinthLuck.setVisibility(View.GONE);
                imageBackgroundLuckFalse.setVisibility(View.VISIBLE);
                imageBackgroundLuckFalse.startAnimation(luckAnimation);

            }


            isFortune = false;
            buttonCaveLabyrinthLuck.setBackgroundColor(Color.parseColor("#60ffffff"));
        } else {
            buttonCaveLabyrinthExit.setBackgroundColor(Color.parseColor("#60ffffff"));
            buttonCaveLabyrinthLuck.setBackgroundColor(Color.parseColor("#607e9e7f"));
            isFortune = true;
            isExit = false;
        }
    }
}
