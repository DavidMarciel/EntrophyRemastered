package com.example.marciel.entrophy.Handlers;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class InfiniteBlockHandler extends Handler {

    public InfiniteBlockHandler(ArrayList<Letter> letras) {
        super(letras);
        concreteInitialization();
    }

    @Override
    protected void concreteInitialization() {
        initSpeeds(MAXIMUM_SPEED);
        initPoints();
    }

    @Override
    public void move() {
        for (Letter letter : letters) {
            letter.move();
        }
    }

}