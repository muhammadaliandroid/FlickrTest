package uk.co.mali.data.cache;


import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;
import io.reactivex.Observable;
import uk.co.mali.data.mapper.DataRealm2DataMapper;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.realmobjects.DataRealm;

/**
 * Created by alig2 on 30/07/2017.
 */

public class FlickrCache implements IFlickrCache {

    private static final long EXPIRATION_TIME = 60000;

    @Override
    public boolean isExpired() {
        Realm realm = Realm.getDefaultInstance();
        if (realm.where(DataRealm.class).count() != 0) {
            Date currentTime = new Date(System.currentTimeMillis());
            SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
            Date lastUpdated = null;
            try {
                lastUpdated = ISO8601DATEFORMAT.parse(realm.where(DataRealm.class).findFirst().getModified());
                boolean isExpired = currentTime.getTime() - lastUpdated.getTime() > EXPIRATION_TIME;
                if(isExpired){
                    realm.beginTransaction();
                    realm.delete(DataRealm.class);
                    realm.commitTransaction();
                    realm.close();
                }
                return isExpired;
            } catch (ParseException e) {
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

    @Override
    public Observable<Data> get() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DataRealm> dataList = realm.where(DataRealm.class).findAll();
        DataRealm dataObject = dataList.get(0);
        Data data = DataRealm2DataMapper.getRealmMapper().getdataRealm(dataObject);
        return Observable.just(data);
    }

    @Override
    public void put(DataRealm flickrDataRealm) {
        Log.d("CACHE","Realm Data");
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(flickrDataRealm);
        realm.commitTransaction();
        realm.close();
    }
}
