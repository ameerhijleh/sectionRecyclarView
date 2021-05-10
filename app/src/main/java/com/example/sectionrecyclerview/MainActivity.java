package com.example.sectionrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.util.Log;

import com.example.sectionrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Section> sectionList = new ArrayList<>();
    ActivityMainBinding activityMainBinding ;
    MainRecyclarAdaptar mainRecyclarAdaptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        initData();
        activityMainBinding.rvMain.setAdapter(mainRecyclarAdaptar);

     }
    private void initData(){
        String sectionOneName = "sectionOne";
        List<String> sectionOneItems = new ArrayList<>();
        sectionOneItems.add("one");
        sectionOneItems.add("two");

        String sectionTwoName = "sectionTwo";
        List<String> sectionTwoItems = new ArrayList<>();
        sectionTwoItems.add("one");
        sectionTwoItems.add("two");

        String sectionTreeName = "sectionThree";
        List<String> sectionTreeItems = new ArrayList<>();
        sectionTreeItems.add("one");
        sectionTreeItems.add("two");

        String sectionForeName = "sectionFore";
        List<String> sectionForeItems = new ArrayList<>();

        sectionForeItems.add("one");
        sectionForeItems.add("two");
        sectionList.add (new Section(sectionOneName , sectionOneItems) );
        sectionList.add (new Section(sectionTwoName , sectionTwoItems) );
        sectionList.add (new Section(sectionTreeName , sectionTreeItems) );
        sectionList.add (new Section(sectionForeName , sectionForeItems) );

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        activityMainBinding.rvMain .addItemDecoration(dividerItemDecoration);

        mainRecyclarAdaptar = new MainRecyclarAdaptar(sectionList);

    }
}