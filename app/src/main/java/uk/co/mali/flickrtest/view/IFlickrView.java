package uk.co.mali.flickrtest.view;

import android.content.Context;

import co.mali.domain.entity.json.DataEntity;

/**
 * Created by alig2 on 28/07/2017.
 */

public interface IFlickrView {

    public Context context();
    public void showFlickrListInView(DataEntity dataEntity);



}
