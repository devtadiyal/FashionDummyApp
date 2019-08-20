package com.logzero.necommerce.womenselection.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.logzero.necommerce.R;
import com.logzero.necommerce.utility.Data;
import com.logzero.necommerce.womenselection.fragment.DataAdapter;
import com.logzero.necommerce.womenselection.fragment.ShoesModel;

import java.util.ArrayList;


public class PalazzoFragment extends Fragment {
    RecyclerView recyclerView;
    public PalazzoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_palazzo, container,
                false);
        recyclerView = view.findViewById(R.id.rv);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<ShoesModel> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getContext(),
                androidVersions,"PalazzoFragment");
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<ShoesModel> prepareData() {

        ArrayList<ShoesModel> android_version = new ArrayList<>();
        for (int i = 0; i < Data.palazzo_image.length; i++) {
            ShoesModel androidVersion = new ShoesModel();
            androidVersion.setName(Data.palazzo_name[i]);
            androidVersion.setImage(Data.palazzo_image[i]);
            androidVersion.setSubtitle(Data.palazzo_subtitle[i]);
            androidVersion.setPrice(Data.palazzo_price[i]);
            android_version.add(androidVersion);
        }

        return android_version;
    }

}

