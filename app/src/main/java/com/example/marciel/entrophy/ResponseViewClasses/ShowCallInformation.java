package com.example.marciel.entrophy.ResponseViewClasses;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.LettersClasses.TypeFaces;

public class ShowCallInformation {

    private boolean isBeingShown = false;

    /*I know this method should look better, the way to play with interfaces is not as beautiful as I would like to,
     *it looks more readable here than in the refactored versions so I will leave this as it is
     */
    public void buttonClicked(Context context, LinearLayout linearLayout, Button showInformationButton, Keyword keyword, Letter[][] selections) {

        if(!isBeingShown){
            isBeingShown = true;

            boolean[] correctClicks = keyword.getCorrectClicks(selections);

            for (int i = 0; i < keyword.size(); i++) {

                Letter keywordLetter =  keyword.getLetter(i);
                Letter[] selection = selections[i];

                //column with keywordLetter and possibilities in this click
                LinearLayout verticalLlinearLayout = getColumn(context, keywordLetter, selection);
                linearLayout.addView(verticalLlinearLayout);

                //add another vertical with the number of letters and the red A here
                LinearLayout verticalLlinearLayoutForSuperAndSubIndex = getColumSuperAndSubIndex(context, correctClicks[i], selection);
                linearLayout.addView(verticalLlinearLayoutForSuperAndSubIndex);
            }

        }
    }

    @NonNull
    private LinearLayout getColumn(Context context, Letter keywordLetter, Letter[] selection) {
        LinearLayout verticalLlinearLayout = new LinearLayout(context);
        verticalLlinearLayout.setOrientation(LinearLayout.VERTICAL);

        keywordLetter.setTextSize(1.3f * keywordLetter.getTextSize());
        verticalLlinearLayout.addView(keywordLetter);

        //print selections

        for (int j = 0; j < selection.length; j++) {
            Letter letter = selection[j];

            verticalLlinearLayout.addView(letter);
        }
        return verticalLlinearLayout;
    }

    @NonNull
    private LinearLayout getColumSuperAndSubIndex(Context context, boolean correctClick, Letter[] selection) {
        LinearLayout verticalLlinearLayoutForSuperAndSubIndex = new LinearLayout(context);
        verticalLlinearLayoutForSuperAndSubIndex.setOrientation(LinearLayout.VERTICAL);


        TextView superIndex = new TextView(context);
        superIndex.setText( "" + selection.length);
        verticalLlinearLayoutForSuperAndSubIndex.addView(superIndex);

        if(correctClick){
            Letter subIndex = new Letter(context, '\u2714', Color.RED, TypeFaces.LE_FUTUR_ATENDRA);
            verticalLlinearLayoutForSuperAndSubIndex.addView(subIndex);
        }
        return verticalLlinearLayoutForSuperAndSubIndex;
    }

}
