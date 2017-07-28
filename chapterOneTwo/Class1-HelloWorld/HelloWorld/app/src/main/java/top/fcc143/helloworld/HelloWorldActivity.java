package top.fcc143.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HelloWorldActivity extends BaseActivity {

    public static final String TAG = "First Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        Log.d(TAG,"The task is:" + getTaskId());

        Button button = (Button) findViewById(R.id.button1_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("hello:", "button1 clicked");
                Intent intent = new Intent(HelloWorldActivity.this, ReturnActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button1_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
