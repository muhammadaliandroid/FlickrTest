package uk.co.mali.data.mapper;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.json.Item;
import uk.co.mali.data.model.pojos.json.Media;
import uk.co.mali.data.model.pojos.realmobjects.DataRealm;
import uk.co.mali.data.model.pojos.realmobjects.ItemRealm;
import uk.co.mali.data.model.pojos.realmobjects.MediaRealm;

/**
 * Created by alig2 on 30/07/2017.
 */

public class DataRealm2DataMapper {

    private static final String TAG = "REALM TO DATA";
    Data data;
    List<Item> itemList;
    Media media;
    ItemRealm itemRealm;
    Item item;


    static DataRealm2DataMapper dataMapper = new DataRealm2DataMapper();
    private DataRealm2DataMapper(){

        Log.d(TAG,"Constructor");
    }

    public static DataRealm2DataMapper getRealmMapper() {
        return dataMapper;
    }

    public Data getdataRealm(DataRealm dataRealm){
        if(dataRealm!=null){
            Log.d(TAG, "getdataRealm(): DataRealm is not Null Called: "+dataRealm.getTitle());

            data= new Data();
            data.setDescription(dataRealm.getDescription());
            data.setGenerator(dataRealm.getGenerator());
            data.setItems(getItemList(dataRealm.getItemRealms()));

            //        dataRealm.setItemRealms(getItemListRealm(data.getItems()));
            data.setTitle(dataRealm.getTitle());
            Log.d(TAG, "getdataRealm(): Databinding : dataRealm: "+dataRealm.getTitle());
        }
        else{


        }


        return data;
    }


    public List<Item> getItemList(RealmList<ItemRealm> itemListRealm){
        if(itemListRealm!=null){
            itemList= new ArrayList<>();

            for(int i=0; i<itemListRealm.size();i++){
                itemList.add(i,getItem(itemListRealm.get(i)));
            }
            Log.d(TAG, "getItemList Itemlist Size: "+itemList.size());

        }
        return itemList;
    }

    Item getItem(ItemRealm itemRealm) {

        if(itemRealm!=null) {

            item = new Item();

            item.setDescription(itemRealm.getDescription());
            item.setAuthorId(itemRealm.getAuthorId());
            item.setAuthor(itemRealm.getAuthor());
            item.setTitle(itemRealm.getTitle());
            item.setPublished(itemRealm.getPublished());
            item.setDateTaken(itemRealm.getDateTaken());
            item.setMedia(getMedia(itemRealm.getMedia()));
            item.setLink(itemRealm.getLink());
            item.setTags(itemRealm.getTags());


        }

        return item;
    }



    public Media getMedia(MediaRealm mediaRealm){
        if(mediaRealm!=null){
            Log.d(TAG, "getItemListRealm(): MediaRealm is not Null Called: ");
            media= new Media();
      //      String decryptString = KeyGeneratorService.getService().decrypttMessage(mediaRealm.getM());
        //    Log.d(TAG,"Decrypt String: "+decryptString);
            media.setM(mediaRealm.getM());
        }
        return media;
    }


}
