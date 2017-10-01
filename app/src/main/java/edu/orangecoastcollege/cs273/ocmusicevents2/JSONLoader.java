package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class loads MusicEvent data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (MusicEvent) with data.
 *
 * @author Derek Tran
 * @version 1.1
 * @since September 26, 2017
 */

public class JSONLoader
{

    /**
     * Loads JSON data from a file in the assets directory.
     *
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static List<MusicEvent> loadJSONFromAsset(Context context) throws IOException
    {
        ArrayList<MusicEvent> allEventsList = new ArrayList<>();
        String json;
        InputStream is = context.getAssets().open("MusicEvents.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        // Now that the JSON string has been retrieved, parse it for each individual
        // MusicEvent object and add each object to the ArrayList (allEventsList)
        try
        {
            JSONObject rootObject = new JSONObject(json);
            JSONArray allEventsArray = rootObject.getJSONArray("MusicEvents");
            int length = allEventsArray.length();

            // Loop through the array one by one, create a new MusicEvent object add the object to
            // an array list
            for (int i = 0; i < length; i++)
            {
                JSONObject event = allEventsArray.getJSONObject(i);
                MusicEvent musicEvent = new MusicEvent();
                musicEvent.setTitle(event.getString("Title"));
                musicEvent.setDate(event.getString("Date"));
                musicEvent.setDay(event.getString("Day"));
                musicEvent.setTime(event.getString("Time"));
                musicEvent.setLocation(event.getString("Location"));
                musicEvent.setAddress1(event.getString("Address1"));
                musicEvent.setAddress2(event.getString("Address2"));
                musicEvent.setImageName(event.getString("ImageName"));
                allEventsList.add(musicEvent);
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return allEventsList;
    }
}
