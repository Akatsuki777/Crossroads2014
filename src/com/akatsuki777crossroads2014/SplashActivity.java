package com.akatsuki777crossroads2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
 
public class SplashActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
 
        Thread myThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    Intent main = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(main);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
 
}
