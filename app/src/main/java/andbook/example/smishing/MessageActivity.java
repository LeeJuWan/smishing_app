package andbook.example.smishing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    private String body = "";
    private String head = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //상태바 제거

        TextView msg = (TextView) findViewById(R.id.msg_info);

        Intent intent = getIntent();
        body = intent.getExtras().getString("body");
        head = intent.getExtras().getString("head");

        msg.setText("문자를 확인 하기전에 먼저 확인해보세요\n"+"수신자: "+head+"\n"+"보낸 내용: "+body);
    }
}


