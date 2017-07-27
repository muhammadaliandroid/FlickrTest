package uk.co.mali.flickrtest.dagger.module;

import dagger.Module;

/**
 * Created by alig2 on 27/07/2017.
 */

@Module
public class RestApiServiceModule {

  /*  @AppScope
    @Provides
    RestApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter){
        Retrofit retrofit= new Retrofit.Builder()
                .client(client)
                .baseUrl(Constants.FLICKR_BASE_URL)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build();

        return retrofit.create(RestApi.class);
    }
*/
}
