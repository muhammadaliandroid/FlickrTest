package uk.co.mali.flickrtest.view;

import android.app.Application;

import uk.co.mali.flickrtest.dagger.component.AppComponent;

/**
 * Created by alig2 on 27/07/2017.
 */

public class App extends Application {

    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();

    }


    private void initAppComponent() {
      //  appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getNetComponent(){
        return appComponent;

    }


}
