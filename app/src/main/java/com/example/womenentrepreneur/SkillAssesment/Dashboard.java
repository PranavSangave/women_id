package com.example.womenentrepreneur.SkillAssesment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.womenentrepreneur.Meetup.Meetups;
import com.example.womenentrepreneur.Meetup.NewGroupsAdapter;
import com.example.womenentrepreneur.Meetup.PopularNowAdapter;
import com.example.womenentrepreneur.R;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    RecyclerView newgroupsrecycler;
    LinearLayout choose;
    String datetime;

    private SkillAdapter newgrousadapter;
    LinearLayoutManager layoutManager;


    private ViewPager2 viewPager;
    private SliderAdapter sliderAdapter;
    private List<String> imageUrlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard4);



        newGroups();
        PopularNow();
        slider();








    }

    private void slider() {
        viewPager = findViewById(R.id.viewPager);
        imageUrlList = new ArrayList<>();
        imageUrlList.add("android.resource://" + getPackageName() + "/" + R.drawable.img); // Add your image URLs here
        imageUrlList.add("android.resource://" + getPackageName() + "/" + R.drawable.img_1); // Add your image URLs here

        imageUrlList.add("android.resource://" + getPackageName() + "/" + R.drawable.img_2); // Add your image URLs here

        imageUrlList.add("URL_2");
        // Add more URLs as needed

        sliderAdapter = new SliderAdapter(this, imageUrlList);
        viewPager.setAdapter(sliderAdapter);

        // Optionally, set orientation and other settings for the ViewPager2
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
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




        newgrousadapter = new SkillAdapter(data_list, this);
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




        SkillAdapter newgrousadapter = new SkillAdapter(data_list, this);
        newgroupsrecycler.setAdapter(newgrousadapter);




    }



}