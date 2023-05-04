package com.example.myapplication.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.data.databases.dao.CocktailsDao;
import com.example.myapplication.data.databases.entity.CocktailsEntity;
import com.example.myapplication.data.databases.roomDatabase.CocktailsDatabase;

import java.util.List;

public class CocktailsRepository {
    private CocktailsDao mCocktailsDao;
    private LiveData<List<CocktailsEntity>> mAllCommonPerfumes;

    public CocktailsRepository(Application application){
        CocktailsDatabase db = CocktailsDatabase.getDatabase(application);
        mCocktailsDao = db.commonPerfumeDao();
        mAllCommonPerfumes = mCocktailsDao.getAllCommonPerfumes();
    }

    public LiveData<List<CocktailsEntity>> getAllCommonPerfumes(){ return mAllCommonPerfumes; }

    public void insert(CocktailsEntity commonPerfume){
        CocktailsDatabase.databaseWriteExecutor.execute(() -> {
            mCocktailsDao.insert(commonPerfume);
        });
    }
}