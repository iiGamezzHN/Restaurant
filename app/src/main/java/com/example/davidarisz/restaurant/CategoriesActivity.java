package com.example.davidarisz.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {
    /**
     * makes a request to get the categories of a restaurant
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
    }

    /**
     * has a simple adapter to convert the 2 categories into a ListView
     *
     * @param categories is an ArrayList with all the categories that were sent with the request
     */
    @Override
    public void gotCategories(final ArrayList<String> categories) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, categories);
        ListView listView = findViewById(R.id.categories_listView);
        listView.setAdapter(adapter);

        // Sends you to the MenuActivity for the category that you clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
                intent.putExtra("category_name", itemValue); // Serializes category name to retrieve it later
                startActivity(intent);
            }
        });
    }

    // Shows a pop-up message when an error occurs
    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
