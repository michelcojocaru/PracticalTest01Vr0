package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var04Service extends Service {
    public PracticalTest01Var04Service() {
    }

    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        String textString = intent.getStringExtra("text");
        processingThread = new ProcessingThread(this,textString);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy(){
        processingThread.stopThread();
    }
}
