package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_spring.gameprealpha.R;
import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.example.last_spring.gameprealpha.res.Intersection;
import com.example.last_spring.gameprealpha.res.Street;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoTrafficJamTest extends GameActivityTwo {

    private ImageButton imageButtonIntersectionTest1;
    private ImageButton imageButtonIntersectionTest2;
    private ImageButton imageButtonIntersectionTest3;
    private ImageButton imageButtonIntersectionTest4;
    private ImageButton imageButtonIntersectionTest5;
    private ImageButton imageButtonIntersectionTest6;
    private ImageButton imageButtonIntersectionTest7;
    private ImageButton imageButtonIntersectionTest8;
    private ImageButton imageButtonIntersectionTest9;
    private ImageButton imageButtonIntersectionTest10;
    private ImageButton imageButtonIntersectionTest11;

    private ImageButton imageButtonTest;
    private ImageButton imageButtonAnimation;

    private ImageView imageButtonIntersectionTestAvtiv1;
    private ImageView imageButtonIntersectionTestAvtiv2;
    private ImageView imageButtonIntersectionTestAvtiv3;
    private ImageView imageButtonIntersectionTestAvtiv4;
    private ImageView imageButtonIntersectionTestAvtiv5;
    private ImageView imageButtonIntersectionTestAvtiv6;
    private ImageView imageButtonIntersectionTestAvtiv7;
    private ImageView imageButtonIntersectionTestAvtiv8;
    private ImageView imageButtonIntersectionTestAvtiv9;
    private ImageView imageButtonIntersectionTestAvtiv10;
    private ImageView imageButtonIntersectionTestAvtiv11;

    private FrameLayout frameJamTest1;
    private FrameLayout frameJamTest2;

    private Intersection startIntersection;
    private Intersection nextIntersection;
    private Intersection timeIntersection;

    private Intersection x0y0;
    private Intersection x1y0;
    private Intersection x1y1;
    private Intersection x1y2;
    private Intersection x2y2;
    private Intersection x3y2;
    private Intersection x2y3;
    private Intersection x1y4;
    private Intersection x2y4;
    private Intersection x3y4;
    private Intersection x2y5;

    Street street1;
    Street street2;
    Street street3;
    Street street4;
    Street street5;
    Street street6;
    Street street7;
    Street street8;
    Street street9;
    Street street10;
    Street street11;
    Street street12;
    Street street13;
    Street street14;

    private int timeMain;
    private int time;

    private Resources res;

    private ArrayList<Street> streets;
    private ArrayList<Intersection> intersections;

    private ArrayList<ImageButton> imageButtons;

    private TextView textIntersectionTimeTest;
    private TextView textIntersectionTimeMainTest;

    private boolean isIntersection;

    private ArrayList<String> streetsMain;

    private ImageButton choiceImageButton;

    private Animation animation;

    private boolean isLuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_traffic_jam_test);

        getSave(9f);

        isLuck = false;

        animation = AnimationUtils.loadAnimation(this, R.anim.button_traffic_jam_size_animation);

        getInterfaceChapterTwo();

        imageButtonIntersectionTest1 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest1ID);
        imageButtonIntersectionTest2 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest2ID);
        imageButtonIntersectionTest3 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest3ID);
        imageButtonIntersectionTest4 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest4ID);
        imageButtonIntersectionTest5 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest5ID);
        imageButtonIntersectionTest6 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest6ID);
        imageButtonIntersectionTest7 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest7ID);
        imageButtonIntersectionTest8 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest8ID);
        imageButtonIntersectionTest9 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest9ID);
        imageButtonIntersectionTest10 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest10ID);
        imageButtonIntersectionTest11 = (ImageButton) findViewById(R.id.imageButtonIntersectionTest11ID);

        imageButtonTest = (ImageButton) findViewById(R.id.imageButtonTestTestID);

        imageButtonIntersectionTestAvtiv1 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv1ID);
        imageButtonIntersectionTestAvtiv2 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv2ID);
        imageButtonIntersectionTestAvtiv3 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv3ID);
        imageButtonIntersectionTestAvtiv4 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv4ID);
        imageButtonIntersectionTestAvtiv5 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv5ID);
        imageButtonIntersectionTestAvtiv6 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv6ID);
        imageButtonIntersectionTestAvtiv7 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv7ID);
        imageButtonIntersectionTestAvtiv8 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv8ID);
        imageButtonIntersectionTestAvtiv9 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv9ID);
        imageButtonIntersectionTestAvtiv10 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv10ID);
        imageButtonIntersectionTestAvtiv11 = (ImageView) findViewById(R.id.imageButtonIntersectionTestAvtiv11ID);


        frameJamTest1 = (FrameLayout) findViewById(R.id.frameJamTest1ID);
        frameJamTest2 = (FrameLayout) findViewById(R.id.frameJamTest2ID);

        textIntersectionTimeTest = (TextView) findViewById(R.id.textIntersectionTimeTestID);
        textIntersectionTimeMainTest = (TextView) findViewById(R.id.textIntersectionTimeMainTestID);

        intersections = new ArrayList<>(Arrays.asList(
                x0y0 = new Intersection("x0y0", imageButtonIntersectionTest1, imageButtonIntersectionTestAvtiv1),
                x1y0 = new Intersection("x1y0", imageButtonIntersectionTest2, imageButtonIntersectionTestAvtiv2),
                x1y1 = new Intersection("x1y1", imageButtonIntersectionTest3, imageButtonIntersectionTestAvtiv3),
                x1y2 = new Intersection("x1y2", imageButtonIntersectionTest4, imageButtonIntersectionTestAvtiv4),
                x2y2 = new Intersection("x2y2", imageButtonIntersectionTest5, imageButtonIntersectionTestAvtiv5),
                x3y2 = new Intersection("x3y2", imageButtonIntersectionTest6, imageButtonIntersectionTestAvtiv6),
                x2y3 = new Intersection("x2y3", imageButtonIntersectionTest7, imageButtonIntersectionTestAvtiv7),
                x1y4 = new Intersection("x1y4", imageButtonIntersectionTest8, imageButtonIntersectionTestAvtiv8),
                x2y4 = new Intersection("x2y4", imageButtonIntersectionTest9, imageButtonIntersectionTestAvtiv9),
                x3y4 = new Intersection("x3y4", imageButtonIntersectionTest10, imageButtonIntersectionTestAvtiv10),
                x2y5 = new Intersection("x2y5", imageButtonIntersectionTest11, imageButtonIntersectionTestAvtiv11)
        ));

        imageButtons = new ArrayList<>(Arrays.asList(

                imageButtonIntersectionTest1,
                imageButtonIntersectionTest2,
                imageButtonIntersectionTest3,
                imageButtonIntersectionTest4,
                imageButtonIntersectionTest5,
                imageButtonIntersectionTest6,
                imageButtonIntersectionTest7,
                imageButtonIntersectionTest8,
                imageButtonIntersectionTest9,
                imageButtonIntersectionTest10,
                imageButtonIntersectionTest11


        ));

        for (ImageButton e : imageButtons) {
            if (e != imageButtonIntersectionTest1) {
                e.setVisibility(View.GONE);
            }
        }


        time = 0;
        timeMain = 0;

        streets = new ArrayList<>(Arrays.asList(
                street1 = new Street(1, 1, "x0y0", "x1y0"),
                street2 = new Street(3, 1, "x1y0", "x1y1"),
                street3 = new Street(2, 3, "x1y0", "x3y2"),
                street4 = new Street(2, 1, "x1y1", "x1y2"),
                street5 = new Street(1, 2, "x1y1", "x2y2"),
                street6 = new Street(1, 1, "x1y2", "x2y2"),
                street7 = new Street(1, 3, "x2y2", "x3y2"),
                street8 = new Street(2, 2, "x1y2", "x1y4"),
                street9 = new Street(1, 1, "x2y2", "x2y3"),
                street10 = new Street(2, 3, "x3y2", "x3y4"),
                street11 = new Street(1, 1, "x1y4", "x2y4"),
                street12 = new Street(1, 1, "x2y4", "x3y4"),
                street13 = new Street(1, 1, "x2y4", "x2y5"),
                street14 = new Street(3, 1, "x2y3", "x2y4")
        ));

        res = getResources();

        startIntersection = x0y0;

        choiceImageButton = (ImageButton) findViewById(R.id.imageButtonIntersectionTest1ID);

        imageButtonAnimation = imageButtonIntersectionTest1;

        streetsMain = new ArrayList<>(4);

        timeIntersection = x0y0;

        onIntersectionTest(imageButtonIntersectionTest1);
        onIntersectionTest(imageButtonIntersectionTest1);
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

    public void onIntersectionTest(View view) {
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
            String strTime = "Всего времени: " + timeMain;
            textIntersectionTimeMainTest.setText(strTime);
            getDirection(startIntersection);
            getFortuneChange(-3);
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
                textIntersectionTimeTest.setText(text);
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

    public void onIntersectionTestFinish(View view) {
        Intersection a = x1y4;
        for (Intersection e : intersections) {
            if (view == e.getImageButton()) {
                a = e;
            }
        }
        if (isIntersection && nextIntersection.getName().equals(a.getName())) {
            date += time + 1;
            getTime();
            getFortuneChange(-3);

            new CountDownTimer(4000, 4000) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    getNextScene(ChapterTwoTrafficJam.class);
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

    public void onTrafficJamLuckTest(View view) {
        if (isLuck) {
            isLuck = false;
            getTimeIntersection(timeIntersection);
            view.setBackgroundColor(Color.parseColor("#5a595b"));
        } else {
            isLuck = true;
            getTimeIntersection(timeIntersection);
            view.setBackgroundColor(Color.parseColor("#303030"));
        }
    }
}
