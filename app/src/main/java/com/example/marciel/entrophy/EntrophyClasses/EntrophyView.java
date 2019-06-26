package com.example.marciel.entrophy.EntrophyClasses;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.marciel.entrophy.ChangePasswordClasses.ChangePasswordView;
import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.R;
import com.example.marciel.entrophy.ResponseViewClasses.ResponseView;
import com.example.marciel.entrophy.Storage.DataStoragePasswordService;

import java.util.ArrayList;


public class EntrophyView extends Activity {

    public static final String DYNAMIC = "Dynamic";
    public static final String STATIC = "Static";
    public static final String WORLD_ALPHABETS = "World Alphabets";
    public static final String MIXED = "Mixed";

    //TODO move to resource
    private int SIZE_OF_KEYWORD = 5;

    private static final int BACKGROUND_COLOR = Color.LTGRAY;

    //moves the letters
    private AsyncLoop asyncLoop;

    //ensures there are not multiclicks in a single click
    private ValidTimeService validTimeService;

    //keeps track of the time and stores it when finish
    private TimeTaken timeTaken;

    //is the one controlling letters, instanciate, move, delete
    private LettersService lettersService;

    //controls how many clicks are being done
    private ClickCounterService clickCounterService;

    //stores the position and time of the user clicks
    //this code would be the only information we would send to the server
    private UserInput userInput;

    //stores the letters near the clicks, this way we can show them later
    //this code wouldn´t stay there in production code
    private SelectedLettersInClick selectedLettersInClick;

    //this is used in many places so it made sense to keep a reference to it
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrophy);

        relativeLayout = findViewById(R.id.rLayout);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setBorder();
        setBackgroundColor();

        ensurePasswordIsSet();
    }

    private void ensurePasswordIsSet() {
        EnsurePasswordIsSet.ensureThereIsPassword(getApplicationContext(), this);
    }

    private void setBackgroundColor() {
        relativeLayout.setBackgroundColor(BACKGROUND_COLOR);
    }

    private void setBorder() {
        relativeLayout.setPadding(1, 1, 1, 1); //screen border
    }

    @Override
    protected void onResume() {
        super.onResume();

        clickCounterService = new ClickCounterService(SIZE_OF_KEYWORD);
        validTimeService = new ValidTimeService();
        userInput = new UserInput();
        selectedLettersInClick = new SelectedLettersInClick();

        lettersService = new LettersService(getApplicationContext(), relativeLayout);
        lettersService.initItems();

        asyncLoop = new AsyncLoop(getApplicationContext(), lettersService);
        asyncLoop.initAsyncLoop();

        timeTaken = new TimeTaken(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();

        lettersService.clear();
        asyncLoop.stop();

        timeTaken.end();
    }

    /**screen click (tap)
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.v("touch", "onTouchEvent ");

        if(validTimeService.isADifferentClick()){

            userClick(event);

            Log.v("touch", "isAdifferentClick ");
            if(!clickCounterService.thereAreMoreclicks()){

                end();
            }
        }
        return true;
    }

    private void userClick(MotionEvent event) {

        int ticTime = asyncLoop.getTicTime();
        userInput.addUserClick(new UserClick(ticTime, event.getX(), event.getY()));

        selectedLettersInClick.addClick(lettersService.getLettersNearAndSignalThem(event));
    }

    private void end() {

        asyncLoop.stop();
        lettersService.clear();

        //this code stores in local the letters near the click, this way we can show them later
        //this code wouldn´t stay there in production code
        selectedLettersInClick.saveInSharedPreferences(getApplicationContext());

        //TODO HERE IS WHERE THE CALL TO THE SERVER WOULD GO
        redirectToResponse();

        this.finish();
    }

    private void redirectToResponse() {
        Intent response = new Intent( getApplicationContext(), ResponseView.class);
        response.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(response);
    }

    /**Change screen orientation
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        lettersService.setPhoneOrientation(getApplicationContext());
    }

}