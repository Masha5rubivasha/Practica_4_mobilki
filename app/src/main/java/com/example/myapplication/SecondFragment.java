package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {

    Button button_1;
    Button button_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        button_1 = (Button) view.findViewById(R.id.button21);
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

        button_3 = (Button) view.findViewById(R.id.button23);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThirdFragment thirdFragment = new ThirdFragment();
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.Container, thirdFragment)
                        .commit();
            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> store_items = new ArrayList<String>();
        for (int i = 1; i < 201; i++){
            store_items.add("Коктейль " + i);
        }

        MyAdapter listViewAdapter = new MyAdapter(
                getActivity(),R.layout.store_item, store_items);

        ListView listView = view.findViewById(R.id.list_view);
        listView.setAdapter(listViewAdapter);
    }
}

