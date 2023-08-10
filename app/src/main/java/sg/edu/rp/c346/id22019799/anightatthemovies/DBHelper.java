package sg.edu.rp.c346.id22019799.anightatthemovies;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;



public class DBHelper extends SQLiteOpenHelper {
    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 2;
    // Filename of the database
    private static final String DATABASE_NAME = "movie.db";

    private static final String TABLE_MOVIE = "movie";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_RATING = "rating";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_MOVIE +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_GENRE + " TEXT,"
                + COLUMN_YEAR + " TEXT,"
                + COLUMN_RATING + " TEXT)";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        db.execSQL("ALTER TABLE " + TABLE_MOVIE + " ADD COLUMN  module_name TEXT ");
        //onCreate(db); // Delete as table already created


    }


    public void insertMovie(String title, String genre,int year,String rating){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_TITLE, title);
        // Store the column name as key and the date as value
        values.put(COLUMN_GENRE, genre);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_RATING, rating);
        // Insert the row into the TABLE_SONG
        db.insert(TABLE_MOVIE, null, values);
        // Close the database connection
        db.close();
    }

    public ArrayList<String> getTaskContent() {
        // Create an ArrayList that holds String objects
        ArrayList<String> tasks = new ArrayList<String>();
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE,COLUMN_YEAR,COLUMN_RATING};
        // Run the query and get back the Cursor object
        Cursor cursor = db.query(TABLE_MOVIE, columns, null, null, null, null, null, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String genre = cursor.getString(2);
                int year = cursor.getInt(3);
                String rating = cursor.getString(4);
                Movie obj = new Movie(id, title, genre, year, rating);
                tasks.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return tasks;
    }

    public ArrayList<Movie> getTasks() {
        ArrayList<Movie> tasks = new ArrayList<Movie>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIE, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String genre = cursor.getString(2);
                int year = cursor.getInt(3);
                String rating = cursor.getString(4);
                Movie obj = new Movie(id,title, genre, year, rating);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }
    public ArrayList<Movie> getTasks(String keyword) {
        ArrayList<Movie> tasks = new ArrayList<Movie>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIE, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String genre = cursor.getString(2);
                int year = cursor.getInt(3);
                String rating = cursor.getString(4);
                Movie obj = new Movie(id,title, genre, year, rating);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }





}

