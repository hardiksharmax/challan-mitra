package com.marakions.challan_mitra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marakions.challan_mitra.beanclasses.ChallanItem;
import com.marakions.challan_mitra.utils.Constants;

public class challandetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challandetail);
        String challanNo = getIntent().getStringExtra("challan_number");
        fetchChallanDetails(challanNo);

    }

    private void fetchChallanDetails(String challanNo) {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child(Constants.CHILD_ROOT).child(challanNo);
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null){
                    ChallanItem challanItem = dataSnapshot.getValue(ChallanItem.class);
                }else{
                    Toast.makeText(challandetail.this, "No challan found for this challan number", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(challandetail.this, "Failed to connect database. Please try again", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
