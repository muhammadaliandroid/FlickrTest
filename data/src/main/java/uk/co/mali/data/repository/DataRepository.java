package uk.co.mali.data.repository;

import android.util.Log;

import co.mali.domain.entity.json.DataEntity;
import co.mali.domain.repository.IDataRespository;
import rx.Observable;
import rx.functions.Func1;
import uk.co.mali.data.cache.FlickrCache;
import uk.co.mali.data.mapper.Data2EntityMapper;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.net.NetGenerator;
import uk.co.mali.data.repository.datasource.FlickrCloudDataStore;
import uk.co.mali.data.repository.datasource.FlickrLocalDataStore;
import uk.co.mali.data.repository.datasource.IFlickrDataStore;
import uk.co.mali.data.restservice.restapi.RestApi;

/**
 * Created by alig2 on 27/07/2017.
 */

public class DataRepository implements IDataRespository{

    private static final String TAG = DataRepository.class.getSimpleName();

    NetGenerator generator = NetGenerator.getGenerator();
    RestApi api;




    public Observable<DataEntity> getFlickrItems(String tag){

        Log.d(TAG, "getFlickrItems called: "+tag);
        //api= generator.getRestService();


        //FlickrCloudDataStore dataStore = new FlickrCloudDataStore(new FlickrCache());


        //Observable<DataRealm> data = api.getRestApiData(tag);

        IFlickrDataStore dataStore;

        if(checkCacheExpired(new FlickrCache())){
           dataStore =  new FlickrLocalDataStore(new FlickrCache());

        }

        else {
           dataStore = new FlickrCloudDataStore(new FlickrCache());

        }

        Observable<Data> data = dataStore.getObservableDataFromSource(tag);

        Observable<DataEntity> dataEntity = data.map(new Func1<Data, DataEntity>() {
            @Override
            public DataEntity call(Data data) {
                return Data2EntityMapper.getEntityMapper().getDataEntity(data);
            }
        });


        if(dataEntity!=null) {
            Log.d(TAG, "getFlickrItems called: dataEntity not null: ");

        }
        return dataEntity;

    }

    private boolean checkCacheExpired(FlickrCache cache){

        if(!cache.isExpired() && (cache.isCached())){
            return true;
        }
        else
        {
            return false;
        }

    }
}
