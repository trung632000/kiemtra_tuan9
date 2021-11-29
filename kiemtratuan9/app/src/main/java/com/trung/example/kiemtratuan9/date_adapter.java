package com.trung.example.kiemtratuan9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class date_adapter extends BaseAdapter {
    private MainActivity mycontext;

    private int layout;
    // tạo danh sách chứa đối tượng Sản phẩm;
    private List<date_class>  date_List;

    public date_adapter(MainActivity mycontext, int layout, List<date_class> dateList) {
        this.mycontext = mycontext;

        this.layout = layout;
        this.date_List = dateList;
    }

    @Override
    public int getCount() {
        return date_List.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // mỗi dòng trả về item
        LayoutInflater inflater= (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        // ánh xạ
        TextView txvTen= view.findViewById(R.id.title);
        TextView txvMota= view.findViewById(R.id.description);
        TextView result=view.findViewById(R.id.result);


        date_class date= date_List.get(i);
        txvTen.setText(date.getTitle());
        txvMota.setText((date.getDescription()));
        result.setText((date.getResult()));

        Button butt_delete=view.findViewById(R.id.delete);
        butt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycontext.xoaItem(i);
            }
        });
        return view;

}

}