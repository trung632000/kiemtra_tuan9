package com.trung.example.kiemtratuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listdate;
    ArrayList<date_class> date_List;
    date_adapter adapter;
    FloatingActionButton butt_add;
    FloatingActionButton butt_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_List= new ArrayList<>();
        anhxa();
        adapter= new date_adapter(this,R.layout.item, date_List);
        listdate.setAdapter(adapter);
        butt_add= findViewById(R.id.but_add_main);
        butt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, activity_add.class);
                startActivity(intent);
            }
        });


    }
    public void xoaItem(int vitri){
        Toast.makeText(this,"Đã xóa thành công",Toast.LENGTH_SHORT).show();
        date_List.remove(vitri);
        adapter.notifyDataSetChanged();
    }
    public void anhxa()
    {
        listdate= findViewById(R.id.list_view);

        date_List.add(new date_class("M Wedding","Stallenbitch, south Africa","54 Day remainiting",R.drawable.ic_baseline_delete_24));
        date_List.add(new date_class(" Trung SN","Quảng Nam","15 Day remainiting",R.drawable.ic_baseline_delete_24));
        date_List.add(new date_class("Thuan Wedding"," Quang Nam","23 Day remainiting",R.drawable.ic_baseline_delete_24));
        date_List.add(new date_class("Lan Metting","B","31 Day remainiting",R.drawable.ic_baseline_delete_24));
        date_List.add(new date_class(getIntent().getStringExtra("eventTitle"),getIntent().getStringExtra("eventDes"),getIntent().getStringExtra("eventCount"),R.drawable.ic_baseline_delete_24));
    }

}