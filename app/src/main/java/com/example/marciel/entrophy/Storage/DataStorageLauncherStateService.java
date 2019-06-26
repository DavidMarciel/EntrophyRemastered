package com.example.marciel.entrophy.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class DataStorageLauncherStateService {

    private static final String LOG_DEVELOPMENT= "Development";
    private static final String SIGNAL = "signal";
    private static final String SPEED = "speed";
    private static final String ALPHABETS_TYPE = "alphabetsType";
    private static final String DEFAULT_ALPHABETS_TYPE = "Dynamic";


    public static void signal(Context context, boolean signal) {

        SharedPreferences.Editor ed = DataStorageAccess.getSharedPreferencesEditor(context);
        ed.putBoolean(SIGNAL, signal);
        ed.commit();

        Log.v(LOG_DEVELOPMENT, SIGNAL + " set to " + signal);
    }

    public static boolean isSignalizable(Context context){

        SharedPreferences sh = DataStorageAccess.getSharedPreferences(context);
        boolean isSingal = sh.getBoolean(SIGNAL, true);

        Log.v(LOG_DEVELOPMENT, SIGNAL + " read as: " + isSingal);
        return isSingal;
    }

    public static int getSpeed(Context context) {

        SharedPreferences sh = DataStorageAccess.getSharedPreferences(context);
        int speed = sh.getInt(SPEED, 5);

        Log.v(LOG_DEVELOPMENT, SPEED + " read as: " + speed);
        return speed;
    }

    public static void setSpeed(Context context, int speed) {

        SharedPreferences.Editor ed = DataStorageAccess.getSharedPreferencesEditor(context);
        ed.putInt(SPEED, speed);
        ed.commit();

        Log.v(LOG_DEVELOPMENT, SPEED + " set to " + speed);
    }

    public static void setAlphabetsType(Context context, String alphabetsType) {

        SharedPreferences.Editor ed = DataStorageAccess.getSharedPreferencesEditor(context);
        ed.putString(ALPHABETS_TYPE, alphabetsType);
        ed.commit();

        Log.v(LOG_DEVELOPMENT, ALPHABETS_TYPE + " "+ alphabetsType);
    }

    public static String getAlphabetsType(Context context) {

        SharedPreferences sh = DataStorageAccess.getSharedPreferences(context);
        String alphabetsType = sh.getString(ALPHABETS_TYPE, DEFAULT_ALPHABETS_TYPE);

        Log.v(LOG_DEVELOPMENT, ALPHABETS_TYPE + " "+ alphabetsType);
        return alphabetsType;
    }
}
