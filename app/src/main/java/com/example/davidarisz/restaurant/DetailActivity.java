package com.example.davidarisz.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final MenuItem item = (MenuItem) getIntent().getSerializableExtra("menu_item");

        TextView name = findViewById(R.id.detailTitle);
        name.setText(item.getName());

        TextView description = findViewById(R.id.detailDescription);
        description.setText(item.getDescription());

        TextView price = findViewById(R.id.detailPrice);
        price.setText(item.getPrice());
    }
}
