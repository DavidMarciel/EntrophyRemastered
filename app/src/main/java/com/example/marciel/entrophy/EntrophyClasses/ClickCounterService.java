package com.example.marciel.entrophy.EntrophyClasses;

import android.util.Log;

public class ClickCounterService {

    //Counters
    private int sizeOfKeyword;
    private int clickCounter;

    public ClickCounterService(int SIZE_OF_KEYWORD) {
        this.sizeOfKeyword = SIZE_OF_KEYWORD;
        this.clickCounter = 0;
    }

    public boolean thereAreMoreclicks() {

        clickCounter++;
        Log.v("EntrophyView", "NUMBER OF CLICKS " + clickCounter + " of " + sizeOfKeyword);
        return clickCounter < sizeOfKeyword;
    }

    public int getClickCounter() {
        return clickCounter;
    }

}
