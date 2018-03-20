package com.marakions.challan_mitra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bus_E_Pass extends AppCompatActivity {

    EditText studentName, collegeName, address, rollno, course, source, destination;
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__e__pass);

        studentName = findViewById(R.id.Studentname_fill);
        collegeName = findViewById(R.id.collegename_fill);
        rollno = findViewById(R.id.Rollnofill);
        address = findViewById(R.id.StudentAddress_fill);
        course = findViewById(R.id.Course_name_fill);
        source = findViewById(R.id.sourcefill);
        destination = findViewById(R.id.Destinationfill);
        proceed =findViewById(R.id.proceed_bt);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sName = studentName.getText().toString().trim();
                String cName = collegeName.getText().toString().trim();
                String roll = rollno.getText().toString().trim();
                String addr = address.getText().toString().trim();
                String cours = course.getText().toString().trim();
                String sour = source.getText().toString().trim();
                String dest = destination.getText().toString().trim();


                if (!TextUtils.isEmpty(sName) && !TextUtils.isEmpty(cName) && !TextUtils.isEmpty(roll) && !TextUtils.isEmpty(addr)
                        && !TextUtils.isEmpty(cours) && !TextUtils.isEmpty(sour)&&!TextUtils.isEmpty(dest)){
                    Intent intent = new Intent(Bus_E_Pass.this,Docupload.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Bus_E_Pass.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
