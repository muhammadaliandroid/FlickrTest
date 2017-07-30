package uk.co.mali.data.repository.datasource;

import rx.Observable;
import uk.co.mali.data.cache.IFlickrCache;
import uk.co.mali.data.model.pojos.json.Data;

/**
 * Created by alig2 on 30/07/2017.
 */

public class FlickrLocalDataStore implements  IFlickrDataStore{

    private IFlickrCache cache;

    public FlickrLocalDataStore(IFlickrCache cache){
        this.cache = cache;
    }

    @Override
    public Observable<Data> getObservableDataFromSource(String tag) {

        return cache.get();
    }

}
