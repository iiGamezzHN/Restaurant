package com.example.davidarisz.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        ImageView image = findViewById(R.id.detailFood);
        Picasso.get().load(item.getImgUrl()).into(image);

        TextView price = findViewById(R.id.detailPrice);
        String pricing = "€" + String.valueOf(item.getPrice());
        price.setText(pricing);
    }
}
