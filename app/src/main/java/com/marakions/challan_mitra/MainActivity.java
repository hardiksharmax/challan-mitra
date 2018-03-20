package com.marakions.challan_mitra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView echallanTv, busPassTv, complaintTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        echallanTv = findViewById(R.id.Echallan);
        busPassTv = findViewById(R.id.Buspass);
        complaintTv = findViewById(R.id.FAQ);

        echallanTv.setOnClickListener(this);
        busPassTv.setOnClickListener(this);
        complaintTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {

            case R.id.Echallan:
            intent = new Intent(this,Echallan.class);
            startActivity(intent);
                break;
            case R.id.Buspass:

                break;

            case R.id.FAQ:

                break;

        }
    }
}
