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

public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static  final  String VALUE = "value";
    public static final String RESULT = "tempearature";
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

        lvSelect.setBackgroundColor(ContextCompat.getColor(this,R.color.tactivity));
        tvSelect.setText(getResources().getString(R.string.temperature));
        bSelect.setTextColor(ContextCompat.getColor(this,R.color.tactivity));

        this.bSelect.setOnClickListener(this);

        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_array, android.R.layout.simple_spinner_item);
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
            double result = getTemperature(textDistance, textDistance2, etSelect.getText().toString());
            explicitIntent.putExtra(RESULT, String.valueOf(result));
            explicitIntent.putExtra(VALUE, etSelect.getText().toString());
            this.startActivity(explicitIntent);
        }
    }

    private double getTemperature(String FirstmUnit, String SecondmUnit, String distanceString) {
        double value = Float.parseFloat(distanceString);
        double result=0;
        switch(FirstmUnit) {
            case "celsius":
                switch(SecondmUnit) {
                    case "celsius":
                        result=value;
                        break;
                    case "fahrenheit":
                        result=1.8*value+32;
                        break;
                    case "kelvin":
                        result=value+273.15;
                        break;
                }
                break;
            case "fahrenheit":
                switch(SecondmUnit) {
                    case "celsius":
                        result=(value-32)*0.56;
                        break;
                    case "fahrenheit":
                        result=value;
                        break;
                    case "kelvin":
                        result=(value+ 459.67)*0.56;
                        break;
                }
                break;
            case "kelvin":
                switch(SecondmUnit) {
                    case "celsius":
                        result=value-273.15;
                        break;
                    case "fahrenheit":
                        result=value*1.8-459.67;
                        break;
                    case "kelvin":
                        result=value;
                        break;
                }
                break;
        }
        return result;
    }
}
