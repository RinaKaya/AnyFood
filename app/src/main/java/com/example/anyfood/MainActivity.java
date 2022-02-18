package com.example.anyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.anyfood.data.Food;
import com.example.anyfood.data.MainViewModal;
import com.example.anyfood.utils.JSONUtils;
import com.example.anyfood.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModal viewModel;

    private Switch switchSort;
    private RecyclerView recyclerViewItemsFood;
    private FoodAdapter foodAdapter;

    //private boolean isMethodOfSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadData();
        viewModel = ViewModelProviders.of(this).get(MainViewModal.class);
        //viewModel = ViewModelProviders.of(this).get(MainViewModal.class);

        foodAdapter = new FoodAdapter();

        switchSort = findViewById(R.id.switchSort);
        //switchSort.setChecked(true);
        recyclerViewItemsFood = findViewById(R.id.recyclerViewItemsFood);
        recyclerViewItemsFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewItemsFood.setAdapter(foodAdapter); //устанавливаем адаптер у RecyclerView


        //слушатель для свича
        /*switchSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    isMethodOfSort = true;
                } else {
                    isMethodOfSort = false;
                }
            }
        });*/
        LiveData<List<Food>> foodFromLiveData = viewModel.getFood();

        //добавляем наблюдателя
        //всякий раз, когда данные в БД будут меняться - мы будем их устанавливать у адаптера
        foodFromLiveData.observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                foodAdapter.setArrFood(foods);
            }
        });


        //switchSort.setChecked(false);
        

        //2. тестируем метод getMoviesFromJSON() из класса JSONUtils
        /*JSONArray jsonArray = NetworkUtils.getJSONFromNetwork();
        ArrayList<Food> arrFood = JSONUtils.getArrFoodFromJSON(jsonArray);
        StringBuilder builder = new StringBuilder();
        for (Food food : arrFood) {
            builder.append(food.getName()).append("\n");
        }
        Log.i("MyResult", builder.toString());*/

        //1. тестируем работу метода getJSONFromNetwork() из класса NetworkUtils
        /*JSONArray jsonArray = NetworkUtils.getJSONFromNetwork();
        if (jsonArray == null) {
            Toast.makeText(this, "Произошла ошибка!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Успешно!", Toast.LENGTH_SHORT).show();
        }*/
    }

    //метод для загрузки данных
    private void downloadData() {
        JSONArray jsonArray = NetworkUtils.getJSONFromNetwork();
        ArrayList<Food> arrFood = JSONUtils.getArrFoodFromJSON(jsonArray); //получаем список блюд
        if (arrFood != null && !arrFood.isEmpty()) {
            viewModel.deleteAllFood(); //очищаем старые данные
            for (Food food : arrFood) { //в цикле вставляем новые данные
                viewModel.insertFood(food);
            }
        }
    }

}