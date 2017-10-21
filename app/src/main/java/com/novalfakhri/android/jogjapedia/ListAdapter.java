package com.novalfakhri.android.jogjapedia;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by Toshiba on 8/9/2017.
 */

public class ListAdapter extends ArrayAdapter {
   private ArrayList<Pariwisata> wisataList;
    private LayoutInflater layoutInflater;
    private int res;


    public ListAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Pariwisata> objects) {
        super(context, resource, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        res = resource;
        wisataList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ListHolder listHolder;
        if(view == null){
            view = layoutInflater.inflate(res, null);
            listHolder = new ListHolder();
            listHolder.text_nama = (TextView) view.findViewById(R.id.list_nama);
            listHolder.text_alamat = (TextView) view.findViewById(R.id.list_alamat);
//            listHolder.text_detail = (TextView) view.findViewById(R.id.detail_deskripsi);
            listHolder.gambar = (ImageView) view.findViewById(R.id.list_gambar);
            view.setTag(listHolder);
        }else {
            listHolder = (ListHolder)view.getTag();
        }
        Pariwisata pariwisata = (Pariwisata) this.getItem(position);
        new LoadImageTask(listHolder.gambar).execute(wisataList.get(position).getGambar());

        listHolder.gambar.setImageResource(R.drawable.ic_launcher);
        listHolder.text_nama.setText(pariwisata.getNama());
        listHolder.text_alamat.setText(pariwisata.getAlamat());
//        listHolder.text_detail.setText(pariwisata.getDetail());

//        return super.getView(position, convertView, parent);
        return  view;
    }


    private class ListHolder{
        TextView text_nama, text_alamat, text_detail;
        ImageView gambar;
    }



}