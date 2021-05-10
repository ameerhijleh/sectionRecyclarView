package com.example.sectionrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionrecyclerview.databinding.SectionRowBinding;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclarAdaptar extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List <Section> sectionList;

    public MainRecyclarAdaptar(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.section_row,parent,false);
         return new ViewHoldar(SectionRowBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        Section section = sectionList.get(position);
        String sectionName = section.getSectionName();
        List<String> items = section.getSectionItems();

        ViewHoldar viewHoldar = (ViewHoldar) holder;
        ((ViewHoldar) holder).sectionRowBinding.tvSectionName.setText(section.getSectionName());
        CiledRecyclarAdapter ciledRecyclarAdapter = new CiledRecyclarAdapter(items);
        ((ViewHoldar) holder).sectionRowBinding.rvItems.setAdapter(ciledRecyclarAdapter);


    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    public class ViewHoldar extends RecyclerView.ViewHolder{
        SectionRowBinding sectionRowBinding;

        public ViewHoldar(SectionRowBinding sectionRowBinding) {

            super(sectionRowBinding.getRoot());
            this.sectionRowBinding = sectionRowBinding;
        }
    }


}
