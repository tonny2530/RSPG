package th.ac.kmitl.rspg.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.fragment.PlantFragmentDetail;
import th.ac.kmitl.rspg.fragment.PlantFragmentMap;
import th.ac.kmitl.rspg.fragment.PlantFragmentPicture;
import th.ac.kmitl.rspg.adapter.ViewPagerAdapter;
import th.ac.kmitl.rspg.request.InsertHabitatRequest;
import th.ac.kmitl.rspg.request.InsertPictureRequest;
import th.ac.kmitl.rspg.request.InsertPlantRequest;
import th.ac.kmitl.rspg.response.HabitatResponse;
import th.ac.kmitl.rspg.response.InsertResponse;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.service.InsertHabitatService;
import th.ac.kmitl.rspg.service.InsertPictureService;
import th.ac.kmitl.rspg.service.InsertPlantService;
import th.ac.kmitl.rspg.util.StringUtil;


public class AddPlantActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LoginUserResponse userInfo;
    private InsertPlantRequest insertPlant;
    private InsertHabitatRequest insertHabitat;
    private InsertPictureRequest insertPicture;
    private InsertResponse response,insertPictureResponse;
    private HabitatResponse habitat;
    private SharedPreferences prefs;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        userInfo = gson.fromJson(json, LoginUserResponse.class);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setUpTabLayout();

        Button saveBtn = (Button)this.findViewById(R.id.add_habitat_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(AddPlantActivity.this);
                builder.setIcon(R.drawable.ic_noti);
                builder.setTitle("ยืนยันการทำรายการ");
                TextView myMsg = new TextView(AddPlantActivity.this);
                myMsg.setText("คุณต้องการบันทึกข้อมูลใช่หรือไม่?");
                myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                builder.setView(myMsg);
                builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        savePlant();
                    }
                });
                builder.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }

    private void savePlant() {

        insertPlant = new InsertPlantRequest();

        final EditText editTxtPlantCode = (EditText)this.findViewById(R.id.plant_code_edttxt);
        final EditText editTxtPlantLocalName = (EditText)this.findViewById(R.id.plant_local_name_edttxt);
        final EditText editTxtPlantSciName = (EditText)this.findViewById(R.id.plant_sci_name_edttxt);
        final EditText editTxtPlantNormalName = (EditText)this.findViewById(R.id.plant_normal_name_edttxt);
        final EditText editTxtPlantDetail = (EditText)this.findViewById(R.id.plant_indetail_edttxt);
        final EditText editTxtPlantBenefit = (EditText)this.findViewById(R.id.plant_benefit_edttxt);

        if(StringUtil.checkNullOrEmptyBoolean(editTxtPlantCode.getText().toString()) || StringUtil.checkNullOrEmptyBoolean(editTxtPlantLocalName.getText().toString())
                || StringUtil.checkNullOrEmptyBoolean(editTxtPlantSciName.getText().toString()) || StringUtil.checkNullOrEmptyBoolean(editTxtPlantNormalName.getText().toString())){
            builder = new AlertDialog.Builder(AddPlantActivity.this);
            builder.setIcon(R.drawable.ic_noti);
            builder.setTitle("แจ้งเตือน");
            TextView myMsg = new TextView(AddPlantActivity.this);
            myMsg.setText("กรุณาระบุข้อมูลให้ครบถ้วน");
            myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
            builder.setView(myMsg);
            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }else{
            insertPlant.setSn(editTxtPlantCode.getText().toString());
            insertPlant.setVernacularName(editTxtPlantLocalName.getText().toString());
            insertPlant.setScientificName(editTxtPlantSciName.getText().toString());
            insertPlant.setCommonName(editTxtPlantNormalName.getText().toString());
            insertPlant.setCharacter(editTxtPlantDetail.getText().toString());
            insertPlant.setOther(editTxtPlantBenefit.getText().toString());
            insertPlant.setLogUserId(String.valueOf(userInfo.getId()));
            insertPlant.setUserId(String.valueOf(userInfo.getId()));

            new CallInsertPlantService().execute();
        }
    }

    @Override
    public void onBackPressed() {
        boolean y = false;
        builder = new AlertDialog.Builder(AddPlantActivity.this);
        builder.setIcon(R.drawable.ic_noti);
        builder.setTitle("ยืนยันการทำรายการ");
        TextView myMsg = new TextView(AddPlantActivity.this);
        myMsg.setText("คุณต้องการยกเลิกใช่หรือไม่?");
        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        builder.setView(myMsg);
        builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                removeImg();
                AddPlantActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            }
        });
        builder.show();
    }

    private void removeImg() {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.remove("storeImage");
        prefsEditor.commit();
    }

    private void setUpTabLayout() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("รายละเอียด");
        tabOne.setTextSize(24);
        tabOne.setTypeface(tabOne.getTypeface(), Typeface.BOLD);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("แผนที่");
        tabTwo.setTextSize(24);
        tabTwo.setTypeface(tabTwo.getTypeface(), Typeface.BOLD);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("เพิ่มรูปภาพ");
        tabThree.setTextSize(24);
        tabThree.setTypeface(tabThree.getTypeface(), Typeface.BOLD);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlantFragmentDetail(), "รายละเอียด");
        adapter.addFragment(new PlantFragmentMap(), "แผนที่");
        adapter.addFragment(new PlantFragmentPicture(), "เพิ่มรูปภาพ");
        viewPager.setAdapter(adapter);
    }

    private void callInsertHabitat(){
        insertHabitat = new InsertHabitatRequest();

        TextView latitude = (TextView)findViewById(R.id.plant_lat_textView);
        TextView longtitude = (TextView)findViewById(R.id.plant_long_textView);

        insertHabitat.setLogUserId(userInfo.getId());
        insertHabitat.setLatitude(Double.parseDouble(latitude.getText().toString()));
        insertHabitat.setLongitude(Double.parseDouble(longtitude.getText().toString()));
        insertHabitat.setPlantId(Integer.parseInt(response.getResult().toString()));
        insertHabitat.setArea(null);
        insertHabitat.setCreatureId(null);

        new CallInsertHabitatService().execute();

    }

    private void callInsertPicture(){
        insertPicture = new InsertPictureRequest();

        ImageView img = (ImageView)findViewById(R.id.plantImageView);

        Bitmap defaultImg = BitmapFactory.decodeResource(getResources(), R.drawable.default_image_thumbnail);
        Bitmap creatureImg = ((BitmapDrawable)img.getDrawable()).getBitmap();

        insertPicture.setLogUserId(userInfo.getId());
        insertPicture.setCreatureId(null);
        insertPicture.setFirst("1");
        insertPicture.setDetail(null);
        insertPicture.setName(null);
        insertPicture.setNewsId(null);
        insertPicture.setPlantId(Integer.parseInt(response.getResult().toString()));
        insertPicture.setBase64encode(StringUtil.encodeToBase64(creatureImg));

        if(!defaultImg.sameAs(creatureImg)){
            new CallInsertPictureService().execute();
        }else{
            removeImg();
            Intent i = new Intent(getApplicationContext(),PlantActivity.class);
            i.putExtra("plantId",response.getResult().toString());
            startActivity(i);
        }


    }


    class CallInsertPlantService extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
//            Toast.makeText(getApplicationContext(), "preExecute InsertPlant", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
//            Toast.makeText(getApplicationContext(), "postExecute InsertPlant", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(), response.toString("Plant"), Toast.LENGTH_SHORT).show();
            if(!"0".equalsIgnoreCase(response.getResult().toString())){
                callInsertHabitat();
            }else{
                builder = new AlertDialog.Builder(AddPlantActivity.this);
                builder.setIcon(R.drawable.ic_noti);
                builder.setTitle("พบข้อผิดพลาด");
                TextView myMsg = new TextView(AddPlantActivity.this);
                myMsg.setText("ไม่สามารถเพิ่มข้อมูลพันธุ์พืชได้ กรุณาลองใหม่อีกครั้ง");
                myMsg.setGravity(Gravity.CENTER);
                builder.setView(myMsg);
                builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            response = InsertPlantService.insertPlant(insertPlant);

            return null;
        }
    }

    class CallInsertHabitatService extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
//            Toast.makeText(getApplicationContext(), "preExecute InsertHabitat", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
//            Toast.makeText(getApplicationContext(), "postExecuteInsertHabitat", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(), habitat.toString(), Toast.LENGTH_SHORT).show();

            callInsertPicture();

        }

        @Override
        protected String doInBackground(String... params) {

            habitat = InsertHabitatService.insertHabitat(insertHabitat);

            return null;
        }
    }

    class CallInsertPictureService extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
//            Toast.makeText(getApplicationContext(), "preExecute InsertPicture", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
//            Toast.makeText(getApplicationContext(), "postExecute InsertPicture", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(), insertPictureResponse.toString("Picture"), Toast.LENGTH_SHORT).show();
            removeImg();
            Intent i = new Intent(getApplicationContext(),PlantActivity.class);
            i.putExtra("plantId",response.getResult().toString());
            startActivity(i);
        }

        @Override
        protected String doInBackground(String... params) {

            insertPictureResponse = InsertPictureService.insertPicture(insertPicture);

            return null;
        }
    }
}
