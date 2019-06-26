package com.example.marciel.entrophy.Movements;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LineMove extends Move {

    private float ySpeed;
    private float xSpeed;

    private final float VELOCIDAD_MAXIMA = 6 /3.5f; //inicialmente 6

    public LineMove(Letter letter) {
        super(letter);

        inicializaVelocidades();
    }

    private void inicializaVelocidades() {
        ySpeed = (float) ((Math.random()* VELOCIDAD_MAXIMA) - VELOCIDAD_MAXIMA/2);
        xSpeed = (float) ((Math.random()* VELOCIDAD_MAXIMA) - VELOCIDAD_MAXIMA/2);
    }

    @Override
    public void move() {
        horizontalMove();
        verticalMove();
    }

    private void verticalMove() {
        if( Y_MIN_SCREEN_SIZE <= y && y <= Y_MAX_SCREEN_SIZE) y += ySpeed;
        else if( y < Y_MIN_SCREEN_SIZE) y = Y_MAX_SCREEN_SIZE;
        else if(Y_MAX_SCREEN_SIZE < y) y = Y_MIN_SCREEN_SIZE;
        letter.setY(y);
    }

    private void horizontalMove() {
        if( X_MIN_SCREEN_SIZE <= x && x <= X_MAX_SCREEN_SIZE) x += xSpeed;
        else if( x < X_MIN_SCREEN_SIZE) x = X_MAX_SCREEN_SIZE;
        else if(X_MAX_SCREEN_SIZE < x) x = X_MIN_SCREEN_SIZE;
        letter.setX(x);
    }


}
