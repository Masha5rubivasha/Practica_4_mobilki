package com.example.myapplication.ui.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;


import com.example.myapplication.data.databases.entity.CocktailsEntity;

public class MyCustomRecyclerViewAdapter extends ListAdapter<CocktailsEntity, CocktailsViewHolder> {

    public MyCustomRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<CocktailsEntity> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CocktailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CocktailsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CocktailsViewHolder holder, int position) {
        CocktailsEntity current = getItem(position);
        holder.bind(current.getName(), current.getPrice());
    }
    public static class WordDiff extends DiffUtil.ItemCallback<CocktailsEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull CocktailsEntity oldItem, @NonNull CocktailsEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CocktailsEntity oldItem, @NonNull CocktailsEntity newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}