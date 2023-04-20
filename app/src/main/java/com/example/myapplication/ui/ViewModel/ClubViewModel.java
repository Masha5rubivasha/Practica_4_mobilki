package com.example.myapplication.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.sources.ClubDataSource;
import com.example.myapplication.data.model.ClubModel;

import java.util.Random;

public class ClubViewModel extends ViewModel {

    private final MutableLiveData<ClubModel> luckyClub; // LiveData

    public ClubViewModel(){
        luckyClub = new MutableLiveData<>(new ClubModel(null));
    }


    public LiveData<ClubModel> getClub(){
        return luckyClub;
    }

    public void rollClub(){
        Random random = new Random();
        int randInt = random.nextInt(2);
        luckyClub.setValue(
                new ClubModel(ClubDataSource.getClubsName(randInt))
        );
    }
}