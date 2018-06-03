package com.pmoviles.fsociety.recyclerartistporn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView rView;

    //    provitional
    public static final List<Artist> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        //Provitional
        Artist ar = new Artist();
        ar.setName("SASHA GREY");
        ar.setPhone("8787837873");
        ar.setRating(5);
        ar.setLife("Artista que se dedica a escribir libros de ciencia y matematicas");
        ar.setAltitude(83.65);
        ar.setLatitude(-103.65);
        data.add(ar);
        ar = new Artist();
        ar.setName("MIA KHALIFA");
        ar.setPhone("555555555");
        ar.setRating(4.3);
        ar.setLife("Artistica / comentarista deportiva que no se le entiende");
        ar.setAltitude(83.65);
        ar.setLatitude(-103.65);
        data.add(ar);
        Log.e("DATA", "" + data);
        llenarRecycler();
    }

    public void llenarRecycler() {
        if (data != null) {
            RecyclerAdapter ar = new RecyclerAdapter(this, data);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            rView.setLayoutManager(llm);
            rView.setAdapter(ar);
        }
    }
}
