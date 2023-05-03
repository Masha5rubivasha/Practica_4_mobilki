package com.example.myapplication.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.model.ClubModel;
import com.example.myapplication.data.model.SongModel;
import com.example.myapplication.data.repository.SongRepository;
import com.example.myapplication.data.sources.ClubDataSource;
import com.example.myapplication.data.sources.SongDataSource;

import java.util.Random;

public class SongViewModel extends ViewModel {

    private final MutableLiveData<SongRepository> repository; // LiveData

    public SongViewModel(){
        repository = new MutableLiveData<>(new SongRepository(0));
    }
    public LiveData<SongRepository> getSong(){
        return repository;
    }

    public void rollSong(){
        Random random = new Random();
        int randInt = random.nextInt(2);
        repository.setValue(
                new SongRepository(randInt)
        );
    }
    public String getName(){
        return repository.getValue().getSong();
    }
}