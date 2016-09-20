package com.ramadhan.robby.indoorgarden.ui.activeListDetails;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.ramadhan.robby.indoorgarden.DatabaseHandler;
import com.ramadhan.robby.indoorgarden.R;
import com.ramadhan.robby.indoorgarden.model.Modules;
import com.ramadhan.robby.indoorgarden.ui.activeLists.AdapterTanaman;

import java.util.ArrayList;
import java.util.List;

public class ListModules extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static List<Modules> arrayModules = new ArrayList<Modules>();

    AdapterTanaman adapterModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_list_modules);

        /**
         * Setup toolbar
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.listToolbar);
        toolbar.setTitle("Add Your Modules");
        setSupportActionBar(toolbar);

        /**
         * Setup Navigation drawer
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerList);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /**
         * Setup Navigation View
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.list_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /**
         * Setup FloatingButton
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListModules.this);
                builder.setTitle("Add New Plant");
                builder.setItems(R.array.tanaman, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseHandler dbH = new DatabaseHandler(ListModules.this);
                        dbH.addTanaman(new Modules(which+1));
                        ListModules.this.updateData();
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        /**
         * cek modules list
         */
        DatabaseHandler dbH = new DatabaseHandler(this);
        Modules[] modules = dbH.readAllModules();
        if (modules.length == 0) {
            TextView noModules = (TextView) findViewById(R.id.noModulesText);
            noModules.setVisibility(View.VISIBLE);
        }

        /**
         * create list modules layout
         */
        ListView listModules = (ListView) findViewById(R.id.listModules);
        adapterModules = new AdapterTanaman(this, R.layout.nama_modules, modules);
        listModules.setAdapter(adapterModules);

        /**
         * put listener in modules, move to detail modules if the user click the list
         */
        listModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListModules.this, DetailModules.class);
                intent.putExtra("indeksModules", position);
                startActivity(intent);
            }
        });

        /**
         * cek modules list
         */
        listModules.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(ListModules.this);
                builder.setTitle("Modules" + " " + "Tanggal");
                builder.setItems(R.array.contextMenu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: {
                                Intent intent = new Intent(ListModules.this, DetailModules.class);
                                intent.putExtra("indeksModules", pos);
                                startActivity(intent);
                            }
                            break;
                            case 1:
                                break;
                            case 2: {
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(ListModules.this);
                                builder2.setTitle("Remove modules?");
                                builder2.setMessage("You will remove modules " + "Nama Modules" +
                                        " " + "Tanggal Module" + ". You will need to entry the modules code to acces the modules in the future");
                                builder2.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        DatabaseHandler dbH = new DatabaseHandler(ListModules.this);
                                        dbH.deleteTanaman(ListModules.arrayModules.get(pos));
                                        updateData();
                                    }
                                });
                                builder2.setNegativeButton("Cancel", null);
                                builder2.create().show();
                            }
                            break;
                        }
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_tanaman, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateData() {
        ListView listTanaman = (ListView) findViewById(R.id.listModules);
        listTanaman.invalidateViews();

        DatabaseHandler dbH = new DatabaseHandler(this);

        Modules[] tanamans = dbH.readAllModules();
        if (tanamans.length == 0) {
            TextView noPlant = (TextView) findViewById(R.id.noModulesText);
            noPlant.setVisibility(View.VISIBLE);
        } else {
            TextView noPlant = (TextView) findViewById(R.id.noModulesText);
            noPlant.setVisibility(View.INVISIBLE);
        }
        adapterModules = new AdapterTanaman(this, R.layout.nama_modules, tanamans);
        listTanaman.setAdapter(adapterModules);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int position = menuItem.getItemId();
        switch (position) {
            case R.id.nav_latestPlan: {
                Intent intent = new Intent(this, DetailModules.class);
                intent.putExtra("indeksTanaman", ListModules.arrayModules.size() - 1);
                startActivity(intent);
            }
            break;
            case R.id.nav_list: {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerList);
                drawer.closeDrawer(GravityCompat.START);
            }
            break;
            case R.id.nav_instruction: {
                Intent intent = new Intent(this, InstructionList.class);
                startActivity(intent);
            }
            break;
            case R.id.nav_settings:
                break;
        }
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        NavigationView navigationView = (NavigationView) findViewById(R.id.list_nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerList);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
