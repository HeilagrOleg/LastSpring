package com.example.last_spring.gameprealpha.chapterTwo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.last_spring.gameprealpha.res.GameActivityTwo;
import com.example.last_spring.gameprealpha.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ChapterTwoApartment extends GameActivityTwo {

    private ImageView imageChapterTwoApartmentFirstCupboard;
    private ImageView imageChapterTwoApartmentFirstLeftMain;
    private ImageView imageChapterTwoApartmentFirstLeftActive;

    private ImageView imageChapterTwoApartmentFirsRightTopMain;
    private ImageView imageChapterTwoApartmentFirstFlashTopMain;
    private ImageView imageChapterTwoApartmentFirsRightBottomActive;
    private ImageView imageChapterTwoApartmentFirsRightBottomMain;

    private ImageView imageChapterTwoApartmentFirsRightBottomListActive;
    private ImageView imageChapterTwoApartmentFirsRightBottomListMain;

    private ImageView imageChapterTwoApartmentThirdTopFolderMain;

    private ImageView imageChapterTwoApartmentSecondKeyActive;
    private ImageView imageChapterTwoApartmentSecondKeyMain;

    private ImageView imageChapterTwoApartmentThirdBottomCartActive;
    private ImageView imageChapterTwoApartmentThirdBottomCartMain;

    private RelativeLayout layoutApartmentMain;

    private HorizontalScrollView scrollApartment;

    private LinearLayout imageChapterTwoApartmentFirst;
    private LinearLayout imageChapterTwoApartmentSecond;
    private LinearLayout imageChapterTwoApartmentThird;

    private LinearLayout layoutApartmentThings;

    private LinearLayout layoutScrollApartment;

    private Resources res;

    private ArrayList<ImageView> beacons;

    private int cupboard;
    private int flash;
    private int list;
    private int key;
    private int folder;
    private int cart;
    private int listCounter;

    private ProgressBar progressBarApartmentCart;
    private ProgressBar progressBarApartmentFlash;
    private ProgressBar progressBarApartmentKey;
    private ProgressBar progressBarApartmentList;

    private ImageView beaconFirst;
    private ImageView beaconSecond;
    private ImageView beaconThird;
    private ImageView beaconFour;
    private ImageView beaconFive;
    private ImageView beaconSix;

    private ImageButton buttonHelpApartment;

    private boolean isCap;
    private boolean isSheet;
    private boolean isCard;
    private boolean isSearch;

    private boolean isSleep;
    private boolean isPhoto;

    private boolean isHelp;

    private boolean isFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two_apartment);

        getButtons();

        isSleep = true;

        listCounter = 0;

        cupboard = 0;
        folder = 0;
        flash = 0;
        list = 0;
        cart = 0;
        key = 0;

        date = 420;

        respectAlin = 30;

        startAnimationChapterTwo(new ArrayList<View>(Arrays.asList(scrollChapterTwo, radioGroupChapterTwo)));

        getInterfaceChapterTwo();

        layoutApartmentMain = (RelativeLayout) findViewById(R.id.layoutApartmentMainID);
        scrollApartment = (HorizontalScrollView) findViewById(R.id.scrollApartmentID);

        imageChapterTwoApartmentFirst = (LinearLayout) findViewById(R.id.imageChapterTwoApartmentFirstID);
        imageChapterTwoApartmentSecond = (LinearLayout) findViewById(R.id.imageChapterTwoApartmentSecondID);
        imageChapterTwoApartmentThird = (LinearLayout) findViewById(R.id.imageChapterTwoApartmentThirdID);

        imageChapterTwoApartmentFirstCupboard = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirstCupboardID);
        imageChapterTwoApartmentFirstLeftMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirstLeftMainID);
        imageChapterTwoApartmentFirstLeftActive = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirstLeftActiveID);

        imageChapterTwoApartmentFirsRightTopMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirsRightTopMainID);
        imageChapterTwoApartmentFirstFlashTopMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirstFlashTopMainID);
        imageChapterTwoApartmentFirsRightBottomActive = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirsRightBottomActiveID);
        imageChapterTwoApartmentFirsRightBottomMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirsRightBottomMainID);

        imageChapterTwoApartmentFirsRightBottomListActive = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirsRightBottomListActiveID);
        imageChapterTwoApartmentFirsRightBottomListMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentFirsRightBottomListMainID);

        imageChapterTwoApartmentSecondKeyActive = (ImageView) findViewById(R.id.imageChapterTwoApartmentSecondKeyActiveID);
        imageChapterTwoApartmentSecondKeyMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentSecondKeyMainID);

        imageChapterTwoApartmentThirdBottomCartActive = (ImageView) findViewById(R.id.imageChapterTwoApartmentThirdBottomCartActiveID);
        imageChapterTwoApartmentThirdBottomCartMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentThirdBottomCartMainID);

        imageChapterTwoApartmentThirdTopFolderMain = (ImageView) findViewById(R.id.imageChapterTwoApartmentThirdTopFolderMainID);

        layoutScrollApartment = (LinearLayout) findViewById(R.id.layoutScrollApartmentID);

        layoutApartmentThings = (LinearLayout) findViewById(R.id.layoutApartmentThingsID);

        beaconFirst = (ImageView) findViewById(R.id.beaconFirstID);
        beaconSecond = (ImageView) findViewById(R.id.beaconSecondID);
        beaconThird = (ImageView) findViewById(R.id.beaconThirdID);
        beaconFour = (ImageView) findViewById(R.id.beaconFourID);
        beaconFive = (ImageView) findViewById(R.id.beaconFiveID);
        beaconSix = (ImageView) findViewById(R.id.beaconSixID);

        progressBarApartmentCart = (ProgressBar) findViewById(R.id.progressBarApartmentCartID);
        progressBarApartmentFlash = (ProgressBar) findViewById(R.id.progressBarApartmentFlashID);
        progressBarApartmentKey = (ProgressBar) findViewById(R.id.progressBarApartmentKeyID);
        progressBarApartmentList = (ProgressBar) findViewById(R.id.progressBarApartmentListID);

        buttonHelpApartment = (ImageButton) findViewById(R.id.buttonHelpApartmentID);

        res = getResources();

        fortune = 20;

        isCap = true;
        isSheet = true;
        isCard = true;

        scrollApartment.setHorizontalScrollBarEnabled(false);

        beacons = new ArrayList<>(Arrays.asList(
                beaconFirst,
                beaconSecond,
                beaconThird,
                beaconFour,
                beaconFive,
                beaconSix
        ));


    }


    public void onChapterTwoFirst(View view) {
        if (isFirst) {
            refreshScroll(scrollChapterTwo);
            if (isSleep) {
                textChapterTwo.setText(R.string.chapter_two_apartment_text_sleep_first);
                buttonChapterTwoFirst.setText(R.string.chapter_two_apartment_button_photo_first);
                buttonChapterTwoSecond.setText(R.string.chapter_two_apartment_button_photo_second);
                isSleep = false;
                isPhoto = true;
            } else if (isPhoto) {
                textChapterTwo.setText(R.string.chapter_two_apartment_text_photo_first);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                isPhoto = false;
            }
            isFirst = false;
            buttonChapterTwoFirst.setBackgroundColor(Color.parseColor(colorButton));
        } else {
            getChoiceButton(buttonChapterTwoFirst);
            isFirst = true;
        }
    }

    public void onChapterTwoSecond(View view) {
        if (isSecond) {
            refreshScroll(scrollChapterTwo);
            if (isSleep) {
                textChapterTwo.setText(R.string.chapter_two_apartment_text_sleep_second);
                buttonChapterTwoFirst.setText(R.string.chapter_two_apartment_button_photo_first);
                buttonChapterTwoSecond.setText(R.string.chapter_two_apartment_button_photo_second);
                isSleep = false;
                isPhoto = true;
            } else if (isPhoto) {
                textChapterTwo.setText(R.string.chapter_two_apartment_text_photo_second);
                buttonChapterTwoFirst.setVisibility(View.GONE);
                buttonChapterTwoSecond.setVisibility(View.GONE);
                buttonChapterTwoThird.setVisibility(View.VISIBLE);
                isPhoto = false;
            }
            isSecond = false;
            buttonChapterTwoSecond.setBackgroundColor(Color.parseColor(colorButton));
        } else {
            getChoiceButton(buttonChapterTwoSecond);
            isSecond = true;
        }
    }

    public void onChapterTwoThird(View view) {
        if (isThird) {
            scrollApartment.setHorizontalScrollBarEnabled(true);
            ObjectAnimator.ofFloat(scrollChapterTwo, View.ALPHA, 1, 0).start();
            ObjectAnimator.ofFloat(radioGroupChapterTwo, View.ALPHA, 1, 0).start();
            startAnimationChapterTwo(layoutApartmentThings);
            startAnimationChapterTwo(buttonHelpApartment);
            date = 450;
            getTimeApartment();
            getTime();
            buttonHelpApartment.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_help_animation));
            new CountDownTimer(200, 200) {
                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    scrollChapterTwo.setVisibility(View.GONE);
                    radioGroupChapterTwo.setVisibility(View.GONE);
                }
            }.start();
            isSearch = true;
            isThird = false;
            buttonChapterTwoThird.setBackgroundColor(Color.parseColor(colorButton));
        } else {
            getChoiceButton(buttonChapterTwoThird);
            isThird = true;
        }
    }

    public void onChapterTwoFour(View view) {
        if (isFour) {
            getNextScene(ChapterTwoPorch.class);
            finish();
            isFour = false;
            buttonChapterTwoFour.setBackgroundColor(Color.parseColor(colorButton));
        } else {
            getChoiceButton(buttonChapterTwoFour);
            isFour = true;
        }
    }

    public void onChapterTwoApartmentFirstCupboard(View view) {
        if (isSearch) {
            switch (cupboard) {
                case 0:
                    animationSearch(imageChapterTwoApartmentFirstLeftActive);
                    cupboard++;
                    break;
                case 1:
                    animationSearch(imageChapterTwoApartmentFirstLeftMain);
                    cupboard++;
                    listCounter += 33;
                    progressBarApartmentList.setProgress(listCounter);
                    getFinal();
                    view.setClickable(false);
                    break;
            }
        }
    }

    public void onChapterTwoApartmentFirstFlashMain(View view) {
        switch (flash) {
            case 0:
                animationSecond(imageChapterTwoApartmentFirsRightTopMain);
                imageChapterTwoApartmentFirstFlashTopMain.setClickable(false);
                animationSecond(imageChapterTwoApartmentFirsRightBottomMain);
                flash++;
                break;
            case 1:
                animationSecond(imageChapterTwoApartmentFirsRightBottomActive);
                view.setClickable(false);
                progressBarApartmentFlash.setProgress(100);
                flash++;
                getFinal();
                break;
        }
    }

    public void onChapterTwoApartmentFirstListBottomMain(View view) {
        switch (list) {
            case 0:
                animationSecond(imageChapterTwoApartmentFirsRightBottomListMain);
                list++;
                break;
            case 1:
                animationSecond(imageChapterTwoApartmentFirsRightBottomListActive);
                list++;
                listCounter += 33;
                progressBarApartmentList.setProgress(listCounter);
                getFinal();
                view.setClickable(false);
                break;
        }
    }

    public void animationSearch(View view) {

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.title_in));
        view.setVisibility(View.VISIBLE);
    }

    public void animationSecond(View view) {

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.things_apartment_animation));
        view.setVisibility(View.INVISIBLE);
    }


    public void onChapterTwoApartmentSecondKey(View view) {
        switch (key) {
            case 0:
                animationSecond(imageChapterTwoApartmentSecondKeyMain);
                key++;
                break;
            case 1:
                animationSecond(imageChapterTwoApartmentSecondKeyActive);
                key++;
                progressBarApartmentKey.setProgress(100);
                getFinal();
                view.setClickable(false);
                break;
        }
    }

    public void onChapterTwoApartmentThirdTopFolder(View view) {
        animationSecond(imageChapterTwoApartmentThirdTopFolderMain);
        folder = 2;
        listCounter += 34;
        progressBarApartmentList.setProgress(listCounter);
        getFinal();
        view.setClickable(false);
    }

    public void onChapterTwoApartmentThirdBottomCart(View view) {
        switch (cart) {
            case 0:
                animationSecond(imageChapterTwoApartmentThirdBottomCartMain);
                cart++;
                break;
            case 1:
                animationSecond(imageChapterTwoApartmentThirdBottomCartActive);
                cart++;
                progressBarApartmentCart.setProgress(100);
                view.setClickable(false);
                getFinal();
                break;
        }
    }

    private void getFinal() {

        if (cart == 2 && folder == 2 && key == 2 && cupboard == 2 && list == 2 && flash == 2) {

            isFinish = true;
            date += 5;

            new CountDownTimer(500, 500) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    getTime();
                    buttonHelpApartment.setVisibility(View.GONE);
                    buttonChapterTwoFirst.setVisibility(View.GONE);
                    radioGroupChapterTwo.setVisibility(View.VISIBLE);
                    ObjectAnimator.ofFloat(scrollChapterTwo, View.ALPHA, 0, 1).start();
                    ObjectAnimator.ofFloat(radioGroupChapterTwo, View.ALPHA, 0, 1).start();
                    scrollChapterTwo.setVisibility(View.VISIBLE);
                    buttonChapterTwoSecond.setVisibility(View.GONE);
                    layoutApartmentThings.setVisibility(View.GONE);
                    buttonChapterTwoThird.setVisibility(View.GONE);
                    buttonChapterTwoFour.setVisibility(View.VISIBLE);
                    buttonChapterTwoFour.setText(R.string.chapter_two_apartment_button_exit);
                    textChapterTwo.setText(R.string.chapter_two_apartment_text_final);
                }
            }.start();
        }
    }

    public void onBeacon(View view) {
        if (isHelp) {
            for (ImageView e : beacons
                    ) {
                startAnimationChapterTwo(e);
            }
            fortune -= 20;
            showMessageChapterTwo(R.string.chapter_two_message_luck_down);
            getLuckImage(false);
            animationSecond(view);
            view.setVisibility(View.GONE);
        } else {
            isHelp = true;
            showMessageChapterTwo(R.string.chapter_two_apartment_message_help);
        }
    }

    private void getTimeApartment() {
        new CountDownTimer(180000, 180000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                if (!isFinish) {
                    date += 10;
                    getTime();

                }
            }
        }.start();
    }
}
