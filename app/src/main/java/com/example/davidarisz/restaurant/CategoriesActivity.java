package com.example.davidarisz.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback{
    @Override
    public void gotCategories(ArrayList<String> categories) {

    }

    @Override
    public void gotCategoriesError(String message) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }
}
