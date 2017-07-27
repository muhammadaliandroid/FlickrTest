package uk.co.mali.data.mapper;

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
    DataEntity dataEntity;
    List<ItemEntity> itemListEntity = new ArrayList<>();
    MediaEntity mediaEntity;

    static Data2EntityMapper entityMapper = new Data2EntityMapper();
    private Data2EntityMapper(){

    }

    public static Data2EntityMapper getEntityMapper() {
        return entityMapper;
    }

    public DataEntity getDataEntity(Data data){
        if(data!=null){
            dataEntity = new DataEntity();
            dataEntity.setDescription(data.getDescription());
            dataEntity.setGenerator(data.getGenerator());
            dataEntity.setItemEntities(getItemListEntity(data.getItems()));
            dataEntity.setTitle(data.getTitle());

            }
            return dataEntity;
    }


    public List<ItemEntity> getItemListEntity(List<Item> itemList){
        if(itemList!=null){

            for(int i=0; i<itemList.size();i++){
                itemListEntity.get(i).setDescription(itemList.get(i).getDescription());
                itemListEntity.get(i).setAuthorId(itemList.get(i).getAuthorId());
                itemListEntity.get(i).setAuthor(itemList.get(i).getAuthor());
                itemListEntity.get(i).setLink(itemList.get(i).getLink());

                itemListEntity.get(i).setMediaEntity(getMediaEntity(itemList.get(i).getMedia()));

                itemListEntity.get(i).setDateTaken(itemList.get(i).getDateTaken());
                itemListEntity.get(i).setTags(itemList.get(i).getTags());
                itemListEntity.get(i).setTitle(itemList.get(i).getTitle());
                itemListEntity.get(i).setPublished(itemList.get(i).getPublished());

            }

            }
        return itemListEntity;
    }


  public MediaEntity getMediaEntity(Media media){
      if(media!=null){
          mediaEntity= new MediaEntity();
          mediaEntity.setM(media.getM());
      }
      return mediaEntity;
  }



}
