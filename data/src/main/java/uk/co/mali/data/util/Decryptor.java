package uk.co.mali.data.util;

import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

/**
 * Created by alig2 on 05/08/2017.
 */

public class Decryptor {

    private static final String TAG = Decryptor.class.getSimpleName();

    public static String decryptString(final String ALIAS_KEY, String message, KeyStore keyStore){
        Log.d(TAG, "Dycrypt String started!.. ");

        String finalText = null;
        try {
            KeyStore.PrivateKeyEntry privateKeyEntry= (KeyStore.PrivateKeyEntry) keyStore.getEntry(ALIAS_KEY,null);
            RSAPrivateKey privateKey = (RSAPrivateKey) privateKeyEntry.getPrivateKey();
            Cipher output = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL");
            output.init(Cipher.DECRYPT_MODE, privateKey);

            //String cipherText = message;
            CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(Base64.decode(message,Base64.DEFAULT)),output);

            ArrayList<Byte> values = new ArrayList<>();

            int nextByte;

            while((nextByte = cipherInputStream.read())!= -1){
                values.add((byte) nextByte);
            }

            byte[] bytes = new byte[values.size()];

            for(int i = 0; i<bytes.length;i++){
                bytes[i] = values.get(i).byteValue();
            }

             finalText= new String(bytes,0,bytes.length,"UTF-8");
            Log.d(TAG, "Encrypted String : "+finalText);


            //  mDecryptText.setText(finalText);

        } catch (Exception e) {
        //    Toast.makeText(this, "Exception " + e.getMessage() + " occured", Toast.LENGTH_LONG).show();
            Log.e(TAG, Log.getStackTraceString(e));
        }

        return finalText;
    }
}
