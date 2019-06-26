package com.example.marciel.entrophy.LettersClasses;

import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.Movements.Move;

import java.util.ArrayList;

/**Delegate to create the Alphabets
 * Created by david on 04/01/2018.
 */

 class AlphabetsInstanciator {

    static ArrayList<Letter> createLatinLetters(Context context, int firstLetter,
                                                int rgb, int movementType, int xPosition, boolean moveRigth, int letterType) {

        ArrayList<Letter> letters = new ArrayList<>();

        final int numLetters = 26;
        int yDistance;
        int yPosition;

        if (moveRigth) {
            yPosition = Dimens.LATIN_LETTERS_POSITION_Y;
            yDistance = Dimens.LATIN_LETTERS_ADDITION_Y;
        } else {
            //el tamaño es 1050 por eso uso 1025
            // solo se puede ustilizar 950 para que sea compatible con el modo apaisado uso 925
            yPosition = Dimens.LATIN_LETTERS_END_POSITION_Y;
            yDistance = -Dimens.LATIN_LETTERS_ADDITION_Y;
        }

        Letter cr;

        for (int i = 0; i < numLetters; i++) {

            char valor = (char) (firstLetter + i);
            cr = new Letter(valor, context, rgb, 0.0f, yPosition + yDistance * i,
                    xPosition, movementType, letterType);

            letters.add(cr);
        }
        return letters;
    }

    static ArrayList<Letter> createLetters(Context context,
                                              int firstLetter, int rgb, int movementType,
                                              int positionX, int positionY, int xDistance,
                                              int yDistance, int letterType) {

        ArrayList<Letter> letters = new ArrayList<>();
        Letter cr;

        for (int i = 0; i < 26; i++) {

            char value = (char) (firstLetter + i);
            cr = new Letter(value, context, rgb, 0f, positionX + xDistance * i,
                    positionY + yDistance * i, movementType, letterType);

            letters.add(cr);
        }
        return letters;
    }

    static ArrayList<Letter> createCirilicalLetters(Context context, int rgb) {

        ArrayList<Letter> letters = new ArrayList<>();

        Letter cr;

        final int FIRST_LETTER = 1040;
        final int NUMBER_OF_LETTERS = 64;// 0xFF;
        final int LETTERS_PER_ROW = 10;// 11; //en realidad son 12
        int x = -1;
        int y = -1;

        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {

            char value = (char) (FIRST_LETTER + i);
            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if (x == 0) y++;

            cr = new Letter(value, context, rgb, 0f,
                    Dimens.CIRILICAl_POSITION_X + Dimens.CIRILICAL_POSITION_ADDITION_X * x,
                    Dimens.CIRILICAl_POSITION_Y + Dimens.CIRILICAL_POSITION_ADDITION_Y * y,
                    Move.VERTICAL_BLOCK_BOUNCE_MOVE, 0);
            letters.add(cr);
        }
        return letters;
    }

    static ArrayList<Letter> createDevanagariLetters(Context context, int rgb) {

        ArrayList<Letter> letters = new ArrayList<>();

        //rango caracteres devanagari: 0x904-0x939
        final int FIRST_LETTER = 0x0904;
        final int NUMBER_OF_LETTERS = 0x939 - 0x904;
        final int LETTERS_PER_ROW = 10;//15;
        int x = -1;
        int y = -1;

        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {

            char value = (char) (FIRST_LETTER + i);
            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if (x == 0) y++;

            letters.add(
                    new Letter(value, context, rgb, 0f,
                            (Dimens.DEVANAGARI_POSITION_X + Dimens.DEVANAGARI_POSITION_ADDITION_X * x),
                            (Dimens.DEVANAGARI_POSITION_Y + Dimens.DEVANAGARI_POSITION_ADDITION_Y * y),
                            Move.VERTICAL_BOUNCE_MOVE, 0)
            );
        }
        return letters;
    }

    static ArrayList<Letter> createHebreanLetters(Context context, int rgb) {

        ArrayList<Letter> letters = new ArrayList<>();
        Letter cr;

        final int FIRST_LETTER = 1488;
        final int NUMBER_OF_LETTERS = 27;// 0xFF;
        final int LETTERS_PER_ROW = 4;// 11; //en realidad son 12
        int x = -1;
        int y = -1;

        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {

            char value = (char) (FIRST_LETTER + i);
            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if (x == 0) y++;

            cr = new Letter(value, context, rgb, 0f,
                    Dimens.HEBREAN_POSITION_X + Dimens.HEBREAN_POSITION_ADDITION_X * x,
                    Dimens.HEBREAN_POSITION_Y + Dimens.HEBREAN_POSITION_ADDITION_Y * y,
                    Move.INFINITE_BLOCK_MOVE, 0);
            letters.add(cr);
        }
        return letters;
    }

    static ArrayList<Letter> createChineeseLetters(Context context, int rgb) {

        ArrayList<Letter> letters = new ArrayList<>();

        //rango caracteres chinos: //rango 4E00-9FFF        son 20991 letters, demasiadas
        final int FIRST_LETTER = 0x4E00;
        final int NUMBER_OF_LETTERS = 0x9FFF - 0x4E00;
        final int LETTERS_PER_ROW = 13; // 15;
        int x = -1;
        int y = -1;

        for (int i = 0; i < NUMBER_OF_LETTERS; i += 55) {

            char value = (char) (FIRST_LETTER + i);
            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if (x == 0) y++;

            letters.add(
                    new Letter(value, context, rgb, 0f,
                            (Dimens.CHINEESE_LETTERS_POSITION_X + Dimens.CHINEESE_LETTERS_ADDITION_X * x),
            (Dimens.CHINEESE_LETTERS_POSITION_Y + Dimens.CHINEESE_LETTERS_ADDITION_Y * y),
            Move.STATIC_MOVE, 0)
            );

        }
        return letters;
    }

    static ArrayList<Letter> createArabianLetters(Context context, int rgb) {

        ArrayList<Letter> letters = new ArrayList<>();

        //rangos xSpeed crear: 0x622-0x623, 0x628-0x63A, 0x641-0x64A

        int LETTERS_PER_ROW = 3 -1; //en realidad son 4
        int x = 0;
        int y = 0;
        int i = 0;

        Letter cr;

        //rangos xSpeed crear: 0x622-0x623
        int FIRST_LETTER = 0x0622;
        int NUMBER_OF_LETTERS = 0x0623- FIRST_LETTER;

        for(; i<= NUMBER_OF_LETTERS; i++){

            char value = (char)(FIRST_LETTER+i);

            cr = getCaracterArabe(context, rgb, x, y, value);
            letters.add(cr);

            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if(x == 0) y++;
        }

        //rangos xSpeed crear: 0x628-0x63A
        FIRST_LETTER = 0x0628;
        NUMBER_OF_LETTERS = 0x063B-FIRST_LETTER;

        for(i = 0; i< NUMBER_OF_LETTERS; i++){

            char value = (char)(FIRST_LETTER+i);
            cr = getCaracterArabe(context, rgb, x, y, value);
            letters.add(cr);

            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if(x == 0) y++;

        }

        //rangos xSpeed crear: 0x641-0x64A
        FIRST_LETTER = 0x0641;
        NUMBER_OF_LETTERS = 0x0658-FIRST_LETTER;

        for(i = 0; i< NUMBER_OF_LETTERS; i++){     //son solo 10 letters

            char value = (char)(FIRST_LETTER+i);
            cr = getCaracterArabe(context, rgb, x, y, value);
            letters.add(cr);

            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if(x == 0) y++;

        }

        //TODO CLEAN THIS CLASS
        if (x < LETTERS_PER_ROW) x++;
        else x = 0;
        if(x == 0) y++;
        if (x < LETTERS_PER_ROW) x++;
        else x = 0;
        if(x == 0) y++;
        if (x < LETTERS_PER_ROW) x++;
        else x = 0;
        if(x == 0) y++;
        if (x < LETTERS_PER_ROW) x++;
        else x = 0;
        if(x == 0) y++;
        if (x < LETTERS_PER_ROW) x++;
        else x = 0;
        if(x == 0) y++;

        //rangos xSpeed crear: 0x641-0x64A
        final int FIRST_LETTER3 = 0x0660;
        final int NUMBER_OF_LETTERS3 = 0x066A-FIRST_LETTER3;

        for(i = 0; i< NUMBER_OF_LETTERS3; i++){     //son solo 10 letters

            char value = (char)(FIRST_LETTER3+i);
            cr =  getCaracterArabe(context, rgb, x, y, value);
            letters.add(cr);

            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if(x == 0) y++;

        }
        return letters;
    }

    private static Letter getCaracterArabe(Context context, int color, int x, int y, char value) {
        Letter cr;
        cr = new Letter(value, context, color, 0f,
                Dimens.ARABIAN_POSITION_X + Dimens.ARABIAN_POSITION_ADDITION_X * x,
                Dimens.ARABIAN_POSITION_Y + Dimens.ARABIAN_POSITION_ADDITION_Y * y,
                Move.HORIZONTAL_BLOCK_BOUNCE_MOVE, 0);
        return cr;
    }

    static ArrayList<Letter> createInfinityBlockLatinLetters(Context context, int rgb) {

        ArrayList<Letter> letters = new ArrayList<>();
        Letter cr;

        final int FIRST_LETTER = 'A';
        final int NUMBER_OF_LETTERS = 26;// 0xFF;
        final int LETTERS_PER_ROW = 4;// 11; //en realidad son 12
        int x = -1;
        int y = -1;

        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {

            char valor = (char) (FIRST_LETTER + i);
            if (x < LETTERS_PER_ROW) x++;
            else x = 0;
            if (x == 0) y++;

            cr = new Letter(valor, context, rgb, 0f,
                    Dimens.HEBREAN_POSITION_X + Dimens.HEBREAN_POSITION_ADDITION_X * x,
                    Dimens.HEBREAN_POSITION_Y + Dimens.HEBREAN_POSITION_ADDITION_Y * y,
                    Move.INFINITE_BLOCK_MOVE, 0);
            letters.add(cr);
        }
        return letters;
    }

    static ArrayList<Letter> createNumbers(Context context, int firstLetter,
                                           int rgb, int movementType, int xPosition, boolean moveRight, int letterType) {

        ArrayList<Letter> letters = new ArrayList<>();

        final int numLetters = 10;
        float yDistance;
        int yPosition;


        if (moveRight) {
            yPosition = Dimens.LATIN_LETTERS_POSITION_Y;
            yDistance = Dimens.LATIN_LETTERS_ADDITION_Y * 2.5f;
        } else {
            //el tamaño es 1050 por eso uso 1025
            // solo se puede ustilizar 950 para que sea compatible con el modo apaisado uso 925
            yPosition = Dimens.LATIN_LETTERS_END_POSITION_Y + 10;
            yDistance = -Dimens.LATIN_LETTERS_ADDITION_Y * 2.5f;
        }

        Letter cr;

        for (int i = 0; i < numLetters; i++) {

            char value = (char) (firstLetter + i);
            cr = new Letter(value, context, rgb, 0f,
                    (float) yPosition + yDistance * i,
                    xPosition,
                    movementType, letterType);

            letters.add(cr);
        }
        return letters;
    }

    private static ArrayList<Letter> createLatinLetterMix(Context context,
                                                          int firstLetter, int rgb, int moveType, int xPosition,
                                                          boolean moveRight, int letterType, int firstLetter2,
                                                          int rgb2, int moveType2, int xPosition2, boolean right2, int letterType2) {

        ArrayList<Letter> letters = new ArrayList<>();

        final int numLetters = 26;
        int yDistance;
        int yPosition;


        if (moveRight) {
            yPosition = Dimens.LATIN_LETTERS_POSITION_Y;
            yDistance = Dimens.LATIN_LETTERS_ADDITION_Y;
        } else {
            //el tamaño es 1050 por eso uso 1025
            // solo se puede ustilizar 950 para que sea compatible con el modo apaisado uso 925
            yPosition = Dimens.LATIN_LETTERS_END_POSITION_Y;
            yDistance = -Dimens.LATIN_LETTERS_ADDITION_Y;
        }

        Letter cr;

        for (int i = 0; i < numLetters; i += 2) {

            char valor = (char) (firstLetter + i);
            cr = new Letter(valor, context, rgb, 0.0f,
                    yPosition + yDistance * i,
                    xPosition,
                    moveType, letterType);

            letters.add(cr);

            char valor2 = (char) (firstLetter2 + i + 1);
            cr = new Letter(valor2, context, rgb2, 0.0f,
                    yPosition + yDistance * (i + 1),
                    xPosition,
                    moveType2, letterType2);

            letters.add(cr);
        }
        return letters;
    }
}
