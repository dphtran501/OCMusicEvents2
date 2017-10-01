package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * An Adapter object that provides views for each MusicEvent object in an MusicEvent data set.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 26, 2017
 */

public class EventListAdapter extends ArrayAdapter<MusicEvent>
{
    private Context mContext;
    private int mResource;
    private List<MusicEvent> mAllEventsList;

    // context = Activity that uses the adapter (EventsListActivity)
    // resource = layout file to inflate (R.layout.music_event_list_item)
    // objects = List<MusicEvent>

    /**
     * Creates a new EventListAdapter object.
     *
     * @param context        The activity that uses this adapter.
     * @param resource       The layout file to inflate.
     * @param allMusicEvents A list of MusicEvent objects.
     */
    public EventListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MusicEvent> allMusicEvents)
    {
        super(context, resource, allMusicEvents);
        mContext = context;
        mResource = resource;
        mAllEventsList = allMusicEvents;
    }

    // Override method called getView

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * inflate(int, android.view.ViewGroup, boolean) to specify a root view and to prevent
     * attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible
     *                    to convert this view to display the correct data, this method can create a
     *                    new view. Heterogeneous lists can specify their number of view types, so
     *                    that this View is always of the right type (see getViewTypeCount() and
     *                    getItemViewType(int)).
     * @param parent      The parent that this view will eventually be attached to.
     * @return A View corresponding to the data at the specified position.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Use "inflater" to inflate the custom layout we just made (R.layout.music_event_list_item)
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // Inflating the custom layout for one single item in the list (repeated multiple times)
        View listItemView = inflater.inflate(mResource, null);

        ImageView listItemImageView = (ImageView) listItemView.findViewById(R.id.listItemImageView);
        TextView listItemTitleTextView = (TextView) listItemView.findViewById(R.id.listItemTitleTextView);
        TextView listItemDateTextView = (TextView) listItemView.findViewById(R.id.listItemDateTextView);

        MusicEvent selectedEvent = mAllEventsList.get(position);
        listItemTitleTextView.setText(selectedEvent.getTitle());
        listItemDateTextView.setText(selectedEvent.getDate());

        // Use the AssetManager to retrieve the image
        AssetManager am = mContext.getAssets();

        try
        {
            InputStream stream = am.open(selectedEvent.getImageName());
            Drawable image = Drawable.createFromStream(stream, selectedEvent.getTitle());
            listItemImageView.setImageDrawable(image);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return listItemView;
    }
}
