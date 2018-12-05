package com.example.davidarisz.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback{
    public static String pickedCategory;
    ArrayList<MenuItem> menu_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        pickedCategory = (String) getIntent().getSerializableExtra("category_name");
        Log.d("menu_name", pickedCategory);

        MenuRequest x = new MenuRequest(this);
        x.getMenus(this);
//        listView.setOnItemClickListener(new GridItemClickListener());
    }

    @Override
    public void gotMenus(final ArrayList<MenuItem> menus) {
        menu_items = menus;
        Log.d("asdf", menus.toString());

        MenuAdapter adapter = new MenuAdapter(this, R.layout.menu_items, menu_items);

        ListView listView = findViewById(R.id.menu_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(MenuActivity.this, DetailActivity.class);
                intent.putExtra("menu_item",  menu_items.get(position));
                startActivity(intent);
            }
        });

    }

    @Override
    public void gotMenusError(String message) {

    }
}
