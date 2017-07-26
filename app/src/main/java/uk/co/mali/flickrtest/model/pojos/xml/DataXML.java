package uk.co.mali.flickrtest.model.pojos.xml;

/**
 * Created by alig2 on 26/07/2017.
 */


public class DataXML
{
    private Feed feed;

    public Feed getFeed ()
    {
        return feed;
    }

    public void setFeed (Feed feed)
    {
        this.feed = feed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [feed = "+feed+"]";
    }
}

