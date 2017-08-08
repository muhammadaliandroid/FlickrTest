package uk.co.mali.data.util;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.security.auth.x500.X500Principal;

/**
 * Created by alig2 on 06/08/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.M)
public class KeyGeneratorService {

    private static final String TAG = KeyGeneratorService.class.getSimpleName();

    private static final String ALIAS_KEY = "FLICKR_APP_ALIAS_PUBLIC_KEY";

    private KeyStore keyStore;
    public List<String> mKeyAliases ;
    static KeyGeneratorService service = new KeyGeneratorService();

    @RequiresApi(api = Build.VERSION_CODES.M)
    private KeyGeneratorService(){
        Log.d(TAG, "Constructor ");

        init();
    }

    public static KeyGeneratorService getService(){
        return service;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        refreshKeys();
        createNewKeys();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createNewKeys() {
        Calendar end=null, start = null;
        Log.d(TAG,"Alias Text in Create New Keys, : "+ALIAS_KEY);
        try {
            if (!keyStore.containsAlias(ALIAS_KEY)) {
                start = Calendar.getInstance();
                end = Calendar.getInstance();
                end.add(Calendar.YEAR, 1);
                KeyGenParameterSpec spec = new KeyGenParameterSpec.Builder(
                        ALIAS_KEY,
                        KeyProperties.PURPOSE_DECRYPT | KeyProperties.PURPOSE_ENCRYPT)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
                        .setCertificateSubject(new X500Principal("CN=Sample Name, O=Android Authority"))
                        .setKeyValidityStart(start.getTime())
                        .setCertificateSerialNumber(BigInteger.ONE)
                        .setKeyValidityEnd(end.getTime())
                        .build();
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                generator.initialize(spec);
                KeyPair keyPair = generator.generateKeyPair();
            }
        } catch (Exception ex) {
            Log.e(TAG, Log.getStackTraceString(ex));
        }
        refreshKeys();
    }

    private void refreshKeys() {
            mKeyAliases = new ArrayList<>();
            try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                mKeyAliases.add(aliases.nextElement());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encryptMessage(String message){
        Log.d(TAG, "Encrypt Message Called:");
        return Encryptor.encryptString(ALIAS_KEY,message,keyStore);
    }


    public String decrypttMessage(String message){
        Log.d(TAG, "Decrypt Message Called:");
        return Decryptor.decryptString(ALIAS_KEY,message,keyStore);
    }

}
