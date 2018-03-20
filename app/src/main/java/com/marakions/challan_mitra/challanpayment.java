package com.marakions.challan_mitra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class challanpayment extends AppCompatActivity {

    TextView challanAmountTv,totalAmtTv,extraAmtTv;
    CheckBox homeDelivertCb;
    Button payBt;
    EditText addressEt;
    private Thread welcomeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challanpayment);

        challanAmountTv = findViewById(R.id.Challan_payment_amntview);
        extraAmtTv = findViewById(R.id.deliveryamnt);
        homeDelivertCb =findViewById(R.id.deliverycheck);
        addressEt =findViewById(R.id.Address);
        payBt =findViewById(R.id.Payamount);

        final String amount = getIntent().getStringExtra("amount");
        final String challanNo = getIntent().getStringExtra("challan_number");

        challanAmountTv.setText(amount);
        payBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeThread.start();
            }
        });

        welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(10000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    Intent intent = new Intent(challanpayment.this,paymentgateway.class);
                    intent.putExtra("challan_number",challanNo);
                    intent.putExtra("amount",amount);
                    startActivity(intent);
                }
            }
        };

    }
}
