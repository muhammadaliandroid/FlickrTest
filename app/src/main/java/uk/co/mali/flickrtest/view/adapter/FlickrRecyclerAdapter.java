package uk.co.mali.flickrtest.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.mali.domain.entity.json.ItemEntity;
import rx.Observable;
import rx.subjects.PublishSubject;
import uk.co.mali.flickrtest.R;

/**
 * Created by alig2 on 28/07/2017.
 */

public class FlickrRecyclerAdapter extends RecyclerView.Adapter<FlickrListViewHolder> {

    public final static String TAG = FlickrRecyclerAdapter.class.getSimpleName();

    PublishSubject<Integer> itemClicks = PublishSubject.create();

    ArrayList<ItemEntity> List = new ArrayList<>();

    public void swapAdapter(List<ItemEntity> list) {
        Log.d(TAG, "Recycler Adapter: swapAdapter Called..: " + list.size());

        this.List.clear();
        this.List.addAll(list);
        notifyDataSetChanged();
        if (List== null) {
            Log.d(TAG, "List of Articles is Null");
        }
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }

    @Override
    public FlickrListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "OnCreateViewHolder called: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new FlickrListViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(FlickrListViewHolder holder, int position) {
        Log.d(TAG, "OnCreateViewHolder called: ");
        ItemEntity itemEntity = List.get(position);
        holder.bind(itemEntity);

    }

    @Override
    public int getItemCount() {
        if (List != null && List.size() > 0) {
            return List.size();
        } else {
            return 0;
        }
    }




}
