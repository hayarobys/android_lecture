package com.model.choong.chap07_adapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-06-29.
 */

public class CustomAdapter extends BaseAdapter{
    Context ctx;
    int layout;
    ArrayList<CustomDTO> list;
    LayoutInflater inflater; // xml 레이아웃 문서의 자원(위젯)을 받아서 객체 생성.

    public CustomAdapter(Context ctx, int layout, ArrayList<CustomDTO> list){
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // ListView에서 보여줄 데이터 갯수를 지정
        return list.size();
    }

    @Override
    public Object getItem(int position) { // ListView에서 보여줄 객체 지정
        return list.get(position);                                 // (position 값은 동적으로 변함)
    }

    @Override
    public long getItemId(int position) { // getItem() 메서드가 리턴한 객체의 고유 식별자.
        return position;
    }

    // ListView에 실제로 행을 보여줄 때 호출되는 메서드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(layout, null); // list_item.xml 자원을 대상으로 View 객체 생성
        }

        // LayoutInflater 객체를 이용하여 list_item.xml 파일에서 id값 가져오기
        TextView title = (TextView)convertView.findViewById(R.id.txtTitle);
        TextView contents = (TextView)convertView.findViewById(R.id.txtContents);
        ImageView imgIcon = (ImageView)convertView.findViewById(R.id.imgIcon);

        // 리스트 컬렉션에서 저장된 원소를 순서대로 가져와서
        // DTO 클래스 타입의 변수에 저장한다.
        CustomDTO dto = list.get(position);// position에 해당하는 레코드  가져오기

        // DTO 클래스의 Getter()로 데이터를 획득하여 해당 뷰에 적용
        title.setText(dto.getTitle());
        contents.setText(dto.getContents());
        imgIcon.setImageResource(dto.getImgIcon());
        return convertView;
    }
}
