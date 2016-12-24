package com.example.tailoredtech.tecnovanza.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.tecnovanza.R;

import java.util.ArrayList;

/**
 * Created by Najneen on 12/24/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    ArrayList<String> newsList;

    public NewsAdapter(ArrayList<String> list) {
        this.newsList = list;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        public NewsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
