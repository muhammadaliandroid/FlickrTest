package uk.co.mali.flickrtest.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mali.domain.entity.json.ItemEntity;
import rx.subjects.PublishSubject;
import uk.co.mali.flickrtest.R;

/**
 * Created by alig2 on 28/07/2017.
 */


class FlickrListViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.iv_Image)
    ImageView image;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_Author)
    TextView tvAuthor;
    @BindView(R.id.tv_Description)
    TextView tvDescription;
    @BindView(R.id.tv_DatePublish)
    TextView tvPublishDate;
    @BindView(R.id.view_ImageSeperator)
    View viewImageSeperator;


    public FlickrListViewHolder(View itemView, PublishSubject<Integer> clickSubject){
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this,view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }


    void bind(ItemEntity itemEntity){
        Glide.with(view.getContext()).load(itemEntity.getLink().toString()).into(image);

        tvTitle.setText(itemEntity.getTitle());
        tvAuthor.setText("Author: "+ itemEntity.getAuthor());
        tvDescription.setText(itemEntity.getDescription());
        tvPublishDate.setText("Dated: "+itemEntity.getDateTaken());
        viewImageSeperator.setBackgroundColor(Color.LTGRAY);
    }
}