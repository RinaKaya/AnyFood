package com.example.anyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.CompoundButton;

import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anyfood.data.Food;
import com.example.anyfood.utils.JSONUtils;
import com.example.anyfood.utils.NetworkUtils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Switch switchSort;
    private TextView textViewSimply;
    private TextView textViewHard;

    private RecyclerView recyclerViewItemsFood;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodAdapter = new FoodAdapter();

        JSONArray jsonArray = NetworkUtils.getJSONFromNetwork();
        ArrayList<Food> arrFood = JSONUtils.getArrFoodFromJSON(jsonArray);

        switchSort = findViewById(R.id.switchSort);
        textViewSimply = findViewById(R.id.textViewSimply);
        textViewHard = findViewById(R.id.textViewHard);

        recyclerViewItemsFood = findViewById(R.id.recyclerViewItemsFood);
        recyclerViewItemsFood.setLayoutManager(new LinearLayoutManager(this));
        foodAdapter.setArrFood(arrFood);

        recyclerViewItemsFood.setAdapter(foodAdapter); //устанавливаем адаптер у RecyclerView

        switchSort.setChecked(true);
        //слушатель для свича
        switchSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                setMethodOfSort(isChecked);
            }
        });

        switchSort.setChecked(false);

        foodAdapter.setOnCardViewClickListener(new FoodAdapter.OnCardViewClickListener() {
            @Override
            public void onCardViewClick(int position) {

                Food food = foodAdapter.getArrFood().get(position);
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                intent.putExtra("image", food.getImage());
                intent.putExtra("calories", food.getCalories());
                intent.putExtra("difficulty", food.getDifficulty());
                intent.putExtra("name", food.getName());
                intent.putExtra("headline", food.getHeadline());
                intent.putExtra("description", food.getDescription());
                intent.putExtra("carbos", food.getCarbos());
                intent.putExtra("proteins", food.getProteins());
                intent.putExtra("fats", food.getFats());
                intent.putExtra("time", food.getTime());
                startActivity(intent);

            }
        });
    }

    public void onClickSetSimple(View view) {
        setMethodOfSort(false);
        switchSort.setChecked(false);
    }

    public void onClickSetHard(View view) {
        setMethodOfSort(true);
        switchSort.setChecked(true);
    }

    private void setMethodOfSort(boolean isHard) {
        if (isHard) {
            textViewHard.setTextColor(getResources().getColor(R.color.red_pink));
            textViewSimply.setTextColor(getResources().getColor(R.color.black));
            Toast.makeText(MainActivity.this, "Свич включен", Toast.LENGTH_SHORT).show();
        } else {
            textViewSimply.setTextColor(getResources().getColor(R.color.red_pink));
            textViewHard.setTextColor(getResources().getColor(R.color.black));
            Toast.makeText(MainActivity.this, "Свич выкл", Toast.LENGTH_SHORT).show();
        }
    }
}