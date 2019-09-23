package th.ac.kmitl.rspg.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.adapter.NewsListAdapter;
import th.ac.kmitl.rspg.bean.BaseItem;
import th.ac.kmitl.rspg.bean.CardViewItem;
import th.ac.kmitl.rspg.request.SelectAllNewsRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectAllNewsResponse;
import th.ac.kmitl.rspg.service.SelectAllNewsService;
import th.ac.kmitl.rspg.util.DateUtil;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsFragmentProject.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsFragmentProject#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragmentProject extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private NewsListAdapter adapter;

    private List<SelectAllNewsResponse> newsList;
    List<BaseItem> itemList = new ArrayList<>();

    SelectAllNewsRequest newsRequest;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewsFragmentProject() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragmentProject.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragmentProject newInstance(String param1, String param2) {
        NewsFragmentProject fragment = new NewsFragmentProject();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("RSPG", "News Fragment Project onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        newsRequest = new SelectAllNewsRequest();
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        Date dateBefore30Days = cal.getTime();

        newsRequest.setLogUserId(String.valueOf(userInfo.getId()));
        newsRequest.setStartdate(DateUtil.convertDateToString(dateBefore30Days,DateUtil.date_pattern_1));
        newsRequest.setEnddate(DateUtil.convertDateToString(new Date(),DateUtil.date_pattern_1));
        newsRequest.setProjectId(String.valueOf(userInfo.getProjectId()));

        new CallWebService().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("RSPG", "News Fragment Project onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.newsProjectRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onResume() {
        Log.i("RSPG", "News Fragment Project onResume");
        super.onResume();
    }

    private List<BaseItem> createNewsItem(List<SelectAllNewsResponse> listNews) {
        if(listNews.size() == 0){
            CardViewItem cardViewItem = new CardViewItem();
            cardViewItem.setItemId("0");
            cardViewItem.setText(getResources().getString(R.string.no_feed_news));
            itemList.add(cardViewItem);
        }else{
            for(SelectAllNewsResponse n : listNews) {
                CardViewItem cardViewItem = new CardViewItem();
                cardViewItem.setItemId(n.getId().toString());
                cardViewItem.setText(n.getName());
                itemList.add(cardViewItem);
            }
        }
        return itemList;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    class CallWebService extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getContext(),
                    "ProgressDialog",
                    "กรุณารอสักครู่");
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            ObjectMapper mapper = new ObjectMapper();
            adapter = new NewsListAdapter(itemList, getContext());
            adapter.setItemList(createNewsItem(newsList));
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected String doInBackground(String... params) {

            newsList = SelectAllNewsService.getAllNews(newsRequest);

            return null;
        }
    }
}
