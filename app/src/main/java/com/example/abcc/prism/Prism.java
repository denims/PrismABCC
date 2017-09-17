package com.example.abcc.prism;

/**
 * Created by shashank on 13/09/2017.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.text.SimpleDateFormat;


/**
 * Created by shashank on 09/09/17.
 */

public class Prism extends AppCompatActivity {
    CheckBox proj1;
    CheckBox proj2;
    CheckBox proj3;
    CheckBox proj4;
    CheckBox proj5;
    CheckBox proj6;
    CheckBox proj7;
    CheckBox proj8;
    CheckBox proj9;
    int currButton = 5;

    Button btnSubmit;
    Button btnLogout;
    Button btnAddProj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
        String startWeek = sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        String endWeek = sdf.format(cal.getTime());

        setTitle("List Of Project "+ startWeek + " - " + endWeek );
        setContentView(R.layout.project);
        init();
    }

    private void init() {

       proj1 = (CheckBox) findViewById(R.id.checkProject1);
        proj2 = (CheckBox) findViewById(R.id.checkProject2);
        proj3 = (CheckBox) findViewById(R.id.checkProject3);
        proj4 = (CheckBox) findViewById(R.id.checkProject4);
        proj5 = (CheckBox) findViewById(R.id.checkProject5);
        proj6 = (CheckBox) findViewById(R.id.checkProject6);
        proj7 = (CheckBox) findViewById(R.id.checkProject7);
        proj8 = (CheckBox) findViewById(R.id.checkProject8);
        proj9 = (CheckBox) findViewById(R.id.checkProject9);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnAddProj = (Button) findViewById(R.id.btnAddProj);

        //proj1.setText("test");
        //proj2.setVisibility(View.INVISIBLE);
        proj5.setVisibility(View.INVISIBLE);
        proj6.setVisibility(View.INVISIBLE);
        proj7.setVisibility(View.INVISIBLE);
        proj8.setVisibility(View.INVISIBLE);
        proj9.setVisibility(View.INVISIBLE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic to save the timesheet details
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        checkEvent();

        btnAddProj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the popup

                final CharSequence projs[] = new CharSequence[] {"Project 10", "Project 11", "Project 12", "Project 13"};

                AlertDialog.Builder builder = new AlertDialog.Builder(Prism.this);
                builder.setTitle("Add a project");
                builder.setItems(projs, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //on click
                        if (currButton == 5){
                            currButton=6;
                            System.out.println(projs[which]);
                           // proj5.setText(which);
                            proj5.setVisibility(View.VISIBLE);
                            proj5.setText(projs[which]);
                            return;

                        }
                        if (currButton == 6){
                            currButton=7;
                            System.out.println(projs[which]);
                            // proj5.setText(which);
                            proj6.setVisibility(View.VISIBLE);
                            proj6.setText(projs[which]);
                            return;

                        }
                        if (currButton == 7){
                            currButton=8;
                            System.out.println(projs[which]);
                            // proj5.setText(which);
                            proj7.setVisibility(View.VISIBLE);
                            proj7.setText(projs[which]);
                            return;

                        }
                        if (currButton == 8){
                            currButton=9;
                            System.out.println(projs[which]);
                            // proj5.setText(which);
                            proj8.setVisibility(View.VISIBLE);
                            proj8.setText(projs[which]);
                            return;

                        }
                        if (currButton == 9){
                            System.out.println(projs[which]);
                            // proj5.setText(which);
                            proj9.setVisibility(View.VISIBLE);
                            proj9.setText(projs[which]);
                            return;

                        }
                    }
                });
                builder.show();
            }
        });


    }



    //if any of the project is checked it wil go to content layout where user have to fill the timesheet
    private void checkEvent() {

        proj1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj1.isChecked())
                {
                    Intent intentproj1 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj1);
                    finish();
                }


            }
        });
        proj2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj2.isChecked())
                {
                    Intent intentproj2 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj2);
                    finish();

                }


            }
        });
        proj3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj3.isChecked())
                {
                    Intent intentproj3 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj3);
                    finish();

                }


            }
        });
        proj4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj4.isChecked())
                {
                    Intent intentproj4 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj4);
                    finish();

                }


            }
        });

        proj9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj9.isChecked())
                {
                    Intent intentproj9 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj9);
                    finish();

                }


            }
        });

        proj5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj5.isChecked())
                {
                    Intent intentproj5 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj5);
                    finish();

                }


            }
        });

        proj6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj6.isChecked())
                {
                    Intent intentproj6 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj6);
                    finish();

                }


            }
        });

        proj7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj7.isChecked())
                {
                    Intent intentproj7 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj7);
                    finish();

                }


            }
        });

        proj8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (proj8.isChecked())
                {
                    Intent intentproj8 = new Intent (getApplicationContext(),Content.class);
                    startActivity(intentproj8);
                    finish();

                }


            }
        });


    }




}