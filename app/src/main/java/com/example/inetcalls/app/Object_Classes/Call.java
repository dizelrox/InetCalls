package com.example.inetcalls.app.Object_Classes;


/**
 * Created by Dizel on 4/24/14.
 */
public class Call
{
    private String number;
    private String duration;
    private String date;

    public Call(String number, String duration, String date)
    {
        this.number = number;
        this.duration = duration;
        this.date = date;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public String getNumber()
    {
        return this.number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

}
