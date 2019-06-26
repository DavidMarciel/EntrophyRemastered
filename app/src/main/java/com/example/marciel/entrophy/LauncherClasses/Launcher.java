package com.example.marciel.entrophy.LauncherClasses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marciel.entrophy.EntrophyClasses.EntrophyView;
import com.example.marciel.entrophy.R;

public class Launcher extends AppCompatActivity {

    ButtonsService buttonsService = new ButtonsService();
    SignalCheckboxService signalCheckboxService = new SignalCheckboxService();
    SeekbarService seekbarService = new SeekbarService();
    AlphabetSpinnerService alphabetSpinnerService = new AlphabetSpinnerService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        signalCheckboxService.initSignalCheckbox(getApplicationContext(), this);
        seekbarService.initSeekBar(getApplicationContext(), findViewById(R.id.seekBar), findViewById(R.id.etiquetaVelocidad));
        alphabetSpinnerService.initAlphabetsSpinner(getApplicationContext(), findViewById(R.id.alphabetsSpinner));

        redirectToEntrophy();
    }

    public void clickButton(View v){
        buttonsService.tapButton(getApplicationContext(), v);
    }

    public void clickSignalCheckbox(View v){
        signalCheckboxService.tapSignal(getApplicationContext(), v);
    }

    private void redirectToEntrophy() {
        Intent iEnt = new Intent(getApplicationContext(), EntrophyView.class);
        iEnt.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(iEnt);
    }

}
