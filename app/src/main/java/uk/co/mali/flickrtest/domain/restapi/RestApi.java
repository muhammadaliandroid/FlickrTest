package uk.co.mali.flickrtest.domain.restapi;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import uk.co.mali.flickrtest.domain.constants.Constants;
import uk.co.mali.flickrtest.model.pojos.json.Data;

/**
 * Created by alig2 on 26/07/2017.
 */

public interface RestApi {

    @GET(Constants.FLICKER_URL_SEARCH_PICTURE_GALLERY_BY_TAG)
    Observable<Data> getRestApiData(@Query("tag") String tag);
    //Observable<Data> getRestApiData();

}
