package com.novalfakhri.android.jogjapedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView nama, alamat, detail;
    ImageView gambar;
    Toolbar toolbar;

    private ArrayList<Pariwisata> wisataListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        final String gambarWisata = intent.getStringExtra("gambar");
//        String namaWisata = intent.getStringExtra("nama");
        String alamatWisata = intent.getStringExtra("alamat");
        String detailWisata = intent.getStringExtra("detail");

        gambar = (ImageView)findViewById(R.id.detail_gambar);
//        nama = (TextView)findViewById(R.id.detail_nama);
        alamat = (TextView)findViewById(R.id.detail_alamat);
        detail = (TextView)findViewById(R.id.detail_deskripsi);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle(intent.getStringExtra("nama"));

        wisataListDetail =  new ArrayList<>(ListActivity.wisataList);

//        nama.setText(namaWisata);
        alamat.setText(alamatWisata);
        detail.setText(detailWisata);

        new LoadImageTask(gambar).execute(gambarWisata);
    }
}
