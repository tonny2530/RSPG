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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import th.ac.kmitl.rspg.R;
import th.ac.kmitl.rspg.adapter.ProjectListAdapter;
import th.ac.kmitl.rspg.bean.BaseItem;
import th.ac.kmitl.rspg.bean.CardViewItem;
import th.ac.kmitl.rspg.request.SelectAllProjectRequest;
import th.ac.kmitl.rspg.response.LoginUserResponse;
import th.ac.kmitl.rspg.response.SelectAllPlantResponse;
import th.ac.kmitl.rspg.response.SelectAllProjectResponse;
import th.ac.kmitl.rspg.service.SelectAllProjectService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProjectFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProjectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private ProjectListAdapter adapter;
    List<BaseItem> itemList = new ArrayList<>();
    List<SelectAllProjectResponse> projectList;

    SelectAllProjectRequest request;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProjectFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProjectFragment newInstance(String param1, String param2) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        request = new SelectAllProjectRequest();
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        Gson gson = new Gson();
        String json = mPrefs.getString("UserInfo", "");
        LoginUserResponse userInfo = gson.fromJson(json, LoginUserResponse.class);

        request.setLogUserId(userInfo.getId().toString());

        new CallWebService().execute();

    }

    private List<BaseItem> createProjectItem(List<SelectAllProjectResponse> projectList){
        for(SelectAllProjectResponse project : projectList ){
            CardViewItem cardViewItem = new CardViewItem();
            cardViewItem.setItemId(project.getId().toString());
            cardViewItem.setText(project.getThname());
            itemList.add(cardViewItem);
        }
        return itemList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @java.lang.Override
    public void onViewCreated(android.view.View view, android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.projectRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
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
            adapter = new ProjectListAdapter(itemList, getContext());
            adapter.setItemList(createProjectItem(projectList));
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected String doInBackground(String... params) {

            projectList = SelectAllProjectService.getAllProject(request);

            return null;
        }
    }
}


