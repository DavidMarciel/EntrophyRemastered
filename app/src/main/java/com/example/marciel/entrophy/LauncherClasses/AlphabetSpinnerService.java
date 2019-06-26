package com.example.marciel.entrophy.LauncherClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marciel.entrophy.R;
import com.example.marciel.entrophy.Storage.DataStorageLauncherStateService;

public class AlphabetSpinnerService {


    public void initAlphabetsSpinner(Context context, View alphabetsSpinner) {

        Spinner alphabetsType = (Spinner) alphabetsSpinner;
        initializeAlphabetsSpinnerScreenValue(context, alphabetsType);

        alphabetsType.setOnItemSelectedListener(getAlphabetSpinnerListener(context));
    }

    private void initializeAlphabetsSpinnerScreenValue(Context context, Spinner alphabetsType) {

        String choosedAlphabet = DataStorageLauncherStateService.getAlphabetsType(context);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.alphabetTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        int spinnerPosition = adapter.getPosition(choosedAlphabet);

        alphabetsType.setSelection(spinnerPosition);
    }

    @NonNull
    private AdapterView.OnItemSelectedListener getAlphabetSpinnerListener(final Context context) {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                String alphabetsType = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(adapterView.getContext(),"Alphabets selected : " + alphabetsType, Toast.LENGTH_SHORT).show();

                DataStorageLauncherStateService.setAlphabetsType(context, alphabetsType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
    }
}
