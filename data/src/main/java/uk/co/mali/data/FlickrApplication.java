package uk.co.mali.data;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.mali.data.injector.component.AppComponent;
import uk.co.mali.data.injector.component.DaggerAppComponent;
import uk.co.mali.data.injector.module.AppModule;


/**
 * Created by alig2 on 29/07/2017.
 */

public class FlickrApplication extends Application {

     static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        initRealm();

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();

    }

    private void initRealm() {
        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
    }

    public static AppComponent getAppComponent(){
        return appComponent;

    }
}
