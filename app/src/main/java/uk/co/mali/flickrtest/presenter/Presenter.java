package uk.co.mali.flickrtest.presenter;

import android.util.Log;

import co.mali.domain.entity.json.DataEntity;
import co.mali.domain.processor.FlickrUsecase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import uk.co.mali.data.repository.DataRepository;
import uk.co.mali.flickrtest.view.IFlickrView;

/**
 * Created by alig2 on 28/07/2017.
 */

public class Presenter implements IPresenter {
    private final static String TAG = Presenter.class.getSimpleName();
    private IFlickrView iFlickrView;
    private FlickrUsecase usecase;
    private String searchByTag;



    //private ArrayList<ItemEntity> List_Items = new ArrayList<>();

    public Presenter(){

    }

    @Override
    public void onCreate() {


    }

    @Override
    public void onResume() {


    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        this.iFlickrView = null;

    }


    public void setFlickrView(IFlickrView iFlickrView){
        this.iFlickrView =  iFlickrView;
    }


    private void getFlickerList(){
        usecase = new FlickrUsecase(AndroidSchedulers.mainThread(), new DataRepository());
        usecase.getItemEntityFromObservable(getSearchByTag(), new DisposableObserver<DataEntity>(){

            @Override
            public void onNext(DataEntity dataEntity) {
                Log.d(TAG,"Entity DataRealm: "+dataEntity.getTitle());
                Log.d(TAG, "Record: Size: Link: "+dataEntity.getItemEntities().size()+" Items : "+dataEntity.getItemEntities().get(0).getLink());
                iFlickrView.showFlickrListInView(dataEntity);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void initialize(){
        this.getFlickerList();

    }


    public void setTag(String tag) {
        this.searchByTag = tag;
    }

    public String getSearchByTag() {
        return searchByTag;
    }
}
