package com.example.marciel.entrophy.Handlers;


import android.view.MotionEvent;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.LettersClasses.Letter;

import java.util.ArrayList;


/**A Handler represents an item whose work is to move some letters with relationship between them.
 * Created by david on 11/06/2014.
 *
 */
public abstract class Handler {

    protected static final int STEPS = 20; //anteriormente 6 //comodo en 3
    protected static final int MAXIMUM_SPEED = STEPS /7+1; //anteriormente 6 //comodo en 3

    //propiedades de pantalla
    static final float Y_MAX_SCREEN_SIZE = Dimens.Y_MAX_SCREEN_SIZE;//1400;
    static final float X_MAX_SCREEN_SIZE = Dimens.X_MAX_SCREEN_SIZE;//1050; //900;
    static final float Y_MIN_SCREEN_SIZE = Dimens.Y_MIN_SCREEN_SIZE;// 100;
    static final float X_MIN_SCREEN_SIZE = Dimens.X_MIN_SCREEN_SIZE;//50;

    //orientacion
    static final boolean ORIENTATION_HORIZONTAL = false;   //landscape --      dimension X
    static final boolean ORIENTATION_VERTICAL = true;      //portrait |        dimension Y

    //propiedades de movimiento
    public final static int STATIC_HANDLER = 0;
    public final static int LASER_HANDLER = 1;
    public final static int SNAKE_HANDLER = 2;
    public final static int INFINITE_BLOCK_HANDLER = 3;
    public static final double VELOCITY = 0.2d;

    //atributos
    protected ArrayList<Letter> letters;

    protected float xSpeed;
    protected float ySpeed;
    protected ArrayList<Point> points;

    protected abstract void concreteInitialization();

    public abstract void move();

    public Handler(ArrayList<Letter> letters){
        this.letters = letters;
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    protected void initSpeeds(double maximumSpeed) {

        double xExtraSpeed = (Math.random()* maximumSpeed);
        double yExtraSpeed = Math.sqrt( maximumSpeed*maximumSpeed - xExtraSpeed*xExtraSpeed);


        if(Math.random()> VELOCITY)
            xSpeed = (float) xExtraSpeed;
        else xSpeed = (float) -xExtraSpeed;

        if(Math.random()>VELOCITY)
            ySpeed = (float) yExtraSpeed;
        else ySpeed = (float) -yExtraSpeed;
    }

    protected void initPoints() {

        points = new ArrayList<>();

        for (int i = 0; i < letters.size()-1 ; i++) {

            points.add(new Point(letters.get(i).getX(), letters.get(i).getY()));

            float x1 = letters.get(i).getX();
            float y1 = letters.get(i).getY();

            float x2 = letters.get(i + 1).getX();
            float y2 = letters.get(i + 1).getY();

            float xDistance = x2-x1;
            float yDistance = y2-y1;

            //crea tantos points entre letters (incluye los de las propias letters) como se pida
            for (int j = 0; j < STEPS; j++) {

                points.add(new Point(x1+ xDistance *j/ STEPS, y1+ yDistance *j/ STEPS));

            }

        }
    }
    /*
    public void tap(MotionEvent event, int tabNumber, ArrayList<Letter>[] hittedCharacteres){

        for (Letter letter : letters) {

            if (letter.inRange(event)) {

                hittedCharacteres[tabNumber].add(letter);

            }
        }
    }

    public ArrayList<Letter> tap(MotionEvent event){

        ArrayList<Letter> selected = new ArrayList<>();

        for (Letter letter : letters) {

            if (letter.inRange(event)) {

                selected.add(letter);

            }
        }
        return selected;
    }

    public ArrayList<Letter> tapAndSignal(MotionEvent event){

        ArrayList<Letter> selectedsInHandler = new ArrayList<>();

        for (Letter letter : letters) {

            if (letter.inRange(event)) {
                letter.selected();

                selectedsInHandler.add(letter);

            } else letter.notSelected();
        }
        return selectedsInHandler;
    }

    protected void verticalMove(Letter c) {

        if( c.getY() < Y_MIN_SCREEN_SIZE || Y_MAX_SCREEN_SIZE < c.getY()   ) {
            ySpeed = -ySpeed;
        }

        c.setY(c.getY() + ySpeed);
    }

    protected void horizontalMove(Letter c) {

        if( c.getX() < X_MIN_SCREEN_SIZE || X_MAX_SCREEN_SIZE < c.getX())
            xSpeed = -xSpeed;

        c.setX(c.getX() + xSpeed);
    }


    private void putInRange(Letter c) {
        if(c.getX() < X_MIN_SCREEN_SIZE) c.setX(X_MIN_SCREEN_SIZE);
        if(c.getX() > X_MAX_SCREEN_SIZE) c.setX(X_MAX_SCREEN_SIZE);
        if(c.getY() < Y_MIN_SCREEN_SIZE) c.setY(Y_MIN_SCREEN_SIZE);
        if(c.getY() > Y_MAX_SCREEN_SIZE) c.setY(Y_MAX_SCREEN_SIZE);
    }

    public void update() {
        for (Letter letter : letters) {
            letter.update();
        }
    }*/

}
