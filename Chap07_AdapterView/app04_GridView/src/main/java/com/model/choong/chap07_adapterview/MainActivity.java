package com.model.choong.chap07_adapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static  Integer[] thumNail = {R.drawable.ph1_s, R.drawable.ph2_s,
                R.drawable.ph3_s, R.drawable.ph4_s,
                R.drawable.ph5_s, R.drawable.ph6_s,
                R.drawable.ph1_s, R.drawable.ph2_s,
                R.drawable.ph3_s, R.drawable.ph4_s,
                R.drawable.ph5_s, R.drawable.ph6_s,
                R.drawable.ph1_s, R.drawable.ph2_s,
                R.drawable.ph3_s, R.drawable.ph4_s,
                R.drawable.ph5_s, R.drawable.ph6_s,
                R.drawable.ph1_s, R.drawable.ph2_s,
                R.drawable.ph3_s, R.drawable.ph4_s,
                R.drawable.ph5_s, R.drawable.ph6_s};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridView);

        ImageAdapter adapter = new ImageAdapter(this);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                                        position+"번째 이미지 선택",
                                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
