package com.example.marciel.entrophy.EntrophyClasses;

import android.content.Context;
import android.util.Log;

import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.Storage.DataStoragePasswordService;
import com.example.marciel.entrophy.Storage.DataStoragePossibilitiesService;

import java.util.ArrayList;

public class SelectedLettersInClick {

    private ArrayList<ArrayList<Letter>> lettersSelected;

    public SelectedLettersInClick() {
        this.lettersSelected = new ArrayList<>();
    }

    public void addClick(ArrayList<Letter> lastClickLettersSelected) {
        lettersSelected.add(lastClickLettersSelected);
    }

    public void saveInSharedPreferences(Context context) {
        DataStoragePossibilitiesService.savePossibilities(context, lettersSelected);
    }
}
