package com.example.kslovic.unicon;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    final static  String TAG="Kristina";

    TextView tvMeasureFirst;
    TextView tvResult;
    TextView tvMeasureSecond;
    TextView tvValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initializeUI();
    }

    private void initializeUI() {
        this.tvMeasureFirst = (TextView) findViewById(R.id.tvMeasureFirst);
        this.tvResult = (TextView) findViewById(R.id.tvResult);
        this.tvMeasureSecond = (TextView) findViewById(R.id.tvMeasureSecond);
        this.tvValue = (TextView) findViewById(R.id.tvValue);

        Intent startingIntent = this.getIntent();
        if(startingIntent.hasExtra(FirstActivity.VALUE)){
            String inputData1 = startingIntent.getStringExtra(FirstActivity.VALUE);
            tvValue.setText(inputData1);
        }
        if(startingIntent.hasExtra(FirstActivity.MEASURE_FIRST)){
            String inputData2 = startingIntent.getStringExtra(FirstActivity.MEASURE_FIRST);
            tvMeasureFirst.setText(inputData2);
        }
        if(startingIntent.hasExtra(FirstActivity.RESULT)){
            String inputData3 = startingIntent.getStringExtra(FirstActivity.RESULT);
            tvResult.setText(inputData3);
        }
        if(startingIntent.hasExtra(FirstActivity.MEASURE_SECOND)){
            String inputData4 = startingIntent.getStringExtra(FirstActivity.MEASURE_SECOND);
            tvMeasureSecond.setText(inputData4);
        }
        if(startingIntent.hasExtra(SecondActivity.VALUE)){
            String inputData1 = startingIntent.getStringExtra(SecondActivity.VALUE);
            tvValue.setText(inputData1);
        }
        if(startingIntent.hasExtra(SecondActivity.MEASURE_FIRST)){
            String inputData2 = startingIntent.getStringExtra(SecondActivity.MEASURE_FIRST);
            tvMeasureFirst.setText(inputData2);
        }
        if(startingIntent.hasExtra(SecondActivity.RESULT)){
            String inputData3 = startingIntent.getStringExtra(SecondActivity.RESULT);
            tvResult.setText(inputData3);
        }
        if(startingIntent.hasExtra(SecondActivity.MEASURE_SECOND)){
            String inputData4 = startingIntent.getStringExtra(SecondActivity.MEASURE_SECOND);
            tvMeasureSecond.setText(inputData4);
        }
        if(startingIntent.hasExtra(ThirdActivity.VALUE)){
            String inputData1 = startingIntent.getStringExtra(ThirdActivity.VALUE);
            tvValue.setText(inputData1);
        }
        if(startingIntent.hasExtra(ThirdActivity.MEASURE_FIRST)){
            String inputData2 = startingIntent.getStringExtra(ThirdActivity.MEASURE_FIRST);
            tvMeasureFirst.setText(inputData2);
        }
        if(startingIntent.hasExtra(ThirdActivity.RESULT)){
            String inputData3 = startingIntent.getStringExtra(ThirdActivity.RESULT);
            tvResult.setText(inputData3);
        }
        if(startingIntent.hasExtra(ThirdActivity.MEASURE_SECOND)){
            String inputData4 = startingIntent.getStringExtra(ThirdActivity.MEASURE_SECOND);
            tvMeasureSecond.setText(inputData4);
        }
        if(startingIntent.hasExtra(FourthActivity.VALUE)){
            String inputData1 = startingIntent.getStringExtra(FourthActivity.VALUE);
            tvValue.setText(inputData1);
        }
        if(startingIntent.hasExtra(FourthActivity.MEASURE_FIRST)){
            String inputData2 = startingIntent.getStringExtra(FourthActivity.MEASURE_FIRST);
            tvMeasureFirst.setText(inputData2);
        }
        if(startingIntent.hasExtra(FourthActivity.RESULT)){
            String inputData3 = startingIntent.getStringExtra(FourthActivity.RESULT);
            tvResult.setText(inputData3);
        }
        if(startingIntent.hasExtra(FourthActivity.MEASURE_SECOND)){
            String inputData4 = startingIntent.getStringExtra(FourthActivity.MEASURE_SECOND);
            tvMeasureSecond.setText(inputData4);
        }
    }


}
