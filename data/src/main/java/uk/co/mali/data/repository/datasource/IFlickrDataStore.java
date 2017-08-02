package uk.co.mali.data.repository.datasource;

import io.reactivex.Observable;
import uk.co.mali.data.model.pojos.json.Data;

/**
 * Created by alig2 on 30/07/2017.
 */

public interface IFlickrDataStore {

    public Observable<Data> getObservableDataFromSource(String tag);


}
