package th.ac.kmitl.rspg.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.request.SelectNewsRequest;
import th.ac.kmitl.rspg.request.SelectPlantRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectNewsResponse;
import th.ac.kmitl.rspg.response.SelectPlantResponse;
import th.ac.kmitl.rspg.service.SelectNewsService;
import th.ac.kmitl.rspg.service.SelectPlantService;

public class PlantActivity extends AppCompatActivity {

    private static SelectPlantResponse selectPlantResponse;
    SelectPlantRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_view);

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        request = new SelectPlantRequest();
        request.setId(this.getIntent().getStringExtra("plantId"));
        request.setLogUserId(userInfo.getId().toString());

        new CallWebService().execute();

    }


    private void SetPlant(SelectPlantResponse plant){
        if(plant != null){
            TextView code = (TextView) findViewById(R.id.plant_code_desc);
            if("".equalsIgnoreCase(plant.getSn()) || plant.getSn() == null){
                code.setText(" - ");
            }else{
                code.setText(plant.getSn());
            }
            ImageView plantImgView = (ImageView) findViewById(R.id.plant_img_view);
            if(!"".equalsIgnoreCase(plant.getPicFirstFilename()) && plant.getPicFirstFilename() != null){
                try{
                    plantImgView.setImageDrawable(Drawable.createFromStream((InputStream)new URL(plant.getPicFirstFilename()).getContent(), "src"));
                    LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(960, 960);
                    layoutParams.gravity=Gravity.CENTER;
                    plantImgView.setLayoutParams(layoutParams);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }else{
                plantImgView.setVisibility(View.GONE);
            }
            TextView localName = (TextView) findViewById(R.id.plant_local_name_desc);
            localName.setText(plant.getVernacularName());
            TextView normalName = (TextView) findViewById(R.id.plant_normal_name_desc);
            normalName.setText(plant.getCommonName());
            TextView sciName = (TextView) findViewById(R.id.plant_sci_name_desc);
            sciName.setText(plant.getScientificName());
            TextView character = (TextView) findViewById(R.id.plant_character);
            character.setText("ลักษณะพรรณไม้ : "+plant.getCharacter());
            TextView original = (TextView) findViewById(R.id.plant_original);
            original.setText("ถื่นกำเนิด : "+plant.getOriginal());
            TextView distrib = (TextView) findViewById(R.id.plant_distribution);
            distrib.setText("การกระจายพันธุ์ : "+plant.getDistribution());
            TextView ecology = (TextView) findViewById(R.id.plant_ecology);
            ecology.setText("สภาพนิเวศ : "+plant.getEcology());

        }else{
//            Toast.makeText(this,"plant Is Null",Toast.LENGTH_SHORT).show();
        }

    }

    class CallWebService extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(PlantActivity.this,
                    "ProgressDialog",
                    "กรุณารอสักครู่");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            SetPlant(selectPlantResponse);
        }

        @Override
        protected String doInBackground(String... params) {

            selectPlantResponse = SelectPlantService.getPlant(request);

            return null;
        }
    }
}
