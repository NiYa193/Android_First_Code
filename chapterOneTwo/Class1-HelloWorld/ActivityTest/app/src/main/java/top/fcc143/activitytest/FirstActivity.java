package top.fcc143.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.added_item:
                Toast.makeText(this, "You clicked the Added Button.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked the Remove Button.", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    //用于对第六个活动返回的值进行收集的重写
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1 :
                if(resultCode == RESULT_OK){
                    String returndata =data.getStringExtra("data_return") ;
                    Log.d("First Activity", returndata);
                }
                break;
            default:
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //用于本活动被注销时，保存数据，以便再调用该活动时可以用到
        //暂时不成功
        super.onSaveInstanceState(outState);
        String tempdata = "Something You Just Typed!";
        outState.putString("data_key", tempdata);
        Log.d(TAG, "onSaveInstanceState");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d(TAG, "onCreat");

        //当FirstActivity被注销时，用于保存数据
        if(savedInstanceState != null){
            String tempdata = savedInstanceState.getString("data_key");
            Log.d("Saved data", tempdata);
        }else{
            Log.d(TAG, "Else");
        }



        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //新建一个Toast通知
                //Toast.makeText(FirstActivity.this, "Hello Toast", Toast.LENGTH_SHORT).show();
                //finish();
                //显式调用活动
                //finish();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式调用第二个活动
                Intent intent = new Intent("top.fcc143.activitytest.ACTION_START");
                intent.addCategory("top.fcc143.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式调用浏览器访问网址
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://fcc143.top"));
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式调用电话
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //隐式调用地图
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intent);
            }
        });

        Button button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显式调用Dialog窗口
                Intent intent = new Intent(FirstActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });

        Button button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View view) {
              //显式向下一个活动传递数据
              String data = "Hello FifthActivity!";
              Intent intent = new Intent(FirstActivity.this, FifthActivity.class);
              intent.putExtra("extra_data", data);
              startActivity(intent);
          }
        });

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //显式向上一个活动传递数据
                Intent intent = new Intent(FirstActivity.this, SixthActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

}
