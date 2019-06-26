package com.example.marciel.entrophy.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marciel.entrophy.LettersClasses.Letter;

import java.util.ArrayList;

public class DataStoragePossibilitiesService {

    private static final String SUB_LETTER = "subLetter ";
    private static final String NUMBER_OF_SUB_LETTERS = "numberOfSubletters ";
    private static final String ENTROPHY = "EntrophyView";
    private static final String NUMBER_OF_LETTERS = "NumberOfLetters";
    private static final String LOG_DEVELOPMENT= "Development";

    public static void savePossibilities(Context applicationContext, ArrayList<ArrayList<Letter>> choosenCharacters) {

        SharedPreferences.Editor editor = DataStorageAccess.getSharedPreferencesEditor(applicationContext);

        for (int i = 0; i < choosenCharacters.size(); i++) {

            for (int j = 0; j < choosenCharacters.get(i).size(); j++) {

                Letter aLetter = choosenCharacters.get(i).get(j);

                String letters = aLetter.getValue() + " " + aLetter.getColor() + " " + aLetter.getLetterType();
                add1Possibility(editor, letters, i, j);
            }
            savePossibilitiesForTap(editor, i, choosenCharacters.get(i).size());
        }
        editor.commit();
    }

    private static void add1Possibility(SharedPreferences.Editor editor, String letter, int tapNumber, int number) {
        editor.putString(SUB_LETTER + tapNumber + " " + number, letter);
    }

    private static void savePossibilitiesForTap(SharedPreferences.Editor editor, int tapNumber, int number) {
        editor.putInt(NUMBER_OF_SUB_LETTERS + tapNumber, number);
    }


    public static Letter[][] getPossibilities(Context context) {

        SharedPreferences sh = DataStorageAccess.getSharedPreferences(context);

        int numberOfLetters = sh.getInt(NUMBER_OF_LETTERS, 0);
        if(numberOfLetters == 0) {
            Log.v(LOG_DEVELOPMENT, "Number of letters == 0, failure en \"Result getKeyword\"");
        }

        Letter[][] possibilities = new Letter[numberOfLetters][];

        for (int i = 0; i < numberOfLetters; i++) {

            int numberOfSubletters = sh.getInt(NUMBER_OF_SUB_LETTERS + i, 0);
            possibilities[i] = new Letter[numberOfSubletters];

            for (int j = 0; j < numberOfSubletters; j++) {

                String characterInfo = sh.getString(SUB_LETTER + i + " " + j, "Z -16777216");
                Letter character = getLetter(context, characterInfo);
                possibilities[i][j] = character;
            }
        }
        return possibilities;
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
