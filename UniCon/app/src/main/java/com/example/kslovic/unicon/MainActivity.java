package com.example.kslovic.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bStartFirstActivity;
    Button bStartSecondActivity;
    Button bStartThirdActivity;
    Button bStartFourthActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        this.bStartFirstActivity = (Button) findViewById(R.id.bStartFirstActivity);
        this.bStartSecondActivity = (Button) findViewById(R.id.bStartSecondActivity);
        this.bStartThirdActivity = (Button) findViewById(R.id.bStartThirdActivity);
        this.bStartFourthActivity = (Button) findViewById(R.id.bStartFourthActivity);

        this.bStartFirstActivity.setOnClickListener(this);
        this.bStartSecondActivity.setOnClickListener(this);
        this.bStartThirdActivity.setOnClickListener(this);
        this.bStartFourthActivity.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent explicitIntent = new Intent();
        switch (v.getId()) {
            case (R.id.bStartFirstActivity):
                explicitIntent.setClass(getApplicationContext(), FirstActivity.class);
                break;
            case (R.id.bStartSecondActivity):
                explicitIntent.setClass(getApplicationContext(), SecondActivity.class);
                break;
            case (R.id.bStartThirdActivity):
                explicitIntent.setClass(getApplicationContext(), ThirdActivity.class);
                break;
            case (R.id.bStartFourthActivity):
                explicitIntent.setClass(getApplicationContext(), FourthActivity.class);
                break;
        }
        this.startActivity(explicitIntent);
    }
}
