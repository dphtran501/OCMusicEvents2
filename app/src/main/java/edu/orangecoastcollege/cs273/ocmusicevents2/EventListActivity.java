package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

/**
 * This activity displays a list of musical artists who will perform at music events in Orange
 * County. Clicking on a list item will launch <code>EventDetailsActivity</code>, which will display
 * information about the event performed by the musical artist in the list item clicked.
 *
 * @author Derek Tran
 * @version 2.0
 * @since September 26, 2017
 */
public class EventListActivity extends ListActivity
{

    private List<MusicEvent> mAllEventsList;

    /**
     * Initializes <code>EventListActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try
        {
            mAllEventsList = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading from JSON", e);
        }

        //setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
        setListAdapter(new EventListAdapter(this, R.layout.music_event_list_item, mAllEventsList));

    }

    /**
     * Launches <code>EventDetailsActivity</code> showing information about the MusicEvent that was
     * clicked in the ListView.
     *
     * @param l        The ListView where the click happened.
     * @param v        The view that was clicked within the ListView.
     * @param position The position of the view in the list.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        MusicEvent selectedEvent = mAllEventsList.get(position);

        detailsIntent.putExtra("Title", selectedEvent.getTitle());
        detailsIntent.putExtra("Date", selectedEvent.getDate());
        detailsIntent.putExtra("Day", selectedEvent.getDay());
        detailsIntent.putExtra("Time", selectedEvent.getTime());
        detailsIntent.putExtra("Location", selectedEvent.getLocation());
        detailsIntent.putExtra("Address1", selectedEvent.getAddress1());
        detailsIntent.putExtra("Address2", selectedEvent.getAddress2());
        detailsIntent.putExtra("ImageName", selectedEvent.getImageName());

        startActivity(detailsIntent);
    }
}
