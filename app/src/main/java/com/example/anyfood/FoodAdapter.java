package com.example.anyfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anyfood.data.Food;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> arrFood;

    public FoodAdapter() {
        arrFood = new ArrayList<>();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = arrFood.get(position);

        int colorId; //переменная для хранения цвета
        int difficulty = food.getDifficulty(); //переменная сложности блюда
        switch (difficulty) {
            case 0:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_green_dark);
                break;
            case 1:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_green_light);
                break;
            case 2:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_orange_dark);
                break;
            case 3:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_red_dark);
                break;
            default:
                colorId = holder.itemView.getResources().getColor(android.R.color.darker_gray);
                break;
        }
        holder.textViewDifficulty.setBackgroundColor(colorId);

        //здесь устанавливаем значения для элементов макета food_item
        ImageView imageViewPreview = holder.imageViewPreview;
        Picasso.get().load(food.getImage()).into(imageViewPreview);

        //holder.textViewDifficulty.setInt(food.getDifficulty());
        holder.textViewCalories.setText(food.getCalories());
        holder.textViewName.setText(food.getName());
        holder.textViewHeadline.setText(food.getHeadline());
        holder.textViewCarbos.setText(food.getCarbos());
        holder.textViewProteins.setText(food.getProteins());
        holder.textViewFats.setText(food.getFats());
    }

    @Override
    public int getItemCount() {
        return arrFood.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {

        //элементы макета food_item
        private ImageView imageViewPreview;
        private TextView textViewDifficulty;
        private TextView textViewCalories;
        private TextView textViewName;
        private TextView textViewHeadline;
        private TextView textViewCarbos;
        private TextView textViewProteins;
        private TextView textViewFats;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPreview = itemView.findViewById(R.id.imageViewPreview);
            textViewDifficulty = itemView.findViewById(R.id.textViewDifficulty);
            textViewCalories = itemView.findViewById(R.id.textViewCalories);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewHeadline = itemView.findViewById(R.id.textViewHeadline);
            textViewCarbos = itemView.findViewById(R.id.textViewCarbos);
            textViewProteins = itemView.findViewById(R.id.textViewProteins);
            textViewFats = itemView.findViewById(R.id.textViewFats);
        }
    }

    public List<Food> getArrFood() {
        return arrFood;
    }

    public void setArrFood(List<Food> arrFood) {
        this.arrFood = arrFood;
        notifyDataSetChanged(); //оповещаем адаптер, что добавлены новые блюда
    }

    //метод, который добавляет элементы к существующему массиву
    public void addFood(List<Food> arrFood) {
        this.arrFood.addAll(arrFood);
        notifyDataSetChanged(); //оповещаем адаптер, что добавлены новые блюда
    }
}
