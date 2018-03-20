package com.marakions.challan_mitra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

public class Paymentsuccesfull extends AppCompatActivity {

    TextView paymentSuccessTv, refTv;
    AVLoadingIndicatorView avi;
    private Thread welcomeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentsuccesfull);

        avi = findViewById(R.id.avi_payment_success);
        paymentSuccessTv = findViewById(R.id.Paymentsuccess);
        refTv = findViewById(R.id.Refrence);

        /*showAvi();
        welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(10000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    hideAvi();
                }
            }
        };
        welcomeThread.start();
        if(welcomeThread.getState()!= Thread.State.WAITING){
//            hideAvi();
        }*/
    }

    private void showAvi() {
        paymentSuccessTv.setVisibility(View.GONE);
        refTv.setVisibility(View.GONE);
        avi.smoothToShow();
    }

    private void hideAvi() {
        paymentSuccessTv.setVisibility(View.VISIBLE);
        refTv.setVisibility(View.VISIBLE);
        avi.smoothToHide();
    }
}


