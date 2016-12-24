package com.example.tailoredtech.tecnovanza.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoredtech.tecnovanza.R;
import com.example.tailoredtech.tecnovanza.adapter.NewsAdapter;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        RecyclerView newsRecycler = (RecyclerView) view.findViewById(R.id.news_list);

        NewsAdapter adapter = new NewsAdapter(new ArrayList<String>());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        newsRecycler.setLayoutManager(manager);
        newsRecycler.setAdapter(adapter);

        return view;
    }

}
