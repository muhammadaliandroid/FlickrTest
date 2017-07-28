package uk.co.mali.flickrtest.view.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import co.mali.domain.entity.json.DataEntity;
import uk.co.mali.flickrtest.R;
import uk.co.mali.flickrtest.presenter.Presenter;
import uk.co.mali.flickrtest.view.IFlickrView;


/**
 * Created by alig2 on 26/07/2017.
 */

public class FlickrListActivity extends BaseActivity implements IFlickrView{

    private final static String TAG = FlickrListActivity.class.getSimpleName();

    RecyclerView Flickr_List;
    private Presenter presenter;


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initComponents() {

        presenter = new Presenter();
        presenter.setFlickrView(this);
        presenter.initialize();

    }


    @Override
    public Context context() {
        return this;
    }

    @Override
    public void showFlickrListInView(DataEntity dataEntity) {



    }


}




