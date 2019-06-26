package com.example.marciel.entrophy.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marciel.entrophy.LettersClasses.Letter;

/**It is responsable to store/retrieve data from Shared Preferences
 * Created by david on 15/03/2015.
 */
public class DataStorageAccess {

    private static final String SHAREDPREFERENCES_NAME = "EntrophyView";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor(Context context) {
        SharedPreferences sh = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        return sh.edit();
    }

}
