package com.example.marciel.entrophy.EntrophyClasses;

import android.content.Context;
import android.widget.Toast;

import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.Storage.DataStoragePasswordService;

public class EnsurePasswordIsSet {

    public static void ensureThereIsPassword(Context context, EntrophyView entrophyView) {

        //if there is no password it asks for one
        if (isPasswordEmpty(context)) {
            askToSetPassword(context, entrophyView);
        }
    }

    private static void askToSetPassword(Context context, EntrophyView entrophyView) {
        Toast.makeText(context, "Please, set a password.", Toast.LENGTH_LONG).show();

        entrophyView.finish();
    }

    private static boolean isPasswordEmpty(Context context) {
        Keyword keyword = DataStoragePasswordService.getKeyword(context);
        return keyword.size() == 0;
    }

}
