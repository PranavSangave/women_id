package com.example.womenentrepreneur.Investor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.womenentrepreneur.R;

import java.util.ArrayList;
import java.util.List;

public class OrganizationFragment extends Fragment {

    RecyclerView upcomingrecycler;

    List<InvestorModel> data_list;
    private OrganizationAdapter pageInfoAdapter;
    LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_organization, container, false);


        upcomingrecycler = view.findViewById(R.id.notconnected);
        layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(RecyclerView.VERTICAL);
        upcomingrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());

        pageInfoAdapter = new OrganizationAdapter(data_list, getContext());
        upcomingrecycler.setAdapter(pageInfoAdapter);


        return view;
    }
}