package com.dhytodev.datakemiskinan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.dhytodev.datakemiskinan.FormInputActivity;
import com.dhytodev.datakemiskinan.R;
import com.dhytodev.datakemiskinan.adapter.ListWargaAdapter;
import com.dhytodev.datakemiskinan.model.Warga;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private Toolbar toolbar;;
    private AppCompatActivity activity ;

    private ListView listView ;
    private FloatingActionButton fab ;

    private ListWargaAdapter adapter ;
    private List<Warga> listWarga;


    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_data, container, false);

        activity = (AppCompatActivity) getActivity();

        setupToolbar(rootView);

        listView = (ListView) rootView.findViewById(R.id.listview);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);

        listWarga = new ArrayList<>() ;
        listWarga = Warga.listAll(Warga.class);

        if (listWarga != null && listWarga.size() > 0) {
            adapter = new ListWargaAdapter(activity, listWarga);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(activity, "Belum ada data", Toast.LENGTH_SHORT).show();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, FormInputActivity.class);
                startActivity(i);
            }
        });

        return rootView ;
    }

    private void setupToolbar(View rootView){
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        if(toolbar != null) {

            activity.setSupportActionBar(toolbar);

        }
    }

}
