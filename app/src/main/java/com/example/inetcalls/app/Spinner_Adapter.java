package com.example.inetcalls.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inetcalls.app.Object_Classes.CountryCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dizel on 15-May-14.
 */
public class Spinner_Adapter extends ArrayAdapter<String>
{
    private Activity activity;
    private ArrayList data;
    public Resources res;
    LayoutInflater inflater;

    public Spinner_Adapter(Call_Activity activity, int resource, ArrayList objects, Resources resLocal)
    {
        super(activity, resource, objects);
        this.activity = activity;
        data = objects;
        res = resLocal;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        return getCustomView(position, convertView, parent);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent)
    {
        View row = inflater.inflate(R.layout.country_code_in_spinner_layout, parent, false);
        CountryCode tempValues = null;
        tempValues = (CountryCode) data.get(position);
        TextView code = (TextView) row.findViewById(R.id.code);
        ImageView flag = (ImageView) row.findViewById(R.id.flag);

        if(tempValues.getCode().equals("-2"))
        {
            code.setText("Country");
        }
        else
        code.setText(tempValues.getCode());

        flag.setImageDrawable(tempValues.getFlag());

        return row;
    }

}
