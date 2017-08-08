package uk.co.mali.data;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alig2 on 29/07/2017.
 */

public class FlickrApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration.
                Builder().
                build();
        Realm.setDefaultConfiguration(config);


    }

}
