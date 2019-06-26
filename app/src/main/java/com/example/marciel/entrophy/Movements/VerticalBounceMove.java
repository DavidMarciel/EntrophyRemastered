package com.example.marciel.entrophy.Movements;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 20/06/2014.
 */
public class VerticalBounceMove extends Move {

    private boolean goingBottom = false;

    private final float SPEED = 5 /3.5f;

    VerticalBounceMove(Letter letter) {
        super(letter);
    }

    @Override
    public void move() {
        bounceMove();
    }

    private void bounceMove() {

        if(goingBottom){
            y += SPEED;
        }
        else{
            y -= SPEED;
        }
        if( y < Y_MIN_SCREEN_SIZE) goingBottom = true;
        else if(Y_MAX_SCREEN_SIZE < y) goingBottom = false;

        letter.setY(y);
    }
}
