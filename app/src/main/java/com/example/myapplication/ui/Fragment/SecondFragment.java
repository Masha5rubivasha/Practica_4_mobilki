package com.example.myapplication.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.data.databases.entity.CommonPerfumeEntity;
import com.example.myapplication.R;
import com.example.myapplication.ui.Adapter.MyCustomRecyclerViewAdapter;
import com.example.myapplication.ui.ViewModel.CommonPerfumeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondFragment extends Fragment {

    private CommonPerfumeViewModel mCommonPerfumeViewModel;

    Button button_1;
    Button button_3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener(NewPerfumeFragment.REPLY_PERFUME,
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                        String namePerfume = bundle.getString(NewPerfumeFragment.REPLY_NAME);
                        int pricePerfume = bundle.getInt(NewPerfumeFragment.REPLY_PRICE);

                        CommonPerfumeEntity word = new CommonPerfumeEntity(namePerfume, pricePerfume);
                        mCommonPerfumeViewModel.insert(word);
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);


        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_store);
        final MyCustomRecyclerViewAdapter adapter = new MyCustomRecyclerViewAdapter(new MyCustomRecyclerViewAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Летающая кнопочка
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_newPerfumeFragment);
            }
        });

        mCommonPerfumeViewModel = new ViewModelProvider(this).get(CommonPerfumeViewModel.class);

        mCommonPerfumeViewModel.getAllCommonPerfumes().observe(getActivity(), words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });

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
    }
}

