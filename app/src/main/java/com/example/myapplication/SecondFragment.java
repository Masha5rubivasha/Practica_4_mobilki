package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    Button button_1;
    Button button_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);


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

        button_1 = view.findViewById(R.id.button21);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment);
            }
        });

        button_3 = view.findViewById(R.id.button23);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), store_items.get(i), Toast.LENGTH_SHORT).show();
                Log.i("ListView", store_items.get(i));
            }
        });
    }
}

