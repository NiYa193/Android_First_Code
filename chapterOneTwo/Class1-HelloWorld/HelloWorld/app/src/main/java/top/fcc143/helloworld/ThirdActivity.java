package top.fcc143.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Third Activity", "The task is:" + getTaskId());
        setContentView(R.layout.activity_third);

        //退出按钮
        Button button1 = (Button) findViewById(R.id.button3_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ActivityCollector.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }

}
