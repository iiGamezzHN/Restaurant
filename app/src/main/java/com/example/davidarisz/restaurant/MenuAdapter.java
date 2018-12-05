package com.example.davidarisz.restaurant;

import android.content.Context;
import android.support.annotation.NonNull;
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

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_items, parent, false);
        }

        MenuItem item = getItem(position);

        TextView name = convertView.findViewById(R.id.menu_item_name);
        name.setText(item.getName());

        TextView price = convertView.findViewById(R.id.menu_item_price);
        String pricing = "€" + String.valueOf(item.getPrice());
        price.setText(pricing);

        ImageView img = convertView.findViewById(R.id.menu_item_img);
        Picasso.get().load(item.getImgUrl()).into(img);

        return convertView;
    }
}
