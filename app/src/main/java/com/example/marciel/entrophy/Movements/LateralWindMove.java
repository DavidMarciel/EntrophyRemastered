package com.example.marciel.entrophy.Movements;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LateralWindMove extends Move {

    private float speed;

    private final float MAXIMUM_SPEED = 8 /3.5f;    //17
    private final float MINIMUM_SPEED = 3 /3.5f;     //5

    public LateralWindMove(Letter letter) {
        super(letter);

        initSpeeds();
    }

    private void initSpeeds() {

        speed = (float) ((Math.random()* MAXIMUM_SPEED) )+ MINIMUM_SPEED;

    }

    @Override
    public void move() {
        if( x < X_MAX_SCREEN_SIZE) x += speed;
        else x %= MAXIMUM_SPEED;

        letter.setX(x);
    }

}
