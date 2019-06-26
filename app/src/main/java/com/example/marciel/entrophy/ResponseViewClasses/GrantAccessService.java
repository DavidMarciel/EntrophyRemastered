package com.example.marciel.entrophy.ResponseViewClasses;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.R;

public class GrantAccessService {

    Keyword keyword;
    Letter[][] selections;

    public GrantAccessService(Keyword keyword, Letter[][] selections) {

        this.keyword = keyword;
        this.selections = selections;
    }


    public void setMainLabel(Context context, View mainLabelView) {
        boolean isKeywordContained = keyword.containedInSelections(selections);

        if(isKeywordContained){
            printAccessGranted(context, mainLabelView);
        } else {
            printAccessDenied(context, mainLabelView);
        }
    }

    private void printAccessGranted(Context context, View mainLabelView) {

        TextView mainLabel = (TextView) mainLabelView;

        mainLabel.setText(context.getString(R.string.accessGranted));
        mainLabel.setTextColor(Color.GREEN);
    }

    private void printAccessDenied(Context context, View mainLabelView) {

        TextView mainLabel = (TextView) mainLabelView;

        mainLabel.setText(context.getString(R.string.accessDenied));
        mainLabel.setTextColor(Color.RED);

    }

}
