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

public class FourthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static  final  String VALUE = "value";
    public static final String RESULT = "weight";
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

        lvSelect.setBackgroundColor(ContextCompat.getColor(this,R.color.foactivity));
        tvSelect.setText(getResources().getString(R.string.weight));
        bSelect.setTextColor(ContextCompat.getColor(this,R.color.foactivity));

        this.bSelect.setOnClickListener(this);

        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_array, android.R.layout.simple_spinner_item);
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
            double result = getWeight(textDistance, textDistance2, etSelect.getText().toString());
            explicitIntent.putExtra(RESULT, String.valueOf(result));
            explicitIntent.putExtra(VALUE, etSelect.getText().toString());
            this.startActivity(explicitIntent);
        }
    }

    private double getWeight(String FirstmUnit, String SecondmUnit, String distanceString) {
        double value = Float.parseFloat(distanceString);
        double result=0;
        switch(FirstmUnit){
            case "tonne":
                switch(SecondmUnit){
                    case "tonne":
                    result=value;
                        break;
                    case "kilogram":
                        result=1000*value;
                        break;
                    case "gram":
                        result=1e+6*value;
                        break;
                    case "miligram":
                        result=1e+9*value;
                        break;
                    case "microgram":
                        result=1e+12*value;
                        break;
                    case "pound":
                        result=2204.62*value;
                        break;
                    case "ounce":
                        result=35273.9199982575*value;
                        break;
                }
                break;
            case "kilogram":
                switch(SecondmUnit){
                    case "tonne":
                        result=0.001*value;
                        break;
                    case "kilogram":
                        result=value;
                        break;
                    case "gram":
                        result=1000*value;
                        break;
                    case "miligram":
                        result=1e+6*value;
                        break;
                    case "microgram":
                        result=1e+9*value;
                        break;
                    case "pound":
                        result=2.2046199998910940288*value;
                        break;
                    case "ounce":
                        result=35.27391999825750446*value;
                        break;
                }
                break;
            case "gram":
                switch(SecondmUnit){
                    case "tonne":
                        result=1e-6*value;
                        break;
                    case "kilogram":
                        result=0.001*value;
                        break;
                    case "gram":
                        result=value;
                        break;
                    case "miligram":
                        result=1000*value;
                        break;
                    case "microgram":
                        result=1e+6*value;
                        break;
                    case "pound":
                        result=0.00220462*value;
                        break;
                    case "ounce":
                        result=0.03527400004546*value;
                        break;
                }
                break;
            case "miligram":
                switch(SecondmUnit){
                    case "tonne":
                        result=1e-9*value;
                        break;
                    case "kilogram":
                        result=1e-6*value;
                        break;
                    case "gram":
                        result=1e-3*value;
                        break;
                    case "miligram":
                        result=value;
                        break;
                    case "microgram":
                        result=1000*value;
                        break;
                    case "pound":
                        result=2.2046e-6*value;
                        break;
                    case "ounce":
                        result=3.527360000346e-5*value;
                        break;
                }
                break;
            case "microgram":
                switch(SecondmUnit){
                    case "tonne":
                        result=1e-12*value;
                        break;
                    case "kilogram":
                        result=1e-9*value;
                        break;
                    case "gram":
                        result=1e-6*value;
                        break;
                    case "miligram":
                        result=1e-3*value;
                        break;
                    case "microgram":
                        result=value;
                        break;
                    case "pound":
                        result=2.2046e-9*value;
                        break;
                    case "ounce":
                        result=3.527360000346e-8*value;
                        break;
                }
                break;
            case "pound":
                switch(SecondmUnit){
                    case "tonne":
                        result=0.00045358771568873188992*value;
                        break;
                    case "kilogram":
                        result=0.45358771568873190727*value;
                        break;
                    case "gram":
                        result=453.58771568873191882*value;
                        break;
                    case "miligram":
                        result=453587.71568873192882*value;
                        break;
                    case "microgram":
                        result=453587715.6887319088*value;
                        break;
                    case "pound":
                        result=value;
                        break;
                    case "ounce":
                        result=16*value;
                        break;
                }
                break;
            case "ounce":
                switch(SecondmUnit){
                    case "tonne":
                        result=2.835e-5*value;
                        break;
                    case "kilogram":
                        result=2.835e-2*value;
                        break;
                    case "gram":
                        result=28.349999397*value;
                        break;
                    case "miligram":
                        result=28349.99939700012692*value;
                        break;
                    case "microgram":
                        result=28349999.397000122815*value;
                        break;
                    case "pound":
                        result=0.0625*value;
                        break;
                    case "ounce":
                        result=value;
                        break;
                }
                break;
        }
        return result;
    }
}
