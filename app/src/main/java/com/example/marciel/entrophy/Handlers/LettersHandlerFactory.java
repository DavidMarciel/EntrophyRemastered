package com.example.marciel.entrophy.Handlers;

import android.content.Context;
import com.example.marciel.entrophy.LettersClasses.BoardsFactory;
import com.example.marciel.entrophy.LettersClasses.Letter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by david on 22/07/2014.
 */
public class LettersHandlerFactory {

    private BoardsFactory boardsFactory;


    public LettersHandlerFactory(Context context) {

        boardsFactory = new BoardsFactory(context);
    }

    public List<Handler> getHandlers() {

        ArrayList<Letter> letters;          //array auxiliar que contiene las letters
        ArrayList<Handler> handlers = new ArrayList<>();

        letters = boardsFactory.getLetters(BoardsFactory.LATIN_LASER_ALPHABET);
        Collections.reverse(letters);
        handlers.add(new HandlerLaser(letters));

        letters = boardsFactory.getLetters(BoardsFactory.LATIN_GUSANO_ALPHABET);
        Collections.reverse(letters);
        handlers.add(new SnakeHandler(letters));

//        letters = boardsFactory.getLetters(AlphabetsFactory.LATIN_INFINITE_BLOCK_ALPHABET);
//        losManejadores.add(new InfiniteBlockHandler(letters));

        return handlers;
    }

}
