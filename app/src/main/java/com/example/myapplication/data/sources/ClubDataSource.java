package com.example.myapplication.data.sources;

public class ClubDataSource {
    private static final String clubsNames[] = {"ЙУХ", "BIZY"};

    public static String getClubsName(int index) {
        return clubsNames[index];
    }
}
