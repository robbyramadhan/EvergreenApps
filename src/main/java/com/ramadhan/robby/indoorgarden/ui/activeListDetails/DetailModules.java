package com.ramadhan.robby.indoorgarden.ui.activeListDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.ramadhan.robby.indoorgarden.R;
import com.ramadhan.robby.indoorgarden.utils.Constants;

public class DetailModules extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public int pos;
    int panGel = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_detail_tanaman);

        /**
         * set Toolbar
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.detailToolbar);
        toolbar.setTitle("My Modules");
        setSupportActionBar(toolbar);

        /**
         * set navigation drawer
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerDetail);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /**
         * set Navigation View
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.detail_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /**
         * get modules indeks
         */
        Intent intent = getIntent();
        final int indeksModules = intent.getIntExtra("indeksModules",0);
        pos = indeksModules;

        /**
         * read Firebase reference
         */

        TextView namaTanaman = (TextView) findViewById(R.id.namaTanamanViewSpesifik);
        namaTanaman.setText(ListModules.arrayModules.get(indeksModules).getPlantName());

        /**
         * set namaModules and tanggalTanaman
         */

        TextView tanggalTanaman = (TextView) findViewById(R.id.tanggalTanamanSpesifik);
        tanggalTanaman.setText(ListModules.arrayModules.get(indeksModules).getPlantDate());

        /**
         * get sensor record inside each variable then put inside each row in the layout
         */

        // Get a reference to our posts
        Firebase pHRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_PH);

        pHRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ph = dataSnapshot.getValue(String.class);
                TextView namaModules = (TextView) findViewById(R.id.pH);
                namaModules.setText(ph);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase ECRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_EC);

        ECRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ec = dataSnapshot.getValue(String.class);
                TextView namaModules = (TextView) findViewById(R.id.EC);
                namaModules.setText(ec);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase airTRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_AIR_TEMPERATURE);

        airTRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String airt = dataSnapshot.getValue(String.class);
                TextView namaModules = (TextView) findViewById(R.id.airTemperature);
                namaModules.setText(airt);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase solTRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIQUID_TEMPERATURE);

        solTRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String solt = dataSnapshot.getValue(String.class);
                TextView namaModules = (TextView) findViewById(R.id.solutionTemperature);
                namaModules.setText(solt);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase airHRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_HUMIDITY);

        pHRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String hum = dataSnapshot.getValue(String.class);
                TextView namaModules = (TextView) findViewById(R.id.airHumidity);
                namaModules.setText(hum);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase lightIRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIGHT_INTENSITY);

        pHRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String lighti = dataSnapshot.getValue(String.class);
                TextView namaModules = (TextView) findViewById(R.id.lightIntensity);
                namaModules.setText(lighti);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        FloatingActionButton fabSync = (FloatingActionButton) findViewById(R.id.fabsync);
        fabSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableInternet();
            }
        });

        int gambar;
            switch(ListModules.arrayModules.get(indeksModules).getPlantName()){
            case "Lettuce" : gambar = R.drawable.lettuce; break;
            case "Cabbage" : gambar = R.drawable.cabbage; break;
            case "Basella" : gambar = R.drawable.basella; break;
            case "Custom"  : gambar = R.drawable.bunga_hati; break;
            default: gambar = R.drawable.cabbage;
        }

        ImageView gambarTanaman = (ImageView) findViewById(R.id.gambarSpesifikTanaman);
        gambarTanaman.setImageResource(gambar);
        gambarTanaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoInstruction = new Intent(DetailModules.this, InstruksiDetail.class);
                gotoInstruction.putExtra("namaTanaman", ListModules.arrayModules.get(indeksModules).getPlantName().toLowerCase());
                startActivity(gotoInstruction);
            }
        });

        /**
         * choose spesific wave length for each plant
         */
        int panjangGelombang;
        switch(indeksModules){
            case 0: panjangGelombang = 661; break; //460
            case 1: panjangGelombang = 530; break;
            case 2: panjangGelombang = 660; break;
            default: panjangGelombang = 640;
        }

        panGel = panjangGelombang;
        TextView lampu = (TextView) findViewById(R.id.lightIntensity);
        lampu.setText(panjangGelombang + "");

    }

    /**
     * navigation selecetion
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int position = menuItem.getItemId();
        switch (position){
            case R.id.nav_latestPlan : {
                if(pos != ListModules.arrayModules.size() - 1) {
                    Intent intent = new Intent(this, DetailModules.class);
                    intent.putExtra("indeksTanaman", ListModules.arrayModules.size() - 1);
                    startActivity(intent);
                } else {
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerDetail);
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
            break;
            case R.id.nav_list : {
                Intent intent = new Intent(this, ListModules.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
            break;
            case R.id.nav_instruction : {
                Intent intent = new Intent(this, InstructionList.class);
                startActivity(intent);
            }
            break;
            case R.id.nav_settings : break;
        }
        return true;
    }

    @Override
    public void onStart(){
        super.onStart();
        NavigationView navigationView = (NavigationView) findViewById(R.id.detail_nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerDetail);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void enableInternet(){
        /*turn on internet access, and what happen if can't connect to the internet */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
