package com.dhytodev.datakemiskinan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.dhytodev.datakemiskinan.adapter.ListWargaAdapter;
import com.dhytodev.datakemiskinan.model.Warga;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRIPOD STUDIO on 6/5/2016.
 */
public class DataActivity extends AppCompatActivity {
    private ListView listView ;
    private FloatingActionButton fab ;

    private ListWargaAdapter adapter ;
    private List<Warga> listWarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_data);

        listView = (ListView) findViewById(R.id.listview);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        listWarga = new ArrayList<>() ;
        listWarga = Warga.listAll(Warga.class);

        Log.d("size", String.valueOf(listWarga.size()));

        if (listWarga != null && listWarga.size() > 0) {
            adapter = new ListWargaAdapter(this, listWarga);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Belum ada data", Toast.LENGTH_SHORT).show();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DataActivity.this, FormInputActivity.class);
                startActivity(i);
            }
        });
    }
}
