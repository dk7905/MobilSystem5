package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textViev2;
    private View viev;
    private View viev2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textViev2 = findViewById(R.id.textView2);
        viev = findViewById(R.id.view);
        viev2 = findViewById(R.id.view2);

        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.age = 9;
        murzik.color = Color.BLACK;

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        viev.setBackgroundColor(murzik.color);//цвет кота
        textView.setText(String.valueOf(gson.toJson(murzik)));//вывод кота в textviev

        String jsonText = textView.getText().toString();

        murzik = gson.fromJson(jsonText, Cat.class);
        murzik.name = "Барсик";
        murzik.age = 11;
        murzik.color = Color.GRAY;

        viev2.setBackgroundColor(murzik.color);//цвет кота
        textViev2.setText(String.valueOf("Имя: " + murzik.name + "\nВозраст: " + murzik.age + "\nЦвет: " + murzik.color));//вывод кота в textviev
    }
}