package top.fcc143.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.content;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private Button receive;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();//初始化消息数据
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        receive = (Button) findViewById(R.id.receive);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        //发送消息
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String contend = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(contend, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    //将ListView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });
        //接收消息
        receive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String contend = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(contend, Msg.TYPE_RECEIVED);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    //将ListView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });

    }

    private void initMsgs(){
        Msg msg1 = new Msg("我是熊宝宝", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("我是房老大", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("老大我爱你", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
