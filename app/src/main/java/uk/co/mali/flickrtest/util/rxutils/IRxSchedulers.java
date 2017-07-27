package uk.co.mali.flickrtest.util.rxutils;

import rx.Scheduler;

/**
 * Created by alig2 on 27/07/2017.
 */

public interface IRxSchedulers {

    Scheduler runOnBackground();
    Scheduler io();
    Scheduler compute();
    Scheduler androidThread();
    Scheduler internet();

}
