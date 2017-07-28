package top.fcc143.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_layout);

        Button button = (Button) findViewById(R.id.button6_1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //向上一个活动发送数据
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello, FirstAtcivity!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //重写onBackPressed方法，当按下返回键时，依旧可以向上一个活动发送数据
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
