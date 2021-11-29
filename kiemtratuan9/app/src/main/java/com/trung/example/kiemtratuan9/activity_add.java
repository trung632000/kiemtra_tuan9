package com.trung.example.kiemtratuan9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Calendar;
import java.util.Date;

public class activity_add extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText edttitle,edtdes;
    Button but_date,but_add;
    TextView Viewdate;
    String Title,des,resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edttitle= findViewById(R.id.edit_title);
        edtdes=findViewById(R.id.edit_des);
        but_date=findViewById(R.id.but_date);
        but_add=findViewById(R.id.but_add);
        Viewdate= findViewById(R.id.result);
        but_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment= new  Date_PickupFragment();
                fragment.show(getSupportFragmentManager(),"date picker");
            }
        });
        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(activity_add.this,MainActivity.class);
                Title=edttitle.getText().toString();
                des=edtdes.getText().toString();
                resultText=Viewdate.getText().toString();
                intent.putExtra("eventTitle",Title);
                intent.putExtra("eventDes",des);
                intent.putExtra("eventCount",resultText);
                intent.putExtra("eventButton",R.drawable.ic_baseline_delete_24);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar=  Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        try {
            Date now= new Date();
            long current= now.getTime();
            long picked=calendar.getTimeInMillis();
            long resultDate=(picked-current)/(24*60*60*1000);
            Viewdate.setText(String.valueOf(resultDate)+" Days Remainting");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
