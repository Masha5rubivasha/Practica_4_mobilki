package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class ThirdFragment extends Fragment {


    Button button_1;
    Button button_2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        button_1 = (Button) view.findViewById(R.id.button31);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment firstFragment = new FirstFragment();
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.Container, firstFragment)
                        .commit();
            }
        });

        button_2 = (Button) view.findViewById(R.id.button32);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SecondFragment secondFragment = new SecondFragment();
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.Container, secondFragment)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> store_items = new ArrayList<String>();

        for(int i = 1; i <= 200; i++){
            store_items.add("Клуб " + i);
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        MyAdapter2 recyclerViewAdapter = new MyAdapter2(getActivity(), store_items);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}