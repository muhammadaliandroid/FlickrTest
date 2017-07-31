package uk.co.mali.flickrtest.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mali.domain.entity.json.ItemEntity;
import uk.co.mali.flickrtest.R;

/**
 * Created by alig2 on 28/07/2017.
 */


class FlickrListViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

    private static final String TAG = FlickrListViewHolder.class.getSimpleName();
    View view;

    @BindView(R.id.iv_Image)
    ImageView image;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_Author)
    TextView tvAuthor;
    @BindView(R.id.tv_DateTaken)
    TextView tvDateTaken;
    @BindView(R.id.tv_DatePublish)
    TextView tvPublishDate;

    private OnListItemClicked onListItemClicked;


    public FlickrListViewHolder(View itemView){
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this,view);
        view.setOnClickListener(this);


    }


    void bind(ItemEntity itemEntity){

        Log.d(TAG,"ItemRealm link: "+itemEntity.getLink());
        Log.d(TAG,"ItemRealm Title: "+itemEntity.getTitle());

        String title = "Author: "+ itemEntity.getAuthor();
        String dateTaken = "Date Taken: "+itemEntity.getDateTaken();
        String datePublish = "Date Published: "+itemEntity.getPublished();

        Glide.with(view.getContext()).load(itemEntity.getMediaEntity().getM().toString()).into(image);
        tvTitle.setText(itemEntity.getTitle());
        tvAuthor.setText(title);
        tvDateTaken.setText(dateTaken);
        tvPublishDate.setText(datePublish);

    }


    public void setOnListItemClicked(OnListItemClicked onListItemClicked) {
        this.onListItemClicked = onListItemClicked;
    }

    @Override
    public void onClick(View v) {
        onListItemClicked.onListItemClicked(v, getAdapterPosition());
    }

}