package com.example.sectionrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionrecyclerview.databinding.ItemRowBinding;
import com.example.sectionrecyclerview.databinding.ItemRowTwoBinding;
import com.example.sectionrecyclerview.databinding.SectionRowBinding;

import java.util.List;

public class CiledRecyclarAdapter extends RecyclerView.Adapter {
    List<String> items;

    public CiledRecyclarAdapter(List<String> items) {
        this.items = items;
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position).toLowerCase().contains("one")) {
            return 0;
        } else

            return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        //= layoutInflater.inflate(R.layout.item_row,parent,false);
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.item_row, parent, false);
            return new ViewHolderee(ItemRowBinding.bind(view));
        }
        view = layoutInflater.inflate(R.layout.item_row_two, parent, false);
        return new ViewHoldarTwo(ItemRowTwoBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (items.get(position).toLowerCase().contains("one")) {
            ViewHolderee viewHolderee = (ViewHolderee) holder;
            ((ViewHolderee) holder).itemRowBinding.tvItameName.setText(items.get(position));

        } else { ViewHoldarTwo viewHoldarTwo = (ViewHoldarTwo) holder;
            ((ViewHoldarTwo) holder).itemRowTwoBinding.tvItemTwo.setText(items.get(position));
        }
        //bind ViewHoldarTwo


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolderee extends RecyclerView.ViewHolder {
        ItemRowBinding itemRowBinding;

        public ViewHolderee(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }
    }

    public class ViewHoldarTwo extends RecyclerView.ViewHolder {
        ItemRowTwoBinding itemRowTwoBinding;

        public ViewHoldarTwo(ItemRowTwoBinding itemRowTwoBinding) {
            super(itemRowTwoBinding.getRoot());
            this.itemRowTwoBinding = itemRowTwoBinding;
        }

    }
}
