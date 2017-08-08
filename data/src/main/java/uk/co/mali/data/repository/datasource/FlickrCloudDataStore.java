package uk.co.mali.data.repository.datasource;


import android.util.Log;

import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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

        Observable<Data> dataObservable = service.getRestApiData(tag);
       // Observer<Data> dataObserver = getObserver();
       // dataObservable.subscribe(dataObserver);

        dataObservable
                .observeOn(Schedulers.from(Executors.newCachedThreadPool()))
                .map(new Function<Data, Boolean>() {
                    @Override
                    public Boolean apply(Data data) throws Exception {

                        DataRealm dataRealm = Data2DataRealmMapper.getRealmMapper().getdataRealm(data);
                        Log.d("Consumer Accept", "Realm Data from Consumer : "+dataRealm.getTitle());
                        cache.put(dataRealm);

                        return true ;
                    }
                });

/*
        dataObservable.subscribeWith(new Observer<Data>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Data data) {
                DataRealm dataRealm = Data2DataRealmMapper.getRealmMapper().getdataRealm(data);
                Log.d("Consumer Accept", "Realm Data from Consumer : "+dataRealm.getTitle());
                cache.put(dataRealm);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }


        });
*/
        return dataObservable;
    }


    public Observer<Data> getObserver(){
        return new Observer<Data>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Data data) {
                DataRealm dataRealm = Data2DataRealmMapper.getRealmMapper().getdataRealm(data);
                Log.d("Dat", "Realm Data from Consumer : "+dataRealm.getTitle());
                cache.put(dataRealm);

            }

            @Override
            public void onError(Throwable e) {

                Log.e("Error Cache",e.getMessage());

            }

            @Override
            public void onComplete() {

                Log.d("Complete Cache","completed");
            }
        };
    }


}

