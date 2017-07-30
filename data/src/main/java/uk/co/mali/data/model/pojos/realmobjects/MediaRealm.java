
package uk.co.mali.data.model.pojos.realmobjects; import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

;

public class MediaRealm extends RealmObject {

    @SerializedName("m")
    @Expose
    @PrimaryKey
    private String m;

    public MediaRealm(){

    }

    public MediaRealm(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

}
