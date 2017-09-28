package com.example.last_spring.gameprealpha.res;

import com.example.last_spring.gameprealpha.AbandonedCar;
import com.example.last_spring.gameprealpha.CaveLabyrinth;
import com.example.last_spring.gameprealpha.HuntingLodge;
import com.example.last_spring.gameprealpha.HuntingLodgeAfter;
import com.example.last_spring.gameprealpha.HuntingLodgeCutScene;
import com.example.last_spring.gameprealpha.HuntingLodgeExit;
import com.example.last_spring.gameprealpha.HuntingLodgeHunter;
import com.example.last_spring.gameprealpha.HuntingLodgeInside;
import com.example.last_spring.gameprealpha.PrologueBackpackAfterCutScene;
import com.example.last_spring.gameprealpha.PrologueBackpackHunter;
import com.example.last_spring.gameprealpha.PrologueBadEnding;
import com.example.last_spring.gameprealpha.PrologueBeforeBreakage;
import com.example.last_spring.gameprealpha.PrologueBonfire;
import com.example.last_spring.gameprealpha.PrologueBreakage;
import com.example.last_spring.gameprealpha.PrologueCave;
import com.example.last_spring.gameprealpha.PrologueCaveAfterLabyrinth;
import com.example.last_spring.gameprealpha.PrologueDownBackpackCutScene;
import com.example.last_spring.gameprealpha.PrologueDownFirstScene;
import com.example.last_spring.gameprealpha.PrologueDownSecondSceneBackPack;
import com.example.last_spring.gameprealpha.PrologueDownSecondSceneNoBackPack;
import com.example.last_spring.gameprealpha.PrologueGoodEnding;
import com.example.last_spring.gameprealpha.PrologueOldStory;
import com.example.last_spring.gameprealpha.PrologueOldStoryAttack;
import com.example.last_spring.gameprealpha.PrologueRain;
import com.example.last_spring.gameprealpha.PrologueStart;

public class LevelsList {
    public static Class getLevel(float level) {
        if (level == 0.1f) {
            return PrologueOldStory.class;
        }
        if (level == 0.2f) {
            return PrologueOldStoryAttack.class;
        }
        if (level == 1) {
            return PrologueStart.class;
        }
        if (level == 1.10f) {
            return AbandonedCar.class;
        }
        if (level == 1.11f) {
            return HuntingLodge.class;
        }
        if (level == 1.12f) {
            return HuntingLodgeInside.class;
        }
        if (level == 1.13f) {
            return HuntingLodgeCutScene.class;
        }
        if (level == 1.14f) {
            return HuntingLodgeHunter.class;
        }
        if (level == 1.15f) {
            return HuntingLodgeExit.class;
        }
        if (level == 1.16f) {
            return HuntingLodgeAfter.class;
        }
        if (level == 2.1f) {
            return PrologueDownFirstScene.class;
        }
        if (level == 2.101f) {
            return PrologueBonfire.class;
        }
        if (level == 2.102f) {
            return PrologueBackpackHunter.class;
        }
        if (level == 2.11f) {
            return PrologueDownSecondSceneNoBackPack.class;
        }
        if (level == 2.12f) {
            return PrologueDownSecondSceneBackPack.class;
        }
        if (level == 2.121f) {
            return PrologueDownBackpackCutScene.class;
        }
        if (level == 2.122f) {
            return PrologueBackpackAfterCutScene.class;
        }
        if (level == 2.13f) {
            return PrologueCave.class;
        }
        if (level == 2.131f) {
            return CaveLabyrinth.class;
        }
        if (level == 2.14f) {
            return PrologueCaveAfterLabyrinth.class;
        }
        if (level == 2.141f) {
            return PrologueRain.class;
        }
        if (level == 3.0f) {
            return PrologueBeforeBreakage.class;
        }
        if (level == 4.0f) {
            return PrologueBreakage.class;
        }

        if (level == 5.0f) {
            return PrologueGoodEnding.class;
        }

        if (level == 5.1f) {
            return PrologueBadEnding.class;
        }
        return null;
    }
}