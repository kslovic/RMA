package com.example.kslovic.unicon;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static  final  String VALUE = "value";
    public static final String RESULT = "pressure";
    public static final String MEASURE_FIRST = "measure";
    public static final String MEASURE_SECOND = "measure2";

    LinearLayout lvSelect;
    TextView tvSelect;
    Button bSelect;
    EditText etSelect;
    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initializeUI();
    }

    private void initializeUI() {
        this.lvSelect = (LinearLayout) findViewById(R.id.lvSelect);
        this.tvSelect = (TextView) findViewById(R.id.tvSelect);
        this.bSelect = (Button) findViewById(R.id.bSelect);
        this.etSelect = (EditText) findViewById(R.id.etSelect);

        lvSelect.setBackgroundColor(ContextCompat.getColor(this,R.color.sactivity));
        tvSelect.setText(getResources().getString(R.string.pressure));
        bSelect.setTextColor(ContextCompat.getColor(this,R.color.sactivity));

        this.bSelect.setOnClickListener(this);

        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pressure_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public void onClick(View v) {
        if(etSelect.getText().toString().isEmpty()){
            Toast.makeText(this, "You must enter a value!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent explicitIntent = new Intent();
            explicitIntent.setClass(getApplicationContext(), ResultActivity.class);
            String textDistance = spinner.getSelectedItem().toString();
            String textDistance2 = spinner2.getSelectedItem().toString();
            explicitIntent.putExtra(MEASURE_FIRST, textDistance);
            explicitIntent.putExtra(MEASURE_SECOND, textDistance2);
            double result = getPressure(textDistance, textDistance2, etSelect.getText().toString());
            explicitIntent.putExtra(RESULT, String.valueOf(result));
            explicitIntent.putExtra(VALUE, etSelect.getText().toString());
            this.startActivity(explicitIntent);
        }
    }

    private double getPressure(String FirstmUnit, String SecondmUnit, String distanceString) {
        double value = Float.parseFloat(distanceString);
        double result=0;
        switch(FirstmUnit) {
            case "atmosphere":
                switch(SecondmUnit) {
                    case "atmosphere":
                        result=value;
                        break;
                    case "bar":
                        result=1.01325*value;
                        break;
                    case "pascal":
                        result=101325*value;
                        break;
                    case "pound-force per square inch":
                        result=14.6959*value;
                        break;
                    case "torr":
                        result=759.99747768001*value;
                        break;
                }
                break;
            case "bar":
                switch(SecondmUnit) {
                    case "atmosphere":
                        result=0.98691999111769113107*value;
                        break;
                    case "bar":
                        result=value;
                        break;
                    case "pascal":
                        result=100000*value;
                        break;
                    case "pound-force per square inch":
                        result=14.503725635349940859*value;
                        break;
                    case "torr":
                        result=750.05919336788542751*value;
                        break;
                }
                break;
            case "pascal":
                switch(SecondmUnit) {
                    case "atmosphere":
                        result=9.869199911176910122e-6*value;
                        break;
                    case "bar":
                        result=10e-6*value;
                        break;
                    case "pascal":
                        result=value;
                        break;
                    case "pound-force per square inch":
                        result=0.00014503725635349936913*value;
                        break;
                    case "torr":
                        result=0.0075005919336788530113*value;
                        break;
                }
                break;
            case "pound-force per square inch":
                switch(SecondmUnit) {
                    case "atmosphere":
                        result=0.068045738063661931339*value;
                        break;
                    case "bar":
                        result=0.068947344093005458188*value;
                        break;
                    case "pascal":
                        result=6894.734409300545849*value;
                        break;
                    case "pound-force per square inch":
                        result=value;
                        break;
                    case "torr":
                        result=51.71476093654924*value;
                        break;
                }
                break;
            case "torr":
                switch(SecondmUnit) {
                    case "atmosphere":
                        result=0.0013157851063711747605*value;
                        break;
                    case "bar":
                        result=0.0013332192590305928358*value;
                        break;
                    case "pascal":
                        result=133.32192590305928093*value;
                        break;
                    case "pound-force per square inch":
                        result=0.01933671052328647666*value;
                        break;
                    case "torr":
                        result=value;
                        break;
                }
                break;
        }
        return result;
    }
}
