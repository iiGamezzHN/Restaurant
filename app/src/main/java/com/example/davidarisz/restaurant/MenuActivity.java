package com.example.davidarisz.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuRequest.Callback {
    public static String pickedCategory;
    private ArrayList<MenuItem> menu_items;

    /**
     * retrieves the picked category and saves it in a string
     * also makes a request to get all the dishes for the selected category
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pickedCategory = (String) getIntent().getSerializableExtra("category_name");

        MenuRequest x = new MenuRequest(this);
        x.getMenus(this);
    }

    /**
     * puts an ArrayList of MenuItems into an adapter
     * sets the adapter to the ListView to display the dishes
     * sets a ClickListener to the adapter so check if a dish is clicked
     *
     * @param menus an ArrayList with MenuItem objects
     */
    @Override
    public void gotMenus(final ArrayList<MenuItem> menus) {
        menu_items = menus;

        MenuAdapter adapter = new MenuAdapter(this, R.layout.menu_items, menu_items);

        ListView listView = findViewById(R.id.menu_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Sends you to the DetailActivity for the clicked dish
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this, DetailActivity.class);
                intent.putExtra("menu_item", menu_items.get(position));
                startActivity(intent);
            }
        });
    }

    // Catches errors
    @Override
    public void gotMenusError(String message) {
        // Do nothing
    }
}
