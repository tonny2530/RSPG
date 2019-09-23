package th.ac.kmitl.rspg.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.adapter.ResultListAdapter;
import th.ac.kmitl.rspg.bean.BaseItem;
import th.ac.kmitl.rspg.bean.CardViewItem;
import th.ac.kmitl.rspg.request.SearchAllRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SearchAllResponse;
import th.ac.kmitl.rspg.service.SearchService;

public class SearchResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ResultListAdapter adapter;
    List<BaseItem> itemList = new ArrayList<>();

    SearchAllRequest request;
    List<SearchAllResponse> result;
    ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_resultx);

        recyclerView = (RecyclerView) findViewById(R.id.resultListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        request = new SearchAllRequest();
        request.setLogUserId(userInfo.getId().toString());
        request.setKeyword(this.getIntent().getStringExtra("keyword"));

        new CallWebService().execute();

    }

    class CallWebService extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(SearchResultActivity.this,
                    "ProgressDialog",
                    "กรุณารอสักครู่");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            adapter = new ResultListAdapter(itemList, getApplicationContext());
            adapter.setItemList(createResultItem(result));
            recyclerView.setAdapter(adapter);
            if(itemList.size() == 0){
                TextView emptyTextView = (TextView)findViewById(R.id.emptyView);
                emptyTextView.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected String doInBackground(String... params) {

            result = SearchService.search(request);

            return null;
        }
    }

    private List<BaseItem> createResultItem(List<SearchAllResponse> r){
        if(r.size() == 0){
            CardViewItem cardViewItem = new CardViewItem();
            cardViewItem.setItemId("0|0");
            cardViewItem.setText(getResources().getString(R.string.no_result));
            cardViewItem.setImage(0);
            itemList.add(cardViewItem);
        }else{
            for(SearchAllResponse s : r){
                CardViewItem cardViewItem = new CardViewItem();
                cardViewItem.setItemId(String.valueOf(s.getId())+"|"+s.getType());
                cardViewItem.setText(s.getTitle());
                cardViewItem.setImage(0);
                itemList.add(cardViewItem);
            }
        }

        return itemList;
    }
}
