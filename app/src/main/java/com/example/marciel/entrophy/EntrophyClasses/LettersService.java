package com.example.marciel.entrophy.EntrophyClasses;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.marciel.entrophy.Handlers.Handler;
import com.example.marciel.entrophy.Handlers.LettersHandlerFactory;
import com.example.marciel.entrophy.LettersClasses.BoardsFactory;
import com.example.marciel.entrophy.LettersClasses.Letter;
import com.example.marciel.entrophy.Storage.DataStorageLauncherStateService;

import java.util.ArrayList;
import java.util.List;

/**This class is the one taking care of the letters on the screen
 *
 */
public class LettersService {

    private final Context context;
    private final RelativeLayout relativeLayout;

    private List<Letter> letters;
    private List<Handler> handlers;

    public LettersService(Context context, View relativeLayoutView) {
        this.context = context;
        this.relativeLayout = (RelativeLayout) relativeLayoutView;

        letters = new ArrayList<>();
        handlers = new ArrayList<>();

        setPhoneOrientation(context);
    }

    public void setPhoneOrientation(Context context) {
        //check the phone orientation when the app starts
        int currentPhoneOrientation = context.getResources().getConfiguration().orientation;
        boolean isVerticalyOrientation = (currentPhoneOrientation == Configuration.ORIENTATION_PORTRAIT);

        initializeLettersOrientation(context, isVerticalyOrientation);
    }

    private void initializeLettersOrientation(Context context, boolean isOrientationVertical) {

        Letter.initializeLettersOrientationAndProportion(context, isOrientationVertical);

        updateCharacteres();
    }

    private void updateCharacteres() {

        for (Letter letter : letters) {
            letter.changeAxis();
        }
    }

    //GENERATE
    public void initItems() {

        initLetters();
        initHandlers();
        addLettersToView();

    }

    private void initLetters() {

        String alphabetsType = DataStorageLauncherStateService.getAlphabetsType(context);

        //use the Factory to instantiate the alphabets
        BoardsFactory boardsFactory = new BoardsFactory(context);

        switch (alphabetsType){
            case EntrophyView.DYNAMIC:          letters.addAll( boardsFactory.getLatinLetters()); break;
            case EntrophyView.STATIC:           letters.addAll( boardsFactory.getStaticLetters());break;
            case EntrophyView.WORLD_ALPHABETS:  letters.addAll( boardsFactory.getWorldLetters()); break;
            case EntrophyView.MIXED:            letters.addAll( boardsFactory.getMixedLetters()); break;
        }
    }

    private void addLettersToView() {

        for (Letter leter: letters) {
            relativeLayout.addView(leter);
        }
    }

    //MOVE
    public void moveLetters() {

        for (Letter aLetter: letters) {
            aLetter.move();
        }

        for (Handler aHandler: handlers) {
            aHandler.move();
        }

    }

    //CLEAN
    public void clear() {
        letters = new ArrayList<>();
        handlers = new ArrayList<>();
        relativeLayout.removeAllViews();
    }

    public ArrayList<Letter> getLettersNearAndSignalThem(MotionEvent event) {

        boolean signalLetter = DataStorageLauncherStateService.isSignalizable(context);

        DistanceBetweenLettersAndEvent distanceBetweenLettersAndEvent = new DistanceBetweenLettersAndEvent();
        return distanceBetweenLettersAndEvent.getLettersCloseToEvent(letters, event, signalLetter);
    }

    public ArrayList<Letter> getLettersNearNoSignal(MotionEvent event) {

        DistanceBetweenLettersAndEvent distanceBetweenLettersAndEvent = new DistanceBetweenLettersAndEvent();
        return distanceBetweenLettersAndEvent.getLettersCloseToEvent(letters, event, false);
    }

    public void showInScreen(ArrayList<Letter> selected) {

        letters.addAll(selected);

        for (int i = 0; i < selected.size(); i++) {
            Letter letter = selected.get(i);

            relativeLayout.addView(letter);
        }
    }

    private void initHandlers() {

        LettersHandlerFactory lettersHandlerFactory = new LettersHandlerFactory(context);
        handlers.addAll(lettersHandlerFactory.getHandlers());

        for (Handler aHandler: handlers) {
            letters.addAll(aHandler.getLetters());
        }


        Log.v("EntrophyView", "initItems after handlers");
        Log.v("handlers.length", ""+handlers.size());

    }

}
