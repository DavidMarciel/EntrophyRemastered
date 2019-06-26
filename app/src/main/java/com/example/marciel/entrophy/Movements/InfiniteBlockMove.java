package com.example.marciel.entrophy.Movements;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 17/03/2015.
 */
public class InfiniteBlockMove extends Move {

    static private float ySpeed;
    static private float xSpeed;

    private final float MAXIMUM_SPEED = 6 /3.5f; //inicialmente 6

    public InfiniteBlockMove(Letter letter) {
        super(letter);

        initSpeeds();
    }

    private void initSpeeds() {

        ySpeed = (float) ((Math.random()* MAXIMUM_SPEED) - MAXIMUM_SPEED /2);
        xSpeed = (float) ((Math.random()* MAXIMUM_SPEED) - MAXIMUM_SPEED /2);

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
