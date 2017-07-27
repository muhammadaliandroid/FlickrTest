package uk.co.mali.data.net;

import retrofit2.Retrofit;
import rx.Subscription;
import uk.co.mali.data.restservice.restapi.RestApi;

/**
 * Created by alig2 on 27/07/2017.
 */

public class NetGenerator {

    private final static String TAG = NetGenerator.class.getSimpleName();

    static NetGenerator generator = new NetGenerator();

    private Subscription subscription;

    private NetGenerator(){

    }

    public static NetGenerator getGenerator() {
        return generator;
    }

    public RestApi getRestService(){

        Retrofit retrofit = RetrofitHelper.getHelper().getRetrofit();

        RestApi service=  retrofit.create(RestApi.class);

        return service;

    }
}
