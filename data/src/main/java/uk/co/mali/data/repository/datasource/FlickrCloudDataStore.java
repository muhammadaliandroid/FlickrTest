package uk.co.mali.data.repository.datasource;


import rx.Observable;
import rx.functions.Action1;
import uk.co.mali.data.cache.IFlickrCache;
import uk.co.mali.data.mapper.Data2DataRealmMapper;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.realmobjects.DataRealm;
import uk.co.mali.data.net.NetGenerator;
import uk.co.mali.data.restservice.restapi.RestApi;

/**
 * Created by alig2 on 30/07/2017.
 */

public class FlickrCloudDataStore implements IFlickrDataStore {


    private IFlickrCache cache;

    public FlickrCloudDataStore(IFlickrCache cache){
        this.cache = cache;
    }


    @Override
    public Observable<Data> getObservableDataFromSource(String tag) {

        RestApi service = NetGenerator.getGenerator().getRestService();

        Observable dataObservable = service.getRestApiData(tag);

        dataObservable.doOnNext(new Action1<Data>() {
            @Override
            public void call(Data data) {
                DataRealm dataRealm = Data2DataRealmMapper.getRealmMapper().getdataRealm(data);
                cache.put(dataRealm);
            }
        });

        return dataObservable;
    }



}
