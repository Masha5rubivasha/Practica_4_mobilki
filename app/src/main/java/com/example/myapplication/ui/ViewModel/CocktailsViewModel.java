package com.example.myapplication.ui.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.data.databases.entity.CocktailsEntity;
import com.example.myapplication.data.repository.CocktailsRepository;

import java.util.List;

public class CocktailsViewModel extends AndroidViewModel {
    private CocktailsRepository mRepository;
    private final LiveData<List<CocktailsEntity>> mAllCommonPerfumes;

    public CocktailsViewModel(Application application){
        super(application);
        mRepository = new CocktailsRepository(application);
        mAllCommonPerfumes = mRepository.getAllCocktails();
    }

    public LiveData<List<CocktailsEntity>> getAllCommonPerfumes(){ return mAllCommonPerfumes; }
    public void insert(CocktailsEntity perfume){
        mRepository.insert(perfume);
    }
}