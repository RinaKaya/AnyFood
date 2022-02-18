package com.example.anyfood.utils;

import com.example.anyfood.data.Food;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/** В этом классе преобразовываем JSON в объект. */

public class JSONUtils {

    private static final String KEY = "key";

    private static final String KEY_ID = "id";
    private static final String KEY_DIFFICULTY = "difficulty"; //уровень сложности приготовления блюда
    private static final String KEY_NAME = "name"; //название блюда
    private static final String KEY_HEADLINE = "headline"; //подстрочник к названию
    private static final String KEY_DESCRIPTION = "description"; //описание блюда - для детальной
    private static final String KEY_IMAGE = "image"; //путь к превью-картинке блюда
    private static final String KEY_THUMB = "thumb"; //путь к большой картинке блюда - для детальной
    private static final String KEY_CALORIES = "calories";
    private static final String KEY_CARBOS = "carbos"; //углеводы
    private static final String KEY_FATS = "fats"; //жиры
    private static final String KEY_PROTEINS = "proteins"; //белки
    private static final String KEY_TIME = "time";

    //сделав запрос к БД, мы должны получить массив с фильмами
    public static ArrayList<Food> getArrFoodFromJSON(JSONArray jsonArray) {
        ArrayList<Food> result = new ArrayList<>();
        if (jsonArray == null) {
            return result;
        }

        try {
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject objectFood = jsonArray.getJSONObject(i);

                String id = objectFood.getString(KEY_ID);
                int difficulty = objectFood.getInt(KEY_DIFFICULTY);
                String name = objectFood.getString(KEY_NAME);
                String headline = objectFood.getString(KEY_HEADLINE);
                String description = objectFood.getString(KEY_DESCRIPTION);
                String image = objectFood.getString(KEY_IMAGE);
                String thumb = objectFood.getString(KEY_THUMB);
                String calories = objectFood.getString(KEY_CALORIES);
                String carbos = objectFood.getString(KEY_CARBOS);
                String fats = objectFood.getString(KEY_FATS);
                String proteins = objectFood.getString(KEY_PROTEINS);
                String time = objectFood.getString(KEY_TIME);

                Food food = new Food(id, difficulty, name, headline, description, image, thumb, calories, carbos, fats, proteins, time);
                result.add(food);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

}
