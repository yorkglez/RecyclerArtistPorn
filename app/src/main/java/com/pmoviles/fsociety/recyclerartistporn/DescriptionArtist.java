package com.pmoviles.fsociety.recyclerartistporn;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionArtist extends AppCompatActivity {


    @BindView(R.id.txtTrajectory)
    TextView txtLife;
    @BindView(R.id.txtPhone)
    TextView txtPhone;
    @BindView(R.id.txtLocation)   // Pendiente
    TextView txtLocalizacion;
    @BindView(R.id.txtComments)   // Pendiente
    TextView txtComments;
    @BindView(R.id.collapser)
    CollapsingToolbarLayout collapser;
    @BindView(R.id.Toolbar)
    Toolbar toolbar;

    private  static Intent crearIntencion(Activity activity, Artist artist)
    {
        Intent i = new Intent(activity, DescriptionArtist.class);
        i.putExtra("nombre", artist.getName());     /// esto va a cambiar
        i.putExtra("vida",artist.getLife());
        i.putExtra("telefono", artist.getPhone());
        i.putExtra("latitud", artist.getLatitude());
        i.putExtra("altitud", artist.getAltitude());
        i.putExtra("comentarios", "asdasdasd");
        return i;
    }

    public static void crearInstancia(Activity activity, Artist artist){
        Intent i = crearIntencion(activity,artist);
        activity.startActivity(i);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_artist);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        collapser.setTitle(i.getStringExtra("nombre"));

        llenarVentana(i);

    }
    public void llenarVentana(Intent i) {   // quitar intencion
        txtLife.setText(i.getStringExtra("vida"));
        txtPhone.setText(i.getStringExtra("telefono"));
        txtLocalizacion.setText("A: " +
                i.getDoubleExtra("altitud", 0 ) +
                " L: " +
                i.getDoubleExtra("latitud", 0 ) );
        txtComments.setText(i.getStringExtra("comentarios"));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

}
