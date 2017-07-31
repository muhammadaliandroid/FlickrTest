package uk.co.mali.flickrtest.view.activity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alig2 on 31/07/2017.
 */

public class FlickrImage implements Parcelable {

    private String title;
    private String imageURL;
    private String author;

    FlickrImage(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.imageURL);
        dest.writeString(this.author);
    }

    protected FlickrImage(Parcel in) {
        this.title = in.readString();
        this.imageURL = in.readString();
        this.author = in.readString();
    }

    public static final Parcelable.Creator<FlickrImage> CREATOR = new Parcelable.Creator<FlickrImage>() {
        @Override
        public FlickrImage createFromParcel(Parcel source) {
            return new FlickrImage(source);
        }

        @Override
        public FlickrImage[] newArray(int size) {
            return new FlickrImage[size];
        }
    };
}
