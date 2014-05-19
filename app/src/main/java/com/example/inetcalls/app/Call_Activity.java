package com.example.inetcalls.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.inetcalls.app.Object_Classes.CountryCode;

import java.util.ArrayList;
import java.util.List;

public class Call_Activity extends ActionBarActivity
{
    ArrayList<CountryCode> CustomListViewValuesArr = new ArrayList<CountryCode>();
    Spinner_Adapter adapter;
    Call_Activity activity = null;
    Spinner countryCodeSpinner;
    Spinner areaCodeSpinner;
    TextView finalCallNumber;
    EditText userInputNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_layout);
        activity=this;
        countryCodeSpinner = (Spinner) findViewById(R.id.countryCodeSpinner);
        areaCodeSpinner = (Spinner) findViewById(R.id.regionCodeSpinner);
        finalCallNumber = (TextView) findViewById(R.id.completeNumberTextView);
        userInputNumber = (EditText) findViewById(R.id.userPhoneInput);
        CustomListViewValuesArr.addAll(CountryCode.getAllCodes(this.getApplicationContext()));
        Resources res = getResources();
        adapter = new Spinner_Adapter(activity, R.layout.country_code_in_spinner_layout, CustomListViewValuesArr,res);
        countryCodeSpinner.setAdapter(adapter);

        countryCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View v, int position, long id)
            {
                CountryCode c = (CountryCode) ((Spinner) findViewById(R.id.countryCodeSpinner)).getSelectedItem();
                if(c.getCode().equals("-2"))
                {
                    finalCallNumber.setText("Select country code!");
                }
                ArrayList<String> ss = CountryCode.getAllAreaCodes(c);
                ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(Call_Activity.this,
                        android.R.layout.simple_spinner_item, ss);
                areaCodeSpinner.setAdapter(spinnerArrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }

        });

        userInputNumber.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                CountryCode selectedCountry = (CountryCode) countryCodeSpinner.getSelectedItem();
                if(selectedCountry.getCode().equals("-2")) {
                    finalCallNumber.setText("Select country code!");
                    return;
                }
                    else
                finalCallNumber.setText(selectedCountry.getCode());
                if(areaCodeSpinner.getSelectedItem() != null)
                finalCallNumber.append(areaCodeSpinner.getSelectedItem().toString());
                finalCallNumber.append(editable);
            }
        });

        areaCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                CountryCode selectedCountry = (CountryCode) countryCodeSpinner.getSelectedItem();
                finalCallNumber.setText(selectedCountry.getCode());
                finalCallNumber.append(areaCodeSpinner.getSelectedItem().toString());
                finalCallNumber.append(userInputNumber.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.call, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }

        if (id == R.id.action_call_history)
        {
            Intent callHistoryIntent = new Intent(this,CallHistroy_Activity.class);
            startActivity(callHistoryIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
