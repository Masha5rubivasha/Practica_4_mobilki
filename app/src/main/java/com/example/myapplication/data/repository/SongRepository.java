package com.example.myapplication.data.repository;

import com.example.myapplication.data.model.SongModel;
import com.example.myapplication.data.sources.SongDataSource;

public class SongRepository {

    private SongModel song;

    public SongRepository(int index){
        createSong(index);
    }

    public String getSong(){
        return song.getClubName();
    }

    public void createSong(int index){
        song = new SongModel(SongDataSource.getSongName(index));
    }

}
