package uk.co.mali.data.mapper;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.mali.domain.entity.json.DataEntity;
import co.mali.domain.entity.json.ItemEntity;
import co.mali.domain.entity.json.MediaEntity;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.json.Item;
import uk.co.mali.data.model.pojos.json.Media;

/**
 * Created by alig2 on 27/07/2017.
 */

public class Data2EntityMapper {


    private static final String TAG = "DATA to ENTITY";
    DataEntity dataEntity;
    List<ItemEntity> itemListEntity;
    MediaEntity mediaEntity;
    ItemEntity itemEntity;


    static Data2EntityMapper entityMapper = new Data2EntityMapper();
    private Data2EntityMapper(){
        Log.d(TAG,"Constructor");

    }

    public static Data2EntityMapper getEntityMapper() {
        return entityMapper;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public DataEntity getDataEntity(Data data){
        if(data!=null){
            Log.d(TAG, "getDataEntity(): Data is not Null Called: "+data.getTitle());

            dataEntity = new DataEntity();
            dataEntity.setDescription(data.getDescription());
            dataEntity.setGenerator(data.getGenerator());
            dataEntity.setItemEntities(getItemListEntity(data.getItems()));
            dataEntity.setTitle(data.getTitle());
            Log.d(TAG, "getDataEntity(): Databinding : dataEntity: "+dataEntity.getTitle());
            }
            else{
            Log.d(TAG, "getDataEntity(): Data is Null Called : title: ");

        }

        Log.d(TAG, "getDataEntity(): Databinding : dataEntity: "+dataEntity.getTitle());

        return dataEntity;
    }


    public List<ItemEntity> getItemListEntity(List<Item> itemList){
        if(itemList!=null){
             itemListEntity = new ArrayList<>();

            Log.d(TAG, "getItemListEntity(): Itemlist is not Null Called: ");

            for(int i=0; i<itemList.size();i++){
                itemListEntity.add(i,getItemEntity(itemList.get(i)));
       }
            Log.d(TAG, "getItemListEntity(): ItemlistEntity Size: "+itemListEntity.size());

        }
        return itemListEntity;
    }

    ItemEntity getItemEntity(Item item) {

        if(item!=null) {

            itemEntity = new ItemEntity();

            itemEntity.setDescription(item.getDescription());
            itemEntity.setAuthorId(item.getAuthorId());
            itemEntity.setAuthor(item.getAuthor());
            itemEntity.setTitle(item.getTitle());
            itemEntity.setPublished(item.getPublished());
            itemEntity.setDateTaken(item.getDateTaken());
            itemEntity.setMediaEntity(getMediaEntity(item.getMedia()));
            itemEntity.setLink(item.getLink());
            itemEntity.setTags(item.getTags());


        }
        Log.d(TAG, "getItemListEntity(): ItemEntity: "+itemEntity.toString());

        return itemEntity;
    }



  public MediaEntity getMediaEntity(Media media){
      if(media!=null){

          Log.d(TAG, "getItemListEntity(): Media is not Null Called: ");
          mediaEntity= new MediaEntity();
          mediaEntity.setM(media.getM());

      }
      return mediaEntity;
  }



}
