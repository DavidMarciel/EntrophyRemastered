package com.example.marciel.entrophy.LettersClasses;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;

import com.example.marciel.entrophy.Dimens.Dimens;
import com.example.marciel.entrophy.Movements.Move;

import java.util.ArrayList;

/**Delegated to instanciate the Alphabets
 * Created by david on 04/01/2018.
 */

class BoardGenerator {

    //cool fonts: ARMALITE, OLIVER, NEUROPOLITICAL, BLKCHCRY

    /*Amarillo Color.rgb(252,147,17)*/
    /*Amarillo Chllón Color.rgb(252,247,17)*/
    /*Amarillo oscuro Color.rgb(228, 123, 12)*/
    /*Naranja Color.rgb(252,147,17)*/
    /*Morado Color.rgb(177, 12, 228)*/
    /*Gris claro  Color.rgb(140,140,140)*/
    /*Gris oscuro Color.rgb(70,70,70)*/

    static ArrayList<Letter> instantiateLatinLetters(Context context) {

        ArrayList<Letter> letters = new ArrayList<>();

        //matrix
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(43, 173, 69), Move.MATRIX_MOVE,
                Dimens.LATIN_LETTERS_POSITION_1, false, TypeFaces.DEFAULT));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(43, 173, 69), Move.MATRIX_MOVE,
                Dimens.LATIN_LETTERS_POSITION_6, true, TypeFaces.DEFAULT));

        //viento lateral
        letters.addAll( instantiateLateralWindLetters(context, Color.BLUE));
        letters.addAll( instantiateLateralWindLettersLowerCase(context, Color.BLUE));

        //letters colores sin mezclar
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(0,0,0), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_2, true, TypeFaces.DEFAULT));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(177, 12, 228), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_3, true, TypeFaces.GLORIA_HALLELUJAH));

        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(252,147,17), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_4, true, TypeFaces.DEFAULT));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(255,0,0), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_10, true, TypeFaces.GLORIA_HALLELUJAH));


        //letters colores sin mezclar
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(177, 12, 228), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_8, true, TypeFaces.DEFAULT));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(0,0,0), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_7, true, TypeFaces.GLORIA_HALLELUJAH));

        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(255,0,0), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_5, true, TypeFaces.DEFAULT));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(252,147,17), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_9, true, TypeFaces.GLORIA_HALLELUJAH));

        return letters;
    }

    static ArrayList<Letter> instantiateLateralWindLetters(Context context, int c){
        return AlphabetsInstanciator.createLetters(context, 'A', c,
                Move.LATERAL_WIND_MOVE, 50, 10, 0, 42, TypeFaces.DEFAULT);
    }

    static ArrayList<Letter> instantiateLateralWindLettersLowerCase(Context context, int c){
        return AlphabetsInstanciator.createLetters(context, 'a', c,
                Move.LATERAL_WIND_MOVE, 350, 1080, 0, -42, TypeFaces.O4B_03);
    }

    /**Encargado de llamar xSpeed la generacion de cada tipo de letra
     *
     */
    static ArrayList<Letter> instantiateLetters(Context context) {

        ArrayList<Letter> letters = new ArrayList<>();

//        createChineeseLetters(Color.rgb(230,230,230) /*Color.LTGRAY*/);                                  //chinas
//        createCirilicalLetters( Color.rgb(77,178,250));                                                //cirilicas
//        createArabianLetters( Color.rgb(219,219,4));                                                    //arabes
//        createDevanagariLetters( Color.rgb(250,181,62));                                               //devanagari
//        createHebreanLetters(Color.rgb(255,178,102)/*Color.rgb(62, 62, 62)*/);                         //hebreo

        letters.addAll( BoardGenerator.instantiateLatinLetters(context));                                                                   //latinas

//        instantiateNumbers(Color.rgb(255, 6, 67));


        return letters;
    }

    static ArrayList<Letter> instantiateWorldLetters(Context context) {

        ArrayList<Letter> letters = new ArrayList<>();

        letters.addAll( AlphabetsInstanciator.createCirilicalLetters(context,
                Color.rgb(77,178,250)));
        letters.addAll( AlphabetsInstanciator.createDevanagariLetters(context,
                Color.rgb(250,181,62)));
        letters.addAll( AlphabetsInstanciator.createHebreanLetters(context, Color.RED));
//        letters.addAll( BoardGenerator.instantiateLaserLetters(context));
//        letters.addAll( BoardGenerator.instantiateSnakeLetters(context));
        letters.addAll( AlphabetsInstanciator.createChineeseLetters(context, Color.WHITE));

        return letters;
    }

    static ArrayList<Letter> instantiateLaserLetters(Context context){
        return AlphabetsInstanciator.createLetters(context, 'a', Color.rgb(70,70,70),
                0, 500, 50, 0, 40, TypeFaces.O4B_03);
    }

    static ArrayList<Letter> instantiateSnakeLetters(Context context){
        return AlphabetsInstanciator.createLetters(context, 'A', Color.rgb(70,70,70),
                0, 200, 50, 0, 40, TypeFaces.DEFAULT);
    }

    static ArrayList<Letter> instantiateMixedLetters(Context context) {

        ArrayList<Letter> letters = new ArrayList<>();

        //matrix
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(43, 173, 69), Move.MATRIX_MOVE,
                Dimens.LATIN_LETTERS_POSITION_1, false, 0));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(43, 173, 69), Move.MATRIX_MOVE,
                Dimens.LATIN_LETTERS_POSITION_6, true, 0));

        //viento lateral
        letters.addAll( BoardGenerator.instantiateLateralWindLetters(context, Color.BLUE));
        letters.addAll( BoardGenerator.instantiateLateralWindLettersLowerCase(context, Color.BLUE));


        letters.addAll( AlphabetsInstanciator.createCirilicalLetters(context, Color.rgb(77,178,250)));
        letters.addAll( AlphabetsInstanciator.createDevanagariLetters(context, Color.rgb(250,181,62)));
        letters.addAll( AlphabetsInstanciator.createHebreanLetters(context, Color.BLACK));

//        letters.addAll( BoardGenerator.instantiateLaserLetters(context));
//        letters.addAll( BoardGenerator.instantiateSnakeLetters(context));


        //letters colores sin mezclar
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(177, 12, 228), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_3, true, TypeFaces.AEROLITE_BOLD));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'a',
                Color.rgb(255,0,0), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_10, true, TypeFaces.BLKCHCRY));


        //letters colores sin mezclar
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(177, 12, 228), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_8, true, 0));
        letters.addAll( AlphabetsInstanciator.createLatinLetters(context, 'A',
                Color.rgb(255,0,0), Move.LINE_BOUNCE_MOVE,
                Dimens.LATIN_LETTERS_POSITION_5, true, 0));

        return letters;
    }

    static ArrayList<Letter> instantiateNumbers(Context context, int color) {

        return AlphabetsInstanciator.createNumbers(context, '0', color, Move.STATIC_MOVE,
                Dimens.LATIN_LETTERS_POSITION_2, true, 0);
    }

}
