package com.example.inetcalls.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.example.inetcalls.app.Object_Classes.Call;

import java.util.ArrayList;
import java.util.List;

public class CallHistroy_Activity extends Activity
{
    ListView callsListView;
    MyCustomListAdapter customListAdapter;
    ArrayList<Call> myCalls = new ArrayList<Call>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_history_layout);

        createCalls();

        callsListView = (ListView) findViewById(R.id.listView);

        customListAdapter = new MyCustomListAdapter(this,
                R.layout.single_call_layout,
                myCalls);

        callsListView.setAdapter(customListAdapter);
    }

    public void createCalls()
    {
        myCalls.add(new Call("0000000","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("1111111","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("2222222","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("3333333","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("0000000","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("1111111","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("2222222","Duration: 5:15","15/5/14"));
        myCalls.add(new Call("3333333","Duration: 5:15","15/5/14"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.call_histroy, menu);
        return true;
    }

    public class MyCustomListAdapter extends ArrayAdapter<Call>
    {
        List<Call> mItems;
        int layoutID;

        public MyCustomListAdapter(Context context, int singleLineLayout,
                                   List<Call> objects) {
            super(context, singleLineLayout, objects);
            // TODO Auto-generated constructor stub
            mItems = objects;
            layoutID = singleLineLayout;
        }


        @Override
        public View getView(int position, View row, ViewGroup parent)
        {

            Call call = mItems.get(position);

            if(row == null)
            {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(layoutID, parent, false);
            }

            // here we take the data from the logical item of Fruit and populate the visual view (the TextView and image, etc.)
            TextView phoneNumber = (TextView) row.findViewById(R.id.historyPhoneNumberTextView);
            phoneNumber.setText(call.getNumber());
            TextView callDuration = (TextView) row.findViewById(R.id.historyDurationTextView);
            callDuration.setText(call.getDuration());
            TextView callDate = (TextView) row.findViewById(R.id.historyDateTextView);
            callDate.setText(call.getDate());

            return row;
        }

    }
}
