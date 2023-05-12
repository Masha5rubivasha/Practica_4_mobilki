package com.example.myapplication.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.data.databases.entity.CocktailsEntity;

import java.util.List;

@Dao
public interface CocktailsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CocktailsEntity cocktail);

    @Query("DELETE FROM cocktails_database")
    void deleteAll();

    @Query("SELECT * FROM cocktails_database")
    LiveData<List<CocktailsEntity>> getAllCocktails();
}