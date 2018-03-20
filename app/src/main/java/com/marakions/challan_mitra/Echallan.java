package com.marakions.challan_mitra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marakions.challan_mitra.utils.Constants;

public class Echallan extends AppCompatActivity {

    EditText challanNoEt;
    Button payBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echallan);

        challanNoEt = findViewById(R.id.challanno);
        payBt = findViewById(R.id.Echallan);

        payBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String challanNo = challanNoEt.getText().toString().trim();
                if (TextUtils.isEmpty(challanNo))
                    Toast.makeText(Echallan.this, "Please enter challan number", Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(Echallan.this,challandetail.class);
                    intent.putExtra("challan_number",challanNo);
                    startActivity(intent);
                }
            }
        });

    }


}
