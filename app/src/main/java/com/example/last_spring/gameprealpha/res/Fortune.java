package com.example.last_spring.gameprealpha.res;

import java.util.Random;

public class Fortune {
    public static boolean isLuck(int fortune, int chance) {
        int number = (int) (Math.random() * chance);
        return number <= fortune;
    }

    public static boolean isFiftyFifty() {
        Random random = new Random();
        int number = random.nextInt(100);
        return number <= 50;
    }

    public static int isTripleLuck(int fortune) {
        int chance = fortune*2;
        int fail = chance + (chance/2);
        int number = (int) (Math.random() * fail);
        if (number <= fortune) {
            return 2;
        } else if (number <= chance) {
            return 1;
        }
        return 0;
    }
}
