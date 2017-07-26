package uk.co.mali.flickrtest.model.pojos.xml;

/**
 * Created by alig2 on 26/07/2017.
 */


public class Content
{
    private String content;

    private String type;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", type = "+type+"]";
    }
}