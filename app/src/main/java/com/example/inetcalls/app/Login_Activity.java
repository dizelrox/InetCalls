package com.example.inetcalls.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends ActionBarActivity
{
    private int REGISTER_WINDOW_REQUEST_CODE = 1;
    private EditText loginEditText;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void startRegisterIntent(View v)
    {
        Intent registerIntent = new Intent(this, Register_Activity.class);
        startActivityForResult(registerIntent, REGISTER_WINDOW_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REGISTER_WINDOW_REQUEST_CODE)
        {
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
                String login = data.getExtras().getString("login");
                String password=  data.getExtras().getString("password");
                loginEditText.setText(login);
                passwordEditText.setText(password);
            }
        }
    }

    public void login(View v)
    {
        Toast.makeText(this,"Should be db validation here",Toast.LENGTH_SHORT).show();
        Intent callIntent = new Intent(this, Call_Activity.class);
        startActivity(callIntent);
    }
}
