package com.example.abcc.prism;

/**
 * Created by vittalkambagi on 13/09/2017.
 */

/**
 * Created by vittalkambagi on 13/09/2017.
 */
import android.app.Activity;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by snraa on 09/09/17.
 */

public class Content extends AppCompatActivity {

    EditText editMonday;
    EditText editTuesday;
    EditText editWednesday;
    EditText editThursday;
    EditText editFriday;
    EditText editSaturday;
    EditText editSunday;
    TextView timeSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("TimeSheet");
        setContentView(R.layout.contentlayout);
        init();
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

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        String startWeek = sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        String endWeek = sdf.format(cal.getTime());
        timeSheet.setText("Time sheet for week " + startWeek + " - " + endWeek);
    }


}
