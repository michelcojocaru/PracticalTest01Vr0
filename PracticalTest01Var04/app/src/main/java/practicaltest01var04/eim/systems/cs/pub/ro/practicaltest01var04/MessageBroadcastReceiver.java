package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by michelcojocaru on 4/3/17.
 */

public class MessageBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("[Message]", intent.getStringExtra("message"));
    }
}
