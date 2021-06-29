package com.dynnamicdevz.mvpretrofitsakuraapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dynnamicdevz.mvpretrofitdigimonapp.databinding.ActivityJikanItemDetailsBinding;
import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.JikanResult;

public class JikanItemDetails extends AppCompatActivity {

    private ActivityJikanItemDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityJikanItemDetailsBinding.inflate(
                getLayoutInflater()
        );
        setContentView(binding.getRoot());

        JikanResult jikanResult = getIntent().getParcelableExtra("ITEM_DATA");
        if(jikanResult != null){
            binding.titleTextview.setText(jikanResult.getTitle());
            binding.synopsisTextview.setText(jikanResult.getSynopsis());
        }

    }
}