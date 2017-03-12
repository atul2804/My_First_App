package com.example.atul.basic;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.Settings.NameValueTable.NAME;
import static android.provider.Telephony.Mms.Part.TEXT;
import static java.sql.Types.INTEGER;

/**
 * Created by Atul on 05-10-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_name = "student.db";
    public static final String Table_name = "student_table";
    public static final String  Col_1 = "ID";
    public static final String Col_2 = "NAME";
    public static final String Col_3 = "SURNAME";
    public static final String Col_4 = "MARKS";
    public static final int version = 1;
    public DatabaseHelper(Context context) {
        super(context, Database_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + Table_name + "(" + Col_1 + "integer primary key ," + Col_2  + "text ," + Col_3 + "text ," + Col_4 + "text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists" + Table_name);
        onCreate(db);
    }

    public int insertData(String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(Col_2,name);
        contentvalues.put(Col_3,surname);
        contentvalues.put(Col_4,marks);
        int result = (int)db.insert(Table_name, null, contentvalues);
        if(result == -1)
            return 0;
        else
            return 1;
    }
}
