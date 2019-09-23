package th.ac.kmitl.rspg.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.adapter.PlantListAdapter;
import th.ac.kmitl.rspg.bean.BaseItem;
import th.ac.kmitl.rspg.bean.CardViewItem;
import th.ac.kmitl.rspg.request.SelectAllPlantRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectAllPlantResponse;
import th.ac.kmitl.rspg.service.SelectAllPlantService;

public class PlantFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private RecyclerView recyclerView;
    private PlantListAdapter adapter;
    List<SelectAllPlantResponse> plantList;
    List<BaseItem> itemList = new ArrayList<>();

    SelectAllPlantRequest request;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PlantFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PlantFragment newInstance(String param1, String param2) {
        PlantFragment fragment = new PlantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("RSPG", "Plant Fragment onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        request = new SelectAllPlantRequest();
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        request.setLogUserId(userInfo.getId().toString());

        new CallWebService().execute();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("RSPG", "Plant Fragment onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.habitatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    private List<BaseItem> createItem() {

        for(int i=0; i<=10; i++){
            itemList.add(new CardViewItem()
                    .setImage(R.mipmap.ic_launcher)
                    .setText("Hello World_"+i));
        }
        return itemList;
    }

    private List<BaseItem> createPlantItem(List<SelectAllPlantResponse> plantList){
        for(SelectAllPlantResponse plant : plantList ){
            CardViewItem cardViewItem = new CardViewItem();
            cardViewItem.setItemId(plant.getId().toString());
            cardViewItem.setText(plant.getVernacularName());
            cardViewItem.setImage(0);
            itemList.add(cardViewItem);
        }
        return itemList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant, container, false);
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
            adapter = new PlantListAdapter(itemList, getContext());
            adapter.setItemList(createPlantItem(plantList));
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected String doInBackground(String... params) {

            plantList = SelectAllPlantService.getAllPlant(request);

            return null;
        }
    }
}
