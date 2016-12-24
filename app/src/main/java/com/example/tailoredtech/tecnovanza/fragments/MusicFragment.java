package com.example.tailoredtech.tecnovanza.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tailoredtech.tecnovanza.R;

import java.util.ArrayList;

public class MusicFragment extends Fragment {

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        // Spinner Drop down elements
        ArrayList<String> categories = new ArrayList<String>();
        categories.add(getString(R.string.txt_game));
        categories.add(getString(R.string.txt_application));
        categories.add(getString(R.string.txt_movie));
        categories.add(getString(R.string.txt_books));

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        return view;
    }

}
