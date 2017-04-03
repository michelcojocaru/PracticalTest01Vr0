package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.Random;

/**
 * Created by michelcojocaru on 4/3/17.
 */

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private String text = null;


    public ProcessingThread(Context context, String textString){
        this.context = context;
        this.text = textString;

    }

    @Override
    public void run(){
        Log.d("[ProcessingThread]", "Thread has started!");
        while(isRunning){
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage(){
        Intent intent = new Intent();
        intent.setAction("sendText");
        intent.putExtra("message",text);
        context.sendBroadcast(intent);
    }

    private void sleep(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
    }

    public void stopThread(){
        isRunning = false;
    }
}
