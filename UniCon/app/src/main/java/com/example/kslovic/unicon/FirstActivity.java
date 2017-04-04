package com.example.kslovic.unicon;

import android.app.Activity;
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

public class FirstActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static  final  String VALUE = "value";
    public static final String RESULT = "distance";
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

        lvSelect.setBackgroundColor(ContextCompat.getColor(this,R.color.factivity));
        tvSelect.setText(getResources().getString(R.string.distance));
        bSelect.setTextColor(ContextCompat.getColor(this,R.color.factivity));

        this.bSelect.setOnClickListener(this);

        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.distance_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

    @Override
    public void onClick(View v) {
        Intent explicitIntent = new Intent();
        explicitIntent.setClass(getApplicationContext(), ResultActivity.class);
        String textDistance = spinner.getSelectedItem().toString();
        String textDistance2 = spinner2.getSelectedItem().toString();
        explicitIntent.putExtra(MEASURE_FIRST, textDistance);
        explicitIntent.putExtra(MEASURE_SECOND, textDistance2);
        double result=getDistance(textDistance, textDistance2, etSelect.getText().toString());
        explicitIntent.putExtra(RESULT, String.valueOf(result));
        explicitIntent.putExtra(VALUE, etSelect.getText().toString());
        this.startActivity(explicitIntent);
    }
    private double getDistance(String FirstmUnit, String SecondmUnit, String distanceString){
        double distance = Float.parseFloat(distanceString);
        double result=0;
        switch(FirstmUnit){
            case "kilometre":
                switch(SecondmUnit){
                    case "kilometre":
                        result=distance;
                        break;
                    case "metre":
                        result=1000*distance;
                        break;
                    case "centimetre":
                        result=100000*distance;
                        break;
                    case "milimetre":
                        result=1000000*distance;
                        break;
                    case "micrometre":
                        result=1000000000*distance;
                        break;
                    case "nanometre":
                        result=1e+12*distance;
                        break;
                    case "mile":
                        result=0.621371*distance;
                        break;
                    case "yard":
                        result=1093.612959995625*distance;
                        break;
                    case "foot":
                        result=3280.838879986874872*distance;
                        break;
                    case "inch":
                        result=39370.066559842496645*distance;
                        break;
                    case "nautical mile":
                        result=0.53995663640388735782*distance;
                        break;
                }
                break;
            case "metre":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.001*distance;
                        break;
                    case "metre":
                        result=distance;
                        break;
                    case "centimetre":
                        result=100*distance;
                        break;
                    case "milimetre":
                        result=1000*distance;
                        break;
                    case "micrometre":
                        result=1000000*distance;
                        break;
                    case "nanometre":
                        result=1000000000*distance;
                        break;
                    case "mile":
                        result=0.000621371*distance;
                        break;
                    case "yard":
                        result=1.093612959995625*distance;
                        break;
                    case "foot":
                        result=3.280838879986874872*distance;
                        break;
                    case "inch":
                        result=39.370066559842496645*distance;
                        break;
                    case "nautical mile":
                        result=0.00053995663640388735782*distance;
                        break;
                }
                break;
            case "centimetre":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.00001*distance;
                        break;
                    case "metre":
                        result=0.01*distance;
                        break;
                    case "centimetre":
                        result=distance;
                        break;
                    case "milimetre":
                        result=10*distance;
                        break;
                    case "micrometre":
                        result=10000*distance;
                        break;
                    case "nanometre":
                        result=10000000*distance;
                        break;
                    case "mile":
                        result=0.00000621371*distance;
                        break;
                    case "yard":
                        result=0.01093612959995625*distance;
                        break;
                    case "foot":
                        result=0.03280838879986874872*distance;
                        break;
                    case "inch":
                        result=0.39370066559842496645*distance;
                        break;
                    case "nautical mile":
                        result=0.0000053995663640388735782*distance;
                        break;
                }
                break;
            case "milimetre":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.000001*distance;
                        break;
                    case "metre":
                        result=0.001*distance;
                        break;
                    case "centimetre":
                        result=0.1*distance;
                        break;
                    case "milimetre":
                        result=distance;
                        break;
                    case "micrometre":
                        result=1000*distance;
                        break;
                    case "nanometre":
                        result=1000000*distance;
                        break;
                    case "mile":
                        result=0.000000621371*distance;
                        break;
                    case "yard":
                        result=0.001093612959995625*distance;
                        break;
                    case "foot":
                        result=0.003280838879986874872*distance;
                        break;
                    case "inch":
                        result=0.039370066559842496645*distance;
                        break;
                    case "nautical mile":
                        result=0.00000053995663640388735782*distance;
                        break;
                }
                break;
            case "micrometre":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.000000001*distance;
                        break;
                    case "metre":
                        result=0.000001*distance;
                        break;
                    case "centimetre":
                        result=0.0001*distance;
                        break;
                    case "milimetre":
                        result=0.001*distance;
                        break;
                    case "micrometre":
                        result=distance;
                        break;
                    case "nanometre":
                        result=1000*distance;
                        break;
                    case "mile":
                        result=0.000000000621371*distance;
                        break;
                    case "yard":
                        result=0.000001093612959995625*distance;
                        break;
                    case "foot":
                        result=0.000003280838879986874872*distance;
                        break;
                    case "inch":
                        result=0.000039370066559842496645*distance;
                        break;
                    case "nautical mile":
                        result=0.00000000053995663640388735782*distance;
                        break;
                }
                break;
            case "nanometre":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.000000000001*distance;
                        break;
                    case "metre":
                        result=0.000000001*distance;
                        break;
                    case "centimetre":
                        result=0.0000001*distance;
                        break;
                    case "milimetre":
                        result=0.000001*distance;
                        break;
                    case "micrometre":
                        result=0.001*distance;
                        break;
                    case "nanometre":
                        result=distance;
                        break;
                    case "mile":
                        result=0.000000000000621371*distance;
                        break;
                    case "yard":
                        result=0.000000001093612959995625*distance;
                        break;
                    case "foot":
                        result=0.000000003280838879986874872*distance;
                        break;
                    case "inch":
                        result=0.000000039370066559842496645*distance;
                        break;
                    case "nautical mile":
                        result=0.00000000000053995663640388735782*distance;
                        break;
                }
                break;
            case "mile":
                switch(SecondmUnit){
                    case "kilometre":
                        result=1.6093435021011524011*distance;
                        break;
                    case "metre":
                        result=1609.3435021011523531*distance;
                        break;
                    case "centimetre":
                        result=160934.35021011522622*distance;
                        break;
                    case "milimetre":
                        result=1609343.502101152204*distance;
                        break;
                    case "micrometre":
                        result=1609343502.1011521816*distance;
                        break;
                    case "nanometre":
                        result=1609343502101.1520996*distance;
                        break;
                    case "mile":
                        result=distance;
                        break;
                    case "yard":
                        result=1759.9994554911986597*distance;
                        break;
                    case "foot":
                        result=5279.9983664735955244*distance;
                        break;
                    case "inch":
                        result=63359.980397683146293*distance;
                        break;
                    case "nautical mile":
                        result=0.86897597305677742874*distance;
                        break;
                }
                break;
            case "yard":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.0009143997171029272621*distance;
                        break;
                    case "metre":
                        result=0.91439971710292722307*distance;
                        break;
                    case "centimetre":
                        result=91.439971710292724083*distance;
                        break;
                    case "milimetre":
                        result=914.39971710292718399*distance;
                        break;
                    case "micrometre":
                        result=914399.71710292727221*distance;
                        break;
                    case "nanometre":
                        result=914399717.10292720795*distance;
                        break;
                    case "mile":
                        result=0.00056818164239772676969*distance;
                        break;
                    case "yard":
                        result=distance;
                        break;
                    case "foot":
                        result=2.9999990718599973683*distance;
                        break;
                    case "inch":
                        result=35.999988862319973748*distance;
                        break;
                    case "nautical mile":
                        result=0.00049373634832771459008*distance;
                        break;
                }
                break;
            case "foot":
                switch(SecondmUnit){
                    case "kilometre":
                        result=0.00030479990570097582631*distance;
                        break;
                    case "metre":
                        result=0.30479990570097581504*distance;
                        break;
                    case "centimetre":
                        result=30.479990570097580616*distance;
                        break;
                    case "milimetre":
                        result=304.79990570097578484*distance;
                        break;
                    case "micrometre":
                        result=304799.90570097585442*distance;
                        break;
                    case "nanometre":
                        result=304799905.70097577572*distance;
                        break;
                    case "mile":
                        result=0.0001893938807992422927*distance;
                        break;
                    case "yard":
                        result=0.3333332302066664421*distance;
                        break;
                    case "foot":
                        result=distance;
                        break;
                    case "inch":
                        result=11.999996287439993026*distance;
                        break;
                    case "nautical mile":
                        result=0.00016457878277590485432*distance;
                        break;
                }
                break;
            case "inch":
                switch(SecondmUnit){
                    case "kilometre":
                        result=2.54e-5*distance;
                        break;
                    case "metre":
                        result=0.0254*distance;
                        break;
                    case "centimetre":
                        result=2.54*distance;
                        break;
                    case "milimetre":
                        result=25.4*distance;
                        break;
                    case "micrometre":
                        result=25400*distance;
                        break;
                    case "nanometre":
                        result=2.54e+7*distance;
                        break;
                    case "mile":
                        result=1.5783e-5*distance;
                        break;
                    case "yard":
                        result=0.02777808*distance;
                        break;
                    case "foot":
                        result=0.08333424*distance;
                        break;
                    case "inch":
                        result=distance;
                        break;
                    case "nautical mile":
                        result=1.37150520259e-5*distance;
                        break;
                }
                break;
            case "nautical mile":
                switch(SecondmUnit){
                    case "kilometre":
                        result=1.8520201497575796701*distance;
                        break;
                    case "metre":
                        result=1852.0201497575797021*distance;
                        break;
                    case "centimetre":
                        result=185202.01497575797839*distance;
                        break;
                    case "milimetre":
                        result=1852020.1497575799003*distance;
                        break;
                    case "micrometre":
                        result=1852020149.7575800419*distance;
                        break;
                    case "nanometre":
                        result=1852020149757.579834*distance;
                        break;
                    case "mile":
                        result=1.1507919685024332601*distance;
                        break;
                    case "yard":
                        result=2025.3938645642824667*distance;
                        break;
                    case "foot":
                        result=6076.1815936928469455*distance;
                        break;
                    case "inch":
                        result=72914.179124314177898*distance;
                        break;
                    case "nautical mile":
                        result=distance;
                        break;
                }
                break;
        }
        return result;
    }
}
