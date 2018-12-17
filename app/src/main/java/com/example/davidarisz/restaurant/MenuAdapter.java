package com.example.davidarisz.restaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private ArrayList<MenuItem> items;

    public MenuAdapter(Context context, int resource, ArrayList<MenuItem> items) {
        super(context, resource, items);
        this.items = items;
    }

    /**
     * Creates the ListViews for all the different dishes in the menu for each category
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_items, parent, false);
        }

        MenuItem item = getItem(position); // Select the dish

        TextView name = convertView.findViewById(R.id.menu_item_name);
        name.setText(item.getName()); // Set the name to a TextView

        TextView price = convertView.findViewById(R.id.menu_item_price);
        String pricing = "€" + String.valueOf(item.getPrice()); // Add a € to the string
        price.setText(pricing); // Set the price to a TextView

        ImageView img = convertView.findViewById(R.id.menu_item_img);

        if (item.getImgUrl().equals("https://resto.mprog.nl/images/chickensoup.jpg")) { // This url had no picture
            String url = "https://www.tasteofhome.com/wp-content/uploads/2018/04/exps192832_TH163619D09_30_2b-696x696.jpg";
            Picasso.get()
                    .load(url)
                    .resize(100, 100) // Resize the pictures to a square
                    .into(img); // Set the image to the ImageView
        } else {
            Picasso.get()
                    .load(item.getImgUrl())
                    .resize(100, 100) // Resize the pictures to a square
                    .into(img); // Set the image to the ImageView
        }

        return convertView;
    }
}
