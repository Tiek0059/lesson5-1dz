package com.example.lesson5_1dz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.FragmentViewHolder> {
    List<String> list;

    public FragmentAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FragmentViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public FragmentViewHolder(@NonNull View itemView) {
            super(itemView);
            textView =  itemView.findViewById(R.id.item_textView);
        }
    }
}