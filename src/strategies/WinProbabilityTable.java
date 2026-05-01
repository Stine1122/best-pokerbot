package com.pokerbot.strategies;

import java.util.HashMap;
import java.util.Map;

//This basically only works preflop; it do not give a flying fuck about the river lol
public class WinProbabilityTable {
    private Map<String, Integer> table = new HashMap<>();

    public WinProbabilityTable() {
        // Pocket Pairs
        table.put("1-1",   85);
        table.put("13-13", 82);
        table.put("12-12", 80);
        table.put("11-11", 77);
        table.put("10-10", 75);
        table.put("9-9",   72);
        table.put("8-8",   69);
        table.put("7-7",   66);
        table.put("6-6",   63);
        table.put("5-5",   60);
        table.put("4-4",   56);
        table.put("3-3",   53);
        table.put("2-2",   49);

        // Ace-High
        table.put("1-13", 65);
        table.put("1-12", 64);
        table.put("1-11", 63);
        table.put("1-10", 62);
        table.put("1-9",  60);
        table.put("1-8",  59);
        table.put("1-7",  58);
        table.put("1-6",  56);
        table.put("1-5",  56);
        table.put("1-4",  55);
        table.put("1-3",  55);
        table.put("1-2",  54);

        // King-High
        table.put("13-12", 61);
        table.put("13-11", 60);
        table.put("13-10", 59);
        table.put("13-9",  57);
        table.put("13-8",  55);
        table.put("13-7",  54);
        table.put("13-6",  53);
        table.put("13-5",  52);
        table.put("13-4",  51);
        table.put("13-3",  50);
        table.put("13-2",  49);

        // Queen-High
        table.put("12-11", 57);
        table.put("12-10", 57);
        table.put("12-9",  55);
        table.put("12-8",  53);
        table.put("12-7",  51);
        table.put("12-6",  50);
        table.put("12-5",  49);
        table.put("12-4",  48);
        table.put("12-3",  47);
        table.put("12-2",  46);

        // Jack-High
        table.put("11-10", 54);
        table.put("11-9",  52);
        table.put("11-8",  50);
        table.put("11-7",  48);
        table.put("11-6",  46);
        table.put("11-5",  46);
        table.put("11-4",  45);
        table.put("11-3",  44);
        table.put("11-2",  43);

        // Ten-High
        table.put("10-9", 51);
        table.put("10-8", 49);
        table.put("10-7", 47);
        table.put("10-6", 45);
        table.put("10-5", 43);
        table.put("10-4", 42);
        table.put("10-3", 41);
        table.put("10-2", 40);

        // Nine-High
        table.put("9-8", 47);
        table.put("9-7", 45);
        table.put("9-6", 43);
        table.put("9-5", 41);
        table.put("9-4", 39);
        table.put("9-3", 38);
        table.put("9-2", 37);

        // Eight-High
        table.put("8-7", 43);
        table.put("8-6", 42);
        table.put("8-5", 40);
        table.put("8-4", 38);
        table.put("8-3", 36);
        table.put("8-2", 35);

        // Seven-High
        table.put("7-6", 40);
        table.put("7-5", 39);
        table.put("7-4", 37);
        table.put("7-3", 35);
        table.put("7-2", 33);

        // Six-High
        table.put("6-5", 38);
        table.put("6-4", 36);
        table.put("6-3", 34);
        table.put("6-2", 32);

        // Five-High
        table.put("5-4", 36);
        table.put("5-3", 34);
        table.put("5-2", 32);

        // Four-High
        table.put("4-3", 33);
        table.put("4-2", 31);

        // Three-High
        table.put("3-2", 30);
    }

    public int getWinPercent(Hand hand) {
        int rank1 = hand.getCard1().getRank();
        int rank2 = hand.getCard2().getRank();
        return table.getOrDefault(buildKey(rank1, rank2), 50);
    }

    private String buildKey(int rank1, int rank2) {
        int pv1 = rank1 == 1 ? 14 : rank1;
        int pv2 = rank2 == 1 ? 14 : rank2;
        if (pv1 >= pv2) return rank1 + "-" + rank2;
        return rank2 + "-" + rank1;
    }
}
