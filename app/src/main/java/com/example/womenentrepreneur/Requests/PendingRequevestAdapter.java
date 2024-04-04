package com.example.womenentrepreneur.Requests;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.womenentrepreneur.Investor.InvestorModel;
import com.example.womenentrepreneur.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;


public class PendingRequevestAdapter extends RecyclerView.Adapter<PendingRequevestAdapter.LeadData>{

    List<InvestorModel> dataholder2;






    AlertDialog.Builder builder ;



    Context context;
    final String sharedPreferencesFileTitle = "ecoview";
    public PendingRequevestAdapter(List<InvestorModel> dataholder2, Context context) {
        this.dataholder2 = dataholder2;
        this.context = context;
//        Toast.makeText(context, "Came here", Toast.LENGTH_SHORT).show();

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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pendingrequvest  ,parent,false);
        return new LeadData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadData holder, int position) {


//        holder.name.setText(dataholder2.get(position).getName());


        holder.success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Came inside", Toast.LENGTH_SHORT).show();
            }
        });

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();


                final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(
                        context,R.style.BottomSheetDialogTheme
                );

                View bottomSheetView = LayoutInflater.from(context)
                        .inflate(
                                R.layout.layout_bottom_sheet_pendingreqvest, holder.bottomsheet
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
        CardView item_parent;
        ImageView success;
        public LeadData(@NonNull View itemView)
        {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            bottomsheet = itemView.findViewById(R.id.bottomsheetcontainer);
//            item_parent = itemView.findViewById(R.id.item_parent);
//            name = itemView.findViewById(R.id.med_name);
            success = itemView.findViewById(R.id.success);

        }
    }



}
