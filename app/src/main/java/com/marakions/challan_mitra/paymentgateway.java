package com.marakions.challan_mitra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class paymentgateway extends AppCompatActivity {

    EditText holderNameEt,cardNoEt,expiryDateEt,CVVEt;
    Button payBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentgateway);

        holderNameEt =findViewById(R.id.holder_name_et);
        cardNoEt = findViewById(R.id.Card_number);
        expiryDateEt = findViewById(R.id.Exiprydate);
        cardNoEt = findViewById(R.id.Card_number);
        CVVEt = findViewById(R.id.CVV);


    }
}
