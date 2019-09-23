package th.ac.kmitl.rspg.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.BitmapDrawableResource;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.request.SelectCreatureRequest;
import th.ac.kmitl.rspg.request.SelectPlantRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectCreatureResponse;
import th.ac.kmitl.rspg.response.SelectPlantResponse;
import th.ac.kmitl.rspg.service.SelectCreatureService;
import th.ac.kmitl.rspg.service.SelectPlantService;

public class CreatureActivity extends AppCompatActivity {

    private static SelectCreatureResponse selectCreatureResponse;
    SelectCreatureRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature_view);

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        request = new SelectCreatureRequest();
        request.setId(this.getIntent().getStringExtra("creatureId"));
        request.setLogUserId(userInfo.getId().toString());

        new CallWebService().execute();

    }


    private void SetCreature(SelectCreatureResponse creature){
        if(creature != null){
            TextView code = (TextView) findViewById(R.id.creature_code_desc);
            if("".equalsIgnoreCase(creature.getSn()) || creature.getSn() == null){
                code.setText(" - ");
            }else{
                code.setText(creature.getSn());
            }
            ImageView creatureImgView = (ImageView) findViewById(R.id.creature_img_view);
            if(!"".equalsIgnoreCase(creature.getPicFirstFilename()) && creature.getPicFirstFilename() != null){
                try{
                    Drawable img = Drawable.createFromStream((InputStream)new URL(creature.getPicFirstFilename()).getContent(), "src");
                    creatureImgView.setImageDrawable(img);
                    LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(960, 960);
                    layoutParams.gravity=Gravity.CENTER;
                    creatureImgView.setLayoutParams(layoutParams);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }else{
                creatureImgView.setVisibility(View.GONE);
            }
            TextView localName = (TextView) findViewById(R.id.creature_local_name_desc);
            localName.setText(creature.getVernacularName());
            TextView normalName = (TextView) findViewById(R.id.creature_normal_name_desc);
            normalName.setText(creature.getCommonName());
            TextView sciName = (TextView) findViewById(R.id.creature_sci_name_desc);
            sciName.setText(creature.getScientificName());
            TextView character = (TextView) findViewById(R.id.creature_character);
            character.setText("ลักษณะพันธุ์สัตว์ : "+creature.getCharacter());
            TextView original = (TextView) findViewById(R.id.creature_original);
            original.setText("ถื่นกำเนิด : "+creature.getOriginal());
            TextView distrib = (TextView) findViewById(R.id.creature_distribution);
            distrib.setText("การกระจายพันธุ์ : "+creature.getDistribution());
            TextView ecology = (TextView) findViewById(R.id.creature_ecology);
            ecology.setText("สภาพนิเวศ : "+creature.getEcology());

        }else{
//            Toast.makeText(this,"creature Is Null",Toast.LENGTH_SHORT).show();
        }

    }

    class CallWebService extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(CreatureActivity.this,
                    "ProgressDialog",
                    "กรุณารอสักครู่");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            SetCreature(selectCreatureResponse);
        }

        @Override
        protected String doInBackground(String... params) {

            selectCreatureResponse = SelectCreatureService.getCreature(request);

            return null;
        }
    }
}
