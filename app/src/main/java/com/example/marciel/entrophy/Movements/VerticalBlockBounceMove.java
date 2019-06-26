package com.example.marciel.entrophy.Movements;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 20/06/2014.
 */
public class VerticalBlockBounceMove extends Move {

    private static boolean goToBottom = true;

    private static final float SPEED = 6 /3.5f;

    public VerticalBlockBounceMove(Letter letter) {
        super(letter);
    }

    @Override
    public void move() {
            bounceMove();
    }

    private void bounceMove() {

        if( y < Y_MIN_SCREEN_SIZE ) goToBottom = true;
        else if(Y_MAX_SCREEN_SIZE < y) goToBottom = false;

        if(goToBottom){
            y += SPEED;
        }
        else{
            y -= SPEED;
        }

        letter.setY(y);
    }

}
