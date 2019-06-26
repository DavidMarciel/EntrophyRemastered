package com.example.marciel.entrophy.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.LettersClasses.Letter;

import java.util.ArrayList;

public class DataStoragePasswordService {

    private static final String PASSWORD_LETTER = "passwordLetter ";
    private static final String ENTROPHY = "EntrophyView";
    private static final String NUMBER_OF_LETTERS = "NumberOfLetters";
    private static final String LOG_DEVELOPMENT= "Development";

    public static void saveKeyWord(Context applicationContext, ArrayList<Letter> choosenCharacters) {

        SharedPreferences.Editor ed = DataStorageAccess.getSharedPreferencesEditor(applicationContext);

        saveNumberOfLetters(ed, choosenCharacters.size());

        for (int i = 0; i < choosenCharacters.size(); i++) {

            Letter aLetter = choosenCharacters.get(i);

            String letter = aLetter.getValue() + " " + aLetter.getColor() + " " + aLetter.getLetterType();
            saveKeywordLetter(ed, letter, i);
        }

        ed.commit();
    }

    private static void saveNumberOfLetters(SharedPreferences.Editor ed, int size) {
        ed.putInt(NUMBER_OF_LETTERS, size);
    }

    private static void saveKeywordLetter(SharedPreferences.Editor ed, String letter, int tapNumber) {
        ed.putString(PASSWORD_LETTER + tapNumber, letter);
    }

    public static Keyword getKeyword(Context context) {

        SharedPreferences sh = DataStorageAccess.getSharedPreferences(context);

        int numberOfLetters = sh.getInt(NUMBER_OF_LETTERS, 0);
        if(numberOfLetters == 0) {
            Log.v(LOG_DEVELOPMENT, "Number of letters == 0, failure en \"Result getKeyword\"");
        }

        Keyword keyword = new Keyword();

        for (int i = 0; i < numberOfLetters; i++) {

            String characterInfo = sh.getString(PASSWORD_LETTER + i , "Z -16777216");
            Letter character = getLetter(context, characterInfo);
            keyword.addKeywordLetter(character);

        }
        return keyword;
    }

    @NonNull
    private static Letter getLetter(Context context, String characterInfo) {

        String[] letterInfoInSharedPrefferences = characterInfo.split(" ");
        char letter = letterInfoInSharedPrefferences[0].charAt(0);
        int color = Integer.parseInt(letterInfoInSharedPrefferences[1]);
        int letterType = getLetterType(letterInfoInSharedPrefferences);

        return new Letter(context, letter, color, letterType);
    }

    private static int getLetterType(String[] s) {

        int letterType;

        try {
            letterType = Integer.parseInt(s[2]);
        }catch (Exception e){
            letterType = 0;
        }

        return letterType;
    }
}
