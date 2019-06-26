package com.example.marciel.entrophy.Movements;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LineBounceMove extends Move {

    private float xSpeed;
    private float ySpeed;

    private final float VELOCIDAD_MAXIMA = 3 /3.5f;

    public LineBounceMove(Letter letter) {
        super(letter);

        initSpeeds();
        putInRange();
    }

    private void putInRange() {
        if(x < X_MIN_SCREEN_SIZE) x = X_MIN_SCREEN_SIZE;
        if(x > X_MAX_SCREEN_SIZE) x = X_MAX_SCREEN_SIZE;
        if(y < Y_MIN_SCREEN_SIZE) y = Y_MIN_SCREEN_SIZE;
        if(y > Y_MAX_SCREEN_SIZE) y = Y_MAX_SCREEN_SIZE;
    }


    private void initSpeeds() {
        xSpeed = (float) ((Math.random()* VELOCIDAD_MAXIMA) - VELOCIDAD_MAXIMA/2);
        ySpeed = (float) ((Math.random()* VELOCIDAD_MAXIMA) - VELOCIDAD_MAXIMA/2);
    }

    @Override
    public void move() {
        horizontalMove();
        verticalMove();
    }

    private void verticalMove() {

        if( y < Y_MIN_SCREEN_SIZE || Y_MAX_SCREEN_SIZE < y   ) {
            ySpeed = -ySpeed;
        }
        letter.setY( y += ySpeed);
    }

    private void horizontalMove() {

        if( x < X_MIN_SCREEN_SIZE || X_MAX_SCREEN_SIZE < x)
            xSpeed = -xSpeed;

        letter.setX( x += xSpeed);
    }


}
