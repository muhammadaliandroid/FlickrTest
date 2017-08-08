package uk.co.mali.data.repository.datasource;


import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
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


    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);

    private IFlickrCache cache;

    private Scheduler scheduler1 = Schedulers.from(Executors.newCachedThreadPool());
    private Scheduler scheduler2 = Schedulers.newThread();

    public Data2DataRealmMapper mapper = Data2DataRealmMapper.getRealmMapper();
    public FlickrCloudDataStore(IFlickrCache cache){
        this.cache = cache;
    }


    @Override
    public Observable<Data> getObservableDataFromSource(String tag) {
        RestApi service = NetGenerator.getGenerator().getRestService();

        final Observable<Data> dataObservable = service.getRestApiData(tag);
        if(dataObservable!=null){
            doNext(dataObservable);
        }

        return dataObservable;
    }

    private void doNext(Observable<Data> dataObservable) {

       DisposableObserver<Data> do1 = new DisposableObserver<Data>() {
            @Override
            public void onNext(Data data) {
                Log.d("Function", "Apply Method Called: ");
                DataRealm dataRealm = mapper.getdataRealm(data);
                cache.put(dataRealm);

            }

            @Override
            public void onError(Throwable e) {

                Log.e("Error","E @ "+e.getLocalizedMessage()+"  Stack trace: "+e.getStackTrace());
            }

            @Override
            public void onComplete() {
                Log.d("Complete","Complete");
            }
        };

        dataObservable.subscribeOn(scheduler1)
        .observeOn(Schedulers.io())
        .subscribe(do1);




    }


}

