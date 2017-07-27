package uk.co.mali.flickrtest.dagger.module;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.flickrtest.util.rxutils.IRxSchedulers;
import uk.co.mali.flickrtest.util.rxutils.RxSchedulers;

/**
 * Created by alig2 on 27/07/2017.
 */

@Module
public class RxModule {
    @Provides
    IRxSchedulers provideIRxSchedulers(){
        return new RxSchedulers();
    }
}
