package com.example.inetcalls.app.Object_Classes;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.example.inetcalls.app.R;

import java.util.ArrayList;

public class CountryCode
{
    private String code;
    private Drawable flag;

    public CountryCode(String code, Drawable flag)
    {
        setCode(code);
        setFlag(flag);
    }

    public static ArrayList<CountryCode> getAllCodes(Context context)
    {
        ArrayList<CountryCode> CustomListViewValuesArr = new ArrayList<CountryCode>();
        CustomListViewValuesArr.add(new CountryCode("-2",context.getResources().getDrawable(R.drawable.phone)));
        CustomListViewValuesArr.add(new CountryCode("972",context.getResources().getDrawable(R.drawable.il)));
        CustomListViewValuesArr.add(new CountryCode("7",context.getResources().getDrawable(R.drawable.ru)));
        CustomListViewValuesArr.add(new CountryCode("1",context.getResources().getDrawable(R.drawable.us)));
        CustomListViewValuesArr.add(new CountryCode("380",context.getResources().getDrawable(R.drawable.ua)));
        return CustomListViewValuesArr;
    }

    public static ArrayList<String> getAllAreaCodes(CountryCode country)
    {
        ArrayList<String> areaCodes = new ArrayList<String>();

        switch(Integer.parseInt(country.getCode()))
        {
            case 972:
            {
                areaCodes.add("50");
                areaCodes.add("52");
                areaCodes.add("53");
                areaCodes.add("54");
                areaCodes.add("55");
                break;
            }

            case 7:
            {
                areaCodes.add("901");
                areaCodes.add("902");
                areaCodes.add("903");
                areaCodes.add("904");
                areaCodes.add("905");
                break;
            }

            case 1:
            {
                areaCodes.add("012");
                areaCodes.add("013");
                areaCodes.add("014");
                areaCodes.add("015");
                areaCodes.add("016");
                break;
            }

            case 380:
            {
                areaCodes.add("97");
                areaCodes.add("98");
                areaCodes.add("99");
                areaCodes.add("96");
                areaCodes.add("016");
                break;
            }
        }


        return areaCodes;
    }

    public void setCode(String code)
    {
        this.code=code;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setFlag(Drawable flag)
    {
        this.flag = flag;
    }

    public Drawable getFlag()
    {
        return this.flag;
    }
}

