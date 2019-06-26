package com.example.marciel.entrophy.ChangePasswordClasses;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.marciel.entrophy.ChangePasswordClasses.Keyword;
import com.example.marciel.entrophy.ChangePasswordClasses.LettersRelocation;
import com.example.marciel.entrophy.EntrophyClasses.AsyncLoop;
import com.example.marciel.entrophy.EntrophyClasses.ClickCounterService;
import com.example.marciel.entrophy.EntrophyClasses.LettersService;
import com.example.marciel.entrophy.EntrophyClasses.UserInput;
import com.example.marciel.entrophy.EntrophyClasses.ValidTimeService;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.R;

import java.util.ArrayList;


public class ChangePasswordView extends Activity {

    public static final String DYNAMIC = "Dynamic";
    public static final String STATIC = "Static";
    public static final String WORLD_ALPHABETS = "World Alphabets";
    public static final String MIXED = "Mixed";

    public static final int BACKGROUND_COLOR = Color.LTGRAY;
    private int SIZE_OF_KEYWORD = 5;

    private AsyncLoop asyncLoop;
    private ValidTimeService validTimeService;
    private LettersService lettersService;
    private ClickCounterService clickCounterService;
    private UserInput userInput;
    private Keyword keyword;

    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        setContentView(R.layout.entrophy);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        clickCounterService = new ClickCounterService(SIZE_OF_KEYWORD);
        keyword = new Keyword();
        relativeLayout = findViewById(R.id.rLayout);

        setBorder();
        setBackgroundColor();
    }

    private void setBorder() {
        relativeLayout.setPadding(1, 1, 1, 1); //screen border
    }

    private void setBackgroundColor() {
        relativeLayout.setBackgroundColor(BACKGROUND_COLOR);
    }

    @Override
    protected void onResume() {
        super.onResume();

        validTimeService = new ValidTimeService();
        userInput = new UserInput();

        lettersService = new LettersService(getApplicationContext(), relativeLayout);
        lettersService.initItems();

        asyncLoop = new AsyncLoop(getApplicationContext(), lettersService);
        asyncLoop.initAsyncLoop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        asyncLoop.stop();
        lettersService.clear();
    }

    /**screen click (tap)
     * We need a single letter pero position as keyword letter
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(validTimeService.isADifferentClick()){

            //Letters near the position clicked
            ArrayList<Letter> lettersNear = lettersService.getLettersNearNoSignal(event);

            if(lettersNear.size() == 0){
                //if user selects none nothing happens
                return true;

            } else if (lettersNear.size() == 1){
                //if user selects one, this is the selection
                asyncLoop.stop();
                choosenALetter(lettersNear.get(0));

            } else {
                //if user selects many he should choose one between them
                asyncLoop.stop();
                chooseOneOfTheLettersNear(lettersNear);
            }
        }
        return true;
    }

    private void choosenALetter(Letter lettersNear) {

        //add the click as the choosen
        keyword.addKeywordLetter(lettersNear);

        Log.v("touch", "isAdifferentClick ");
        if(!clickCounterService.thereAreMoreclicks()){

            //keyword full
            end();
        } else {
            //choose another letter
            lettersService.clear();
            onResume();
        }
    }

    private void chooseOneOfTheLettersNear(ArrayList<Letter> lettersNear) {
        lettersService.clear();
        ArrayList<Letter> relocatedLetters = LettersRelocation.recolocateLetters(lettersNear);

        lettersService.showInScreen(relocatedLetters);
    }

    private void end() {
        keyword.saveInSharedPreferences(getApplicationContext());

        //TODO call external service with the info
        Log.v("ChangePasswordView", "OUT OF CLICKS " + clickCounterService.getClickCounter());

        this.finish();
    }

    /**Change screen orientation
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        lettersService.setPhoneOrientation(getApplicationContext());
    }

}