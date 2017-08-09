package uk.co.mali.data.cache;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Date;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import uk.co.mali.data.mapper.DataRealm2DataMapper;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.realmobjects.DataRealm;

/**
 * Created by alig2 on 30/07/2017.
 */

public class FlickrCache implements IFlickrCache {

    private static final long EXPIRATION_TIME = 6000;

    @Override
    public boolean isExpired() {
        Realm realm = Realm.getDefaultInstance();
        if (realm.where(DataRealm.class).count() != 0) {
            Date currentTime = new Date(System.currentTimeMillis());
           //SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
            Date lastUpdated = null;
            long count = 0;
            boolean isExpired = false;
            try {
                count = (int) realm.where(DataRealm.class).count();
                if(count>0) {
                    lastUpdated = realm.where(DataRealm.class).findFirst().getCreateTime();
                   // lastUpdated = ISO8601DATEFORMAT.parse(timeRealm);
                    isExpired = currentTime.getTime() - lastUpdated.getTime() > EXPIRATION_TIME;
                    Log.d("CACHE", "isExpired: "+isExpired);
                }

                if(isExpired){
                    realm.beginTransaction();
                    realm.delete(DataRealm.class);
                    realm.commitTransaction();
                    realm.close();
                }
                return isExpired;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    @Override
    public boolean isCached() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DataRealm.class).findAll()!=null
                && realm.where(DataRealm.class).findAll().size()>0;
        }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Observable<Data> get() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DataRealm> dataList = realm.where(DataRealm.class).findAll();
        DataRealm dataObject = dataList.get(0);
        Data data = DataRealm2DataMapper.getRealmMapper().getdataRealm(dataObject);
        return Observable.just(data);
    }

    @Override
    public void put(DataRealm flickrDataRealm){
        Log.d("CACHE","Realm Data");
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Date createDate = new Date(System.currentTimeMillis());
        flickrDataRealm.setCreateTime(createDate);
        realm.copyToRealmOrUpdate(flickrDataRealm);
        realm.commitTransaction();
        realm.close();
    }
}
