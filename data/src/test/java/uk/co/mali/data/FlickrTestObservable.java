package uk.co.mali.data;

import org.junit.Test;

import io.reactivex.observers.TestObserver;
import io.reactivex.Observable;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.net.NetGenerator;

/**
 * Created by alig2 on 02/08/2017.
 */


public class FlickrTestObservable {

    @Test
    public void testRestApi(){

        NetGenerator generator = NetGenerator.getGenerator();
        Observable<Data> flickrDataObservable= generator.getRestService().getRestApiData("Spain");
        TestObserver<Object> testObserver = new TestObserver<>();
        flickrDataObservable.subscribeWith(testObserver);
        testObserver.assertSubscribed();
    }


}
