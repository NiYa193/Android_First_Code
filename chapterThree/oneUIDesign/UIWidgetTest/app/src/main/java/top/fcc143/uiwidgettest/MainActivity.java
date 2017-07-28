package top.fcc143.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static top.fcc143.uiwidgettest.R.id.edit_text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    //private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        //imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                //添加逻辑
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();
                /**AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a AlertDialog");
                dialog.setMessage("Some thing important!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("好", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                    }
                });
                dialog.setNegativeButton("滚", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                    }
                });
                dialog.show();*/
                /**int progressCount = progressBar.getProgress();
                if (progressCount == 100) {
                    progressCount = 0;
                    progressBar.setProgress(progressCount);
                }
                else{
                    progressCount += 10;
                    progressBar.setProgress(progressCount);
                }*/
                /**if(progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }*/
                //String inputText = editText.getText().toString();
                //Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                //imageView.setImageResource(R.drawable.img_2);
                break;
            default:
                break;
        }
    }
}
