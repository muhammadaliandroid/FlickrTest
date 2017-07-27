package uk.co.mali.flickrtest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import co.mali.domain.entity.json.DataEntity;
import co.mali.domain.processor.FlickrUsecase;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import uk.co.mali.data.repository.DataRepository;


/**
 * Created by alig2 on 26/07/2017.
 */

public class RestTestActivity extends AppCompatActivity{

    private final static String TAG = RestTestActivity.class.getSimpleName();

    Subscription subscription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlickrUsecase usecase = new FlickrUsecase(AndroidSchedulers.mainThread(), new DataRepository());
        usecase.getItemEntityFromObservable("Spain", new Subscriber<DataEntity>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error "+e.getMessage());
            }

            @Override
            public void onNext(DataEntity dataEntity) {
                Log.d(TAG,"Entity Data: "+dataEntity.getTitle());
                Log.d(TAG, "Record: Size: Link: "+dataEntity.getItemEntities().size()+" Items : "+dataEntity.getItemEntities().get(0).getLink());

            }
        });

  /*      Observable<Data> observable = service.getRestApiData("Spain");

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
                        Log.d(TAG, "Record: Size: Link: "+data.getItems().size()+" Items : "+data.getItems().get(0).getLink());
                    }
                });
                */


    }


}

