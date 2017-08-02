package uk.co.mali.data.datasource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.mali.data.cache.IFlickrCache;
import uk.co.mali.data.repository.datasource.FlickrLocalDataStore;

/**
 * Created by alig2 on 02/08/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class LocalDatastoreTest {

    @Mock private IFlickrCache cache;

    private FlickrLocalDataStore flickrLocalDataStore;

    @Before
    public void setup(){
        flickrLocalDataStore = new FlickrLocalDataStore(cache);

    }

    @Test
    public void testDataLocalCacheFlickr(){
        flickrLocalDataStore.getObservableDataFromSource("Spain");
        Mockito.verify(cache).get();
    }


}
