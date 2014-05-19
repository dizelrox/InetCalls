package com.example.inetcalls.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Register_Activity extends Activity
{

    private int REGISTER_WINDOW_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }

    public void finishRegistration(View v)
    {
        getIntent().putExtra("login",((TextView)findViewById(R.id.registerLoginEditText)).getText().toString());
        getIntent().putExtra("password",((TextView)findViewById(R.id.registerPasswordEditText)).getText().toString());
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
