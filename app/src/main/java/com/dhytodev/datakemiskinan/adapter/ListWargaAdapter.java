package com.dhytodev.datakemiskinan.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dhytodev.datakemiskinan.R;
import com.dhytodev.datakemiskinan.model.Warga;

import java.util.List;

/**
 * Created by TRIPOD STUDIO on 6/4/2016.
 */
public class ListWargaAdapter extends BaseAdapter{
    private Activity activity ;
    private List<Warga> wargas ;


    public ListWargaAdapter(Activity activity, List<Warga> wargas) {
        this.activity = activity ;
        this.wargas = wargas ;
    }

    @Override
    public int getCount() {
        return wargas.size();
    }

    @Override
    public Object getItem(int position) {
        return wargas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null ;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.data_warga_row, null) ;
            holder = new ViewHolder();
            holder.txtNik = (TextView) convertView.findViewById(R.id.txtNik);
            holder.txtNama = (TextView) convertView.findViewById(R.id.txtNama);
            holder.txtKategori = (TextView) convertView.findViewById(R.id.txtKategori);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Warga warga = (Warga) getItem(position);
        holder.txtNik.setText(warga.getNik());
        holder.txtNama.setText(warga.getNama());
        holder.txtKategori.setText(warga.getKategori());


        return convertView;
    }

    static class ViewHolder {
        TextView txtNik ;
        TextView txtNama ;
        TextView txtKategori ;
    }
}
