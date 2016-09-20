package com.ramadhan.robby.indoorgarden.ui.activeLists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramadhan.robby.indoorgarden.R;
import com.ramadhan.robby.indoorgarden.model.Modules;

/**
 * Created by Asus on 21/04/2016.
 */
public class AdapterTanaman extends ArrayAdapter {
    public AdapterTanaman(Context context, int resource, Modules[] tanaman){
        super(context, resource, tanaman);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.nama_modules, null);
        }

        Modules tanaman1 = (Modules)getItem(position);

        TextView nomorTanaman = (TextView) v.findViewById(R.id.nomorTanaman);
        String posisi = String.valueOf(position+1);
        nomorTanaman.setText(posisi);

        TextView detailTanaman = (TextView) v.findViewById(R.id.namaTanaman);
        String detail = tanaman1.getPlantName();
        detailTanaman.setText(detail);

        TextView tanggalTanaman = (TextView) v.findViewById(R.id.tanggalTanaman);
        tanggalTanaman.setText(tanaman1.getPlantDate());

        ImageView gambarTanaman = (ImageView) v.findViewById(R.id.gambarTanaman);
        int gambar;
        switch(tanaman1.getPlantName()){
            case "LETTUCE" : gambar = R.drawable.lettuce; break;
            case "CABBAGE" : gambar = R.drawable.cabbage; break;
            case "BASELLA" : gambar = R.drawable.basella; break;
            default: gambar = R.drawable.cabbage;
        }
        gambarTanaman.setImageResource(gambar);

        return v;
    }

}
