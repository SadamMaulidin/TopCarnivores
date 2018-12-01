package com.tapperware.topcarnivores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashView extends AppCompatActivity {
    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_view);

        Thread mythread = new Thread(){
            public void run(){
                try{
                    while(splashActive && ms < splashTime){
                        if (!paused){
                            ms = ms + 100;
                            sleep(100);
                        }
                    }
                }catch (Exception e) {
                } finally {
                    Intent intent = new Intent(SplashView.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        mythread.start();


    }
}

