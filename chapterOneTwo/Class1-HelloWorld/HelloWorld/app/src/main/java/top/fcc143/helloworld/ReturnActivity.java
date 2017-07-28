package top.fcc143.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ReturnActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        Log.d("Second Activity", "The task is:" + getTaskId());
        Button button = (Button) findViewById(R.id.button2_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                Intent intent = new Intent(ReturnActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        //退出程序按钮
        Button button2 = (Button) findViewById(R.id.button2_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Second Activity", "onDestroy");
    }

}
