package uk.co.mali.data.repository;

import android.util.Log;

import co.mali.domain.entity.json.DataEntity;
import co.mali.domain.repository.IDataRespository;
import rx.Observable;
import rx.functions.Func1;
import uk.co.mali.data.mapper.Data2EntityMapper;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.net.NetGenerator;
import uk.co.mali.data.restservice.restapi.RestApi;

/**
 * Created by alig2 on 27/07/2017.
 */

public class DataRepository implements IDataRespository{

    private static final String TAG = DataRepository.class.getSimpleName();

    NetGenerator generator = NetGenerator.getGenerator();
    RestApi api;




    public Observable<DataEntity> getFlickrItems(String tag){

        Log.d(TAG, tag);
        api= generator.getRestService();
        Observable<Data> data = api.getRestApiData(tag);





        Observable<DataEntity> dataEntity = data.map(new Func1<Data, DataEntity>() {
            @Override
            public DataEntity call(Data data) {
                return Data2EntityMapper.getEntityMapper().getDataEntity(data);
            }
        });


       return dataEntity;

    }
}
