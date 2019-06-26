package com.example.marciel.entrophy.LauncherClasses;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.example.marciel.entrophy.Storage.DataStorageLauncherStateService;
import com.example.marciel.entrophy.R;

public class SignalCheckboxService {


    public void initSignalCheckbox(Context applicationContext, Launcher launcher) {

        CheckBox checkboxSignal = launcher.findViewById(R.id.señal);
        boolean isSinalizeChecked = DataStorageLauncherStateService.isSignalizable(applicationContext);

        checkboxSignal.setChecked(isSinalizeChecked);
    }

    public void tapSignal(Context context, View v){

        CheckBox signalCheckbox = (CheckBox) v;
        boolean signal = signalCheckbox.isChecked();

        DataStorageLauncherStateService.signal(context, signal);
    }
}
