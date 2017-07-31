package uk.co.mali.flickrtest.view.activity;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import uk.co.mali.flickrtest.R;

/**
 * Created by alig2 on 30/07/2017.
 */

public class FlickrImageActivity extends BaseActivity {
    private final static String TAG = FlickrImageActivity.class.getSimpleName();


    @BindView(R.id.tv_ImageTitle)
    TextView title;
    @BindView(R.id.tv_ImageAuthor)
    TextView author;
    @BindView(R.id.iv_FlickrImage)
    ImageView image;

    public FlickrImageActivity(){

    }

    @Override
    public int getContentLayout() {
       return R.layout.activity_image;
    }

    @Override
    public void initComponents() {

        Log.d(TAG, "initComponent called");
        FlickrImage flickrImage = (FlickrImage) getIntent().getExtras().get("flickrImage");
        Log.d(TAG,"initComponent: flickrImage: "+flickrImage.toString());
        title.setText(flickrImage.getTitle());
        author.setText(flickrImage.getAuthor());
        Glide.with(this).load(flickrImage.getImageURL()).into(image);

    }
}
