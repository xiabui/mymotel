package me.monla.mymotel.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import me.monla.mymotel.models.MotelModel;
import me.monla.mymotel.models.RoomModel;

public class RoomController extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MOTEL";

    // Table name: Note.
    private static final String TABLE_NAME = "ROOM";

    private static final String COLUMN_ROOM_ID = "id";
    private static final String COLUMN_ROOM_NAME ="name";
    private static final String COLUMN_LAST_ELECT = "lastElect";
    private static final String COLUMN_LAST_WATER = "lastWater";
    private static final String COLUMN_RENTED = "rented";

    public RoomController(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script.
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ROOM_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_ROOM_NAME + " TEXT, "
                + COLUMN_LAST_ELECT + " INTEGER, "
                + COLUMN_LAST_WATER + " INTEGER, "
                + COLUMN_RENTED + " BOOLEAN"
                + ")";
        // Execute Script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    public void addNew(RoomModel model) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NAME, model.getName());
        values.put(COLUMN_LAST_ELECT, model.getLastElectricNumber());
        values.put(COLUMN_LAST_WATER, model.getLastWaterNumber());
        values.put(COLUMN_RENTED, model.isRented());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);

        // Closing database connection
        db.close();
    }


    public RoomModel getByID(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {
                        COLUMN_ROOM_ID,
                        COLUMN_ROOM_NAME,
                        COLUMN_LAST_ELECT,
                        COLUMN_LAST_WATER,
                        COLUMN_RENTED
                }, COLUMN_ROOM_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        RoomModel model = new RoomModel(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                Boolean.parseBoolean(cursor.getString(4)));
        // return note
        return model;
    }


    public List<RoomModel> getAll() {

        List<RoomModel> roomList = new ArrayList<RoomModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomModel model = new RoomModel(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        Boolean.parseBoolean(cursor.getString(4))
                );
                roomList.add(model);
            } while (cursor.moveToNext());
        }

        // return note list
        return roomList;
    }

    public int getCount() {

        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }


    public int update(RoomModel model) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NAME, model.getName());
        values.put(COLUMN_LAST_ELECT, model.getLastElectricNumber());
        values.put(COLUMN_LAST_WATER, model.getLastWaterNumber());
        values.put(COLUMN_RENTED, model.isRented());

        // updating row
        return db.update(TABLE_NAME, values, COLUMN_ROOM_ID + " = ?",
                new String[]{String.valueOf(model.getId())});
    }

    public void deleteNote(RoomModel dan) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ROOM_ID + " = ?",
                new String[] { String.valueOf(dan.getId()) });
        db.close();
    }
}
