package com.example.android.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

           // Create dummy data of forecasts
           String[] forecastArray = {
                   "Today - Sunny - 88/63",
                   "Tomorrow - Foggy - 88/63",
                   "Wed - Cloudy - 88/63",
                   "Thu - Asteroids - 88/63",
                   "Fri - Heavy Rain - 88/63",
                   "Sat - HELP - 88/63",
                   "Sun - Sunny - 88/63",

           };

            ArrayList<String> weekForecast = new ArrayList<String>(
                    Arrays.asList(forecastArray)
            );

            // Now that we have some dummy forecast data, create an ArrayAdapter.
            // The ArrayAdapter will take data from a source (like  your dummy forecast)
            // and use it to populate the ListView its attached to.
            ArrayAdapter<String> forecastAdapter = new ArrayAdapter<String>(
                    getActivity(), // The current context
                    R.layout.list_item_forecast, // ID of list item layout
                    R.id.list_item_forecast_textview, // ID of textview to populate
                    weekForecast // Forecast data
            );

            ListView lv = (ListView) rootView.findViewById(R.id.listview_forecast);
            lv.setAdapter(forecastAdapter);

            return rootView;
        }
    }
}
