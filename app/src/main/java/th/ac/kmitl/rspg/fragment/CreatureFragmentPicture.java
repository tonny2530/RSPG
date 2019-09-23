package th.ac.kmitl.rspg.fragment;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.util.StringUtil;

import static th.ac.kmitl.rspg.constant.MainConstant.REQUEST_CAMERA;

public class CreatureFragmentPicture extends Fragment {

    private TextView test;
    private ImageView imageView;
    private ImageButton cameraBtn;
    private Bitmap thumbnail;
    private SharedPreferences prefs;

    Uri uri;

    public CreatureFragmentPicture() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_add_creature_picture, container, false);
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        imageView = (ImageView)rootView.findViewById(R.id.creatureImageView);

        String base64 = mPrefs.getString("storeImage", "");
        if(!base64.equalsIgnoreCase("")){
            imageView.setImageBitmap(StringUtil.decodeBase64(base64));
        }else{
            imageView.setImageResource(R.drawable.default_image_thumbnail);
        }

        cameraBtn = (ImageButton)rootView.findViewById(R.id.buttonIntent);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//                String imageFileName = "IMG_RSPG_" + timeStamp + ".jpg";
//                File x =  new File(Environment.getExternalStoragePublicDirectory(
//                        Environment.DIRECTORY_DCIM),"");
//                File f = new File(x.getPath()+ "/"+ imageFileName);
//                uri = Uri.fromFile(f);
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, 0);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
//        if (requestCode == REQUEST_CAMERA && resultCode == -1) {
////            getContentResolver().notifyChange(uri, null);
//            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//            ContentResolver cr = getActivity().getContentResolver();
//            try {
//                Bitmap bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, uri);
//                imageView.setImageBitmap(bitmap);
//                Toast.makeText(getActivity().getApplicationContext(), uri.getPath(), Toast.LENGTH_SHORT).show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        imageView = (ImageView)getView().findViewById(R.id.creatureImageView);
//        imageView.setImageBitmap(thumbnail);
        prefs =  PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString("storeImage", StringUtil.encodeToBase64(thumbnail));
        prefsEditor.commit();
    }


}
