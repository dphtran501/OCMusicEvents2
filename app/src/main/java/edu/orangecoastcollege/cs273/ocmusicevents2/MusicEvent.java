package edu.orangecoastcollege.cs273.ocmusicevents2;

/**
 * The MusicEvent class is a place holder for data corresponding to music events
 * occurring within Orange County, including title, date, day, time, location,
 * address and a corresponding image.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class MusicEvent
{

    private String mTitle;
    private String mDate;
    private String mDay;
    private String mTime;
    private String mLocation;
    private String mAddress1;
    private String mAddress2;
    private String mImageName;

    /**
     * Gets the title of the music event.
     *
     * @return Title of the music event.
     */
    public String getTitle()
    {
        return mTitle;
    }

    /**
     * Sets the title of the music event.
     *
     * @param title Title of the music event.
     */
    public void setTitle(String title)
    {
        mTitle = title;
    }

    /**
     * Gets the date of the music event.
     *
     * @return The date of the music event.
     */
    public String getDate()
    {
        return mDate;
    }

    /**
     * Sets the date of the music event.
     *
     * @param date The date of the music event.
     */
    public void setDate(String date)
    {
        mDate = date;
    }

    /**
     * Gets the day of the music event.
     *
     * @return The day of the music event.
     */
    public String getDay()
    {
        return mDay;
    }

    /**
     * Sets the day of the music event.
     *
     * @param day The day of the music event.
     */
    public void setDay(String day)
    {
        mDay = day;
    }

    /**
     * Gets the time of the music event.
     *
     * @return The time of the music event.
     */
    public String getTime()
    {
        return mTime;
    }

    /**
     * GSets the time of the music event.
     *
     * @param time The time of the music event.
     */
    public void setTime(String time)
    {
        mTime = time;
    }

    /**
     * Gets the location of the music event.
     *
     * @return The location of the music event.
     */
    public String getLocation()
    {
        return mLocation;
    }

    /**
     * Sets the location of the music event.
     *
     * @param location The location of the music event.
     */
    public void setLocation(String location)
    {
        mLocation = location;
    }

    /**
     * Gets the street address of the music event.
     *
     * @return The street address of the music event.
     */
    public String getAddress1()
    {
        return mAddress1;
    }

    /**
     * Sets the street address of the music event.
     *
     * @param address1 The street address of the music event.
     */
    public void setAddress1(String address1)
    {
        mAddress1 = address1;
    }

    /**
     * Gets the city address of the music event.
     *
     * @return The city address of the music event.
     */
    public String getAddress2()
    {
        return mAddress2;
    }

    /**
     * Sets the city address of the music event.
     *
     * @param address2 The city address of the music event.
     */
    public void setAddress2(String address2)
    {
        mAddress2 = address2;
    }

    /**
     * Gets the image name of the music event image.
     *
     * @return The image name of the music event image.
     */
    public String getImageName()
    {
        return mImageName;
    }

    /**
     * Sets the image name of the music event image.
     *
     * @param imageName The image name of the music event image.
     */
    public void setImageName(String imageName)
    {
        mImageName = imageName;
    }
}
