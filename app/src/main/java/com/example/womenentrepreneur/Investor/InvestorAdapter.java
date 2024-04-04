package com.example.womenentrepreneur.Investor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.womenentrepreneur.Mentor.MentorServicesAdpter;
import com.example.womenentrepreneur.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class InvestorAdapter extends RecyclerView.Adapter<InvestorAdapter.LeadData>{

    List<InvestorModel> dataholder2;






    AlertDialog.Builder builder ;



    Context context;
    final String sharedPreferencesFileTitle = "ecoview";
    public InvestorAdapter(List<InvestorModel> dataholder2, Context context) {
        this.dataholder2 = dataholder2;
        this.context = context;

    }


    public void setFilteredList(List<InvestorModel> filteredList) {
        Log.println(Log.DEBUG,"debug", "Finally"+filteredList);
        this.dataholder2 = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public LeadData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        init();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.investorcard  ,parent,false);
        return new LeadData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadData holder, int position) {


//        holder.name.setText(dataholder2.get(position).getName());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(
                        context,R.style.BottomSheetDialogTheme
                );

                View bottomSheetView = LayoutInflater.from(context)
                        .inflate(
                                R.layout.layout_bottom_sheet_investor, holder.bottomsheet
                        );



//
//                RecyclerView recyclerView = bottomSheetView.findViewById(R.id.sevices);
//
//
//                List<InvestorModel> data_list;
//                MentorServicesAdpter pageInfoAdapter;
//                LinearLayoutManager layoutManager;
//
//                layoutManager = new LinearLayoutManager(context);
//
//                layoutManager.setOrientation(RecyclerView.VERTICAL);
//                recyclerView.setLayoutManager(layoutManager);
//
//
//                data_list = new ArrayList<>();
//                data_list.add(new InvestorModel());
//                data_list.add(new InvestorModel());
//                data_list.add(new InvestorModel());
//                data_list.add(new InvestorModel());
//                data_list.add(new InvestorModel());
//                data_list.add(new InvestorModel());
//
//                pageInfoAdapter = new MentorServicesAdpter(data_list, context);
//                recyclerView.setAdapter(pageInfoAdapter);








                bottomSheetDialog1.setContentView(bottomSheetView);
                bottomSheetDialog1.show();




            }
        });

    }




    @Override
    public int getItemCount() {
        return dataholder2.size();
    }


    class LeadData extends RecyclerView.ViewHolder
    {
        LinearLayout card;
        TextView name;
        LinearLayout bottomsheet;
        public LeadData(@NonNull View itemView)
        {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            bottomsheet = itemView.findViewById(R.id.bottomsheetcontainer);
//            name = itemView.findViewById(R.id.med_name);

        }
    }



}
