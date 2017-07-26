package uk.co.mali.flickrtest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uk.co.mali.flickrtest.domain.constants.Constants;
import uk.co.mali.flickrtest.domain.restapi.RestApi;
import uk.co.mali.flickrtest.model.pojos.json.Data;

/**
 * Created by alig2 on 26/07/2017.
 */

public class RestTestActivity extends AppCompatActivity {

    private final static String TAG = RestTestActivity.class.getSimpleName();

    Subscription subscription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = getRetrofit();
        RestApi service=  retrofit.create(RestApi.class);


        Observable<Data> observable = service.getRestApiData("Spain");

        subscription= observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Data>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG,"onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Error "+e.getMessage());

                    }

                    @Override
                    public void onNext(Data data) {

                        Log.d(TAG, "Record: Size: "+data.getItems().size()+" Items : "+data.getItems().get(0).getTitle());

                    }
                });


    }


    Retrofit getRetrofit() {

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