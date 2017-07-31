package uk.co.mali.flickrtest.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import co.mali.domain.entity.json.DataEntity;
import co.mali.domain.entity.json.ItemEntity;
import uk.co.mali.flickrtest.R;
import uk.co.mali.flickrtest.presenter.Presenter;
import uk.co.mali.flickrtest.view.IFlickrView;
import uk.co.mali.flickrtest.view.adapter.FlickrRecyclerAdapter;


/**
 * Created by alig2 on 26/07/2017.
 */

public class FlickrListActivity extends BaseActivity implements IFlickrView{



    private final static String TAG = FlickrListActivity.class.getSimpleName();

    RecyclerView Flickr_List;
    private Presenter presenter;
    String tag;


    @BindView(R.id.rv_ListFlickrImages)
    RecyclerView recyclerView;
    @BindView(R.id.et_Search)
    EditText etSearch;
    @BindView(R.id.btn_Search)
    Button btnSearch;

    FlickrRecyclerAdapter adapter;


    List<ItemEntity> Item_List = new ArrayList<>();

    public FlickrListActivity(){

    }


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

            Item_List = dataEntity.getItemEntities();

    }

    @OnClick(R.id.btn_Search)
    public void submit(View view) {
        presenter.initialize();

        if (tag != null) {
            tag = null;
        }
        tag = String.valueOf(etSearch.getText());
        presenter.setTag(tag);
        adapter = new FlickrRecyclerAdapter(context());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context()));
        adapter.swapAdapter(Item_List);


       }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void startFlickrImageActivity(ItemEntity itemEntity) {

        Log.d(TAG,"Start FlickrImageActivity" +itemEntity.getAuthor());

        FlickrImage flickrImage = new FlickrImage();
        flickrImage.setTitle(itemEntity.getTitle());
        flickrImage.setImageURL(itemEntity.getMediaEntity().getM());
        flickrImage.setAuthor(itemEntity.getAuthor());

        Intent intent = new Intent(this, FlickrImageActivity.class);
        intent.putExtra("flickrImage", flickrImage);
        startActivity(intent);
    }
}




