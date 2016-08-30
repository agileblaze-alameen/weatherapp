package com.example.manager.newweather;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by manager on 30/8/16.
 */
public class RemoteFetch {
    private static final String openweathermapapi="http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric";

    public static JSONObject getjson(Context context, String city)
    {
        try
        {
            URL url= new URL(String.format(openweathermapapi,city));
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.addRequestProperty("x-api-key",context.getString(R.string.open_weather_maps_app_id));
            BufferedReader reader= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer json=new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data= new JSONObject(json.toString());

            if(data.getInt("cod")!=200)
            {
                return null;
            }
            return data;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
