
package uk.co.mali.data.model.pojos.realmobjects; import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

;import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ItemRealm extends RealmObject {

    @SerializedName("title")
    @Expose
    @PrimaryKey
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("media")
    @Expose
    private MediaRealm media;
    @SerializedName("date_taken")
    @Expose
    private String dateTaken;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("author_id")
    @Expose
    private String authorId;
    @SerializedName("tags")
    @Expose
    private String tags;

    public ItemRealm(){

    }

    public ItemRealm(String title, String link, MediaRealm media, String dateTaken, String description, String published, String author, String authorId, String tags) {
        this.title = title;
        this.link = link;
        this.media = media;
        this.dateTaken = dateTaken;
        this.description = description;
        this.published = published;
        this.author = author;
        this.authorId = authorId;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MediaRealm getMedia() {
        return media;
    }

    public void setMedia(MediaRealm media) {
        this.media = media;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
