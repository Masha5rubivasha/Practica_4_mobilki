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
    void insert(CocktailsEntity perfume);

    @Query("DELETE FROM common_perfume_table")
    void deleteAll();

    @Query("SELECT * FROM common_perfume_table")
    LiveData<List<CocktailsEntity>> getAllCommonPerfumes();
}