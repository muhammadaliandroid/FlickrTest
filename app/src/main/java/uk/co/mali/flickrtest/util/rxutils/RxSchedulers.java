package uk.co.mali.flickrtest.util.rxutils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alig2 on 27/07/2017.
 */

public class RxSchedulers implements IRxSchedulers{

    public static Executor backgroundExecutor = Executors.newCachedThreadPool();
    public static Scheduler backgroundScheduler = Schedulers.from(backgroundExecutor);
    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler internetScheduler = Schedulers.from(internetExecutor);



    @Override
    public Scheduler runOnBackground() {
        return backgroundScheduler;
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler compute() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler androidThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return internetScheduler;
    }

}
