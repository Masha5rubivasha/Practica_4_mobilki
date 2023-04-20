package com.example.myapplication.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.model.ClubModel;
import com.example.myapplication.data.model.SongModel;
import com.example.myapplication.data.sources.ClubDataSource;
import com.example.myapplication.data.sources.SongDataSource;

import java.util.Random;

public class SongViewModel extends ViewModel {

    private final MutableLiveData<SongModel> luckySong; // LiveData

    public SongViewModel(){
        luckySong = new MutableLiveData<>(new SongModel(null));
    }


    public LiveData<SongModel> getSong(){
        return luckySong;
    }

    public void rollSong(){
        Random random = new Random();
        int randInt = random.nextInt(2);
        luckySong.setValue(
                new SongModel(SongDataSource.getSongName(randInt))
        );
    }
}