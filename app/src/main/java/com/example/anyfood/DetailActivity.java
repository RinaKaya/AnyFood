package com.example.anyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewThumbDetail;
    private TextView textViewCaloriesDetail;
    private TextView textViewDifficultyDetail;
    private TextView textViewNameDetail;
    private TextView textViewHeadlineDetail;
    private TextView textViewDescriptionDetail;
    private TextView textViewCarbos;
    private TextView textViewProteins;
    private TextView textViewFats;
    private TextView textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewThumbDetail = findViewById(R.id.imageViewThumbDetail);
        textViewCaloriesDetail = findViewById(R.id.textViewCaloriesDetail);
        textViewDifficultyDetail = findViewById(R.id.textViewDifficultyDetail);
        textViewNameDetail = findViewById(R.id.textViewNameDetail);
        textViewHeadlineDetail = findViewById(R.id.textViewHeadlineDetail);
        textViewDescriptionDetail = findViewById(R.id.textViewDescriptionDetail);
        textViewCarbos = findViewById(R.id.textViewCarbos);
        textViewProteins = findViewById(R.id.textViewProteins);
        textViewFats = findViewById(R.id.textViewFats);
        textViewTime = findViewById(R.id.textViewTime);

    }
}