package top.fcc143.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_layout);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("FifthActivity", data);

        Button button = (Button) findViewById(R.id.button5_1);
        button.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               //返回上一个活动
               finish();

           }
        });

    }


}
