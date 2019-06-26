package com.example.marciel.entrophy.ResponseViewClasses;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.R;
import com.example.marciel.entrophy.Storage.DataStoragePasswordService;
import com.example.marciel.entrophy.Storage.DataStoragePossibilitiesService;

public class ResponseView extends Activity {

    private ShowCallInformation showCallInformation;
    private Keyword keyword;
    private Letter[][] selections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);

        keyword = DataStoragePasswordService.getKeyword(getApplicationContext());
        selections = DataStoragePossibilitiesService.getPossibilities(getApplicationContext());

        GrantAccessService grantAccessService = new GrantAccessService(keyword, selections);
        grantAccessService.setMainLabel(getApplicationContext(), findViewById(R.id.mainLabel));

        TimeTakenService timeTakenService = new TimeTakenService();
        timeTakenService.initTimeTakenLabel(getApplicationContext(), findViewById(R.id.timeLabel));


        showCallInformation = new ShowCallInformation();

    }

    public void showResponseInformation(View buttonView) {

        Button showInformation = (Button) buttonView;

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        showCallInformation.buttonClicked(getApplicationContext(), linearLayout, showInformation, keyword, selections);

    }
}
