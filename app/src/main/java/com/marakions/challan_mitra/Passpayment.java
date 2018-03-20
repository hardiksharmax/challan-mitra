package com.marakions.challan_mitra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Passpayment extends AppCompatActivity {

    Button payBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passpayment);

        payBt = findViewById(R.id.pay_bt);

        payBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Passpayment.this,paymentgateway.class);
                startActivity(intent);
            }
        });
    }
}
