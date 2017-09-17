package com.example.abcc.prism;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText ntid,password,securityCode;
    Button btnSubmit;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setTitle("Prism");
        setContentView(R.layout.activity_main);
        init();
    }


//the above activity_main go to that xml and go to the text and paste the xml code which is for the respective


    private void init() {

        ntid = (EditText) findViewById(R.id.editNTID);
        password= (EditText) findViewById(R.id.editPassword);
        securityCode= (EditText) findViewById(R.id.editsecurityCode);
        btnSubmit= (Button) findViewById(R.id.savebtn);
        btnCancel= (Button) findViewById(R.id.cancelbtn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Logic to validate if the Ntid,password an security code is valid  on submit button clicked and if the credentials are valid
                on click of submit button the List of projects activity screen is opened.*/
            //user names and pwds
                String userName=ntid.getText().toString();

                if (userName.equals("admin")&& password.getText().toString().equals("pass1234"))

                       /* ||
                        userName.equals("usr1") && password.getText().toString().equals("pass1234")||
                        userName.equals("usr2") && password.getText().toString().equals("pass1234")) */

                {
                    Intent intent = new Intent(getApplicationContext(), Prism.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(),"Credentials invalid",Toast.LENGTH_SHORT).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
