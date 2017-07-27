package uk.co.mali.flickrtest.dagger.module;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.flickrtest.dagger.scope.AppScope;
import uk.co.mali.flickrtest.util.rxutils.RxSchedulers;

/**
 * Created by alig2 on 27/07/2017.
 */

@Module
public class NetModule {
    @AppScope
    @Provides
    OkHttpClient provideHttpClient(HttpLoggingInterceptor logger, Cache cache){

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(logger);
        builder.cache(cache);
        return builder.build();

    }
    @AppScope
    @Provides
    HttpLoggingInterceptor provideInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @AppScope
    @Provides
    Cache provideCache(File file){
        return new Cache(file, 10 *10* 1024);
    }

    @AppScope
    @Provides
    File providesCacheFile(Context context){
        return context.getFilesDir();
    }

    @AppScope
    @Provides
    RxJavaCallAdapterFactory providesRxAdapter(){
        return RxJavaCallAdapterFactory.createWithScheduler(RxSchedulers.internetScheduler);
    }

    @Provides
    GsonConverterFactory provideGsonClient(){
        return GsonConverterFactory.create();
    }

}
