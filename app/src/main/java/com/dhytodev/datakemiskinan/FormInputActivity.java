package com.dhytodev.datakemiskinan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dhytodev.datakemiskinan.model.Warga;
import com.dhytodev.datakemiskinan.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by TRIPOD STUDIO on 6/4/2016.
 */
public class FormInputActivity extends AppCompatActivity {
    private Toolbar mToolbar;


    @Bind(R.id.edtNik) EditText edtNik ;
    @Bind(R.id.edtNama) EditText edtNama ;
    @Bind(R.id.edtAlamat) EditText edtAlamat ;
    @Bind(R.id.edtJmlhAnak) EditText edtJmlhAnak ;
    @Bind(R.id.edtPenghasilan) EditText edtPenghasilan ;
    @Bind(R.id.edtTagihan) EditText edtTagihan ;
    @Bind(R.id.btnSave) Button btnSave ;

    @Bind(R.id.title)
    TextView titleText ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleText.setText("Form Input");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = edtNik.getText().toString().trim();
                String nama = edtNama.getText().toString().trim();
                String alamat = edtAlamat.getText().toString().trim();
                String jumlah_anak = edtJmlhAnak.getText().toString().trim();
                String penghasilan = edtPenghasilan.getText().toString().trim();
                String tagihan = edtTagihan.getText().toString().trim();
                String kategori = null ;

                int nil_penghasilan = Integer.valueOf(penghasilan);
                int nil_anak = Integer.valueOf(jumlah_anak);
                int nil_tagihan = Integer.valueOf(tagihan);


                if (nil_penghasilan < 1000000) {
                    kategori = "Miskin" ;
                } else {
                    if (nil_penghasilan - ((nil_anak + 2) * 250000 + nil_tagihan) < 500000){
                        kategori = "Miskin";
                    } else {
                        kategori = "Kaya" ;
                    }
                }

                Warga warga = new Warga(Util.getNewId(),nik, nama, alamat, jumlah_anak, penghasilan, tagihan, kategori);
                warga.save();
                Intent i = new Intent(FormInputActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
