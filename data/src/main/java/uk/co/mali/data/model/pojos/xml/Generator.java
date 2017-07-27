package uk.co.mali.data.model.pojos.xml;

/**
 * Created by alig2 on 26/07/2017.
 */

public class Generator
{
    private String content;

    private String uri;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getUri ()
    {
        return uri;
    }

    public void setUri (String uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Content = "+content+", uri = "+uri+"]";
    }
}
