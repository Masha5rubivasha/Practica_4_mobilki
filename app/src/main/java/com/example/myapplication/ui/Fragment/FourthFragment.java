package com.example.myapplication.ui.Fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.ViewModel.ClubViewModel;

public class FourthFragment extends Fragment {

    ClubViewModel model;

    private Button bttnLuckyPerfume;
    private ImageView imagePerfume;
    private TextView textPerfume;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Searching elements
        bttnLuckyPerfume = view.findViewById(R.id.buttonGetLuckyPerfume);
        imagePerfume = view.findViewById(R.id.imageViewLuckyPerfume);
        textPerfume = view.findViewById(R.id.text_rolled_perfume);

        // Connecting to ViewModel
        model = new ViewModelProvider(this).get(ClubViewModel.class);
        model.getClub().observe(getViewLifecycleOwner(), luckyClub -> {
            textPerfume.setText(luckyClub.getClubName());
        });

        // Adding listener to button
        bttnLuckyPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.rollClub();
            }
        });
    }
}