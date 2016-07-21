package com.telpa.ecommerce.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.utils.BaseActivity;

public class ScreenJActivity extends BaseActivity {
    private String[] arraySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_j);

        fcreateTitle("Form" + "J");
        fcreateToolbar(this,false,  true, false, R.id.toolbar);
        fcreateMenu(this, false);





        arraySpinner= new String[]{"option", "option2", "option3"};

        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        Spinner spinner2=(Spinner) findViewById(R.id.spinner2);
        Spinner spinner3=(Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, arraySpinner);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
    }
}

