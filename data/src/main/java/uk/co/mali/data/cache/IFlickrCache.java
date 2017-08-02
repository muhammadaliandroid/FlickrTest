package uk.co.mali.data.cache;

import io.reactivex.Observable;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.realmobjects.DataRealm;

/**
 * Created by alig2 on 30/07/2017.
 */

public interface IFlickrCache {

    boolean isExpired();
    boolean isCached();
    Observable<Data> get();
    void put(DataRealm flickrDataRealm);


}
