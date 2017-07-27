package uk.co.mali.data.model.pojos.xml;

/**
 * Created by alig2 on 26/07/2017.
 */

public class Category
{
    private String scheme;

    private String term;

    public String getScheme ()
    {
        return scheme;
    }

    public void setScheme (String scheme)
    {
        this.scheme = scheme;
    }

    public String getTerm ()
    {
        return term;
    }

    public void setTerm (String term)
    {
        this.term = term;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [scheme = "+scheme+", term = "+term+"]";
    }
}

