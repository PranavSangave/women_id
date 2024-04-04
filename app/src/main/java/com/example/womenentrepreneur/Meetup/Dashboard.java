package com.example.womenentrepreneur.Meetup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.womenentrepreneur.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    RecyclerView newgroupsrecycler;
    LinearLayout choose;
    String datetime;

    private NewGroupsAdapter newgrousadapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        choose  = findViewById(R.id.choose);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendor();
            }
        });



        newGroups();
        PopularNow();




    }

    private void openCalendor() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new DatePickerDialog instance
        DatePickerDialog datePickerDialog = new DatePickerDialog(Dashboard.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Update selectedDateTextView when a date is selected

                        datetime =dayOfMonth + "/" + (month + 1) + "/" + year;
//                        selectedDateTextView.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);

        // Show the date picker dialog
        datePickerDialog.show();



    }

    public void newGroups()
    {
        List<Meetups> data_list;
        newgroupsrecycler = findViewById(R.id.newgroupsrecycler);
        layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();

        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());
        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());




        newgrousadapter = new NewGroupsAdapter(data_list, this);
        newgroupsrecycler.setAdapter(newgrousadapter);




    }

    public void PopularNow()
    {
        List<Meetups> data_list;
        RecyclerView newgroupsrecycler = findViewById(R.id.popularnow);
        layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);


        data_list = new ArrayList<>();

        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());
        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());




        PopularNowAdapter newgrousadapter = new PopularNowAdapter(data_list, this);
        newgroupsrecycler.setAdapter(newgrousadapter);




    }


    public void newGroups1()
    {

        newgroupsrecycler = findViewById(R.id.newgroupsrecycler);
        layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newgroupsrecycler.setLayoutManager(layoutManager);

        List<Meetups> data_list;
        data_list = new ArrayList<>();

        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());
        data_list.add(new Meetups());
        data_list.add(new Meetups());

        data_list.add(new Meetups());




        newgrousadapter = new NewGroupsAdapter(data_list, this);
        newgroupsrecycler.setAdapter(newgrousadapter);




    }


}