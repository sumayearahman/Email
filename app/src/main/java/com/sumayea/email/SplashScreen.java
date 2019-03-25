package com.sumayea.email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    int progress;
    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mProgressbar= findViewById(R.id.progressBar1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();

            }
        });
        thread.start();
    }

    public void doWork(){
        for (progress=20; progress<100; progress=progress+20){
            try {
                Thread.sleep(400);
                mProgressbar.setProgress(progress);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void startApp(){
        Intent intent= new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
