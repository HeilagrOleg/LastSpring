package com.example.last_spring.gameprealpha.res;

import com.example.last_spring.gameprealpha.prologue.PrologueAbandonedCar;
import com.example.last_spring.gameprealpha.prologue.PrologueCaveLabyrinth;
import com.example.last_spring.gameprealpha.prologue.PrologueHuntingLodge;
import com.example.last_spring.gameprealpha.prologue.PrologueHuntingLodgeAfter;
import com.example.last_spring.gameprealpha.prologue.PrologueHuntingLodgeCutScene;
import com.example.last_spring.gameprealpha.prologue.PrologueHuntingLodgeExit;
import com.example.last_spring.gameprealpha.prologue.PrologueHuntingLodgeHunter;
import com.example.last_spring.gameprealpha.prologue.PrologueHuntingLodgeInside;
import com.example.last_spring.gameprealpha.prologue.PrologueBackpackAfterCutScene;
import com.example.last_spring.gameprealpha.prologue.PrologueBackpackHunter;
import com.example.last_spring.gameprealpha.prologue.PrologueBadEnding;
import com.example.last_spring.gameprealpha.prologue.PrologueBeforeBreakage;
import com.example.last_spring.gameprealpha.prologue.PrologueBonfire;
import com.example.last_spring.gameprealpha.prologue.PrologueBox;
import com.example.last_spring.gameprealpha.prologue.PrologueBreakage;
import com.example.last_spring.gameprealpha.prologue.PrologueCave;
import com.example.last_spring.gameprealpha.prologue.PrologueCaveAfterLabyrinth;
import com.example.last_spring.gameprealpha.prologue.PrologueDownBackpackCutScene;
import com.example.last_spring.gameprealpha.prologue.PrologueDownFirstScene;
import com.example.last_spring.gameprealpha.prologue.PrologueDownSecondSceneBackPack;
import com.example.last_spring.gameprealpha.prologue.PrologueDownSecondSceneNoBackPack;
import com.example.last_spring.gameprealpha.prologue.PrologueGoodEnding;
import com.example.last_spring.gameprealpha.oldStory.PrologueOldStory;
import com.example.last_spring.gameprealpha.oldStory.PrologueOldStoryAttack;
import com.example.last_spring.gameprealpha.prologue.PrologueRain;
import com.example.last_spring.gameprealpha.prologue.PrologueStart;

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
            return PrologueAbandonedCar.class;
        }
        if (level == 1.11f) {
            return PrologueHuntingLodge.class;
        }
        if (level == 1.12f) {
            return PrologueHuntingLodgeInside.class;
        }
        if (level == 1.121f) {
            return PrologueBox.class;
        }
        if (level == 1.13f) {
            return PrologueHuntingLodgeCutScene.class;
        }
        if (level == 1.14f) {
            return PrologueHuntingLodgeHunter.class;
        }
        if (level == 1.15f) {
            return PrologueHuntingLodgeExit.class;
        }
        if (level == 1.16f) {
            return PrologueHuntingLodgeAfter.class;
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
            return PrologueCaveLabyrinth.class;
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