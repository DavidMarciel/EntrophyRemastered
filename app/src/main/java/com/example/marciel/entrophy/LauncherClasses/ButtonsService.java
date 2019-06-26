package com.example.marciel.entrophy.LauncherClasses;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.marciel.entrophy.ChangePasswordClasses.ChangePasswordView;
import com.example.marciel.entrophy.R;
import com.example.marciel.entrophy.EntrophyClasses.EntrophyView;
import com.example.marciel.entrophy.ResponseViewClasses.ResponseView;

public class ButtonsService {

    public void tapButton(Context context, View view){

        if(R.id.Entrophy == view.getId()){
            Log.v("Development", "clicked EntrophyView");
            Intent entrophy = new Intent(context, EntrophyView.class);
            entrophy.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            entrophy.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(entrophy);
        }
        if(R.id.SetPassword == view.getId()){
            Log.v("Development", "clicked SetPassword");
            Intent changePassword = new Intent(context, ChangePasswordView.class);
            changePassword.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            changePassword.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(changePassword);
        }
        if(R.id.Result == view.getId()){
            Log.v("Development", "clicked Result");
            Intent response = new Intent(context, ResponseView.class);
            response.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(response);
        }
    }

}
