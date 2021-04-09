package me.monla.mymotel.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.monla.mymotel.models.MotelModel;

public class MotelController extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MOTEL";

    // Table name: Note.
    private static final String TABLE_NAME = "MOTEL_INFO";

    private static final String COLUMN_MOTEL_ID = "id";
    private static final String COLUMN_MOTEL_NAME ="name";
    private static final String COLUMN_NUMBER_ROOM = "number_room";
    private static final String COLUMN_ROOM_COST = "room_cost";
    private static final String COLUMN_ELECTRIC_COST ="electric_cost";
    private static final String COLUMN_WATER_COST = "water_cost";
    private static final String COLUMN_SERVICES_COST = "service_cost";
    private static final String COLUMN_RENTED_ROOM = "rented_room";
    private static final String COLUMN_PAYMENT_ROOM = "payment_room";

    public MotelController(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script.
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_MOTEL_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_MOTEL_NAME + " TEXT, "
                + COLUMN_NUMBER_ROOM + " INTEGER, "
                + COLUMN_ROOM_COST + " INTEGER, "
                + COLUMN_ELECTRIC_COST + " INTEGER, "
                + COLUMN_WATER_COST + " INTEGER, "
                + COLUMN_SERVICES_COST + " INTEGER, "
                + COLUMN_RENTED_ROOM + " INTEGER, "
                + COLUMN_PAYMENT_ROOM + " INTEGER"
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


    public void addNew(MotelModel model) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MOTEL_NAME, model.getMotelName());
        values.put(COLUMN_NUMBER_ROOM, model.getNumberOfRoom());
        values.put(COLUMN_ROOM_COST, model.getRoomCost());
        values.put(COLUMN_ELECTRIC_COST, model.getElectricCost());
        values.put(COLUMN_WATER_COST, model.getWaterCost());
        values.put(COLUMN_SERVICES_COST, model.getServiceCost());
        values.put(COLUMN_RENTED_ROOM, model.getRentedRoom());
        values.put(COLUMN_PAYMENT_ROOM, model.getPaymentRoom());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);

        // Closing database connection
        db.close();
    }


    public MotelModel getByID(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {
                        COLUMN_MOTEL_ID,
                        COLUMN_MOTEL_NAME,
                        COLUMN_NUMBER_ROOM,
                        COLUMN_ROOM_COST,
                        COLUMN_ELECTRIC_COST,
                        COLUMN_WATER_COST,
                        COLUMN_SERVICES_COST,
                        COLUMN_RENTED_ROOM,
                        COLUMN_PAYMENT_ROOM
                }, COLUMN_MOTEL_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MotelModel model = new MotelModel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)),
                Integer.parseInt(cursor.getString(8)));
        // return note
        return model;
    }


//    public List<NguoiDan> getAll() {
//
//        List<NguoiDan> danList = new ArrayList<NguoiDan>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_PEOPLE;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                NguoiDan dan = new NguoiDan(
//                        Integer.parseInt(cursor.getString(0)),
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        cursor.getString(3)
//                );
//                danList.add(dan);
//            } while (cursor.moveToNext());
//        }
//
//        // return note list
//        return danList;
//    }

    public int getCount() {

        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }


    public int update(MotelModel model) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MOTEL_NAME, model.getMotelName());
        values.put(COLUMN_NUMBER_ROOM, model.getNumberOfRoom());
        values.put(COLUMN_ROOM_COST, model.getRoomCost());
        values.put(COLUMN_ELECTRIC_COST, model.getElectricCost());
        values.put(COLUMN_WATER_COST, model.getWaterCost());
        values.put(COLUMN_SERVICES_COST, model.getServiceCost());
        values.put(COLUMN_RENTED_ROOM, model.getRentedRoom());
        values.put(COLUMN_PAYMENT_ROOM, model.getPaymentRoom());

        // updating row
        return db.update(TABLE_NAME, values, COLUMN_MOTEL_ID + " = ?",
                new String[]{String.valueOf(model.getId())});
    }

    public void deleteNote(MotelModel dan) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_MOTEL_ID + " = ?",
                new String[] { String.valueOf(dan.getId()) });
        db.close();
    }

}