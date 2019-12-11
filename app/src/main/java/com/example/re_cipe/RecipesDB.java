package com.example.re_cipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RecipesDB extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Recipes.db";
    public static final String TABLE_NAME = "favourites_table";
    public static final String ID = "recipe_id";
    public static final String IMAGE = "image_url";
    public static final String CONTENT = "content_url";
    public static final String DESCRIPTION = "description";

    public RecipesDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (recipe_id INTEGER PRIMARY KEY AUTOINCREMENT,image_url TEXT,content_url TEXT,description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertRecipe(String image, String content, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IMAGE, image);
        contentValues.put(CONTENT, content);
        contentValues.put(DESCRIPTION, description);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllRecipes() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_NAME, null);
        return result;
    }

    public boolean update(String id, String image, String content, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(IMAGE, image);
        contentValues.put(CONTENT, content);
        contentValues.put(DESCRIPTION, description);
        db.update(TABLE_NAME, contentValues, "recipe_id = ?", new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "recipe_id = ?", new String[] {id});
    }

}
