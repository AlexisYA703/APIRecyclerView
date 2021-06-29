package com.dynnamicdevz.mvpretrofitsakuraapp.model.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class JikanHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "jikan.db";
    public static int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Jikan";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_SYNOPSIS = "synopsis";
    public static final String COLUMN_RESULT_ID = "jikan_id";

    public JikanHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<JikanResult> getAllJikans() {
        List<JikanResult> results = new ArrayList<>();
        String getQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = getReadableDatabase().rawQuery(getQuery, null);
        cursor.move(-1);

        while (cursor.moveToNext()) {
            JikanResult result = new JikanResult(
                    cursor.getInt(cursor.getColumnIndex(COLUMN_RESULT_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_SYNOPSIS)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
            );
            results.add(result);
        }
        return results;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createCommand = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_RESULT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_SYNOPSIS + " TEXT)";
        sqLiteDatabase.execSQL(createCommand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String upgrade = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(upgrade);
        onCreate(sqLiteDatabase);
    }
}
