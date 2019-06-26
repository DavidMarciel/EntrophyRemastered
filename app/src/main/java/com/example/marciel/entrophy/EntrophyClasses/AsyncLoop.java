package com.example.marciel.entrophy.EntrophyClasses;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import com.example.marciel.entrophy.Storage.DataStorageLauncherStateService;

/**This is the main loop, it moves the letters and handlers on the screen
 * Created by david on 19/05/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AsyncLoop extends AsyncTask<Object, Object, Object> {

    private static final String DEVELOPMENT = "Development";
    private int timeToWait = 100;

    private LettersService lettersService;

    // this ticTime is not the overall ticTime, it is a tick counter,
    // it adds one each ticTime the loop executes
    private int ticTime;

    public AsyncLoop(Context context, LettersService lettersService) {
        this.lettersService = lettersService;

        setSpeed(context);
    }

    private void setSpeed(Context context) {
        int speed = DataStorageLauncherStateService.getSpeed(context);

        timeToWait = 100 / speed;
    }


    public void initAsyncLoop() {
        Log.v(DEVELOPMENT, "initAsyncLoop starts");
        ticTime = 0;

        this.execute("");
    }

    @Override
    protected Object doInBackground(Object... params) {

        while (!isCancelled()) {

            loopWait(timeToWait);
            ticTime++;
            publishProgress();
        }
        return null;
    }

    private void loopWait(int timeToWait) {
        try {
            Thread.sleep(timeToWait);

        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.v(DEVELOPMENT, "Failure in AsyncLoop Waiting ");
        }
    }

    @Override
    protected void onProgressUpdate(Object... params) {
        super.onProgressUpdate();

        //this condition is needed to avoid letters moving after stopped the loop
        //the last iteration moved them even if the loop was stopped
        if (!isCancelled()) {

            lettersService.moveLetters();
        }
    }

    public void stop() {
        this.cancel(true);
    }

    public int getTicTime() {
        return ticTime;
    }

}
