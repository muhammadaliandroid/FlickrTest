package uk.co.mali.data.injector.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.mali.data.injector.module.AppModule;

/**
 * Created by alig2 on 09/08/2017.
 */


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getAppContext();

}