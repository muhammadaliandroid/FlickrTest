package uk.co.mali.data.injector.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alig2 on 09/08/2017.
 */


@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context){
        this.context = context;

    }

    @Singleton
    @Provides
    Context provideAppContext(){
        return context;
    }
}
