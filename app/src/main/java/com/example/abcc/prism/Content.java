package com.example.abcc.prism;


import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;


public class Content extends AppCompatActivity {

    EditText editMonday;
    EditText editTuesday;
    EditText editWednesday;
    EditText editThursday;
    EditText editFriday;
    EditText editSaturday;
    EditText editSunday;
    TextView timeSheet;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("TimeSheet");
        setContentView(R.layout.contentlayout);

        init();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int i=Integer.parseInt((editMonday.getText().toString())+
                        Integer.parseInt(editTuesday.getText().toString())+
                        Integer.parseInt(editWednesday.getText().toString())+
                        Integer.parseInt(editThursday.getText().toString())+
                        Integer.parseInt(editFriday.getText().toString())+
                        Integer.parseInt(editSaturday.getText().toString())+
                        Integer.parseInt(editSunday.getText().toString());
                String s= "Your timesheet for"+ i+"hrs has been approved";
                Toast.makeText(getApplicationContext(),
                        s,Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(getApplicationContext(), Prism.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        editMonday = (EditText) findViewById(R.id.edithour);
        editTuesday = (EditText) findViewById(R.id.edithour2);
        editWednesday = (EditText) findViewById(R.id.edithour3);
        editThursday = (EditText) findViewById(R.id.edithour4);
        editFriday = (EditText) findViewById(R.id.edithour5);
        editSaturday = (EditText) findViewById(R.id.edithour6);
        editSunday = (EditText) findViewById(R.id.edithour7);
        timeSheet= (TextView) findViewById(R.id.textViewTimeSheet);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        String startWeek = sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        String endWeek = sdf.format(cal.getTime());
        timeSheet.setText("Time sheet for week " + startWeek + " - " + endWeek);


    }





}
