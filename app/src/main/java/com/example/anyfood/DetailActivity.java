package com.example.anyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anyfood.data.Food;
import com.squareup.picasso.Picasso;

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

        //получаем информацию из интента
        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            String imageDetail = intent.getStringExtra("image");
            String caloriesDetail = intent.getStringExtra("calories");
            String difficultyDetail = intent.getStringExtra("difficulty");
            String nameDetail = intent.getStringExtra("name");
            String headlineDetail = intent.getStringExtra("headline");
            String descriptionDetail = intent.getStringExtra("description");
            String carbos = intent.getStringExtra("carbos");
            String proteins = intent.getStringExtra("proteins");
            String fats = intent.getStringExtra("fats");
            String time = intent.getStringExtra("time");

            Picasso.get().load(imageDetail).placeholder(R.drawable.plate).into(imageViewThumbDetail);
            textViewCaloriesDetail.setText(caloriesDetail);
            textViewDifficultyDetail.setText(difficultyDetail);
            textViewNameDetail.setText(nameDetail);
            textViewHeadlineDetail.setText(headlineDetail);
            textViewDescriptionDetail.setText(descriptionDetail);
            textViewCarbos.setText(carbos);
            textViewProteins.setText(proteins);
            textViewFats.setText(fats);
            textViewTime.setText(time);

        } else {
            finish();
        }
    }
}