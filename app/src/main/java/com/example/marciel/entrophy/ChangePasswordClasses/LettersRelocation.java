package com.example.marciel.entrophy.ChangePasswordClasses;

import android.util.Log;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.LettersClasses.Letter;

import java.util.ArrayList;

public class LettersRelocation {

    //Legacy code
    public static ArrayList<Letter> recolocateLetters(ArrayList<Letter> selected) {

        Log.d("number of letters", selected.size() + "");

        //double distance = Dimens.MAXIMUM_RANGE_DISTANCE /2-1;
        double xMax = Dimens.X_MAX_SCREEN_SIZE;
        double xMin = Dimens.X_MIN_SCREEN_SIZE + 150f;
        //double yMax = Dimens.Y_MAX_SCREEN_SIZE;
        double yMin = Dimens.Y_MIN_SCREEN_SIZE + 150f;
        double margen = 100;

        float usefulLength = (float) (xMax - xMin);
        int lettersPerRow = (int) (usefulLength/ (margen+6d));
        int x = -1;
        int y = -1;

        for (Letter aSelected : selected) {

            if (x < lettersPerRow) x++;
            else x = 0;
            if (x == 0) y++;

            aSelected.setX((float) ((x * margen) % usefulLength) + (float) xMin);
            aSelected.setY((float) (y * margen + yMin));

            Log.d("Development", "Letter in the position: " + aSelected.getValue() + " " + aSelected.getX() + " " + aSelected.getY());
        }

        return selected;
    }
}
