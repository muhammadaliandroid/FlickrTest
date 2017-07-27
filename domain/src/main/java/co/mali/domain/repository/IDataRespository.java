package co.mali.domain.repository;


import co.mali.domain.entity.json.DataEntity;
import rx.Observable;

/**
 * Created by alig2 on 27/07/2017.
 */

public interface IDataRespository {

    public Observable<DataEntity> getFlickrItems(String tag);

}
