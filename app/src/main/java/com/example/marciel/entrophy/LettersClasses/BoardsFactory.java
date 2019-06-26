package com.example.marciel.entrophy.LettersClasses;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by david on 22/07/2014.
 */
public class BoardsFactory {

    public static final int LATIN_ALPHABET = 0;
    public static final int RUSSIAN_ALPHABET = 1;
    public static final int CHINEESE_ALPHABET = 2;
    public static final int ARABIAN_ALPHABET = 3;
    public static final int DEBANAGARI_ALPHABET = 4;
    public static final int HEBREO_ALPHABET = 5;
    public static final int LATIN_LASER_ALPHABET = 6;
    public static final int LATIN_GUSANO_ALPHABET = 7;
    public static final int NUMBERS = 8;
    public static final int LATIN_LATERAL_WIND_ALPHABET = 9;
    public static final int LATIN_INFINITE_BLOCK_ALPHABET = 10;

    private final Context context;


    public BoardsFactory(Context context) {
        this.context = context;
    }

    public ArrayList<Letter> getLatinLetters() {
        Log.v("BoardsFactory", "call to getLatinLetters");
        return BoardGenerator.instantiateLatinLetters( context);
    }

    public ArrayList<Letter>  getLetters() {
        return BoardGenerator.instantiateLetters( context);
    }

    public ArrayList<Letter>  getStaticLetters() {

        Log.v("BoardsFactory", "call to getStaticLetters");
        return BoardGenerator.instantiateLatinLetters( context);
    }


    public ArrayList<Letter>  getWorldLetters() {
        return BoardGenerator.instantiateWorldLetters(context);
    }


    public ArrayList<Letter>  getMixedLetters() {
        return BoardGenerator.instantiateMixedLetters(context);
    }


    public ArrayList<Letter> getLetters(int type) {

        ArrayList<Letter> lettersList;

        switch (type){
            case LATIN_ALPHABET:                lettersList = BoardGenerator.instantiateLatinLetters(context);                                          break;
            case RUSSIAN_ALPHABET:              lettersList = AlphabetsInstanciator.createCirilicalLetters(context, Color.rgb(77,178,250));    break;
            case CHINEESE_ALPHABET:             lettersList = AlphabetsInstanciator.createChineeseLetters(context, Color.LTGRAY);                               break;
            case ARABIAN_ALPHABET:              lettersList = AlphabetsInstanciator.createArabianLetters(context, Color.rgb(219,219,4));       break;
            case DEBANAGARI_ALPHABET:           lettersList = AlphabetsInstanciator.createDevanagariLetters(context, Color.rgb(250,181,62));   break;
            case HEBREO_ALPHABET:               lettersList = AlphabetsInstanciator.createHebreanLetters(context, Color.RED);                                    break;
            case NUMBERS:                       return BoardGenerator.instantiateNumbers(context, Color.rgb(43, 173, 69));
            case LATIN_LASER_ALPHABET:          return BoardGenerator.instantiateLaserLetters(context);
            case LATIN_GUSANO_ALPHABET:         return BoardGenerator.instantiateSnakeLetters(context);
            case LATIN_INFINITE_BLOCK_ALPHABET: lettersList = AlphabetsInstanciator.createInfinityBlockLatinLetters(context, Color.rgb(255,159,54)); break;
            case LATIN_LATERAL_WIND_ALPHABET:   return BoardGenerator.instantiateLateralWindLetters(context, Color.BLUE);

            default:                            lettersList = null;                break;
        }
        return lettersList;
    }
}

