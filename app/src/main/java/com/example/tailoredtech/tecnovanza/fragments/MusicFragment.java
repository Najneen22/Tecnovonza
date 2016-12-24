package com.example.tailoredtech.tecnovanza.fragments;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
        spinner.getBackground().setColorFilter(ContextCompat.getColor(getActivity(),android.R.color.darker_gray), PorterDuff.Mode.SRC_ATOP);
        ImageButton btnPlay = (ImageButton) view.findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWarningAlertWithPositiveBtn();
            }
        });
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

    private void showWarningAlertWithPositiveBtn() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Google Music");
        builder.setMessage("The Best Music Player since last 5 years");

        String positiveText = "Dismiss";
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
}
