package com.example.anyfood.data;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/** Данный класс описывает еду. */

public class Food {

    private String id;
    private int difficulty; //уровень сложности приготовления блюда
    private String name; //название блюда
    private String headline; //подстрочник к названию
    private String description; //описание блюда
    private String image; //путь к превью-картинке блюда
    private String thumb; //путь к большой картинке блюда
    private String calories;
    private String carbos; //углеводы
    private String fats; //жиры
    private String proteins; //белки
    private String time;

    public Food(String id, int difficulty, String name, String headline, String description, String image, String thumb, String calories, String carbos, String fats, String proteins, String time) {
        this.id = id;
        this.difficulty = difficulty;
        this.name = name;
        this.headline = headline;
        this.description = description;
        this.image = image;
        this.thumb = thumb;
        this.calories = calories;
        this.carbos = carbos;
        this.fats = fats;
        this.proteins = proteins;
        this.time = time;
    }


    //геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbos() {
        return carbos;
    }

    public void setCarbos(String carbos) {
        this.carbos = carbos;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
