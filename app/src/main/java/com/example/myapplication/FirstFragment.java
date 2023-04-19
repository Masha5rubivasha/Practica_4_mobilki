package com.example.myapplication;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
public class FirstFragment extends Fragment {
    public FirstFragment(){
        super(R.layout.fragment_first);
    }

    Button button_2;
    Button button_3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_2 = view.findViewById(R.id.button2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });

        button_3 = view.findViewById(R.id.button3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_thirdFragment);
            }
        });
    }
}