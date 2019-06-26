package com.example.marciel.entrophy.LettersClasses;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.Movements.Move;

import org.w3c.dom.Text;


/**A Letter represents an item on the screen,
 * it has it's own moveLetters, whose define the way it's moveLetters
 *
 * The name is Letter to avoid collisions with Character primitive type
 * Created by david on 11/06/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
//It was this way in the past but it changed because a textview needs a context to be created
//there should be a DummyLetter for the places where you can not get the context to generate the Letter
public class Letter extends android.support.v7.widget.AppCompatTextView {

    private static final boolean ORIENTATION_HORIZONTAL = false;   //landscape --      dimension X
    private static final boolean ORIENTATION_VERTICAL = true;      //portrait |        dimension Y
    private static boolean isOrientationVertical = ORIENTATION_VERTICAL;

    //deviation
    private static float proportion = 1;

    public static void initializeLettersOrientationAndProportion(Context context, boolean isOrientationVertical) {
        Letter.isOrientationVertical = isOrientationVertical;
        proportion = Dimens.getDimens(context).getProportion();

        Log.v("Deviation", "Letter initializeLettersOrientationAndProportion " + isOrientationVertical);
        Log.v("Proportion", "proportioon " + proportion);
    }

    public static boolean isIsOrientationVertical() {
        return isOrientationVertical;
    }

    public static float getProportion() {
        return proportion;
    }


    private int color;
    private int letterType;
    private Move movement;

    public Letter(char value, final Context context, int color, float porcentualIncrease,
                  float x, int y, int movementType, int letterType) {

        super(context);

        this.color = color;
        setText( String.valueOf( value));
        setTextColor(color);

        setTextSize(18 * (1f + porcentualIncrease));

        setX(x);
        setY(y);

        movement = Move.movementStaticFactory(this, movementType);

        this.letterType = letterType;
        setLetterType(context, letterType);

//        Log.v("EntrophyView", "Caracter created " + value + " color " + color
//                + " x " + getX() + " y " + getY());
    }


    public Letter(final Context context, char value, int color, int letterType) {

        super(context);

        this.color = color;
        setText( String.valueOf( value));
        setTextColor(color);

        setLetterType(context, letterType);
    }


    public float getX() {
        if (isOrientationVertical)
            return super.getX()/ proportion;
        else
            return super.getY()/ proportion;
    }

    public float getY() {
        if (isOrientationVertical)
            return super.getY()/ proportion;
        else
            return super.getX()/ proportion;
    }

    public void setX(float x) {
        if (isOrientationVertical)
            super.setX(x* proportion);
        else
            super.setY(x* proportion);
    }

    public void setY(float y) {
        if (isOrientationVertical)
            super.setY(y * proportion);
        else
            super.setX(y * proportion);
    }

    public void changeAxis() {
        movement.update();
    }

    public void move() {
        movement.move();
    }

    public String getInfo() {

        String s = "Valor: " + getValue();
        s += "\n color: " + color;
        s += "\n poisition x,y : " + getX() + "," + getY();

        return s;
    }

    public char getValue() {

        return getText().charAt(0);
    }

    public int getColor() {
        return color;
    }

    public int getLetterType() {
        return letterType;
    }

    public void setSelectedColor() {
        setTextColor(Color.RED);
    }

    public void setOriginalColor() {
        setTextColor(color);
    }

    private void setLetterType(Context context, int letterTypeAsInt) {

        Typeface letterType = TypeFaces.tipeFaceStaticFactory(context, letterTypeAsInt);

//        if(movement != null && movement.getMovementType() == Move.LINE_BOUNCE_MOVE) {     //if the movement is difficult to find you make it
//            setTypeface(letterType, Typeface.BOLD);                    //easier to see
//        }
//        else{
//            setTypeface(letterType);
//        }

        setTypeface(letterType);
    }

    public void setMove(int movementType) {

        movement = Move.movementStaticFactory(this, movementType);
    }

    public boolean equals(Letter other){

        return this.getValue() == other.getValue()
                && this.getColor() == other.getColor();
        //      &&this.getLetterType() == other.getLetterType();
    }


}