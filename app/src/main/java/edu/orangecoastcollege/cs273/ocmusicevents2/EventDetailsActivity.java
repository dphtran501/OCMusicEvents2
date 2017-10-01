package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * This activity displays information about an artist and the event he/she is performing at. The
 * information is specified by which list item was clicked in <code>EventsListActivity</code>.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 26, 2017
 */
public class EventDetailsActivity extends AppCompatActivity
{

    /**
     * Initializes <code>EventDetailsActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String date = intent.getStringExtra("Date");
        String day = intent.getStringExtra("Day");
        String time = intent.getStringExtra("Time");
        String location = intent.getStringExtra("Location");
        String address1 = intent.getStringExtra("Address1");
        String address2 = intent.getStringExtra("Address2");
        String imageName = intent.getStringExtra("ImageName");

        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);
        TextView eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView eventDateDayTextView = (TextView) findViewById(R.id.eventDateDayTextView);
        TextView eventTimeTextView = (TextView) findViewById(R.id.eventTimeTextView);
        TextView eventLocationTextView = (TextView) findViewById(R.id.eventLocationTextView);
        TextView eventAddress1TextView = (TextView) findViewById(R.id.eventAddress1TextView);
        TextView eventAddress2TextView = (TextView) findViewById(R.id.eventAddress2TextView);

        AssetManager am = this.getAssets();
        try
        {
            InputStream stream = am.open(imageName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + imageName, e);
        }
        eventTitleTextView.setText(title);
        eventDateDayTextView.setText(date + " - " + day);
        eventTimeTextView.setText(time);
        eventLocationTextView.setText(location);
        eventAddress1TextView.setText(address1);
        eventAddress2TextView.setText(address2);

    }

    /**
     * Terminates this activity and returns to <code>EventsListActivity</code>.
     *
     * @param v The <code>View</code> that called this method.
     */
    protected void goBackToList(View v)
    {
        finish();
    }
}
