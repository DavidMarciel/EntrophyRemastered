package com.example.marciel.entrophy.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class DataStorageTimeTaken {

    private static final String LOG_DEVELOPMENT= "Development";
    private static final String TIME_TAKEN = "timetaken";


    public static void storeTime(Context context, float timeTaken) {

        SharedPreferences.Editor ed = DataStorageAccess.getSharedPreferencesEditor(context);
        ed.putFloat(TIME_TAKEN, timeTaken);
        ed.commit();

        Log.v(LOG_DEVELOPMENT, TIME_TAKEN + " set to " + timeTaken);
    }

    public static float getTimeTaken(Context context){

        SharedPreferences sh = DataStorageAccess.getSharedPreferences(context);
        float timeTaken = sh.getFloat(TIME_TAKEN, -1f);

        Log.v(LOG_DEVELOPMENT, TIME_TAKEN + " read as: " + timeTaken);
        return timeTaken;
    }

}
