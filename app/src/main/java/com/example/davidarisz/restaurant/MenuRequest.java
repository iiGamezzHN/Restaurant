package com.example.davidarisz.restaurant;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    Context context;
    Callback activity;

    public interface Callback {
        void gotMenus(ArrayList<MenuItem> menus);
        void gotMenusError(String message);
    }

    public MenuRequest(Context con) {
        context = con;
    }

    public void getMenus(Callback activity) {
        String url = "https://resto.mprog.nl/menu";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

        this.activity = activity;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (error.getMessage() == null)
            Toast.makeText(context, "Timeout error :(", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Timeout error :(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        String pickCategory = MenuActivity.pickedCategory;

        Log.d("responses", pickCategory);
        JSONArray values;
        ArrayList<MenuItem> arrayList = new ArrayList();

        try {
            JSONArray menItems = response.getJSONArray("items");

            for (int i = 0; i < menItems.length(); i++) {
                JSONObject skillObject = menItems.getJSONObject(i);
                String category = skillObject.getString("category");
                String description = skillObject.getString("description");
                int price = skillObject.getInt("price");
                String img = skillObject.getString("image_url");
                int id = skillObject.getInt("id");
                String name = skillObject.getString("name");
                Log.d("categories15", category);

                if (category == pickCategory) {
                    MenuItem menu = new MenuItem(name, description, img, price, category);
                    arrayList.add(menu);
                }
            }

            activity.gotMenus(arrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
