package uk.co.mali.flickrtest.dagger.component;

import android.content.Context;

import dagger.Component;
import uk.co.mali.flickrtest.dagger.module.AppModule;
import uk.co.mali.flickrtest.dagger.module.NetModule;
import uk.co.mali.flickrtest.dagger.module.RestApiServiceModule;
import uk.co.mali.flickrtest.dagger.module.RxModule;
import uk.co.mali.flickrtest.dagger.scope.AppScope;
import uk.co.mali.flickrtest.util.rxutils.IRxSchedulers;

/**
 * Created by alig2 on 27/07/2017.
 */


@AppScope
@Component(modules = {AppModule.class,NetModule.class, RxModule.class, RestApiServiceModule.class})
public interface AppComponent {

    Context getAppContext();
    IRxSchedulers iRxSchedulers();
//    RestApi apiService();
}

