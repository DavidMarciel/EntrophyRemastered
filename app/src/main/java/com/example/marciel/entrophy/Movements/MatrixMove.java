package com.example.marciel.entrophy.Movements;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MatrixMove extends Move {

    private float ySpeed;

    private final float MAXIMUM_SPEED = 8 /3.5f;    //17
    private final float MINIMUM_SPEED = 3 /3.5f;     //5

    MatrixMove(Letter letter) {
        super(letter);

        inicializaVelocidades();
    }

    private void inicializaVelocidades() {

        ySpeed = (float) ((Math.random()* MAXIMUM_SPEED) )+ MINIMUM_SPEED;

    }

    @Override
    public void move() {
        matrixMove();
    }

    private void matrixMove() {
        //ySpeed debe ser un random con valor max 70
        //es muy chulo

        if( y < Y_MAX_SCREEN_SIZE) y += ySpeed;
        else y %= MAXIMUM_SPEED;

        letter.setY(y);
    }

}
