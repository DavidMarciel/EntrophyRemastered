package com.example.marciel.entrophy.Movements;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LaserMove extends Move {

    public static final double VELOCITY = 0.5d;
    private float xSpeed;
    private float ySpeed;

    private static final int STEPS = 6;
    private final float MAXIMUM_SPEED = STEPS /7+1;

    public LaserMove(Letter letter) {
        super(letter);

        initSpeeds(MAXIMUM_SPEED);
        startInRange();
    }

    private void initSpeeds(double maximumSpeed) {

        double xExtraSpeed = (Math.random()* maximumSpeed);
        double yExtraSpeed = Math.sqrt( maximumSpeed*maximumSpeed - xExtraSpeed*xExtraSpeed);


        if(Math.random()> VELOCITY)
            xSpeed = (float) xExtraSpeed;
        else xSpeed = (float) -xExtraSpeed;

        if(Math.random()>VELOCITY)
            ySpeed = (float) yExtraSpeed;
        else ySpeed = (float) -yExtraSpeed;
    }

    private void startInRange() {
        if(x < X_MIN_SCREEN_SIZE) x = X_MIN_SCREEN_SIZE;
        if(x > X_MAX_SCREEN_SIZE) x = X_MAX_SCREEN_SIZE;
        if(y < Y_MIN_SCREEN_SIZE) y = Y_MIN_SCREEN_SIZE;
        if(y > Y_MAX_SCREEN_SIZE) y = Y_MAX_SCREEN_SIZE;
    }

    @Override
    public void move() {

        verticalMove();
        horizontalMove();
    }

    private void verticalMove() {

        if( letter.getY() < Y_MIN_SCREEN_SIZE || Y_MAX_SCREEN_SIZE < letter.getY()   ) {
            ySpeed = -ySpeed;
        }
        letter.setY(y+= ySpeed);
    }

    private void horizontalMove() {

        if( letter.getX() < X_MIN_SCREEN_SIZE || X_MAX_SCREEN_SIZE < letter.getX()) {
            xSpeed = -xSpeed;
        }
        letter.setX(x+= xSpeed);
    }

}
