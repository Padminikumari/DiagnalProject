package com.example.diagnal_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridviewAdapter extends RecyclerView.Adapter<GridviewAdapter.HomeView> {

    ArrayList<Model> list;

    public GridviewAdapter(ArrayList<Model> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public HomeView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, null);
        return new HomeView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeView holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.imageView.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class HomeView extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public HomeView(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name_textview);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}