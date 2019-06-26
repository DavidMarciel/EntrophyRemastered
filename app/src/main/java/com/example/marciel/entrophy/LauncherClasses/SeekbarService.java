package com.example.marciel.entrophy.LauncherClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.marciel.entrophy.Storage.DataStorageLauncherStateService;

public class SeekbarService {


    public void initSeekBar(final Context context, View seekBarView, final View speedLabel) {

        int speed = DataStorageLauncherStateService.getSpeed(context);

        SeekBar seekBar = (SeekBar) seekBarView;
        seekBar.setProgress(speed);
        updateSpeedLabel(speed, speedLabel);

        seekBar.setOnSeekBarChangeListener(getSeekbarListener(context, speedLabel));

    }

    @NonNull
    private SeekBar.OnSeekBarChangeListener getSeekbarListener(final Context context, final View speedLabel) {
        return new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int speed = seekBar.getProgress() + 1; //you have to add 1 to avoid the 0 value
                updateSpeedLabel(speed, speedLabel);
                Log.v("Speed", "Speed: " + speed);

                DataStorageLauncherStateService.setSpeed(context, speed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };
    }

    private void updateSpeedLabel(int speed, View speedLabel) {
        TextView textView = (TextView) speedLabel;
        textView.setText( String.valueOf(speed));
    }

}
