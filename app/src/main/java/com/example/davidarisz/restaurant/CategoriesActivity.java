package com.example.davidarisz.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotCategories(final ArrayList<String> categories) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, categories);
        ListView listView = findViewById(R.id.categories_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // ListView Clicked item index
////                int itemPosition     = position;
////                // ListView Clicked item value
                String itemValue = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
                intent.putExtra("category_name", itemValue);
                startActivity(intent);
            }
        });
    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
