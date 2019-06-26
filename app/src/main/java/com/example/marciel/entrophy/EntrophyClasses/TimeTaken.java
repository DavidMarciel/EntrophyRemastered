package com.example.marciel.entrophy.EntrophyClasses;

import android.content.Context;

import com.example.marciel.entrophy.Storage.DataStorageTimeTaken;

import java.util.Calendar;
import java.util.Date;

/**This class gets the start and end time and stores the time taken by the user in disc
 *
 */
class TimeTaken {

    private final Context context;
    private Date startTime;
    private Date endTime;

    public TimeTaken(Context context) {
        this.context = context;
        startTime = getCurrentTime();
    }

    public void end() {
        endTime = getCurrentTime();
        storeTimeTaken();
    }

    private Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    private void storeTimeTaken(){

        double timeDifference = endTime.getTime() - startTime.getTime();

        float elapsedSeconds = (float) (timeDifference / 1000);

        DataStorageTimeTaken.storeTime(context, elapsedSeconds);
    }
}
