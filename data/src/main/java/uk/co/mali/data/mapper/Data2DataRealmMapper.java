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

public class Data2DataRealmMapper {

    private static final String TAG = "DATA to REALM";

    DataRealm dataRealm;
    List<ItemRealm> itemListRealm;
    MediaRealm mediaRealm;
    ItemRealm itemRealm;


    static Data2DataRealmMapper realmMapper = new Data2DataRealmMapper();
    private Data2DataRealmMapper(){
        Log.d(TAG,"Constructor");

    }

    public static Data2DataRealmMapper getRealmMapper() {
        return realmMapper;
    }

    public DataRealm getdataRealm(Data data){
        if(data!=null){
            Log.d(TAG, "getdataRealm(): DataRealm is not Null Called: "+data.getTitle());

            dataRealm = new DataRealm();
            dataRealm.setDescription(data.getDescription());
            dataRealm.setGenerator(data.getGenerator());
            dataRealm.setItemRealms((RealmList)getItemListRealm(data.getItems()));

    //        dataRealm.setItemRealms(getItemListRealm(data.getItems()));
            dataRealm.setTitle(data.getTitle());
            Log.d(TAG, "getdataRealm(): Databinding : dataRealm: "+dataRealm.getTitle());
        }
        else{
            Log.d(TAG, "getdataRealm(): DataRealm is Null Called : title: ");

        }

        Log.d(TAG, "getdataRealm(): Databinding : dataRealm: "+dataRealm.getTitle());

        return dataRealm;
    }


    public List<ItemRealm> getItemListRealm(List<Item> itemList){
        if(itemList!=null){
            itemListRealm= new ArrayList<>();

            Log.d(TAG, "getItemListRealm(): Itemlist is not Null Called: ");

            for(int i=0; i<itemList.size();i++){
                itemListRealm.add(i,getItemRealm(itemList.get(i)));
            }
            Log.d(TAG, "getItemListRealm(): ItemlistRealm Size: "+itemListRealm.size());

        }
        return itemListRealm;
    }

    ItemRealm getItemRealm(Item item) {

        if(item!=null) {

            itemRealm = new ItemRealm();

            itemRealm.setDescription(item.getDescription());
            itemRealm.setAuthorId(item.getAuthorId());
            itemRealm.setAuthor(item.getAuthor());
            itemRealm.setTitle(item.getTitle());
            itemRealm.setPublished(item.getPublished());
            itemRealm.setDateTaken(item.getDateTaken());
            itemRealm.setMedia(getMediaRealm(item.getMedia()));
            itemRealm.setLink(item.getLink());
            itemRealm.setTags(item.getTags());


        }
        Log.d(TAG, "getItemListRealm(): ItemRealm: "+itemRealm.toString());

        return itemRealm;
    }



    public MediaRealm getMediaRealm(Media media){
        if(media!=null){
            Log.d(TAG, "getItemListRealm(): MediaRealm is not Null Called: ");
            mediaRealm= new MediaRealm();
         //   String encryptMessage=KeyGeneratorService.getService().encryptMessage(media.getM());
          //  Log.d(TAG,"Encrypt String: "+encryptMessage);

            mediaRealm.setM(media.getM());
        }
        return mediaRealm;
    }


}
