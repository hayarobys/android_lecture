package com.model.choong.chap06_activity_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText receiver, message;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = (EditText)findViewById(R.id.receiver);
        message = (EditText)findViewById(R.id.message);
        btn = (Button)findViewById(R.id.send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * "smsto:" - 문자 전송 액티비티 호출
                * "tel:" - 전화 관련 액티비티 호출
                * */

                Uri num = Uri.parse("smsto:"+receiver.getText());
                Intent intent = new Intent(Intent.ACTION_SENDTO, num);

                String msg = message.getText().toString();
                intent.putExtra("sms_body", msg);

                startActivity(intent);
            }
        });
    }
}
