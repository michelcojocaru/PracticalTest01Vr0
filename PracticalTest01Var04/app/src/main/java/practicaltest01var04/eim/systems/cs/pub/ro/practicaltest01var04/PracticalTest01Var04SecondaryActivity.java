package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private TextView textSecond = null;
    private Button verify = null;
    private Button cancel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        textSecond = (TextView) findViewById(R.id.textSecond);
        verify = (Button) findViewById(R.id.verify);
        cancel = (Button) findViewById(R.id.cancel);

        Intent intent = getIntent();
        if(intent != null && intent.getExtras().containsKey("textReceived")){
            String textReceived = intent.getStringExtra("textReceived");
            textSecond.setText(textReceived);
        }

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,null);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,null);
                finish();
            }

        });
    }
}
