package com.example.marciel.entrophy.EntrophyClasses;

import android.view.MotionEvent;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.Storage.DataStorageLauncherStateService;

import java.util.ArrayList;
import java.util.List;

public class DistanceBetweenLettersAndEvent {

    static private double MAXIMUM_RANGE_DISTANCE = Dimens.MAXIMUM_RANGE_DISTANCE;

    static private int VERTICAL_Y_DEVIATION = Dimens.VERTICAL_Y_DEVIATION;
    static private int VERTICAL_X_DEVIATION = Dimens.VERTICAL_X_DEVIATION;
    static private int HORIZONTAL_Y_DEVIATION = Dimens.HORIZONTAL_Y_DEVIATION;
    static private int HORIZONTAL_X_DEVIATION = Dimens.HORIZONTAL_X_DEVIATION;

    public ArrayList<Letter> getLettersCloseToEvent(List<Letter> letters, MotionEvent event, boolean signalLetter) {

        ArrayList<Letter> selectedLetters = new ArrayList<>();

        for (Letter aLetter: letters) {

            if(isLetterNearToEvent(aLetter, event, signalLetter)){
                selectedLetters.add(aLetter);
            }
        }

        return selectedLetters;
    }


    /**Returns true if the character is close to the tap position
     * the distance is MAXIMUM_RANGE_DISTANCE
     *
     * @return true if the Character is close to the tap position
     */
    private boolean isLetterNearToEvent(Letter aLetter, MotionEvent event, boolean signalLetter) {

        float xDifference;
        float yDifference;

        if(Letter.isIsOrientationVertical()) {
            xDifference = event.getX() / Letter.getProportion() - aLetter.getX() - VERTICAL_X_DEVIATION;
            yDifference = event.getY() / Letter.getProportion() - aLetter.getY() - VERTICAL_Y_DEVIATION;
        }
        else{
            xDifference = event.getX() / Letter.getProportion() - aLetter.getY() - HORIZONTAL_X_DEVIATION;
            yDifference = event.getY() / Letter.getProportion() - aLetter.getX() - HORIZONTAL_Y_DEVIATION;
        }

        double distance = xDifference * xDifference + yDifference * yDifference;
        distance = Math.sqrt(distance);

        boolean isNear = distance < MAXIMUM_RANGE_DISTANCE;

        signalIfRequired(aLetter, signalLetter, isNear);

        return isNear;
    }

    private void signalIfRequired(Letter aLetter, boolean signalLetter, boolean isNear) {
        if(signalLetter && isNear){
            aLetter.setSelectedColor();
        } else {
            aLetter.setOriginalColor();
        }
    }


}
