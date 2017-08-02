package uk.co.mali.data.datasource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.mali.data.cache.IFlickrCache;
import uk.co.mali.data.repository.datasource.FlickrCloudDataStore;

/**
 * Created by alig2 on 02/08/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class CloudDatastoreTest {

    @Mock
    private IFlickrCache cache;

    private FlickrCloudDataStore cloudDataStore;

    @Before
    public void setup(){
        cloudDataStore = new FlickrCloudDataStore(cache);

    }

    @Test
    public void testDataLocalCacheFlickr(){
        cloudDataStore.getObservableDataFromSource("Spain");

    }


}
