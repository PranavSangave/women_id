package com.example.womenentrepreneur.Requests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.womenentrepreneur.Investor.InvestorAdapter;
import com.example.womenentrepreneur.Investor.InvestorModel;
import com.example.womenentrepreneur.R;

import java.util.ArrayList;
import java.util.List;

public class PrendingRequvests extends AppCompatActivity {
    RecyclerView upcomingrecycler;

    List<InvestorModel> data_list;
    private PendingRequevestAdapter pageInfoAdapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prending_requvests);


        upcomingrecycler = findViewById(R.id.pendingrequvest);
        layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.VERTICAL);
        upcomingrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());
        data_list.add(new InvestorModel());
//        data_list.add(new InvestorModel());
//        data_list.add(new InvestorModel());
//        data_list.add(new InvestorModel());

        pageInfoAdapter = new PendingRequevestAdapter(data_list, this);
        upcomingrecycler.setAdapter(pageInfoAdapter);


    }
}