package com.example.anyfood.data;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainViewModal extends AndroidViewModel {

    private static FoodDatabase database; //объект БД
    private LiveData<List<Food>> food;

    public MainViewModal(@NonNull Application application) {
        super(application);
        database = FoodDatabase.getInstance(getApplication());
        food = database.foodDao().getAllFood();
    }

    public LiveData<List<Food>> getFood() {
        return food;
    }

    //метод для получения данных
    public Food getFoodById(int id) {
        try {
            return new GetFoodTask().execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //метод для удаления данных
    public void deleteAllFood() {
        new DeleteFoodTask().execute();
    }

    //метод для вставки данных
    public void insertFood(Food food) {
        new InsertFoodTask().execute(food);
    }

    //метод удаляет один элемент из базы
    public void deleteOneFood(Food food) {
        new DeleteOneFoodTask().execute(food);
    }

    //эти классы нужны, чтобы действия выполнялись в другом потоке
    private static class GetFoodTask extends AsyncTask<Integer, Void, Food> {

        @Override
        protected Food doInBackground(Integer... integers) {
            if (integers != null && integers.length > 0) {
                return database.foodDao().getFoodById(integers[0]);
            }
            return null;
        }
    }

    private static class DeleteFoodTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... integers) {
            database.foodDao().deleteAllFood();
            return null;
        }
    }

    private static class InsertFoodTask extends AsyncTask<Food, Void, Void> {

        @Override
        protected Void doInBackground(Food... foods) {
            if (foods != null && foods.length > 0) {
                database.foodDao().insertFood(foods[0]);
            }
            return null;
        }
    }

    private static class DeleteOneFoodTask extends AsyncTask<Food, Void, Void> {

        @Override
        protected Void doInBackground(Food... foods) {
            if (foods != null && foods.length > 0) {
                database.foodDao().deleteOneFood(foods[0]);
            }
            return null;
        }
    }
}
