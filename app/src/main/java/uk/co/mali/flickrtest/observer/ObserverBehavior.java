package uk.co.mali.flickrtest.observer;

import io.reactivex.observers.DisposableObserver;
import uk.co.mali.data.model.pojos.json.Data;

/**
 * Created by alig2 on 08/08/2017.
 */

public class ObserverBehavior extends DisposableObserver<Data> {

    @Override
    public void onNext(Data data) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
