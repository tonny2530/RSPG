package th.ac.kmitl.rspg.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.request.SelectNewsRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectNewsResponse;
import th.ac.kmitl.rspg.service.SelectNewsService;

public class NewsActivity extends AppCompatActivity {

    private static SelectNewsResponse selectNewsResponse;
    SelectNewsRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        request = new SelectNewsRequest();
        request.setid(Integer.valueOf(this.getIntent().getStringExtra("newsId")));
        request.setLogUserId(userInfo.getId());

        new CallWebService().execute();

    }


    private void SetNews(SelectNewsResponse news){
        if(news != null){
            TextView topic = (TextView) findViewById(R.id.news_view_topic);
            topic.setText(news.getName());
            TextView dateTime = (TextView) findViewById(R.id.news_view_date_name);
            dateTime.setText(news.getDate() + " " +news.getTime() + " " + news.getUserThname());
            TextView detail = (TextView) findViewById(R.id.news_view_detail);
            detail.setText("รายละเอียด : "+news.getFullDetail());
        }else{
//            Toast.makeText(this,"News Is Null",Toast.LENGTH_SHORT).show();
        }

    }

    class CallWebService extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(NewsActivity.this,
                    "ProgressDialog",
                    "กรุณารอสักครู่");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            ObjectMapper mapper = new ObjectMapper();
            SetNews(selectNewsResponse);
        }

        @Override
        protected String doInBackground(String... params) {

            selectNewsResponse = SelectNewsService.getNews(request);

            return null;
        }
    }
}
