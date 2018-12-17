package com.example.davidarisz.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    /**
     * Retrieves the selected dish and sets al the views for the selected dish
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final MenuItem item = (MenuItem) getIntent().getSerializableExtra("menu_item");

        TextView name = findViewById(R.id.detailTitle);
        name.setText(item.getName());

        TextView tvDescription = findViewById(R.id.detailDescription);
        String description = "<b>Description:</b> " + item.getDescription(); // Custom description string with bold word
        tvDescription.setText(Html.fromHtml(description)); // Allow html for bold word

        ImageView image = findViewById(R.id.detailFood);
        if (item.getImgUrl().equals("https://resto.mprog.nl/images/chickensoup.jpg")) { // This url has no image
            String url = "https://www.tasteofhome.com/wp-content/uploads/2018/04/exps192832_TH163619D09_30_2b-696x696.jpg";
            Picasso.get()
                    .load(url)
                    .into(image); // Set the image to the ImageView
        } else {
            Picasso.get().load(item.getImgUrl()).into(image); // Set the image to the ImageView
        }

        TextView price = findViewById(R.id.detailPrice);
        String pricing = "<b>Price:</b> This dish is €" + String.valueOf(item.getPrice()); // Custom price string with bold word
        price.setText(Html.fromHtml(pricing)); // Allow html for bold word
    }
}
