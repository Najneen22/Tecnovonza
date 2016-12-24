package com.example.tailoredtech.tecnovanza.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tailoredtech.tecnovanza.R;

import java.util.ArrayList;

/**
 * Created by Daniyal on 12/24/2016.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.NavigationHolder> {

    private ArrayList<DrawerElements> drawerElements;
    private Context mContext;
    private LayoutInflater mInflator;

    public NavigationDrawerAdapter(Context mContext) {
        this.mContext = mContext;
        this.drawerElements = getNavigationElements();
        this.mInflator=LayoutInflater.from(mContext);
    }

    @Override
    public NavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflator.inflate(R.layout.list_item_drawer,parent,false);
        return new NavigationHolder(view);
    }

    @Override
    public void onBindViewHolder(NavigationHolder holder, int position) {
        holder.txtNavigationTitle.setText(drawerElements.get(position).getTitle());
        holder.imgNavigation.setImageResource(drawerElements.get(position).getImgId());
    }

    @Override
    public int getItemCount() {
        return drawerElements.size();
    }

    class NavigationHolder extends RecyclerView.ViewHolder {

        ImageView imgNavigation;
        TextView txtNavigationTitle;
        public NavigationHolder(View itemView) {
            super(itemView);
            imgNavigation= (ImageView) itemView.findViewById(R.id.img_navigation_item);
            txtNavigationTitle= (TextView) itemView.findViewById(R.id.txt_navigation_title);
        }
    }


    public enum DrawerElements {
        Share(R.mipmap.icon,"Share"), FeedBack(R.mipmap.icon,"Feedback");

        private int imgId;
        private String title;

        DrawerElements(int id,String title) {
            this.imgId=id;
            this.title=title;
        }

        public int getImgId() {
            return imgId;
        }

        public String getTitle() {
            return title;
        }
    }

    public ArrayList<DrawerElements> getNavigationElements() {

        ArrayList<DrawerElements> drawerElements = new ArrayList<>();
        drawerElements.add(DrawerElements.Share);
        drawerElements.add(DrawerElements.FeedBack);
        return drawerElements;
    }
}
