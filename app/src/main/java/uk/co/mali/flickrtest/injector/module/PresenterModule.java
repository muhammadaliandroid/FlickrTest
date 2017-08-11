package uk.co.mali.flickrtest.injector.module;

import dagger.Module;
import dagger.Provides;
import uk.co.mali.data.injector.scope.AppScope;
import uk.co.mali.flickrtest.presenter.Presenter;

/**
 * Created by alig2 on 09/08/2017.
 */


@Module
public class PresenterModule {

    @AppScope
    @Provides
    Presenter providePresenter(){
        return new Presenter();
    }

}
