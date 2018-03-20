package com.marakions.challan_mitra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marakions.challan_mitra.beanclasses.ChallanItem;
import com.marakions.challan_mitra.utils.Constants;

public class challandetail extends AppCompatActivity {

    TextView challanNoTv, nameTv, dateTv, locationTv, categoryTv, amountTv;
    private ChallanItem challanItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challandetail);

        challanNoTv = findViewById(R.id.challannumberview);
        nameTv = findViewById(R.id.nameview);
        dateTv = findViewById(R.id.challandateview);
        locationTv = findViewById(R.id.locationview);
        categoryTv = findViewById(R.id.Challancatview);
        amountTv = findViewById(R.id.Challanamtview);

        Button proceed = findViewById(R.id.proceed_bt);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (challanItem == null)
                    return;
                Intent intent = new Intent(challandetail.this, challanpayment.class);
                intent.putExtra("challan_number", challanItem.getChallanNo());
                intent.putExtra("amount", challanItem.getAmount());
                startActivity(intent);
            }
        });
        String challanNo = getIntent().getStringExtra("challan_number");
        fetchChallanDetails(challanNo);

    }

    private void fetchChallanDetails(final String challanNo) {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child(Constants.CHILD_ROOT).child(challanNo);
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    challanItem = dataSnapshot.getValue(ChallanItem.class);
                    if (challanItem==null){
                        Toast.makeText(challandetail.this, "No challan found for this number", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    challanNoTv.setText(challanItem.getChallanNo());
                    dateTv.setText(challanItem.getDate());
                    nameTv.setText(challanItem.getName());
                    categoryTv.setText(challanItem.getCategory());
                    amountTv.setText(challanItem.getAmount());
                    locationTv.setText(challanItem.getLocation());
                } else {
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
