package com.novalfakhri.android.jogjapedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    String jsonUrl;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListAdapter listAdapter;
    static ArrayList<Pariwisata> wisataList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Jogjapedia");
        listView = (ListView) findViewById(R.id.listView);

        Bundle bundle =  getIntent().getExtras();
        jsonUrl = bundle.getString("url");
        Log.d("myurl", jsonUrl);

        wisataList = new ArrayList<>();
        listAdapter = new ListAdapter(this, R.layout.item_list, wisataList);
        listView.setAdapter(listAdapter);


        try {
            jsonObject = new JSONObject(jsonUrl);
            jsonArray = jsonObject.getJSONArray("data");
            Log.d("jsonArray",jsonArray.toString());



            for (int i = 0; i < jsonArray.length();i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Pariwisata pariwisata = new Pariwisata();

                pariwisata.setNama(object.getString("nama_pariwisata"));
                pariwisata.setAlamat(object.getString("alamat_pariwisata"));
                pariwisata.setDetail(object.getString("detail_pariwisata"));
                pariwisata.setGambar(object.getString("gambar_pariwisata"));

                Log.d("nama pariwisata", pariwisata.getNama());
                Log.d("alamat pariwisata", pariwisata.getAlamat());
                Log.d("detail pariwisata", pariwisata.getDetail());
                listAdapter.add(pariwisata);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pariwisata pariwisata = wisataList.get(position);

                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("position", String.valueOf(position));
                intent.putExtra("gambar", pariwisata.getGambar());
                intent.putExtra("nama", pariwisata.getNama());
                intent.putExtra("alamat", pariwisata.getAlamat());
                intent.putExtra("detail", pariwisata.getDetail());
                startActivity(intent);
            }
        });
    }

}
