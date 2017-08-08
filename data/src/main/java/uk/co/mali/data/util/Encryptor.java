package uk.co.mali.data.util;

import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

/**
 * Created by alig2 on 05/08/2017.
 */

public class Encryptor {

    private static final String TAG = Encryptor.class.getSimpleName();
    private static final String CIPHER_TYPE = "RSA/ECB/PKCS1PADDING";
    private static final String CIPHER_PROVIDER = "AndroidOpenSSL";

    public static String encryptString(final String ALIAS_KEY, String message, KeyStore keyStore) {

        Log.d(TAG, "Encrypted String Started");

        String encryptedString = null;
        try {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(ALIAS_KEY, null);
            RSAPublicKey publicKey = (RSAPublicKey) privateKeyEntry.getCertificate().getPublicKey();

            //String initialText = mStartText.getText().toString();
            if (message.isEmpty()) {
               // Toast.makeText(this, "Enter text in the 'Initial Text' widget", Toast.LENGTH_LONG).show();
                return null;
            }

            Cipher inCipher = Cipher.getInstance(CIPHER_TYPE,CIPHER_PROVIDER);
            inCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream,inCipher);
            cipherOutputStream.write(message.getBytes("UTF-8"));

            cipherOutputStream.close();
            byte [] vals = outputStream.toByteArray();

            //  String m = Base64.encodeToString(vals,Base64.DEFAULT);

           encryptedString = (Base64.encodeToString(vals,Base64.DEFAULT));
            Log.d(TAG, "Encrypted String : "+encryptedString);


        } catch (Exception e) {
            e.printStackTrace();
           // Toast.makeText(this, "Exception " + e.getMessage() + " occured", Toast.LENGTH_LONG).show();
            Log.e(TAG, Log.getStackTraceString(e));
        }

        return encryptedString;
    }


}
