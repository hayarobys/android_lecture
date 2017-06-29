package com.model.choong.chap07_adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView img = (ImageView)findViewById(R.id.img);
        TextView title = (TextView)findViewById(R.id.txtTitle);
        TextView contents = (TextView)findViewById(R.id.txtContents);
        Button btn = (Button)findViewById(R.id.close);

        Intent intent = getIntent();
        int id = intent.getExtras().getInt("POSITION");

        CustomDTO dto = MainActivity.list.get(id);

        title.setText(dto.getTitle());
        contents.setText(dto.getContents());
        img.setImageResource(dto.getImgIcon());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
