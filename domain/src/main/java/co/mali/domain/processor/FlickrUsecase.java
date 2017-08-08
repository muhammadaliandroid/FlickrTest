package co.mali.domain.processor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import co.mali.domain.repository.IDataRespository;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alig2 on 27/07/2017.
 */

public class FlickrUsecase{


    private static final String TAG = FlickrUsecase.class.getSimpleName();

    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);

    private IDataRespository respository;

 //   AppListener listener;

    Scheduler scheduler;

    public FlickrUsecase(Scheduler scheduler, IDataRespository respository){
        this.respository = respository;
        this.scheduler = scheduler;
    }



    public void getItemEntityFromObservable(String tag, DisposableObserver observer) {

        respository.getFlickrItems(tag)
                .subscribeOn(internetScheduler)
                .observeOn(scheduler)
                .subscribe(observer);



    }

}