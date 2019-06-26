package com.example.marciel.entrophy.ResponseViewClasses;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.marciel.entrophy.R;
import com.example.marciel.entrophy.Storage.DataStorageTimeTaken;

class TimeTakenService {

    public void initTimeTakenLabel(Context context, View viewById) {

        float timeTaken = DataStorageTimeTaken.getTimeTaken(context);

        TextView timeLabel = (TextView) viewById;

        timeLabel.setText(context.getString(R.string.timeRequired, timeTaken));

    }
}
