package com.example.anyfood.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Food.class}, version = 1, exportSchema = false)
public abstract class FoodDatabase extends RoomDatabase {

    private static final String DB_NAME = "food.db";
    private static FoodDatabase database;
    private static final Object LOCK = new Object(); //нужен для синхронизации потоков

    public static FoodDatabase getInstance(Context context) {
        synchronized (LOCK) { //синхронизация потоков
            if (database == null) {
                database = Room.databaseBuilder(context, FoodDatabase.class, DB_NAME).build();
            }
        }
        return database;
    }

    public abstract FoodDao foodDao();
}
