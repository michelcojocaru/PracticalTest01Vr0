package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var4MainActivity extends AppCompatActivity {

    private int SECONDARY_ACTIVITY_REQUEST_CODE = 2017;

    private IntentFilter intentFilter = new IntentFilter();
    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();

    private boolean serviceStatus = false;

    private Button center = null;
    private Button topleft = null;
    private Button topright = null;
    private Button bottomleft = null;
    private Button bottomright = null;
    private TextView text = null;
    private Button navigate = null;

    private String textString = "";

    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var4_main);

        center = (Button) findViewById(R.id.center);
        topleft = (Button) findViewById(R.id.topleft);
        topright = (Button) findViewById(R.id.topright);
        bottomleft = (Button) findViewById(R.id.bottomleft);
        bottomright = (Button) findViewById(R.id.bottomright);
        navigate = (Button) findViewById(R.id.navigate);

        text = (TextView) findViewById(R.id.text);
        text.setText(textString);

        serviceStatus = Constants.SERVICE_STOPPED;

        intentFilter = new IntentFilter();
        intentFilter.addAction("sendText");


        if ((savedInstanceState != null)) {
            if (savedInstanceState.containsKey("counter")) {
                Toast.makeText(this,"The activity began with counter " + counter, Toast.LENGTH_LONG).show();
            } else {
                counter = 0;
                Toast.makeText(this, "The activity began with counter " + counter, Toast.LENGTH_LONG).show();

            }
        }

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textString = textString + "," + center.getText().toString();
                text.setText(textString);

                if(counter > Constants.NUMBER_OF_CLICKS_THREASHOLD && serviceStatus == Constants.SERVICE_STOPPED){
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04Service.class);
                    intent.putExtra("send",counter);

                    getApplicationContext().startService(intent);
                    serviceStatus = Constants.SERVICE_STARTED;
                }
            }
        });

        topright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textString = textString + "," + topright.getText().toString();
                text.setText(textString);

                if(counter > Constants.NUMBER_OF_CLICKS_THREASHOLD && serviceStatus == Constants.SERVICE_STOPPED){
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04Service.class);
                    intent.putExtra("text",counter);

                    getApplicationContext().startService(intent);
                    serviceStatus = Constants.SERVICE_STARTED;
                }
            }
        });

        topleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textString = textString + "," + topleft.getText().toString();
                text.setText(textString);

                if(counter > Constants.NUMBER_OF_CLICKS_THREASHOLD && serviceStatus == Constants.SERVICE_STOPPED){
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04Service.class);
                    intent.putExtra("send",counter);

                    getApplicationContext().startService(intent);
                    serviceStatus = Constants.SERVICE_STARTED;
                }
            }
        });

        bottomright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textString = textString + "," + bottomright.getText().toString();
                text.setText(textString);

                if(counter > Constants.NUMBER_OF_CLICKS_THREASHOLD && serviceStatus == Constants.SERVICE_STOPPED){
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04Service.class);
                    intent.putExtra("send",counter);

                    getApplicationContext().startService(intent);
                    serviceStatus = Constants.SERVICE_STARTED;
                }
            }
        });

        bottomleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textString = textString + "," + bottomleft.getText().toString();
                text.setText(textString);

                if(counter > Constants.NUMBER_OF_CLICKS_THREASHOLD && serviceStatus == Constants.SERVICE_STOPPED){
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04Service.class);
                    intent.putExtra("send",counter);

                    getApplicationContext().startService(intent);
                    serviceStatus = Constants.SERVICE_STARTED;
                }
            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PracticalTest01Var04SecondaryActivity.class);
                //int counter = Integer.parseInt(textView1.getText().toString()) +
                //        Integer.parseInt(textView2.getText().toString());
                intent.putExtra("textReceived",textString);
                startActivityForResult(intent,SECONDARY_ACTIVITY_REQUEST_CODE);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent intent){
        if(requestCode == SECONDARY_ACTIVITY_REQUEST_CODE){
            Toast.makeText(this,"The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            textString = "";
            counter = 0;
        }
    }




    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("counter", String.valueOf(counter));

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Toast.makeText(this,"The activity began with counter " + counter, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver(messageBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause(){
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        Intent intent = new Intent(this,PracticalTest01Var04Service.class);
        stopService(intent);
        super.onDestroy();
    }
}
