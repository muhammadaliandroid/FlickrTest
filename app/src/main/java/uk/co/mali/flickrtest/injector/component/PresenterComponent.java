package uk.co.mali.flickrtest.injector.component;

import dagger.Component;
import uk.co.mali.data.injector.component.AppComponent;
import uk.co.mali.data.injector.scope.AppScope;
import uk.co.mali.flickrtest.injector.module.PresenterModule;
import uk.co.mali.flickrtest.presenter.Presenter;
import uk.co.mali.flickrtest.view.activity.FlickrListActivity;

/**
 * Created by alig2 on 09/08/2017.
 */

@AppScope
@Component(dependencies = {AppComponent.class}, modules = {PresenterModule.class})
public interface PresenterComponent {

    void inject(FlickrListActivity activity);
    Presenter presenter();

}
