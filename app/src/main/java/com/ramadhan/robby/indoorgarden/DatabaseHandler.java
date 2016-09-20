package com.ramadhan.robby.indoorgarden;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ramadhan.robby.indoorgarden.ui.activeListDetails.ListModules;
import com.ramadhan.robby.indoorgarden.model.Modules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 21/04/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "tanamanManager";

    private static final String TABLE_MODULES = "modules";

    private static final String ID_MODULES = "id";
    private static final String NAMA_MODULES = "nama";
    private static final String TANGGAL_MODULES = "tanggal";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_MODULES + " (" +
                ID_MODULES + " INTEGER PRIMARY KEY, " +
                NAMA_MODULES + " TEXT, " +
                TANGGAL_MODULES + " TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_MODULES);
        onCreate(db);
    }

    public void addTanaman(Modules tanaman){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAMA_MODULES, tanaman.getPlantName());
        values.put(TANGGAL_MODULES, tanaman.getPlantDate());

        db.insert(TABLE_MODULES, null, values);
        db.close();
    }

    public Modules[] readAllModules(){
        List<Modules> listModules = new ArrayList<Modules>();

        String selectQuery = "SELECT * FROM " + TABLE_MODULES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        ListModules.arrayModules.clear();

        if(cursor.moveToFirst()){
            do {
                Modules tanaman = new Modules(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                listModules.add(tanaman);
                ListModules.arrayModules.add(tanaman);
            } while (cursor.moveToNext());
        }
        db.close();
        return listModules.toArray(new Modules[listModules.size()]);
    }

    public void deleteTanaman(Modules tanaman){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MODULES, ID_MODULES + " = ?", new String[]{ String.valueOf(tanaman.getId()) });
        db.close();
    }
}
