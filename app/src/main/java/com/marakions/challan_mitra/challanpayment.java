package com.marakions.challan_mitra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

public class challanpayment extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView challanAmountTv, totalAmtTv, extraAmtTv;
    CheckBox homeDelivertCb;
    Button payBt;
    EditText addressEt;
    AVLoadingIndicatorView avi;
    String amount;
    String challanNo;
    private Thread welcomeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challanpayment);

        challanAmountTv = findViewById(R.id.Challan_payment_amntview);
        extraAmtTv = findViewById(R.id.deliveryamnt);
        homeDelivertCb = findViewById(R.id.deliverycheck);
        addressEt = findViewById(R.id.Address);
        payBt = findViewById(R.id.Payamount);
        avi = findViewById(R.id.avi_challan_payment);
        totalAmtTv = findViewById(R.id.total_amt);
        extraAmtTv.setEnabled(false);

        homeDelivertCb.setOnCheckedChangeListener(this);
        amount = getIntent().getStringExtra("amount");
        challanNo = getIntent().getStringExtra("challan_number");

        totalAmtTv.setText(amount);

        challanAmountTv.setText(amount);
        payBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avi.smoothToShow();
                payBt.setVisibility(View.GONE);
                welcomeThread.start();
            }
        });

        welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5000);  //Delay of 5 seconds
                } catch (Exception e) {

                } finally {
                    Intent intent = new Intent(challanpayment.this, paymentgateway.class);
                    intent.putExtra("challan_number", challanNo);
                    intent.putExtra("amount", amount);
                    startActivity(intent);
                    finish();
                }
            }
        };

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            addressEt.setVisibility(View.VISIBLE);
            extraAmtTv.setEnabled(true);
            int total = Integer.parseInt(amount) + Integer.parseInt(extraAmtTv.getText().toString().trim());
            totalAmtTv.setText(String.valueOf(total));

        } else {
            addressEt.setVisibility(View.GONE);
            extraAmtTv.setEnabled(false);
            totalAmtTv.setText(amount);

        }
    }
}
