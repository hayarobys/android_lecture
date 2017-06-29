package com.model.choong.chap07_adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static ArrayList<CustomDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<CustomDTO>();
        list.add(new CustomDTO("어촌1", "바다가 굿!", R.drawable.ph1_s));
        list.add(new CustomDTO("어촌2", "해변가 굿!", R.drawable.ph2_s));
        list.add(new CustomDTO("산촌1", "산 고갯길 굿!", R.drawable.ph3_s));
        list.add(new CustomDTO("산촌2", "산 마루길 굿!", R.drawable.ph4_s));
        list.add(new CustomDTO("농촌1", "강변가 굿!", R.drawable.ph5_s));
        list.add(new CustomDTO("농촌2", "한옥 굿!", R.drawable.ph6_s));

        listView = (ListView)findViewById(R.id.listView);

        CustomAdapter adapter =
            new CustomAdapter(getApplicationContext(),
                                            R.layout.list_item, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(),
                        parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });
    }
}
