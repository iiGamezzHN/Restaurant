package com.example.davidarisz.restaurant;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    Context context;
    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }

    public CategoriesRequest(Context con) {
        context = con;
    }

    public void getCategories(Callback activity) {
        Callback callback = activity;
        String url = "https://resto.mprog.nl/";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray values;
        ArrayList arrayList = new ArrayList();

        try {
            values = response.getJSONArray("categories");

            for (int i = 0; i < values.length(); i++) {
                JSONObject categories = values.getJSONObject(i);
                arrayList.add(categories.getString("categories"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
