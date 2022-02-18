package com.example.anyfood.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface FoodDao {

    @Query("SELECT * FROM food")
    LiveData<List<Food>> getAllFood();

    //метод возвращает блюдо по id
    @Query("SELECT * FROM food WHERE id == :foodId")
    Food getFoodById(int foodId);

    //метод удаляет все данные из таблицы
    @Query("DELETE FROM food")
    void deleteAllFood();

    //метод вставляет данные в таблицу
    @Insert
    void insertFood(Food food);

    //метод удаляет один элемент
    @Delete
    void deleteOneFood(Food food);

}
