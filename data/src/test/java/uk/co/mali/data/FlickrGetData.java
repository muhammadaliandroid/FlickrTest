package uk.co.mali.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.mali.domain.processor.FlickrUsecase;
import co.mali.domain.repository.IDataRespository;

/**
 * Created by alig2 on 02/08/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class FlickrGetData {


    @Mock
    private IDataRespository respository;

    private FlickrUsecase usecase;



    @Before public void setup(){
        usecase = new FlickrUsecase(FlickrUsecase.internetScheduler,respository);
    }


    @Test
    public void testRepositoryMock(){

      Mockito.verifyNoMoreInteractions(respository);
      Assert.assertTrue(String.valueOf(respository.getFlickrItems("Spain")), true);


    }


}
