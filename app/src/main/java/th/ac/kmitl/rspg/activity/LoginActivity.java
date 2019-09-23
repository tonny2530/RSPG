package th.ac.kmitl.rspg.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.request.LoginUserRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectUserResponse;
import th.ac.kmitl.rspg.service.UserService;
import th.ac.kmitl.rspg.util.StringUtil;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SelectUserResponse loginUserInfo;
    private LoginUserRequest req;
    private String tempUrl;
    private String domainUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(!isOnline()){
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("กรุณาเชื่อมต่ออินเเตอร์เน็ต ก่อนเริ่มใช้งานแอพพลิเคชั่น");
            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.show();
        }

        new CallGetURLService().execute();

        final EditText editTxtUserName = (EditText)this.findViewById(R.id.edittxt_username);
        final EditText editTxtPassword = (EditText)this.findViewById(R.id.edittxt_password);
        ImageView imgView = (ImageView)this.findViewById(R.id.logo);
        imgView.setImageResource(R.drawable.logo);
        Button btnSubmit = (Button)this.findViewById(R.id.btn_login_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Context context = getApplicationContext();
                SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                domainUrl = mPrefs.getString("DomailURL", "");

                req = new LoginUserRequest();
                req.setUserName(editTxtUserName.getText().toString());
                req.setPassword(editTxtPassword.getText().toString());

                new CallWebService().execute(req.getUserName(),req.getPassword());
            }
        });
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }

    }

    public void changeToHome(SelectUserResponse s){
        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
//        i.putExtra("userInfo",s);
        i.putExtra("userInfo",s);
        startActivity(i);
    }

    class CallGetURLService extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            tempUrl = UserService.getUrl();

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if(!"".equalsIgnoreCase(tempUrl)){
                prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor prefsEditor = prefs.edit();
                prefsEditor.putString("DomailURL", tempUrl);
                prefsEditor.commit();
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("เกิดข้อผิดพลาด ไม่สามารถทำรายการได้");
                builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
            }

        }
    }

    class CallWebService extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(LoginActivity.this,
                    "ProgressDialog",
                    "กรุณารอสักครู่");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            if(loginUserInfo != null){
                changeToHome(loginUserInfo);
            }else{
                String msg = "ข้อมูลของท่านไม่ถูกต้อง กรุณาระบุอีกครั้ง";
                Toast t = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
                t.show();
            }
        }
        @Override
        protected String doInBackground(String... params) {

            loginUserInfo = UserService.login(tempUrl,req.getUserName(),req.getPassword());

            return null;
        }
    }

}
