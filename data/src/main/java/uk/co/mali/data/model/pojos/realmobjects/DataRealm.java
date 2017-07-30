
package uk.co.mali.data.model.pojos.realmobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class DataRealm extends RealmObject {



    @SerializedName("title")
    @Expose
    @PrimaryKey
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("generator")
    @Expose
    private String generator;
    @SerializedName("itemRealms")
    @Expose
    private RealmList<ItemRealm> itemRealms;

    public DataRealm(){

    }

    public DataRealm(String title, String link, String description, String modified, String generator, RealmList<ItemRealm> itemRealms) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.modified = modified;
        this.generator = generator;
        this.itemRealms = itemRealms;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public RealmList<ItemRealm> getItemRealms() {
        return itemRealms;
    }

    public void setItemRealms(RealmList<ItemRealm> itemRealms) {
        this.itemRealms = itemRealms;
    }
}
