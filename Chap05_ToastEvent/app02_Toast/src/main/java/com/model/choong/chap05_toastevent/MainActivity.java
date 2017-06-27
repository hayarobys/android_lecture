package com.model.choong.chap05_toastevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edit01, edit02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        edit01 = (EditText)findViewById(R.id.edit01);
        edit02 = (EditText)findViewById(R.id.edit02);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Hello, Toast Message", Toast.LENGTH_SHORT);

                int xoff = Integer.parseInt(edit01.getText().toString());
                int yoff = Integer.parseInt(edit02.getText().toString());
                toast.setGravity(Gravity.CENTER, xoff, yoff);
                /*Ctrl + P 를 누르면 필요한 매개변수를 볼 수 있다.*/

                toast.show();
            }
        });
    }
}
