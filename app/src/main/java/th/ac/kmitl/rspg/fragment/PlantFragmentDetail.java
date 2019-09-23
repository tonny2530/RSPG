package th.ac.kmitl.rspg.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import th.ac.kmitl.rspg.R;

public class PlantFragmentDetail extends Fragment {

    public PlantFragmentDetail() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_plant_detail, container, false);
        TextView txtTitleName = (TextView)rootView.findViewById(R.id.PtextView);
        txtTitleName.requestFocus();
        return rootView;
    }
}
