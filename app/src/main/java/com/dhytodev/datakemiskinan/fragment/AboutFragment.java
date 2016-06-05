package com.dhytodev.datakemiskinan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhytodev.datakemiskinan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private Toolbar toolbar;;
    private AppCompatActivity activity ;


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        activity = (AppCompatActivity) getActivity();

        setupToolbar(rootView);

        return rootView ;
    }

    private void setupToolbar(View rootView){
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        if(toolbar != null) {

            activity.setSupportActionBar(toolbar);

        }
    }

}
