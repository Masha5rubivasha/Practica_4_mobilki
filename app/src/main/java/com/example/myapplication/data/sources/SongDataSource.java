package com.example.myapplication.data.sources;

public class SongDataSource {
    private static final String songsNames[] = {"Барбарики", "За деньги да"};

    public static String getSongName(int index) {
        return songsNames[index];
    }
}
