package com.example.manager.newweather;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by manager on 30/8/16.
 */
public class CityPreference {

    SharedPreferences preferences;

    public CityPreference(Activity activity) {
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    String getCity() {
        return preferences.getString("city", "Sydney, AU");
    }

   void setCity(String city)
    {
        preferences.edit().putString("city",city).commit();
    }

}
