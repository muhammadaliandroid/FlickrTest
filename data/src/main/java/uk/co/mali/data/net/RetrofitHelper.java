package uk.co.mali.data.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.data.restservice.constants.Constants;

/**
 * Created by alig2 on 27/07/2017.
 */

public class RetrofitHelper {

    private final static String TAG = RetrofitHelper.class.getSimpleName();

    static RetrofitHelper helper = new RetrofitHelper();
    private RetrofitHelper(){
    }

    static RetrofitHelper getHelper(){
        return helper;
    }

    Retrofit getRetrofit() {
        Log.d(TAG, "getRetrofit Called: ");
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(Constants.FLICKR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;

    }

}
