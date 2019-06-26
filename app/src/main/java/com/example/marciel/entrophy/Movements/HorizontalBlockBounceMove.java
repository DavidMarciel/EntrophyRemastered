package com.example.marciel.entrophy.Movements;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 20/06/2014.
 */
public class HorizontalBlockBounceMove extends Move {

    private static boolean startToTheRight = true;

    private static final float SPEED = 5 /3.5f;

    HorizontalBlockBounceMove(Letter letter) {
        super(letter);
    }

    @Override
    public void move() {

        if( x < X_MIN_SCREEN_SIZE ) startToTheRight = true;
        else if(X_MAX_SCREEN_SIZE < x) startToTheRight = false;

        if(startToTheRight){
            x += SPEED;
        }
        else{
            x -= SPEED;
        }

        letter.setX(x);
    }

}
