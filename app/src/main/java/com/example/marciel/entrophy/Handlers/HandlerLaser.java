package com.example.marciel.entrophy.Handlers;

import android.annotation.TargetApi;
import android.os.Build;

import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.Movements.Move;

import java.util.ArrayList;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HandlerLaser extends Handler {

//    final float MAXIMUM_SPEED = 7; //anteriormente 6 //comodo en 3

    HandlerLaser(ArrayList<Letter> letras) {
        super(letras);
        concreteInitialization();
    }

    @Override
    protected void concreteInitialization() {
        initSpeeds(MAXIMUM_SPEED);
        initPoints();

        //añades el movimiento unicamente en la ultima letra, el resto la seguiran
        letters.get(letters.size() - 1).setMove(Move.LASER_MOVE);
    }

    /**Mueve todas las letters, se mueven de forma que unas siguen xSpeed otras,
     * excepto la primera, que utiliza un movimiento
     *
     */
    @Override
    public void move() {
        for (int i = 0; i < letters.size()-1 ; i++) {

            int nextPointToMove = (i*(STEPS +1)+1);
            float nextPointX = points.get( nextPointToMove).getX();
            float nextPointY = points.get( nextPointToMove).getY();

            letters.get(i).setX( nextPointX );
            letters.get(i).setY( nextPointY );

        }
        lastLetterMove(letters.get(letters.size() - 1));
    }

    /**Mueve unicamente la primera letra, el resto la seguirán
     * aunque sea la primera letra de la fila (la guia) es la ultima en la lista
     *
     * @param letra letra xSpeed la que seguirán el resto (última en la lista)
     */
    private void lastLetterMove(Letter letra) {

        letra.move();

        //create a new point to move there letters in next steps
        points.add(new Point(letra.getX(), letra.getY()));
        points.remove(0);


    }

}