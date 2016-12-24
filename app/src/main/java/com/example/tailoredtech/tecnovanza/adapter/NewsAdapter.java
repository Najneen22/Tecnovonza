package com.example.tailoredtech.tecnovanza.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tailoredtech.tecnovanza.R;
import com.example.tailoredtech.tecnovanza.model.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Najneen on 12/24/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    ArrayList<News> newsList;
    private Context mContext;

    public NewsAdapter(Context context,ArrayList<News> list) {
        this.newsList = list;
        this.mContext=context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News news=newsList.get(position);
        holder.txtVereName.setText(news.getName());
        holder.txtVerNo.setText(news.getCity());
        holder.txtDate.setText(news.getTime());
        holder.txtDesc.setText(news.getDescription());
        holder.txtLatestReleaseVer.setText(news.getComments());
        Picasso.with(mContext).load(news.getImg()).placeholder(R.mipmap.placeholder).into(holder.bImage);
        Picasso.with(mContext).load(news.getPimg()).placeholder(R.mipmap.placeholder).into(holder.sImage);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        private ImageView sImage,bImage;
        private TextView txtVereName,txtVerNo,txtDate,txtLatestReleaseVer,txtDesc;

        public NewsViewHolder(View itemView) {
            super(itemView);
            sImage= (ImageView) itemView.findViewById(R.id.img_s_news);
            bImage= (ImageView) itemView.findViewById(R.id.img_b_image);
            txtVereName= (TextView) itemView.findViewById(R.id.txt_ver_name);
            txtVerNo= (TextView) itemView.findViewById(R.id.txt_ver_no);
            txtDate= (TextView) itemView.findViewById(R.id.txt_date);
            txtLatestReleaseVer= (TextView) itemView.findViewById(R.id.txt_latest_release_ver);
            txtDesc= (TextView) itemView.findViewById(R.id.txt_description);
        }
    }
}
