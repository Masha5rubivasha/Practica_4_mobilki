package com.example.myapplication.data.databases.roomDatabase;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.example.myapplication.data.databases.dao.CocktailsDao;
import com.example.myapplication.data.databases.entity.CocktailsEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {CocktailsEntity.class}, version = 1, exportSchema = false)
public abstract class CocktailsDatabase extends RoomDatabase {
    public abstract CocktailsDao cocktailDao();
    private static volatile CocktailsDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static CocktailsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CocktailsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CocktailsDatabase.class, "cocktails_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                CocktailsDao dao = INSTANCE.cocktailDao();
                dao.deleteAll();
                dao.insert(new CocktailsEntity("Lost Cherry",700));
                dao.insert(new CocktailsEntity("L.12.12",800));
            });
        }
    };
}