package com.example.womenentrepreneur.Investor;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.womenentrepreneur.R;

import java.util.ArrayList;
import java.util.List;

public class InvestorFragment extends Fragment {



    RecyclerView upcomingrecycler;

    List<InvestorModel> data_list;
    private InvestorAdapter pageInfoAdapter;
    LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_investor, container, false);

        upcomingrecycler = view.findViewById(R.id.connected);
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

        pageInfoAdapter = new InvestorAdapter(data_list, getContext());
        upcomingrecycler.setAdapter(pageInfoAdapter);





//        String sharedPreferencesFileTitle = "capcunadmin";
//
//
//
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences(sharedPreferencesFileTitle, getContext().MODE_PRIVATE);
//
//        String act_id = sharedPreferences.getString("act_id","");


//        Call<List<IDAndNameReciverModel>> call = ApiControlllerEmployee
//                .getInstance()
//                .fethAllID()
//                .fetchallAdAccountsconnected(act_id);
//        //Toast.makeText(this, "vasudev data update sceessfuly", Toast.LENGTH_SHORT).show();
//        call.enqueue(new Callback<List<IDAndNameReciverModel>>() {
//            @Override
//            public void onResponse(Call<List<IDAndNameReciverModel>> call, Response<List<IDAndNameReciverModel>> response) {
//
//                List<IDAndNameReciverModel> data = response.body();
//
////                Toast.makeText(AllAdAccountList.this, ""+data.size(), Toast.LENGTH_SHORT).show();
//                if(data!=null)
//                {
//                    data_list.addAll(data);
//                    pageInfoAdapter = new PageInfoAdapter(data_list, getContext());
//                    upcomingrecycler.setAdapter(pageInfoAdapter);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<IDAndNameReciverModel>> call, Throwable t) {
////                progressDialog.dismiss();
//
//                Toast.makeText(getContext(),"Something went wrong please refresh the page !",Toast.LENGTH_LONG).show();
//            }
//        });

        return view;
    }
}