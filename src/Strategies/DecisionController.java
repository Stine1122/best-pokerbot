package com.pokerbot.strategies;

public class DecisionController {

    private  ArrayList<String> decisions = new ArrayList<>(Arrays.asList("FOLD", "CALL", "RAISE"));
    private StrategiController strategiController = new StrategiController();

    public void fold() {
        //TODO: add logic for folding through API
        System.out.println("FOLD");
    }
    public void call() {
        //TODO: add logic for calling through API + handling of not enough chips to call
        System.out.println("CALL");
    }
    public void raise() {
        //TODO: add logic for raising through API + handling of not enough chips to raise

        // Maybe use WinProbabilityTable to decide how much to raise? Like if we have 80% win chance, we random decide again: 
        // if 80>=prob raise between 50-100% of current bet, if 50>=prob raise between 25-50% of current bet, if 25>=prob raise between 10-25% of current bet, else raise minimum :D 
        // Also if no money to raise, just call instead of folding
        System.out.println("RAISE");
    }

    public DecisionController() {
        string WhatToDo = strategiController.decide(hand);

        case WhatToDo:
            "FOLD" -> fold();
            "CALL" -> call();
            "RAISE" -> raise();
    }

}

