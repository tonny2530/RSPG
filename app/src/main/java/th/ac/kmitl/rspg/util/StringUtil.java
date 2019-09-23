package th.ac.kmitl.rspg.util;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class StringUtil {

    public static String checkNullOrEmpty(String word){
        if(word == null || word.isEmpty()){
            return "";
        }
        return word;
    }

    public static boolean checkNullOrEmptyBoolean(String word){
        if(word == null || word.isEmpty()){
            return true;
        }
        return false;
    }

    public static String encodeToBase64(Bitmap img){
        Bitmap image = img;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        byte[] b = bytes.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    public static Bitmap decodeBase64(String input){
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

}
