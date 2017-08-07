package uk.co.mali.data.mapper;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import uk.co.mali.data.model.pojos.json.Data;
import uk.co.mali.data.model.pojos.json.Item;
import uk.co.mali.data.model.pojos.json.Media;
import uk.co.mali.data.model.pojos.realmobjects.DataRealm;
import uk.co.mali.data.model.pojos.realmobjects.ItemRealm;
import uk.co.mali.data.model.pojos.realmobjects.MediaRealm;
import uk.co.mali.data.util.KeyGeneratorService;

/**
 * Created by alig2 on 30/07/2017.
 */

public class DataRealm2DataMapper {

    private static final String TAG = DataRealm2DataMapper.class.getSimpleName();
    Data data;
    List<Item> itemList;
    Media media;
    ItemRealm itemRealm;
    Item item;


    static DataRealm2DataMapper dataMapper = new DataRealm2DataMapper();
    private DataRealm2DataMapper(){

    }

    public static DataRealm2DataMapper getRealmMapper() {
        return dataMapper;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Data getdataRealm(DataRealm dataRealm){
        if(data!=null){
            Log.d(TAG, "getdataRealm(): DataRealm is not Null Called: "+data.getTitle());

            data= new Data();
            data.setDescription(dataRealm.getDescription());
            data.setGenerator(dataRealm.getGenerator());
            data.setItems((List)getItemList(dataRealm.getItemRealms()));

            //        dataRealm.setItemRealms(getItemListRealm(data.getItems()));
            data.setTitle(dataRealm.getTitle());
            Log.d(TAG, "getdataRealm(): Databinding : dataRealm: "+data.getTitle());
        }
        else{
            Log.d(TAG, "getdataRealm(): Data is Null Called : title: ");

        }

        Log.d(TAG, "getdataRealm(): Databinding : dataRealm: "+data.getTitle());

        return data;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public List<ItemRealm> getItemList(List<ItemRealm> itemListRealm){
        if(itemList!=null){
            itemList= new ArrayList<>();

            Log.d(TAG, "getItemList(): Itemlist is not Null Called: ");

            for(int i=0; i<itemList.size();i++){
                itemList.add(i,getItem(itemListRealm.get(i)));
            }
            Log.d(TAG, "getItemList Itemlist Size: "+itemList.size());

        }
        return itemListRealm;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
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
        Log.d(TAG, "getItemListRealm(): ItemRealm: "+item.toString());

        return item;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    public Media getMedia(MediaRealm mediaRealm){
        if(media!=null){
            Log.d(TAG, "getItemListRealm(): MediaRealm is not Null Called: ");
            media= new Media();
            String decryptString = KeyGeneratorService.getService().decrypttMessage(mediaRealm.getM());
            Log.d(TAG,"Decrypt String: "+decryptString);
            media.setM(decryptString);
        }
        return media;
    }


}
