package com.example.marciel.entrophy.EntrophyClasses;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;

/**This class support with multiclick problems
 * it ensures the clicks are not the same
 */
public class ValidTimeService {

    private static final long TIME_DISTANCE_IN_MILISECONDS = 200;

    private Date lastClickTime;
    private Date currentTime;

    public ValidTimeService(){
        lastClickTime = Calendar.getInstance().getTime();
    }

    public boolean isADifferentClick() {

        currentTime = Calendar.getInstance().getTime();

        if (isValidTime()) {

            Log.v("Development", "ticTime" + lastClickTime + " " + currentTime + " "
                    + (lastClickTime.getTime() - currentTime.getTime()) + "\n" );

            lastClickTime = currentTime;
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isValidTime() {
        //we consider as a different click if it is older than 0.2 seconds
        return (currentTime.getTime() - lastClickTime.getTime()) > TIME_DISTANCE_IN_MILISECONDS;
    }
}
