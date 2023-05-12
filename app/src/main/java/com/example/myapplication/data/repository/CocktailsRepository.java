package com.example.myapplication.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.data.databases.dao.CocktailsDao;
import com.example.myapplication.data.databases.entity.CocktailsEntity;
import com.example.myapplication.data.databases.roomDatabase.CocktailsDatabase;

import java.util.List;

public class CocktailsRepository {
    private CocktailsDao mCocktailsDao;
    private LiveData<List<CocktailsEntity>> mAllCocktails;

    public CocktailsRepository(Application application){
        CocktailsDatabase db = CocktailsDatabase.getDatabase(application);
        mCocktailsDao = db.cocktailDao();
        mAllCocktails = mCocktailsDao.getAllCocktails();
    }

    public LiveData<List<CocktailsEntity>> getAllCocktails(){ return mAllCocktails; }

    public void insert(CocktailsEntity cocktail){
        CocktailsDatabase.databaseWriteExecutor.execute(() -> {
            mCocktailsDao.insert(cocktail);
        });
    }
}