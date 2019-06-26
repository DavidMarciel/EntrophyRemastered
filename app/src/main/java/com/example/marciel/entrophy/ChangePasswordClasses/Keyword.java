package com.example.marciel.entrophy.ChangePasswordClasses;

import android.content.Context;
import android.util.Log;

import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.Storage.DataStoragePasswordService;
import com.example.marciel.entrophy.Storage.DataStoragePossibilitiesService;

import java.util.ArrayList;

public class Keyword {

    private ArrayList<Letter> keyword;

    public Keyword() {
        this.keyword = new ArrayList<>();
    }

    public void addKeywordLetter(Letter letter) {
        keyword.add(letter);
    }

    public void saveInSharedPreferences(Context context) {
        DataStoragePasswordService.saveKeyWord(context, keyword);
    }

    public boolean containedInSelections(Letter[][] selections) {

        //avoid issues when no keyword is selected
        if( !isThereKeyword()){
            throw new Error("SET A PASSWORD");
        }

        for (int i = 0; i < keyword.size(); i++) {
            Letter letter = keyword.get(i);

            if ( ! letterContainedIn(letter, selections[i])){
                return false;
            }
        }
        return true;
    }

    private boolean letterContainedIn(Letter keywordLetter, Letter[] selection) {

        //avoid issues when no leter is selected
        if(selection.length == 0){
            return false;
        }

        for (int i = 0; i < selection.length; i++) {
            Letter letter = selection[i];

            if(keywordLetter.equals(letter)){
                return true;
            }
        }

        return false;
    }

    public int size() {
        return keyword.size();
    }

    public Letter getLetter(int i) {
        return keyword.get(i);
    }

    public boolean[] getCorrectClicks(Letter[][] selections) {

        boolean[] correctClicks = new boolean[keyword.size()];

        //avoid issues when no keyword is selected
        if( !isThereKeyword()){
            throw new Error("SET A PASSWORD");
        }

        for (int i = 0; i < keyword.size(); i++) {
            Letter letter = keyword.get(i);

            correctClicks[i] = letterContainedIn(letter, selections[i]);
        }

        return correctClicks;
    }

    private boolean isThereKeyword() {
        return keyword.size() != 0;
    }
}
