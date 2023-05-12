package com.example.myapplication.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ExternalInputDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_input_data);

        // получаем Intent, которое запустило наше активити <3
        Intent intent = getIntent();

        // а тут получаем строчку с нашим новым баром или клубом и выводим её на экран
        if(intent.getType().equals("text/plain")){
            String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView text_view_new_club_bar = findViewById(R.id.text_view_add_club_bar);
            text_view_new_club_bar.setText(sharedText);
        }
    }
}
