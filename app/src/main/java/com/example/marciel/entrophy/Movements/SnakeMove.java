package com.example.marciel.entrophy.Movements;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.example.marciel.entrophy.LettersClasses.Letter;

import static java.lang.Math.PI;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.random;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SnakeMove extends Move {

    private int time = 0;
    private float xSpeed;
    private float ySpeed;

    private static final int STEPS = 6;
    private static final int MAXIMUM_SPEED = STEPS /7+1;

    private static final float ANGULO_MAX_GIRO = 30;

    public SnakeMove(Letter letter) {
        super(letter);

        initSpeeds(MAXIMUM_SPEED);
    }

    @Override
    public void move() {

        if (time % (57 * STEPS / 7) == 0) {
            changeSpeeds();
        }

        verticalMove();
        horizontalMove();
        time++;
    }


    private void changeSpeeds() {

        double extraAngle = (random() * ANGULO_MAX_GIRO);    // (-30,+30)
        if (random() < 0.5d) extraAngle = -extraAngle;

        double currentAngleInDegrees = atan2(ySpeed, xSpeed) * 180 / PI;
        double currentModule = sqrt(xSpeed * xSpeed + ySpeed * ySpeed);

        //next angle
        double angle = currentAngleInDegrees + extraAngle;
        double angleInRad = angle * PI / 180;

        xSpeed = getAngleX_Component(currentModule, angleInRad);
        ySpeed = getAngleY_Component(currentModule, angleInRad);

        Log.v("Angulo", "Angulo actual: " + currentAngleInDegrees +
                " angulo extra: " + extraAngle + " angulo final: " + angleInRad * 180 / PI);
        Log.v("Angulo", "Valor xSpeed: "+ xSpeed+" valor ySpeed: "+ ySpeed);
        Log.v("Angulo", "inicial cos: "+ cos(currentAngleInDegrees)+ "sen: "+sin(angleInRad));
        Log.v("Angulo", "final cos: "+ cos(currentAngleInDegrees)+ "sen: "+sin(angleInRad));

    }

    private float getAngleY_Component(double currentModule, double angleInRad) {
        return (float) (sin(angleInRad) * currentModule);
    }

    private float getAngleX_Component(double currentModule, double angleInRad) {
        return (float) (cos(angleInRad) * currentModule);
    }

    private void initSpeeds(double VELOCIDAD_MAXIMA) {

        double xExtraSpeed = (Math.random()* VELOCIDAD_MAXIMA);
        double yExtraSpeed = Math.sqrt( VELOCIDAD_MAXIMA*VELOCIDAD_MAXIMA - xExtraSpeed*xExtraSpeed);


        if(Math.random()>0.5d)
            xSpeed = (float) xExtraSpeed;
        else xSpeed = (float) -xExtraSpeed;

        if(Math.random()>0.5d)
            ySpeed = (float) yExtraSpeed;
        else ySpeed = (float) -yExtraSpeed;
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
