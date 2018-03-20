package com.marakions.challan_mitra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wang.avi.AVLoadingIndicatorView;

public class paymentgateway extends AppCompatActivity {

    EditText holderNameEt, cardNoEt, expiryDateEt, CVVEt;
    Button payBt;
    Thread welcomeThread;
    AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentgateway);

        holderNameEt = findViewById(R.id.holder_name_et);
        cardNoEt = findViewById(R.id.Card_number);
        expiryDateEt = findViewById(R.id.Exiprydate);
        cardNoEt = findViewById(R.id.Card_number);
        CVVEt = findViewById(R.id.CVV);
        avi = findViewById(R.id.avi_payment_gateway);
        payBt =findViewById(R.id.Pay);

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
                    sleep(10000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(paymentgateway.this,
                            challanpayment.class);
                    startActivity(i);
                    finish();
                }
            }
        };

    }
}
