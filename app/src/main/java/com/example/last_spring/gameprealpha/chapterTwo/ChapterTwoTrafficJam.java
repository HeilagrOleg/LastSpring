package com.example.last_spring.gameprealpha.chapterTwo;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.example.last_spring.gameprealpha.res.Intersection;
import com.example.last_spring.gameprealpha.res.Street;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoTrafficJam extends GameActivityTwo {

    private ImageButton imageButtonIntersection1;
    private ImageButton imageButtonIntersection2;
    private ImageButton imageButtonIntersection3;
    private ImageButton imageButtonIntersection4;
    private ImageButton imageButtonIntersection5;
    private ImageButton imageButtonIntersection6;
    private ImageButton imageButtonIntersection7;
    private ImageButton imageButtonIntersection8;
    private ImageButton imageButtonIntersection9;
    private ImageButton imageButtonIntersection10;
    private ImageButton imageButtonIntersection11;
    private ImageButton imageButtonIntersection12;
    private ImageButton imageButtonIntersection13;
    private ImageButton imageButtonIntersection14;
    private ImageButton imageButtonIntersection15;
    private ImageButton imageButtonIntersection16;
    private ImageButton imageButtonIntersection17;
    private ImageButton imageButtonIntersection18;
    private ImageButton imageButtonIntersection19;
    private ImageButton imageButtonIntersection20;
    private ImageButton imageButtonIntersection21;
    private ImageButton imageButtonIntersection22;
    private ImageButton imageButtonIntersection23;
    private ImageButton imageButtonIntersection24;

    private ImageButton imageButtonTest;
    private ImageButton imageButtonAnimation;

    private ImageView imageButtonIntersectionActiv1;
    private ImageView imageButtonIntersectionActiv2;
    private ImageView imageButtonIntersectionActiv3;
    private ImageView imageButtonIntersectionActiv4;
    private ImageView imageButtonIntersectionActiv5;
    private ImageView imageButtonIntersectionActiv6;
    private ImageView imageButtonIntersectionActiv7;
    private ImageView imageButtonIntersectionActiv8;
    private ImageView imageButtonIntersectionActiv9;
    private ImageView imageButtonIntersectionActiv10;
    private ImageView imageButtonIntersectionActiv11;
    private ImageView imageButtonIntersectionActiv12;
    private ImageView imageButtonIntersectionActiv13;
    private ImageView imageButtonIntersectionActiv14;
    private ImageView imageButtonIntersectionActiv15;
    private ImageView imageButtonIntersectionActiv16;
    private ImageView imageButtonIntersectionActiv17;
    private ImageView imageButtonIntersectionActiv18;
    private ImageView imageButtonIntersectionActiv19;
    private ImageView imageButtonIntersectionActiv20;
    private ImageView imageButtonIntersectionActiv21;
    private ImageView imageButtonIntersectionActiv22;
    private ImageView imageButtonIntersectionActiv23;
    private ImageView imageButtonIntersectionActiv24;

    private Intersection startIntersection;
    private Intersection nextIntersection;

    private Intersection x3y0;
    private Intersection x3y1;
    private Intersection x4y1;
    private Intersection x3y2;
    private Intersection x2y2;
    private Intersection x4y2;

    private Intersection x2y3;
    private Intersection x3y3;
    private Intersection x4y3;

    private Intersection x1y4;
    private Intersection x2y4;
    private Intersection x3y4;
    private Intersection x4y4;

    private Intersection x3y5;
    private Intersection x4y5;

    private Intersection x2y6;
    private Intersection x3y6;
    private Intersection x4y6;

    private Intersection x1y7;
    private Intersection x2y7;
    private Intersection x3y7;

    private Intersection x2y8;
    private Intersection x3y8;

    private Intersection x3y9;

    private Intersection timeIntersection;

    private Street streetMain;

    private boolean isLuck;

    private int timeMain;
    private int time;

    private Resources res;

    private ArrayList<Street> streets;
    private ArrayList<Intersection> intersections;

    private ArrayList<ImageButton> imageButtons;

    private TextView textIntersectionTime;
    private TextView textIntersectionTimeMain;

    private Animation animation;

    private boolean isIntersection;

    private ArrayList<Boolean> intersectionBooleens;

    private ArrayList<String> streetsMain;

    private ImageButton choiceImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_traffic_jam);

        getSave(10f);

        res = getResources();

        isLuck = false;

        getInterfaceChapterTwo();

        animation = AnimationUtils.loadAnimation(this, R.anim.button_traffic_jam_size_animation);

        textIntersectionTime = (TextView) findViewById(R.id.textIntersectionTimeID);
        textIntersectionTimeMain = (TextView) findViewById(R.id.textIntersectionTimeMainID);

        imageButtonIntersection1 = (ImageButton) findViewById(R.id.imageButtonIntersection1ID);
        imageButtonIntersection2 = (ImageButton) findViewById(R.id.imageButtonIntersection2ID);
        imageButtonIntersection3 = (ImageButton) findViewById(R.id.imageButtonIntersection3ID);
        imageButtonIntersection4 = (ImageButton) findViewById(R.id.imageButtonIntersection4ID);
        imageButtonIntersection5 = (ImageButton) findViewById(R.id.imageButtonIntersection5ID);
        imageButtonIntersection6 = (ImageButton) findViewById(R.id.imageButtonIntersection6ID);
        imageButtonIntersection7 = (ImageButton) findViewById(R.id.imageButtonIntersection7ID);
        imageButtonIntersection8 = (ImageButton) findViewById(R.id.imageButtonIntersection8ID);
        imageButtonIntersection9 = (ImageButton) findViewById(R.id.imageButtonIntersection9ID);
        imageButtonIntersection10 = (ImageButton) findViewById(R.id.imageButtonIntersection10ID);
        imageButtonIntersection11 = (ImageButton) findViewById(R.id.imageButtonIntersection11ID);
        imageButtonIntersection12 = (ImageButton) findViewById(R.id.imageButtonIntersection12ID);
        imageButtonIntersection13 = (ImageButton) findViewById(R.id.imageButtonIntersection13ID);
        imageButtonIntersection14 = (ImageButton) findViewById(R.id.imageButtonIntersection14ID);
        imageButtonIntersection15 = (ImageButton) findViewById(R.id.imageButtonIntersection15ID);
        imageButtonIntersection16 = (ImageButton) findViewById(R.id.imageButtonIntersection16ID);
        imageButtonIntersection17 = (ImageButton) findViewById(R.id.imageButtonIntersection17ID);
        imageButtonIntersection18 = (ImageButton) findViewById(R.id.imageButtonIntersection18ID);
        imageButtonIntersection19 = (ImageButton) findViewById(R.id.imageButtonIntersection19ID);
        imageButtonIntersection20 = (ImageButton) findViewById(R.id.imageButtonIntersection20ID);
        imageButtonIntersection21 = (ImageButton) findViewById(R.id.imageButtonIntersection21ID);
        imageButtonIntersection22 = (ImageButton) findViewById(R.id.imageButtonIntersection22ID);
        imageButtonIntersection23 = (ImageButton) findViewById(R.id.imageButtonIntersection23ID);
        imageButtonIntersection24 = (ImageButton) findViewById(R.id.imageButtonIntersection24ID);

        imageButtonTest = (ImageButton) findViewById(R.id.imageButtonTestID);

        imageButtonIntersectionActiv1 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv1ID);
        imageButtonIntersectionActiv2 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv2ID);
        imageButtonIntersectionActiv3 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv3ID);
        imageButtonIntersectionActiv4 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv4ID);
        imageButtonIntersectionActiv5 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv5ID);
        imageButtonIntersectionActiv6 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv6ID);
        imageButtonIntersectionActiv7 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv7ID);
        imageButtonIntersectionActiv8 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv8ID);
        imageButtonIntersectionActiv9 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv9ID);
        imageButtonIntersectionActiv10 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv10ID);
        imageButtonIntersectionActiv11 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv11ID);
        imageButtonIntersectionActiv12 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv12ID);
        imageButtonIntersectionActiv13 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv13ID);
        imageButtonIntersectionActiv14 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv14ID);
        imageButtonIntersectionActiv15 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv15ID);
        imageButtonIntersectionActiv16 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv16ID);
        imageButtonIntersectionActiv17 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv17ID);
        imageButtonIntersectionActiv18 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv18ID);
        imageButtonIntersectionActiv19 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv19ID);
        imageButtonIntersectionActiv20 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv20ID);
        imageButtonIntersectionActiv21 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv21ID);
        imageButtonIntersectionActiv22 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv22ID);
        imageButtonIntersectionActiv23 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv23ID);
        imageButtonIntersectionActiv24 = (ImageView) findViewById(R.id.imageButtonIntersectionActiv24ID);

        imageButtons = new ArrayList<>(Arrays.asList(
                imageButtonIntersection1,
                imageButtonIntersection2,
                imageButtonIntersection3,
                imageButtonIntersection4,
                imageButtonIntersection5,
                imageButtonIntersection6,
                imageButtonIntersection7,
                imageButtonIntersection8,
                imageButtonIntersection9,
                imageButtonIntersection10,
                imageButtonIntersection11,
                imageButtonIntersection12,
                imageButtonIntersection13,
                imageButtonIntersection14,
                imageButtonIntersection15,
                imageButtonIntersection16,
                imageButtonIntersection17,
                imageButtonIntersection18,
                imageButtonIntersection19,
                imageButtonIntersection20,
                imageButtonIntersection21,
                imageButtonIntersection22,
                imageButtonIntersection23,
                imageButtonIntersection24
        ));

        for (ImageButton e : imageButtons) {
            if (e != imageButtonIntersection1) {
                e.setVisibility(View.GONE);
            }
        }


        Street redFirst = new Street(2, 1, "x3y0", "x3y1");
        Street redSecond = new Street(4, 2, "x3y1", "x3y2");
        Street redThird = new Street(4, 1, "x3y2", "x3y3");
        Street redFour = new Street(3, 1, "x3y3", "x3y4");
        Street redFive = new Street(4, 1, "x3y4", "x3y5");
        Street redSix = new Street(3, 1, "x3y5", "x3y6");
        Street redSeven = new Street(3, 1, "x3y6", "x3y7");
        Street redEight = new Street(3, 1, "x3y7", "x3y8");
        Street redNine = new Street(3, 1, "x3y8", "x3y9");

        Street serFirst = new Street(2, 1, "x2y2", "x2y3");
        Street serSecond = new Street(2, 1, "x2y3", "x2y4");
        Street serThird = new Street(1, 2, "x2y4", "x2y6");
        Street serFour = new Street(3, 1, "x2y6", "x2y7");
        Street serFive = new Street(1, 1, "x2y7", "x2y8");
        Street serSix = new Street(2, 1, "x2y8", "x3y8");

        Street gor = new Street(2, 2, "x3y1", "x4y1");

        Street octFirst = new Street(1, 1, "x2y2", "x3y2");
        Street octSecond = new Street(2, 2, "x3y2", "x4y2");

        Street komFirst = new Street(1, 1, "x2y3", "x3y3");
        Street komSecond = new Street(2, 2, "x3y3", "x4y3");

        Street sveFirst = new Street(1, 1, "x2y4", "x3y4");
        Street sveSecond = new Street(1, 2, "x3y4", "x4y4");

        Street vik = new Street(1, 2, "x3y5", "x4y5");

        Street sibFirst = new Street(2, 1, "x2y6", "x3y6");
        Street sibSecond = new Street(3, 1, "x3y6", "x4y6");

        Street kai = new Street(2, 1, "x2y7", "x3y7");

        Street octMagFirst = new Street(3, 3, "x3y1", "x2y2");
        Street octMagSecond = new Street(3, 3, "x2y2", "x1y4");

        Street ippFirst = new Street(3, 4, "x1y4", "x1y7");
        Street ippSecond = new Street(3, 2, "x1y7", "x2y8");
        Street ippThird = new Street(2, 1, "x2y8", "x3y9");

        Street sovFirst = new Street(2, 2, "x4y1", "x4y2");
        Street sovSecond = new Street(2, 1, "x4y2", "x4y3");
        Street sovThird = new Street(1, 1, "x4y3", "x4y4");
        Street sovFour = new Street(3, 1, "x4y4", "x4y5");
        Street sovFive = new Street(1, 1, "x4y5", "x4y6");
        Street sovSix = new Street(3, 1, "x4y6", "x3y7");

        timeMain = 0;
        time = 0;

        intersections = new ArrayList<>(Arrays.asList(
                x3y0 = new Intersection("x3y0", imageButtonIntersection1, imageButtonIntersectionActiv1),
                x3y1 = new Intersection("x3y1", imageButtonIntersection2, imageButtonIntersectionActiv2),
                x4y1 = new Intersection("x4y1", imageButtonIntersection3, imageButtonIntersectionActiv3),
                x2y2 = new Intersection("x2y2", imageButtonIntersection4, imageButtonIntersectionActiv4),
                x3y2 = new Intersection("x3y2", imageButtonIntersection5, imageButtonIntersectionActiv5),
                x4y2 = new Intersection("x4y2", imageButtonIntersection6, imageButtonIntersectionActiv6),
                x2y3 = new Intersection("x2y3", imageButtonIntersection7, imageButtonIntersectionActiv7),
                x3y3 = new Intersection("x3y3", imageButtonIntersection8, imageButtonIntersectionActiv8),
                x4y3 = new Intersection("x4y3", imageButtonIntersection9, imageButtonIntersectionActiv9),
                x1y4 = new Intersection("x1y4", imageButtonIntersection10, imageButtonIntersectionActiv10),
                x2y4 = new Intersection("x2y4", imageButtonIntersection11, imageButtonIntersectionActiv11),
                x3y4 = new Intersection("x3y4", imageButtonIntersection12, imageButtonIntersectionActiv12),
                x4y4 = new Intersection("x4y4", imageButtonIntersection13, imageButtonIntersectionActiv13),
                x3y5 = new Intersection("x3y5", imageButtonIntersection14, imageButtonIntersectionActiv14),
                x4y5 = new Intersection("x4y5", imageButtonIntersection15, imageButtonIntersectionActiv15),
                x2y6 = new Intersection("x2y6", imageButtonIntersection16, imageButtonIntersectionActiv16),
                x3y6 = new Intersection("x3y6", imageButtonIntersection17, imageButtonIntersectionActiv17),
                x4y6 = new Intersection("x4y6", imageButtonIntersection18, imageButtonIntersectionActiv18),
                x1y7 = new Intersection("x1y7", imageButtonIntersection19, imageButtonIntersectionActiv19),
                x2y7 = new Intersection("x2y7", imageButtonIntersection20, imageButtonIntersectionActiv20),
                x3y7 = new Intersection("x3y7", imageButtonIntersection21, imageButtonIntersectionActiv21),
                x2y8 = new Intersection("x2y8", imageButtonIntersection22, imageButtonIntersectionActiv22),
                x3y8 = new Intersection("x3y8", imageButtonIntersection23, imageButtonIntersectionActiv23),
                x3y9 = new Intersection("x3y9", imageButtonIntersection24, imageButtonIntersectionActiv24)
        ));


        streets = new ArrayList<>(Arrays.asList(
                redFirst,
                redSecond,
                redThird,
                redFour,
                redFive,
                redSix,
                redSeven,
                redEight,
                redNine,
                serFirst,
                serSecond,
                serThird,
                serFour,
                serFive,
                serSix,
                gor,
                octFirst,
                octSecond,
                komFirst,
                komSecond,
                sveFirst,
                sveSecond,
                vik,
                sibFirst,
                sibSecond,
                kai,
                octMagFirst,
                octMagSecond,
                ippFirst,
                ippSecond,
                ippThird,
                sovFirst,
                sovSecond,
                sovThird,
                sovFour,
                sovFive,
                sovSix
        ));


        startIntersection = x3y0;

        res = getResources();

        choiceImageButton = imageButtonIntersection1;

        streetsMain = new ArrayList<>(4);

        imageButtonAnimation = imageButtonIntersection1;

        timeIntersection = x3y0;

        for (Intersection e : intersections) {
            e.getImageView().setVisibility(View.GONE);
        }

        imageButtonIntersection1.setVisibility(View.VISIBLE);

        onIntersection(imageButtonIntersection1);
        onIntersection(imageButtonIntersection1);
    }


    private void getDirection(Intersection intersection) {
        streetsMain.clear();
        for (Street e : streets) {
            if (e.getFirstIntersection().equals(intersection.getName()) || e.getSecondIntersection().equals(intersection.getName())) {
                streetsMain.add(e.getFirstIntersection());
                streetsMain.add(e.getSecondIntersection());
            }
        }

        for (Intersection a : intersections) {
            if (streetsMain.contains(a.getName())) {
                a.getImageButton().setVisibility(View.VISIBLE);
                a.getImageButton().setImageDrawable(res.getDrawable(R.drawable.button_background_traffic_jam_no_activ));
                a.getImageView().setVisibility(View.GONE);
            } else {
                a.getImageButton().setVisibility(View.GONE);
                a.getImageView().setVisibility(View.GONE);
            }
        }
    }


    public void onIntersection(View view) {
        Intersection a = x1y4;
        for (Intersection e : intersections) {
            if (view == e.getImageButton()) {
                a = e;
            }
        }
        timeIntersection = a;
        if (isIntersection && nextIntersection.getName().equals(a.getName())) {
            getIntersectionMain(a);
            timeMain += time;
            if (isLuck) {
                getFortuneChange(-3);
            }
            String strTime = "Всего времени: " + timeMain;
            textIntersectionTimeMain.setText(strTime);
            getDirection(startIntersection);
            getAnimationButton(a.getImageButton());
            isIntersection = false;
            a.getImageView().setVisibility(View.VISIBLE);
        } else {
            nextIntersection = a;
            getTimeIntersection(a);
            getChoiceIntersection(a.getImageButton());
            isIntersection = true;
        }

    }

    public void onIntersectionFinish(View view) {
        Intersection a = x1y4;
        for (Intersection e : intersections) {
            if (view == e.getImageButton()) {
                a = e;
            }
        }
        timeIntersection = a;
        if (isIntersection && nextIntersection.getName().equals(a.getName())) {

            date += time + 1;
            getTime();
            getFortuneChange(-3);

            new CountDownTimer(4000, 4000) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    getNextScene(ChapterTwoInstituteEntrance.class);
                    finish();
                }
            }.start();

        } else {
            nextIntersection = a;
            getTimeIntersection(a);
            getChoiceIntersection(a.getImageButton());
            isIntersection = true;
        }

    }


    private void getTimeIntersection(Intersection intersection) {
        for (Street e : streets) {
            if ((e.getFirstIntersection().equals(startIntersection.getName()) && e.getSecondIntersection().equals(intersection.getName()) ||
                    (e.getFirstIntersection().equals(intersection.getName()) && e.getSecondIntersection().equals(startIntersection.getName())
                    ))) {
                if (isLuck) {
                    if (e.getComplexity() != 1) {
                        time = (e.getComplexity() - 1) * e.getDistance();
                    } else {
                        time = e.getComplexity() * e.getDistance();
                    }
                } else {
                    time = e.getComplexity() * e.getDistance();
                }
                String text = "Время пути " + time;
                textIntersectionTime.setText(text);
            }
        }
    }

    private void getChoiceIntersection(ImageButton imageButton) {
        choiceImageButton.setImageDrawable(res.getDrawable(R.drawable.button_background_traffic_jam_no_activ));
        choiceImageButton = imageButton;
        choiceImageButton.setImageDrawable(res.getDrawable(R.drawable.button_background_traffic_jam_activ));
    }

    private void getIntersectionMain(Intersection intersection) {
        choiceImageButton = imageButtonTest;
        startIntersection.getImageButton().setClickable(true);
        startIntersection = intersection;
        startIntersection.getImageButton().setClickable(false);
    }

    private void getAnimationButton(ImageButton imageButton) {
        imageButtonAnimation.clearAnimation();
        imageButtonAnimation = imageButton;
        imageButton.setImageDrawable(res.getDrawable(R.drawable.button_background_traffic_jam));
        imageButton.startAnimation(animation);
    }

    public void onTrafficJamLuck(View view) {
        if (isLuck) {
            isLuck = false;
            getTimeIntersection(timeIntersection);
            getLuckImage(true);
            view.setBackgroundColor(Color.parseColor("#5a595b"));
        } else {
            isLuck = true;
            getLuckImage(false);
            getTimeIntersection(timeIntersection);
            view.setBackgroundColor(Color.parseColor("#303030"));
        }
    }
}
