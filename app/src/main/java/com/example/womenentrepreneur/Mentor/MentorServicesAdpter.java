package com.example.womenentrepreneur.Mentor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.womenentrepreneur.Investor.InvestorModel;
import com.example.womenentrepreneur.R;

import java.util.List;


public class MentorServicesAdpter extends RecyclerView.Adapter<MentorServicesAdpter.LeadData>{

    List<InvestorModel> dataholder2;






    AlertDialog.Builder builder ;



    Context context;
    final String sharedPreferencesFileTitle = "ecoview";
    public MentorServicesAdpter(List<InvestorModel> dataholder2, Context context) {
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mentorservice  ,parent,false);
        return new LeadData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadData holder, int position) {


//        holder.name.setText(dataholder2.get(position).getName());
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,AllPagesStatus.class);
//                context.startActivity(intent);
//            }
//        });

    }




    @Override
    public int getItemCount() {
        return dataholder2.size();
    }


    class LeadData extends RecyclerView.ViewHolder
    {
        LinearLayout card;
        TextView name;
        public LeadData(@NonNull View itemView)
        {
            super(itemView);
            card = itemView.findViewById(R.id.card);
//            name = itemView.findViewById(R.id.med_name);

        }
    }



}
