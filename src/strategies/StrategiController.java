package com.pokerbot.strategies;

import java.util.Random;

public class StrategiController {
    private WinProbabilityTable table = new WinProbabilityTable();
    private Random random = new Random();

    public String decide(Hand hand) {
        int winPercent = table.getWinPercent(hand);
        int remaining = 100 - winPercent;
        int foldPercent = (remaining * remaining) / 100;
        int callPercent = remaining - foldPercent;

        int roll = random.nextInt(101);

        if (roll < winPercent) return "RAISE";
        if (roll < winPercent + callPercent) return "CALL";
        return "FOLD";
    }
}
